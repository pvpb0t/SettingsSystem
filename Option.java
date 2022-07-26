package me.pvpb0t.callisto.api.option;

import me.pvpb0t.callisto.api.module.Module;

/**
 * @Author pvpb0t
 * @Since 7/12/2022
 * @param <T>
 */

public class Option<T> {



    private String Name;
    private T exact;
    private Module module;
    private Boolean shown;

    public Option(String name, T exact, Module module) {
        Name = name;
        this.exact = exact;
        this.module = module;
        OptionManager.addOption(this);
    }

    public Option(String name, T exact, Module module, Boolean shown) {
        Name = name;
        this.exact = exact;
        this.module = module;
        this.shown = shown;
        OptionManager.addOption(this);

    }



    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public T getExact() {
        return exact;
    }

    public void setExact(T type) {
        this.exact = type;
    }

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }

    public Boolean getShown() {
        return shown;
    }

    public void setShown(Boolean shown) {
        this.shown = shown;
    }





}
