
public class TertiarySearchImplementation {

	public static void main(String[] args) {
		TertiarySearchImplementation obj = new TertiarySearchImplementation();
		
		int val = 18; //Element to be searched ----------
		int[] arraySearch = {1,2,3,4,5,6,7,8,10,11,12,13,14,15,17,19}; //Add or remove elements here ----
		//It is assumed that elements of "arraySearch" are in ascending order. -----------
		
		System.out.print("Array Elements: ");
		for (int i=0;i<arraySearch.length;i++) 
		{
			System.out.print(arraySearch[i] + ", ");
		}
		System.out.println("--END\n");
		System.out.println("Element to be searched: '" + val + "'\nNumber of elements in array: '" + arraySearch.length + "'\n");
		
		int x = obj.searchTertiary(arraySearch,0,arraySearch.length-1,val); //function returning position of element
		
		if (x == -1)
			System.out.println(val + " not found.");
		else
			System.out.println(val + " found at position: " + (x+1)); //1 has been added to show position according to 1-15 NOT 0-14
		
	}
	
	public int searchTertiary(int[] arraySearch, int low, int high, int val)
	{
		if (low>high) { return -1;}
		
		if ((val<arraySearch[low])||(val>arraySearch[high])) {return -1;}
		
		int mid1 = low + ((high + 1 - low)/3);
		int mid2 = low + 2 * ((high + 1 - low)/3);
		
		if (arraySearch[low]==val) {return low;}
		
		if (arraySearch[mid1]==val) {return mid1;}
		
		if (arraySearch[mid2]==val) {return mid2;}
		
		if (arraySearch[high]==val) {return high;}
		
		if (val < arraySearch[mid1]) { return searchTertiary(arraySearch,low+1,mid1-1,val); }
		
		if ((val > arraySearch[mid1])&&(val<arraySearch[mid2])) { return searchTertiary(arraySearch,mid1+1,mid2-1,val); }
		
		else /*(val < arraySearch[mid1])*/ { return searchTertiary(arraySearch,mid2+1,high-1,val); }
		
	}

}
