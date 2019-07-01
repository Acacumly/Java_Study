/**
 * 迭代器接口，用于用通用的方式进行
 * 线性表的迭代
 */
public interface Iterator {
    /**
     * 判断迭代器是否走到了最后
     * @return true 表示没到最后，false 表示到最后了
     */
    boolean hasNext();

    /**
     * 返回下一个迭代到的数据，
     * 同时让迭代器向后走一步
     * @return 当前迭代到的数据
     */
    int next();
}