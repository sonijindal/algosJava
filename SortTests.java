package practice;

public class SortTests {
	public static void HeapSort(int arr[]) {
		int n = arr.length;

		//Build Heap
//		for (int i = n/2 - 1; i >=0; --i) {
//			MinHeapify(arr, i, n);
//		}
		for (int i = n/2 - 1; i >=0; --i) {
			MaxHeapify(arr, i, n);
		}
		for (int e: arr)
			System.out.println(e);
		System.out.println("Now the sorted:");
		for (int i = n; i > 0; --i) {
			int last = arr[i - 1];
			arr[i-1] = arr[0];
			arr[0] = last;
			//n = n -1;
			
			MaxHeapify(arr, 0, i-1);
		}
	}
	
	public static void MinHeapify(int arr[], int index, int n) {
		int left = 2 * index + 1;
		int right = 2 * index + 2;
		int small = index;
		if (left < n && arr[small] > arr[left])
			small = left;
		if (right < n && arr[small] > arr[right])
			small = right;
		
		if (small != index) {
			int temp = arr[small];
			arr[small] = arr[index];
			arr[index] = temp;
			
			MinHeapify(arr, small, n);
			
		}
	}
	
	public static void MaxHeapify(int arr[], int index, int n) {
		int left = 2 * index + 1;
		int right = 2 * index + 2;
		int large = index;
		if (left < n && arr[large] < arr[left])
			large = left;
		if (right < n && arr[large] < arr[right])
			large = right;
		
		if (large != index) {
			int temp = arr[large];
			arr[large] = arr[index];
			arr[index] = temp;
			
			MaxHeapify(arr, large, n);
			
		}
	}
	
}
