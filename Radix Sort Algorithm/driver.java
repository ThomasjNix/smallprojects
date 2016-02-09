import java.io.*;
import java.util.*;

/*
 * @author Thomas Nix
 * @version 2/1/2016
 */
public class driver {

		private static BufferedReader bReader;//local field for buffered reader

		/*
		 * main class for reading file and calling radix sort
		 * throws IOExcpetion to read file
		 */
		public static void main(String[] args) throws IOException
		{
			//Read file, created buffered reader and tokenizer, separate tokens by commas
			File inFile = new File("radixList.txt");
			FileReader readFile = new FileReader(inFile);
			bReader = new BufferedReader(readFile);
			StringTokenizer breakUp = new StringTokenizer(bReader.readLine(), ",");
			
			//create array by tokens (each number between commas), add to array
			int[] readInArray = new int[breakUp.countTokens()];
			for (int i = 0; i < readInArray.length; i++){
				readInArray[i] = Integer.parseInt(breakUp.nextToken());
			}
			
			
			//print unsorted array
			System.out.println("Unsorted array:\n");
			for (int i = 0; i < readInArray.length; i++)
			{
				System.out.println("Element #" + i + ":\t" + readInArray[i]);
			}
			
			//use radix constructor to create an object
			//run sortArray based off array read from file
			Radix aRadixSort = new Radix(readInArray);
			aRadixSort.sortArray();
			
			//print sorted array
			System.out.println("\nSorted array:\n");
			for (int i = 0; i < aRadixSort.currentArray.length; i++)
			{
				System.out.println("Element #" + i + ":\t" + aRadixSort.currentArray[i]);
			}
		}
}
