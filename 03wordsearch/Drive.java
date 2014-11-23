import java.util.*;
import java.io.*;

public class Drive{
    public static void main(String[]args) throws FileNotFoundException{
	WordGrid g = new WordGrid(20,20);
	File mots = new File("words.txt");
	Scanner scan = new Scanner(mots);
	ArrayList<String> slova = new ArrayList<String>();
	while(scan.hasNextLine()){
	    slova.add(scan.nextLine());
	}
	System.out.println(slova);
	g.generate(slova);
	System.out.println(g);
    }
}
