package com.iitpkd.hospitalManagement.App.dto;

public class LoginOut {

    Login login;
    int id;

    public LoginOut(Login login, int id) {
        this.login = login;
        this.id = id;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
