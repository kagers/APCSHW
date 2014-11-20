public class Drive{
    public static void main(String[]args){
	WordGrid g = new WordGrid(5,5);
	System.out.println(g);
	System.out.println(g.addWordHorizontal("word",6,6));
	System.out.println(g.addWordHorizontal("hyper",2,0));
        System.out.println(g.addWordVertical("geom",3,3));
	System.out.println(g.addWordVertical("geom",1,3));
	System.out.println(g.addWordDiagonal("tyfo",0,0));
	System.out.println(g.addWordDiagonal("typo",0,0));
	System.out.println(g);
    }
}
