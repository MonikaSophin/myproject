package com.thinkinginjava.enumerated_types.example.chapter19_2;

/**
 * @author: XueYing.Cao
 * @date: 2019/4/8
 * @description:
 */
public enum OzWith {
    // Instances must be defined first, before methods:
    WEST("Miss Gulch, aka the Wicked Witch of the West"),
    NORTH("Glinda, the Good Witch of the North"),
    EAST("Wicked Witch of the East, wearer of the Ruby " +
            "Slippers, crushed by Dorothy's house"),
    SOUTH("Good by inference, but missing");
    
    private String description;
    
    OzWith(String description) {
        this.description = description;
    }
    
    public String getDescription() { return description; }

    public static void main(String[] args) {
        for (OzWith with : OzWith.values()) {
            System.out.println(with + ": " + with.getDescription());
        }
    }
}
/**output:
 * WEST: Miss Gulch, aka the Wicked Witch of the West
 * NORTH: Glinda, the Good Witch of the North
 * EAST: Wicked Witch of the East, wearer of the Ruby Slippers, crushed by Dorothy's house
 * SOUTH: Good by inference, but missing
 */