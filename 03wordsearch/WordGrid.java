import java.util.*;
import java.io.*;

public class WordGrid{
    private char[][]data;
    
    /**Initialize the grid to the size specified and fill all of the positions
     *with spaces.
     *@param row is the starting height of the WordGrid
     *@param col is the starting width of the WordGrid
     */
    public WordGrid(int rows,int cols){
	data = new char[rows][cols];
	clear();
    }
    
    /**Set all values in the WordGrid to spaces ' '*/
    private void clear(){
	for (int i=0;i<data.length;i++){
	    for (int j=0;j<data[i].length;j++){
		data[i][j]=' ';
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
    /**Attempts to add a given word to the specified position of the WordGrid.
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
	if (v==0 && h==0){
	    return false;
	}
        if (row>=data.length || col>=data[0].length){
	    return false;
        }
        int x=col;
	int y=row;
        for (int i=0;i<word.length();i++){
	    if (x>=data[0].length || y>=data.length || y<0 || x<0 || (data[y][x]!=' ' && word.charAt(i)!=data[y][x])){
		return false;
	    }
	    x=directionH(h,x);
	    y=directionV(v,y);
	}
        for (int i=0;i<word.length();i++){
	    data[row][col]=word.charAt(i);
	    col=directionH(h,col);
	    row=directionV(v,row);
        }
        return true;
    }
    /**Helper method*/
    public static int directionV(int v,int r){
	if (v==-1){
	    return r-1;
	}
	if (v==1){
	    return r+1;
	}
	else {
	    return r;
	}
    }
    /**Helper method*/
    public static int directionH(int h, int c){
	if (h==-1){
	    return c-1;
	}
	if (h==1){
	    return c+1;
	}
	else {
	    return c;
	}
    }
    /**Attempts to randomly add words from an ArrayList of words.
     *
     *@param bank is a word bank from which words to be added are taken.
     */
    public void generate(ArrayList<String> bank){
	Random ayn = new Random();
	for (int i=0; i<bank.size(); i++){
	    boolean done = false;
	    int j = 0;
	    while(j<=25 && !(done)){
		done=addWord((bank.get(i)).toUpperCase(),ayn.nextInt(data.length),ayn.nextInt(data[0].length),randD(),randD());
		j++;
	    }
	}
	filler();
    }
    /**Helper method*/
    public static int randD(){
	Random rand = new Random();
	int d = rand.nextInt(3);
	if (d==0){
	    return -1;
	}
	if (d==1){
	    return 0;
	}
	else{
	    return 1;
	}
    }
    /**Helper method sets all spaces in the WordGrid to random chars.*/
    public void filler(){
	Random ayn = new Random();
	for (int i=0;i<data.length;i++){
	    for (int j=0;j<data[i].length;j++){
		if (data[i][j]==' '){
		    data[i][j]=(char)(ayn.nextInt((90-65)+1)+65);
		}
	    }
	}
    }
}
