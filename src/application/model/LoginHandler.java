package src.application.model;

public class LoginHandler {

    static Login UserLogin;

    public static Login getLogin() {
        UserLogin = UserLogin == null ? new Login() : UserLogin;
        return UserLogin;
    }

}
