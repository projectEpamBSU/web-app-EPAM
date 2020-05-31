package main.java.form;

public class SignInForm {
    private String login;
    private String password;

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public SignInForm() {
        super();
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}
