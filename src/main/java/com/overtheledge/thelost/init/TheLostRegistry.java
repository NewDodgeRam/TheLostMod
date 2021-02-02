package com.overtheledge.thelost.init;

import com.overtheledge.thelost.TheLost;
import com.overtheledge.thelost.block.BlockItemBase;
import com.overtheledge.thelost.block.Lock;
import com.overtheledge.thelost.block.Tier1PortalBlock;
import com.overtheledge.thelost.block.tile.Tier1PortalTileEntity;
import com.overtheledge.thelost.entity.*;
import com.overtheledge.thelost.items.Key;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class TheLostRegistry {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, TheLost.MOD_ID);
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, TheLost.MOD_ID);
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, TheLost.MOD_ID);
    public static final DeferredRegister<TileEntityType<?>> TILES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, TheLost.MOD_ID);

    public static void init() {
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        TILES.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    // Items
    public static final RegistryObject<Item> KEY1 = ITEMS.register("key1", Key::new);
    public static final RegistryObject<Item> KEY2 = ITEMS.register("key2", Key::new);
    public static final RegistryObject<Item> KEY3 = ITEMS.register("key3", Key::new);
    public static final RegistryObject<Item> KEY4 = ITEMS.register("key4", Key::new);

    // Blocks
    public static final RegistryObject<Block> LOCK = BLOCKS.register("lock", Lock::new);
    public static final RegistryObject<Block> TIER_1_PORTAL_BLOCK = BLOCKS.register("tier1portalblock", Tier1PortalBlock::new);

    // Tiles
    public static final RegistryObject<TileEntityType<Tier1PortalTileEntity>> TIER_1_PORTAL_TILE = TILES.register("tier1portaltile", () -> TileEntityType.Builder.create(Tier1PortalTileEntity::new, TheLostRegistry.TIER_1_PORTAL_BLOCK.get()).build(null));

    // Block Items
    public static final RegistryObject<Item> LOCK_ITEM = ITEMS.register("lock", () -> new BlockItemBase(LOCK.get()));
    public static final RegistryObject<Item> TIER_1_PORTAL_ITEM = ITEMS.register("tier1portal", () -> new BlockItemBase(TIER_1_PORTAL_BLOCK.get()));

    // Entities

    // Tier 1
    // Desert
    public static final RegistryObject<EntityType<HuskHulkEntity>> HUSK_HULK = buildEntity("husk_hulk", HuskHulkEntity::new, HuskHulkEntity.class, 4.0F, 3.0F);
    // Jungle
    public static final RegistryObject<EntityType<TaoTekiEntity>> TAO_TEKI = buildEntity("tao_teki", TaoTekiEntity::new, TaoTekiEntity.class, 3.0F, 2.0F);
    // Forest

    // Tier 2
    // Nether Fortress
    public static final RegistryObject<EntityType<BlazeKeeperEntity>> BLAZE_KEEPER = buildEntity("blaze_keeper", BlazeKeeperEntity::new, BlazeKeeperEntity.class, 3.0F, 4.0F);
    // Nether Soul
    public static final RegistryObject<EntityType<WellOfSoulsEntity>> WELL_OF_SOULS = buildFireResistantEntity("well_of_souls", WellOfSoulsEntity::new, WellOfSoulsEntity.class, 1.0F, 1.0F);
    // Nether Shrooms
    public static final RegistryObject<EntityType<MegaShroomEntity>> MEGA_SHROOM = buildEntity("mega_shroom", MegaShroomEntity::new, MegaShroomEntity.class, 9.0F, 12.0F);

    // Tier 3
    // End Wastes
    // End Void
    // End City

    // Unassigned Entities
    public static final RegistryObject<EntityType<SkeletonSniperEntity>> SKELETON_SNIPER = buildEntity("skeleton_sniper", SkeletonSniperEntity::new, SkeletonSniperEntity.class, 1.0F, 2.0F);
    public static final RegistryObject<EntityType<SpitterEntity>> SPITTER = buildEntity("spitter", SpitterEntity::new, SpitterEntity.class, 1.0F, 1.0F);

    // Methods
    public static <T extends Entity> RegistryObject<EntityType<T>> buildEntity(String name , EntityType.IFactory<T> entity, Class<T> entityClass, float width, float height)
    {
        return ENTITIES.register(name, () -> EntityType.Builder
                .create(entity, EntityClassification.CREATURE)
                .size(width, height).build(name));
    }
    public static <T extends Entity> RegistryObject<EntityType<T>> buildFireResistantEntity(String name , EntityType.IFactory<T> entity, Class<T> entityClass, float width, float height)
    {
        return ENTITIES.register(name, () -> EntityType.Builder
                .create(entity, EntityClassification.CREATURE)
                .immuneToFire()
                .size(width, height).build(name));
    }
}
