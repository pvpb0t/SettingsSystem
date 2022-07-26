package me.pvpb0t.callisto.api.option.options;

import me.pvpb0t.callisto.api.module.Module;
import me.pvpb0t.callisto.api.option.Option;
/**
 * @Author pvpb0t
 * @Since 7/20/2022
 */
public class StringOption extends Option<String> {

    public StringOption(String name, String exact, Module module) {
        super(name, exact, module);
    }

    public StringOption(String name, String exact, Module module, Boolean shown) {
        super(name, exact, module, shown);
    }
}
