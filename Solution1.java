import java.util.ArrayList;
import java.util.List;

public class Solution1 {
    //泛型方法
    private List<List<Integer>>generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>(numRows);
        //list是一种引用, List类型的接口引用
        //list实际上是一种线性表
        //线性表的元素类型是List<Integer>
        //List类型的接口引用
        //元素类型是Integer类类型的引用
        //Integer是int的包装类

        //for循环实现尾插引用,(每一个线性表中的元素又是一个线性表.形象的理解为一个二维数组
        //通过这种方式实现了对线性表的尾插
        for(int i = 0; i < numRows; i++) {
            list.add(new ArrayList<>( i + 1));
        }

        //相当于初始化杨辉三角的前两行, list.get(0)如:线性表中的第一个元素(即又是一个线性表),有一个值,尾插一个1
        //第一行: 1
        //第二行: 1 1           ---------- 第二行中继续尾插1 1; 尾插两次实现对第二行的初始化
        //用list.get(n)得到下标, 不能直接访问下标, 因为访问的相当于是线性表,
        // 直接访问下标会出现错误,(若是最开始就初始化,即全是1,则可以实现)
        list.get(0).add(1);
        list.get(1).add(1);
        list.get(1).add(1);

        //用for循环,从2开始, 前两行已经被初始化赋值, 从第三行起需要进行计算,

        for(int i = 2; i < numRows; i++) {
            List<Integer> nums = list.get(i);
            nums.add(1);
            for(int j = 1; j < i; j++) {
                int num = list.get(i - 1).get(j - 1) + list.get(i - 1).get(j);
                nums.add(num);
            }
            nums.add(1);
        }
        return list;
    }

    private static void printPascalsTriangle(Solution1 s, int n) {
        System.out.println(s.generate(n));
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        printPascalsTriangle(solution1, 6);
    }
}
