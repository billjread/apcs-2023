import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class SpellingBee {

    private static char[] letters;
    private static char mustUse;

    public SpellingBee(char[] l, char mU) {
        letters = l;
        mustUse = mU;
    }

    public static boolean checkWord(String word) {
        boolean result = false;
        char[] wordLetters = word.toCharArray();
        int counter = 0;
        
        if(word.length() >= 4) {
           if(word.indexOf(mustUse) >= 0) {
              for(int i = 0; i < wordLetters.length; i++) {
                 for(int o = 0; o < letters.length; o++) {
                    if(wordLetters[i] == letters[o] || wordLetters[i] == mustUse) {
                       counter++;
                       break;
                    }
                 }
              }
              if(counter == wordLetters.length) {
                 result = true;
              }
           }
        }
        return result;
    }

    /**
     * Loads the contents of file "filename" as a String.
     * 
     * @param filename the file to load
     * @return the contents of file "filename"
     */
    public static String loadFile(String filename) {
        String contents = "";
        Path path = Paths.get(filename);
        try {
            path = Path.of(ClassLoader.getSystemResource(filename).toURI());
            contents = Files.readString(path);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return contents;
    }

    public static void main(String[] args) {
        String[] words = loadFile("words_dropped.txt").split("\n");
        System.out.println("Loaded " + words.length + " words");
        
        SpellingBee bee = new SpellingBee("ranglty".toCharArray(), 'y');

        for(int i = 0; i < words.length; i++) {
           if(checkWord(words[i]) == true) {
              System.out.println(words[i]);
           }
           
        }

        // TODO sort words!
        
        Arrays.sort(words);
        
        // TODO what position in the sorted list is the word "search"
        
        for(int o = 0; o < words.length; o++) {
           if(words[o].equals("search")) {
              System.out.println("Search is located at " + o);
           }
        }
    }
}