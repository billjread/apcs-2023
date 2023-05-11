public class PiDay {

    // https://en.wikipedia.org/wiki/Pi#Rate_of_convergence
    public static double piDay(int n, boolean subtract) {
       if(n<=5000) {
          if(subtract == true) {
             return 4.0/n - piDay(n+2, true);
          }
          else if(subtract == false) {
             return 4.0/n + piDay(n+2, false);
          }
       }
       return 0;
    }

    public static void main(String args[]) {
        //  Gregory–Leibniz
        double pi = piDay(1, true);

        // Nilakantha
        //double pi = 3.0 + piDay(3, false);

        System.out.println("pi = " + pi);
    }
}
