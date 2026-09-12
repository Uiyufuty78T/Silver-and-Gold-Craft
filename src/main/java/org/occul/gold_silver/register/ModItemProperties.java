package org.occul.gold_silver.register;

import net.minecraft.client.renderer.item.ItemProperties;
import org.occul.gold_silver.GoldSilver;

public class ModItemProperties {
    public static void register() {
        ItemProperties.register(ModItems.SILVER_COIN.get(), GoldSilver.resourceLocation("amount"),
                (stack, world, entity, seed) -> {
                    int count = stack.getCount();
                    if(count <= 5) return 0.0f;
                    if(count <= 20) return 0.3f;
                    if(count <= 40) return 0.6f;
                    if(count <= 64) return 1.0f;
                    return 0.0f;
                });
    }
}
