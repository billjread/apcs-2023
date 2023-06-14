package Unit12pro;
import java.lang.Math;
import java.util.Scanner;

public class TheBox {
   public static void main(String[] args) {
      Scanner scan = new Scanner(System.in);
      System.out.print("Select a Capital Letter to be your Character: ");
      String player = scan.nextLine();
      boolean b = false;
      while(b == false) {
         if(player.length() != 1 || !Character.isUpperCase(player.charAt(0))) {
            System.out.print("Not Valid. Enter a Capital Letter: ");
            player = scan.nextLine(); }
         else {
            b = true; } }
      
      int wallet = 0;
      TheBorder border = new TheBorder(player);
      TheShop shop = new TheShop(wallet);
      TheItems items = new TheItems();
      
      long previousTimeMillis = System.currentTimeMillis();

      while(0 == 0) {
         border.printBox();
         shop.printWallet();
         System.out.print("Enter Command Here: ");
         String command = scan.nextLine();
         enterCommand(wallet, border, shop, items, command);
         checkSpot(wallet, border, shop, items);
         
         if((System.currentTimeMillis() - previousTimeMillis) > 2000) {
            spawn(border);
            previousTimeMillis = System.currentTimeMillis();
         }
      }
      
   }
   
   public static void enterCommand(int wallet, TheBorder border, TheShop shop, TheItems items, String command) {
      Scanner scan = new Scanner(System.in);
      if(command.equals("a")) {
         border.moveLeft(); }
      else if(command.equals("s")) {
         border.moveDown(); }
      else if(command.equals("d")) {
         border.moveRight(); }
      else if(command.equals("w")) {
         border.moveUp(); }
      else if(command.equals("e")) {
         System.out.println();
         shop.printShop(); 
         System.out.println();
         System.out.print("Enter Shop Command Here: ");
         String shopCommand = scan.nextLine();
         enterShopCommand(wallet, border, shop, items, shopCommand);
         }
      else {
         System.out.print("Invalid Command. Enter Command Here: ");
         String newCommand = scan.nextLine();
         enterCommand(wallet, border, shop, items, newCommand); }    
   }
   
   public static int enterShopCommand(int wallet, TheBorder border, TheShop shop, TheItems items, String shopCommand) {
      Scanner scan = new Scanner(System.in);
      wallet = shop.getWallet();
      if(!shopCommand.equals("e")) {
         if(shopCommand.equals("d")) {
            if(wallet - shop.getBDP() < 0) {
               notEnough(wallet, border, shop, items); }
            else {
               border.addDown1();
               shop.walletChange(-1*shop.getBDP());
               shop.growBRP(); }
            enterCommand(wallet, border, shop, items, "e"); 
         }
         else if(shopCommand.equals("r")) {
            if(wallet - shop.getBRP() < 0) {
               notEnough(wallet, border, shop, items); }
            else {
               border.addRight1();
               shop.walletChange(-1*shop.getBRP());
               shop.growBDP(); }
            enterCommand(wallet, border, shop, items, "e");
            }
         else if(shopCommand.equals("i")) {
            if(wallet - shop.getIVP() < 0) {
               notEnough(wallet, border, shop, items); }
            else {
               items.doubleTheValue();
               shop.walletChange(-1*shop.getIVP());
               shop.growIVP(); }
            enterCommand(wallet, border, shop, items, "e"); }
         else if(shopCommand.equals("secret command")) {
            shop.walletChange(100); 
            enterCommand(wallet, border, shop, items, "e"); }
         else {
            System.out.print("Invalid Command. Enter Shop Command Here: ");
            String newShopCommand = scan.nextLine();
            enterShopCommand(wallet, border, shop, items, newShopCommand); 
         }
       }
         return wallet;
   }
   
   public static void notEnough(int wallet, TheBorder border, TheShop shop, TheItems items) {
      Scanner scan = new Scanner(System.in);
      System.out.print("Out of Points! Enter Shop Command Here: ");
      String newShopCommand = scan.nextLine();
      enterShopCommand(wallet, border, shop, items, newShopCommand);
   }
   
   public static void spawn(TheBorder border) {
      int oneOrTwo = (int)(Math.random()*2) + 1;
      int oneThroughTen = (int)(Math.random()*10) + 1;

      if(oneOrTwo == 2) {
         if(oneThroughTen >= 1 && oneThroughTen < 3) {
            border.spawnPoint1(); }
         else if(oneThroughTen >= 3 && oneThroughTen < 5) {
            border.spawnPoint2(); }
         else if(oneThroughTen >= 5 && oneThroughTen < 7) {
            border.spawnPoint3(); }
         else if(oneThroughTen >= 7 && oneThroughTen < 9) {
            border.spawnPoint4(); }
         else {
            border.spawnPoint5(); }
      }
   }

   public static void checkSpot(int wallet, TheBorder border, TheShop shop, TheItems items) {
      Scanner scan = new Scanner(System.in);
      int hp = border.getHeightPos();
      int lp = border.getLengthPos();

      if(hp == 0 || hp == border.getHeight() - 1) {
         border.moveUp();
         System.out.print("Out of Bounds. Enter Command: ");
         String newCommand = scan.nextLine();
         enterCommand(wallet, border, shop, items, newCommand);
         checkSpot(wallet, border, shop, items);
      }
      else if(lp == 0 || lp == border.getLength() - 1) {
         border.moveLeft();
         System.out.print("Out of Bounds. Enter Command: ");
         String newCommand = scan.nextLine();
         enterCommand(wallet, border, shop, items, newCommand);
         checkSpot(wallet, border, shop, items);
      }

      if(hp == 4 && lp == 5 && !border.getPoint1().equals("  ")) {
         if(border.getPoint1().equals(". ")) {
            shop.walletChange(items.getPointVal()); }
         else if(border.getPoint1().equals("+ ")) {
            shop.walletChange(items.getDegreeVal()); }
         else {
            shop.walletChange(items.getStarVal()); }
         border.resetPoint1();
      }
      else if(hp == 6 && lp == 16 && !border.getPoint2().equals("  ")) {
         if(border.getPoint2().equals(". ")) {
            shop.walletChange(items.getPointVal()); }
         else if(border.getPoint2().equals("+ ")) {
            shop.walletChange(items.getDegreeVal()); }
         else {
            shop.walletChange(items.getStarVal()); }
         border.resetPoint2();
      }
      else if(hp == 10 && lp == 12 && !border.getPoint3().equals("  ")) {
         if(border.getPoint3().equals(". ")) {
            shop.walletChange(items.getPointVal()); }
         else if(border.getPoint3().equals("+ ")) {
            shop.walletChange(items.getDegreeVal()); }
         else {
            shop.walletChange(items.getStarVal()); }
         border.resetPoint3();
      }
      else if(hp == 16 && lp == 18 && !border.getPoint4().equals("  ")) {
         if(border.getPoint4().equals(". ")) {
            shop.walletChange(items.getPointVal()); }
         else if(border.getPoint4().equals("+ ")) {
            shop.walletChange(items.getDegreeVal()); }
         else {
            shop.walletChange(items.getStarVal()); }
         border.resetPoint4();
      }
      else if(hp == 17 && lp == 1 && !border.getPoint5().equals("  ")) {
         if(border.getPoint5().equals(". ")) {
            shop.walletChange(items.getPointVal()); }
         else if(border.getPoint5().equals("+ ")) {
            shop.walletChange(items.getDegreeVal()); }
         else {
            shop.walletChange(items.getStarVal()); }
         border.resetPoint5();
      }
   }
   
}