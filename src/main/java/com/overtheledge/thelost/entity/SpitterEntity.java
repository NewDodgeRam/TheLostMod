package com.overtheledge.thelost.entity;

import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class SpitterEntity extends CreatureEntity implements IAnimatable {
    private AnimationFactory factory = new AnimationFactory(this);

    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event)
    {
        //if (event.isMoving() == true) {
        //event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.husk_hulk.walk", true));
        //return PlayState.CONTINUE;
        //}
        //else {
        event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.spitter.idle", true));
        return PlayState.CONTINUE;
        //}
    }

    public SpitterEntity(EntityType<? extends CreatureEntity> type, World worldIn)
    {
        super(type, worldIn);
        this.ignoreFrustumCheck = true;
    }

    public static AttributeModifierMap.MutableAttribute setCustomAttribute() {
        return MobEntity.func_233666_p_()
                .createMutableAttribute(Attributes.MAX_HEALTH, 20.0D)
                .createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.50D);
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
        this.goalSelector.addGoal(4, new RandomWalkingGoal(this, 0.575F));
        this.goalSelector.addGoal(5, new LookRandomlyGoal(this));
        this.goalSelector.addGoal(6, new LookAtGoal(this, PlayerEntity.class, 6.0F));
        super.registerGoals();
    }
}
