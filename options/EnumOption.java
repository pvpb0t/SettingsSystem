package me.pvpb0t.callisto.api.option.options;

import me.pvpb0t.callisto.api.module.Module;
import me.pvpb0t.callisto.api.option.Option;

import java.util.List;
/**
 * @Author pvpb0t
 * @Since 7/20/2022
 */
public class EnumOption extends Option<String> {

    private List<String> enums;

    public EnumOption(String name, String exact, List<String> list, Module module) {
        super(name, exact, module);
        this.enums = list;
    }

    public EnumOption(String name, String exact, Module module, List<String> list, Boolean shown) {
        super(name, exact, module, shown);
        this.enums = list;
    }

    public List<String> getEnums() {
        return enums;
    }

    public void setEnums(List<String> enums) {
        this.enums = enums;
    }
}
