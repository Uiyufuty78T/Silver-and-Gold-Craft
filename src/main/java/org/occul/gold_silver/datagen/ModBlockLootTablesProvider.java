package org.occul.gold_silver.datagen;

import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.occul.gold_silver.core.Info.ModBlockInfo;
import org.occul.gold_silver.core.Info.ModElementInfoRegistry;
import org.occul.gold_silver.register.ModBlocks;
import org.occul.gold_silver.register.ModItems;

import java.util.Set;

public class ModBlockLootTablesProvider extends BlockLootSubProvider {

    public ModBlockLootTablesProvider() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        for(ResourceLocation id: ModElementInfoRegistry.getId()){
            Block block = ForgeRegistries.BLOCKS.getValue(id);
            if(block == null) continue;
            if (!(ModElementInfoRegistry.getInfo(id) instanceof ModBlockInfo info)) continue;
            switch (info.getBlockLootTable()) {
                case DROP_SELF -> dropSelf(block);
                case DROP_SLAB -> dropSlab(block);
                case DROP_DOOR -> dropDoor(block);

                //case ORE -> createOreDrop(block, ModItems.RAW_SILVER.get());
            }
        }

        add(ModBlocks.SILVER_ORE.get(),(block) -> createOreDrop(ModBlocks.SILVER_ORE.get(), ModItems.RAW_SILVER.get()));
        add(ModBlocks.DEEPSLATE_SILVER_ORE.get(),(block) -> createOreDrop(ModBlocks.DEEPSLATE_SILVER_ORE.get(), ModItems.RAW_SILVER.get()));
    }
    private void dropSlab(Block slab){
        add(slab, block -> createSlabItemTable(slab));
    }
    private void dropDoor(Block door){
        add(door, block -> createDoorTable(door));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
