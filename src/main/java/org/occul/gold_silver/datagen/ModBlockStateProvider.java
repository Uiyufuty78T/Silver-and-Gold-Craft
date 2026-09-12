package org.occul.gold_silver.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import org.occul.gold_silver.GoldSilver;
import org.occul.gold_silver.core.Info.ModBlockInfo;
import org.occul.gold_silver.core.Info.ModElementInfoRegistry;
import org.occul.gold_silver.utils.ItemUtils;


public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, GoldSilver.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        for(ResourceLocation id: ModElementInfoRegistry.getId()){
            Block block = ForgeRegistries.BLOCKS.getValue(id);
            if (block == null) continue;
            if (!(ModElementInfoRegistry.getInfo(id) instanceof ModBlockInfo info)) continue;
            switch (info.getBlockState()) {
                case SIMPLE -> simpleBlockWithItem(block,cubeAll(block));
                case STAIRS -> stairsBlockWithItem((StairBlock) block, info.getBaseBlock());
                case SLAB -> slabBlockWithItem((SlabBlock) block, info.getBaseBlock());
                case DOOR -> transparentDoor((DoorBlock) block);
                case TRAPDOOR -> transparentTrapdoorWithItem((TrapDoorBlock) block);
                case PRESSURE_PLATE -> pressurePlateBlockWithItem((PressurePlateBlock) block, info.getBaseBlock());
            }
        }
    }

    private void pressurePlateBlockWithItem(PressurePlateBlock block, Block modelBlock) {
        pressurePlateBlock(block, blockTexture(modelBlock));
        blockItem(block);
    }

    private void stairsBlockWithItem(StairBlock stairs, Block modelBlock) {
       stairsBlock(stairs, blockTexture(modelBlock));
       blockItem(stairs);
    }
    private void slabBlockWithItem(SlabBlock slab, Block modelBlock) {
        slabBlock(slab, blockTexture(modelBlock),blockTexture(modelBlock));
        blockItem(slab);
    }
    private void transparentDoor(DoorBlock door){
        String name = ItemUtils.getName(door);
        doorBlockWithRenderType(door, modLoc("block/" + name + "_bottom"), modLoc("block/" + name + "_top"),"cutout");
    }
    private void transparentTrapdoorWithItem(TrapDoorBlock trapdoor){
        String name = ItemUtils.getName(trapdoor);
        trapdoorBlockWithRenderType(trapdoor, modLoc("block/" + name), true,"cutout");
        blockItem(trapdoor,"_bottom");
    }

    private <T extends Block> void blockItem(T block){
        simpleBlockItem(block, new ModelFile.UncheckedModelFile(ItemUtils.getNamespace(block) + ":block/" + ItemUtils.getName(block)));
    }
    private <T extends Block> void blockItem(T block,String append){
        simpleBlockItem(block, new ModelFile.UncheckedModelFile(ItemUtils.getNamespace(block) + ":block/" + ItemUtils.getName(block) + append));
    }
}
