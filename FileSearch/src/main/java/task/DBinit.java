package task;

import java.io.File;
import java.net.URL;

public class DBinit {
    public static void init(){
        URL classesURL = DBinit.class.getClassLoader().getResource("./");
        String dir = new File(classesURL.getPath()).getParent();
        String url = "jdbc:sqlite://"+dir+File.separator+"everything-like.db";
        System.out.println(url);
    }
    public static void main(String args[]){
            init();
    }
}
