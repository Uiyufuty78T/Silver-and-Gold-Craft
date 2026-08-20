package org.occul.gold_and_silver_craft.register;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.occul.gold_and_silver_craft.GoldAndSilverCraft;
import org.occul.gold_and_silver_craft.core.ModularBlock;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, GoldAndSilverCraft.MODID);

    public static final RegistryObject<Block> SILVER_BLOCK =
            registerBlock("silver_block",() -> new ModularBlock(BlockBehaviour.Properties.copy(Blocks.GOLD_BLOCK).requiresCorrectToolForDrops())
                    .addTags(BlockTags.MINEABLE_WITH_PICKAXE)
                    .addTags(BlockTags.NEEDS_IRON_TOOL)
                    .dropSelf()
                    .usingBasicModel()
                    .enUsLang("Silver Block"));

    public static final RegistryObject<Block> SILVER_ORE =
            registerBlock("silver_ore",() -> new ModularBlock(BlockBehaviour.Properties.copy(Blocks.GOLD_ORE).requiresCorrectToolForDrops())
                    .addTags(BlockTags.MINEABLE_WITH_PICKAXE)
                    .addTags(BlockTags.NEEDS_IRON_TOOL)
                    .usingBasicModel()
                    .enUsLang("Silver Ore"));

    public static final RegistryObject<Block> DEEPSLATE_SILVER_ORE =
            registerBlock("deepslate_silver_ore",() -> new ModularBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_GOLD_ORE).requiresCorrectToolForDrops())
                    .addTags(BlockTags.MINEABLE_WITH_PICKAXE)
                    .addTags(BlockTags.NEEDS_IRON_TOOL)
                    .usingBasicModel()
                    .enUsLang("Deepslate Silver Ore"));

    public static final RegistryObject<Block> RAW_SILVER_BLOCK =
            registerBlock("raw_silver_block",() -> new ModularBlock(BlockBehaviour.Properties.copy(Blocks.RAW_GOLD_BLOCK).requiresCorrectToolForDrops())
                    .addTags(BlockTags.MINEABLE_WITH_PICKAXE)
                    .addTags(BlockTags.NEEDS_IRON_TOOL)
                    .dropSelf()
                    .usingBasicModel()
                    .enUsLang("Raw Silver Block"));

    public static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block){
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
