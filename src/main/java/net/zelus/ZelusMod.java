package net.zelus;

import net.zelus.Item.ModBlocks;
import net.zelus.Item.ModCreativeTabs;
import net.zelus.Item.ModItems;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.eventbus.api.IEventBus;

@Mod(ZelusMod.MODID)
public class ZelusMod {
    public static final String MODID = "zelus";

    public ZelusMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(modEventBus);
        ModBlocks.BLOCKS.register(bus);
        ModCreativeTabs.register(modEventBus);   // เพิ่มบรรทัดนี้
        bus.addListener(this::addCreative);
        modEventBus.addListener(this::addCreative);
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.FOOD_AND_DRINKS) {
            event.accept(ModItems.Strawberry);
        }
    }
}