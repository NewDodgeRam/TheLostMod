package com.overtheledge.thelost.client.render;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.overtheledge.thelost.client.model.TaoTekiModel;
import com.overtheledge.thelost.entity.TaoTekiEntity;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class TaoTekiRenderer  extends GeoEntityRenderer<TaoTekiEntity>
{
    public TaoTekiRenderer(EntityRendererManager renderManager)
    {
        super(renderManager, new TaoTekiModel());
    }

    @Override
    public RenderType getRenderType(TaoTekiEntity animatable, float partialTicks, MatrixStack stack, IRenderTypeBuffer renderTypeBuffer, IVertexBuilder vertexBuilder, int packedLightIn, ResourceLocation textureLocation) {
        return RenderType.getEntityTranslucent(getTextureLocation(animatable));
    }
}
