import java.util.*;
import java.io.*;

public class Drive{
    public static void main(String[]args) throws FileNotFoundException{
	WordGrid g = new WordGrid(20,20);
	/*System.out.println(g);
	System.out.println(g.addWord("word",6,6,0,1));
	System.out.println(g.addWord("hyper",2,0,0,1));
        System.out.println(g.addWord("geom",3,3,1,0));
	System.out.println(g.addWord("geom",1,3,1,0));
	System.out.println(g.addWord("tyfo",0,19,0,-1));
	System.out.println(g);
	System.out.println(g.addWord("typo",0,0,0,-1));
	System.out.println(g);*/
	Random ayn = new Random();
	File mots = new File("words.txt");
	Scanner scan = new Scanner(mots);
	ArrayList<String> slova = new ArrayList<String>();
	while(scan.hasNextLine()){
	    slova.add(scan.nextLine());
	}
	System.out.println(slova);
	g.generate(slova);
	System.out.println(g);
	/*for (int i=0; i<slova.length; i++){
	    while(){
		g.addWord(slova[i],ayn.nextInt();
	    }
	}*/
	//g.generate(slova);
	//System.out.println(g);
    }
}
