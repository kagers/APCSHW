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

    /**Attempts to add a given word to the specified position of the WordGrid.
     *The word is added from left to right, must fit on the WordGrid, and must
     *have a corresponding letter to match any letters that it overlaps.
     *
     *@param word is any text to be added to the word grid.
     *@param row is the vertical locaiton of where you want the word to start.
     *@param col is the horizontal location of where you want the word to start.
     *@return true when the word is added successfully. When the word doesn't fit,
     *or there are overlapping letters that do not match, then false is returned.
     */
    public boolean addWordHorizontal(String word,int row, int col){
	if (word.length()>data[0].length || row>=data.length || col>=data[0].length){
		return false;
	}
	int x=col;
	for (int i=0;i<word.length();i++){
		if (x>=data[0].length || (data[row][x]!='_' && word.charAt(i)!=data[row][x])){
			return false;
		}
		x++;
	}
	for (int i=0;i<word.length();i++){
                data[row][col]=word.charAt(i);
                col++;
        }
	return true;
    }

    /**Attempts to add a given word to the specified position of the WordGrid.
     *The word is added from top to bottom, must fit on the WordGrid, and must
     *have a corresponding letter to match any letters that it overlaps.
     *
     *@param word is any text to be added to the word grid.
     *@param row is the vertical locaiton of where you want the word to start.
     *@param col is the horizontal location of where you want the word to start.
     *@return true when the word is added successfully. When the word doesn't fit,
     *or there are overlapping letters that do not match, then false is returned.
     */
    public boolean addWordVertical(String word,int row, int col){
        if (word.length()>data.length || row>=data.length || col>=data[0].length){
                return false;
        }
        int y=row;
        for (int i=0;i<word.length();i++){
                if (y>=data.length || (data[y][col]!='_' && word.charAt(i)!=data[y][col])){
                        return false;
                }
                y++;
        }
        for (int i=0;i<word.length();i++){
                data[row][col]=word.charAt(i);
                row++;
        }
        return true;
    }


    /**Attempts to add a given word to the specified position of the WordGrid.
     *The word is added diagonally from top left to bottom right, must fit on
     *the WordGrid, and must have a corresponding letter to match any letters
     *that it overlaps.
     *
     *@param word is any text to be added to the word grid.
     *@param row is the vertical locaiton of where you want the word to start.
     *@param col is the horizontal location of where you want the word to start.
     *@return true when the word is added successfully. When the word doesn't fit,
     *or there are overlapping letters that do not match, then false is returned.
     */
    public boolean addWordDiagonal(String word,int row, int col){
        if (word.length()>(Math.min(data[0].length,data.length)) || row>=data.length || col>=data[0].length){
                return false;
        }
        int x=col;
	int y=row;
        for (int i=0;i<word.length();i++){
                if (x>=data[0].length || y>=data.length || (data[y][x]!='_' && word.charAt(i)!=data[y][x])){
                        return false;
                }
                x++;
		y++;
        }
        for (int i=0;i<word.length();i++){
                data[row][col]=word.charAt(i);
                col++;
		row++;
        }
        return true;
    }


}
