package ec3.dummycore.utils;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraftforge.oredict.OreDictionary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UnformedItemStack {
    public List<ItemStack> possibleStacks = new ArrayList();

    public UnformedItemStack() {
    }

    public UnformedItemStack(ItemStack is) {
        this.possibleStacks.add(is);
        this.sort();
    }

    public UnformedItemStack(String oreDictName) {
        this.possibleStacks.addAll(OreDictionary.getOres(oreDictName));
        this.sort();
    }

    public UnformedItemStack(List<ItemStack> lst) {
        this.possibleStacks.addAll(lst);
        this.sort();
    }

    public UnformedItemStack(ItemStack[] stk) {
        this.possibleStacks.addAll(Arrays.asList(stk));
        this.sort();
    }

    public UnformedItemStack(Block b) {
        this.possibleStacks.add(new ItemStack(b, 1, 32767));
        this.sort();
    }

    public UnformedItemStack(Item i) {
        this.possibleStacks.add(new ItemStack(i, 1, 32767));
        this.sort();
    }

    public UnformedItemStack(Object obj) {
        if (obj instanceof ItemStack) {
            this.possibleStacks.add((ItemStack)obj);
        }

        if (obj instanceof String) {
            this.possibleStacks.addAll(OreDictionary.getOres((String)obj));
        }

        if (obj instanceof List) {
            this.possibleStacks.addAll((List)obj);
        }

        if (obj instanceof ItemStack[]) {
            this.possibleStacks.addAll(Arrays.asList((ItemStack[])obj));
        }

        if (obj instanceof Block) {
            this.possibleStacks.add(new ItemStack((Block)obj, 1, 32767));
        }

        if (obj instanceof Item) {
            this.possibleStacks.add(new ItemStack((Item)obj, 1, 32767));
        }

        this.sort();
    }

    public boolean itemStackMatches(ItemStack is) {
        if (is == null) {
            return false;
        } else {
            for(ItemStack s : this.possibleStacks) {
                if (is.func_77969_a(s) || is.func_77973_b().equals(s.func_77973_b()) && s.func_77960_j() == 32767) {
                    return true;
                }
            }

            return false;
        }
    }

    public String toString() {
        String str = "";

        for(ItemStack s : this.possibleStacks) {
            str = str + s;
        }

        return str;
    }

    public DummyCore.Utils.UnformedItemStack copy() {
        return new DummyCore.Utils.UnformedItemStack(this.possibleStacks);
    }

    public void nullify() {
        for(ItemStack s : this.possibleStacks) {
            s.field_77994_a = 0;
        }

    }

    public void sort() {
        List<ItemStack> possibleStacksCopy = new ArrayList();
        possibleStacksCopy.addAll(this.possibleStacks);
        this.possibleStacks.clear();

        for(int i = 0; i < possibleStacksCopy.size(); ++i) {
            ItemStack is = (ItemStack)possibleStacksCopy.get(i);
            if (is != null) {
                this.possibleStacks.add(is);
            }
        }

        possibleStacksCopy.clear();
        possibleStacksCopy = null;
    }

    public ItemStack getISToDraw(long time) {
        int size = this.possibleStacks.size();
        return size <= 0 ? null : (ItemStack)this.possibleStacks.get((int)(time / 30L) % size);
    }

    public void writeToNBTTagCompound(NBTTagCompound tag) {
        NBTTagList items = new NBTTagList();

        for(ItemStack is : this.possibleStacks) {
            NBTTagCompound itemTag = new NBTTagCompound();
            is.func_77955_b(itemTag);
            items.func_74742_a(itemTag);
        }

        tag.func_74782_a("unformedISList", items);
    }

    public void readFromNBTTagCompound(NBTTagCompound tag) {
        NBTTagList items = tag.func_150295_c("unformedISList", 10);

        for(int i = 0; i < items.func_74745_c(); ++i) {
            NBTTagCompound itemTag = items.func_150305_b(i);
            ItemStack is = ItemStack.func_77949_a(itemTag);
            this.possibleStacks.add(is);
        }

        this.sort();
    }
}
