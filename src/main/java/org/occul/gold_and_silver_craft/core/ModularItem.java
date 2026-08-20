package org.occul.gold_and_silver_craft.core;

import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import org.occul.gold_and_silver_craft.datagen.ModEnUsLangProvider;
import org.occul.gold_and_silver_craft.datagen.ModItemTagsProvider;
import org.occul.gold_and_silver_craft.register.ModItems;

import java.util.ArrayList;

public class ModularItem extends Item {

    public ModularItem(Properties pProperties) {
        super(pProperties);
    }

    private ArrayList<TagKey<Item>> tagKeys = new ArrayList<>();
    private boolean isBasicItem = false;
    private String enUsName;

    public ModularItem addTags(TagKey<Item> tags){
        tagKeys.add(tags);
        return this;
    }

    public ArrayList<TagKey<Item>> getTagKeys() { return tagKeys; }
    public String getEnUsName() { return enUsName; }

    public boolean hasTags(){
        return !tagKeys.isEmpty();
    }

    public boolean isBasic(){
        return isBasicItem;
    }


    public ModularItem usingBasicModel(){
        isBasicItem = true;
        return this;
    }
    public ModularItem enUsLang(String name){
        enUsName = name;
        return this;
    }
}
