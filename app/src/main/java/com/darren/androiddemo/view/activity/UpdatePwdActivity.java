package com.darren.androiddemo.view.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.darren.androiddemo.MainActivity;
import com.darren.androiddemo.R;

import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.UpdateListener;

public class UpdatePwdActivity extends AppCompatActivity {
    private Intent intent;
    private EditText et_old_pwd, et_new_pwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_pwd);
        findViews();
    }

    private void findViews() {
        et_old_pwd = (EditText) findViewById(R.id.et_old_pwd);
        et_new_pwd = (EditText) findViewById(R.id.et_new_pwd);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_cancel:
                intent = new Intent(UpdatePwdActivity.this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_sure:
                updateUsersPassword();
                break;
        }
    }

    private void updateUsersPassword() {
        String oldPwd = et_old_pwd.getText().toString();
        String newPwd = et_new_pwd.getText().toString();
        BmobUser.updateCurrentUserPassword(oldPwd, newPwd, new UpdateListener() {
            @Override
            public void done(BmobException e) {
                if (e == null) {
                    Toast.makeText(UpdatePwdActivity.this, "密码修改成功，可以用新密码进行登录啦", Toast.LENGTH_SHORT).show();
                    intent = new Intent(UpdatePwdActivity.this, MainActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(UpdatePwdActivity.this, "失败" + e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
