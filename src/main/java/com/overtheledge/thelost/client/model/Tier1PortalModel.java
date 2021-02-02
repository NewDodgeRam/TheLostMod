package com.overtheledge.thelost.client.model;

import com.overtheledge.thelost.TheLost;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class Tier1PortalModel extends AnimatedGeoModel {

    @Override
    public ResourceLocation getAnimationFileLocation(Object entity)
    {
        return new ResourceLocation(TheLost.MOD_ID, "animations/tier_1_portal.animation.json");
    }

    @Override
    public ResourceLocation getModelLocation(Object entity)
    {
        return new ResourceLocation(TheLost.MOD_ID, "geo/tier_1_portal.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(Object entity)
    {
        return new ResourceLocation(TheLost.MOD_ID, "textures/blocks/tier_1_portal.png");
    }
}
