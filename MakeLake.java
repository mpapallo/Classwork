import java.io.*;
import java.util.*;
public class MakeLake{

    private File input;
    private Scanner scan;
    private String[][] pasture;
    private int e;
    private int n;
    
    public MakeLake(){
	
	try{
	    input = new File("makelake.txt");
	    scan = new Scanner(input);
	}catch(Exception e){}
	pasture = new String[Integer.parseInt(scan.next())][Integer.parseInt(scan.next())];
	e = Integer.parseInt(scan.next());
	n = Integer.parseInt(scan.next());
	
	for (int r = 0; r < pasture.length; r ++){
	    for (int c = 0; c < pasture[0].length; c ++){
		pasture[r][c] = scan.next();
	    }
	}
      
    }

    public String toString(){
	String ans = "";
	for (int r = 0; r < pasture.length; r ++){
	    for (int c = 0; c < pasture[0].length; c ++){
		ans += pasture[r][c] + " ";
	    }
	    ans += "\n";
	}
	return ans;
    }

    public static void main(String[]args){
	MakeLake m = new MakeLake();
	System.out.println(m);
    }

}