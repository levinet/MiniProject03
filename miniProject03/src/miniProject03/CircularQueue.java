package miniProject03;

// Our names are Megan and Tom.

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author
 * 
 */
public class CircularQueue<E> implements FixedSizeQueueInterface<E> {
	public int capacity;
	public E dataArray[];
	public int head;
	public int tail;
	public int size;
	


	/**
	 * This constructor will instantiate a new circular queue of the size given
	 * as an attribute.
	 * 
	 * @param maxQueueSize This is the capacity of the circular queue.
	 * @throws Exception An exception will be thrown if an invalid capacity is passed into the method.
	 */
	public CircularQueue(int maxQueueSize) throws Exception {
		super();
		if (maxQueueSize<=0) //Went from !=0 to <=0
		{
			throw new Exception("Queue capacity invalid.");
		}
		this.capacity = maxQueueSize+1;
		clear();
	}

	@Override
	public boolean add(E arg0) {
		return offer(arg0);
	}

	@Override
	public E element() {
		if (size == 0) {
			throw new NoSuchElementException("Circular queue is empty.");
		} else {
			return dataArray[tail]; //no need for minus one
		}
	}

	@Override
	public boolean offer(E arg0) {
		if (size==capacity){        		//if the capacity is full exception
			try {
				throw new Exception("Array is full.");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			size++;							//adding arg increases size
			tail=(tail+1) % capacity;		//add to tail
			dataArray[tail]=arg0;
			return true;
			
		}
		return false;
	}

	@Override
	public E peek() {
		if (size == 0) {
			return null;
		} else {
			return dataArray[head]; //not tail-1
		}
	}

	@Override
	public E poll() {
		E retVal = null;
		if (size == 0) {
			return null; //return null if empty
		} else {
			retVal = dataArray[head];
			dataArray[head] = null;		//take the data from head (not tail) and set to null
			head = (head + 1) % capacity;
			size--;						//decrease size
		}
		return retVal;

	}

	@Override
	public E remove() {
		if (size == 0) {
			throw new NoSuchElementException("Circular queue is empty.");
		} else {
			E retVal = dataArray[tail]; 
			dataArray[tail] = null;
			tail = (tail+1) % capacity; 
			size--;
			
			return retVal;
		}
	}

	@Override
	public boolean addAll(Collection<? extends E> arg0) {
		throw new UnsupportedOperationException("Method not yet supported.");
	}

	@SuppressWarnings("unchecked")
	@Override
	public void clear() {
		dataArray = ((E[]) new Object[capacity]);
		head = 0;
		tail = 0;
		size = 0;
	}

	@Override
	public boolean contains(Object arg0) {
		throw new UnsupportedOperationException("Method not yet supported.");
	}

	@Override
	public boolean containsAll(Collection<?> arg0) {
		throw new UnsupportedOperationException("Method not yet supported.");
	}

	@Override
	public boolean isEmpty() {
		if (this.size == 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Iterator<E> iterator() {
		throw new UnsupportedOperationException("Method not yet supported.");
	}

	@Override
	public boolean remove(Object arg0) {
		throw new UnsupportedOperationException("Method not yet supported.");
	}

	@Override
	public boolean removeAll(Collection<?> arg0) {
		throw new UnsupportedOperationException("Method not yet supported.");
	}

	@Override
	public boolean retainAll(Collection<?> arg0) {
		throw new UnsupportedOperationException("Method not yet supported.");
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public Object[] toArray() {
		Object retVal[] = new Object[size];

		for (int index = 0; index < size; index++) {
			int myOffset = (head + index) % this.capacity;
			retVal[index] = this.dataArray[myOffset];
		}
		return retVal;
	}

	@Override
	public <T> T[] toArray(T[] arg0) {
		throw new UnsupportedOperationException("Method not yet supported.");
	}

	@Override
	public int getQueueCapacity() {
		return this.capacity;
	}

	@Override
	public int getRemainingQueueSpace() {
		return this.capacity - this.size;
	}

	@Override
	public boolean isQueueFull() {
		return (this.size >= this.capacity);
	}

}