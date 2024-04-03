import ui.LoginJFrame;

import java.sql.SQLException;

public class Main
{
    public static void main(String[] args)
    {
        try
        {
            new LoginJFrame();
        } catch (SQLException e)
        {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e)
        {
            throw new RuntimeException(e);
        };
    }
}