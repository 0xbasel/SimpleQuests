package com.stormymc.simplequests.quest;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class QuestsCommand implements CommandExecutor {

    private final QuestManager questManager;

    public QuestsCommand(QuestManager questManager) {
        this.questManager = questManager;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) return false;

        Player player = (Player) sender;

        for (Quest quest : questManager.getQuests()) {
            if (quest.isCompleted(player)) continue;
            if (quest instanceof KillQuest) {
                player.sendMessage(String.format("%s (%d/%d)", quest.getDescription(), ((KillQuest) quest).getProgress().getOrDefault(player.getUniqueId(), 0), quest.getGoal()));
            } /* else if BowQuest, AssistQuest, etc.. */
        }

        return false;
    }
}
