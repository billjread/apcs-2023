package unit11;r

import java.util.Scanner;

public class DoubleTrouble {
   private static int player1Pts;
   private static int player2Pts;
   
   public DoubleTrouble() {
      player1Pts = 10;
      player2Pts = 10;   
   }

   public static void main(String[] args){
      DoubleTrouble game = new DoubleTrouble();
      
      while(player1Pts > 0 && player2Pts > 0) {
         player1Roll();
         player2Roll();
      }
      if(player1Pts > 0) {
         System.out.println("Player 1 Won!");
      }
      else {
         System.out.println("Player 2 Won!");
      }
   }
   
   public static int rollDice1() {
      int dice1 = (int)(Math.random()*6) + 1;
      return dice1;
   }
   
   public static int rollDice2() {
      int dice2 = (int)(Math.random()*6) + 1;
      return dice2;
   }
   
   public static String pointsPlayer1(int d1, int d2) {
      if(d1 == d2) {
         player1Pts -= 5;
         return "-5p";
      }
      else if(d1 + d2 == 7) {
         player1Pts += 3;
         return "+3p";
      }
      else if((d1 + d2)%2 != 0) {
         player1Pts += 1;
         return "+1p";
      }
      else {
         return "+0p";
      }
         
   }
   
   public static String pointsPlayer2(int d1, int d2) {
      if(d1 == d2) {
         player2Pts -= 5;
         return "-5p";
      }
      else if(d1 + d2 == 7) {
         player2Pts += 3;
         return "+3p";
      }
      else if((d1 + d2)%2 != 0) {
         player2Pts += 1;
         return "+1p";
      }
      else {
         return "+0p";
      }
         
   }

      
   public static void player1Roll() {
      System.out.println("Player 1's Turn: Type and Enter \"r\" to Roll");
      Scanner roll = new Scanner(System.in);
      String r = roll.nextLine();
     
      if(r.equals("r")) {
         int dice1 = rollDice1();
         int dice2 = rollDice2();
         System.out.println(dice1 + " " + dice2);
         System.out.println("Player 1: " + pointsPlayer1(dice1, dice2));
         System.out.println("Player 1: " + player1Pts + " | Player 2: " + player2Pts);
         System.out.println();
      }
      else {
         player1Roll();
      }
   }
   
   public static void player2Roll() {
      System.out.println("Player 2's Turn: Type and Enter \"r\" to Roll");
      Scanner roll = new Scanner(System.in);
      String r = roll.nextLine();
     
      if(r.equals("r")) {
         int dice1 = rollDice1();
         int dice2 = rollDice2();
         System.out.println(dice1 + " " + dice2);
         System.out.println("Player 2: " + pointsPlayer2(dice1, dice2));
         System.out.println("Player 1: " + player1Pts + " | Player 2: " + player2Pts);
         System.out.println();
      }
      else {
         player2Roll();
      }
   }

}
