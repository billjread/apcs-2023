public class TheBorder {
   private int length;
   private int height;
   private int lengthPos;
   private int heightPos;
   private String player;

   
   public TheBorder(String p) {
      length = 22;
      height = 20;
      lengthPos = 10;
      heightPos = 10;
      player = p;
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
      
   public void printBox() {
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
            else {
               System.out.print("  ");
            }
         }
         System.out.println();
      }
   }
   
   public String toString() {
      return length + " " + height;
   }
}