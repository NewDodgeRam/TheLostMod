package com.overtheledge.thelost.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class Lock extends Block {

    public Lock() {
        super(Block.Properties.create(Material.IRON)
                .hardnessAndResistance(30.0f, 6.0f)
                .sound(SoundType.METAL)
                .harvestLevel(3)
                .setRequiresTool()
                .harvestTool(ToolType.PICKAXE)
        );
    }
}
