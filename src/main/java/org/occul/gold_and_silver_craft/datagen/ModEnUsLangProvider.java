package org.occul.gold_and_silver_craft.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.LanguageProvider;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.occul.gold_and_silver_craft.GoldAndSilverCraft;
import org.occul.gold_and_silver_craft.core.*;
import org.occul.gold_and_silver_craft.register.ModBlocks;
import org.occul.gold_and_silver_craft.register.ModItems;
import org.occul.gold_and_silver_craft.register.ModMobEffects;

import java.util.ResourceBundle;
import java.util.Set;

public class ModEnUsLangProvider extends LanguageProvider {

    public ModEnUsLangProvider(PackOutput output) {
        super(output, GoldAndSilverCraft.MODID,"en_us");
    }

    @Override
    protected void addTranslations() {
        for(ResourceLocation id:ModInfRegistry.getItemId()){
            Item item = ForgeRegistries.ITEMS.getValue(id);
            if(item == null) continue;
            String name = ModInfRegistry.getItemInf(id).getEnUsName();
            if(name != null) add(item,name);
        }
        for(ResourceLocation id:ModInfRegistry.getBlockId()){
            Block block = ForgeRegistries.BLOCKS.getValue(id);
            if (block == null) continue;
            String name = ModInfRegistry.getBlockInf(id).getEnUsName();
            if(name != null) add(block,name);
        }
        for(TranslateComponent component: TranslatableManager.components){
            String name = component.getEnUsName();
            if(name != null) add(component.getRegisterName(), name);
        }
        add(ModMobEffects.DIVINE_BLESSING.get(), "Divine Blessing");

        add("tooltip.press_shift","§7Press [§6Shift§7] for more info");
        add("tooltip.silver_armor_shift1","§7When wearing a full set of silver armor:");
        add("tooltip.silver_armor_shift2","§7 • - §b50% §7damage from undead mobs");
        add("tooltip.silver_armor_shift3","§7 • §7Grants §bHaste I");
        add("tooltip.silver_sword_shift1","§7When attacking undead mobs:");
        add("tooltip.silver_sword_shift2","§7 • + §b50% §7damage");
        add("tooltip.silver_sword_shift3","§7 • Grants §bStrength I 00:05");

        add("itemGroup.gold_and_silver_craft","Gold & Silver Craft");
    }
}
