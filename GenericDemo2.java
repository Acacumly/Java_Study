public class GenericDemo2 {
    public static void main(String[] args) {

//        Tool t = new Tool();
//        t.setObject(6);
//        String s = (String)t.getObject();
//        System.out.println(s);

    }
}

//jdk1.5以后有了新技术, 泛型,改成如下这样
//类中操作的对象确定不?不确定,用Object需要转型,运行容易出现异常,不爽
//在定义时,就将不确定的对象的类型,定义成参数, 由使用该类的
//调用者来传递对象类型

class Tool<Q> { //将泛型定义在类上,泛型类
    private Q object;

    public Q getObject() {
        return object;
    }

    public void setObject(Q object) {
        this.object = object;
    }
}

/**
//定义一个工具对对象进行操作,比如设置和获取
//可以对任意对象进行操作,对共性类型Object操作
//定义Object就哦了,但用的时候因为提升为了Object,想要使用特有内容,需要向下转型.容易引发ClassCastException

class Tool {
   /**
    private String str;

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    class Tool2 {
        private Integer str;

        public Integer getStr() {
            return str;
        }

        public void setStr(Integer str) {
            this.str = str;
        }
    }

    private Object object;

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
    */
}
