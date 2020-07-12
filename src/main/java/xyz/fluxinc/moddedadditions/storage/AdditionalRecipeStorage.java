package xyz.fluxinc.moddedadditions.storage;

import org.bukkit.Material;

import java.util.ArrayList;
import java.util.HashMap;

public class AdditionalRecipeStorage {

    /**
     * Value 1: Slab
     * Value 2: Full Block
     */
    public static final HashMap<Material, Material> SLAB_TO_BLOCK;
    public static final HashMap<Material, Material> FURNACE_RECIPE;
    public static final ArrayList<Material> STAINED_GLASS;
    public static final ArrayList<Material> STAINED_GLASS_PANE;
    public static final ArrayList<Material> TERRACOTTA;
    public static final ArrayList<Material> GLAZED_TERRACOTTA;
    public static final ArrayList<Material> CONCRETE;
    public static final ArrayList<Material> CONCRETE_POWDER;
    public static final HashMap<Material, Material> STAINED_GLASS_TO_DYE;
    public static final HashMap<Material, Material> STAINED_GLASS_PANE_TO_DYE;
    public static final HashMap<Material, Material> TERRACOTTA_TO_DYE;
    public static final HashMap<Material, Material> GLAZED_TERRACOTTA_TO_DYE;
    public static final HashMap<Material, Material> CONCRETE_TO_DYE;
    public static final HashMap<Material, Material> CONCRETE_POWDER_TO_DYE;

    static {
        SLAB_TO_BLOCK = new HashMap<>();
        SLAB_TO_BLOCK.put(Material.OAK_SLAB, Material.OAK_PLANKS);
        SLAB_TO_BLOCK.put(Material.SPRUCE_SLAB, Material.SPRUCE_PLANKS);
        SLAB_TO_BLOCK.put(Material.BIRCH_SLAB, Material.BIRCH_PLANKS);
        SLAB_TO_BLOCK.put(Material.JUNGLE_SLAB, Material.JUNGLE_PLANKS);
        SLAB_TO_BLOCK.put(Material.ACACIA_SLAB, Material.ACACIA_PLANKS);
        SLAB_TO_BLOCK.put(Material.DARK_OAK_SLAB, Material.DARK_OAK_PLANKS);
        SLAB_TO_BLOCK.put(Material.STONE_SLAB, Material.STONE);
        SLAB_TO_BLOCK.put(Material.SMOOTH_STONE_SLAB, Material.SMOOTH_STONE);
        SLAB_TO_BLOCK.put(Material.SANDSTONE_SLAB, Material.SANDSTONE);
        SLAB_TO_BLOCK.put(Material.CUT_SANDSTONE_SLAB, Material.CUT_SANDSTONE);
        SLAB_TO_BLOCK.put(Material.COBBLESTONE_SLAB, Material.COBBLESTONE);
        SLAB_TO_BLOCK.put(Material.BRICK_SLAB, Material.BRICKS);
        SLAB_TO_BLOCK.put(Material.STONE_BRICK_SLAB, Material.STONE_BRICKS);
        SLAB_TO_BLOCK.put(Material.NETHER_BRICK_SLAB, Material.NETHER_BRICKS);
        SLAB_TO_BLOCK.put(Material.QUARTZ_SLAB, Material.QUARTZ_BLOCK);
        SLAB_TO_BLOCK.put(Material.RED_SANDSTONE_SLAB, Material.RED_SANDSTONE);
        SLAB_TO_BLOCK.put(Material.CUT_RED_SANDSTONE_SLAB, Material.CUT_RED_SANDSTONE);
        SLAB_TO_BLOCK.put(Material.PURPUR_SLAB, Material.PURPUR_BLOCK);
        SLAB_TO_BLOCK.put(Material.PRISMARINE_SLAB, Material.PRISMARINE);
        SLAB_TO_BLOCK.put(Material.DARK_PRISMARINE_SLAB, Material.DARK_PRISMARINE);
        SLAB_TO_BLOCK.put(Material.PRISMARINE_BRICK_SLAB, Material.PRISMARINE_BRICKS);
        SLAB_TO_BLOCK.put(Material.GRANITE_SLAB, Material.GRANITE);
        SLAB_TO_BLOCK.put(Material.POLISHED_GRANITE_SLAB, Material.POLISHED_GRANITE);
        SLAB_TO_BLOCK.put(Material.ANDESITE_SLAB, Material.ANDESITE);
        SLAB_TO_BLOCK.put(Material.POLISHED_ANDESITE_SLAB, Material.POLISHED_ANDESITE);
        SLAB_TO_BLOCK.put(Material.DIORITE_SLAB, Material.DIORITE);
        SLAB_TO_BLOCK.put(Material.POLISHED_DIORITE_SLAB, Material.POLISHED_DIORITE);
        SLAB_TO_BLOCK.put(Material.MOSSY_STONE_BRICK_SLAB, Material.MOSSY_STONE_BRICKS);
        SLAB_TO_BLOCK.put(Material.MOSSY_COBBLESTONE_SLAB, Material.MOSSY_COBBLESTONE);
        SLAB_TO_BLOCK.put(Material.END_STONE_BRICK_SLAB, Material.END_STONE_BRICKS);
        SLAB_TO_BLOCK.put(Material.SMOOTH_SANDSTONE_SLAB, Material.SMOOTH_SANDSTONE);
        SLAB_TO_BLOCK.put(Material.SMOOTH_QUARTZ_SLAB, Material.SMOOTH_QUARTZ);
        SLAB_TO_BLOCK.put(Material.RED_NETHER_BRICK_SLAB, Material.RED_NETHER_BRICKS);
        SLAB_TO_BLOCK.put(Material.SMOOTH_RED_SANDSTONE_SLAB, Material.SMOOTH_RED_SANDSTONE);
    }

    static {
        FURNACE_RECIPE = new HashMap<>();
        FURNACE_RECIPE.put(Material.ROTTEN_FLESH, Material.LEATHER);
    }

    static {
        STAINED_GLASS = new ArrayList<>();
        STAINED_GLASS.add(Material.RED_STAINED_GLASS);
        STAINED_GLASS.add(Material.GREEN_STAINED_GLASS);
        STAINED_GLASS.add(Material.PURPLE_STAINED_GLASS);
        STAINED_GLASS.add(Material.CYAN_STAINED_GLASS);
        STAINED_GLASS.add(Material.LIGHT_GRAY_STAINED_GLASS);
        STAINED_GLASS.add(Material.GRAY_STAINED_GLASS);
        STAINED_GLASS.add(Material.PINK_STAINED_GLASS);
        STAINED_GLASS.add(Material.LIME_STAINED_GLASS);
        STAINED_GLASS.add(Material.YELLOW_STAINED_GLASS);
        STAINED_GLASS.add(Material.LIGHT_BLUE_STAINED_GLASS);
        STAINED_GLASS.add(Material.MAGENTA_STAINED_GLASS);
        STAINED_GLASS.add(Material.ORANGE_STAINED_GLASS);
        STAINED_GLASS.add(Material.BLACK_STAINED_GLASS);
        STAINED_GLASS.add(Material.BROWN_STAINED_GLASS);
        STAINED_GLASS.add(Material.BLUE_STAINED_GLASS);
        STAINED_GLASS.add(Material.WHITE_STAINED_GLASS);
    }

    static {
        STAINED_GLASS_PANE = new ArrayList<>();
        STAINED_GLASS_PANE.add(Material.RED_STAINED_GLASS_PANE);
        STAINED_GLASS_PANE.add(Material.GREEN_STAINED_GLASS_PANE);
        STAINED_GLASS_PANE.add(Material.PURPLE_STAINED_GLASS_PANE);
        STAINED_GLASS_PANE.add(Material.CYAN_STAINED_GLASS_PANE);
        STAINED_GLASS_PANE.add(Material.LIGHT_GRAY_STAINED_GLASS_PANE);
        STAINED_GLASS_PANE.add(Material.GRAY_STAINED_GLASS_PANE);
        STAINED_GLASS_PANE.add(Material.PINK_STAINED_GLASS_PANE);
        STAINED_GLASS_PANE.add(Material.LIME_STAINED_GLASS_PANE);
        STAINED_GLASS_PANE.add(Material.YELLOW_STAINED_GLASS_PANE);
        STAINED_GLASS_PANE.add(Material.LIGHT_BLUE_STAINED_GLASS_PANE);
        STAINED_GLASS_PANE.add(Material.MAGENTA_STAINED_GLASS_PANE);
        STAINED_GLASS_PANE.add(Material.ORANGE_STAINED_GLASS_PANE);
        STAINED_GLASS_PANE.add(Material.BLACK_STAINED_GLASS_PANE);
        STAINED_GLASS_PANE.add(Material.BROWN_STAINED_GLASS_PANE);
        STAINED_GLASS_PANE.add(Material.BLUE_STAINED_GLASS_PANE);
        STAINED_GLASS_PANE.add(Material.WHITE_STAINED_GLASS_PANE);
    }

    static {
        TERRACOTTA = new ArrayList<>();
        TERRACOTTA.add(Material.RED_TERRACOTTA);
        TERRACOTTA.add(Material.GREEN_TERRACOTTA);
        TERRACOTTA.add(Material.PURPLE_TERRACOTTA);
        TERRACOTTA.add(Material.CYAN_TERRACOTTA);
        TERRACOTTA.add(Material.LIGHT_GRAY_TERRACOTTA);
        TERRACOTTA.add(Material.GRAY_TERRACOTTA);
        TERRACOTTA.add(Material.PINK_TERRACOTTA);
        TERRACOTTA.add(Material.LIME_TERRACOTTA);
        TERRACOTTA.add(Material.YELLOW_TERRACOTTA);
        TERRACOTTA.add(Material.LIGHT_BLUE_TERRACOTTA);
        TERRACOTTA.add(Material.MAGENTA_TERRACOTTA);
        TERRACOTTA.add(Material.ORANGE_TERRACOTTA);
        TERRACOTTA.add(Material.BLACK_TERRACOTTA);
        TERRACOTTA.add(Material.BROWN_TERRACOTTA);
        TERRACOTTA.add(Material.BLUE_TERRACOTTA);
        TERRACOTTA.add(Material.WHITE_TERRACOTTA);
    }

    static {
        GLAZED_TERRACOTTA = new ArrayList<>();
        GLAZED_TERRACOTTA.add(Material.RED_GLAZED_TERRACOTTA);
        GLAZED_TERRACOTTA.add(Material.GREEN_GLAZED_TERRACOTTA);
        GLAZED_TERRACOTTA.add(Material.PURPLE_GLAZED_TERRACOTTA);
        GLAZED_TERRACOTTA.add(Material.CYAN_GLAZED_TERRACOTTA);
        GLAZED_TERRACOTTA.add(Material.LIGHT_GRAY_GLAZED_TERRACOTTA);
        GLAZED_TERRACOTTA.add(Material.GRAY_GLAZED_TERRACOTTA);
        GLAZED_TERRACOTTA.add(Material.PINK_GLAZED_TERRACOTTA);
        GLAZED_TERRACOTTA.add(Material.LIME_GLAZED_TERRACOTTA);
        GLAZED_TERRACOTTA.add(Material.YELLOW_GLAZED_TERRACOTTA);
        GLAZED_TERRACOTTA.add(Material.LIGHT_BLUE_GLAZED_TERRACOTTA);
        GLAZED_TERRACOTTA.add(Material.MAGENTA_GLAZED_TERRACOTTA);
        GLAZED_TERRACOTTA.add(Material.ORANGE_GLAZED_TERRACOTTA);
        GLAZED_TERRACOTTA.add(Material.BLACK_GLAZED_TERRACOTTA);
        GLAZED_TERRACOTTA.add(Material.BROWN_GLAZED_TERRACOTTA);
        GLAZED_TERRACOTTA.add(Material.BLUE_GLAZED_TERRACOTTA);
        GLAZED_TERRACOTTA.add(Material.WHITE_GLAZED_TERRACOTTA);
    }

    static {
        CONCRETE = new ArrayList<>();
        CONCRETE.add(Material.RED_CONCRETE);
        CONCRETE.add(Material.GREEN_CONCRETE);
        CONCRETE.add(Material.PURPLE_CONCRETE);
        CONCRETE.add(Material.CYAN_CONCRETE);
        CONCRETE.add(Material.LIGHT_GRAY_CONCRETE);
        CONCRETE.add(Material.GRAY_CONCRETE);
        CONCRETE.add(Material.PINK_CONCRETE);
        CONCRETE.add(Material.LIME_CONCRETE);
        CONCRETE.add(Material.YELLOW_CONCRETE);
        CONCRETE.add(Material.LIGHT_BLUE_CONCRETE);
        CONCRETE.add(Material.MAGENTA_CONCRETE);
        CONCRETE.add(Material.ORANGE_CONCRETE);
        CONCRETE.add(Material.BLACK_CONCRETE);
        CONCRETE.add(Material.BROWN_CONCRETE);
        CONCRETE.add(Material.BLUE_CONCRETE);
        CONCRETE.add(Material.WHITE_CONCRETE);
    }

    static {
        CONCRETE_POWDER = new ArrayList<>();
        CONCRETE_POWDER.add(Material.RED_CONCRETE_POWDER);
        CONCRETE_POWDER.add(Material.GREEN_CONCRETE_POWDER);
        CONCRETE_POWDER.add(Material.PURPLE_CONCRETE_POWDER);
        CONCRETE_POWDER.add(Material.CYAN_CONCRETE_POWDER);
        CONCRETE_POWDER.add(Material.LIGHT_GRAY_CONCRETE_POWDER);
        CONCRETE_POWDER.add(Material.GRAY_CONCRETE_POWDER);
        CONCRETE_POWDER.add(Material.PINK_CONCRETE_POWDER);
        CONCRETE_POWDER.add(Material.LIME_CONCRETE_POWDER);
        CONCRETE_POWDER.add(Material.YELLOW_CONCRETE_POWDER);
        CONCRETE_POWDER.add(Material.LIGHT_BLUE_CONCRETE_POWDER);
        CONCRETE_POWDER.add(Material.MAGENTA_CONCRETE_POWDER);
        CONCRETE_POWDER.add(Material.ORANGE_CONCRETE_POWDER);
        CONCRETE_POWDER.add(Material.BLACK_CONCRETE_POWDER);
        CONCRETE_POWDER.add(Material.BROWN_CONCRETE_POWDER);
        CONCRETE_POWDER.add(Material.BLUE_CONCRETE_POWDER);
        CONCRETE_POWDER.add(Material.WHITE_CONCRETE_POWDER);
    }

    static {
        STAINED_GLASS_TO_DYE = new HashMap<>();
        STAINED_GLASS_TO_DYE.put(Material.RED_STAINED_GLASS, Material.RED_DYE);
        STAINED_GLASS_TO_DYE.put(Material.GREEN_STAINED_GLASS, Material.GREEN_DYE);
        STAINED_GLASS_TO_DYE.put(Material.PURPLE_STAINED_GLASS, Material.PURPLE_DYE);
        STAINED_GLASS_TO_DYE.put(Material.CYAN_STAINED_GLASS, Material.CYAN_DYE);
        STAINED_GLASS_TO_DYE.put(Material.LIGHT_GRAY_STAINED_GLASS, Material.LIGHT_GRAY_DYE);
        STAINED_GLASS_TO_DYE.put(Material.GRAY_STAINED_GLASS, Material.GRAY_DYE);
        STAINED_GLASS_TO_DYE.put(Material.PINK_STAINED_GLASS, Material.PINK_DYE);
        STAINED_GLASS_TO_DYE.put(Material.LIME_STAINED_GLASS, Material.LIME_DYE);
        STAINED_GLASS_TO_DYE.put(Material.YELLOW_STAINED_GLASS, Material.YELLOW_DYE);
        STAINED_GLASS_TO_DYE.put(Material.LIGHT_BLUE_STAINED_GLASS, Material.LIGHT_BLUE_DYE);
        STAINED_GLASS_TO_DYE.put(Material.MAGENTA_STAINED_GLASS, Material.MAGENTA_DYE);
        STAINED_GLASS_TO_DYE.put(Material.ORANGE_STAINED_GLASS, Material.ORANGE_DYE);
        STAINED_GLASS_TO_DYE.put(Material.BLACK_STAINED_GLASS, Material.BLACK_DYE);
        STAINED_GLASS_TO_DYE.put(Material.BROWN_STAINED_GLASS, Material.BROWN_DYE);
        STAINED_GLASS_TO_DYE.put(Material.BLUE_STAINED_GLASS, Material.BLUE_DYE);
        STAINED_GLASS_TO_DYE.put(Material.WHITE_STAINED_GLASS, Material.WHITE_DYE);
    }

    static {
        STAINED_GLASS_PANE_TO_DYE = new HashMap<>();
        STAINED_GLASS_PANE_TO_DYE.put(Material.RED_STAINED_GLASS_PANE, Material.RED_DYE);
        STAINED_GLASS_PANE_TO_DYE.put(Material.GREEN_STAINED_GLASS_PANE, Material.GREEN_DYE);
        STAINED_GLASS_PANE_TO_DYE.put(Material.PURPLE_STAINED_GLASS_PANE, Material.PURPLE_DYE);
        STAINED_GLASS_PANE_TO_DYE.put(Material.CYAN_STAINED_GLASS_PANE, Material.CYAN_DYE);
        STAINED_GLASS_PANE_TO_DYE.put(Material.LIGHT_GRAY_STAINED_GLASS_PANE, Material.LIGHT_GRAY_DYE);
        STAINED_GLASS_PANE_TO_DYE.put(Material.GRAY_STAINED_GLASS_PANE, Material.GRAY_DYE);
        STAINED_GLASS_PANE_TO_DYE.put(Material.PINK_STAINED_GLASS_PANE, Material.PINK_DYE);
        STAINED_GLASS_PANE_TO_DYE.put(Material.LIME_STAINED_GLASS_PANE, Material.LIME_DYE);
        STAINED_GLASS_PANE_TO_DYE.put(Material.YELLOW_STAINED_GLASS_PANE, Material.YELLOW_DYE);
        STAINED_GLASS_PANE_TO_DYE.put(Material.LIGHT_BLUE_STAINED_GLASS_PANE, Material.LIGHT_BLUE_DYE);
        STAINED_GLASS_PANE_TO_DYE.put(Material.MAGENTA_STAINED_GLASS_PANE, Material.MAGENTA_DYE);
        STAINED_GLASS_PANE_TO_DYE.put(Material.ORANGE_STAINED_GLASS_PANE, Material.ORANGE_DYE);
        STAINED_GLASS_PANE_TO_DYE.put(Material.BLACK_STAINED_GLASS_PANE, Material.BLACK_DYE);
        STAINED_GLASS_PANE_TO_DYE.put(Material.BROWN_STAINED_GLASS_PANE, Material.BROWN_DYE);
        STAINED_GLASS_PANE_TO_DYE.put(Material.BLUE_STAINED_GLASS_PANE, Material.BLUE_DYE);
        STAINED_GLASS_PANE_TO_DYE.put(Material.WHITE_STAINED_GLASS_PANE, Material.WHITE_DYE);
    }

    static {
        TERRACOTTA_TO_DYE = new HashMap<>();
        TERRACOTTA_TO_DYE.put(Material.RED_TERRACOTTA, Material.RED_DYE);
        TERRACOTTA_TO_DYE.put(Material.GREEN_TERRACOTTA, Material.GREEN_DYE);
        TERRACOTTA_TO_DYE.put(Material.PURPLE_TERRACOTTA, Material.PURPLE_DYE);
        TERRACOTTA_TO_DYE.put(Material.CYAN_TERRACOTTA, Material.CYAN_DYE);
        TERRACOTTA_TO_DYE.put(Material.LIGHT_GRAY_TERRACOTTA, Material.LIGHT_GRAY_DYE);
        TERRACOTTA_TO_DYE.put(Material.GRAY_TERRACOTTA, Material.GRAY_DYE);
        TERRACOTTA_TO_DYE.put(Material.PINK_TERRACOTTA, Material.PINK_DYE);
        TERRACOTTA_TO_DYE.put(Material.LIME_TERRACOTTA, Material.LIME_DYE);
        TERRACOTTA_TO_DYE.put(Material.YELLOW_TERRACOTTA, Material.YELLOW_DYE);
        TERRACOTTA_TO_DYE.put(Material.LIGHT_BLUE_TERRACOTTA, Material.LIGHT_BLUE_DYE);
        TERRACOTTA_TO_DYE.put(Material.MAGENTA_TERRACOTTA, Material.MAGENTA_DYE);
        TERRACOTTA_TO_DYE.put(Material.ORANGE_TERRACOTTA, Material.ORANGE_DYE);
        TERRACOTTA_TO_DYE.put(Material.BLACK_TERRACOTTA, Material.BLACK_DYE);
        TERRACOTTA_TO_DYE.put(Material.BROWN_TERRACOTTA, Material.BROWN_DYE);
        TERRACOTTA_TO_DYE.put(Material.BLUE_TERRACOTTA, Material.BLUE_DYE);
        TERRACOTTA_TO_DYE.put(Material.WHITE_TERRACOTTA, Material.WHITE_DYE);
    }

    static {
        GLAZED_TERRACOTTA_TO_DYE = new HashMap<>();
        GLAZED_TERRACOTTA_TO_DYE.put(Material.RED_GLAZED_TERRACOTTA, Material.RED_DYE);
        GLAZED_TERRACOTTA_TO_DYE.put(Material.GREEN_GLAZED_TERRACOTTA, Material.GREEN_DYE);
        GLAZED_TERRACOTTA_TO_DYE.put(Material.PURPLE_GLAZED_TERRACOTTA, Material.PURPLE_DYE);
        GLAZED_TERRACOTTA_TO_DYE.put(Material.CYAN_GLAZED_TERRACOTTA, Material.CYAN_DYE);
        GLAZED_TERRACOTTA_TO_DYE.put(Material.LIGHT_GRAY_GLAZED_TERRACOTTA, Material.LIGHT_GRAY_DYE);
        GLAZED_TERRACOTTA_TO_DYE.put(Material.GRAY_GLAZED_TERRACOTTA, Material.GRAY_DYE);
        GLAZED_TERRACOTTA_TO_DYE.put(Material.PINK_GLAZED_TERRACOTTA, Material.PINK_DYE);
        GLAZED_TERRACOTTA_TO_DYE.put(Material.LIME_GLAZED_TERRACOTTA, Material.LIME_DYE);
        GLAZED_TERRACOTTA_TO_DYE.put(Material.YELLOW_GLAZED_TERRACOTTA, Material.YELLOW_DYE);
        GLAZED_TERRACOTTA_TO_DYE.put(Material.LIGHT_BLUE_GLAZED_TERRACOTTA, Material.LIGHT_BLUE_DYE);
        GLAZED_TERRACOTTA_TO_DYE.put(Material.MAGENTA_GLAZED_TERRACOTTA, Material.MAGENTA_DYE);
        GLAZED_TERRACOTTA_TO_DYE.put(Material.ORANGE_GLAZED_TERRACOTTA, Material.ORANGE_DYE);
        GLAZED_TERRACOTTA_TO_DYE.put(Material.BLACK_GLAZED_TERRACOTTA, Material.BLACK_DYE);
        GLAZED_TERRACOTTA_TO_DYE.put(Material.BROWN_GLAZED_TERRACOTTA, Material.BROWN_DYE);
        GLAZED_TERRACOTTA_TO_DYE.put(Material.BLUE_GLAZED_TERRACOTTA, Material.BLUE_DYE);
        GLAZED_TERRACOTTA_TO_DYE.put(Material.WHITE_GLAZED_TERRACOTTA, Material.WHITE_DYE);
    }

    static {
        CONCRETE_TO_DYE = new HashMap<>();
        CONCRETE_TO_DYE.put(Material.RED_CONCRETE, Material.RED_DYE);
        CONCRETE_TO_DYE.put(Material.GREEN_CONCRETE, Material.GREEN_DYE);
        CONCRETE_TO_DYE.put(Material.PURPLE_CONCRETE, Material.PURPLE_DYE);
        CONCRETE_TO_DYE.put(Material.CYAN_CONCRETE, Material.CYAN_DYE);
        CONCRETE_TO_DYE.put(Material.LIGHT_GRAY_CONCRETE, Material.LIGHT_GRAY_DYE);
        CONCRETE_TO_DYE.put(Material.GRAY_CONCRETE, Material.GRAY_DYE);
        CONCRETE_TO_DYE.put(Material.PINK_CONCRETE, Material.PINK_DYE);
        CONCRETE_TO_DYE.put(Material.LIME_CONCRETE, Material.LIME_DYE);
        CONCRETE_TO_DYE.put(Material.YELLOW_CONCRETE, Material.YELLOW_DYE);
        CONCRETE_TO_DYE.put(Material.LIGHT_BLUE_CONCRETE, Material.LIGHT_BLUE_DYE);
        CONCRETE_TO_DYE.put(Material.MAGENTA_CONCRETE, Material.MAGENTA_DYE);
        CONCRETE_TO_DYE.put(Material.ORANGE_CONCRETE, Material.ORANGE_DYE);
        CONCRETE_TO_DYE.put(Material.BLACK_CONCRETE, Material.BLACK_DYE);
        CONCRETE_TO_DYE.put(Material.BROWN_CONCRETE, Material.BROWN_DYE);
        CONCRETE_TO_DYE.put(Material.BLUE_CONCRETE, Material.BLUE_DYE);
        CONCRETE_TO_DYE.put(Material.WHITE_CONCRETE, Material.WHITE_DYE);
    }

    static {
        CONCRETE_POWDER_TO_DYE = new HashMap<>();
        CONCRETE_POWDER_TO_DYE.put(Material.RED_CONCRETE_POWDER, Material.RED_DYE);
        CONCRETE_POWDER_TO_DYE.put(Material.GREEN_CONCRETE_POWDER, Material.GREEN_DYE);
        CONCRETE_POWDER_TO_DYE.put(Material.PURPLE_CONCRETE_POWDER, Material.PURPLE_DYE);
        CONCRETE_POWDER_TO_DYE.put(Material.CYAN_CONCRETE_POWDER, Material.CYAN_DYE);
        CONCRETE_POWDER_TO_DYE.put(Material.LIGHT_GRAY_CONCRETE_POWDER, Material.LIGHT_GRAY_DYE);
        CONCRETE_POWDER_TO_DYE.put(Material.GRAY_CONCRETE_POWDER, Material.GRAY_DYE);
        CONCRETE_POWDER_TO_DYE.put(Material.PINK_CONCRETE_POWDER, Material.PINK_DYE);
        CONCRETE_POWDER_TO_DYE.put(Material.LIME_CONCRETE_POWDER, Material.LIME_DYE);
        CONCRETE_POWDER_TO_DYE.put(Material.YELLOW_CONCRETE_POWDER, Material.YELLOW_DYE);
        CONCRETE_POWDER_TO_DYE.put(Material.LIGHT_BLUE_CONCRETE_POWDER, Material.LIGHT_BLUE_DYE);
        CONCRETE_POWDER_TO_DYE.put(Material.MAGENTA_CONCRETE_POWDER, Material.MAGENTA_DYE);
        CONCRETE_POWDER_TO_DYE.put(Material.ORANGE_CONCRETE_POWDER, Material.ORANGE_DYE);
        CONCRETE_POWDER_TO_DYE.put(Material.BLACK_CONCRETE_POWDER, Material.BLACK_DYE);
        CONCRETE_POWDER_TO_DYE.put(Material.BROWN_CONCRETE_POWDER, Material.BROWN_DYE);
        CONCRETE_POWDER_TO_DYE.put(Material.BLUE_CONCRETE_POWDER, Material.BLUE_DYE);
        CONCRETE_POWDER_TO_DYE.put(Material.WHITE_CONCRETE_POWDER, Material.WHITE_DYE);
    }

}
