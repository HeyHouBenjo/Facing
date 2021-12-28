package com.benjocraeft.facing;

import org.bukkit.Axis;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.data.Orientable;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.plugin.java.JavaPlugin;


public final class Facing extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
        getLogger().info("Facing enabled");
    }

    @EventHandler
    public void onBlockPlaced(BlockPlaceEvent event){
        Block block = event.getBlockPlaced();
        if (block.getType() == Material.DEEPSLATE){
            Orientable orientation = (Orientable)block.getBlockData();
            orientation.setAxis(Axis.Y);
            block.setBlockData(orientation);
        }
    }

    @Override
    public void onDisable() {
        getLogger().info("Facing disabled");
    }
}
