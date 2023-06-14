package Unit12pro;

public class TheShop {
   private int wallet, collectorPrice, borderDownPrice,
   borderRightPrice, iItemValuePrice;
   
   public TheShop(int w) {
      wallet = w;
      collectorPrice = 25;
      borderDownPrice = 20;
      borderRightPrice = 20;
      iItemValuePrice = 50;
   }
   
   public int getWallet() {
      return wallet;
   }
   public int getCP() {
      return collectorPrice;
   }
   
   public int getBDP() {
      return borderDownPrice;
   }
   
   public int getBRP() {
      return borderRightPrice;
   }
   
   public int getIVP() {
      return iItemValuePrice;
   }
   
   public void growBDP() {
      borderDownPrice += 2;
   }
   
   public void growBRP() {
      borderRightPrice += 2;
   }
   
   public void growIVP() {
      iItemValuePrice *= 2;
   }
   
   public void walletChange(int amount) {
      wallet += amount;
   }

   public void printWallet() {
      String shopLine = "------------------------------------------------------------------";
      System.out.println(shopLine);
      System.out.println("Your Wallet: " + wallet);
      System.out.println(shopLine);
      System.out.println();
   }
   
   public void printShop() {
      String shopLine = "------------------------------------------------------------------";
      System.out.println(shopLine);
      System.out.println("Your Wallet: " + wallet);
      System.out.println(shopLine);
//      System.out.println("\nCollector (b): " + collectorPrice + " Points (Enter \"c\" to Purchase)\n");
      System.out.println("Increase Border (down): " + borderDownPrice + " Points (Enter \"d\" to Purchase)\n");
      System.out.println("Increase Border (right): " + borderRightPrice + " Points (Enter \"r\" to Purchase)\n");
      System.out.println("Increase Item Value: " + iItemValuePrice + " Points (Enter \"i\" to Purchase)\n");
      System.out.println(shopLine);
   }
}