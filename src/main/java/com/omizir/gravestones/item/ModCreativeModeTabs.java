package com.omizir.gravestones.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import org.jetbrains.annotations.NotNull;

public class ModCreativeModeTabs {
    public static final CreativeModeTab GRAVESTONE_TAB = new CreativeModeTab("gravestones_tab") {
        @Override
        public @NotNull ItemStack makeIcon() {
            return new ItemStack(Items.BONE);
        }
    };
}
