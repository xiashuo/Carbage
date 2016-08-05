package crane.lthd.com.crane;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.os.Bundle;
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
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import crane.lthd.com.crane.adapter.SimpleAdapter_lv_warning;

public class MainActivity extends FragmentActivity implements OnClickListener,InfoFragment.setHead {
    private int flag2=0;
    private TextView tv_title;
    private TextView tv_error;
    private DrawerLayout drawer_layout;
    private LinearLayout drawer_left;
    private LinearLayout ll_info;
    private LinearLayout ll_work;
    private LinearLayout ll_manager;
    private LinearLayout ll_set;
    private Fragment infoFragment;
    private Fragment workFragment;
    private Fragment managerFragment;
    private Fragment setFragment;
    private LinearLayout button1;
    private LinearLayout button2;
    private LinearLayout button3;
    private LinearLayout button4;
    private ImageButton ib_menu;
    private CheckBox cb_guzhang;
    private Window window;
    private WindowManager.LayoutParams params;
    private PopupWindow pw;
    private int flag=0;
    private ListView lv_warning;
    private List<Map<String,Object>> list;
    private Map<String,Object> map;
    private SimpleAdapter_lv_warning adapter_lv;
    private Data_Warning data;
    private Handler mhandler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what==250)
                flag=0;
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initEvent();
        initFragment(0);
    }
    private void initFragment(int index) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        switch (index){
            case 0:
                if(flag2>0)
                    transaction.setCustomAnimations(R.anim.sp2_enter,0);
                flag2=0;
                infoFragment=new InfoFragment();
                transaction.replace(R.id.fl_content, infoFragment);
                break;
            case 1:
                if (flag2<1)
                    transaction.setCustomAnimations(R.anim.sp_enter,0);
                else if (flag2>1)
                    transaction.setCustomAnimations(R.anim.sp2_enter,0);
                flag2=1;
                workFragment=new WorkFragment();
                transaction.replace(R.id.fl_content, workFragment);
                break;
            case 2:
                if (flag2<2)
                    transaction.setCustomAnimations(R.anim.sp_enter,0);
                else if (flag2>2)
                    transaction.setCustomAnimations(R.anim.sp2_enter,0);
                flag2=2;
                if (managerFragment==null){
                    managerFragment=new ManagerFragment();
                    transaction.replace(R.id.fl_content, managerFragment);
                }
                else{
                    transaction.replace(R.id.fl_content, managerFragment);
                }
                break;
            case 3:
                if (flag2<3)
                    transaction.setCustomAnimations(R.anim.sp_enter,0);
                flag2=3;
                if (setFragment==null){
                    setFragment=new SetFragment();
                    transaction.replace(R.id.fl_content, setFragment);
                }
                else{
                    transaction.replace(R.id.fl_content, setFragment);
                }

                break;
        }
        transaction.commit();
    }
    private void hideFragment(FragmentTransaction transaction) {
        if(infoFragment!=null){
           transaction.hide(infoFragment);
        }
        if(workFragment!=null){
            transaction.remove(workFragment);
        }
        if(managerFragment!=null){
            transaction.hide(managerFragment);
        }
        if(setFragment!=null){
            transaction.hide(setFragment);
        }
    }
    private void initEvent() {
        ll_info.setOnClickListener(this);
        ll_work.setOnClickListener(this);
        ll_manager.setOnClickListener(this);
        ll_set.setOnClickListener(this);
        cb_guzhang.setOnCheckedChangeListener(onCheckedChangeListener);
        drawer_layout.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {

            }

            @Override
            public void onDrawerOpened(View drawerView) {
                drawer_layout.openDrawer(GravityCompat.END);
                drawer_layout.openDrawer(GravityCompat.START);

            }

            @Override
            public void onDrawerClosed(View drawerView) {
                drawer_layout.closeDrawer(GravityCompat.END);
                drawer_layout.closeDrawer(GravityCompat.START);
            }

            @Override
            public void onDrawerStateChanged(int newState) {
            }
        });
        ib_menu.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                drawer_layout.openDrawer(GravityCompat.END);
                drawer_layout.openDrawer(GravityCompat.START);
            }
        });
    }
    private void initView() {
        data=new Data_Warning();
        tv_title= (TextView) findViewById(R.id.tv_title);
        ll_info=(LinearLayout)findViewById(R.id.ll_info);
        ll_work=(LinearLayout)findViewById(R.id.ll_work);
        ll_manager=(LinearLayout)findViewById(R.id.ll_manager);
        ll_set=(LinearLayout)findViewById(R.id.ll_set);
        ll_info.setBackgroundResource(R.mipmap.xinxi_selected);
        drawer_layout= (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer_left= (LinearLayout) findViewById(R.id.drawer_left);
        button1=(LinearLayout)findViewById(R.id.button1);
        button2=(LinearLayout)findViewById(R.id.button2);
        button3=(LinearLayout)findViewById(R.id.button3);
        button4=(LinearLayout)findViewById(R.id.button4);
        ib_menu= (ImageButton)findViewById(R.id.ib_menu);
        cb_guzhang=(CheckBox)findViewById(R.id.cb_guzhang);
        window=getWindow();
        params=window.getAttributes();
    }
    @Override
    public void onClick(View v) {
        restartButton();
        switch (v.getId()){
            case R.id.ll_info:
                ll_info.setBackgroundResource(R.mipmap.xinxi_selected);
                initFragment(0);
                tv_title.setText("上车信息");
                break;
            case R.id.ll_work:
                ll_work.setBackgroundResource(R.mipmap.zuoye_selected);
                initFragment(1);
                tv_title.setText("作业");
                break;
            case R.id.ll_manager:
                ll_manager.setBackgroundResource(R.mipmap.guanli_selected);
                initFragment(2);
                tv_title.setText("管理");
                break;
            case R.id.ll_set:
                ll_set.setBackgroundResource(R.mipmap.set_selet);
                initFragment(3);
                tv_title.setText("设置");
                break;
        }
    }
    private CompoundButton.OnCheckedChangeListener onCheckedChangeListener=new
            CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked){
                        showPopWarning();
                    }
                }
            };
    private View.OnTouchListener onTouchListener=new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            if (pw!=null&&pw.isShowing()){
                pw.dismiss();
                cb_guzhang.setChecked(false);
            }
            return false;
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
    public void showPopWarning(){
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
        pw.showAtLocation(findViewById(R.id.cb_guzhang), Gravity.RIGHT, 20, 120);
    }
    private void restartButton() {
        ll_info.setBackgroundResource(R.mipmap.xinxi);
        ll_work.setBackgroundResource(R.mipmap.zuoye);
        ll_manager.setBackgroundResource(R.mipmap.guanli);
        ll_set.setBackgroundResource(R.mipmap.set);

    }
    public void userManager(View view){
        button1.setBackgroundResource(R.color.bg_list);
        button2.setBackgroundResource(R.color.bg_list);
        button3.setBackgroundResource(R.color.bg_list);
        button4.setBackgroundResource(R.color.bg_list);
        switch (view.getId()){
            case R.id.button1:
                button1.setBackgroundResource(R.color.bg_selected);
                break;
            case R.id.button2:
                button2.setBackgroundResource(R.color.bg_selected);
                break;
            case R.id.button3:
                button3.setBackgroundResource(R.color.bg_selected);
                break;
            case R.id.button4:
                button4.setBackgroundResource(R.color.bg_selected);
                break;
        }
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode==event.KEYCODE_BACK){
            switch (flag){
                case 0:
                    flag=1;
                    Toast.makeText(this,"再按一次退出程序",Toast.LENGTH_LONG).show();
                    mhandler.sendEmptyMessageDelayed(250,2000);
                    break;
                case 1:
                    finish();
                    break;
            }
        }
        return false;
    }

    @Override
    public void setTitle(String str){
        tv_title.setText(str);
    }
}