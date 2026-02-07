package name.modid.Item;

import name.modid.Qurandiscs;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.JukeboxSong;

import static name.modid.Qurandiscs.MOD_ID;

public class CustomSounds { // basically we put all of our old registry things here for simplification!
    private CustomSounds() {
        // private empty constructor to avoid accidental instantiation, remember, default construction = default usage of class!!!
        // Reminds me of C, where we put an empty or so function at the top so the compiler recognizes it's existence!!
    }


    //static ResourceKey<JukeboxSong> fathia_disc = registerQuran("fathia_disc");
    public final SoundEvent fathia = registerSound("fathia_disc");


    // our functions are below
    public static ResourceKey<JukeboxSong> registerQuran(String disc) {
        return ResourceKey.create(Registries.JUKEBOX_SONG, Identifier.fromNamespaceAndPath(MOD_ID, disc));
    } // aka takes the name of a disc and turns it into a qurandisc


    private static SoundEvent registerSound(String id) { //returns SoundEvent
        Identifier identifier = Identifier.fromNamespaceAndPath(MOD_ID, id);
        return Registry.register(BuiltInRegistries.SOUND_EVENT, identifier, SoundEvent.createVariableRangeEvent(identifier));
    }

    public static void initialize() {
        Qurandiscs.LOGGER.info("Registering " + MOD_ID + " Sounds");
    }
}
