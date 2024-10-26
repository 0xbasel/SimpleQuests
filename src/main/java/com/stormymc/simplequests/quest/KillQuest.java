package com.stormymc.simplequests.quest;

import com.stormymc.simplequests.SimpleQuests;
import com.stormymc.simplequests.profile.Profile;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.PlayerDeathEvent;

import java.util.*;

public class KillQuest extends Quest {

    private final Material using;

    private final Map<UUID, Integer> progress = new HashMap<>();

    public KillQuest(String description, QuestType type, int goal, Material using) {
        super(description, type, goal);
        this.using = using;
    }

    public Material getUsing() {
        return using;
    }

    public Map<UUID, Integer> getProgress() {
        return progress;
    }

    @Override
    public boolean isCompleted(Player player) {
        return progress.getOrDefault(player.getUniqueId(), 0) >= getGoal();
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        Player killer = event.getEntity().getKiller();

        // Early return if there’s no killer, they have already completed the task, or they are not using the required item
        if (killer == null || isCompleted(killer) || (using != null && killer.getItemInHand().getType() != using)) {
            return;
        }

        int currentProgress = progress.compute(killer.getUniqueId(), (uuid, value) -> value == null ? 1 : value + 1);

        if (currentProgress == getGoal()) {
            killer.sendMessage("You have completed the Quest!");

            // Reward the player and stuff like that
            Profile profile = SimpleQuests.getInstance().getProfileManager().getProfiles().get(killer.getUniqueId());
            profile.setCoins(profile.getCoins() + getType().getReward());
        }
    }
}
