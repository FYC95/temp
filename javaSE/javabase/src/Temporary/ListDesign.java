package Temporary;

import java.util.LinkedList;
import java.util.List;

//整理书架
public class ListDesign {
    public static void main(String[] args) {
        List<Book> books = new LinkedList();
        books.add(new Book("CSS基础",100,55));
        books.add(new Book("javaScript",100,55));
        books.add(0,new Book("HTML",100,55));
        System.out.println(books.get(1));
        for (int i = 0; i < books.size(); i++) {
            System.out.println(books.get(i));
        }
    }
}
class Book{
    private String name;
    private int page;
    private double price;

    public Book(String name, int page, double price) {
        this.name = name;
        this.page = page;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", page=" + page +
                ", price=" + price +
                '}';
    }
}