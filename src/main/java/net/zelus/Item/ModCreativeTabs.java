package net.zelus.Item;

import net.minecraft.ChatFormatting;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.zelus.ZelusMod;

public class ModCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ZelusMod.MODID);

    public static final RegistryObject<CreativeModeTab> Zephyrus =
            CREATIVE_TABS.register("zelus", () -> CreativeModeTab.builder()
                    // ชื่อแท็บ (ดึงจาก lang file)
                    .title(Component.translatable("creativetab.zelus")
                            .withStyle(ChatFormatting.GOLD)
                            .withStyle(ChatFormatting.BOLD)
                    )
                    // ไอเทมที่ใช้เป็นไอคอนของแท็บ
                    .icon(() -> new ItemStack(ModItems.Strawberry.get()))
                    // ไอเทมที่จะแสดงในแท็บ
                    .displayItems((parameters, output) -> {
                        output.accept(ModItems.Strawberry.get());
                        output.accept(ModItems.Tom_yum_goongmodel.get());
                        output.accept(ModBlocks.Zebramini.get());
                        // เพิ่มไอเทมอื่นต่อได้ที่นี่
                        // output.accept(ModItems.ANOTHER_ITEM.get());
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_TABS.register(eventBus);
    }
}