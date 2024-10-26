package com.stormymc.simplequests;

import com.stormymc.simplequests.profile.ProfileListener;
import com.stormymc.simplequests.profile.ProfileManager;
import com.stormymc.simplequests.quest.QuestManager;
import com.stormymc.simplequests.quest.QuestsCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class SimpleQuests extends JavaPlugin {

    public static SimpleQuests instance;

    public static SimpleQuests getInstance() {
        return instance;
    }

    private ProfileManager profileManager;
    private QuestManager questManager;

    @Override
    public void onEnable() {
        instance = this;

        profileManager = new ProfileManager();
        questManager = new QuestManager();

        getServer().getPluginManager().registerEvents(new ProfileListener(profileManager), this);

        getCommand("quests").setExecutor(new QuestsCommand(questManager));
    }

    public ProfileManager getProfileManager() {
        return profileManager;
    }

    public QuestManager getQuestManager() {
        return questManager;
    }
}
