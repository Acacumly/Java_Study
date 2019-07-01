public class ArrayList extends AbstractList implements List {
    private int[] array;

    public ArrayList() {

        this(16);
    }

    public ArrayList(int capacity) {
        array = new int[capacity];
    }

    @Override
    protected void insertInternal(int index, int val) {
        ensureCapacity();

        for (int i = size(); i > index; i--) {
            array[i] = array[i - 1];
        }

        array[index] = val;
    }

    /**
     * 顺序表的迭代器类
     */
    private class ArrayListIterator implements Iterator {
        /**
         * 当前迭代器所在位置的下标
         */
        private int current;

        private ArrayListIterator(int current) {
            this.current = current;
        }

        @Override
        public boolean hasNext() {

            return current < size();
        }

        @Override
        public int next() {

            return array[current++];
        }
    }

    @Override
    public Iterator iterator() {

        return new ArrayListIterator(0);
    }

    /**
     * 保证顺序的容量是够用的
     * 如果不够用，进行扩容，扩容为当前容量的 2 倍
     */
    private void ensureCapacity() {
        if (size() < array.length) {
            return;
        }

        int[] newArray = new int[size() * 2];
        for (int i = 0; i < size(); i++) {
            newArray[i] = array[i];
        }

        array = newArray;
    }
}
