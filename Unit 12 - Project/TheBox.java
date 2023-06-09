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
      
      int wallet = 51;
      TheBorder border = new TheBorder(player);
      TheShop shop = new TheShop(wallet);
      
      
      while(0 == 0) {
         spawn();
         System.out.println();
         border.printBox();
         System.out.println();
         System.out.print("Enter Command Here: ");
         String command = scan.nextLine();
         enterCommand(wallet, border, shop, command);
      }
      
   }
   
   public static void enterCommand(int wallet, TheBorder border, TheShop shop, String command) {
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
         enterShopCommand(wallet, border, shop, shopCommand);
         }
      else {
         System.out.print("Invalid Command. Enter Command Here: ");
         String newCommand = scan.nextLine();
         enterCommand(wallet, border, shop, newCommand); }    
   }
   
   public static int enterShopCommand(int wallet, TheBorder border, TheShop shop, String shopCommand) {
      Scanner scan = new Scanner(System.in);
      wallet = shop.getWallet();
      if(!shopCommand.equals("e")) {
         if(shopCommand.equals("c")) {
            if(wallet - 25 < 0) {
               notEnough(wallet, border, shop); }
            else {
               shop.walletChange(-1*shop.getCP());
               //place collector
               enterCommand(wallet, border, shop, "e"); }
         }
         else if(shopCommand.equals("d")) {
            if(wallet - shop.getBDP() < 0) {
               notEnough(wallet, border, shop); }
            else {
               border.addDown1();
               shop.walletChange(-1*shop.getBDP());
               shop.growBRP(); }
            enterCommand(wallet, border, shop, "e"); 
         }
         else if(shopCommand.equals("r")) {
            if(wallet - shop.getBRP() < 0) {
               notEnough(wallet, border, shop); }
            else {
               border.addRight1();
               shop.walletChange(-1*shop.getBRP());
               shop.growBDP(); }
            enterCommand(wallet, border, shop, "e");
         }
         else {
            System.out.print("Invalid Command. Enter Shop Command Here: ");
            String newShopCommand = scan.nextLine();
            enterShopCommand(wallet, border, shop, newShopCommand); 
         }
       }
         return wallet;
   }
   
   public static void notEnough(int wallet, TheBorder border, TheShop shop) {
      Scanner scan = new Scanner(System.in);
      System.out.print("Out of Points! Enter Shop Command Here: ");
      String newShopCommand = scan.nextLine();
      enterShopCommand(wallet, border, shop, newShopCommand);
   }
   
   public static void spawn() {
      int oneOrTwo = (int) (Math.random() + 1)*2;
      System.out.println(oneOrTwo);
   }
   
}