package me.pvpb0t.callisto.api.option.options;

import me.pvpb0t.callisto.api.module.Module;
import me.pvpb0t.callisto.api.option.Option;
/**
 * @Author pvpb0t
 * @Since 7/20/2022
 */
public class IntegerOption extends Option<Integer> {

    private Integer min, max;

    public IntegerOption(String name, Integer exact, Integer min, Integer max, Module module) {
        super(name, exact, module);
        this.min = min;
        this.max = max;
    }

    public IntegerOption(String name, Integer exact, Integer min, Integer max, Module module, Boolean shown) {
        super(name, exact, module, shown);
        this.min = min;
        this.max = max;
    }

    public Integer getMin() {
        return min;
    }

    public void setMin(Integer min) {
        this.min = min;
    }

    public Integer getMax() {
        return max;
    }

    public void setMax(Integer max) {
        this.max = max;
    }
}
