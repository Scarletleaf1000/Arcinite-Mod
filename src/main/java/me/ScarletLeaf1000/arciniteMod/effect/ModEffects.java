package me.ScarletLeaf1000.arciniteMod.effect;

import me.ScarletLeaf1000.arciniteMod.ArciniteMod;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import javax.management.Attribute;

public class ModEffects {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS =
            DeferredRegister.create(BuiltInRegistries.MOB_EFFECT, ArciniteMod.MOD_ID);

    public static final Holder<MobEffect> FRENZIED_EFFECT = MOB_EFFECTS.register("frenzied",
        () -> new FrenziedEffect(MobEffectCategory.BENEFICIAL, 0xff702e));

    public static void register(IEventBus eventBus){
        MOB_EFFECTS.register(eventBus);
    }
}
