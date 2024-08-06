import util.ApplicationContext;

import java.sql.SQLException;

public class JpaApplication {
    public static void main(String[] args) throws SQLException {
        ApplicationContext context = ApplicationContext.getInstance();
       context.getMainMenu().showMenu();
    }

}
