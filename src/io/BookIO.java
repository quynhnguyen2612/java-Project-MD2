package io;

import model.Book;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BookIO {
    static File file = new File("book.txt");
    public static void writerBook(List<Book> books){
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            for (Book b : books) {
                bufferedWriter.write(b.toString());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Book> readBook() {
        ArrayList<Book> books = new ArrayList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader( new FileReader(file));
            String str = "";
            while ((str = bufferedReader.readLine()) !=null) {
                String[] arr = str.split("-");
               Book book = new Book(
                        Integer.parseInt(arr[0]),
                        arr[1], arr[2], arr[3]);
                books.add(book);
            }
            bufferedReader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return books;
    }
}
