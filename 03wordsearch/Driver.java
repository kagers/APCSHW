import java.util.*;
import java.io.*;

public class Driver{
    public static void main(String[]args) throws FileNotFoundException{
	WordGrid w = new WordGrid(10,10);
	w.setSeed(11);
	w.loadWordsFromFile("words.txt",false);
	System.out.println(w);
	System.out.println(w.wordsInPuzzle());
    }
}
