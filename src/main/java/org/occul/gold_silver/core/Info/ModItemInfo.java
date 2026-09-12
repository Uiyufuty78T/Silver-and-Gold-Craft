package org.occul.gold_silver.core.Info;

import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;


public class ModItemInfo extends ModTagElementInfo<Item> {
    private ItemModelState itemModelState = ItemModelState.BASIC;

    @Override
    @SafeVarargs
    public final ModItemInfo addTags(TagKey<Item>... tags) {
        super.addTags(tags);
        return this;
    }


    public enum ItemModelState {
        BASIC,HANDHELD,ARMOR,SPECIAL
    }

    public static ModItemInfo create(){
        return new ModItemInfo();
    }

    public ModItemInfo usingHandheld(){
        itemModelState = ItemModelState.HANDHELD;
        return this;
    }
    public ModItemInfo usingBasic(){
        itemModelState = ItemModelState.BASIC;
        return  this;
    }
    public ModItemInfo usingArmor(){
        itemModelState = ItemModelState.ARMOR;
        return this;
    }
    public ModItemInfo setModelState(ItemModelState modelState){
        itemModelState = modelState;
        return this;
    }
    public ItemModelState getModelState(){
        return itemModelState;
    }


}
