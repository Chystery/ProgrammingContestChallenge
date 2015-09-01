package Subsequence;

import java.lang.reflect.Method;

public class BinarySearchMethod {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 10;
		int S = 15;
		int[] a = {5,1,3,5,10,7,4,9,2,8};
		
		System.out.println("the result is: " + binarySearch(n,S,a));
	}

	private static int binarySearch(int n, int s, int[] a) {
		// TODO Auto-generated method stub
		// 计算a0 + a1 + ... + ai的值
		int[] sum = new int[n + 1];
		sum[0] = 0;
		for (int i = 0; i < n; i++){
			sum[i + 1] = sum[i] + a[i];
		}
		
		int rslt = n;
		for (int i = 0; sum[i] + s <= sum[n]; i++){
			// 利用二分搜索找到符合条件的数组尾坐标
			int target = sum[i] + s;
			int t = search(i, n, sum, target);
			rslt = min(t - i, rslt);
		}
		return rslt;
	}

	private static int min(int i, int j) {
		if (j < i)
			return j;
		else
			return i;
	}

	private static int search(int i, int n, int[] sum, int s) {
		if (n - i <= 1)
			return n;
		else{
			int mid = (i + n)/2;
			if (sum[mid] > s){
				return search(i, mid, sum, s);
			}else{
				return search(mid, n, sum, s);
			}
		}
		
				
	}
	
	

}
