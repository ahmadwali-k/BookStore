import java.sql.SQLException;
import java.util.List;

public interface UsersDao {

    void createUsers(User user) throws SQLException;
    void updateUsers(User user) throws SQLException;
    List<User> getUsers() throws SQLException;
    void deleteUser(int id) throws SQLException;
    void loginUser() throws SQLException;
}
