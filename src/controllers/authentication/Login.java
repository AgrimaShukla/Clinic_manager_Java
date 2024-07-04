package controllers.authentication;
import handlers.UserHandler;

import java.sql.SQLException;
import java.util.*;

import static view.menu.MainMenu.roleBasedMenu;

public class Login {

    public String login(String username, String password) throws Exception{
        try {
            Map<String, String> success = UserHandler.login(username, password);
            roleBasedMenu(success);
            return "";
        }
        catch (SQLException e){
            return "Invalid credentials\nLogin again";
        }
    }
}
