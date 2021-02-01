package com.overtheledge.thelost.client.render;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.overtheledge.thelost.client.model.HuskHulkModel;
import com.overtheledge.thelost.entity.HuskHulkEntity;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class HuskHulkRenderer extends GeoEntityRenderer<HuskHulkEntity>
{
    public HuskHulkRenderer(EntityRendererManager renderManager)
    {
        super(renderManager, new HuskHulkModel());
    }

    @Override
    public RenderType getRenderType(HuskHulkEntity animatable, float partialTicks, MatrixStack stack, IRenderTypeBuffer renderTypeBuffer, IVertexBuilder vertexBuilder, int packedLightIn, ResourceLocation textureLocation) {
        return RenderType.getEntityTranslucent(getTextureLocation(animatable));
    }

}