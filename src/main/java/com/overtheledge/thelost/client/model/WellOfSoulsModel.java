package com.overtheledge.thelost.client.model;

import com.overtheledge.thelost.TheLost;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class WellOfSoulsModel extends AnimatedGeoModel
{
    @Override
    public ResourceLocation getAnimationFileLocation(Object entity)
    {
        return new ResourceLocation(TheLost.MOD_ID, "animations/well_of_souls.animation.json");
    }

    @Override
    public ResourceLocation getModelLocation(Object entity)
    {
        return new ResourceLocation(TheLost.MOD_ID, "geo/well_of_souls.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(Object entity)
    {
        return new ResourceLocation(TheLost.MOD_ID, "textures/entity/well_of_souls.png");
    }
}