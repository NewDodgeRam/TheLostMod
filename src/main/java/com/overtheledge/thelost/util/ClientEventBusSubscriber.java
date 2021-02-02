package com.overtheledge.thelost.util;

import com.overtheledge.thelost.TheLost;
import com.overtheledge.thelost.client.render.*;
import com.overtheledge.thelost.init.TheLostRegistry;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Supplier;

@Mod.EventBusSubscriber(modid = TheLost.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEventBusSubscriber {

    @SubscribeEvent
    public static void registerRenderers(final FMLClientSetupEvent event)
    {
        // Tier 1
        // Desert
        RenderingRegistry.registerEntityRenderingHandler(TheLostRegistry.HUSK_HULK.get(),
                HuskHulkRenderer::new);
        // Jungle
        RenderingRegistry.registerEntityRenderingHandler(TheLostRegistry.TAO_TEKI.get(),
                TaoTekiRenderer::new);
        // Forest

        // Tier 2
        // Nether Fortress
        RenderingRegistry.registerEntityRenderingHandler(TheLostRegistry.BLAZE_KEEPER.get(),
                BlazeKeeperRenderer::new);
        // Nether Soul
        RenderingRegistry.registerEntityRenderingHandler(TheLostRegistry.WELL_OF_SOULS.get(),
                WellOfSoulsRenderer::new);
        // Nether Shrooms
        RenderingRegistry.registerEntityRenderingHandler(TheLostRegistry.MEGA_SHROOM.get(),
                MegaShroomRenderer::new);

        // Tier 3
        // End Wastes
        // End Void
        // End City

        // Unassigned Entities
        RenderingRegistry.registerEntityRenderingHandler(TheLostRegistry.SKELETON_SNIPER.get(),
                SkeletonSniperRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(TheLostRegistry.SPITTER.get(),
                SpitterRenderer::new);

        // Tiles
        ClientRegistry.bindTileEntityRenderer(TheLostRegistry.TIER_1_PORTAL_TILE.get(), Tier1PortalTileRenderer::new);

        RenderTypeLookup.setRenderLayer(TheLostRegistry.TIER_1_PORTAL_BLOCK.get(), RenderType.getCutout());
    }

    public static class ConfigValueListener<T> implements Supplier<T>
    {
        private T value = null;
        private final ForgeConfigSpec.ConfigValue<T> configValue;

        private ConfigValueListener(final ForgeConfigSpec.ConfigValue<T> configValue)
        {
            this.configValue = configValue;
            //this.value = configValue.get();
        }

        public static <T> ConfigValueListener<T> of(final ForgeConfigSpec.ConfigValue<T> configValue, final List<ConfigValueListener<?>> valueList)
        {
            final ConfigValueListener<T> value = new ConfigValueListener<>(configValue);
            valueList.add(value);
            return value;
        }
        public static <T> T register(
                final ModConfig.Type configType,
                final BiFunction<ForgeConfigSpec.Builder, Subscriber, T> configBuilder,
                final String registerConfig)
        {
            return register(ModLoadingContext.get(), configType, configBuilder, registerConfig);
        }

        /** call this in either your @Mod class constructor or in FMLCommonSetupEvent or in FMLClientSetupEvent **/
        public static <T> T register(
                final ModLoadingContext modContext,
                final ModConfig.Type configType,
                final BiFunction<ForgeConfigSpec.Builder, Subscriber, T> configBuilder,
                final String registerConfig)
        {
            final List<ConfigValueListener<?>> subscriptionList = new ArrayList<>();
            final Pair<T, ForgeConfigSpec> entry = new ForgeConfigSpec.Builder().configure(builder -> configBuilder.apply(builder, getSubscriber(subscriptionList)));
            final T config = entry.getLeft();
            final ForgeConfigSpec spec = entry.getRight();

            modContext.registerConfig(configType, spec, registerConfig);

            final Consumer<ModConfig.ModConfigEvent> configUpdate = event ->
            {
                if(event.getConfig().getSpec() == spec)
                    for(ConfigValueListener<?> value : subscriptionList)
                        value.update();
            };

            FMLJavaModLoadingContext.get().getModEventBus().addListener(configUpdate);
            return config;
        }

        private static Subscriber getSubscriber(final List<ConfigValueListener<?>> list)
        {
            return new Subscriber(list);
        }

        public static class Subscriber
        {
            final List<ConfigValueListener<?>> list;

            Subscriber(final List<ConfigValueListener<?>> list)
            {
                this.list = list;
            }

            public <T> ConfigValueListener<T> subscribe(final ForgeConfigSpec.ConfigValue<T> value)
            {
                return ConfigValueListener.of(value, this.list);
            }
        }

        public void update()
        {
            this.value = this.configValue.get();
        }

        @Override
        public T get()
        {
            if (this.value == null)
                this.update();
            return this.value;
        }
    }

}
