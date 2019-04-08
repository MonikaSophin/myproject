package com.thinkinginjava.enumerated_types.example.chapter19_2.ex19_2_1;

/**
 * @author: XueYing.Cao
 * @date: 2019/4/8
 * @description:
 */
public enum SpaceShip {
    SCOUT, CARGO, TRANSPORT, CRUISER, BATTLESHIP, MOTHERSHIP;

    @Override
    public String toString() {
        String id = name();
        String lower = id.substring(1).toLowerCase();
        return id.charAt(0) + lower;
    }

    public static void main(String[] args) {
        for (SpaceShip s : values()) {
            System.out.println(s);
        }
    }
}
/**output:
 * Scout
 * Cargo
 * Transport
 * Cruiser
 * Battleship
 * Mothership
 */