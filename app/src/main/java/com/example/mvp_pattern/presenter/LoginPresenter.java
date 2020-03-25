package com.example.mvp_pattern.presenter;

import com.example.mvp_pattern.model.User;
import com.example.mvp_pattern.view.ILoginView;

public class LoginPresenter implements ILoginPresenter {
    ILoginView loginView;

    public LoginPresenter(ILoginView loginView) {
        this.loginView = loginView;
    }

    @Override
    public void onLogin(String email, String password) {
         User user = new User(email,password);
         int loginCode = user.isValidData();

        if(loginCode == 0){
            loginView.onLoginError("You must Enter your Email");
        }
        else if(loginCode == 1) loginView.onLoginError("Not a valid Email Address");
        else if(loginCode == 2) loginView.onLoginError("Password Length Must be greater than 6");
        else if(loginCode == -1) loginView.onLoginResult("Login Successful");


    }
}
