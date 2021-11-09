public class Book {
    private int isbn;
    private String title;
    private String author;
    private double price;
    public String category;
    public String description;
    /*public String name;
    private int id;
    private String password;*/

    public Book() {

    }

    public Book(String title, int bookId, String author, double price,
                String category, String description)
    {
        this.title = title;
        this.isbn = bookId;
        this.author = author;
        this.price = price;
        this.category = category;
        this.description = description;
    }

    /*public int getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public void setId(int id) {
        this.id = id;
    }

    //public void setPassword(String password) {
        this.password = password;
    }*/

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

    public int getIsbn() {
        return isbn;
    }



    public void setIsbn(int bookId) {
        this.isbn = bookId;
    }


    @Override
    public String toString() {


        return "Book ==> |" +
                "Title = " + title + '\'' +
                "| |ISBN = '" + isbn + '\'' +
                "| |Author = '" + author + '\'' +
                "| |Price = '" + price + '\'' +
                "| |Category = '" + category + '\'' +
                "| |Description = '" + description + '\'' +
                '|' + "\n";

    }
}
