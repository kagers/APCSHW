import java.util.*;
import java.io.*;

public class Drive{
    public static void main(String[]args) throws FileNotFoundException{
	WordGrid g = new WordGrid(15,15);
	File mots = new File("words.txt");
	Scanner scan = new Scanner(mots);
	ArrayList<String> slova = new ArrayList<String>();
	while(scan.hasNextLine()){
	    slova.add(scan.nextLine());
	}
	g.generate(slova);
	System.out.println(g);
    }
}
