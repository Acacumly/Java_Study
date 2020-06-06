package classes;

public class Book {
    private String ISBN;
    private String name;
    private String author;
    private int price;
    public Book(){
        super();
    }//不带参的构造函数
    public Book(String ISBN, String name, String author){
        super();
        this.name = name;
        this.author = author;
        this.ISBN = ISBN;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


}
