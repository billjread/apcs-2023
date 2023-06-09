package unit11;

// 2018 FRQ #3
// https://secure-media.collegeboard.org/ap/pdf/ap18-frq-computer-science-a.pdf#page=12
interface StringChecker {
    /** Returns true if str is valid. */
    boolean isValid(String str);
}

public class CodeWordChecker implements StringChecker {

    private String noString;
    private int minSize;
    private int maxSize;

    public CodeWordChecker(String nostr) {
        noString = nostr;
        minSize = 6;
        maxSize = 20;
    }

    public CodeWordChecker(int min, int max, String nostr) {
        minSize = min;
        maxSize = max;
        noString = nostr;
    }

    /** Returns true if str is valid. */
    public boolean isValid(String str) {
        boolean x = false;
        if (str.length() >= minSize && str.length() <= maxSize) {
            if (str.contains(noString) == false){
                 x = true;
            }
        }
        return x;
    }

    static boolean check(boolean test) throws AssertionError {
        if (!test)
            throw new AssertionError("sad panda");
        return test;
    }

    public static void main(String[] args) {
        //uncomment the following lines to test your code
        StringChecker sc1 = new CodeWordChecker(5, 8, "$");
        check(sc1.isValid("happy"));
        check(!sc1.isValid("happy$"));
        check(!sc1.isValid("Code"));
        check(!sc1.isValid("happyCode"));
        check(!sc1.isValid("happy$Code"));
        check(!sc1.isValid("Code$happy"));

        StringChecker sc2 = new CodeWordChecker("pass");
        check(sc2.isValid("MyPass"));
        check(!sc2.isValid("Mypassport"));
        check(!sc2.isValid("happy"));
        check(!sc2.isValid("1,000,000,000,000,000"));

        System.out.println("Happy Panda! \uD83D\uDC3C");
    }

}
