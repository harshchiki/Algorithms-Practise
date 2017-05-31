package arrays;

public class SumOFAllSubArrays {
	public static void main(String[] args) {
		int[] a = new int[]{1,2,3};
		int l = a.length;
		int sum = 0;
		
		for(int i = 0; i<a.length; i++){
			sum += a[i] * (l-i) * (i+1);
		}
		System.out.println(sum);
	}
}
