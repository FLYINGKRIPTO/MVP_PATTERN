package com.example.mvp_pattern;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.mvp_pattern.databinding.ActivityMainBinding;
import com.example.mvp_pattern.presenter.ILoginPresenter;
import com.example.mvp_pattern.presenter.LoginPresenter;
import com.example.mvp_pattern.view.ILoginView;

import java.util.logging.Logger;

public class MainActivity extends AppCompatActivity implements ILoginView {
    private  ActivityMainBinding binding;
    ILoginPresenter loginPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater()) ;
        setContentView(binding.getRoot());

        //init
        loginPresenter = new LoginPresenter(this);

        //EVENT
        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginPresenter.onLogin(binding.edtEmail.getText().toString(),binding.edtPassword.getText().toString());
            }
        });
    }

    @Override
    public void onLoginResult(String message) {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLoginError(String message) {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();

    }
}
