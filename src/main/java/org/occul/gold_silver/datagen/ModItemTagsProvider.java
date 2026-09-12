package org.occul.gold_silver.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;
import org.occul.gold_silver.GoldSilver;
import org.occul.gold_silver.core.Info.ModItemInfo;
import org.occul.gold_silver.core.Info.ModElementInfoRegistry;
import org.occul.gold_silver.register.ModItems;

import java.util.concurrent.CompletableFuture;

public class ModItemTagsProvider extends ItemTagsProvider {

    public ModItemTagsProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pLookupProvider, CompletableFuture<TagLookup<Block>> pBlockTags,  @Nullable ExistingFileHelper existingFileHelper) {
        super(pOutput, pLookupProvider, pBlockTags, GoldSilver.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        for(var entry: ModItems.ITEMS.getEntries()){
            Item item = entry.get();
            if(!(ModElementInfoRegistry.getInfo(item) instanceof ModItemInfo info)) continue;
            for(TagKey<Item> tag :info.getTagKeys())
                tag(tag).add(item);
        }
    }
}
