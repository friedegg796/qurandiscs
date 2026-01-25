package name.modid;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.ModelTemplates;
import name.modid.Item.ModItems;


public class QurandiscsModelProvider extends FabricModelProvider {
    public QurandiscsModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockStateModelGenerator) {
    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerator) {
        itemModelGenerator.generateFlatItem(ModItems.fathia, ModelTemplates.FLAT_ITEM);
        //ModItems takes from wanderingmuslim.qurandiscs.item.moditems
    }

    @Override
    public String getName() {
        return "Qurandiscs";
    }
}

