package org.occul.gold_and_silver_craft.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;
import org.occul.gold_and_silver_craft.GoldAndSilverCraft;
import org.occul.gold_and_silver_craft.core.ModInf;
import org.occul.gold_and_silver_craft.core.ModInfRegistry;
import org.occul.gold_and_silver_craft.core.ModularItem;
import org.occul.gold_and_silver_craft.register.ModItems;

import java.util.concurrent.CompletableFuture;

public class ModItemTagsProvider extends ItemTagsProvider {

    public ModItemTagsProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pLookupProvider, CompletableFuture<TagLookup<Block>> pBlockTags,  @Nullable ExistingFileHelper existingFileHelper) {
        super(pOutput, pLookupProvider, pBlockTags, GoldAndSilverCraft.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        for(var entry: ModItems.ITEMS.getEntries()){
            Item item = entry.get();
            if(ModInfRegistry.hasItemInf(item)){
                ModInf<Item> inf = ModInfRegistry.getItemInf(item);
                for(TagKey<Item> t :inf.getTagKeys())
                    tag(t).add(item);
            }
        }
    }
}
