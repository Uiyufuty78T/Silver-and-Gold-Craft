package org.occul.gold_silver.register;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.occul.gold_silver.GoldSilver;
import org.occul.gold_silver.core.Info.*;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, GoldSilver.MODID);

    public static final RegistryObject<Block> SILVER_BLOCK =
            registerBlock("silver_block",() -> new Block(BlockBehaviour.Properties
                    .copy(Blocks.GOLD_BLOCK).requiresCorrectToolForDrops()),
                    ModBlockInfo.create()
                            .addTags(BlockTags.MINEABLE_WITH_PICKAXE,BlockTags.NEEDS_IRON_TOOL)
                            .setName(new LangString("Silver Block", "银块"))
                        );

    public static final RegistryObject<Block> SILVER_ORE =
            registerBlock("silver_ore",() -> new Block(BlockBehaviour.Properties
                    .copy(Blocks.GOLD_ORE).requiresCorrectToolForDrops()),
                    ModBlockInfo.create()
                            .addTags(BlockTags.MINEABLE_WITH_PICKAXE,BlockTags.NEEDS_IRON_TOOL)
                            .setName(new LangString("Silver Ore", "银矿石"))
                        );

    public static final RegistryObject<Block> DEEPSLATE_SILVER_ORE =
            registerBlock("deepslate_silver_ore",() -> new Block(BlockBehaviour.Properties
                    .copy(Blocks.DEEPSLATE_GOLD_ORE).requiresCorrectToolForDrops()),
                    ModBlockInfo.create()
                            .addTags(BlockTags.MINEABLE_WITH_PICKAXE,BlockTags.NEEDS_IRON_TOOL)
                            .setName(new LangString("Deepslate Silver Ore", "深层银矿石"))
                        );

    public static final RegistryObject<Block> RAW_SILVER_BLOCK =
            registerBlock("raw_silver_block",() -> new Block(BlockBehaviour.Properties
                    .copy(Blocks.RAW_GOLD_BLOCK).requiresCorrectToolForDrops()),
                    ModBlockInfo.create()
                            .addTags(BlockTags.MINEABLE_WITH_PICKAXE,BlockTags.NEEDS_IRON_TOOL)
                            .setName(new LangString("Raw Silver Block", "粗银块"))
                        );

    public static final RegistryObject<Block> CUT_SILVER =
            registerBlock("cut_silver",() -> new Block(BlockBehaviour.Properties
                    .copy(Blocks.GOLD_BLOCK).requiresCorrectToolForDrops()),
                    ModBlockInfo.create()
                            .addTags(BlockTags.MINEABLE_WITH_PICKAXE,BlockTags.NEEDS_IRON_TOOL)
                            .setName(new LangString("Cut Silver", "切制银块"))
                        );

    public static final RegistryObject<Block> CHISELED_SILVER =
            registerBlock("chiseled_silver",() -> new Block(BlockBehaviour.Properties
                            .copy(Blocks.GOLD_BLOCK).requiresCorrectToolForDrops()),
                    ModBlockInfo.create()
                            .addTags(BlockTags.MINEABLE_WITH_PICKAXE,BlockTags.NEEDS_IRON_TOOL)
                            .setName(new LangString("Chiseled Silver", "雕刻银块"))
            );

    public static final RegistryObject<StairBlock> CUT_SILVER_STAIRS =
            registerBlock("cut_silver_stairs",() -> new StairBlock(() -> CUT_SILVER.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(CUT_SILVER.get())),
                    ModBlockInfo.create()
                            .setBaseBlock(() -> CUT_SILVER.get())
                            .setBlockState(ModBlockInfo.BlockState.STAIRS)
                            .addTags(BlockTags.MINEABLE_WITH_PICKAXE,BlockTags.NEEDS_IRON_TOOL)
                            .setName(new LangString("Cut Silver Stairs", "切制银楼梯"))
            );

    public static final RegistryObject<SlabBlock> CUT_SILVER_SLAB =
            registerBlock("cut_silver_slab",() -> new SlabBlock(BlockBehaviour.Properties
                    .copy(CUT_SILVER.get()).requiresCorrectToolForDrops()),
                    ModBlockInfo.create()
                            .setBaseBlock(() -> CUT_SILVER.get())
                            .setBlockState(ModBlockInfo.BlockState.SLAB)
                            .setBlockLootTable(ModBlockInfo.BlockLootTable.DROP_SLAB)
                            .addTags(BlockTags.MINEABLE_WITH_PICKAXE,BlockTags.NEEDS_IRON_TOOL)
                            .setName(new LangString("Cut Silver Slab", "切制银台阶"))
            );

    public static final RegistryObject<Block> SILVER_GRATE =
            registerBlock("silver_grate",() -> new Block(BlockBehaviour.Properties
                    .copy(Blocks.GOLD_BLOCK).requiresCorrectToolForDrops().noOcclusion()),
                    ModBlockInfo.create().setBlockState(ModBlockInfo.BlockState.SPECIAL)
                            .addTags(BlockTags.MINEABLE_WITH_PICKAXE,BlockTags.NEEDS_IRON_TOOL)
                            .setName(new LangString("Silver Grate", "银格栅"))
            );

    public static final RegistryObject<Block> SILVER_BARS =
            registerBlock("silver_bars",() -> new IronBarsBlock(BlockBehaviour.Properties
                    .copy(Blocks.GOLD_BLOCK).requiresCorrectToolForDrops().noOcclusion()),
                    ModBlockInfo.create().setBlockState(ModBlockInfo.BlockState.SPECIAL)
                            .addTags(BlockTags.MINEABLE_WITH_PICKAXE,BlockTags.NEEDS_IRON_TOOL)
                            .setName(new LangString("Silver Bars", "银栏杆"))
            );

    public static final RegistryObject<DoorBlock> SILVER_DOOR =
            registerBlock("silver_door",() -> new DoorBlock(BlockBehaviour.Properties
                    .copy(Blocks.GOLD_BLOCK).requiresCorrectToolForDrops().noOcclusion()
                            , BlockSetType.GOLD),
                    ModBlockInfo.create()
                            .setBlockState(ModBlockInfo.BlockState.DOOR)
                            .setBlockLootTable(ModBlockInfo.BlockLootTable.DROP_DOOR)
                            .addTags(BlockTags.MINEABLE_WITH_PICKAXE,BlockTags.NEEDS_IRON_TOOL)
                            .setName(new LangString("Silver Door", "银门"))
            );

    public static final RegistryObject<TrapDoorBlock> SILVER_TRAP_DOOR =
            registerBlock("silver_trapdoor",() -> new TrapDoorBlock(BlockBehaviour.Properties
                    .copy(Blocks.GOLD_BLOCK).requiresCorrectToolForDrops().noOcclusion()
                            , BlockSetType.GOLD),
                    ModBlockInfo.create()
                            .setBlockState(ModBlockInfo.BlockState.TRAPDOOR)
                            .addTags(BlockTags.MINEABLE_WITH_PICKAXE,BlockTags.NEEDS_IRON_TOOL)
                            .setName(new LangString("Silver Trapdoor", "银活板门"))
            );

    public static final RegistryObject<PressurePlateBlock> SILVER_PRESSURE_PLATE =
            registerBlock("silver_pressure_plate",() -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.MOBS, BlockBehaviour.Properties
                            .copy(Blocks.GOLD_BLOCK).requiresCorrectToolForDrops()
                            , BlockSetType.GOLD),
                    ModBlockInfo.create()
                            .setBaseBlock(SILVER_BLOCK)
                            .setBlockState(ModBlockInfo.BlockState.PRESSURE_PLATE)
                            .addTags(BlockTags.MINEABLE_WITH_PICKAXE,BlockTags.NEEDS_IRON_TOOL)
                            .setName(new LangString("Silver Pressure Plate", "银压力板"))
            );

    public static final RegistryObject<ChainBlock> SILVER_CHAIN =
            registerBlock("silver_chain",() -> new ChainBlock(BlockBehaviour.Properties
                    .copy(Blocks.CHAIN).requiresCorrectToolForDrops().noOcclusion()),
                    ModBlockInfo.create().setBlockState(ModBlockInfo.BlockState.SPECIAL)
                            .addTags(BlockTags.MINEABLE_WITH_PICKAXE)
                            .setName(new LangString("Silver Chain", "银链"))
            );

    public static final RegistryObject<LanternBlock> SILVER_LANTERN =
            registerBlock("silver_lantern",() -> new LanternBlock(BlockBehaviour.Properties
                    .copy(Blocks.LANTERN).requiresCorrectToolForDrops().noOcclusion()),
                    ModBlockInfo.create().setBlockState(ModBlockInfo.BlockState.SPECIAL)
                            .addTags(BlockTags.MINEABLE_WITH_PICKAXE)
                            .setName(new LangString("Silver Lantern", "银灯笼"))
            );
    public static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, ModElementInfo info){
        info.setLocation(GoldSilver.resourceLocation(name)).build();
        RegistryObject<T> aBlock = BLOCKS.register(name,block);
        registerBlockItem(name,aBlock);
        return aBlock;
    }

    public static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block){
        return ModItems.ITEMS.register(name,
                () -> new BlockItem(block.get(),new Item.Properties()));
    }

    public static void register(IEventBus bus){
        BLOCKS.register(bus);
    }
}
