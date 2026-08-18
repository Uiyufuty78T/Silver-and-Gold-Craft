package org.occul.gold_and_silver_craft;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSet;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.occul.gold_and_silver_craft.datagen.*;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = GoldAndSilverCraft.MODID,bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModDataGenerator {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event){
        DataGenerator generator = event.getGenerator();
        PackOutput output = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        generator.addProvider(event.includeServer(), new ModRecipesProvider(output));
        generator.addProvider(event.includeServer(),new LootTableProvider(output, Set.of(), List.of(
                new LootTableProvider.SubProviderEntry(ModBlockLootTablesProvider::new, LootContextParamSets.BLOCK)
        )));

        BlockTagsProvider blockTagsProvider = generator.addProvider(event.includeServer(), new ModBlockTagsProvider(output,lookupProvider,existingFileHelper));
        generator.addProvider(event.includeServer(), new ModItemTagsProvider(output,lookupProvider,blockTagsProvider.contentsGetter(),existingFileHelper ));

        generator.addProvider(event.includeClient(), new ModBlockStateProvider(output,existingFileHelper));
        generator.addProvider(event.includeClient(), new ModItemModelsProvider(output,existingFileHelper));
        generator.addProvider(event.includeClient(), new ModEnUsLangProvider(output));
        //generator.addProvider(event.includeClient(), new ModBlockStateProvider(output,existingFileHelper));

    }
}
