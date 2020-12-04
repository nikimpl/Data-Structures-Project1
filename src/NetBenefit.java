import java.io.*;
import java.util.*;
import java.io.PrintStream;

public class NetBenefit extends IntQueueImpl{

	private static IntQueueImpl queue = new IntQueueImpl(0); //creates new empty queue
    private static File f = null;
	private static BufferedReader reader = null;
    
	//constructor for class NetBenefit
    NetBenefit(int maxN){super(maxN);}

    public static void main(String[] args) {
        
		//find file
        try{
            f = new File(args[0]);
            
        } catch (NullPointerException e) {
            System.err.println("File not found.");
        }

        //open file
        try {
            reader = new BufferedReader(new FileReader(f));
        } catch (FileNotFoundException e) {
            System.err.println("Error opening file.");
        }
        
		//calculate profit or damage
        try{
            
            String line = reader.readLine();
            Scanner in = new Scanner(line);
            int profit = 0;
			while(line!=null){         
				if(in.next().equals("buy")){
					int n = in.nextInt(); //n is the amount of stocks that are bought
                    in.next();
					int price = in.nextInt(); //the price in which the stocks are bought
                    int i=1;
					while(i<=n){
						queue.put(price); //adds n new items on queue, each one containing a price
						i++;
					}
				}
				else{
                    int n = in.nextInt();
                    if (n > queue.size()){ //if the user wants to sell more stocks than the amount they currently own
                        System.out.println("Number of stocks available for sale: "+queue.size());
                        System.out.println("Number of stocks that are wanted for sale: "+n);
                        System.out.println("Error. Number of stocks for sale is out of bounds with the current number of stocks available");
                    }else{
                        in.next();
                        int price = in.nextInt();
                        int j=1;
                        while(j<=n){
                            profit = profit+price - queue.get(); //calculates the profit or damage
                            j++;
                        }
                        System.out.println("The"+((profit>=0) ? " profit" : " damage") +" is: "+profit);
                    }
				}
                line = reader.readLine();
                
                if (line != null){ 
                    in = new Scanner(line);
                }
            }
            in.close();
        }
        
        catch (IOException e){
            System.err.println("Error reading file.");
        }

        //close file
        try {
            reader.close();
            reader = null;
        } catch(IOException e) {
            System.err.println("Error closing file.");
        }
    }
}