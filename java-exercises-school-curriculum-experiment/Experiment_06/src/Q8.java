
/**
 * @Project_Name: Java programming course in school
 * @Package_Name: PACKAGE_NAME
 * @File:
 * @Version: 1.0.0
 * @Author: zhangjiangh03
 * @Created: 2023-10-28 13:22
 * @Last_Modified: 2023-10-28 13:22
 * @Description: No Description.
 */

import java.util.*;

class Book implements Comparable<Book> {
    private final String name;
    private final double price;

    public Book(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public int compareTo(Book book) {
        return Double.compare(this.price, book.price);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Book other)) {
            return false;
        }
        return this.name.equals(other.name) && Double.compare(this.price, other.price) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }
}

class SortSearchClass {
    public static void main(String[] args) {
        List<Book> bookList = new ArrayList<>();

        bookList.add(new Book("Book_1", 29.80));
        bookList.add(new Book("Book_2", 12.50));
        bookList.add(new Book("Book_3", 50.00));
        bookList.add(new Book("Book_4", 98.90));

        Book newBook = new Book("Book_4", 98.90);

        boolean flag = true;
        for (Book book : bookList) {
            if (book.equals(newBook)) {
                System.out.println("Found: " + book.getName() + " -> " + book.getPrice());

                flag = false;
            }
        }
        if (flag) {
            System.out.println("Not Found!");
        }

        Collections.sort(bookList);
        System.out.println("After sort: ");
        for (Book book : bookList) {
            System.out.println(book.getName() + " -> " + book.getPrice());
        }
    }
}

public class Q8 {
}
