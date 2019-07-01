/**
 * 抽象线性表类，把公共方法实现在这里
 */
public abstract class AbstractList implements List {
    /**
     * 线性表中当前数据的个数
     */
    private int size = 0;

    /**
     * 内部使用的根据下标插入指定数据
     * 一定保证 index 是不会出错的
     * @param index 要插入位置的 index
     * @param val 要插入的数据
     */
    protected abstract void insertInternal(int index, int val);

    @Override
    public void pushFront(int val) {
        insertInternal(0, val);
        size++;
    }

    @Override
    public void pushBack(int val) {
        insertInternal(size, val);
        size++;
    }

    @Override
    public void insert(int index, int val) {
        if (index < 0 || index > size) {
            System.out.println("下标错误");
            return;
        }

        insertInternal(index, val);

        size++;
    }

    @Override
    public int size() {
        return size;
    }
}
