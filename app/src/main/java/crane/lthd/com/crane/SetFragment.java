package crane.lthd.com.crane;


import android.app.Activity;
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
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import crane.lthd.com.crane.adapter.MySimpleAdapter;

public class SetFragment extends Fragment {
    private CheckBox cb_chinese;
    private CheckBox cb_english;
    private SeekBar skb1;
    private SeekBar skb2;
    private SeekBar skb3;
    private SeekBar skb4;
    private SeekBar skb5;
    private SeekBar skb6;
    private TextView tv_sb1;
    private TextView tv_sb2;
    private TextView tv_sb3;
    private TextView tv_sb4;
    private TextView tv_sb5;
    private TextView tv_sb6;
    private View view;
    private LinearLayout button1;
    private LinearLayout button2;
    private LinearLayout button3;
    private RelativeLayout button4;
    private RelativeLayout button5;
    private LinearLayout ll1_set;
    private LinearLayout ll2_set;
    private LinearLayout ll3_set;
    private LinearLayout ll4_set;
    private RelativeLayout ll5_set;
    private RelativeLayout rl_yjsz;
    private RelativeLayout rl_gps;
    private RelativeLayout rl_csxg;
    private RelativeLayout rl_cxsj;
    private RelativeLayout rl_hxzgl;
    private RelativeLayout rl_gnjs;
    private RelativeLayout rl_help;
    private RelativeLayout rl_jcxbb;
    private TextView tv1;
    private TextView tv2;
    private TextView tv3;
    private TextView tv4;
    private TextView tv5;
    private PopupWindow pw;
    private Window window;
    private WindowManager.LayoutParams params;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_set, container, false);
        initView(view, inflater);
        initEvent();
        return view;
    }
    private void initEvent() {
        button1.setOnClickListener(listener1);
        button2.setOnClickListener(listener1);
        button3.setOnClickListener(listener1);
        button4.setOnClickListener(listener1);
        button5.setOnClickListener(listener1);
        skb1.setOnSeekBarChangeListener(onSeekBarChangeListener);
        skb2.setOnSeekBarChangeListener(onSeekBarChangeListener);
        skb3.setOnSeekBarChangeListener(onSeekBarChangeListener);
        skb4.setOnSeekBarChangeListener(onSeekBarChangeListener);
        skb5.setOnSeekBarChangeListener(onSeekBarChangeListener);
        skb6.setOnSeekBarChangeListener(onSeekBarChangeListener);
        rl_yjsz.setOnClickListener(listener2);
        rl_gps.setOnClickListener(listener2);
        rl_csxg.setOnClickListener(listener2);
        rl_cxsj.setOnClickListener(listener2);
        rl_hxzgl.setOnClickListener(listener2);
        rl_gnjs.setOnClickListener(listener2);
        rl_help.setOnClickListener(listener2);
        rl_jcxbb.setOnClickListener(listener2);
        cb_chinese.setOnCheckedChangeListener(onCheckedChangeListener);
        cb_english.setOnCheckedChangeListener(onCheckedChangeListener);
    }
    private void initView(View view, LayoutInflater inflater) {
        window=getActivity().getWindow();
        params=window.getAttributes();
        button1= (LinearLayout) view.findViewById(R.id.button1);
        button2= (LinearLayout) view.findViewById(R.id.button2);
        button3= (LinearLayout) view.findViewById(R.id.button3);
        button4=(RelativeLayout)view.findViewById(R.id.button4);
        button5=(RelativeLayout)view.findViewById(R.id.button5);
        ll1_set=(LinearLayout)view.findViewById(R.id.ll1_set);
        ll2_set=(LinearLayout)view.findViewById(R.id.ll2_set);
        ll3_set=(LinearLayout)view.findViewById(R.id.ll3_set);
        ll4_set=(LinearLayout)view.findViewById(R.id.ll4_set);
        ll5_set=(RelativeLayout)view.findViewById(R.id.ll5_set);
        rl_yjsz=(RelativeLayout)view.findViewById(R.id.rl1);
        rl_gps=(RelativeLayout)view.findViewById(R.id.rl_set1);
        rl_csxg=(RelativeLayout)view.findViewById(R.id.rl_set2);
        rl_cxsj=(RelativeLayout)view.findViewById(R.id.rl_set3);
        rl_hxzgl=(RelativeLayout)view.findViewById(R.id.rl_set4);
        rl_gnjs=(RelativeLayout)view.findViewById(R.id.rl_gnjs);
        rl_help=(RelativeLayout)view.findViewById(R.id.rl_help);
        rl_jcxbb=(RelativeLayout)view.findViewById(R.id.rl_jcxbb);
        tv1=(TextView)view.findViewById(R.id.tv_znjs);
        tv2= (TextView) view.findViewById(R.id.tv_sdsz);
        tv3=(TextView)view.findViewById(R.id.tv_gcsz);
        tv4= (TextView) view.findViewById(R.id.tv_dyy);
        tv5= (TextView) view.findViewById(R.id.tv_gy);
        skb1= (SeekBar) view.findViewById(R.id.skb1);
        skb2= (SeekBar) view.findViewById(R.id.skb2);
        skb3= (SeekBar) view.findViewById(R.id.skb3);
        skb4= (SeekBar) view.findViewById(R.id.skb4);
        skb5= (SeekBar) view.findViewById(R.id.skb5);
        skb6= (SeekBar) view.findViewById(R.id.skb6);
        tv_sb1= (TextView) view.findViewById(R.id.tv_sb1);
        tv_sb2= (TextView) view.findViewById(R.id.tv_sb2);
        tv_sb3= (TextView) view.findViewById(R.id.tv_sb3);
        tv_sb4= (TextView) view.findViewById(R.id.tv_sb4);
        tv_sb5= (TextView) view.findViewById(R.id.tv_sb5);
        tv_sb6= (TextView) view.findViewById(R.id.tv_sb6);
        cb_chinese= (CheckBox) view.findViewById(R.id.cb_zw);
        cb_english= (CheckBox) view.findViewById(R.id.cb_yw);
    }
    private CompoundButton.OnCheckedChangeListener onCheckedChangeListener=new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            switch (buttonView.getId()){
                case R.id.cb_zw:
                    if (isChecked)
                        cb_english.setChecked(false);
                    break;
                case R.id.cb_yw:
                    if (isChecked)
                        cb_chinese.setChecked(false);
                    break;
            }
        }
    };
    private SeekBar.OnSeekBarChangeListener onSeekBarChangeListener=new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            switch (seekBar.getId()){
                case R.id.skb1:
                    tv_sb1.setText(progress+"%");
                    break;
                case R.id.skb2:
                    tv_sb2.setText(progress+"%");
                    break;
                case R.id.skb3:
                    tv_sb3.setText(progress+"%");
                    break;
                case R.id.skb4:
                    tv_sb4.setText(progress+"%");
                    break;
                case R.id.skb5:
                    tv_sb5.setText(progress+"%");
                    break;
                case R.id.skb6:
                    tv_sb6.setText(progress+"%");
                    break;
            }
        }
        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {
        }
        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
        }
    };
    private View.OnClickListener listener1=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            resetBg();
            initLayout();
            switch (v.getId()) {
                case R.id.button1:
                    button1.setBackgroundColor(getResources().getColor(R.color.bg_selected));
                    ll1_set.setVisibility(View.VISIBLE);
                    tv1.setTextColor(Color.WHITE);
                    break;
                case R.id.button2:
                    tv2.setTextColor(Color.WHITE);
                    button2.setBackgroundColor(getResources().getColor(R.color.bg_selected));
                    ll2_set.setVisibility(View.VISIBLE);
                    break;
                case R.id.button3:
                    button3.setBackgroundColor(getResources().getColor(R.color.bg_selected));
                    ll3_set.setVisibility(View.VISIBLE);
                    tv3.setTextColor(Color.WHITE);
                    break;
                case R.id.button4:
                    tv4.setTextColor(Color.WHITE);
                    button4.setBackgroundColor(getResources().getColor(R.color.bg_selected));
                    ll4_set.setVisibility(View.VISIBLE);
                    break;
                case R.id.button5:
                    tv5.setTextColor(Color.WHITE);
                    button5.setBackgroundColor(getResources().getColor(R.color.bg_selected));
                    ll5_set.setVisibility(View.VISIBLE);
                    break;
            }
        }
    };
    private View.OnClickListener listener2=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.rl_set1:
                    break;
                case R.id.rl_set2:
                    break;
                case R.id.rl_set3:
                    break;
                case R.id.rl_set4:
                    break;
                case R.id.rl1:
                    break;
                case R.id.rl_gnjs:
                    break;
                case R.id.rl_help:
                    break;
                case R.id.rl_jcxbb:
                    break;
            }
        }
    };
    private void resetBg() {
        button1.setBackgroundResource(R.color.bg_list);
        button2.setBackgroundResource(R.drawable.border_top_down);
        button3.setBackgroundResource(R.drawable.border_bottom);
        button4.setBackgroundResource(R.color.bg_list);
        button5.setBackgroundResource(R.color.bg_list);
        tv1.setTextColor(getResources().getColor(R.color.tv_color));
        tv2.setTextColor(getResources().getColor(R.color.tv_color));
        tv3.setTextColor(getResources().getColor(R.color.tv_color));
        tv4.setTextColor(getResources().getColor(R.color.tv_color));
        tv5.setTextColor(getResources().getColor(R.color.tv_color));
    }
    private void initLayout() {
        ll1_set.setVisibility(View.GONE);
        ll2_set.setVisibility(View.GONE);
        ll3_set.setVisibility(View.GONE);
        ll4_set.setVisibility(View.GONE);
        ll5_set.setVisibility(View.GONE);
    }
}
