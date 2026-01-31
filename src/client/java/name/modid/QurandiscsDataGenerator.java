package name.modid;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class QurandiscsDataGenerator implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
        pack.addProvider(QurandiscsEnglishLangProvider::new);
        pack.addProvider(QurandiscsModelProvider::new);
        pack.addProvider(QurandiscsTagProvider::new);
    }
}
