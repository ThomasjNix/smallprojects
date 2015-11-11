
/**
 * 
 * @author Thomas Nix
 * @version September 14th, 2015
 *
 */
public class driver {
	
	/**
	 * This is the main class, in this project it is solely responsible for sorting a hard coded array using bubble sort.
	 * @param args
	 */
	public static void main(String [] args)
	{
		//initialization of variables; an array, a holder variable, and a variable used to do multiple passes on the array for sorting.
		int[] anArray =  {3,7,67,2,6,78,36,367347,8,45,12,1};
		int tempVar = 0;
		int passVar = anArray.length-1;
		
		//Prints the original unsorted array
		System.out.println("\nUnsorted Array:\nIndex Num\tElement value");
		for (int i = 0; i < anArray.length; i++){
			System.out.println(i + "\t\t"+ anArray[i]);
		}
		
		//passVar starts at the array length-1 and the while loop continues to do passes until the last variable has been sorted (passVar=0)
		while (passVar!=0){
			for (int counter = 0; counter < passVar; counter++){
				if (anArray[counter] > anArray[counter+1]){
				tempVar = anArray[counter+1];
				anArray[counter+1] = anArray[counter];
				anArray[counter] = tempVar;
				//This code compares one element to the element next to it (ex: anArray[3] and anArray[4]) and swaps them if the earlier element is larger
				}
			}
			passVar--;//once the largest element in anArray[] has been moved to anArray[passVar], passVar - 1 to pass through all but 
					  //the most recently sorted element
		}
		
		//prints the sorted array
		System.out.println("\nSorted Array:\nIndex Num\tElement value");
		for (int i = 0; i < anArray.length; i++){
			System.out.println(i + "\t\t"+ anArray[i]);
		}
	}
}
