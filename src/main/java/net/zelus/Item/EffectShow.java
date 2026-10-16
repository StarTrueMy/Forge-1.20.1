package net.zelus.Item;

import com.mojang.datafixers.util.Pair;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffectUtil;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.MutableComponent;

import javax.annotation.Nullable;
import java.util.List;

public class EffectShow extends Item {

    @Override
    public Component getName(ItemStack stack) {
        return super.getName(stack).copy().withStyle(ChatFormatting.DARK_PURPLE);
    }
//    กำหนดสีเอง
//    @Override
//    public Component getName(ItemStack stack) {
//        return super.getName(stack).copy()
//    }

    public EffectShow(Properties properties) {
        super(properties);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level,
                                List<Component> tooltip, TooltipFlag flag) {
        FoodProperties food = stack.getFoodProperties(null);
        if (food == null || food.getEffects().isEmpty()) {
            super.appendHoverText(stack, level, tooltip, flag);
            return;
        }

        tooltip.add(Component.translatable("A-goi!")
                .withStyle(ChatFormatting.DARK_PURPLE));

        for (Pair<MobEffectInstance, Float> pair : food.getEffects()) {
            MobEffectInstance effect = pair.getFirst();
            float chance = pair.getSecond();

            // ชื่อ effect เช่น "Regeneration"
            MutableComponent line = Component.translatable(effect.getDescriptionId());

            // ระดับ เช่น "II" (amplifier 0 = ระดับ I ไม่ต้องแสดง)
            if (effect.getAmplifier() > 0) {
                line = Component.translatable("potion.withAmplifier", line,
                        Component.translatable("potion.potency." + effect.getAmplifier()));
            }

            // ระยะเวลา เช่น "0:05"
            if (!effect.endsWithin(20)) {
                line = Component.translatable("potion.withDuration", line,
                        MobEffectUtil.formatDuration(effect, 1.0f));
            }

            // สีตามประเภท effect (ดี = น้ำเงิน, ไม่ดี = แดง)
            line.withStyle(effect.getEffect().getCategory().getTooltipFormatting());
            tooltip.add(line);

            // โอกาสเกิด (แสดงเมื่อไม่ใช่ 100%)
            if (chance < 1.0f) {
                tooltip.add(Component.translatable("tooltip.examplemod.chance",
                                Math.round(chance * 100))
                        .withStyle(ChatFormatting.GRAY));
            }
        }
    }
}