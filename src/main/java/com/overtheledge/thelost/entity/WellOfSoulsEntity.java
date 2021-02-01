package com.overtheledge.thelost.entity;

import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.world.World;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class WellOfSoulsEntity extends CreatureEntity implements IAnimatable {
    private AnimationFactory factory = new AnimationFactory(this);

    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event)
    {
        //if (event.isMoving() == true) {
        //event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.husk_hulk.walk", true));
        //return PlayState.CONTINUE;
        //}
        //else {
        event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.well_of_souls.idle", true));
        return PlayState.CONTINUE;
        //}
    }

    public WellOfSoulsEntity(EntityType<? extends CreatureEntity> type, World worldIn)
    {
        super(type, worldIn);
        this.ignoreFrustumCheck = true;
    }

    public static AttributeModifierMap.MutableAttribute setCustomAttribute() {
        return MobEntity.func_233666_p_()
                .createMutableAttribute(Attributes.MAX_HEALTH, 20.0D)
                .createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.0D);
    }


    @Override
    public void registerControllers(AnimationData data)
    {
        data.addAnimationController(new AnimationController(this, "controller", 0, this::predicate));
    }

    @Override
    public AnimationFactory getFactory()
    {
        return this.factory;
    }

    @Override
    protected void registerGoals()
    {
        super.registerGoals();
    }
}