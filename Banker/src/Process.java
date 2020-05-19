//进程链表
class Process {
    String name;
    Resource maxNeed;//最大所需资源链表头结点
    Resource already;//当前占有资源的链表头结点
    Process pNext;//next
    public Process(String name){
        this.name = name;
    }
}
