package me.ScarletLeaf1000.arciniteMod.potion;

import me.ScarletLeaf1000.arciniteMod.ArciniteMod;
import me.ScarletLeaf1000.arciniteMod.effect.ModEffects;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.alchemy.Potion;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModPotions {

    public static final DeferredRegister<Potion> POTIONS =
            DeferredRegister.create(BuiltInRegistries.POTION, ArciniteMod.MOD_ID);

    public static final Holder<Potion> FRENZIED_POTION = POTIONS.register("frenzied_potion",
            () -> new Potion(new MobEffectInstance(ModEffects.FRENZIED_EFFECT, 3600, 0)));
    public static final Holder<Potion> FRENZIED_LONG_POTION = POTIONS.register("frenzied_long_potion",
            () -> new Potion(new MobEffectInstance(ModEffects.FRENZIED_EFFECT, 9600, 0)));
    public static final Holder<Potion> FRENZIED_STRONG_POTION = POTIONS.register("frenzied_strong_potion",
            () -> new Potion(new MobEffectInstance(ModEffects.FRENZIED_EFFECT, 1800, 1)));

    public static void register(IEventBus eventBus){
        POTIONS.register(eventBus);
    }
}
