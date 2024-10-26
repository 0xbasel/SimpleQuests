package com.stormymc.simplequests.profile;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class ProfileListener implements Listener {

    private final ProfileManager profileManager;

    public ProfileListener(ProfileManager profileManager) {
        this.profileManager = profileManager;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        if (!profileManager.getProfiles().containsKey(player.getUniqueId())) {
            profileManager.getProfiles().put(player.getUniqueId(), new Profile(player.getUniqueId()));
        }
    }
}
