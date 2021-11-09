import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class Options {
    static void welcome() throws SQLException {
        BooksDao dao = BooksDaoFactory.getBookDao();
        UsersDao dao1 = UsersDaoFactory.getUserDao();
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            System.out.println("***************************");
            System.out.println("Select from the options below");
            System.out.println("***************************");
            System.out.println("PRESS 1: TO SHOW ALL USERS");
            System.out.println("PRESS 2: TO ADD A NEW BOOK");
            System.out.println("PRESS 3: TO DISPLAY BOOKS");
            // show tables only by category.
            //System.out.println("PRESS 4: TO FIND BOOK BY CATEGORY");
            System.out.println("PRESS 4: TO SEARCH BOOK BY ISBN NUM");
            System.out.println("PRESS 5: TO REMOVE A BOOK");
            System.out.println("PRESS 6: TO REMOVE A USER");
            System.out.println("PREES 7: TO BUY A BOOK");
            //SUB CATEGORY (BUY/CANCEL)
            System.out.println("PRESS 8: TO VIEW CART");
            System.out.println("PRESS 9: TO EXIT");

            Scanner scanner1 = new Scanner(System.in);
            int num = scanner1.nextInt();
            switch (num) {
                case 1:
                    List<User> users = dao1.getUsers();
                    for (User user : users) {
                        System.out.print(user);
                    }
                    break;
                case 2: addbook();
                    break;
                case 3:
                    List<Book> books = dao.getBooks();
                    for (Book book : books) {
                        System.out.print(book);
                    }
                    break;
                case 4:
                    //Book book = new Book();
                    System.out.println("Enter table by ISBN number:");
                    int isbn = scanner.nextInt();
                    Book book = dao.getBookByName(isbn);
                    System.out.println(book);
                    break;
                case 5:
                    // to remove a book
                    System.out.println("Enter table by ISBN number to Delete:");
                    int isbn1 = scanner.nextInt();
                    dao.deleteBook(isbn1);
                    break;
                case 6:
                    // to remove a user
                    System.out.println("Enter User ID to Delete");
                    int id = scanner.nextInt();
                    dao1.deleteUser(id);
                    break;
                case 7: dao.buy();
                    // buy or cancel
                    break;
                case 8:

                    // view cart
                    break;
                case 9: loop = false; // TODO: change if needed
                    // break;
                default:
                    System.out.println("");
                    break;
            }

        }

    }
    static void registration() throws SQLException {
        // To register a new User
        UsersDao dao1 = UsersDaoFactory.getUserDao();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter User Name:");
        String name = scanner.next();
        System.out.println("Enter User ID");
        int id = scanner.nextInt();
        System.out.println("Create a password. (no spaces)");
        int password = scanner.nextInt();
        User user = new User();
        user = new User(name, id, password);
        dao1.updateUsers(user);
    }
    static void addbook() throws SQLException {
        BooksDao dao = BooksDaoFactory.getBookDao();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Title");
        String title = scanner.next();
        System.out.println("Enter ISBN number");
        int isbn = scanner.nextInt();
        System.out.println("Who is the Author.");
        String author = scanner.next();
        System.out.println("Price");
        double price = scanner.nextDouble();
        System.out.println("Chose category");
        String category = scanner.next();
        System.out.println("Book Description");
        String descrp = scanner.nextLine();
        descrp = "";
        descrp+=scanner.nextLine();
        //scanner.close();
        Book book = new Book();
        book = new Book(title, isbn, author, price, category, descrp);
        dao.updateBooks(book);
    }

    void printReceipt(ArrayList<Book> cart) {
        for(Book book : cart) {
            System.out.println("Receipt:");;
            System.out.print(book.getIsbn()+"\t"+book.getTitle());
        }
    }
}
