package com.omizir.gravestones.block;

import com.omizir.gravestones.Gravestones;
import com.omizir.gravestones.block.custom.GravestoneBlock;
import com.omizir.gravestones.item.ModCreativeModeTabs;
import com.omizir.gravestones.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Gravestones.MOD_ID);

    public static final RegistryObject<Block> GRAVESTONE_1 = registerBlock("gravestone_1",
            () -> new GravestoneBlock(BlockBehaviour.Properties.of(Material.STONE).strength(1f).noOcclusion()), ModCreativeModeTabs.GRAVESTONE_TAB);

    public static final RegistryObject<Block> GRAVESTONE_1_CANDLE = registerBlock("gravestone_1_candle",
            () -> new GravestoneBlock(BlockBehaviour.Properties.of(Material.STONE).strength(1f).noOcclusion().lightLevel(state -> 10)), ModCreativeModeTabs.GRAVESTONE_TAB);

    public static final RegistryObject<Block> GRAVESTONE_1_MOSS = registerBlock("gravestone_1_moss",
            () -> new GravestoneBlock(BlockBehaviour.Properties.of(Material.STONE).strength(1f).noOcclusion()), ModCreativeModeTabs.GRAVESTONE_TAB);

    public static final RegistryObject<Block> GRAVESTONE_1_CANDLE_MOSS = registerBlock("gravestone_1_candle_moss",
            () -> new GravestoneBlock(BlockBehaviour.Properties.of(Material.STONE).strength(1f).noOcclusion().lightLevel(state -> 10)), ModCreativeModeTabs.GRAVESTONE_TAB);


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
