//资源链表
public class Resource {
    String name;//名称
    int num;//数目
    int Available;//可利用资源
    Resource rNext;//next
    public Resource(String name,int num){
        this.name = name;
        this.num = num;
    }
}
