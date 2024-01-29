package model;

public class Book {
    private int id;
    private static int idStatic = 1;
    private String name;
    private String category;
    private String author;

    public Book(int i, String s, String string, String s1) {
        this.id = idStatic++;
    }

    public Book( String name, String category, String author) {
        this.id = idStatic++;
        this.name = name;
        this.category = category;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
