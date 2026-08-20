package org.occul.gold_and_silver_craft.core;

import net.minecraft.world.item.Item;

import java.util.HashMap;
import java.util.Map;

// unused
public class ModItemInfRegistry {
    private static Map<String,ModItemInf> map = new HashMap<>();

    public static void register(Item item,ModItemInf inf){
        map.put(item.getDescriptionId(),inf);
    }

    public static ModItemInf get(Item item){
        return map.get(item.getDescriptionId());
    }

    public static boolean hasInf(Item item){
        return map.containsKey(item.getDescriptionId());
    }
}
