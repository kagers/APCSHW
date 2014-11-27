import java.util.*;
import java.io.*;

public class WordGrid{
    private char[][]data;
    private Random ayn;
    private ArrayList<String> inGrid;
    
    /**Initialize the grid to the size specified and fill all of the positions
     *with spaces.
     *@param row is the starting height of the WordGrid
     *@param col is the starting width of the WordGrid
     */
    public WordGrid(int rows,int cols){
	data = new char[rows][cols];
        ayn = new Random();
	clear();
	inGrid = new ArrayList<String>();
    }
    
    /**Set all values in the WordGrid to underscores '_'*/
    private void clear(){
	for (int i=0;i<data.length;i++){
	    for (int j=0;j<data[i].length;j++){
		data[i][j]='_';
	    }
	}
    }
    
    /**The proper formatting for a WordGrid is created in the toString.
     *@return a String with each character separated by spaces, and each row
     *separated by newlines.
     */
    public String toString(){
	String ret="";
	for (int i=0;i<data.length;i++){
	    for (int j=0;j<data[i].length;j++){
		ret+=data[i][j]+" ";
	    }
	    ret+="\n";
        }
	return ret;
    }

    /**Show the words currently contained in the WordGrid.
     *@return a formatted String containing the words.
     */
    public String wordsInPuzzle(){
	String ret="";
	for (int i=0;i<inGrid.size();i++){
	    ret+=inGrid.get(i)+"\n";
	}
	return ret;
    }

    /**Set the seed for Random object.
     *@param seed is the seed for the Random.
     */
    public void setSeed(long seed){
	ayn.setSeed(seed);
    }

    /**Attempt to add a given word to the specified position of the WordGrid.
     *The word is added according to the specified direction, must fit on
     *the WordGrid, and must have a corresponding letter to match any letters
     *that it overlaps.
     *
     *@param word is any text to be added to the word grid.
     *@param row is the vertical locaiton of where you want the word to start.
     *@param col is the horizontal location of where you want the word to start.
     *@param v is how much the vertical position should change.
     *@param h is how much the horizontal position should change.
     *@return true when the word is added successfully. When the word doesn't fit,
     *or there are overlapping letters that do not match, then false is returned.
     */
    public boolean addWord(String word,int row, int col,int v, int h){
	if ((v==0 && h==0) || (row>=data.length || col>=data[0].length)){
	    return false;
        }
        int x=col;
	int y=row;
        for (int i=0;i<word.length();i++){
	    if (x>=data[0].length || y>=data.length || y<0 || x<0 || (data[y][x]!='_' && word.charAt(i)!=data[y][x])){
		return false;
	    }
	    x+=h;
	    y+=v;
	}
        for (int i=0;i<word.length();i++){
	    data[row][col]=word.charAt(i);
	    col+=h;
	    row+=v;
        }
        return true;
    }

    /**Helper attempts to randomly add words from an ArrayList of words.
     *@param allWords is a word bank from which words to be added are taken.
     */
    private void addManyWordsToList(ArrayList<String> allWords){
	randomize(allWords);
	for (int i=0; i<allWords.size(); i++){
	    boolean done = false;
	    int j = 0;
	    while(j<=25 && !(done)){
		done=addWord((allWords.get(i)).toUpperCase(),ayn.nextInt(data.length),ayn.nextInt(data[0].length),ayn.nextInt(3)-1,ayn.nextInt(3)-1);
		j++;
	    }
	    if (done){
		inGrid.add(allWords.get(i));
	    }
	}
    }

    /**Helper randomizes the order of elements in an ArrayList.
     *@param L is the ArrayList<Integer> to be randomized.
     */
    private void randomize(ArrayList<String> L){
	for (int i=0;i<L.size();i++){
	    L.set(i,L.set(ayn.nextInt(L.size()),L.get(i)));
	}
    }

    /**Helper sets all spaces in the WordGrid to random chars.*/
    private void filler(){
	for (int i=0;i<data.length;i++){
	    for (int j=0;j<data[i].length;j++){
		if (data[i][j]=='_'){
		    data[i][j]=(char)(ayn.nextInt((90-65)+1)+65);
		}
	    }
	}
    }

    /**Load words from a text file into an ArrayList and attempts to 
     *add them to the WordGrid.
     *
     *@param fileName is the path of the words file
     *@param fillRandomLetters indicates whether or not the empty slots
     *of the WordGrid should be filled.
     */
    public void loadWordsFromFile(String fileName, boolean fillRandomLetters) throws FileNotFoundException{
	File mots = new File(fileName);
	Scanner scan = new Scanner(mots);
	ArrayList<String> slova = new ArrayList<String>();
	while(scan.hasNextLine()){
	    slova.add(scan.nextLine());
	}
	addManyWordsToList(slova);
	if (fillRandomLetters){
	    filler();
	}
    }
}
