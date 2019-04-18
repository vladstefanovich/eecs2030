package A2Q1;
import java.util.*;
/**
 * Represents a sorted integer array.  Provides a method, kpairSum, that
 * determines whether the array contains two elements that sum to a given
 * integer k.  Runs in O(n) time, where n is the length of the array.
 * @author jameselder
 */
public class SortedIntegerArray {

    protected int[] sortedIntegerArray;

    public SortedIntegerArray(int[] integerArray) {
        sortedIntegerArray = integerArray.clone();
        Arrays.sort(sortedIntegerArray);
    }

/**
 * Determines whether the array contains two elements that sum to a given
 * integer k. Runs in O(n) time, where n is the length of the array.
 * @author jameselder
 */
    public boolean kPairSum(Integer k) {
    	//implement this method
    	return kPairSumInterval(k,0,sortedIntegerArray.length - 1);
    }
    
    private boolean kPairSumInterval(Integer k, int i, int j) {
    	if (i == j || sortedIntegerArray.length == 0) {
    		return false;
    	} else {
    		if (sortedIntegerArray[i] + sortedIntegerArray[j] == k) {
    			return true;
    		} else if (sortedIntegerArray[i] + sortedIntegerArray[j] > k) {
    			return true && kPairSumInterval(k,i,j - 1);
    		} else {
    			return true && kPairSumInterval(k,i + 1,j);
    		}
    	}
    }
    

    public static void main (String[] args) {
    	
    	
    	
    }
    
}