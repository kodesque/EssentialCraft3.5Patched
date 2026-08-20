package ec3.integration.waila;

// public class WailaDataProvider implements IWailaDataProvider {
//
// @Override
// public ItemStack getWailaStack(IWailaDataAccessor accessor, IWailaConfigHandler config) {
// if (accessor.getTileEntity() != null) {
// if (accessor.getTileEntity() instanceof TileRightClicker) {
// TileRightClicker tile = (TileRightClicker) accessor.getTileEntity();
// return tile.getStackInSlot(10) != null && tile.getStackInSlot(10)
// .getItem() instanceof ItemBlock ? tile.getStackInSlot(10) : null;
// }
// }
// return null;
// }
//
// @Override
// public List<String> getWailaHead(ItemStack itemStack, List<String> currenttip, IWailaDataAccessor accessor,
// IWailaConfigHandler config) {
// return currenttip;
// }
//
// @Override
// public List<String> getWailaBody(ItemStack itemStack, List<String> currenttip, IWailaDataAccessor accessor,
// IWailaConfigHandler config) {
//
// if (accessor.getTileEntity() != null) {
// if (accessor.getTileEntity() instanceof TileRightClicker) {
// return currenttip;
// }
// if (accessor.getTileEntity() instanceof ITEHasMRU) {
// ITEHasMRU tile = (ITEHasMRU) accessor.getTileEntity();
// if (tile.getMaxMRU() > 0) {
// currenttip.add("MRU: " + tile.getMRU() + "/" + tile.getMaxMRU());
// float balance = tile.getBalance();
// String str = Float.toString(((ITEHasMRU) tile).getBalance());
// if (str.length() > 6) str = str.substring(0, 6);
// for (int i = str.length() - 1; i > 0; --i) {
// if (i > 2) {
// char c = str.charAt(i);
// if (c == '0') {
// str = str.substring(0, i);
// }
// }
// }
// EnumChatFormatting color = EnumChatFormatting.AQUA;
// if (balance < 1) {
// color = EnumChatFormatting.BLUE;
// }
// if (balance > 1) {
// color = EnumChatFormatting.RED;
// }
// currenttip.add("Balance: " + color + str);
// if (accessor.getTileEntity() instanceof IInventory) {
// IInventory tInv = (IInventory) accessor.getTileEntity();
// if (tInv.getSizeInventory() > 0) {
// ItemStack tryBoundGem = tInv.getStackInSlot(0);
// if (tryBoundGem != null) {
// if (tryBoundGem.getItem() instanceof ItemBoundGem) {
// ItemBoundGem itm = (ItemBoundGem) tryBoundGem.getItem();
// itm.addInformation(tryBoundGem, null, currenttip, true);
// }
// }
// }
// }
// }
// }
//
// }
//
// return currenttip;
// }
//
// @Override
// public List<String> getWailaTail(ItemStack itemStack, List<String> currenttip, IWailaDataAccessor accessor,
// IWailaConfigHandler config) {
// return currenttip;
// }
//
// @Override
// public NBTTagCompound getNBTData(EntityPlayerMP player, TileEntity te, NBTTagCompound tag, World world, int x,
// int y, int z) {
// return tag;
// }
//
// public static void callbackRegister(IWailaRegistrar registrar) {
// registrar.registerBodyProvider(new WailaDataProvider(), Block.class);
// registrar.registerStackProvider(new WailaDataProvider(), BlockRightClicker.class);
// }
//
// }
