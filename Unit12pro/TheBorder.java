package Unit12pro;

import java.util.Random;

public class TheBorder {
   private int length;
   private int height;
   private int lengthPos;
   private int heightPos;
   private String player;
   
   private String point1;
   private String point2;
   private String point3;
   private String point4;
   private String point5;

   
   public TheBorder(String p) {
      length = 22;
      height = 20;

      lengthPos = 10;
      heightPos = 10;
      player = p;

      point1 = "  ";
      point2 = "  ";
      point3 = "  ";
      point4 = "  ";
      point5 = "  ";

   }
   
   public void addDown1() {
      height++;
   }
   
   public void addRight1() {
      length++;
   }
   
   public void moveLeft() {
      lengthPos--;
   }
   
   public void moveDown() {
      heightPos++;
   }
   
   public void moveRight() {
      lengthPos++;
   }
   
   public void moveUp() {
      heightPos--;
   }

   public int getLengthPos() {
      return lengthPos;
   }

   public int getHeightPos() {
      return heightPos;
   }

   public String getPoint1() {
      return point1;
   }

   public String getPoint2() {
      return point2;
   }

   public String getPoint3() {
      return point3;
   }

   public String getPoint4() {
      return point4;
   }

   public String getPoint5() {
      return point5;
   }

   public int getHeight() {
      return height;
   }

   public int getLength() {
      return length;
   }

   public String getRandomPoint() {
      int random = (int)(Math.random()*10) + 1;
      String type;

      if(random >= 1 && random <= 5) {
         type = ". "; }
      else if(random >= 6 && random <= 9) {
         type = "+ "; }
      else {
         type = "* "; }
      return type;
   }

   public void spawnPoint1() {
      if(point1.equals("  ")) {
         point1 = getRandomPoint(); }
   }

   public void spawnPoint2() {
      if(point2.equals("  ")) {
         point2 = getRandomPoint(); }
   }

   public void spawnPoint3() {
      if(point3.equals("  ")) {
         point3 = getRandomPoint(); }
   }

   public void spawnPoint4() {
      if(point4.equals("  ")) {
         point4 = getRandomPoint(); }
   }

   public void spawnPoint5() {
      if(point5.equals("  ")) {
         point5 = getRandomPoint(); }
   }

   public void resetPoint1() {
      point1 = "  ";
   }

   public void resetPoint2() {
      point2 = "  ";
   }

   public void resetPoint3() {
      point3 = "  ";
   }

   public void resetPoint4() {
      point4 = "  ";
   }

   public void resetPoint5() {
      point5 = "  ";
   }

   public void printBox() {
      System.out.println();
      for(int r = 0; r < height; r++) {
         for(int c = 0; c < length; c++) {
            if(c == lengthPos && r == heightPos) {
               System.out.print(player + " ");
            }
            else if(r == 0 || r == height-1) {
               System.out.print("@ ");
            }
            else if(c == 0 || c == length-1) {
               System.out.print("@ ");
            }

            else if(r == 4 && c == 5) {
               System.out.print(point1);
            }
            else if(r == 6 && c == 16) {
               System.out.print(point2);
            }
            else if(r == 10 && c == 12) {
               System.out.print(point3);
            }
            else if(r == 16 && c == 18) {
               System.out.print(point4);
            }
            else if(r == 17 && c == 1) {
               System.out.print(point5);
            }

            else {
               System.out.print("  ");
            }
         }
         System.out.println();
      }
      System.out.println();
   }
   
   public String toString() {
      return length + " " + height;
   }
}