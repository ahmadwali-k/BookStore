import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserDaoImpl implements UsersDao {

    Connection connection;

    public UserDaoImpl() {
        this.connection = ConnectionFactory.getConnection();
    }

    @Override
    public void createUsers(User user) throws SQLException {
        String sql = "create table if not exists User (Name varchar(30), ID integer, password varchar(50));";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.addBatch();
        preparedStatement.executeBatch();
    }
    @Override
    public void updateUsers(User user) throws SQLException {
        String sql = "insert into User (Name, ID, password) values (?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, user.getName());
        preparedStatement.setInt(2, user.getId());
        preparedStatement.setInt(3, user.getPassword());
        int count = preparedStatement.executeUpdate();
        if (count > 0) {
            System.out.println("User Updated");
        }
        else {
            System.out.println("Update Failed");
        }
    }
    @Override
    public List<User> getUsers() throws SQLException {
        List<User> users = new ArrayList<>();
        String sql = "select * from User";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            String name = resultSet.getString(1);
            int id = resultSet.getInt(2);
            int password = resultSet.getInt(3);
            User user = new User(name, id, password);
            users.add(user);

        }
        return users;
    }
    @Override
    public void deleteUser(int id) throws SQLException {
        String sql = "delete from user where id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        int count = preparedStatement.executeUpdate();
        if (count > 0) {
            System.out.println("User deleted");
        } else {
            System.out.println("could not perform deletion");
        }
    }
    @Override
    public void loginUser() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter User name");
        String chossenname = scanner.next();
        User user = new User();
        user.setName(chossenname);
        System.out.println("Enter Password");
        int chosenPassword = scanner.nextInt();
        user.setPassword(chosenPassword);
        String sql = "select name, password from user where name = ? AND password = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, user.getName());
        preparedStatement.setInt(2, user.getPassword());
        ResultSet resultSet = preparedStatement.executeQuery();
        //System.out.println(name);
        //System.out.println(password);
        while (resultSet.next()) {
            if (user.getName().equals(chossenname) && (user.getPassword() == chosenPassword)) {

                System.out.println("login successful");
                Options.welcome();
            } else
                System.out.println("could not validate user.");
        }
        /*String sql = "select * from user";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            String name = resultSet.getString(1);
            int password = resultSet.getInt(2);

            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter name: ");
            String chosenName = scanner.next();
            System.out.print("Enter password: ");
            int chosenPassword = scanner.nextInt();
            User user = new User(name, password);
            if (user.getName().equals(chosenName) && (password == chosenPassword)) {
                System.out.println(name);
                System.out.println(password);
                System.out.println("login successful");
                Options.welcome();
                } else
                System.out.println("could not validate user.");
        }*/
    }
}
