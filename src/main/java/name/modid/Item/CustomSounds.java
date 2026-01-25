package name.modid.Item;

import name.modid.Qurandiscs;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.JukeboxPlayable;
import net.minecraft.world.item.JukeboxSong;

import static name.modid.Qurandiscs.MOD_ID;


public class CustomSounds { // basically we put all of our old registry things here for simplification!
    private CustomSounds() {
        // private empty constructor to avoid accidental instantiation, remember, construction = default usage of class!!!
    }

    public static final SoundEvent fathia = registerSound("surah_fathia");
    //public static final Registry<JukeboxSong> fathia_key = RegistryKey.of(RegistryKeys.JUKEBOX_SONG, Identifier.of(MOD_ID, "surah_fathia"));

    private static SoundEvent registerSound(String id) { //returns SoundEvent
        Identifier identifier = Identifier.fromNamespaceAndPath(MOD_ID, id);
        return Registry.register(BuiltInRegistries.SOUND_EVENT, identifier, SoundEvent.createVariableRangeEvent(identifier));
    }

    public static void initialize() {
        Qurandiscs.LOGGER.info("Registering " + MOD_ID + " Sounds");
    }
}
