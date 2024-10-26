package com.stormymc.simplequests.quest;

import com.stormymc.simplequests.SimpleQuests;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;

public abstract class Quest implements Listener {

    private final String description;
    private final QuestType type;
    private final int goal;

    public Quest(String description, QuestType type, int goal) {
        this.description = description;
        this.type = type;
        this.goal = goal;
    }

    public String getDescription() {
        return description;
    }

    public QuestType getType() {
        return type;
    }

    public int getGoal() {
        return goal;
    }

    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this, SimpleQuests.getInstance());
    }

    public void onDisable() {
        HandlerList.unregisterAll(this);
    }

    public abstract boolean isCompleted(Player player);
}
