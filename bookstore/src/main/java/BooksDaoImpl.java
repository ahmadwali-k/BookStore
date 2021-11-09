import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ArrayList.*;
import java.util.Scanner;

public class BooksDaoImpl implements BooksDao {

    List<Book> carts;
    Connection connection;
    static Statement statement = null;
    static PreparedStatement prep = null;
    static ResultSet rs = null;
    static Scanner scan = null;

    public BooksDaoImpl() {
        this.connection = ConnectionFactory.getConnection();
    }

    @Override
    public void createBooks(Book book) throws SQLException {

        String sql = "create table if not exists Book (Title varchar(30), ISBN integer, Author varchar(30)," +
                " Price double(7,2), Category varchar(50), Description varchar(100));";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.addBatch(sql);
        preparedStatement.executeBatch();

    }
    @Override
    public void updateBooks(Book book) throws SQLException {
        String sql = "insert into Book (Title, ISBN, Author, Price, Category, Description) values (?, ?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, book.getTitle());
        preparedStatement.setInt(2, book.getIsbn());
        preparedStatement.setString(3, book.getAuthor());
        preparedStatement.setDouble(4, book.getPrice());
        preparedStatement.setString(5, book.category);
        preparedStatement.setString(6, book.description);
        int count = preparedStatement.executeUpdate();
        if (count > 0) {
            System.out.println("Updated Successfully");
        }
        else
            System.out.println("Update failed");
    }

    @Override
    public List<Book> getBooks() throws SQLException {
        List<Book> books = new ArrayList<>();
        String sql = "select * from book";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {

            String Title = resultSet.getString(1);
            int ISBN = resultSet.getInt(2);
            String Author = resultSet.getString(3);
            double Price = resultSet.getDouble(4);
            String Category = resultSet.getString(5);
            String Description = resultSet.getString(6);
            Book book = new Book(Title, ISBN, Author, Price, Category, Description);
            books.add(book);
        }
        return books;
    }

    @Override
    public Book getBookByName(int isbn) throws SQLException {
        Book book = new Book();
        String sql = "select * from book where ISBN = " + isbn;
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        resultSet.next();


            if (resultSet != null) {

                String title = resultSet.getString(1);
                isbn = resultSet.getInt(2);
                String author = resultSet.getString(3);
                double price = resultSet.getDouble(4);
                String categ = resultSet.getString(5);
                String descrip = resultSet.getString(6);

                book = new Book(title, isbn, author, price, categ, descrip);
            } else {
                System.out.println("no record found");
            }
        return book;
    }
    @Override
    public void deleteBook(int isbn) throws SQLException {
        String sql = "delete from book where isbn = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, isbn);
        int count = preparedStatement.executeUpdate();
        if(count > 0){
            System.out.println("book deleted");
        }else{
            System.out.println("could not perform deletion");
        }
    }
    @Override
    public void buy() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name of the book");
        String bookname = scanner.next();
        System.out.println("Enter the ISBN NUM: ");
        int bookisbn = scanner.nextInt();
        Book book = new Book();
        book.setTitle(bookname);
        book.setIsbn(bookisbn);
        String sql = "select Title, isbn from book where Title = ? AND isbn = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, book.getTitle());
        preparedStatement.setInt(2, book.getIsbn());
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            if (book.getTitle().equals(bookname) && (book.getIsbn() == bookisbn)) {
                //UserAccount. addToCartNew(bookname);
                //carts.add(book);
                /*for (Book book1 : carts) {
                    if (book1.equals(bookname));
                    carts.add(book);
                    System.out.println(bookname);
                }*/
                //cart
                System.out.println("Book added to cart");
                // add book to cart.
            } else
                System.out.println("could not find the book.");
        }
    }
    @Override
    public List<Book> addBookToCart() throws SQLException {

        carts = new ArrayList<>();
        //Book book = new Book();
        for (Book book : carts) {



        }
        return carts;

    }
}
