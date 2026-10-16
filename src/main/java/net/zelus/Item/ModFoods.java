package net.zelus.Item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties Strawberry = new FoodProperties.Builder()
            .nutrition(400)              // เติมหลอดอาหาร 8 หน่วย (4 ไอคอนน่อง)
            .saturationMod(1.0f)       // ตัวคูณ saturation
            .alwaysEat()   // กินได้ตลอด แม้หลอดอาหารเต็ม
            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 100, 1), 1.0f)
            .effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 200, 2, false, false, true), 1.0f)
            .build();
    public static final FoodProperties Tom_yum_goongmodel = new FoodProperties.Builder()
            .nutrition(4)              // เติมหลอดอาหาร 8 หน่วย (4 ไอคอนน่อง)
            .saturationMod(1.0f)       // ตัวคูณ saturation
            .alwaysEat()   // กินได้ตลอด แม้หลอดอาหารเต็ม
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 200, 2, false, false, true), 1.0f)
            .build();
}