package org.occul.gold_silver.core.Info;

import net.minecraft.tags.TagKey;

import java.util.ArrayList;
import java.util.Collections;

public class ModTagElementInfo<T> extends ModElementInfo {

    private ArrayList<TagKey<T>> tagKeys = new ArrayList<>();

    public ModTagElementInfo<T> addTags(TagKey<T>... tags){
        Collections.addAll(tagKeys,tags);
        return this;
    }

    public ArrayList<TagKey<T>> getTagKeys() { return tagKeys; }
}
