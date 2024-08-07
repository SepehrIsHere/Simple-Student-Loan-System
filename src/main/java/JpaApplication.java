import util.ApplicationContext;

public class JpaApplication {
    public static void main(String[] args)  {
        ApplicationContext context = ApplicationContext.getInstance();
       context.getMainMenu().showMenu();
    }

}
