package xyz.fluxinc.moddedadditions.hooks;

import com.gamingmesh.jobs.CMILib.CMIMaterial;
import com.gamingmesh.jobs.Jobs;
import com.gamingmesh.jobs.actions.BlockActionInfo;
import com.gamingmesh.jobs.container.ActionType;
import com.gamingmesh.jobs.container.JobsPlayer;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.BlockState;
import org.bukkit.entity.Player;

import java.util.List;

public class JobsRebornHook {

    private static Jobs plugin;

    /**
     * Registers the Jobs Plugin
     * @param jobs The instance of the jobs plugin
     */
    public static void registerJobs(Jobs jobs) {
        plugin = jobs;
    }

    public static boolean isJobsRegistered() { return plugin != null; }

    /**
     * Add jobs experience and money for block states
     * @param blocks a list of block states
     * @param player player to adjust
     */
    public static void addExperienceForBlocks(List<BlockState> blocks, Player player) {
        if (plugin == null) return;
        for (BlockState blockState : blocks) {
            BlockActionInfo bInfo = new BlockActionInfo(blockState.getBlock(), ActionType.BREAK);
            Jobs.action(Jobs.getPlayerManager().getJobsPlayer(player), bInfo, blockState.getBlock());
        }
    }

    public static void addExperienceForBlocks(Block block, BlockActionInfo info, Player player) {
        if (plugin == null) return;

        Jobs.action(Jobs.getPlayerManager().getJobsPlayer(player), info, block);
    }


}
