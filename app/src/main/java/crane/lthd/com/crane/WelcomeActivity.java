package crane.lthd.com.crane;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;

public class WelcomeActivity extends AppCompatActivity {
    Handler mhandler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            if (msg.what==123) {
                Intent it=new Intent(WelcomeActivity.this,LoginActivity.class);
                startActivity(it);
                finish();
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_welcome);
        mhandler.sendEmptyMessageDelayed(123,3000);
    }
}
