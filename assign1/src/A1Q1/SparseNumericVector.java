package A1Q1;
import java.util.*;

/**
 * Represents a sparse numeric vector. Elements are comprised of a (long)
 * location index an a (double) value.  The vector is maintained in increasing
 * order of location index, which facilitates numeric operations like
 * inner products (projections).  Note that location indices can be any integer
 * from 1 to Long.MAX_VALUE.  The representation is based upon a
 * singly-linked list.
 * The following methods are supported:  iterator, getSize, getFirst,
 * add, remove, and dot, which takes the dot product of the with a second vector
 * passed as a parameter.
 * @author jameselder
 */
public class SparseNumericVector implements Iterable {

    protected SparseNumericNode head = null;
    protected SparseNumericNode tail = null;
    protected long size;

  /**
     * Iterator
     */
    @Override
    public Iterator<SparseNumericElement> iterator() { //iterator
        return new SparseNumericIterator(this);
    }

    /**
     * @return number of non-zero elements in vector
     */
   public long getSize() {
        return size;
    }

     /**
     * @return the first node in the list.
     */
    public SparseNumericNode getFirst() {
        return head;
    }
    
    /**
     * Add the element to the vector.  It is inserted to maintain the
     * vector in increasing order of index.  If the element has zero value, or if 
     * an element with the same index already exists, an UnsupportedOperationException is thrown. 
     * @param e element to add
     */
  public void add(SparseNumericElement e) throws UnsupportedOperationException {
       //implement this method
	  if(e.getIndex() == 0 || e.getValue() == 0) {
		  throw new UnsupportedOperationException();
	  }
	  if (getSize() > 0) {
		  SparseNumericNode current = this.head;
		  int count = 0;
		  while (count < getSize()) {
			  if (e.getIndex() == current.getElement().getIndex()) {
				  throw new UnsupportedOperationException();
			  }
			  current = current.getNext();
			  count++;
		  }
	  }
		  
	  SparseNumericNode n = new SparseNumericNode(e, null);
		if (size == 0) {
			this.head = n;
			this.tail = n;
		} else {
			tail.setNext(n);
			this.tail = n;
		}
		this.size++;
    }

    /**
     * If an element with the specified index exists, it is removed and the
     * method returns true.  If not, it returns false.
     *
     * @param index of element to remove
     * @return true if removed, false if does not exist
     */
    public boolean remove(Long index) {
        //implement this method
        //this return statement is here to satisfy the compiler - replace it with your code.
    	
    	if (getSize() == 0) {
			throw new NoSuchElementException();
    	}
    	
    	if (getSize() == 1) {
    		if (head.getElement().getIndex() == index) {
    			head = null;
    			tail = null;
    			size--;
    			return true;
    		} else {
    			return false;
    		}
    	}
    	
    	SparseNumericNode current = head;
    	SparseNumericNode prev = null;
    	while (current.getElement().getIndex() != index) {
    		prev = current;
    		current = current.getNext();
    		if(current.getNext() == null) {
    			break;
    		}
    	}
    	if (current.getElement().getIndex() == index) {
    		SparseNumericNode next = current.getNext();
    		current.setNext(null);
    		prev.setNext(next);
    		size--;
    		return true;
    	} else {
    		return false;
    	}
    	
    }

    /**
     * Returns the inner product of the vector with a second vector passed as a
     * parameter.  The vectors are assumed to reside in the same space.
     * Runs in O(m+n) time, where m and n are the number of non-zero elements in
     * each vector.
     * @param Y Second vector with which to take inner product
     * @return result of inner product
     */

    public double dot (SparseNumericVector Y) {
        //implement this method
        //this return statement is here to satisfy the compiler - replace it with your code.
    	
    	SparseNumericNode current = head;
    	SparseNumericNode currentY = Y.head;
    	double dotP = 0;
//    	while(!(current == null) && !(currentY == null)) {
//    		if (current.getElement().getIndex() == currentY.getElement().getIndex()) {
//    			dotP += current.getElement().getValue()*currentY.getElement().getValue();
//    			if(current.getNext() != null) {
//    				current = current.getNext();
//    			}
//    			if (currentY.getNext() != null) {
//    				currentY = currentY.getNext();	
//    			}
//    		} 
//    		if (current.getElement().getIndex() > currentY.getElement().getIndex()) {
//    			currentY = currentY.getNext();
//    		} else if (current.getElement().getIndex() > currentY.getElement().getIndex()) {
//    			
//    		}
//    		if (current.getElement().getIndex() < currentY.getElement().getIndex()) {
//    			current = current.getNext();    			
//    		}
//    	}
    	
        return dotP;
   }

       /**
     * returns string representation of sparse vector
     */

    @Override
    public String toString() {
        String sparseVectorString = "";
        Iterator<SparseNumericElement> it = iterator();
        SparseNumericElement x;
        while (it.hasNext()) {
            x = it.next();
            sparseVectorString += "(index " + x.getIndex() + ", value " + x.getValue() + ")\n";
        }
        return sparseVectorString;
    }
}
