package com.poly.lab5.model;

import java.util.*;

public class DB {
    public static Map<Integer, Item> items = new HashMap<>();

    static {
        items.put(1, new Item(1, "Xiaome", 10.0, 0));
        items.put(2, new Item(2, "SamSung", 20.5, 0));
        items.put(3, new Item(3, "iPhone 20", 90.49, 0));
        items.put(4, new Item(4, "Motorola", 15.55, 0));
        items.put(5, new Item(5, "Oppo", 12.99, 0));
    }
}
