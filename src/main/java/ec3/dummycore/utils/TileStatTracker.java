package ec3.dummycore.utils;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TileStatTracker {
    public TileEntity trackedTile;
    public NBTTagCompound trackedTag;

    public TileStatTracker(TileEntity tracked) {
        this.trackedTile = tracked;
    }

    public boolean tileNeedsSyncing() {
        if (this.trackedTile == null) {
            return false;
        } else {
            NBTTagCompound currentTag = new NBTTagCompound();
            if (this.trackedTag == null) {
                this.trackedTag = new NBTTagCompound();
                this.trackedTile.func_145841_b(this.trackedTag);
                return true;
            } else {
                this.trackedTile.func_145841_b(currentTag);
                if (currentTag.equals(this.trackedTag)) {
                    this.trackedTile.func_145841_b(this.trackedTag);
                    return false;
                } else {
                    this.trackedTile.func_145841_b(this.trackedTag);
                    return true;
                }
            }
        }
    }
}
