package ec3.common.blocks;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ec3.api.config.Config;
import ec3.common.init.ECItems;
import ec3.common.tile.crafting.TileWeaponMaker;
import ec3.root.EssentialCraftCore;
import ec3.utils.dummycore.utils.MiscUtils;

public class BlockWeaponMaker extends BlockContainer {

    public IIcon[] blockIcons = new IIcon[2];

    public BlockWeaponMaker() {
        super(Material.rock);
    }

    public int damageDropped(int meta) {
        return meta;
    }

    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister p_149651_1_) {
        this.blockIcons[0] = p_149651_1_.registerIcon("essentialcraft:fortifiedStone");
        this.blockIcons[1] = p_149651_1_.registerIcon("essentialcraft:weaponBench");
    }

    public IIcon getIcon(int side, int par2) {
        return side == 1 ? blockIcons[1] : blockIcons[0];
    }

    @Override
    public void breakBlock(World par1World, int par2, int par3, int par4, Block par5, int par6) {
        MiscUtils.dropItemsOnBlockBreak(par1World, par2, par3, par4, par5, par6);
        super.breakBlock(par1World, par2, par3, par4, par5, par6);
    }

    @Override
    public TileEntity createNewTileEntity(World p_149915_1_, int metadata) {
        return new TileWeaponMaker();
    }

    @Override
    public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer,
        int par6, float par7, float par8, float par9) {
        if (par1World.isRemote) {
            return true;
        } else {
            if (!par5EntityPlayer.isSneaking()) {
                par5EntityPlayer.openGui(EssentialCraftCore.core, Config.guiID[0], par1World, par2, par3, par4);
                return true;
            } else {
                return false;
            }
        }
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
        switch (par1ItemStack.getItemDamage()) {
            case 0: {
                par3List.add(new ItemStack(ECItems.pistol).getDisplayName());
                break;
            }
            case 1: {
                par3List.add(new ItemStack(ECItems.rifle).getDisplayName());
                break;
            }
            case 2: {
                par3List.add(new ItemStack(ECItems.sniper).getDisplayName());
                break;
            }
            case 3: {
                par3List.add(new ItemStack(ECItems.gatling).getDisplayName());
                break;
            }
        }
    }

}
