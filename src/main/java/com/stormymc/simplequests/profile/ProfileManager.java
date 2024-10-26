package com.stormymc.simplequests.profile;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ProfileManager {

    private final Map<UUID, Profile> profiles = new HashMap<>();

    public Map<UUID, Profile> getProfiles() {
        return profiles;
    }
}
