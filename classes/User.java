package classes;

import java.util.Scanner;

public abstract class User {
    private String id;
    private String name;

    public User(String id, String name){
        super();
    }
    public static void login(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入用户ID: ");
        String id = scanner.nextLine();
        System.out.println("请输入用户姓名: ");
        String name = scanner.nextLine();
        System.out.println("请输入角色: ");

    }
    public abstract void menu();
    public abstract boolean input();

    public static Book putBook(String ISBN, String title, String author) {
        //系统内部只能有一个书架对象
        //单例模式
        BookShelf bookShelf = BookShelf.getInstance();
        try {
            Book book = bookShelf.search(ISBN);
            book.increaseCount(count);
            return book;
        }catch (NoSuchBookException exc) {
            Book book = new Book(ISBN, title, author, price, count);
            bookShelf.putBook(book);
            return book;
        }
    }


}
