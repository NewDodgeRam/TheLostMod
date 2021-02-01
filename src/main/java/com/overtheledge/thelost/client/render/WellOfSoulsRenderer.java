package com.overtheledge.thelost.client.render;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.overtheledge.thelost.client.model.WellOfSoulsModel;
import com.overtheledge.thelost.entity.WellOfSoulsEntity;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class WellOfSoulsRenderer  extends GeoEntityRenderer<WellOfSoulsEntity>
{
    public WellOfSoulsRenderer(EntityRendererManager renderManager)
    {
        super(renderManager, new WellOfSoulsModel());
    }

    @Override
    public RenderType getRenderType(WellOfSoulsEntity animatable, float partialTicks, MatrixStack stack, IRenderTypeBuffer renderTypeBuffer, IVertexBuilder vertexBuilder, int packedLightIn, ResourceLocation textureLocation) {
        return RenderType.getEntityTranslucent(getTextureLocation(animatable));
    }
}