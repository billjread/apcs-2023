package unit10;

public class Recur {

    public static int fun3(int n) { //3 to the power of n
        if (n == 0)
            return 1;
        else
            return 3 * fun3(n - 1);
    }

    public static int f(int n) { //finds fibonacci nth-term
        if (n == 0)    
            return 0; 
        else if (n == 1)
            return 1;
        else 
            return f(n - 1) + f(n - 2);
    }

    public static boolean has(String input) { //returns whether or not the input String has recurring letters side-by-side
        if (input.length() < 2)
            return false;
        return (input.charAt(0) == input.charAt(1) || has(input.substring(1)));
    }

    public static boolean pot(String input) { //returns whether or not the String is the same spelled backwards and forwards
        if (input.length() < 2)
            return true;
        return (input.charAt(0) == input.charAt(input.length() - 1)
                && pot(input.substring(1, input.length() - 1)));
    }

    public static double two(int n) { //makes n a big double
        if (n < 1)
            return 1.0 / 2;
        return 1.0 / (2 + two(n - 1));
    }

    public static String mop(int n) { //returns n in binary form
        if (n / 2 == 0)
            return "" + n % 2;
        return mop(n / 2) + n % 2;
    }

    public static int cat(int x) { //adds all numbers together in x;
        if (x == 0)
            return x;
        return ((x % 10) + cat(x / 10));
    }

    public static int mystery(int x) { //
        if (x <= 1)
            return 1;
        // return mystery(x - 1) + mystery(x - 2);
        return 2 * mystery(x - 2);
        // return 2 * mystery(x - 1);
        // return 4 * mystery(x - 4);
        // return 4 + mystery(x - 1);
    }

    public static void main(String[] args) {

        //Consider function fun3
        System.out.println(fun3(5));

        // Consider function f
        System.out.println(f(6));

        // Consider function has
        System.out.println(has("hello"));
        System.out.println(has("howdy"));

        // Consider function pot
         System.out.println(pot("deified"));
         System.out.println(pot("deepfried"));

        // Consider function two
         System.out.println(two(6));

        // Consider function mop
         System.out.println(mop(5));

        // Consider function cat
         System.out.println(cat(4096));

        // Fix function mystery so that mystery(10) == 32
        System.out.println(mystery(10));

    }

}