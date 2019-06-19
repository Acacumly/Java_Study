public class QuickSort {
	/*public static void sort(int[] a, int first, int last) {
		if(first >= last) {
			return;
		}
		int i = first;
		int j = last;
		int base  = a[first];
		while(i < j) {
			while (a[j] >= base && i < j ) {
				j--;
				//a[i++] = a[j];
			}
			while(a[j] <= base && i < j) {
				i++;
				//a[j--] = a[i];
			}
			if(i < j) {
				int t = a[j];
				a[j] = a[i];
				a[i] = t;
			}
				
		}
			a[first] = a[i];
			a[i] = base;
			sort(a, first, j-1);
			sort(a, j+1, last);
	}
		
	/*public static void quickSort(int[] a) {
		sort(a, 0, a.length-1);
		for(int i:a) {
			System.out.print(i+" ");
		}
	}
	
	public static void main(String[] args) {
		int[] a = { 6, 3, 9, 1, 5, 7, 8, 2, 4 };
		//quickSort(a);
		sort(a, 0, a.length - 1);
		for(int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}*/
	
	
	public static void quickSort(int[] arr,int low,int high){
        int i,j,temp,t;
        if(low>high){
            return;
        }
        i=low;
        j=high;
        //temp就是基准位
        temp = arr[low];
        while (i<j) {
            //先看右边，依次往左递减
            while (temp<=arr[j]&&i<j) {
                j--;
            }
            //再看左边，依次往右递增
            while (temp>=arr[i]&&i<j) {
               i++;
            }
            //如果满足条件则交换
            if (i<j) {
                t = arr[j];
                arr[j] = arr[i];
                arr[i] = t;
            }
        }		
        //最后将基准为与i和j相等位置的数字交换
         arr[low] = arr[i];
         arr[i] = temp;
        //递归调用左半数组
        quickSort(arr, low, j-1);
        //递归调用右半数组
        quickSort(arr, j+1, high);
    }
	
    public static void main(String[] args){
        int[] arr = {10,7,2,4,7,62,3,4,2,1,8,9,19};
        quickSort(arr, 0, arr.length-1);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}