package A1Q3;
import java.util.*;

/**
 * Specializes the stack data structure for comparable elements, and provides
 * a method for determining the maximum element on the stack in O(1) time.
 * @author jameselder
 */
public class MaxStack<E extends Comparable<E>> extends Stack<E> {

    private Stack<E> maxStack;

    public MaxStack() {
        maxStack = new Stack<>();
    }

    /* must run in O(1) time */
    public E push(E element) {
        return null; //Dummy return to satisfy compiler.  Remove once coded.
    }

    /* @exception  EmptyStackException  if this stack is empty. */
    /* must run in O(1) time */
   public synchronized E pop() {
        return null; //Dummy return to satisfy compiler.  Remove once coded.
    }

    /* Returns the maximum value currenctly on the stack. */
    /* @exception  EmptyStackException  if this stack is empty. */
    /* must run in O(1) time */
    public synchronized E max() {
        return null; //Dummy return to satisfy compiler.  Remove once coded.
    }
}