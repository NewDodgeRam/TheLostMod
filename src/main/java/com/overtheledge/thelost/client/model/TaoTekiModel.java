package com.overtheledge.thelost.client.model;

import com.overtheledge.thelost.TheLost;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class TaoTekiModel extends AnimatedGeoModel
{
    @Override
    public ResourceLocation getAnimationFileLocation(Object entity)
    {
        return new ResourceLocation(TheLost.MOD_ID, "animations/tao_teki.animation.json");
    }

    @Override
    public ResourceLocation getModelLocation(Object entity)
    {
        return new ResourceLocation(TheLost.MOD_ID, "geo/tao_teki.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(Object entity)
    {
        return new ResourceLocation(TheLost.MOD_ID, "textures/entity/tao_teki.png");
    }
}