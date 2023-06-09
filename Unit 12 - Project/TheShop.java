public class TheShop {
   private int wallet, collectorPrice, borderDownPrice,
   borderRightPrice, sRatePrice, dsRatePrice;
   
   public TheShop(int w) {
      wallet = w;
      collectorPrice = 25;
      borderDownPrice = 20;
      borderRightPrice = 20;
      sRatePrice = 30;
      dsRatePrice = 30;
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
   
//   public int getSRP() {
//      return sRatePrice;
//   }
   
//   public int getDSRP() {
//      return dsRatePrice;
//   }
   
   public void growBDP() {
      borderDownPrice += 2;
   }
   
   public void growBRP() {
      borderRightPrice += 2;
   }
   
//   public void growSRP() {
//      sRatePrice += 10;
//   }
   
//   public void growDSRP() {
//      dsRatePrice += 10;
//   }
   
   public void walletChange(int amount) {
      wallet += amount;
   }
   
   public void printShop() {
      String shopLine = "------------------------------------------------------------------";
      System.out.println(shopLine);
      System.out.println("Your Wallet: " + wallet);
      System.out.println(shopLine);
      System.out.println("\nCollector (b): " + collectorPrice + " Points (Enter \"c\" to Purchase)\n");
      System.out.println("Increase Border (down): " + borderDownPrice + " Points (Enter \"d\" to Purchase)\n");
      System.out.println("Increase Border (right): " + borderRightPrice + " Points (Enter \"r\" to Purchase)\n");
//      System.out.println("Increase Spawn-rate (.+*): " + sRatePrice + " Points (Enter \"s\" to Purchase)\n");
//      System.out.println("Decrease Despawn-rate (.+*): " + dsRatePrice + " Points (Enter \"ds\" to Purchase)\n");
      System.out.println(shopLine);
   }
}