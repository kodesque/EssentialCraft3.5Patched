package ec3.common.items;

import net.minecraft.item.ItemRecord;
import net.minecraft.util.ResourceLocation;

public class ItemRecordMod extends ItemRecord {

    public ItemRecordMod(String p_i45350_1_) {
        super(p_i45350_1_);
        // TODO Auto-generated constructor stub
    }

    public ResourceLocation getRecordResource(String name) {
        return new ResourceLocation("essentialcraft:" + name);
    }
}
