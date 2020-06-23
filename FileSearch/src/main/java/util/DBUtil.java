package util;

import org.sqlite.SQLiteConfig;
import org.sqlite.SQLiteDataSource;
import task.DBinit;

import javax.sql.DataSource;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.sql.Connection;
import java.sql.SQLException;

public class DBUtil {

    private static volatile DataSource DATA_SOURCE;
//多线程操纵:原子性 可见性(主内存拷贝到工作内存),有序性
    //synchronized保证三个特性，volatile保证可见性，有序性
    private static DataSource getDataSource(){
        if(DATA_SOURCE==null){//目的是提高效率
            //也可能是第一个线程之后的线程进入并执行
            synchronized (DBUtil.class){//刚开始所以进入这行代码的进程，DATA_SOURCE对象都是空的
                if(DATA_SOURCE==null){
                    //初始化操作 使用volatile关键字禁止指令重排序 建立内存屏障
                    SQLiteConfig config=new SQLiteConfig();
                    config.setDateStringFormat(Util.DATA_PATTERN);
                    DATA_SOURCE= new SQLiteDataSource();
                    ((SQLiteDataSource)DATA_SOURCE).setUrl(getUrl());
                }
            }
        }
        return DATA_SOURCE;
    }
    private  static  String getUrl(){        //获取target编译文件夹的路径
        try {
            //通过classLoader.getResource()/classLoader.getResourceAsStream()方法
            //默认的根路径为编译文件夹路径(target/classes)
            URL classesURL= DBinit.class.getClassLoader().getResource("./");
            String dir=new File(classesURL.getPath()).getParent();
            String url="jdbc:sqlite://" + dir + File.separator + "Mavenproject.db";
            //new SqliteDateSource() 把这个对象的url设置进去 才会创建这个文件，如果
            //文件已经存在，就会读取这个文件
            url= URLDecoder.decode(url,"UTF-8");
            System.out.println(url);
            return url;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            throw new RuntimeException("获取数据库文件路径失败",e);
        }
    }
    /*
    提供数据库连接的方法
    从数据库链接DataSource.getConnection()来获取数据库链接
     */
    public static Connection getConnection() throws SQLException {
        return  getDataSource().getConnection();
    }

    public static void main(String[] args) throws SQLException {
        System.out.println(getConnection());
    }
}
