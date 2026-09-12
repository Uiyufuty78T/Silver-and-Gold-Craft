package org.occul.gold_silver.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
import org.occul.gold_silver.GoldSilver;
import org.occul.gold_silver.content.item.armor.ModTrimMaterials;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

//数据驱动注册,绕过动态注册表，参考TheSilverAge
//适合世界生成、附魔、纹饰
public class ModDataparkProvider extends DatapackBuiltinEntriesProvider {
    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.TRIM_MATERIAL, ModTrimMaterials::bootstrap);

    public ModDataparkProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries,BUILDER, Set.of(GoldSilver.MODID));
    }
}
