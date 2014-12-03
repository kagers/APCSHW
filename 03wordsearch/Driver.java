import java.util.*;
import java.io.*;

public class Driver{
    public static void main(String[]args) throws FileNotFoundException{
	if (args.length>=2 && args.length<=4){
	    try {
		WordGrid w = new WordGrid(Integer.parseInt(args[0]),Integer.parseInt(args[1]));
		if (args.length>=3){
		    w.setSeed(Long.parseLong(args[2]));
		}
		boolean b=!((args.length==4)&&(args[3].equals("1")));
		w.loadWordsFromFile("words.txt",b);
		System.out.println("\nFind these words:");
		System.out.println(w.wordsInPuzzle()+"\n");
		System.out.println(w);
	    }
	    catch (Exception e){
		System.out.println("Input numeric arguments in the format:");
		System.out.println("java Driver rows cols [randomSeed [answers]]");
	    }
	}
	else{
	    System.out.println("Input numeric arguments in the format:");
	    System.out.println("java Driver rows cols [randomSeed [answers]]");
	}
    }
}
