package me.pvpb0t.callisto.api.option.options;

import me.pvpb0t.callisto.api.module.Module;
import me.pvpb0t.callisto.api.option.Option;
/**
 * @Author pvpb0t
 * @Since 7/20/2022
 */
public class FloatOption extends Option<Float> {

    private Float min, max;

    public FloatOption(String name, Float exact, Float min, Float max, Module module) {
        super(name, exact, module);
        this.min = min;
        this.max = max;
    }

    public FloatOption(String name, Float exact, Float min, Float max, Module module, Boolean shown) {
        super(name, exact, module, shown);
        this.min = min;
        this.max = max;
    }

    public Float getMin() {
        return min;
    }

    public void setMin(Float min) {
        this.min = min;
    }

    public Float getMax() {
        return max;
    }

    public void setMax(Float max) {
        this.max = max;
    }
}
