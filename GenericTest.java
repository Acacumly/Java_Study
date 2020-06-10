import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class GenericTest {
    /**
     * @param args
     */

    public static void main(String[] args) {

        //创建一个唯一性元素的集合要求排序, set -- treeset
        //按照长度排序,需要匿名内部类实现
        Set<String> set = new TreeSet<String>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
             //   String  s1 = (String)o1;
             //   String  s2 = (String)o2;

                int temp = o1.length() -o2.length();
                return temp == 0?o1.compareTo(o2):temp;
            }
        });

        //添加元素
        set.add("abcd");
        set.add("java");
        set.add("hello");

        for (Iterator<String> it = set.iterator(); it.hasNext(); ) {
            String string = (String) it.next();
            System.out.println(string);
        }
    }
}
