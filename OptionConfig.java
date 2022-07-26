package me.pvpb0t.callisto.api.option;

import com.google.common.collect.Multimap;
import me.pvpb0t.callisto.Callisto;
import me.pvpb0t.callisto.api.friend.FriendObj;
import me.pvpb0t.callisto.api.module.Module;
import me.pvpb0t.callisto.api.module.ModuleManager;
import me.pvpb0t.callisto.api.option.options.*;
import me.pvpb0t.callisto.api.setting.SettingManager;
import me.pvpb0t.callisto.api.util.JsonUtil;
import me.pvpb0t.callisto.api.util.logger.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.Locale;

/**
 * @Author pvpb0t
 * @Since 7/20/2022
 */
public class OptionConfig extends Thread{

    private static Multimap<Module, Option> options = OptionManager.getOptions();
    private static String path = Callisto.mainFolder + File.separator +  "Config";

    public void saveOptionConfig(){
        File mkdirpath = new File(path);
        if(mkdirpath.mkdir()){
        }
        Logger.getLogger().print("Saving Configs");

        for(Module m : ModuleManager.INSTANCE.getModules()){
            String filepath =path + File.separator + m.getCategory().toString().toLowerCase(Locale.ROOT)+ File.separator+m.getName() + ".cllst";
            File filez = new File(filepath);
            filez.getParentFile().mkdirs();
            try{
                JSONArray arrayz = new JSONArray();
                JSONObject isEnabled = new JSONObject();

                isEnabled.put("Toggled", m.isEnabled());
                arrayz.add(isEnabled);

                if(options.keySet().contains(m)) {
                    for (Option op : OptionManager.getOptions(m)) {
                        JSONObject jsonObject = new JSONObject();
                        jsonObject.put("Exact", op.getExact());
                        jsonObject.put("Name", op.getName());
                        arrayz.add(jsonObject);


                    }
                }


                FileWriter file = new FileWriter(filepath);
                file.write(JsonUtil.prettyPrintJSON(arrayz.toJSONString()));
                file.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }



    public static void loadOptionConfig(){
        File mkdirpath = new File(path);
        if(mkdirpath.mkdir()){
        }
        Logger.getLogger().print("Loading Configs");

        JSONParser parser = new JSONParser();
        for(Module m : ModuleManager.INSTANCE.getModules()){
            String filepath =path + File.separator + m.getCategory().toString().toLowerCase(Locale.ROOT)+ File.separator+m.getName() + ".cllst";
            if(new File(filepath).exists()) {
                JSONParser jsonParser = new JSONParser();
                try (FileReader reader = new FileReader(filepath))
                {
                    Object obj = jsonParser.parse(reader);
                   JSONArray array = (JSONArray) obj;
                    for(Object ob: array){
                        JSONObject object = (JSONObject) ob;
                        String name = (String) object.get("Name");
                        if(object.get("Exact") != null && name != null){
                            for(Option option : OptionManager.getOptions(m)){
                                if(option.getName().equals(name)){
                                    option.setExact(object.get("Exact"));
                                }
                            }
                        }


                    }

                } catch (FileNotFoundException e) {
                    System.err.println("ERROR : FILE NOT FOUND.");
                } catch (IOException | ParseException e) {
                    throw new RuntimeException(e);
                }
            }else {
                try{
                    Thread thread = new OptionConfig();
                    thread.start();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }

    }

    @Override
    public void run() {
        saveOptionConfig();
    }
}
