package net.zelus.Item;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.zelus.ZelusMod;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, ZelusMod.MODID);

    public static final RegistryObject<Item> Strawberry = ITEMS.register("strawberry",
            () -> new EffectShow(new Item.Properties()
                    .food(ModFoods.Strawberry)
                    .stacksTo(16)));
    public static final RegistryObject<Item> Tom_yum_goongmodel = ITEMS.register("tom_yum_goongmodel",
            () -> new EffectShow(new Item.Properties()
                    .food(ModFoods.Tom_yum_goongmodel)
                    .stacksTo(16)));
    public static final RegistryObject<Item> Zebramini = ITEMS.register("zebramini",
            () -> new BlockItem(ModBlocks.Zebramini.get(), new Item.Properties()));
    //public static final RegistryObject<Item> Strawberry = ITEMS.register("strawberry",
    //        () -> new Item(new Item.Properties()
    //                .food(ModFoods.Strawberry)
    //                .stacksTo(16)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}