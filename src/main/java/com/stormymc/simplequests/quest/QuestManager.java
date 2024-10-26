package com.stormymc.simplequests.quest;

import org.bukkit.Material;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuestManager {

    private final List<Quest> quests = new ArrayList<>();

    public QuestManager() {
        quests.addAll(Arrays.asList(
                new KillQuest("Kill 1 players using DIAMOND_SWORD", QuestType.DAILY, 1, Material.DIAMOND_SWORD),
                new KillQuest("Kill 1 players", QuestType.DAILY, 1, null)
        ));
        quests.forEach(Quest::onEnable);
    }

    public List<Quest> getQuests() {
        return quests;
    }
}
