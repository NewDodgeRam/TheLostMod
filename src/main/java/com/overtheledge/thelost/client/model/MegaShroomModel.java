package com.overtheledge.thelost.client.model;

import com.overtheledge.thelost.TheLost;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class MegaShroomModel extends AnimatedGeoModel
{
    @Override
    public ResourceLocation getAnimationFileLocation(Object entity)
    {
        return new ResourceLocation(TheLost.MOD_ID, "animations/mega_shroom.animation.json");
    }

    @Override
    public ResourceLocation getModelLocation(Object entity)
    {
        return new ResourceLocation(TheLost.MOD_ID, "geo/mega_shroom.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(Object entity)
    {
        return new ResourceLocation(TheLost.MOD_ID, "textures/entity/mega_shroom.png");
    }
}