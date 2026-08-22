package org.occul.gold_and_silver_craft.core;


import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TranslatableManager {
    public static final ArrayList<TranslateComponent> components = new ArrayList<>();
    public static MutableComponent add(TranslateComponent component){
        components.add(component);
        return Component.translatable(component.getRegisterName());

    }
}
