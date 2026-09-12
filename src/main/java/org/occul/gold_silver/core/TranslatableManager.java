package org.occul.gold_silver.core;


import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;

import java.util.ArrayList;

public class TranslatableManager {
    public static final ArrayList<TranslateComponent> components = new ArrayList<>();
    public static MutableComponent add(TranslateComponent component){
        components.add(component);
        return Component.translatable(component.getRegisterName());

    }
}
