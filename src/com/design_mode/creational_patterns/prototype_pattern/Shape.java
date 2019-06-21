package com.design_mode.creational_patterns.prototype_pattern;

/**
 * @author: XueYing.Cao
 * @date: 2019/6/21
 * @description:
 */
public abstract class Shape implements Cloneable {
    private String id;
    protected String type;

    public abstract void draw();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    @Override
    public Object clone() {
        Object clone = null;
        try {
            clone = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }
}
