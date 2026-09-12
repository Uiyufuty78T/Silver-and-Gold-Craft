package org.occul.gold_silver.core.Info;

import net.minecraft.resources.ResourceLocation;

public class ModElementInfo {
    private LangString name;
    private ResourceLocation location;

    public static ModElementInfo create(){
        return new ModElementInfo();
    }
    public <T extends ModElementInfo> T setName(LangString name){
        this.name = name;
        return (T) this;
    }
    public ModElementInfo setLocation(ResourceLocation location){
        this.location = location;
        return this;
    }
    public LangString getName(){
        return name;
    }
    public ResourceLocation getLocation(){
        return location;
    }
    public ModElementInfo build(){
        ModElementInfoRegistry.register(location,this);
        return this;
    }
}
