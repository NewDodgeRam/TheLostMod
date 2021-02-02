package com.overtheledge.thelost.client.render;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.overtheledge.thelost.block.tile.Tier1PortalTileEntity;
import com.overtheledge.thelost.client.model.Tier1PortalModel;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.renderers.geo.GeoBlockRenderer;

import javax.annotation.Nullable;

public class Tier1PortalTileRenderer extends GeoBlockRenderer<Tier1PortalTileEntity>
{
    public Tier1PortalTileRenderer(TileEntityRendererDispatcher rendererDispatcherIn)
    {
        super(rendererDispatcherIn, new Tier1PortalModel());
    }

    @Override
    public RenderType getRenderType(Tier1PortalTileEntity animatable, float partialTicks, MatrixStack stack, IRenderTypeBuffer renderTypeBuffer, IVertexBuilder vertexBuilder, int packedLightIn, ResourceLocation textureLocation)
    {
        return RenderType.getEntityTranslucent(getTextureLocation(animatable));
    }
}
