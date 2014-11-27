import java.util.*;
import java.io.*;

public class Driver{
    public static void main(String[]args) throws FileNotFoundException{
	if (args.length==2){
	    WordGrid w = new WordGrid(Integer.parseInt(args[0]),Integer.parseInt(args[1]));
	    w.loadWordsFromFile("words.txt",true);
	    System.out.println(w.wordsInPuzzle());
	    System.out.println(w);
	}
	else if (args.length==3){
	   WordGrid w = new WordGrid(Integer.parseInt(args[0]),Integer.parseInt(args[1])); 
	    w.setSeed(Integer.parseInt(args[2]));
	    w.loadWordsFromFile("words.txt",true);
	    System.out.println(w.wordsInPuzzle());
	    System.out.println(w);
	}
	else if (args.length==4){
	    WordGrid w = new WordGrid(Integer.parseInt(args[0]),Integer.parseInt(args[1]));
	    w.setSeed(Integer.parseInt(args[2]));
	    boolean b=true;
	    if (args[3].equals("1")){
		b=false;
	    }
	    w.loadWordsFromFile("words.txt",b);		
	    System.out.println(w.wordsInPuzzle());
	    System.out.println(w);
	}
	else{
	    System.out.println("Input arguments in the format:");
	    System.out.println("java Driver rows cols [randomSeed [answers]]");
	}
    }
}
