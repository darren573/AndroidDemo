package com.darren.androiddemo.view.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.darren.androiddemo.MainActivity;
import com.darren.androiddemo.R;
import com.darren.androiddemo.bean.Users;

import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

public class RegisterActivity extends AppCompatActivity {
    private EditText et_register_name, et_register_pwd, et_register_email;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        findViews();
    }

    private void findViews() {
        et_register_name = (EditText) findViewById(R.id.et_register_name);
        et_register_pwd = (EditText) findViewById(R.id.et_register_pwd);
        et_register_email = (EditText) findViewById(R.id.et_register_email);
    }

    public void putOn(View view) {
        switch (view.getId()) {
            case R.id.btn_putOn:
                commit();
                break;
            case R.id.btn_goBack:
                intent=new Intent(RegisterActivity.this,MainActivity.class);
                startActivity(intent);
                break;
        }
    }

    private void commit() {
        String name = et_register_name.getText().toString();
        String pwd = et_register_pwd.getText().toString();
        String email = et_register_email.getText().toString();
        BmobUser user = new BmobUser();
        user.setUsername(name);
        user.setPassword(pwd);
        user.setEmail(email);
        user.signUp(new SaveListener<Users>() {
            @Override
            public void done(Users users, BmobException e) {
                if (e == null) {
                    Toast.makeText(RegisterActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
                    intent = new Intent(RegisterActivity.this, MainActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(RegisterActivity.this, "注册失败", Toast.LENGTH_SHORT).show();
                    Log.e("TAG", "e");
                }
            }
        });
    }
}
