import ui.LoginJFrame;
import ui.RegisterJFrame;
import ui.UserJFrame;

import java.sql.SQLException;

public class Main
{
    public static void main(String[] args)
    {

//        try
//        {
//            new RegisterJFrame();
//        } catch (SQLException e)
//        {
//            throw new RuntimeException(e);
//        } catch (ClassNotFoundException e)
//        {
//            throw new RuntimeException(e);
//        }
//        try
//        {
//            new UserJFrame();
//        } catch (SQLException e)
//        {
//            throw new RuntimeException(e);
//        } catch (ClassNotFoundException e)
//        {
//            throw new RuntimeException(e);
//        }
        try
        {
            new LoginJFrame();
        } catch (SQLException e)
        {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e)
        {
            throw new RuntimeException(e);
        }
//        new UserJFrame();
    }
}