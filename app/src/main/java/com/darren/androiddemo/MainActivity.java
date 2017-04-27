package com.darren.androiddemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.darren.androiddemo.bean.Users;
import com.darren.androiddemo.view.activity.MenuActivity;
import com.darren.androiddemo.view.activity.RegisterActivity;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

public class MainActivity extends AppCompatActivity {
private Intent intent;
    private EditText et_name,et_pwd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化
        Bmob.initialize(this, "8c8d7caa55be568ba20e6b9baa5865f8");
        findViews();
    }

    private void findViews() {
        et_name= (EditText) findViewById(R.id.et_name);
        et_pwd= (EditText) findViewById(R.id.et_pwd);
    }

    public void onClick(View view){
        switch (view.getId()){
            case R.id.btn_login:
                login();
                break;
            case R.id.btn_forget:
                break;
            case R.id.btn_register:
                intent=new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);
                break;
        }
    }

    private void login() {
        String name=et_name.getText().toString();
        String pwd=et_pwd.getText().toString();
        BmobUser bu =new BmobUser();
        bu.setUsername(name);
        bu.setPassword(pwd);
        bu.login(new SaveListener<Users>() {
            @Override
            public void done(Users users, BmobException e) {
                if(e==null){
                    Toast.makeText(MainActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                    intent=new Intent(MainActivity.this,MenuActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}
