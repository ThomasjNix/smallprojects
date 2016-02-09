import java.util.*;

/*
 * @author Thomas Nix
 * @version 2/1/2016
 * Main radix sort class responsible for receiving and sorting arrays using radix sort
 */
public class Radix {

	int[] currentArray; //global field for sortArray use
	
	//Constructor for setting arrays equal
	public Radix(int[] inArray){
		currentArray = inArray;
	}
	
	/*
	 * sortArray() uses radix sort to sort currentArray
	 * @return int[] returns sorted array
	 */
	public int[] sortArray() { 
		
	
		int n = 1; //divide by n integer created
		LinkedList<Integer>[] liListArr = new LinkedList[10];
		for (int i = 0; i < liListArr.length; i++)
		{
			liListArr[i] = new LinkedList<Integer>(); //initializes the linked lists in the array
		}
		
		//Main loop that cycles through 10, 100, 1000 for modulus and assigns values to the new array
		for (int m = 10; m <= 1000; m *=10)
		{
			//create variable
			for (int i = 0; i < liListArr.length; i++)
			{
				liListArr[i] = new LinkedList<Integer>(); //re-initializes the linked lists on each pass
			}
			int liIndex=0;//sets the linked list indexer back to 0			
			
			//Modulus and divides elements in the initial array and then adds them
			//To the appropriate spot in the linked list array
			for (int currArrayCounter = 0; currArrayCounter < currentArray.length; currArrayCounter++){					
				liIndex = (currentArray[currArrayCounter]%m)/n;				
				liListArr[liIndex].add(currentArray[currArrayCounter]);
				
			}
			
			//loop through liListArr in order, placing elements back into current array (overwriting)
			int currentArrayIndexer = 0;//Concrete array placeholder
			for (int i = 0; i < liListArr.length; i++) //for all linked lists in the array
			{
				if (liListArr[i] != null)//so long as they are not null
				{
					for (int p = 0; p < liListArr[i].size(); p++) // for all elements in the linked list
					{
						currentArray[currentArrayIndexer] = liListArr[i].get(p);
						currentArrayIndexer++;
						//add them in order to the array
						//increase the array indexer as to not overwrite
					}
				}
			}
			n*=10;//multiplies n by 10 for each pass (1, 10, 100)
		}
		
		return currentArray;
		//return currentArray after 3rd iteration
	}
}
