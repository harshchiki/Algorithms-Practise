package sorting;

public class InsertionSort {
	boolean isLoggingEnabled = false;
	public static void main(String[] args) {
		new InsertionSort().insertionSort(new int[] {9,8,7,6});
	}
	public void insertionSort(int[] a) {
		for(int i = 1;i<a.length;++i) {
			int key = a[i];
			int j = i-1;
			while(j>=0 
					&& a[j] > key) {
				a[j+1] = a[j];
				j--;
				log(i,j,a);
			}
			a[j+1] = key;
			log(i,j,a);
		}
		log(0,0,a);
		StringBuilder b = new StringBuilder();
		for(int k = 0;k<a.length;k++) {
			if(b.length() == 0) {
				b.append(String.valueOf(a[k]));
			}else {
				b.append(", "+String.valueOf(a[k]));
			}
		}
		System.out.println("Sorted array: "+b.toString());
	}

	public void log(int i, int j, int[] a) {
		if(isLoggingEnabled) {
			StringBuilder b = new StringBuilder();
			for(int k = 0;k<a.length;k++) {
				if(b.length() == 0) {
					b.append(String.valueOf(a[k]));
				}else {
					b.append(", "+String.valueOf(a[k]));
				}
			}
			System.out.println("i: "+i+" j: "+j+" "+b.toString());
		}
	}
}
