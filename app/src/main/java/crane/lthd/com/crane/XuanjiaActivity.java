package crane.lthd.com.crane;

import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import crane.lthd.com.crane.adapter.SimpleAdapter_lv_warning;

public class XuanjiaActivity extends AppCompatActivity {
    private setDangwei setDangwei;
    private Fragment leftFragment;
    private Fragment rightFragment;
    private TextView tv_error;
    private ListView lv_warning;
    private List<Map<String,Object>> list;
    private Map<String,Object> map;
    private SimpleAdapter_lv_warning adapter_lv;
    private Data_Warning data;
    private int flag3=0;
    private CheckBox cb_gxtx;
    private CheckBox cb_lt;
    private CheckBox cb_lb;
    private CheckBox cb_rt;
    private CheckBox cb_rb;
    private ImageView iv_checking;
    private ImageView iv_checking2;
    private ImageButton ib_quli;
    private ImageButton ib_guzhang;
    private ImageButton ib_down;
    private ImageButton ib_up;
    private Window window;
    private WindowManager.LayoutParams params;
    private PopupWindow pw;
    Handler mhandler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            if (msg.what==135){
                iv_checking.setVisibility(View.GONE);
                ib_quli.setBackgroundResource(R.drawable.quli_pressed);
                setDangwei.setText(flag3);
            }
            if (msg.what==250){
                iv_checking2.setVisibility(View.GONE);
                cb_gxtx.setClickable(true);
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xuanjia);
        initView();
        initEvent();
    }
    private void initView() {
        data=new Data_Warning();
        ib_guzhang= (ImageButton) findViewById(R.id.ib_warning);
        window=getWindow();
        params=window.getAttributes();
        ib_quli = (ImageButton) findViewById(R.id.bt_quli);
        ib_down = (ImageButton) findViewById(R.id.bt_down);
        ib_up = (ImageButton) findViewById(R.id.bt_up);
        iv_checking= (ImageView) findViewById(R.id.iv_quli);
        iv_checking2=(ImageView)findViewById(R.id.iv_gxtx);
        cb_gxtx= (CheckBox) findViewById(R.id.cb_gxtx);
        cb_lt= (CheckBox) findViewById(R.id.cb_lt);
        cb_lb= (CheckBox) findViewById(R.id.cb_lb);
        cb_rt= (CheckBox) findViewById(R.id.cb_rt);
        cb_rb= (CheckBox) findViewById(R.id.cb_rb);
    }
    private void initEvent() {
        cb_gxtx.setOnCheckedChangeListener(onChecklistener);
        cb_rb.setOnCheckedChangeListener(onChecklistener);
        cb_rt.setOnCheckedChangeListener(onChecklistener);
        cb_lt.setOnCheckedChangeListener(onChecklistener);
        cb_lb.setOnCheckedChangeListener(onChecklistener);
        ib_down.setOnTouchListener(onTouchListener2);
        ib_up.setOnTouchListener(onTouchListener2);
    }
    private void initFragment(int i) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        switch (i){
            case 1:
                transaction.setCustomAnimations(R.anim.sp2_enter,R.anim.sp2_exit);
                if (leftFragment==null){
                    leftFragment=new LeftFragment();
                    transaction.add(R.id.fl_content, leftFragment);
                }
                else
                    transaction.show(leftFragment);
                break;
            case 2:
                transaction.setCustomAnimations(R.anim.sp_enter,R.anim.sp_exit);
                if (rightFragment == null) {
                    rightFragment=new RightFragment();
                    transaction.replace(R.id.fl_content2,rightFragment);
                }
                else
                    transaction.show(rightFragment);
                break;
            case 3:
                hideFragment(transaction);
                break;
        }
        transaction.commit();
    }
    private void hideFragment(FragmentTransaction transaction) {
        if(leftFragment!=null){
            transaction.setCustomAnimations(R.anim.sp_enter,R.anim.sp_exit);
            transaction.hide(leftFragment);
        }
        if(rightFragment!=null){
            transaction.setCustomAnimations(R.anim.sp2_enter,R.anim.sp2_exit);
            transaction.hide(rightFragment);
        }
    }
    public void showHide(View v){
        switch (v.getId()){
            case R.id.ib_left:
                initFragment(1);
                break;
            case R.id.ib_right:
                initFragment(2);
                break;
        }
    }
    public void hideInfo(View v){
        initFragment(3);
    }
    public void setQuli(View view) {
        switch (flag3){
            case 0:
                iv_checking.setVisibility(View.VISIBLE);
                mhandler.sendEmptyMessageDelayed(135, 2000);
                flag3=1;
                break;
            case 1:
                view.setBackgroundResource(R.drawable.quli);
                flag3=0;
                setDangwei.setText(flag3);
                break;
        }

    }
    private View.OnTouchListener onTouchListener=new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            if (pw!=null&&pw.isShowing()){
                pw.dismiss();
                ib_guzhang.setBackgroundResource(R.drawable.guzhang);
            }
            return false;
        }
    };
    private View.OnTouchListener onTouchListener2=new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            switch (v.getId()){
                case R.id.bt_down:
                    if (event.getAction()==MotionEvent.ACTION_DOWN){
                        if (cb_lt.isChecked())
                            cb_lt.setBackgroundResource(R.drawable.zxxg);
                        else if(cb_lb.isChecked())
                            cb_lb.setBackgroundResource(R.drawable.zxxg);
                        else if (cb_rt.isChecked())
                            cb_rt.setBackgroundResource(R.drawable.yxxg);
                        else if (cb_rb.isChecked())
                            cb_rb.setBackgroundResource(R.drawable.yxxg);
                    }
                    else if (event.getAction()==MotionEvent.ACTION_UP){
                        cb_lb.setBackgroundResource(R.drawable.zqzh_selector);
                        cb_lt.setBackgroundResource(R.drawable.zqzh_selector);
                        cb_rb.setBackgroundResource(R.drawable.yqzh_selector);
                        cb_rt.setBackgroundResource(R.drawable.yqzh_selector);
                    }
                    break;
                case R.id.bt_up:
                    if (event.getAction()==MotionEvent.ACTION_DOWN){
                        if (cb_lt.isChecked())
                            cb_lt.setBackgroundResource(R.drawable.zsxg);
                        else if(cb_lb.isChecked())
                            cb_lb.setBackgroundResource(R.drawable.zsxg);
                        else if (cb_rt.isChecked())
                            cb_rt.setBackgroundResource(R.drawable.ysxg);
                        else if (cb_rb.isChecked())
                            cb_rb.setBackgroundResource(R.drawable.ysxg);
                    }
                    else if (event.getAction()==MotionEvent.ACTION_UP){
                        cb_lb.setBackgroundResource(R.drawable.zqzh_selector);
                        cb_lt.setBackgroundResource(R.drawable.zqzh_selector);
                        cb_rb.setBackgroundResource(R.drawable.yqzh_selector);
                        cb_rt.setBackgroundResource(R.drawable.yqzh_selector);
                    }
                    break;
            }
            return false;
        }
    };
    public void onBack(View v){
        finish();
    }
    private CompoundButton.OnCheckedChangeListener onChecklistener=new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            switch (buttonView.getId()){
                case R.id.cb_gxtx:
                    if (isChecked){
                        iv_checking2.setVisibility(View.VISIBLE);
                        cb_gxtx.setClickable(false);
                        mhandler.sendEmptyMessageDelayed(250,2000);
                    }
                    break;
                case R.id.cb_lt:
                    if (isChecked){
                        cb_lb.setChecked(false);
                        cb_rt.setChecked(false);
                        cb_rb.setChecked(false);
                    }
                    break;
                case R.id.cb_lb:
                    if (isChecked){
                        cb_lt.setChecked(false);
                        cb_rt.setChecked(false);
                        cb_rb.setChecked(false);
                    }
                    break;
                case R.id.cb_rt:
                    if (isChecked){
                        cb_lb.setChecked(false);
                        cb_lt.setChecked(false);
                        cb_rb.setChecked(false);
                    }
                    break;
                case R.id.cb_rb:
                    if (isChecked){
                        cb_lb.setChecked(false);
                        cb_rt.setChecked(false);
                        cb_lt.setChecked(false);
                    }
                    break;
            }
        }
    };
    private void initListData() {
        list=new ArrayList<>();
        for (int i=0;i<data.image.length;i++){
            map=new HashMap<>();
            map.put("image",data.image[i]);
            map.put("name",data.name_gz[i]);
            map.put("code",data.code_gz[i]);
            list.add(map);
        }
        adapter_lv=new SimpleAdapter_lv_warning(this,list,R.layout.item_warning,new String[]{"image","name",
                "code"},new int[]{R.id.imageView1,R.id.textView1,R.id.textView2});
        lv_warning.setAdapter(adapter_lv);
    }
    public void showPopWarning(View view){
        View v = getLayoutInflater().inflate(R.layout.pop_warning, null);
        RelativeLayout ll_blank= (RelativeLayout) v.findViewById(R.id.ll_blank);
        ll_blank.setOnTouchListener(onTouchListener);
        lv_warning= (ListView)v.findViewById(R.id.lv_warning);
        tv_error=(TextView)v.findViewById(R.id.tv_error);
        initListData();
        lv_warning.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                adapter_lv.flag=1;
                adapter_lv.notifyDataSetInvalidated();
                tv_error.setText(data.info_error[position]);
            }
        });
        pw = new PopupWindow(v, ViewGroup.LayoutParams.FILL_PARENT,
                ViewGroup.LayoutParams.FILL_PARENT, true);
        pw.setAnimationStyle(R.anim.anim_pop);
        pw.setBackgroundDrawable(new BitmapDrawable());
        pw.showAtLocation(findViewById(R.id.ib_warning), Gravity.CENTER, 0, 120);
        view.setBackgroundResource(R.drawable.guzhang_pressed);
    }
    public interface setDangwei {
        public void setText(int flag);
    }
    @Override
    public void onAttachFragment(Fragment fragment) {
        super.onAttachFragment(fragment);
        if (fragment==rightFragment)
            setDangwei=(setDangwei)fragment;
    }
}
