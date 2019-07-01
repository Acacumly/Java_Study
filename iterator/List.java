/**
 * 定义一个线性表的接口
 */
public interface List {
    /**
     * 头部插入
     * @param val 要插入的数据
     */
    void pushFront(int val);

    /**
     * 尾部插入
     * @param val 要插入的数据
     */
    void pushBack(int val);

    /**
     * 根据下标 index 进行插入
     * 如果下标错误，给出打印提示
     * @param index 取值范围从 [0, size]
     * @param val 要插入的数据
     */
    void insert(int index, int val);

    /**
     * 返回当前线性表中的数据个数
     * @return 数据个数
     */
    int size();

    /**
     * 返回当前线性表的迭代器
     * @return 迭代器，从线性表最开始进行
     */
    Iterator iterator();
}