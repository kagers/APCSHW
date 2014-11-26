import java.util.*;
import java.io.*;

public class Driver{
    public static void main(String[]args) throws FileNotFoundException{
	WordGrid w = new WordGrid(35,35);
	/*File mots = new File("words.txt");
	Scanner scan = new Scanner(mots);
	ArrayList<String> slova = new ArrayList<String>();
	while(scan.hasNextLine()){
	    slova.add(scan.nextLine());
	}
	g.generate(slova);*/
	w.loadWordsFromFile("words.txt",false);
	System.out.println(w);
    }
}
