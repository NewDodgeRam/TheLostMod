package com.overtheledge.thelost;

import com.overtheledge.thelost.entity.*;
import com.overtheledge.thelost.init.TheLostRegistry;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import software.bernie.example.GeckoLibMod;
import software.bernie.geckolib3.GeckoLib;


@Mod("thelost")
public class TheLost
{
    public static final Logger LOGGER = (Logger) LogManager.getLogger();
    public static final String MOD_ID = "thelost";

    public static ItemGroup thelostItemGroup;

    public TheLost()
    {
        GeckoLib.initialize();
        GeckoLibMod.DISABLE_IN_DEV = true;

        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::setup);

        TheLostRegistry.ENTITIES.register(modEventBus);
        TheLostRegistry.ITEMS.register(modEventBus);
        TheLostRegistry.BLOCKS.register(modEventBus);

        thelostItemGroup = new ItemGroup(ItemGroup.getGroupCountSafe(), "thelostcreativetab") {
            @Override
            public ItemStack createIcon() {
                return new ItemStack(TheLostRegistry.KEY4.get());
            }
        };
    }

    private void setup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            // Tier 1
            // Desert
            GlobalEntityTypeAttributes.put(TheLostRegistry.HUSK_HULK.get(), HuskHulkEntity.setCustomAttribute().create());
            // Jungle
            GlobalEntityTypeAttributes.put(TheLostRegistry.TAO_TEKI.get(), TaoTekiEntity.setCustomAttribute().create());
            // Forest

            // Tier 2
            // Nether Fortress
            GlobalEntityTypeAttributes.put(TheLostRegistry.BLAZE_KEEPER.get(), BlazeKeeperEntity.setCustomAttribute().create());
            // Nether Soul
            GlobalEntityTypeAttributes.put(TheLostRegistry.WELL_OF_SOULS.get(), WellOfSoulsEntity.setCustomAttribute().create());
            // Nether Shrooms
            GlobalEntityTypeAttributes.put(TheLostRegistry.MEGA_SHROOM.get(), MegaShroomEntity.setCustomAttribute().create());

            // Tier 3
            // End Wastes
            // End Void
            // End City

            // Unassigned Entities
            GlobalEntityTypeAttributes.put(TheLostRegistry.SKELETON_SNIPER.get(), SkeletonSniperEntity.setCustomAttribute().create());
            GlobalEntityTypeAttributes.put(TheLostRegistry.SPITTER.get(), SpitterEntity.setCustomAttribute().create());

        });
    }
}