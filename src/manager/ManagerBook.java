package manager;

import io.AccountIO;
import io.BookIO;
import model.Book;
import validate.ValidateBook;

import java.util.ArrayList;
import java.util.Scanner;

public class ManagerBook {
    ArrayList<Book> books = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    public ManagerBook() {
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void displayBook() {
        for (Book b : books)  {
            System.out.println(b);
        }
    }

    public void editBook(int index, Book book) {
        book.setId(books.get(index).getId());
        books.set(index, book);
    }

    public void deleteBook(int index) {
        books.remove(index);
    }

    public Book create() {
        String name = ValidateBook.name(books);
        System.out.println("Nhập thể loại sách");
        String category = scanner.nextLine();
        System.out.println("Nhập tên tác ");
        String author = scanner.nextLine();
        return new Book(name, category, author);
    }

    public ArrayList<Book> findAllByName(String name) {
        ArrayList<Book> findBook = new ArrayList<>();
        for (Book b : books) {
            if (b.getName().contains(name)) {
                findBook.add(b);
            }
        }
        return findBook;
    }

    public int findIndexByName(String name) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    public void writeBook() {
        BookIO.writerBook(books);
    }

    public void readBook(){
        BookIO.readBook();
    }
}
