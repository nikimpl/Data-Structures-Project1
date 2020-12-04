import java.io.*;
import java.util.*;
import java.util.Scanner;
import java.util.StringTokenizer;



public class TagMatching extends StringStackImpl{

    private static StringStackImpl s1 = new StringStackImpl(0); //creates new empty stack
	private static File f = null;
    private static BufferedReader reader = null;

	//constructor for class TagMatching
    TagMatching(int maxN){super(maxN);}

	//check is html file has matching tags
    public static boolean hasMatchingTags(File file) {

        try{
            String line = reader.readLine();
            while(line!=null){
                StringTokenizer str = new StringTokenizer(line);
                String token = str.nextToken();
                while(token != null){  
                    if(token.startsWith("<")){
                            if(token.substring(1).startsWith("/")){ //we have encountered a closing tag
                                if(token.substring(2).equals(s1.peek())){
                                    s1.pop();
                                }
                            }
                            else{ //we have encountered an opening tag
                                s1.push(token.substring(1));
                            }
                        }
                        if (str.hasMoreTokens()){  
                            token = str.nextToken();
                        }else{
                            token = null;
                        }
                    }  
                    line = reader.readLine();
                }
                
            if (s1.isEmpty()){ //all opening tags have found their matching closing tag
                return true;

            }else{ //not all opening tags have found their matching closing tag
                return false;
            }
        }catch (IOException e){
            System.err.println("Error reading file.");
            return false;
        }
    
    }

    public static void main(String[] args) {

		//find file
        try{
            f = new File(args[0]);
        }
        catch (NullPointerException e){
            System.err.println ("File not found.");
        }
	
		//open file
        try{
            reader = new BufferedReader(new FileReader(f));
        }
        catch (FileNotFoundException e ){
            System.err.println("Error opening file. Terminating.");
            System.exit(1); 
        }

        if(hasMatchingTags(f)){
            System.out.println("The file has matching tags.");
        } else{
            System.out.println("The file doesn't have matching tags.");

        }
        
		//close file
        try {
            reader.close();
        }
        catch (IOException e){
            System.err.println("Error closing file.");
        }
    }
}

    