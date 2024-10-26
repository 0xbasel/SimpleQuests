package com.stormymc.simplequests.profile;

import java.util.UUID;

public class Profile {

    private final UUID uniqueId;
    private int coins;

    public Profile(UUID uniqueId) {
        this.uniqueId = uniqueId;
    }

    public UUID getUniqueId() {
        return uniqueId;
    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    @Override
    public String toString() {
        return "Profile{" +
                "uniqueId=" + uniqueId +
                ", coins=" + coins +
                '}';
    }
}
