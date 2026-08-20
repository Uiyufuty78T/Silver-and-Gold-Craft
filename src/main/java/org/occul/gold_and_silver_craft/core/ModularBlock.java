package org.occul.gold_and_silver_craft.core;

import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import java.util.ArrayList;

public class ModularBlock extends Block {

    public ModularBlock(Properties pProperties) {
        super(pProperties);
    }

    private ArrayList<TagKey<Block>> tagKeys = new ArrayList<>();
    private boolean isBasicBlock = false;
    private boolean isDropSelf = false;
    private String enUsName;

    public boolean isDropSelf() {
        return isDropSelf;
    }

    public ModularBlock dropSelf() {
        isDropSelf = true;
        return this;
    }

    public ModularBlock addTags(TagKey<Block> tags){
        tagKeys.add(tags);
        return this;
    }

    public ArrayList<TagKey<Block>> getTagKeys() { return tagKeys; }
    public String getEnUsName() { return enUsName; }

    public boolean hasTags(){
        return !tagKeys.isEmpty();
    }

    public boolean isBasic(){
        return isBasicBlock;
    }
    public ModularBlock usingBasicModel(){
        isBasicBlock = true;
        return this;
    }
    public ModularBlock enUsLang(String name){
        enUsName = name;
        return this;
    }
}
