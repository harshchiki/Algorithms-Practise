package arrays;

import java.util.Iterator;

/*
 * Implement a CircularArray class, 
 * that supports an array-like data structure, 
 * which can be efficiently rotated.
 * 
 * The class should be a generic type (may work as a template)
 * and should support iteration via the standard way:
 * for( Obj o : circularArray)
 * 
 */

public class CircularArray<T> implements Iterable<T> {
	private T[] a;
	private final int len;
	
	public CircularArray(final T[] array){
		this.len = array.length;
		
		this.a = (T[]) new Object[len];
		
		for(int i = 0;i<len;i++){
			this.a[i] = array[i];
		}
		
		
		System.arraycopy(array, 0, this.a, 0, len);
		
	}
	
	public void rotate(final int steps){
		T[] remove = (T[]) new Object[steps];
		
		for(int i = 0;i<steps;i++){
			remove[i] = a[len-steps+i];
		}
		
		/*
		 * go backwards, to swap this with previous.
		 * going foward, we'll lose trace
		 */
		for(int i = len-1; i >= len-steps;i--){
			a[i] = a[i-steps];
		}
		
		
		for(int i =0;i< steps;i++ ){
			a[i] = (T) remove[i];
		}
	}
	

	@Override
	public Iterator<T> iterator() {
		return new CircularArrayIterator<T>(this.a);
	}
	
	class CircularArrayIterator<T> implements Iterator<T>{
		private T[] a;
		private int currentPointer = -1;
		private final int len;
		
		@SuppressWarnings("unchecked")
		CircularArrayIterator(T[] a){
			this.a = (T[]) new Object[a.length];
			this.len = a.length;
			for(int i = 0;i<len;i++){
				this.a[i] = a[i];
			}
		}
		
		
		@Override
		public boolean hasNext() {
			return currentPointer < len-1;
		}
		
		@Override
		public T next() {
			currentPointer++;
			System.out.print(currentPointer +" ");
			return this.a[currentPointer];
		}	
	}
	
	public static void main(String[] args) {
		Integer[] array = new Integer[]{1,2,3,4};
		
		CircularArray<Integer> ca = new CircularArray<Integer>(array);
		
		for(Integer i : ca){
			System.out.println(i.intValue());
		}
		
		ca.rotate(2);
		System.out.println("Rotated");
		for(Integer i : ca){
			System.out.println(i.intValue());
		}
	}
	
}
