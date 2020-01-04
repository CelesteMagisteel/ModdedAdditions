package xyz.fluxinc.moddedadditions.controllers;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.ItemMeta;
import xyz.fluxinc.fluxcore.configuration.ConfigurationManager;
import xyz.fluxinc.moddedadditions.ModdedAdditions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static xyz.fluxinc.fluxcore.utils.BlockUtils.convertStringToMaterial;

public class AreaToolController {

    private ModdedAdditions instance;
    private YamlConfiguration areaToolConfiguration;
    private List<Material> hammerBlocks;
    private List<Material> excavatorBlocks;
    private static final String CONFIG_NAME = "areatool.yml";
    private static final String HAMMER_CONFIG_KEY = "hammer";
    private static final String EXCAVATOR_CONFIG_KEY = "excavator";


    public AreaToolController(ModdedAdditions instance) {
        this.instance = instance;
        areaToolConfiguration = new ConfigurationManager<>(this.instance, CONFIG_NAME).getConfig();
        loadFromConfiguration();
    }

    public boolean checkHammer(Material material) {
        return hammerBlocks.contains(material);
    }

    public boolean checkExcavator(Material material) {
        return excavatorBlocks.contains(material);
    }

    public void addHammerBlock(Material material) {
        hammerBlocks.add(material);
        areaToolConfiguration.set(HAMMER_CONFIG_KEY, hammerBlocks.toArray());
        saveConfiguration();
    }

    public void removeHammerBlock(Material material) {
        hammerBlocks.remove(material);
        areaToolConfiguration.set(HAMMER_CONFIG_KEY, hammerBlocks.toArray());
        saveConfiguration();
    }

    public void addExcavatorBlock(Material material) {
        excavatorBlocks.add(material);
        areaToolConfiguration.set(EXCAVATOR_CONFIG_KEY, excavatorBlocks.toArray());
        saveConfiguration();
    }

    public void removeExcavatorBlock(Material material) {
        excavatorBlocks.remove(material);
        areaToolConfiguration.set(EXCAVATOR_CONFIG_KEY, excavatorBlocks.toArray());
        saveConfiguration();
    }

    public static List<Block> getBlockList(Block startingBlock, BlockFace face) {
        // Extract the X Y Z coordinates and world for easy access
        int x = startingBlock.getX();
        int y = startingBlock.getY();
        int z = startingBlock.getZ();
        World world = startingBlock.getWorld();
        // Create a list for the extra blocks
        List<Block> extraBlocks = new ArrayList<>();

        // Switch to get the surrounding blocks based on the block face
        switch (face) {
            case UP:
            case DOWN:
                for (int xMod = -1; xMod < 2; xMod++) {
                    for (int zMod = -1; zMod < 2; zMod++) {
                        extraBlocks.add(world.getBlockAt(x + xMod, y, z + zMod));
                    }
                }
                break;
            case EAST:
            case WEST:
                for (int yMod = -1; yMod < 2; yMod++) {
                    for (int zMod = -1; zMod < 2; zMod++) {
                        extraBlocks.add(world.getBlockAt(x, y + yMod, z + zMod));
                    }
                }
                break;
            case NORTH:
            case SOUTH:
                for (int yMod = -1; yMod < 2; yMod++) {
                    for (int xMod = -1; xMod < 2; xMod++) {
                        extraBlocks.add(world.getBlockAt(x + xMod, y + yMod, z));
                    }
                }
                break;
            default:
                break;
        }
        return extraBlocks;
    }

    public List<Material> getHammerList() { return this.hammerBlocks; }

    public List<Material> getExcavatorList() { return this.excavatorBlocks; }

    public void saveConfiguration() {
        try {
            areaToolConfiguration.save(CONFIG_NAME);
        } catch (IOException e) {
            Bukkit.getLogger().severe("An error occurred whilst saving " + CONFIG_NAME + ": " + e.getMessage());
            Bukkit.getServer().getPluginManager().disablePlugin(this.instance);
        }
    }

    public void loadFromConfiguration() {
        hammerBlocks = convertStringToMaterial(areaToolConfiguration.getStringList(HAMMER_CONFIG_KEY));
        excavatorBlocks = convertStringToMaterial(areaToolConfiguration.getStringList(EXCAVATOR_CONFIG_KEY));
    }
}
