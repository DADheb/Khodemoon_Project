package SQL;

public class SQL {

    private static final DatabaseInitializer  databaseInitializer = new DatabaseInitializer();

    private static final DataInitializer dataInitializer = new DataInitializer();

    private static final UserRepository userRepository = new UserRepository();

    public static DatabaseInitializer getDatabaseInitializer() { return databaseInitializer; }

    public static DataInitializer getDataInitializer() { return dataInitializer; }

    public static UserRepository getUserRepository() { return userRepository; }

}
