
import java.util.*;
import java.io.*;

/**
 * 
 * @author Thomas Nix
 * @version 10/26/2015
 * Implements file writing, file reading, and breadth-first search.
 */
public class driver { //Driver class for the code
/**
 * main method that handles all calculations and user inputs
 * @param args
 * @throws FileNotFoundException
 */
public static void main(String[] args) throws FileNotFoundException
{
Queue<String> charQ = new LinkedList<String>(); //Writing the file to be later read
PrintWriter fileWriter = new PrintWriter("hw4file.txt");
   	fileWriter.println("A,E,D,B");
   	fileWriter.println("E,A");
   	fileWriter.println("D,A");
   	fileWriter.println("B,A,C");
   	fileWriter.println("C,B");
   	fileWriter.close();//closes the file writer
   	HashMap<String, LinkedList<String>> hashForQ = new HashMap<String, LinkedList<String>>();//creates a hashmap for file input
   	File hwFile = new File("hw4file.txt");
       Scanner fileIn = new Scanner(hwFile); //scanner for the file
       while (fileIn.hasNextLine()) 
       {
    	   /*
    	    * This set of code creates a linked list (aList) and a temporary array (tempArray)
    	    * Each line is set to the string currentLine and split by the , delimmeter
    	    * then added to the array. Afterwards an enhanced for loop adds each element
    	    * in the array to the list, then the list is added as an entry in the hashmap
    	    * once the line is read, with the first character being the key value (first node)
    	    * this continues until the entire file has been read.
    	    */
          LinkedList<String> aList = new LinkedList<String>();
          String currentLine = fileIn.nextLine();           
          String[] tempArray = currentLine.split(",");
          for (String x:tempArray)
          {
          aList.add(x);
          }
          hashForQ.put(Character.toString(currentLine.charAt(0)), aList);
       }
       
    //This simply gets the users input   
    Scanner uScanner = new Scanner(System.in);
    System.out.println("Enter first node");
    String startingValue = uScanner.nextLine();
    
    //Creates a Queue and for the hashmap entry of the user entered node, 
    //it adds the entries in that linked list associated with the node to the queue
    Queue<String> aQ = new LinkedList<String>();
    for(int x = 0; x < hashForQ.get(startingValue).size(); x++)
       {
       	aQ.add(hashForQ.get(startingValue).get(x));
       }
    Queue<String> visited = new LinkedList<String>(); //creates a queue for referencing what nodes have been visited
    while (aQ.size()>=1) //while the linked list has at least one element
    {
      if (!visited.contains(aQ.peek())) //if the current node hasn't been visited
      {
       	System.out.println(hashForQ.get(aQ.peek())); //print out the linked list associated with the node
       	visited.add(aQ.peek()); //add the node to the visited queue
       	
       	//for all the nodes in the linked list for the peek of the queue
       	for (String x : hashForQ.get(aQ.peek()))
       	{
       		if(!visited.contains(x))//if the node hasn't been visited
       		{
       			aQ.add(x); // add it to the queue
       		} 
       	}
      }
      aQ.remove(); //remove function to take the top value off the queue
    }
}
}