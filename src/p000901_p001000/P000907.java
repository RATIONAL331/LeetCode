package p000901_p001000;

public class P000907 {
//	private static class IntegerWrapper {
//		private int result = 0;
//
//		public void addResult(int add) {
//			this.result = (this.result + add) % MODULO;
//		}
//
//		public int getResult() {
//			return result;
//		}
//	}
	private static final int MODULO = 1_000_000_007;

	public static void main(String[] args) {
		System.out.println(sumSubarrayMins(new int[]{3, 1, 2, 4})); // 3(x), 1, 2, 4, 31(x), 12, 24, 312(x), 124, 3124(x)
//		System.out.println(sumSubarrayMins(new int[]{11,81,94,43,3})); // 11, 81, 94, 43, 3, 1181, 8194, 9443, 433, 118194, 819443, 94433, 11819443, 8194433, 118194433
	}

//	public int sumSubarrayMins(int[] arr) {
//		IntegerWrapper result = new IntegerWrapper();
//		sumSubarrayMins(arr, 0, arr.length - 1, result, new boolean[arr.length][arr.length]);
//		return result.getResult();
//	}

	public static int sumSubarrayMins(int[] arr) {
		long sumOfMin = 0;

		for(int i = 0; i < arr.length; i++){
			sumOfMin = (sumOfMin + findSubArrayMin(arr, i)) % MODULO;
		}
		return (int)sumOfMin;
	}

	private static int findSubArrayMin(int[] arr, int start){
		int minVal = arr[start];
		int result = 0;

		for(int i = start; i < arr.length; i++){
			minVal = Math.min(minVal, arr[i]);
			result += minVal;
		}
		return result;
	}

//	private static void sumSubarrayMins(int[] arr, int begin, int end, IntegerWrapper total, boolean[][] exist) {
//		if (exist[begin][end]) {
//			return;
//		}
//
//		if (begin >= end) {
//			exist[begin][end] = true;
//			total.addResult(arr[begin]);
//			return;
//		}
//
//		int minValue = getMinArray(arr, begin, end);
//		total.addResult(minValue);
//		exist[begin][end] = true;
//
//		sumSubarrayMins(arr, begin, end - 1, total, exist);
//		sumSubarrayMins(arr, begin + 1, end, total, exist);
//	}
//
//	private static int getMinArray(int[] arr, int begin, int end) {
//		int minValue = MODULO;
//		for (int i = begin; i <= end; i++) {
//			minValue = Math.min(minValue, arr[i]);
//		}
//		return minValue;
//	}
}
