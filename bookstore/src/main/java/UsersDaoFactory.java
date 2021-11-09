public class UsersDaoFactory {
    private static UsersDao dao1;

    private UsersDaoFactory() {

    }
    public static UsersDao getUserDao() {
        if (dao1 == null) {
            dao1 = new UserDaoImpl();
        }
        return dao1;
    }
}
