// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

import java.util.NoSuchElementException;

class PeekingIterator implements Iterator<Integer> {
    
    private Iterator<Integer> iterator;
    private Integer peekedValue;
    
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    this.iterator = iterator;
        this.peekedValue = null;
	}
	
    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        if (peekedValue == null) {
            if (!iterator.hasNext()) {
                throw new NoSuchElementException();
            }
            peekedValue = iterator.next();
        }
        return peekedValue;
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    Integer result;
        if (peekedValue != null) {
            result = peekedValue;
            peekedValue = null;
            return result;
        }
        
        if (!iterator.hasNext()) {
            throw new NoSuchElementException();
        }
        
        return iterator.next();
	}
	
	@Override
	public boolean hasNext() {
	    return peekedValue != null || iterator.hasNext();
	}
}