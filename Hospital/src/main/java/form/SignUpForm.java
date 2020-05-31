package main.java.form;

public class SignUpForm {
    private String name;
    private String surname;
    private String age;
    private String login;
    private String password;

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public SignUpForm() {
        super();
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getAge() {
        return age;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}
