package me.pvpb0t.callisto.api.option.options;

import me.pvpb0t.callisto.api.module.Module;
import me.pvpb0t.callisto.api.option.Option;
/**
 * @Author pvpb0t
 * @Since 7/20/2022
 */
public class DoubleOption extends Option<Double> {

    private Double min, max;

    public DoubleOption(String name, Double exact, Double min, Double max, Module module) {
        super(name, exact, module);
        this.min = min;
        this.max = max;
    }

    public DoubleOption(String name, Double exact, Double min, Double max, Module module, Boolean shown) {
        super(name, exact, module, shown);
        this.min = min;
        this.max = max;
    }

    public Double getMin() {
        return min;
    }


    public void setMin(Double min) {
        this.min = min;
    }

    public Double getMax() {
        return max;
    }

    public void setMax(Double max) {
        this.max = max;
    }
}
