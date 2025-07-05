package me.ScarletLeaf1000.arciniteMod.effect;


import me.ScarletLeaf1000.arciniteMod.ArciniteMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;

public class FrenziedEffect extends MobEffect {
    public FrenziedEffect(MobEffectCategory category, int color) {
        super(category, color);
    }

    public void addAttackSpeedModifier(int amplifier){
        addAttributeModifier(Attributes.ATTACK_SPEED, ResourceLocation.fromNamespaceAndPath( ArciniteMod.MOD_ID, "effect.frenzied"), 0.1 * (amplifier + 1), AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL);
    }

    @Override
    public void onEffectAdded(LivingEntity livingEntity, int amplifier) {
        addAttackSpeedModifier(amplifier);
    }
}
