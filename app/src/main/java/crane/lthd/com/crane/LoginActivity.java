package crane.lthd.com.crane;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.Toast;

public class LoginActivity extends Activity {
    private ImageButton userlogin;
    private ImageButton wifilogin;
    private EditText et_user;
    private EditText et_pwd;
    private RelativeLayout relativeLayout_login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        userlogin=(ImageButton)findViewById(R.id.button2);
        wifilogin=(ImageButton)findViewById(R.id.button);
        et_user=(EditText)findViewById(R.id.et_user);
        et_pwd=(EditText)findViewById(R.id.et_pwd);
        relativeLayout_login=(RelativeLayout)findViewById(R.id.rl_login);

    }
    public void Login(View view){
       switch (view.getId())
       {
           case R.id.button:
               Intent it=new Intent(LoginActivity.this,MainActivity.class);
               startActivity(it);
               finish();
               break;
           case R.id.button2:
               relativeLayout_login.setVisibility(View.VISIBLE);
               userlogin.setBackgroundResource(R.drawable.zhmmdl_checked);
               break;
       }

    }
    public void hideLogin(View view){
        relativeLayout_login.setVisibility(View.GONE);
        userlogin.setBackgroundResource(R.drawable.zhmmdl);
    }
}
