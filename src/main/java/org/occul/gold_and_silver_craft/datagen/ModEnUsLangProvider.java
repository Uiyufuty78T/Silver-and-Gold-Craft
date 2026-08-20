package org.occul.gold_and_silver_craft.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.LanguageProvider;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.occul.gold_and_silver_craft.GoldAndSilverCraft;
import org.occul.gold_and_silver_craft.core.ModInfRegistry;
import org.occul.gold_and_silver_craft.core.ModularBlock;
import org.occul.gold_and_silver_craft.core.ModularItem;
import org.occul.gold_and_silver_craft.register.ModBlocks;
import org.occul.gold_and_silver_craft.register.ModItems;

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

        add("itemGroup.gold_and_silver_craft","Gold & Silver Craft");
    }
}
