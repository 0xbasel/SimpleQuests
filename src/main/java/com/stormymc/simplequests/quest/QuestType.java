package com.stormymc.simplequests.quest;

public enum QuestType {

    DAILY(100), WEEKLY(500);

    private final int reward;

    QuestType(int reward) {
        this.reward = reward;
    }

    public int getReward() {
        return reward;
    }
}
