import java.io.*;
import java.util.*;

//A comment denoted by 1. 2. or 3. indicates it is relevant to the instructions on moodle
//1. 2. 3. respectively identify the instructions by part under "Now here's what you will need to do".
/**
 * Created by Thomas Nix on 10/6/2015.
 * @version 10/6/15
 */
public class driver {

	/**
	 * 
	 * @param args Standard argument parameter for main
	 * @throws IOException Throws IOException as needed for reading file
	 * 
	 * Main class will handle creating a hash map and reading data from both the file and the user.
	 */
    public static void main(String[] args) throws IOException
    {
    	//File was not provided so I wrote one in to make sure the program works 100% of the time.
    	PrintWriter fileWriter = new PrintWriter("hw3file.txt");
    	fileWriter.println("A,B,E");
    	fileWriter.println("F,E,K,B");
    	fileWriter.println("E,A,F");
    	fileWriter.println("K,F,C");
    	fileWriter.println("C,K,B");
    	fileWriter.println("B,C,A,F");
    	fileWriter.close();
    	
        HashMap<String, LinkedList<String>> aHashMap = new HashMap<String, LinkedList<String>>(); //1. Hash map created, String and LinkedList<String>     
        
        //2.Here is where I read in the file using a scanner
        File hwFile = new File("hw3file.txt");
        Scanner fileIn = new Scanner(hwFile);
        
        //Checks for next line
        while (fileIn.hasNextLine()) 
        {
        	//2.With every pass through, a linked list is created and the current line is saved to a temporary string file
           	LinkedList<String> list = new LinkedList<String>();
           	String currentLine = fileIn.nextLine();
        	
           	//2.Splits the current line by the comma delimiter and saves the result as an array
           	String[] tempArray = currentLine.split(",");
           	
           	//2.Adds elements from the newly created array to the list
           	for (String x:tempArray)
           	{
           		list.add(x);
           	}
           	
           	//2.Adds the list to the hashmap with the key of the first character of the line (The node)
           	aHashMap.put(Character.toString(currentLine.charAt(0)), list);
        }
        
        
        //Visual representation of the hash map, to ease visuals in the process of coding.
        for (String keyValue:aHashMap.keySet())
        {
        	System.out.println(keyValue + "\t" + aHashMap.get(keyValue));
        }
       fileIn.close(); //closes the scanner
       
       String[] acceptableInput = {"A","B","C","E","F","K"};
       //3.Prompts the user for two strings from a given set
       System.out.println("Enter two character values from the set (A,B,C,E,F,K):");
       Scanner userIn = new Scanner(System.in);
       String userInputOne = userIn.nextLine().toUpperCase();
       String userInputTwo = userIn.nextLine().toUpperCase();
       
       //Simple fail safe for invalid input
       if (!Arrays.asList(acceptableInput).contains(userInputOne) || !Arrays.asList(acceptableInput).contains(userInputTwo))
       		{System.out.println("Invalid input, terminating program...");
       		 System.exit(0);}
       
       //3.Calls compareList method to compare the list to the node given by the user
       if (compareList(aHashMap.get(userInputOne), userInputTwo))
    	   {
    		   System.out.println("The two nodes " + userInputOne + " and " + userInputTwo + " are directly connected.");
    	   }
       else
    	   {
    		   System.out.println("The two nodes " + userInputOne + " and " + userInputTwo + " are not directly connected.");
    	   }
       }
    
    /**
     * 
     * @param list1 : linked list passed in for comparing to the node given by the user
     * @param checkValue : String node given by the user to determine if it exists in the list (direct connection)
     * @return boolean : returns true if the node exists in the list (direct connection) and false if it does not (indirect connection)
     */
    public static boolean compareList(LinkedList<String> list1, String checkValue)
    {
    	boolean result = false;    			
    	if (list1.contains(checkValue)) //3. Compares node given to the list given by the user
    		{result = true;}    	
    	return result;
    }
}
     
    

       