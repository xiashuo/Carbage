package crane.lthd.com.crane;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
public class WorkFragment extends Fragment {
    private Window window;
    private WindowManager.LayoutParams params;
    private View view;
    private AlertDialog diadog;
    private LinearLayout ll1;
    private LinearLayout ll2;
    private LinearLayout ll3;
    private LinearLayout ll4;
    private LinearLayout ll5;
    private LinearLayout ll1_set;
    private LinearLayout ll2_set;
    private LinearLayout layout_left;
    private LinearLayout ll_fbcd;
    private LinearLayout ll_fbjd;
    private GridLayout gl_sbzh;
    private RelativeLayout layout_right;
    private RelativeLayout rl1;
    private RelativeLayout rlset1;
    private RelativeLayout rlset2;
    private RelativeLayout rlset3;
    private RelativeLayout rlset4;
    private TextView tv1;
    private TextView tv2;
    private TextView tv3;
    private TextView tv4;
    private TextView tv5;
    private TextView tv6;
    private TextView tv7;
    private TextView tv_sbzh;
    private EditText et_beilv;
    private Spinner sp;
    private ImageButton bt1;
    private ImageButton bt2;
    private ImageButton bt3;
    private ImageButton bt4;
    private ImageButton bt5;
    private ImageButton bt6;
    private ImageButton bt7;
    private ImageButton bt8;
    private Switch aSwitch;
    private ImageButton rb1;
    private ImageButton rb2;
    private ImageButton rb3;
    private ImageButton rb4;
    private ImageButton rb5;
    private ImageButton rb6;
    private ImageButton rb7;
    private ImageButton rb8;
    private ImageButton rb9;
    private ImageButton rb10;
    private ImageButton rb11;
    private ImageButton rb12;
    private ImageButton rb13;
    private ImageButton rb14;
    private Button bt_sure;
    private Button bt_sure2;
    private CheckBox cb_sbzh;
    private String[] rb={"主臂工况","","","80t","半伸"};
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_work, container, false);
        initView(view,inflater);
        initEvent();
        return view;
    }
    private void initEvent() {
        ll1.setOnClickListener(listener1);
        ll2.setOnClickListener(listener1);
        ll3.setOnClickListener(listener4);
        ll4.setOnClickListener(listener4);
        ll5.setOnClickListener(listener4);
        bt1.setOnClickListener(listener3);
        bt2.setOnClickListener(listener3);
        bt3.setOnClickListener(listener3);
        bt4.setOnClickListener(listener3);
        bt5.setOnClickListener(listener3);
        bt6.setOnClickListener(listener3);
        bt7.setOnClickListener(listener3);
        bt8.setOnClickListener(listener3);
        rb1.setOnClickListener(listener_rg1);
        rb2.setOnClickListener(listener_rg1);
        rb3.setOnClickListener(listener_rg1);
        rb4.setOnClickListener(listener_rg2);
        rb5.setOnClickListener(listener_rg2);
        rb6.setOnClickListener(listener_rg2);
        rb7.setOnClickListener(listener_rg3);
        rb8.setOnClickListener(listener_rg3);
        rb9.setOnClickListener(listener_rg3);
        rb10.setOnClickListener(listener_rg4);
        rb11.setOnClickListener(listener_rg4);
        rb12.setOnClickListener(listener_rg4);
        rb13.setOnClickListener(listener_rg5);
        rb14.setOnClickListener(listener_rg5);
        layout_left.setOnClickListener(listener5);
        layout_right.setOnClickListener(listener5);
        bt_sure.setOnClickListener(listener6);
        bt_sure2.setOnClickListener(listener7);
        cb_sbzh.setOnCheckedChangeListener(onCheckedChangeListener);
    }
    private void initView(View view,LayoutInflater inflater) {
        cb_sbzh= (CheckBox) view.findViewById(R.id.cb_sbzh);
        ll1= (LinearLayout) view.findViewById(R.id.button1);
        ll2= (LinearLayout) view.findViewById(R.id.button2);
        ll3= (LinearLayout) view.findViewById(R.id.button3);
        ll4= (LinearLayout) view.findViewById(R.id.button4);
        ll5= (LinearLayout) view.findViewById(R.id.button5);
        gl_sbzh= (GridLayout) view.findViewById(R.id.gl_sbzh);
        layout_left= (LinearLayout) view.findViewById(R.id.ll_left);
        layout_right= (RelativeLayout)view.findViewById(R.id.layout_right);
        ll1_set= (LinearLayout) view.findViewById(R.id.ll1_set);
        ll2_set= (LinearLayout) view.findViewById(R.id.ll2_set);
        ll_fbcd= (LinearLayout) view.findViewById(R.id.ll_fbcd);
        ll_fbjd= (LinearLayout) view.findViewById(R.id.ll_fbjd);
        rl1=(RelativeLayout)view.findViewById(R.id.rl1);
        rlset1=(RelativeLayout)view.findViewById(R.id.rl_set1);
        rlset2=(RelativeLayout)view.findViewById(R.id.rl_set2);
        rlset3=(RelativeLayout)view.findViewById(R.id.rl_set3);
        rlset4=(RelativeLayout)view.findViewById(R.id.rl_set4);
        tv1=(TextView)view.findViewById(R.id.tv1);
        tv2=(TextView)view.findViewById(R.id.tv2);
        tv3=(TextView)view.findViewById(R.id.tv3);
        tv4=(TextView)view.findViewById(R.id.tv4);
        tv5=(TextView)view.findViewById(R.id.tv5);
        tv_sbzh=(TextView)view.findViewById(R.id.tv_sbzh);
        et_beilv= (EditText) view.findViewById(R.id.et_beilv);
        sp= (Spinner) view.findViewById(R.id.sp1);
        ArrayAdapter adapter=ArrayAdapter.createFromResource(getContext(),R.array.data,
                android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(R.layout.item_spinner);
        sp.setAdapter(adapter);
        bt1=(ImageButton)view.findViewById(R.id.dxk1);
        bt2=(ImageButton)view.findViewById(R.id.dxk2);
        bt3=(ImageButton)view.findViewById(R.id.dxk3);
        bt4=(ImageButton)view.findViewById(R.id.dxk4);
        bt5=(ImageButton)view.findViewById(R.id.dxk5);
        bt6=(ImageButton)view.findViewById(R.id.dxk6);
        bt7=(ImageButton)view.findViewById(R.id.dxk7);
        bt8=(ImageButton)view.findViewById(R.id.dxk8);
        aSwitch= (Switch) view.findViewById(R.id.switch4);
        rb1=(ImageButton)view.findViewById(R.id.rb1);
        rb2=(ImageButton)view.findViewById(R.id.rb2);
        rb3=(ImageButton)view.findViewById(R.id.rb3);
        rb4=(ImageButton)view.findViewById(R.id.rb4);
        rb5=(ImageButton)view.findViewById(R.id.rb5);
        rb6=(ImageButton)view.findViewById(R.id.rb6);
        rb7=(ImageButton)view.findViewById(R.id.rb7);
        rb8=(ImageButton)view.findViewById(R.id.rb8);
        rb9=(ImageButton)view.findViewById(R.id.rb9);
        rb10=(ImageButton)view.findViewById(R.id.rb10);
        rb11=(ImageButton)view.findViewById(R.id.rb11);
        rb12=(ImageButton)view.findViewById(R.id.rb12);
        rb13=(ImageButton)view.findViewById(R.id.rb13);
        rb14=(ImageButton)view.findViewById(R.id.rb14);
        bt_sure= (Button) view.findViewById(R.id.bt_sure);
        bt_sure2= (Button) view.findViewById(R.id.bt_sure2);
    }
    private View.OnClickListener listener_rg1=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            rb1.setBackgroundResource(R.drawable.zbgk);
            rb2.setBackgroundResource(R.drawable.gdfb);
            rb3.setBackgroundResource(R.drawable.bygk);
            switch (v.getId()){
                case R.id.rb1:
                    rb1.setBackgroundResource(R.drawable.zbgk_selected);
                    rb[0]="主臂工况";
                    ll_fbcd.setVisibility(View.GONE);
                    ll_fbjd.setVisibility(View.GONE);
                    rb[1]="";
                    rb[2]="";
                    break;
                case R.id.rb2:
                    rb2.setBackgroundResource(R.drawable.gdfb_selected);
                    rb[0]="固定副臂";
                    ll_fbcd.setVisibility(View.VISIBLE);
                    ll_fbjd.setVisibility(View.VISIBLE);
                    rb[1]="10.6m";
                    rb[2]="30°";
                    break;
                case R.id.rb3:
                    rb3.setBackgroundResource(R.drawable.bygk_selected);
                    rb[0]="保养工况";
                    ll_fbcd.setVisibility(View.GONE);
                    ll_fbjd.setVisibility(View.GONE);
                    rb[1]="";
                    rb[2]="";
                    break;
            }
        }
    };
    private View.OnClickListener listener_rg2=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            rb4.setBackgroundResource(R.drawable.fbcd106);
            rb5.setBackgroundResource(R.drawable.fbcd83);
            rb6.setBackgroundResource(R.drawable.fbcd53);
            switch (v.getId()){
                case R.id.rb4:
                    rb4.setBackgroundResource(R.drawable.fbcd106_selected);
                    rb[1]="10.6m";
                    break;
                case R.id.rb5:
                    rb5.setBackgroundResource(R.drawable.fbcd83_selected);
                    rb[1]="8.3m";
                    break;
                case R.id.rb6:
                    rb6.setBackgroundResource(R.drawable.fbcd53_selected);
                    rb[1]="5.3m";
                    break;
            }
        }
    };
    private View.OnClickListener listener_rg3=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            rb7.setBackgroundResource(R.drawable.fbjd30);
            rb8.setBackgroundResource(R.drawable.fbjd15);
            rb9.setBackgroundResource(R.drawable.fbjd10);
            switch (v.getId()){
                case R.id.rb7:
                    rb7.setBackgroundResource(R.drawable.fbjd30_selecte);
                    rb[2]="30°";
                    break;
                case R.id.rb8:
                    rb8.setBackgroundResource(R.drawable.fbjd15_selected);
                    rb[2]="15°";
                    break;
                case R.id.rb9:
                    rb9.setBackgroundResource(R.drawable.fbjd10_select);
                    rb[2]="10°";
                    break;
            }
        }
    };
    private View.OnClickListener listener_rg4=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            rb10.setBackgroundResource(R.drawable.phz80);
            rb11.setBackgroundResource(R.drawable.phz50);
            rb12.setBackgroundResource(R.drawable.phz15);
            switch (v.getId()){
                case R.id.rb10:
                    rb10.setBackgroundResource(R.drawable.phz80_selected);
                    rb[3]="80t";
                    break;
                case R.id.rb11:
                    rb11.setBackgroundResource(R.drawable.phz50_selected);
                    rb[3]="50t";
                    break;
                case R.id.rb12:
                    rb12.setBackgroundResource(R.drawable.phz15_selected);
                    rb[3]="15t";
                    break;
            }
        }
    };
    private View.OnClickListener listener_rg5=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            rb13.setBackgroundResource(R.drawable.ztbs);
            rb14.setBackgroundResource(R.drawable.ztqs);
            switch (v.getId()){
                case R.id.rb13:
                    rb13.setBackgroundResource(R.drawable.ztbs_selected);
                    rb[4]="半伸";
                    break;
                case R.id.rb14:
                    rb14.setBackgroundResource(R.drawable.ztqs_selected);
                    rb[4]="全伸";
                    break;
            }
        }
    };
    private View.OnClickListener listener3=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            bt1.setBackgroundResource(R.drawable.dxk);
            bt2.setBackgroundResource(R.drawable.dxk);
            bt3.setBackgroundResource(R.drawable.dxk);
            bt4.setBackgroundResource(R.drawable.dxk);
            bt5.setBackgroundResource(R.drawable.dxk);
            bt6.setBackgroundResource(R.drawable.dxk);
            bt7.setBackgroundResource(R.drawable.dxk);
            bt8.setBackgroundResource(R.drawable.dxk);
            switch (v.getId()){
                case R.id.dxk1:
                    bt1.setBackgroundResource(R.drawable.dxk_selected);
                    tv_sbzh.setText("1");
                    break;
                case R.id.dxk2:
                    bt2.setBackgroundResource(R.drawable.dxk_selected);
                    tv_sbzh.setText("2");
                    break;
                case R.id.dxk3:
                    bt3.setBackgroundResource(R.drawable.dxk_selected);
                    tv_sbzh.setText("3");
                    break;
                case R.id.dxk4:
                    bt4.setBackgroundResource(R.drawable.dxk_selected);
                    tv_sbzh.setText("4");
                    break;
                case R.id.dxk5:
                    bt5.setBackgroundResource(R.drawable.dxk_selected);
                    tv_sbzh.setText("5");
                    break;
                case R.id.dxk6:
                    bt6.setBackgroundResource(R.drawable.dxk_selected);
                    tv_sbzh.setText("6");
                    break;
                case R.id.dxk7:
                    bt7.setBackgroundResource(R.drawable.dxk_selected);
                    tv_sbzh.setText("7");
                    break;
                case R.id.dxk8:
                    bt8.setBackgroundResource(R.drawable.dxk_selected);
                    tv_sbzh.setText("8");
                    break;
            }
        }
    };
    private View.OnClickListener listener1=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            resetBg();
            initLayout();
            switch (v.getId()) {
                case R.id.button1:
                    ll1.setBackgroundColor(getResources().getColor(R.color.bg_selected));
                    ll1_set.setVisibility(View.VISIBLE);
                    tv1.setTextColor(Color.WHITE);
                    cb_sbzh.setChecked(false);
                    break;
                case R.id.button2:
                    tv2.setTextColor(Color.WHITE);
                    ll2.setBackgroundColor(getResources().getColor(R.color.bg_selected));
                    ll2_set.setVisibility(View.VISIBLE);
                    break;
            }
        }
    };
    private View.OnClickListener listener4=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.button3:
                    Intent it=new Intent(getContext(),TakeupActivity.class);
                    startActivity(it);
                    cb_sbzh.setChecked(false);
                    break;
                case R.id.button4:
                    Intent it2=new Intent(getContext(),ControlFootActivity.class);
                    startActivity(it2);
                    cb_sbzh.setChecked(false);
                    break;
                case R.id.button5:
                    Intent it3=new Intent(getContext(),XuanjiaActivity.class);
                    startActivity(it3);
                    cb_sbzh.setChecked(false);
                    break;

            }
        }
    };
    private View.OnClickListener listener5=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            InputMethodManager imm = (InputMethodManager)
                    getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
        }
    };
    private View.OnClickListener listener6=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            AlertDialog.Builder builder=new AlertDialog.Builder(getContext());
            View view=getLayoutInflater(null).inflate(R.layout.layout_diadog3,null);
            TextView tv= (TextView) view.findViewById(R.id.tv_content);
            Button bt1=(Button)view.findViewById(R.id.bt1);
            Button bt2=(Button)view.findViewById(R.id.bt2);
            bt1.setOnClickListener(listener);
            bt2.setOnClickListener(listener);
            String str="工况类型：";
            str+=rb[0]+"\n";
            str+="副臂长度："+rb[1]+"\n";
            str+="副臂角度："+rb[2]+"\n";
            str+="平衡重："+rb[3]+"\n";
            str+="支腿："+rb[4]+"\n";
            str+="倍率："+et_beilv.getText().toString()+"\n";
            str+="伸臂组合："+tv_sbzh.getText().toString();
            tv.setText(str);
            builder.setView(view);
            builder.create();
            diadog=builder.show();
            window=diadog.getWindow();
            window.setGravity(Gravity.RIGHT);
            params=window.getAttributes();
            params.x=100;
            params.y=0;
            params.width=700;
            window.setAttributes(params);
            cb_sbzh.setChecked(false);
        }
    };
    private View.OnClickListener listener7=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            AlertDialog.Builder builder=new AlertDialog.Builder(getContext());
            View view=getLayoutInflater(null).inflate(R.layout.layout_diadog3,null);
            TextView tv1= (TextView) view.findViewById(R.id.tv_head);
            TextView tv2= (TextView) view.findViewById(R.id.tv_content);
            Button bt1=(Button)view.findViewById(R.id.bt1);
            Button bt2=(Button)view.findViewById(R.id.bt2);
            bt1.setOnClickListener(listener);
            bt2.setOnClickListener(listener);
            tv1.setText("提示");
            tv2.setText("确认选择此工况？");
            builder.setView(view);
            builder.create();
            diadog=builder.show();
            window=diadog.getWindow();
            window.setGravity(Gravity.RIGHT);
            params=window.getAttributes();
            params.x=100;
            params.y=0;
            params.width=700;
            window.setAttributes(params);
        }
    };
    private View.OnClickListener listener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            diadog.dismiss();
        }
    };
    private CompoundButton.OnCheckedChangeListener onCheckedChangeListener=new
            CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    switch (buttonView.getId()){
                        case R.id.cb_sbzh:
                            if (isChecked)
                               gl_sbzh.setVisibility(View.VISIBLE);
                            else
                                gl_sbzh.setVisibility(View.GONE);
                            break;
                    }
                }
            };
    private void initLayout() {
        ll1_set.setVisibility(View.GONE);
        ll2_set.setVisibility(View.GONE);
    }
    private void resetBg() {
        ll1.setBackgroundResource(R.color.bg_list);
        ll2.setBackgroundResource(R.color.bg_list);
        tv1.setTextColor(getResources().getColor(R.color.tv_color));
        tv2.setTextColor(getResources().getColor(R.color.tv_color));
    }
}
