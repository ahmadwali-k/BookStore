import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

class UserAccount {
    String username;
    String password;
    ArrayList<Book> cart;
    
    String getUsername() {
        return username;
    }
    String getPassword() {
        return password;
    }
    
    void setUsername(String username) {
        this.username = username;
    }
    void setPassword(String password) {
        this.password = password;
    }
    
    ArrayList<Book> getCart() {
        if(cart==null) {
            cart = new ArrayList<Book>();
        }
        return cart;
    }

    void addToCartNew(Book book) {
        cart.add(book);
    }
    Book getBook(String isbn) {
        for(Book book : cart) {
            if(book.getTitle().equals(isbn)) {
                return book;
            }
        }
        System.err.println("Cannot getBook: Cannot find book with ISBN "+ isbn);
        return new Book();
    }
    
    void removeBook(Book book) {
        if(cart.contains(book)) {
            cart.remove(book);
            System.out.println(
                "\""+ book.getTitle() +"\" (ISBN: "+ book.getIsbn()
                +") is removed from cart"
            );
            return;
        }
        else {
            System.err.println("Cannot removeBook. title: "+book.getTitle());
        }
    }
}

/*public class UserAccountManager {
    protected static UserAccount findAccount(String username) {
        try {
            DaoFactory.getPreparedStatement("select * from ?;").setString(1, Main.bookTableName);
            ResultSet rs = DaoFactory.getPreparedStatement().executeQuery();
            while(rs.next()) {
                // TODO: 
            }
        } catch (SQLException e) {
            System.out.print("SQLException in UserAccountManager.findAccount: ");
            e.printStackTrace();
        }
        
        // TODO: return the UserAccount;
        return new UserAccount();
    }
}*/
