package crane.lthd.com.crane;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

import crane.lthd.com.crane.R;
public class LeftFragment extends Fragment {
    private String[] texts={"P2","P4","P8"};
    private TextView tv1;
    private Handler mhandler=new Handler(){
        int index=0;
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case 250:
                    index=index%3;
                    tv1.setText(texts[index]);
                    index++;
                    break;
            }
            super.handleMessage(msg);
        }
    };
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_left, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        tv1= (TextView) view.findViewById(R.id.tv1);
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                mhandler.sendEmptyMessage(250);
            }
        }, 0, 700);
    }
    public void setDangwei(){

    }

}
