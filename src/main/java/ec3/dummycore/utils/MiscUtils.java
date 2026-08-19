package ec3.dummycore.utils;

import DummyCore.Core.CoreInitialiser;
import DummyCore.Utils.BlockPosition;
import DummyCore.Utils.DataStorage;
import DummyCore.Utils.DummyData;
import DummyCore.Utils.DummyPacketHandler;
import DummyCore.Utils.DummyPacketIMSG;
import DummyCore.Utils.DummyPacketIMSG_Tile;
import DummyCore.Utils.ITEHasGameData;
import DummyCore.Utils.Notifier;
import cpw.mods.fml.common.ObfuscationReflectionHelper;
import cpw.mods.fml.relauncher.ReflectionHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.texture.TextureUtil;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemCloth;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.potion.Potion;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.*;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.Chunk;
import net.minecraftforge.client.ForgeHooksClient;
import net.minecraftforge.oredict.OreDictionary;
import org.lwjgl.opengl.GL11;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;

public class MiscUtils {
    public static final String genUUIDString = "CB3F55A9-6DCC-4FF8-AAC7-9B87A33";
    public static Hashtable<String, String> descriptionTable = new Hashtable();
    public static Hashtable<String, EnumChatFormatting> descriptionCTable = new Hashtable();
    public static Hashtable<List<?>, String> descriptionNTable = new Hashtable();
    public static Hashtable<List<?>, EnumChatFormatting> descriptionNCTable = new Hashtable();
    public static Hashtable<String, String> registeredClientData = new Hashtable();
    public static Hashtable<String, String> registeredClientWorldData = new Hashtable();
    public static Hashtable<String, String> registeredServerData = new Hashtable();
    public static Hashtable<String, String> registeredServerWorldData = new Hashtable();
    public static List<DummyCore.Utils.BlockPosition> unbreakableBlocks = new ArrayList();
    public static Hashtable<String, ResourceLocation> locTable = new Hashtable();
    public static final ResourceLocation[] defaultShaders = new ResourceLocation[]{new ResourceLocation("shaders/post/notch.json"), new ResourceLocation("shaders/post/fxaa.json"), new ResourceLocation("shaders/post/art.json"), new ResourceLocation("shaders/post/bumpy.json"), new ResourceLocation("shaders/post/blobs2.json"), new ResourceLocation("shaders/post/pencil.json"), new ResourceLocation("shaders/post/color_convolve.json"), new ResourceLocation("shaders/post/deconverge.json"), new ResourceLocation("shaders/post/flip.json"), new ResourceLocation("shaders/post/invert.json"), new ResourceLocation("shaders/post/ntsc.json"), new ResourceLocation("shaders/post/outline.json"), new ResourceLocation("shaders/post/phosphor.json"), new ResourceLocation("shaders/post/scan_pincushion.json"), new ResourceLocation("shaders/post/sobel.json"), new ResourceLocation("shaders/post/bits.json"), new ResourceLocation("shaders/post/desaturate.json"), new ResourceLocation("shaders/post/green.json"), new ResourceLocation("shaders/post/blur.json"), new ResourceLocation("shaders/post/wobble.json"), new ResourceLocation("shaders/post/blobs.json"), new ResourceLocation("shaders/post/antialias.json")};

    public MiscUtils() {
    }

    @SideOnly(Side.CLIENT)
    public static void bindTexture(String mod, String texture) {
        if (locTable.contains(mod + ":" + texture)) {
            Minecraft.func_71410_x().func_110434_K().func_110577_a((ResourceLocation)locTable.get(mod + ":" + texture));
        } else {
            ResourceLocation loc = new ResourceLocation(mod, texture);
            locTable.put(mod + ":" + texture, loc);
            Minecraft.func_71410_x().func_110434_K().func_110577_a(loc);
        }

    }

    public static void createNBTTag(ItemStack stack) {
        if (!stack.func_77942_o()) {
            NBTTagCompound itemTag = new NBTTagCompound();
            stack.func_77982_d(itemTag);
        }
    }

    public static NBTTagCompound getStackTag(ItemStack stack) {
        createNBTTag(stack);
        return stack.func_77978_p();
    }

    public static void dropItemsOnBlockBreak(World par1World, int par2, int par3, int par4, Block par5, int par6) {
        try {
            IInventory inv = (IInventory)par1World.func_147438_o(par2, par3, par4);
            if (inv != null) {
                for(int j1 = 0; j1 < inv.func_70302_i_(); ++j1) {
                    ItemStack itemstack = inv.func_70301_a(j1);
                    if (itemstack != null) {
                        float f = par1World.field_73012_v.nextFloat() * 0.8F + 0.1F;
                        float f1 = par1World.field_73012_v.nextFloat() * 0.8F + 0.1F;
                        float f2 = par1World.field_73012_v.nextFloat() * 0.8F + 0.1F;

                        while(itemstack.field_77994_a > 0) {
                            int k1 = par1World.field_73012_v.nextInt(21) + 10;
                            if (k1 > itemstack.field_77994_a) {
                                k1 = itemstack.field_77994_a;
                            }

                            itemstack.field_77994_a -= k1;
                            EntityItem entityitem = new EntityItem(par1World, (double)((float)par2 + f), (double)((float)par3 + f1), (double)((float)par4 + f2), new ItemStack(itemstack.func_77973_b(), k1, itemstack.func_77960_j()));
                            if (itemstack.func_77942_o()) {
                                entityitem.func_92059_d().func_77982_d((NBTTagCompound)itemstack.func_77978_p().func_74737_b());
                            }

                            float f3 = 0.05F;
                            entityitem.field_70159_w = (double)((float)par1World.field_73012_v.nextGaussian() * f3);
                            entityitem.field_70181_x = (double)((float)par1World.field_73012_v.nextGaussian() * f3 + 0.2F);
                            entityitem.field_70179_y = (double)((float)par1World.field_73012_v.nextGaussian() * f3);
                            par1World.func_72838_d(entityitem);
                        }
                    }
                }
            }

        } catch (Exception ex) {
            Notifier.notifyCustomMod("DummyCore", "[ERROR]Trying to drop items upon block breaking, but caught an exception:");
            ex.printStackTrace();
        }
    }

    public static boolean oreDictionaryContains(String oreName) {
        return !OreDictionary.getOres(oreName).isEmpty();
    }

    public static void syncTileEntity(ITEHasGameData t, Side s) {
        String dataString = "||mod:DummyCore.TileSync" + t.getPosition() + t.getData();
        DummyCore.Utils.DummyPacketIMSG simplePacket = new DummyCore.Utils.DummyPacketIMSG(dataString);
        if (s == Side.CLIENT) {
            DummyCore.Utils.DummyPacketHandler.sendToAll(simplePacket);
        }

        if (s == Side.SERVER) {
            DummyCore.Utils.DummyPacketHandler.sendToServer(simplePacket);
        }

    }

    public static void syncTileEntity(NBTTagCompound tileTag, int packetID) {
        DummyCore.Utils.DummyPacketIMSG_Tile simplePacket = new DummyCore.Utils.DummyPacketIMSG_Tile(tileTag);
        CoreInitialiser.network.sendToAll(simplePacket);
    }

    /** @deprecated */
    @Deprecated
    public static void makeItemIgnoreDamage(Item i) {
    }

    /** @deprecated */
    @Deprecated
    public static void registerItemModifier(Item id, int meta, String type, String last5ofUUID, double value, IAttribute attrib, int operation) {
    }

    public static void applyPlayerModifier(EntityPlayer p, IAttribute attrib, String uuidLast5Symbols, double modifier, boolean remove, int operation, String type) {
        if (p.func_110140_aT().func_111151_a(attrib).func_111127_a(UUID.fromString("CB3F55A9-6DCC-4FF8-AAC7-9B87A33" + uuidLast5Symbols)) == null) {
            if (!remove) {
                p.func_110140_aT().func_111151_a(attrib).func_111121_a(new AttributeModifier(UUID.fromString("CB3F55A9-6DCC-4FF8-AAC7-9B87A33" + uuidLast5Symbols), "dam." + type + "." + attrib.func_111108_a(), modifier, operation));
            }
        } else if (remove && p.func_110140_aT().func_111151_a(attrib).func_111127_a(UUID.fromString("CB3F55A9-6DCC-4FF8-AAC7-9B87A33" + uuidLast5Symbols)) != null) {
            p.func_110140_aT().func_111151_a(attrib).func_111124_b(p.func_110140_aT().func_111151_a(attrib).func_111127_a(UUID.fromString("CB3F55A9-6DCC-4FF8-AAC7-9B87A33" + uuidLast5Symbols)));
        }

    }

    public static void registerDescriptionFor(String unlocalisedName, String descr, EnumChatFormatting color) {
        descriptionTable.put(unlocalisedName, descr);
        descriptionCTable.put(unlocalisedName, color);
    }

    public static void registerDescriptionFor(String id, int meta, String descr, EnumChatFormatting color) {
        descriptionNTable.put(Arrays.asList(id, meta), descr);
        descriptionNCTable.put(Arrays.asList(id, meta), color);
    }

    public static void sendPacketToAllAround(World w, Packet pkt, int x, int y, int z, int dimId, double distance) {
        List<EntityPlayer> playerLst = w.func_72872_a(EntityPlayer.class, AxisAlignedBB.func_72330_a((double)x - (double)0.5F, (double)y - (double)0.5F, (double)z - (double)0.5F, (double)x + (double)0.5F, (double)y + (double)0.5F, (double)z + (double)0.5F).func_72314_b(distance, distance, distance));
        if (!playerLst.isEmpty()) {
            for(int i = 0; i < playerLst.size(); ++i) {
                EntityPlayer player = (EntityPlayer)playerLst.get(i);
                if (player instanceof EntityPlayerMP) {
                    if (pkt instanceof S35PacketUpdateTileEntity) {
                        NBTTagCompound tileTag = new NBTTagCompound();
                        w.func_147438_o(x, y, z).func_145841_b(tileTag);
                        CoreInitialiser.network.sendTo(new DummyPacketIMSG_Tile(tileTag, -10), (EntityPlayerMP)player);
                    } else if (player.field_71093_bK == dimId) {
                        ((EntityPlayerMP)player).func_71121_q().func_73046_m().func_71203_ab().func_148540_a(pkt);
                    }
                } else {
                    Notifier.notifyDebug("Trying to send packet " + pkt + " to all around on Client side, probably a bug, ending the packet send try");
                }
            }
        }

    }

    public static void sendPacketToAll(World w, Packet pkt) {
        List<EntityPlayer> playerLst = w.field_73010_i;
        if (!playerLst.isEmpty()) {
            for(int i = 0; i < playerLst.size(); ++i) {
                EntityPlayer player = (EntityPlayer)playerLst.get(i);
                if (player instanceof EntityPlayerMP) {
                    ((EntityPlayerMP)player).field_71135_a.func_147359_a(pkt);
                } else {
                    Notifier.notifyDebug("Trying to send packet " + pkt + " to all on Client side, probably a bug, ending the packet send try");
                }
            }
        }

    }

    public static void sendPacketToAllInDim(World w, Packet pkt, int dimId) {
        List<EntityPlayer> playerLst = w.field_73010_i;
        if (!playerLst.isEmpty()) {
            for(int i = 0; i < playerLst.size(); ++i) {
                EntityPlayer player = (EntityPlayer)playerLst.get(i);
                if (player instanceof EntityPlayerMP) {
                    if (player.field_71093_bK == dimId) {
                        ((EntityPlayerMP)player).field_71135_a.func_147359_a(pkt);
                    }
                } else {
                    Notifier.notifyDebug("Trying to send packet " + pkt + " to all in dimension " + dimId + " on Client side, probably a bug, ending the packet send try");
                }
            }
        }

    }

    public static void sendPacketToPlayer(World w, Packet pkt, EntityPlayer player) {
        if (player instanceof EntityPlayerMP) {
            ((EntityPlayerMP)player).field_71135_a.func_147359_a(pkt);
        } else {
            Notifier.notifyDebug("Trying to send packet " + pkt + " to player " + player + "||" + player.getDisplayName() + " on Client side, probably a bug, ending the packet send try");
        }

    }

    @SideOnly(Side.CLIENT)
    public static boolean drawScaledTexturedRect_Items(int x, int y, IIcon icon, int width, int height, float zLevel) {
        if (icon == null) {
            return false;
        } else {
            bindTexture("minecraft", "textures/atlas/items.png");
            double minU = (double)icon.func_94209_e();
            double maxU = (double)icon.func_94212_f();
            double minV = (double)icon.func_94206_g();
            double maxV = (double)icon.func_94210_h();
            Tessellator tessellator = Tessellator.field_78398_a;
            tessellator.func_78382_b();
            tessellator.func_78374_a((double)(x + 0), (double)(y + height), (double)zLevel, minU, minV + (maxV - minV) * (double)height / (double)16.0F);
            tessellator.func_78374_a((double)(x + width), (double)(y + height), (double)zLevel, minU + (maxU - minU) * (double)width / (double)16.0F, minV + (maxV - minV) * (double)height / (double)16.0F);
            tessellator.func_78374_a((double)(x + width), (double)(y + 0), (double)zLevel, minU + (maxU - minU) * (double)width / (double)16.0F, minV);
            tessellator.func_78374_a((double)(x + 0), (double)(y + 0), (double)zLevel, minU, minV);
            tessellator.func_78381_a();
            return true;
        }
    }

    @SideOnly(Side.CLIENT)
    public static boolean drawScaledTexturedRect(int x, int y, IIcon icon, int width, int height, float zLevel) {
        if (icon == null) {
            return false;
        } else {
            bindTexture("minecraft", "textures/atlas/blocks.png");
            double minU = (double)icon.func_94209_e();
            double maxU = (double)icon.func_94212_f();
            double minV = (double)icon.func_94206_g();
            double maxV = (double)icon.func_94210_h();
            Tessellator tessellator = Tessellator.field_78398_a;
            tessellator.func_78382_b();
            tessellator.func_78374_a((double)(x + 0), (double)(y + height), (double)zLevel, minU, minV + (maxV - minV) * (double)height / (double)16.0F);
            tessellator.func_78374_a((double)(x + width), (double)(y + height), (double)zLevel, minU + (maxU - minU) * (double)width / (double)16.0F, minV + (maxV - minV) * (double)height / (double)16.0F);
            tessellator.func_78374_a((double)(x + width), (double)(y + 0), (double)zLevel, minU + (maxU - minU) * (double)width / (double)16.0F, minV);
            tessellator.func_78374_a((double)(x + 0), (double)(y + 0), (double)zLevel, minU, minV);
            tessellator.func_78381_a();
            return true;
        }
    }

    @SideOnly(Side.CLIENT)
    public static void drawTexture(int x, int y, IIcon icon, int width, int height, float zLevel) {
        for(int i = 0; i < width; i += 16) {
            for(int j = 0; j < height; j += 16) {
                drawScaledTexturedRect(x + i, y + j, icon, Math.min(width - i, 16), Math.min(height - j, 16), zLevel);
            }
        }

        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
    }

    @SideOnly(Side.CLIENT)
    public static void drawTexture_Items(int x, int y, IIcon icon, int width, int height, float zLevel) {
        for(int i = 0; i < width; i += 16) {
            for(int j = 0; j < height; j += 16) {
                drawScaledTexturedRect_Items(x + i, y + j, icon, Math.min(width - i, 16), Math.min(height - j, 16), zLevel);
            }
        }

        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
    }

    public static boolean classHasMethod(Class<?> c, String mName, Class<?>... classes) {
        try {
            Method m = c.getMethod(mName, classes);
            return m != null;
        } catch (Exception var4) {
            return false;
        }
    }

    public static void saveInventory(TileEntity t, NBTTagCompound saveTag) {
        if (t instanceof IInventory) {
            IInventory tile = (IInventory)t;
            NBTTagList nbttaglist = new NBTTagList();

            for(int i = 0; i < tile.func_70302_i_(); ++i) {
                if (tile.func_70301_a(i) != null) {
                    NBTTagCompound nbttagcompound1 = new NBTTagCompound();
                    nbttagcompound1.func_74774_a("Slot", (byte)i);
                    tile.func_70301_a(i).func_77955_b(nbttagcompound1);
                    nbttaglist.func_74742_a(nbttagcompound1);
                }
            }

            saveTag.func_74782_a("Items", nbttaglist);
        }

    }

    public static void loadInventory(TileEntity t, NBTTagCompound loadTag) {
        if (t instanceof IInventory) {
            IInventory tile = (IInventory)t;

            for(int i = 0; i < tile.func_70302_i_(); ++i) {
                tile.func_70299_a(i, (ItemStack)null);
            }

            NBTTagList nbttaglist = loadTag.func_150295_c("Items", 10);

            for(int i = 0; i < nbttaglist.func_74745_c(); ++i) {
                NBTTagCompound nbttagcompound1 = nbttaglist.func_150305_b(i);
                byte b0 = nbttagcompound1.func_74771_c("Slot");
                if (b0 >= 0 && b0 < tile.func_70302_i_()) {
                    tile.func_70299_a(b0, ItemStack.func_77949_a(nbttagcompound1));
                }
            }
        }

    }

    public static void changeBiome(World w, BiomeGenBase biome, int x, int z) {
        Chunk chunk = w.func_72938_d(x, z);
        byte[] b = chunk.func_76605_m();
        byte var10000 = b[(z & 15) << 4 | x & 15];
        byte cbiome = (byte)(biome.field_76756_M & 255);
        b[(z & 15) << 4 | x & 15] = cbiome;
        chunk.func_76616_a(b);
        notifyBiomeChange(x, z, biome.field_76756_M);
    }

    public static void spawnParticlesOnServer(String particleName, float posX, float posY, float posZ, double par5, double par6, double par7) {
        String dataString = "||mod:DummyCore.Particle";
        DummyCore.Utils.DummyData name = new DummyCore.Utils.DummyData("particleName", particleName);
        DummyCore.Utils.DummyData xpos = new DummyCore.Utils.DummyData("positionX", posX);
        DummyCore.Utils.DummyData ypos = new DummyCore.Utils.DummyData("positionX", posY);
        DummyCore.Utils.DummyData zpos = new DummyCore.Utils.DummyData("positionX", posZ);
        DummyCore.Utils.DummyData xmot = new DummyCore.Utils.DummyData("par1", par5);
        DummyCore.Utils.DummyData ymot = new DummyCore.Utils.DummyData("par2", par6);
        DummyCore.Utils.DummyData zmot = new DummyCore.Utils.DummyData("par3", par7);
        DummyCore.Utils.DataStorage.addDataToString(name);
        DummyCore.Utils.DataStorage.addDataToString(xpos);
        DummyCore.Utils.DataStorage.addDataToString(ypos);
        DummyCore.Utils.DataStorage.addDataToString(zpos);
        DummyCore.Utils.DataStorage.addDataToString(xmot);
        DummyCore.Utils.DataStorage.addDataToString(ymot);
        DummyCore.Utils.DataStorage.addDataToString(zmot);
        String newDataString = DummyCore.Utils.DataStorage.getDataString();
        dataString = dataString + newDataString;
        DummyCore.Utils.DummyPacketIMSG simplePacket = new DummyCore.Utils.DummyPacketIMSG(dataString);
        DummyCore.Utils.DummyPacketHandler.sendToAll(simplePacket);
    }

    public static void drawTexturedModalRect(int p_73729_1_, int p_73729_2_, int p_73729_3_, int p_73729_4_, int p_73729_5_, int p_73729_6_, int zLevel) {
        float f = 0.00390625F;
        float f1 = 0.00390625F;
        Tessellator tessellator = Tessellator.field_78398_a;
        tessellator.func_78382_b();
        tessellator.func_78374_a((double)(p_73729_1_ + 0), (double)(p_73729_2_ + p_73729_6_), (double)zLevel, (double)((float)(p_73729_3_ + 0) * f), (double)((float)(p_73729_4_ + p_73729_6_) * f1));
        tessellator.func_78374_a((double)(p_73729_1_ + p_73729_5_), (double)(p_73729_2_ + p_73729_6_), (double)zLevel, (double)((float)(p_73729_3_ + p_73729_5_) * f), (double)((float)(p_73729_4_ + p_73729_6_) * f1));
        tessellator.func_78374_a((double)(p_73729_1_ + p_73729_5_), (double)(p_73729_2_ + 0), (double)zLevel, (double)((float)(p_73729_3_ + p_73729_5_) * f), (double)((float)(p_73729_4_ + 0) * f1));
        tessellator.func_78374_a((double)(p_73729_1_ + 0), (double)(p_73729_2_ + 0), (double)zLevel, (double)((float)(p_73729_3_ + 0) * f), (double)((float)(p_73729_4_ + 0) * f1));
        tessellator.func_78381_a();
    }

    @SideOnly(Side.CLIENT)
    public static void renderItemStack_Full(ItemStack stk, double posX, double posY, double posZ, double screenPosX, double screenPosY, double screenPosZ, float rotation, float rotationZ, float colorRed, float colorGreen, float colorBlue, float offsetX, float offsetY, float offsetZ) {
        if (stk != null) {
            ItemStack itemstack = stk.func_77946_l();
            itemstack.field_77994_a = 1;
            new ResourceLocation("textures/misc/enchanted_item_glint.png");
            RenderBlocks renderBlocksRi = new RenderBlocks();
            Random random = new Random();
            boolean renderWithColor = true;
            if (itemstack != null && itemstack.func_77973_b() != null) {
                Minecraft.func_71410_x().field_71446_o.func_110577_a(Minecraft.func_71410_x().field_71446_o.func_130087_a(stk.func_94608_d()));
                TextureUtil.func_152777_a(false, false, 1.0F);
                random.setSeed(187L);
                GL11.glPushMatrix();
                byte b0 = 1;
                if (stk.field_77994_a > 1) {
                    b0 = 2;
                }

                if (stk.field_77994_a > 5) {
                    b0 = 3;
                }

                if (stk.field_77994_a > 20) {
                    b0 = 4;
                }

                if (stk.field_77994_a > 40) {
                    b0 = 5;
                }

                GL11.glTranslated((double)((float)screenPosX + offsetX), (double)((float)screenPosY + offsetY), (double)((float)screenPosZ + offsetZ));
                GL11.glEnable(32826);
                EntityItem fakeItem = new EntityItem(Minecraft.func_71410_x().field_71441_e, posX, posY, posZ, stk);
                GL11.glRotatef(rotationZ, 0.0F, 0.0F, 1.0F);
                if (!ForgeHooksClient.renderEntityItem(fakeItem, itemstack, rotationZ, rotation, random, Minecraft.func_71410_x().field_71446_o, renderBlocksRi, b0)) {
                    if (itemstack.func_94608_d() == 0 && itemstack.func_77973_b() instanceof ItemBlock && RenderBlocks.func_147739_a(Block.func_149634_a(itemstack.func_77973_b()).func_149645_b())) {
                        Block block = Block.func_149634_a(itemstack.func_77973_b());
                        GL11.glRotatef(rotation, 0.0F, 1.0F, 0.0F);
                        float f9 = 0.25F;
                        int k = block.func_149645_b();
                        if (k == 1 || k == 19 || k == 12 || k == 2) {
                            f9 = 0.5F;
                        }

                        if (block.func_149701_w() > 0) {
                            GL11.glAlphaFunc(516, 0.1F);
                            GL11.glEnable(3042);
                            OpenGlHelper.func_148821_a(770, 771, 1, 0);
                        }

                        GL11.glScalef(f9, f9, f9);

                        for(int l = 0; l < b0; ++l) {
                            GL11.glPushMatrix();
                            if (l > 0) {
                                float f6 = (random.nextFloat() * 2.0F - 1.0F) * 0.2F / f9;
                                float f7 = (random.nextFloat() * 2.0F - 1.0F) * 0.2F / f9;
                                float f8 = (random.nextFloat() * 2.0F - 1.0F) * 0.2F / f9;
                                GL11.glTranslatef(f6, f7, f8);
                            }

                            renderBlocksRi.func_147800_a(block, itemstack.func_77960_j(), 1.0F);
                            GL11.glPopMatrix();
                        }

                        if (block.func_149701_w() > 0) {
                            GL11.glDisable(3042);
                        }
                    } else if (itemstack.func_77973_b().func_77623_v()) {
                        GL11.glScalef(0.5F, 0.5F, 0.5F);

                        for(int j = 0; j < itemstack.func_77973_b().getRenderPasses(itemstack.func_77960_j()); ++j) {
                            random.setSeed(187L);
                            itemstack.func_77973_b().getIcon(itemstack, j);
                            renderItemStack(stk, posX, posY, posZ, screenPosX, screenPosY, screenPosZ, rotation, colorRed, colorGreen, colorBlue, j, stk.field_77994_a);
                        }
                    } else {
                        if (itemstack != null && itemstack.func_77973_b() instanceof ItemCloth) {
                            GL11.glAlphaFunc(516, 0.1F);
                            GL11.glEnable(3042);
                            OpenGlHelper.func_148821_a(770, 771, 1, 0);
                        }

                        GL11.glScalef(0.5F, 0.5F, 0.5F);
                        itemstack.func_77954_c();
                        if (renderWithColor) {
                            renderItemStack(stk, posX, posY, posZ, screenPosX, screenPosY, screenPosZ, rotation, colorRed, colorGreen, colorBlue, 0, stk.field_77994_a);
                        }

                        if (itemstack != null && itemstack.func_77973_b() instanceof ItemCloth) {
                            GL11.glDisable(3042);
                        }
                    }
                }

                EntityItem var37 = null;
                GL11.glDisable(32826);
                GL11.glPopMatrix();
                Minecraft.func_71410_x().field_71446_o.func_110577_a(Minecraft.func_71410_x().field_71446_o.func_130087_a(stk.func_94608_d()));
                TextureUtil.func_147945_b();
            }

            Object var36 = null;
        }

    }

    @SideOnly(Side.CLIENT)
    public static void renderItemStack(ItemStack stk, double posX, double posY, double posZ, double screenPosX, double screenPosY, double screenPosZ, float rotation, float colorRed, float colorGreen, float colorBlue, int renderPass, int itemsAmount) {
        ResourceLocation RES_ITEM_GLINT = new ResourceLocation("textures/misc/enchanted_item_glint.png");
        new RenderBlocks();
        Random random = new Random();
        IIcon p_77020_2_ = stk.func_77973_b().getIcon(stk, renderPass);
        Tessellator tessellator = Tessellator.field_78398_a;
        if (p_77020_2_ == null) {
            TextureManager texturemanager = Minecraft.func_71410_x().func_110434_K();
            ResourceLocation resourcelocation = texturemanager.func_130087_a(stk.func_77973_b().func_94901_k());
            p_77020_2_ = ((TextureMap)texturemanager.func_110581_b(resourcelocation)).func_110572_b("missingno");
        }

        float f14 = p_77020_2_.func_94209_e();
        float f15 = p_77020_2_.func_94212_f();
        float f4 = p_77020_2_.func_94206_g();
        float f5 = p_77020_2_.func_94210_h();
        float f6 = 1.0F;
        float f7 = 0.5F;
        float f8 = 0.25F;
        if (Minecraft.func_71410_x().field_71474_y.field_74347_j) {
            GL11.glPushMatrix();
            GL11.glRotatef(rotation, 0.0F, 1.0F, 0.0F);
            float f9 = 0.0625F;
            float f10 = 0.021875F;
            ItemStack itemstack = stk;
            int j = stk.field_77994_a;
            byte b0;
            if (j < 2) {
                b0 = 1;
            } else if (j < 16) {
                b0 = 2;
            } else if (j < 32) {
                b0 = 3;
            } else {
                b0 = 4;
            }

            GL11.glTranslatef(-f7, -f8, -((f9 + f10) * (float)b0 / 2.0F));

            for(int k = 0; k < b0; ++k) {
                if (k > 0) {
                    float x = (random.nextFloat() * 2.0F - 1.0F) * 0.3F / 0.5F;
                    float y = (random.nextFloat() * 2.0F - 1.0F) * 0.3F / 0.5F;
                    random.nextFloat();
                    GL11.glTranslatef(x, y, f9 + f10);
                } else {
                    GL11.glTranslatef(0.0F, 0.0F, f9 + f10);
                }

                if (itemstack.func_94608_d() == 0) {
                    Minecraft.func_71410_x().field_71446_o.func_110577_a(TextureMap.field_110575_b);
                } else {
                    Minecraft.func_71410_x().field_71446_o.func_110577_a(TextureMap.field_110576_c);
                }

                GL11.glColor4f(colorRed, colorGreen, colorBlue, 1.0F);
                ItemRenderer.func_78439_a(tessellator, f15, f4, f14, f5, p_77020_2_.func_94211_a(), p_77020_2_.func_94216_b(), f9);
                if (itemstack.hasEffect(renderPass)) {
                    GL11.glDepthFunc(514);
                    GL11.glDisable(2896);
                    Minecraft.func_71410_x().field_71446_o.func_110577_a(RES_ITEM_GLINT);
                    GL11.glEnable(3042);
                    GL11.glBlendFunc(768, 1);
                    float f11 = 0.76F;
                    GL11.glColor4f(0.5F * f11, 0.25F * f11, 0.8F * f11, 1.0F);
                    GL11.glMatrixMode(5890);
                    GL11.glPushMatrix();
                    float f12 = 0.125F;
                    GL11.glScalef(f12, f12, f12);
                    float f13 = (float)(Minecraft.func_71386_F() % 3000L) / 3000.0F * 8.0F;
                    GL11.glTranslatef(f13, 0.0F, 0.0F);
                    GL11.glRotatef(-50.0F, 0.0F, 0.0F, 1.0F);
                    ItemRenderer.func_78439_a(tessellator, 0.0F, 0.0F, 1.0F, 1.0F, 255, 255, f9);
                    GL11.glPopMatrix();
                    GL11.glPushMatrix();
                    GL11.glScalef(f12, f12, f12);
                    f13 = (float)(Minecraft.func_71386_F() % 4873L) / 4873.0F * 8.0F;
                    GL11.glTranslatef(-f13, 0.0F, 0.0F);
                    GL11.glRotatef(10.0F, 0.0F, 0.0F, 1.0F);
                    ItemRenderer.func_78439_a(tessellator, 0.0F, 0.0F, 1.0F, 1.0F, 255, 255, f9);
                    GL11.glPopMatrix();
                    GL11.glMatrixMode(5888);
                    GL11.glDisable(3042);
                    GL11.glEnable(2896);
                    GL11.glDepthFunc(515);
                }
            }

            GL11.glPopMatrix();
        } else {
            for(int l = 0; l < itemsAmount; ++l) {
                GL11.glPushMatrix();
                if (l > 0) {
                    float f10 = (random.nextFloat() * 2.0F - 1.0F) * 0.3F;
                    float f16 = (random.nextFloat() * 2.0F - 1.0F) * 0.3F;
                    float f17 = (random.nextFloat() * 2.0F - 1.0F) * 0.3F;
                    GL11.glTranslatef(f10, f16, f17);
                }

                GL11.glColor4f(colorRed, colorGreen, colorBlue, 1.0F);
                tessellator.func_78382_b();
                tessellator.func_78375_b(0.0F, 1.0F, 0.0F);
                tessellator.func_78374_a((double)(0.0F - f7), (double)(0.0F - f8), (double)0.0F, (double)f14, (double)f5);
                tessellator.func_78374_a((double)(f6 - f7), (double)(0.0F - f8), (double)0.0F, (double)f15, (double)f5);
                tessellator.func_78374_a((double)(f6 - f7), (double)(1.0F - f8), (double)0.0F, (double)f15, (double)f4);
                tessellator.func_78374_a((double)(0.0F - f7), (double)(1.0F - f8), (double)0.0F, (double)f14, (double)f4);
                tessellator.func_78381_a();
                GL11.glPopMatrix();
            }
        }

    }

    public static Entity cloneEntity(Entity e) {
        Entity retEntity = null;

        try {
            retEntity = (Entity)e.getClass().getConstructor(World.class).newInstance(e.field_70170_p);
            retEntity.func_82141_a(e, true);
            return retEntity;
        } catch (Exception var3) {
            return retEntity;
        }
    }

    public static void notifyBiomeChange(int x, int z, int biomeID) {
        String dataString = "||mod:DummyCore.BiomeChange";
        DummyCore.Utils.DummyData xpos = new DummyCore.Utils.DummyData("positionX", x);
        DummyCore.Utils.DummyData zpos = new DummyCore.Utils.DummyData("positionZ", z);
        DummyCore.Utils.DummyData id = new DummyCore.Utils.DummyData("biomeID", biomeID);
        DummyCore.Utils.DataStorage.addDataToString(xpos);
        DummyCore.Utils.DataStorage.addDataToString(zpos);
        DummyCore.Utils.DataStorage.addDataToString(id);
        String newDataString = DummyCore.Utils.DataStorage.getDataString();
        dataString = dataString + newDataString;
        DummyCore.Utils.DummyPacketIMSG simplePacket = new DummyCore.Utils.DummyPacketIMSG(dataString);
        DummyCore.Utils.DummyPacketHandler.sendToAll(simplePacket);
    }

    public static float multiplyDamageByArmorAbsorbption(EntityLivingBase base, DamageSource dam, float amount) {
        if (!dam.func_76363_c()) {
            int i = 25 - base.func_70658_aO();
            float f1 = amount * (float)i;
            amount = f1 / 25.0F;
        }

        return amount;
    }

    public static float applyPotionDamageCalculations(EntityLivingBase base, DamageSource dam, float amount) {
        if (dam.func_151517_h()) {
            return amount;
        } else {
            if (base.func_70644_a(Potion.field_76429_m) && dam != DamageSource.field_76380_i) {
                int i = (base.func_70660_b(Potion.field_76429_m).func_76458_c() + 1) * 5;
                int j = 25 - i;
                float f1 = amount * (float)j;
                amount = f1 / 25.0F;
            }

            if (amount <= 0.0F) {
                return 0.0F;
            } else {
                int i = EnchantmentHelper.func_77508_a(base.func_70035_c(), dam);
                if (i > 20) {
                    i = 20;
                }

                if (i > 0 && i <= 20) {
                    int j = 25 - i;
                    float f1 = amount * (float)j;
                    amount = f1 / 25.0F;
                }

                return amount;
            }
        }
    }

    public static void damageEntityIgnoreEvent(EntityLivingBase base, DamageSource dam, float amount) {
        if (!base.func_85032_ar()) {
            if (amount <= 0.0F) {
                return;
            }

            amount = multiplyDamageByArmorAbsorbption(base, dam, amount);
            amount = applyPotionDamageCalculations(base, dam, amount);
            float f1 = amount;
            amount = Math.max(amount - base.func_110139_bj(), 0.0F);
            base.func_110149_m(base.func_110139_bj() - (f1 - amount));
            if (amount != 0.0F) {
                float f2 = base.func_110143_aJ();
                base.func_70606_j(f2 - amount);
                base.func_110142_aN().func_94547_a(dam, f2, amount);
                base.func_110149_m(base.func_110139_bj() - amount);
            }
        }

    }

    public static void setPrivateFinalValue(Class<Potion> classToAccess, Object instance, Object value, String[] fieldNames) {
        Field field = ReflectionHelper.findField(classToAccess, ObfuscationReflectionHelper.remapFieldNames(classToAccess.getName(), fieldNames));

        try {
            Field modifiersField = Field.class.getDeclaredField("modifiers");
            modifiersField.setAccessible(true);
            modifiersField.setInt(field, field.getModifiers() & -17);
            field.set(instance, value);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static int extendPotionArray(int byAmount) {
        int potionsOffset = Potion.field_76425_a.length;
        int pStart = 0;
        if (potionsOffset < Potion.field_76425_a.length - byAmount) {
            Potion[] potionTypes = new Potion[potionsOffset + byAmount];
            System.arraycopy(Potion.field_76425_a, 0, potionTypes, 0, potionsOffset);
            setPrivateFinalValue(Potion.class, (Object)null, potionTypes, new String[]{"potionTypes", "field_76425_a", "a"});
            pStart = potionsOffset++ - 1;
        } else {
            for(int i = 0; i < Potion.field_76425_a.length; ++i) {
                if (Potion.field_76425_a[i] == null) {
                    return i;
                }
            }

            pStart = -1;
            Notifier.notifyCustomMod("DummyCore", "Potion Array limit reached!");
        }

        return pStart;
    }

    public static void setBlockUnbreakable(World w, int x, int y, int z, boolean remove) {
        if (!isBlockUnbreakable(w, x, y, z) && !remove) {
            DummyCore.Utils.BlockPosition pos = new DummyCore.Utils.BlockPosition(w, x, y, z);
            unbreakableBlocks.add(pos);
        } else {
            for(int i = 0; i < unbreakableBlocks.size(); ++i) {
                DummyCore.Utils.BlockPosition pos = (DummyCore.Utils.BlockPosition)unbreakableBlocks.get(i);
                if (pos.x == x && pos.y == y && pos.z == z && pos.wrld.field_73011_w.field_76574_g == w.field_73011_w.field_76574_g) {
                    unbreakableBlocks.remove(pos);
                    break;
                }
            }
        }

    }

    public static boolean isBlockUnbreakable(World w, int x, int y, int z) {
        for(int i = 0; i < unbreakableBlocks.size(); ++i) {
            DummyCore.Utils.BlockPosition pos = (BlockPosition)unbreakableBlocks.get(i);
            if (pos.x == x && pos.y == y && pos.z == z && pos.wrld.field_73011_w.field_76574_g == w.field_73011_w.field_76574_g) {
                return true;
            }
        }

        return false;
    }

    @SideOnly(Side.CLIENT)
    public static void handleButtonPress(int buttonID, Class<? extends Gui> parentClass, Class<? extends GuiButton> buttonClass, EntityPlayer presser, int bX, int bY, int bZ) {
        handleButtonPress(buttonID, parentClass, buttonClass, presser, bX, bY, bZ, "||data:no data");
    }

    @SideOnly(Side.CLIENT)
    public static void handleButtonPress(int buttonID, Class<? extends Gui> parentClass, Class<? extends GuiButton> buttonClass, EntityPlayer presser, int bX, int bY, int bZ, String additionalData) {
        String dataString = "||mod:DummyCore.guiButton";
        DummyCore.Utils.DummyData id = new DummyCore.Utils.DummyData("id", buttonID);
        DummyCore.Utils.DummyData parent = new DummyCore.Utils.DummyData("parent", parentClass.getName());
        DummyCore.Utils.DummyData button = new DummyCore.Utils.DummyData("button", buttonClass.getName());
        DummyCore.Utils.DummyData player = new DummyCore.Utils.DummyData("player", presser.func_70005_c_());
        DummyCore.Utils.DummyData dx = new DummyCore.Utils.DummyData("x", bX);
        DummyCore.Utils.DummyData dy = new DummyCore.Utils.DummyData("y", bY);
        DummyCore.Utils.DummyData dz = new DummyData("z", bZ);
        DummyCore.Utils.DataStorage.addDataToString(id);
        DummyCore.Utils.DataStorage.addDataToString(parent);
        DummyCore.Utils.DataStorage.addDataToString(button);
        DummyCore.Utils.DataStorage.addDataToString(player);
        DummyCore.Utils.DataStorage.addDataToString(dx);
        DummyCore.Utils.DataStorage.addDataToString(dy);
        DummyCore.Utils.DataStorage.addDataToString(dz);
        String newDataString = DataStorage.getDataString();
        dataString = dataString + newDataString + additionalData;
        DummyCore.Utils.DummyPacketIMSG simplePacket = new DummyPacketIMSG(dataString);
        DummyPacketHandler.sendToServer(simplePacket);
    }

    public static int search_firstBlock(World w, Block toSearch, int x, int z, int maxY, int minY, int metadata, boolean shouldHaveAirAbove) {
        for(int y = maxY; y > minY; --y) {
            Block b = w.func_147439_a(x, y, z);
            int meta = w.func_72805_g(x, y, z);
            if (b != null && b != Blocks.field_150350_a) {
                if (b == toSearch && (metadata == -1 || metadata == 32767 || metadata == meta)) {
                    return y;
                }

                if (shouldHaveAirAbove) {
                    return -1;
                }
            }
        }

        return -1;
    }

    public static void openGui(World w, int x, int y, int z, EntityPlayer player, int guiID) {
        player.openGui(CoreInitialiser.instance, guiID, w, x, y, z);
    }

    public static void setShaders(int shaderID) {
        if (shaderID >= defaultShaders.length) {
            shaderID = defaultShaders.length - 1;
        }

        if (shaderID < 0) {
            setShaders((ResourceLocation)null);
        } else {
            CoreInitialiser.proxy.initShaders(defaultShaders[shaderID]);
        }

    }

    public static void setShaders(ResourceLocation shaders) {
        CoreInitialiser.proxy.initShaders(shaders);
    }
}
