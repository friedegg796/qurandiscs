package name.modid;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.core.HolderLookup;

import java.util.concurrent.CompletableFuture;

public class QurandiscsEnglishLangProvider extends FabricLanguageProvider {//THEY NEED PROPER NAMES TO WORK!

    public QurandiscsEnglishLangProvider(FabricDataOutput dataOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
        // Only use protecc if they're near each other, otherwise use public
        super(dataOutput, "en_us", registryLookup);
    }

    @Override
    public void generateTranslations(HolderLookup.Provider wrapperLookup, FabricLanguageProvider.TranslationBuilder translationBuilder) {
        translationBuilder.add("itemGroup.qurandiscs", "Quran Discs");
        translationBuilder.add("item.minecraft.fathia", "Surah Fathia Disc");
        translationBuilder.add("item.minecraft.fathia.desc", "Surah Fathia Disc");
    }

}





