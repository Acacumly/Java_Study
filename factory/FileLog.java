//package factory;
//
//public class FileLog implements Log{
//    public void writeLog() {
//        System.out.println("文件日志记录");
//    }
//    public static class DatabaseLogFactory implements LogFactory{
//        public Log createLog() {
//            System.out.println("数据库日志工厂生产数据库日志。");
//            return new DatabaseFile();
//        }
//    }
//}