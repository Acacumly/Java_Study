public class Dui {
    public static void creatHeap(int ){
          /*

         */
        //parent =( size - 1 - 1) / 2
        for(int i = (size - 2) / 2; i >= 0; i--){
            heapify(array, size, i);
        }
    }

    public static void adjustUp(int[] array, int index) {
        int min = array[0];
        if(array[index] <= array[min]) {

        }
    }

    public static void main(String[] args) {
        int[] array = {3, 5, 2, 4, 9, 0, 1, 9, 8, 4, 7, 2, 3, 8, 6, 3};
    }
}






