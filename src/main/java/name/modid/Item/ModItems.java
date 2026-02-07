package name.modid.Item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.*;
import org.spongepowered.include.com.google.common.base.Function;

import static name.modid.Qurandiscs.MOD_ID;


public class ModItems {
    public static <GenericItem extends Item> GenericItem register(String name, Function<Item.Properties, GenericItem> itemFactory, Item.Properties settings) {
        // Create the item key.
        ResourceKey<Item> itemKey = ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(MOD_ID, name));

        // Create the item instance.
        GenericItem item = itemFactory.apply(settings.setId(itemKey));

        // Register the item.
        Registry.register(BuiltInRegistries.ITEM, itemKey, item);

        return item;
    }


    public static final Item fathia_disc = register("fathia_disc", properties -> properties != null ? new Item(properties) : null, new Item.Properties()
                    .stacksTo(1)
                    .rarity(Rarity.UNCOMMON)
                    .jukeboxPlayable(CustomSounds.registerQuran("fathia_disc"))
            //JukeboxSongs.ELEVEN
    );


    public static final ResourceKey<CreativeModeTab> CUSTOM_ITEM_GROUP_KEY = ResourceKey.create(BuiltInRegistries.CREATIVE_MODE_TAB.key(), Identifier.fromNamespaceAndPath(MOD_ID, "item_group"));
    public static final CreativeModeTab CUSTOM_ITEM_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(ModItems.fathia_disc))
            .title(Component.translatable("itemGroup.qurandiscs"))
            .build(); // all the .things mean that they are a part of FabricItemGroup.builder, with ; ending them.


    public static void initialize() {
        // Get the event for modifying entries in the ingredients group.
        // And register an event handler that adds our suspicious item to the ingredients group.
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.TOOLS_AND_UTILITIES) // you change this part if you wanna put it in other tabs
                .register((itemGroup) -> itemGroup.accept(ModItems.fathia_disc));


        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, CUSTOM_ITEM_GROUP_KEY, CUSTOM_ITEM_GROUP);
        //Registry.register(BuiltInRegistries.SOUND_EVENT, Identifier.fromNamespaceAndPath(MOD_ID, "fathia_disc"),
        //SoundEvent.createVariableRangeEvent(Identifier.fromNamespaceAndPath(MOD_ID, "fathia_disc")));

        ItemGroupEvents.modifyEntriesEvent(CUSTOM_ITEM_GROUP_KEY).register(itemGroup -> {
            itemGroup.accept(ModItems.fathia_disc); // within the register (itemgroup because of ->
        });
    }
}

