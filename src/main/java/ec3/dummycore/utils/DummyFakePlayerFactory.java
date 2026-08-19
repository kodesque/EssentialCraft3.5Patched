package ec3.dummycore.utils;

import com.mojang.authlib.GameProfile;

import java.util.Hashtable;
import java.util.UUID;

public class DummyFakePlayerFactory {
    public static Hashtable<Class<?>, GameProfile> fakeProfiles = new Hashtable();

    public DummyFakePlayerFactory() {
    }

    public static GameProfile getGameProfile(Class<?> mod) {
        if (fakeProfiles.get(mod) == null) {
            fakeProfiles.put(mod, new GameProfile(UUID.randomUUID(), "[DC][" + mod.getSimpleName() + "]"));
        }

        return (GameProfile)fakeProfiles.get(mod);
    }
}
