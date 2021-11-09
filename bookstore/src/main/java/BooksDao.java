import java.sql.Array;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface BooksDao {


    void createBooks(Book book) throws SQLException;
    void updateBooks(Book book) throws SQLException;
    List<Book> getBooks() throws SQLException;
    Book getBookByName(int isbn) throws SQLException;
    void deleteBook(int isbn) throws SQLException;
    void buy() throws SQLException;
    List<Book> addBookToCart() throws SQLException;
    //ArrayList<Book> sql2ArrayList()

    /*void deleteEmployee(int id) throws SQLException;
    List<Employee> getEmployees() throws SQLException;
    Employee getEmployeeById(int id) throws SQLException;*/
}
