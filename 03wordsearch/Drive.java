public class Drive{
    public static void main(String[]args){
	WordGrid g = new WordGrid(5,5);
	System.out.println(g);
	System.out.println(g.addWord("word",6,6,0,1));
	System.out.println(g.addWord("hyper",2,0,0,1));
        System.out.println(g.addWord("geom",3,3,1,0));
	System.out.println(g.addWord("geom",1,3,1,0));
	System.out.println(g.addWord("tyfo",0,0,1,1));
	System.out.println(g.addWord("typo",0,0,1,1));
	System.out.println(g);
    }
}
