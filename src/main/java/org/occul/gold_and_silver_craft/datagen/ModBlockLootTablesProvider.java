package org.occul.gold_and_silver_craft.datagen;

import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.occul.gold_and_silver_craft.core.ModInfRegistry;
import org.occul.gold_and_silver_craft.core.ModularBlock;
import org.occul.gold_and_silver_craft.register.ModBlocks;
import org.occul.gold_and_silver_craft.register.ModItems;

import java.util.Set;

public class ModBlockLootTablesProvider extends BlockLootSubProvider {

    public ModBlockLootTablesProvider() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        for(ResourceLocation id: ModInfRegistry.getBlockId()){
            Block block = ForgeRegistries.BLOCKS.getValue(id);
            if (block == null) continue;
            switch (ModInfRegistry.getBlockInf(block).getBlockLootTable()) {
                case DROP_SELF -> dropSelf(block);
                //case ORE -> createOreDrop(block, ModItems.RAW_SILVER.get());
            }
        }

        add(ModBlocks.SILVER_ORE.get(),(block) -> createOreDrop(ModBlocks.SILVER_ORE.get(), ModItems.RAW_SILVER.get()));
        add(ModBlocks.DEEPSLATE_SILVER_ORE.get(),(block) -> createOreDrop(ModBlocks.DEEPSLATE_SILVER_ORE.get(), ModItems.RAW_SILVER.get()));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
