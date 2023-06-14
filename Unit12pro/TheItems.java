package Unit12pro;

public class TheItems {
   private int pointVal;
   private int degreeVal;
   private int starVal;
   
   public TheItems() {
      pointVal = 1;
      degreeVal = 4;
      starVal = 8;
   }

   public void doubleTheValue() {
      pointVal *= 2;
      degreeVal *= 2;
      starVal *= 2;
   }

   public int getPointVal() {
      return pointVal;
   }

   public int getDegreeVal() {
      return degreeVal;
   }

   public int getStarVal() {
      return starVal;
   }

}