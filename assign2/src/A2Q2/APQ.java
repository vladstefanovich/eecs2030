package A2Q2;

import java.util.*;

/**
 * Adaptible priority queue using location-aware entries in a min-heap, based on
 * an extendable array.  The order in which equal entries were added is preserved.
 *
 * @author jameselder
 * @param <E> The entry type.
 */
public class APQ<E> {

    private final ArrayList<E> apq; //will store the min heap
    private final Comparator<E> comparator; //to compare the entries
    private final Locator<E> locator;  //to locate the entries within the queue

    /**
     * Constructor
     * @param comparator used to compare the entries
     * @param locator used to locate the entries in the queue
     * @throws NullPointerException if comparator or locator parameters are null
     */
    public APQ(Comparator<E> comparator, Locator<E> locator) throws NullPointerException {
        if (comparator == null || locator == null) {
            throw new NullPointerException();
        }
        apq = new ArrayList<>();
        apq.add(null); //dummy value at index = 0
        this.comparator = comparator;
        this.locator = locator;
    }

    /**
     * Inserts the specified entry into this priority queue.
     *
     * @param e the entry to insert
     * @throws NullPointerException if parameter e is null
     */
    public void offer(E e) throws NullPointerException {
    //implement this method    
    	apq.add(e);
    	upheap(size());
    }

   /**
     * Removes the entry at the specified location.
     *
     * @param pos the location of the entry to remove
     * @throws BoundaryViolationException if pos is out of range
     */
    public void remove(int pos) throws BoundaryViolationException {
    //implement this method
    	apq.set(pos, apq.get(size()));
    	apq.set(size(), null);
    	downheap(pos);
    	
    }

   /**
     * Removes the first entry in the priority queue.
     */
    public E poll() {
        //implement this method
    	E toReturn = apq.get(1);
    	apq.remove(1);
    	return toReturn;
    }

  /**
     * Returns but does not remove the first entry in the priority queue.
     */
     public E peek() {
        if (isEmpty()) {
            return null;
        }
        return apq.get(1);
    }

   public boolean isEmpty() {
        return (size() == 0); 
    }

    public int size() {
        return apq.size() - 1; //dummy node at location 0
    }


    /**
     * Shift the entry at pos upward in the heap to restore the minheap property
     * @param pos the location of the entry to move
     */
    private void upheap(int pos) {
        //implement this method  	
    	if (pos > 1) {
    		int parent = pos/2;
    		if (comparator.compare(apq.get(pos), apq.get(parent)) >= 1) {
    			return;
    		}
    		swap(pos, parent);
    		upheap(parent);
    	}
    	
    }

    /**
     * Shift the entry at pos downward in the heap to restore the minheap property
     * @param pos the location of the entry to move
     */
    private void downheap(int pos) {
        //implement this method
    	int index;
    	int leftchild = 2*pos;
    	int rightchild = 2*pos+1;
    	
    	if (leftchild >= size()) return;
    	else if (rightchild >= size()) {
    		if ( comparator.compare(apq.get(pos), apq.get(leftchild)) > 0) {
    			swap(pos, leftchild);
    			downheap(leftchild);
    		} 
    	}
    	else {
    		E min;
    		if (comparator.compare(apq.get(leftchild), apq.get(rightchild)) > 0) {
    			min = apq.get(rightchild);
    		} else {
    			min = apq.get(leftchild); 
    		}
    		
    		if (comparator.compare(apq.get(leftchild), min) == 0) {
    			index = leftchild;
    		} else {
    			index = rightchild;
    		}
    		
    		if (comparator.compare(apq.get(pos), apq.get(index)) > 0) {
    			swap(pos, index);
    		}
    		
    		downheap(leftchild);
    	}
    }

    /**
     * Swaps the entries at the specified locations.
     *
     * @param pos1 the location of the first entry 
     * @param pos2 the location of the second entry 
     */
    private void swap(int pos1, int pos2) {
        //implement this method
    	E tmp = apq.get(pos1);
    	apq.set(pos1, apq.get(pos2));
    	apq.set(pos2, tmp);
    }
}