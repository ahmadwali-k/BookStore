import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        BooksDao dao = BooksDaoFactory.getBookDao();
        Book book = new Book();
        dao.createBooks(book);
        User user = new User();
        UsersDao dao1 = UsersDaoFactory.getUserDao();
        dao1.createUsers(user);

        boolean flag = true;
        while (flag) {
            System.out.println("*******************************");
            System.out.println("Welcome To Book Store");
            System.out.println("*******************************");
            System.out.println("PRESS 1: To Login ");
            System.out.println("PRESS 2: To Register ");
            System.out.println("PRESS 3: To Exit");

            int num = scanner.nextInt();
            switch (num) {
                case 1:
                    dao1.loginUser(); //loggingIn();
                    //Options.userLogin();
                    break;
                case 2:
                    Options.registration(); //register();
                    break;
                case 3:
                    flag = false;
                    //return;
            }
        }

    }
}
