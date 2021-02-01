package com.overtheledge.thelost.client.model;

import com.overtheledge.thelost.TheLost;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class HuskHulkModel extends AnimatedGeoModel
{
    @Override
    public ResourceLocation getAnimationFileLocation(Object entity)
    {
        return new ResourceLocation(TheLost.MOD_ID, "animations/husk_hulk.animation.json");
    }

    @Override
    public ResourceLocation getModelLocation(Object entity)
    {
        return new ResourceLocation(TheLost.MOD_ID, "geo/husk_hulk.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(Object entity)
    {
        return new ResourceLocation(TheLost.MOD_ID, "textures/entity/husk_hulk.png");
    }
}