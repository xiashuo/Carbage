package crane.lthd.com.crane;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.inputmethodservice.Keyboard;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import crane.lthd.com.crane.adapter.MySimpleAdapter;
public class ManagerFragment extends Fragment {
    private String date="";
    private Spinner sp;
    private Spinner sp2;
    private Spinner sp3;
    private Spinner sp4;
    private Spinner sp5;
    private Spinner sp6;
    private boolean flag1=false;
    private LinearLayout ll_left;
    private RelativeLayout rl_right;
    private LinearLayout ll_pop;
    private View view;
    private View view_flag;
    private LinearLayout ll1;
    private LinearLayout ll2;
    private LinearLayout ll3;
    private LinearLayout ll4;
    private LinearLayout ll5;
    private LinearLayout ll6;
    private LinearLayout ll7;
    private LinearLayout ll8;
    private LinearLayout ll_cssz;
    private LinearLayout ll_czsz;
    private LinearLayout ll_wlsz;
    private LinearLayout ll_drgjsj;
    private LinearLayout ll_gjcxsz;
    private LinearLayout ll_lsgk;
    private LinearLayout ll_cscz;
    private LinearLayout ll_back;
    private RelativeLayout rl_sjdzl;
    private RelativeLayout rl_yxzysj;
    private RelativeLayout rl_zyzsj;
    private RelativeLayout rl_ryxhl;
    private TextView tv1;
    private TextView tv2;
    private TextView tv3;
    private TextView tv4;
    private TextView tv5;
    private TextView tv6;
    private TextView tv7;
    private TextView tv8;
    private TextView tv_vin;
    private TextView tv_xinghao;
    private TextView tv_time;
    private TextView tv_location;
    private TextView tv_state;
    private TextView tv_num;
    private TextView tv_car;
    private EditText et_s;
    private EditText et_e;
    private EditText et_s2;
    private EditText et_e2;
    private EditText et_s3;
    private EditText et_e3;
    private EditText et_wlbj;
    private ImageButton ib_set;
    private LinearLayout ll1_set;
    private RelativeLayout ll2_set;
    private LinearLayout ll3_set;
    private LinearLayout ll4_set;
    private RelativeLayout ll5_set;
    private LinearLayout ll6_set;
    private LinearLayout ll7_set;
    private LinearLayout ll8_set;
    private LinearLayout ll_calendar;
    private LinearLayout ll_gkdm1;
    private LinearLayout ll_gkdm2;
    private ListView lv;
    private Switch switch1;
    private Switch switch2;
    private Switch switch3;
    private Switch switch4;
    private Switch switch5;
    private Switch switch6;
    private Switch switch7;
    private Switch switch8;
    private Switch switch9;
    private CheckBox cb1;
    private CheckBox cb2;
    private CheckBox cb3;
    private CheckBox cb4;
    private CheckBox cb5;
    private CheckBox cb_gkdm1;
    private CheckBox cb_gkdm2;
    private ImageView iv;
    private ImageButton ib1;
    private ImageButton ib2;
    private ImageButton ib3;
    private ImageButton ib4;
    private ImageButton ib5;
    private ImageButton ib6;
    private ImageButton ib7;
    private ImageButton ib_delete;
    List<Map<String,Object>> list1;
    private SimpleAdapter adapter;
    private String text1[]={"XCT80","QY12","QY8B.5","QAY300A"};
    private String text2[]={"LXGCPA507FA005192","LXGBCA163FA005157","LGHWAD1H3F6105512"
            ,"LXGEPA723FA003706"};
    private String text3[]={"苏CAF600","苏CAF601","苏CAF602"
            ,"苏CAF603"};
    private AdapterView.OnItemLongClickListener lv_listener=new AdapterView.OnItemLongClickListener() {
        @Override
        public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
            final ImageButton ib_delete=(ImageButton)view.findViewById(R.id.ib_delete);
            ib_delete.setVisibility(View.VISIBLE);
            ib_delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    list1.remove(position);
                    adapter.notifyDataSetChanged();
                    ib_delete.setVisibility(View.GONE);
                }
            });
            return false;
        }
    };
    private PopupWindow pw;
    private Window window;
    private WindowManager.LayoutParams params;
    Handler mhandler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            if (msg.what==100){
                ll_drgjsj.setVisibility(View.GONE);
            }
        }
    };
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view=inflater.inflate(R.layout.fragment_manager, container, false);
        initView(view, inflater);
        initEvent();
        initListView(text1, text2, text3);
        return view;
    }

    private void initListView(String[] text1, String[] text2, String[] text3) {
        list1=new ArrayList<>();
        for (int i=0;i<text1.length;i++){
            Map<String,Object> map=new HashMap<>();
            map.put("text1",text1[i]);
            map.put("text2",text2[i]);
            map.put("text3",text3[i]);
            list1.add(map);
        }
        adapter=new SimpleAdapter(getContext(),list1,R.layout.item_cldj,new String[]
                {"text1","text2","text3"},new int[]{R.id.tv1, R.id.tv2, R.id.tv3});
        lv.setAdapter(adapter);
    }
    private void initEvent() {
        et_s.setOnClickListener(listener4);
        et_e.setOnClickListener(listener4);
        et_s2.setOnClickListener(listener4);
        et_e2.setOnClickListener(listener4);
        et_s3.setOnClickListener(listener4);
        et_e3.setOnClickListener(listener4);
        ll1.setOnClickListener(listener1);
        ll2.setOnClickListener(listener1);
        ll3.setOnClickListener(listener1);
        ll4.setOnClickListener(listener1);
        ll5.setOnClickListener(listener1);
        ll6.setOnClickListener(listener1);
        ll7.setOnClickListener(listener1);
        ll8.setOnClickListener(listener1);
        ib_set.setOnClickListener(listener2);
        ll_left.setOnClickListener(listener2);
        rl_right.setOnClickListener(listener2);
        ib_delete.setOnClickListener(listener2);
        ll_back.setOnClickListener(listener2);
        lv.setOnItemLongClickListener(lv_listener);
        switch1.setOnCheckedChangeListener(onCheckedChangeListener);
        switch2.setOnCheckedChangeListener(onCheckedChangeListener);
        switch3.setOnCheckedChangeListener(onCheckedChangeListener);
        switch4.setOnCheckedChangeListener(onCheckedChangeListener);
        switch5.setOnCheckedChangeListener(onCheckedChangeListener);
        switch6.setOnCheckedChangeListener(onCheckedChangeListener);
        switch7.setOnCheckedChangeListener(onCheckedChangeListener);
        switch8.setOnCheckedChangeListener(onCheckedChangeListener);
        switch9.setOnCheckedChangeListener(onCheckedChangeListener);
        cb1.setOnCheckedChangeListener(onCheckedChangeListener);
        cb2.setOnCheckedChangeListener(onCheckedChangeListener);
        cb3.setOnCheckedChangeListener(onCheckedChangeListener);
        cb4.setOnCheckedChangeListener(onCheckedChangeListener);
        cb5.setOnCheckedChangeListener(onCheckedChangeListener);
        cb_gkdm1.setOnCheckedChangeListener(onCheckedChangeListener);
        cb_gkdm2.setOnCheckedChangeListener(onCheckedChangeListener);
        ib1.setOnClickListener(listener3);
        ib2.setOnClickListener(listener3);
        ib3.setOnClickListener(listener3);
        ib4.setOnClickListener(listener3);
        ib5.setOnClickListener(listener3);
        ib6.setOnClickListener(listener3);
        ib7.setOnClickListener(listener3);
        sp6.setOnItemSelectedListener(sp_listener);
        et_wlbj.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                flag1 = true;
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }
    private void initView(View view, LayoutInflater inflater) {
        window=getActivity().getWindow();
        params=window.getAttributes();
        sp=(Spinner)view.findViewById(R.id.sp);
        sp2=(Spinner)view.findViewById(R.id.sp2);
        sp3=(Spinner)view.findViewById(R.id.sp3);
        sp4=(Spinner)view.findViewById(R.id.sp4);
        sp5=(Spinner)view.findViewById(R.id.sp5);
        sp6=(Spinner)view.findViewById(R.id.sp6);
        initSpinner();
        ArrayAdapter adapter=ArrayAdapter.createFromResource(getContext(),R.array.data_car,
                android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(R.layout.item_spinner);
        sp.setAdapter(adapter);
        ll_pop= (LinearLayout) view.findViewById(R.id.ll_pop);
        ll_left= (LinearLayout) view.findViewById(R.id.ll_left);
        rl_right= (RelativeLayout) view.findViewById(R.id.rl_right);
        lv= (ListView) view.findViewById(R.id.lv_cldj);
        ll1= (LinearLayout) view.findViewById(R.id.button1);
        ll2= (LinearLayout) view.findViewById(R.id.button2);
        ll3= (LinearLayout) view.findViewById(R.id.button3);
        ll4= (LinearLayout) view.findViewById(R.id.button4);
        ll5= (LinearLayout) view.findViewById(R.id.button5);
        ll6= (LinearLayout) view.findViewById(R.id.button6);
        ll7= (LinearLayout) view.findViewById(R.id.button7);
        ll8= (LinearLayout) view.findViewById(R.id.button8);
        ll_back= (LinearLayout) view.findViewById(R.id.ll_back);
        ll_cssz= (LinearLayout) view.findViewById(R.id.ll_cssz);
        ll_czsz= (LinearLayout) view.findViewById(R.id.ll_czsz);
        ll_wlsz= (LinearLayout) view.findViewById(R.id.ll_wlsz);
        ll_drgjsj= (LinearLayout) view.findViewById(R.id.ll1);
        ll_gjcxsz= (LinearLayout) view.findViewById(R.id.ll_gjcxsz);
        ll_lsgk= (LinearLayout) view.findViewById(R.id.ll_lsgkcx);
        ll_cscz= (LinearLayout) view.findViewById(R.id.ll_csczcx);
        ll_gkdm1= (LinearLayout) view.findViewById(R.id.ll_gkdm1);
        ll_gkdm2= (LinearLayout) view.findViewById(R.id.ll_gkdm2);
        rl_sjdzl= (RelativeLayout) view.findViewById(R.id.rl_sjdzl);
        rl_yxzysj= (RelativeLayout) view.findViewById(R.id.rl_yxzysj);
        rl_zyzsj= (RelativeLayout) view.findViewById(R.id.rl_zyzsj);
        rl_ryxhl= (RelativeLayout) view.findViewById(R.id.rl_ryxhl);
        tv1=(TextView)view.findViewById(R.id.tv1);
        tv2=(TextView)view.findViewById(R.id.tv2);
        tv3=(TextView)view.findViewById(R.id.tv3);
        tv4=(TextView)view.findViewById(R.id.tv4);
        tv5=(TextView)view.findViewById(R.id.tv5);
        tv6=(TextView)view.findViewById(R.id.tv6);
        tv7=(TextView)view.findViewById(R.id.tv7);
        tv8=(TextView)view.findViewById(R.id.tv8);
        tv_vin=(TextView)view.findViewById(R.id.tv_VIN);
        tv_xinghao=(TextView)view.findViewById(R.id.tv_xinghao);
        tv_time=(TextView)view.findViewById(R.id.tv_time);
        tv_location=(TextView)view.findViewById(R.id.tv_location);
        tv_state=(TextView)view.findViewById(R.id.tv_state);
        tv_num=(TextView)view.findViewById(R.id.tv_num);
        tv_car= (TextView) view.findViewById(R.id.tv_car);
        ib_set= (ImageButton) view.findViewById(R.id.ib_set);
        ll1_set= (LinearLayout) view.findViewById(R.id.ll1_set);
        ll2_set= (RelativeLayout) view.findViewById(R.id.ll2_set);
        ll3_set= (LinearLayout) view.findViewById(R.id.ll3_set);
        ll4_set= (LinearLayout) view.findViewById(R.id.ll4_set);
        ll5_set= (RelativeLayout) view.findViewById(R.id.ll5_set);
        ll6_set= (LinearLayout) view.findViewById(R.id.ll6_set);
        ll7_set= (LinearLayout) view.findViewById(R.id.ll7_set);
        ll8_set= (LinearLayout) view.findViewById(R.id.ll8_set);
        ll_calendar= (LinearLayout) view.findViewById(R.id.calendar);
        switch1= (Switch) view.findViewById(R.id.switch1);
        switch2= (Switch) view.findViewById(R.id.switch2);
        switch3= (Switch) view.findViewById(R.id.switch3);
        switch4= (Switch) view.findViewById(R.id.switch4);
        switch5= (Switch) view.findViewById(R.id.switch5);
        switch6= (Switch) view.findViewById(R.id.switch_sjdzl);
        switch7= (Switch) view.findViewById(R.id.switch_yxzysj);
        switch8= (Switch) view.findViewById(R.id.switch_zyzsj);
        switch9= (Switch) view.findViewById(R.id.switch_ryxhl);
        cb1= (CheckBox) view.findViewById(R.id.cb1);
        cb2= (CheckBox) view.findViewById(R.id.cb2);
        cb3= (CheckBox) view.findViewById(R.id.cb3);
        cb4= (CheckBox) view.findViewById(R.id.cb4);
        cb5= (CheckBox) view.findViewById(R.id.cb5);
        cb_gkdm1= (CheckBox) view.findViewById(R.id.cb_gkdm1);
        cb_gkdm2= (CheckBox) view.findViewById(R.id.cb_gkdm2);
        et_s=(EditText)view.findViewById(R.id.et_s);
        et_e=(EditText)view.findViewById(R.id.et_e);
        et_s2=(EditText)view.findViewById(R.id.et_s2);
        et_e2=(EditText)view.findViewById(R.id.et_e2);
        et_s3=(EditText)view.findViewById(R.id.et_s3);
        et_e3=(EditText)view.findViewById(R.id.et_e3);
        et_wlbj= (EditText) view.findViewById(R.id.et_wlbj);
        iv= (ImageView) view.findViewById(R.id.iv_map);
        ib1= (ImageButton) view.findViewById(R.id.button25);
        ib2= (ImageButton) view.findViewById(R.id.button26);
        ib3= (ImageButton) view.findViewById(R.id.button31);
        ib4= (ImageButton) view.findViewById(R.id.button32);
        ib5= (ImageButton) view.findViewById(R.id.button33);
        ib6= (ImageButton) view.findViewById(R.id.button34);
        ib7= (ImageButton) view.findViewById(R.id.button35);
        ib_delete= (ImageButton) view.findViewById(R.id.ib_delete);
    }
    private void initSpinner() {
        ArrayAdapter adapter=ArrayAdapter.createFromResource(getContext(),R.array.data_car,
                android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(R.layout.item_spinner);
        sp.setAdapter(adapter);
        sp2.setAdapter(adapter);
        sp3.setAdapter(adapter);
        sp4.setAdapter(adapter);
        sp5.setAdapter(adapter);
        sp6.setAdapter(adapter);
    }
    private AdapterView.OnItemSelectedListener sp_listener=new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            switch (position){
                case 0:
                    tv_car.setText("FA000001");
                    break;
                case 1:
                    tv_car.setText("FA000002");
                    break;
                case 2:
                    tv_car.setText("FA000003");
                    break;
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    };
    private View.OnClickListener listener1=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (flag1&&v!=view_flag){
                showDiadog(v);
                flag1=false;
            }
            else {
                setLayout(v);
            }
            view_flag=v;
        }
    };
    public void setLayout(View v){
        resetBg();
        initLayout();
        switch (v.getId()) {
            case R.id.button1:
                ll1.setBackgroundColor(getResources().getColor(R.color.bg_selected));
                ll1_set.setVisibility(View.VISIBLE);
                tv1.setTextColor(Color.WHITE);
                break;
            case R.id.button2:
                tv2.setTextColor(Color.WHITE);
                ll2.setBackgroundColor(getResources().getColor(R.color.bg_selected));
                ll2_set.setVisibility(View.VISIBLE);
                break;
            case R.id.button3:
                ll3.setBackgroundColor(getResources().getColor(R.color.bg_selected));
                tv3.setTextColor(Color.WHITE);
                ll3_set.setVisibility(View.VISIBLE);
                break;
            case R.id.button4:
                tv4.setTextColor(Color.WHITE);
                ll4.setBackgroundColor(getResources().getColor(R.color.bg_selected));
                ll4_set.setVisibility(View.VISIBLE);
                break;
            case R.id.button5:
                tv5.setTextColor(Color.WHITE);
                ll5.setBackgroundColor(getResources().getColor(R.color.bg_selected));
                ll5_set.setVisibility(View.VISIBLE);
                ll1.setVisibility(View.VISIBLE);
                mhandler.sendEmptyMessageDelayed(100,3000);
                break;
            case R.id.button6:
                tv6.setTextColor(Color.WHITE);
                ll6.setBackgroundColor(getResources().getColor(R.color.bg_selected));
                ll6_set.setVisibility(View.VISIBLE);
                break;
            case R.id.button7:
                tv7.setTextColor(Color.WHITE);
                ll7.setBackgroundColor(getResources().getColor(R.color.bg_selected));
                ll7_set.setVisibility(View.VISIBLE);
                break;
            case R.id.button8:
                tv8.setTextColor(Color.WHITE);
                ll8.setBackgroundColor(getResources().getColor(R.color.bg_selected));
                ll8_set.setVisibility(View.VISIBLE);
                break;
        }
    }
    public void showDiadog(final View view1) {
        final AlertDialog.Builder builder= new AlertDialog.Builder(getContext());
        View view=getLayoutInflater(null).inflate(R.layout.layout_diadog2,null);
        final Button bt1= (Button) view.findViewById(R.id.bt1);
        Button bt2= (Button) view.findViewById(R.id.bt2);
        builder.setView(view);
        builder.create();
        final AlertDialog dialog=builder.show();
        Window window=dialog.getWindow();
        window.setGravity(Gravity.RIGHT);
        WindowManager.LayoutParams lp=window.getAttributes();
        lp.x=100;
        lp.y=0;
        lp.width=700;
        window.setAttributes(lp);
        View.OnClickListener listener=new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                setLayout(view1);
            }
        };
        bt1.setOnClickListener(listener);
        bt2.setOnClickListener(listener);
    }
    private View.OnClickListener listener2=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.ib_set:
                    ll5_set.setVisibility(View.GONE);
                    ll_gjcxsz.setVisibility(View.VISIBLE);
                    break;
                case R.id.ll_back:
                    ll5_set.setVisibility(View.VISIBLE);
                    ll_gjcxsz.setVisibility(View.GONE);
                    break;
                case R.id.ll_left:
                    lv.setAdapter(adapter);
                    ll_pop.setVisibility(View.GONE);
                    resetIb();
                    break;
                case R.id.rl_right:
                    lv.setAdapter(adapter);
                    ll_pop.setVisibility(View.GONE);
                    resetIb();
                    break;
                case R.id.ib_delete:
                    ll_pop.setVisibility(View.GONE);
                    resetIb();
                    break;
            }
        }
    };
    private View.OnClickListener listener3=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            resetIb();
            switch (v.getId()){
                case R.id.button25:
                    ib1.setBackgroundResource(R.drawable.clan_click);
                    ll_pop.setVisibility(View.VISIBLE);
                    break;
                case R.id.button26:
                    ib2.setBackgroundResource(R.drawable.clan_click);
                    ll_pop.setVisibility(View.VISIBLE);
                    tv_vin.setText("\tLFDSFD3J4C2341234");
                    tv_xinghao.setText("\tQY8B.6");
                    tv_num.setText("\t234324456");
                    break;
                case R.id.button31:
                    ib3.setBackgroundResource(R.drawable.clan_click);
                    ll_pop.setVisibility(View.VISIBLE);
                    tv_vin.setText("\tLFghjD3J4C2456734");
                    tv_xinghao.setText("\tQY8B.7");
                    tv_num.setText("\t234456756");
                    break;
                case R.id.button32:
                    ib4.setBackgroundResource(R.drawable.clan_click);
                    ll_pop.setVisibility(View.VISIBLE);
                    tv_vin.setText("\tLJHFFD3J4C2387544");
                    tv_xinghao.setText("\tQY8B.8");
                    tv_num.setText("\t231235656");
                    break;
                case R.id.button33:
                    ib5.setBackgroundResource(R.drawable.clan_click);
                    ll_pop.setVisibility(View.VISIBLE);
                    tv_vin.setText("\tLFDJLK3J4C2398754");
                    tv_xinghao.setText("\tQY8B.9");
                    tv_num.setText("\t226789456");
                    break;
                case R.id.button34:
                    ib6.setBackgroundResource(R.drawable.clan_click);
                    ll_pop.setVisibility(View.VISIBLE);
                    tv_vin.setText("\tLFD34JL56C2341234");
                    tv_xinghao.setText("\tQY9B.6");
                    tv_num.setText("\t229876456");
                    break;
                case R.id.button35:
                    ib7.setBackgroundResource(R.drawable.clan_click);
                    ll_pop.setVisibility(View.VISIBLE);
                    tv_vin.setText("\tLFDSF9FJD82341234");
                    tv_xinghao.setText("\tQY9B.7");
                    tv_num.setText("\t234328764");
                    break;
            }

        }
    };
    private View.OnClickListener listener4=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.et_s:
                    showPopCalendar1(et_s);
                    break;
                case R.id.et_e:
                    showPopCalendar2(et_e);
                    break;
                case R.id.et_s2:
                    showPopCalendar1(et_s2);
                    break;
                case R.id.et_e2:
                    showPopCalendar2(et_e2);
                    break;
                case R.id.et_s3:
                    showPopCalendar1(et_s3);
                    break;
                case R.id.et_e3:
                    showPopCalendar2(et_e3);
                    break;
            }
        }
    };
    private CompoundButton.OnCheckedChangeListener onCheckedChangeListener=new
            CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    switch (buttonView.getId()){
                        case R.id.switch1:
                            flag1=true;
                            if (isChecked){
                                ll_cssz.setVisibility(View.VISIBLE);
                            }
                            else
                                ll_cssz.setVisibility(View.GONE);
                            break;
                        case R.id.switch2:
                            flag1=true;
                            if (isChecked){
                                ll_czsz.setVisibility(View.VISIBLE);
                            }
                            else
                                ll_czsz.setVisibility(View.GONE);
                            break;
                        case R.id.switch3:
                            flag1=true;
                            if (isChecked)
                                ll_wlsz.setVisibility(View.VISIBLE);
                            else
                                ll_wlsz.setVisibility(View.GONE);
                            break;
                        case R.id.switch4:
                            if (isChecked)
                                ll_lsgk.setVisibility(View.VISIBLE);
                            else
                                ll_lsgk.setVisibility(View.GONE);
                            break;
                        case R.id.switch5:
                            if (isChecked)
                                ll_cscz.setVisibility(View.VISIBLE);
                            else
                                ll_cscz.setVisibility(View.GONE);
                            break;
                        case R.id.switch_ryxhl:
                            if (isChecked)
                                rl_ryxhl.setVisibility(View.VISIBLE);
                            else
                                rl_ryxhl.setVisibility(View.GONE);
                            break;
                        case R.id.switch_sjdzl:
                            if (isChecked)
                                rl_sjdzl.setVisibility(View.VISIBLE);
                            else
                                rl_sjdzl.setVisibility(View.GONE);
                            break;
                        case R.id.switch_yxzysj:
                            if (isChecked)
                                rl_yxzysj.setVisibility(View.VISIBLE);
                            else
                                rl_yxzysj.setVisibility(View.GONE);
                            break;
                        case R.id.switch_zyzsj:
                            if (isChecked)
                                rl_zyzsj.setVisibility(View.VISIBLE);
                            else
                                rl_zyzsj.setVisibility(View.GONE);
                            break;
                        case R.id.cb1:
                            flag1=true;
                            break;
                        case R.id.cb2:
                            flag1=true;
                            break;
                        case R.id.cb3:
                            flag1=true;
                            break;
                        case R.id.cb4:
                            flag1=true;
                            break;
                        case R.id.cb5:
                            flag1=true;
                            break;
                        case R.id.cb_gkdm1:
                            if (isChecked)
                                ll_gkdm1.setVisibility(View.VISIBLE);
                            else
                                ll_gkdm1.setVisibility(View.GONE);
                            break;
                        case R.id.cb_gkdm2:
                            if (isChecked)
                                ll_gkdm2.setVisibility(View.VISIBLE);
                            else
                                ll_gkdm2.setVisibility(View.GONE);
                            break;
                    }
                }
            };
    public void resetIb() {
        ib1.setBackgroundResource(R.drawable.clan);
        ib2.setBackgroundResource(R.drawable.clan);
        ib3.setBackgroundResource(R.drawable.clan);
        ib4.setBackgroundResource(R.drawable.clan);
        ib5.setBackgroundResource(R.drawable.clan);
        ib6.setBackgroundResource(R.drawable.clan);
        ib7.setBackgroundResource(R.drawable.clan);
    }
    public void showPopCalendar1(final EditText et){
        View v=getLayoutInflater(null).inflate(R.layout.pop_calendar,null);
        final CalendarView calendarView= (CalendarView) v.findViewById(R.id.calendar);
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                int m = month + 1;
                date = year + "/" +normalNumber(m) + "/" + normalNumber(dayOfMonth);
            }
        });
        Button bt1= (Button) v.findViewById(R.id.bt1);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pw.dismiss();
                et.setText(date);
            }
        });
        pw = new PopupWindow(v, ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT, true);
        pw.setAnimationStyle(R.anim.anim_pop);
        pw.setBackgroundDrawable(new BitmapDrawable());
        pw.showAtLocation(view.findViewById(R.id.et_s), Gravity.TOP | Gravity.RIGHT, 290, 420);
    }
    public String normalNumber(int m){
        if (m<10)
            return "0"+m;
        else
            return ""+m;
    }
    public void showPopCalendar2(final EditText et){
        View v=getLayoutInflater(null).inflate(R.layout.pop_calendar,null);
        final CalendarView calendarView= (CalendarView) v.findViewById(R.id.calendar);
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                int m = month + 1;
                date = year + "/" + normalNumber(m) + "/" + normalNumber(dayOfMonth);
            }
        });
        Button bt1= (Button) v.findViewById(R.id.bt1);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((et==et_e&&et_s.getText().toString().compareTo(date)>0)||
                        (et==et_e2&&et_s2.getText().toString().compareTo(date)>0)
                        ||(et==et_e&&et_s.getText().toString().compareTo(date)>0)) {
                    Toast.makeText(getContext(), "结束时间不能小于起始时间！", Toast.LENGTH_SHORT).show();
                }
                else{
                    et.setText(date);
                    pw.dismiss();
                }
            }
        });
        pw = new PopupWindow(v, ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT, true);
        pw.setAnimationStyle(R.anim.anim_pop);
        pw.setBackgroundDrawable(new BitmapDrawable());
        pw.showAtLocation(view.findViewById(R.id.et_s), Gravity.TOP | Gravity.RIGHT, 60, 420);
    }
    private void initLayout() {
        ll1_set.setVisibility(View.GONE);
        ll2_set.setVisibility(View.GONE);
        ll3_set.setVisibility(View.GONE);
        ll4_set.setVisibility(View.GONE);
        ll5_set.setVisibility(View.GONE);
        ll6_set.setVisibility(View.GONE);
        ll7_set.setVisibility(View.GONE);
        ll8_set.setVisibility(View.GONE);
        ll_gjcxsz.setVisibility(View.GONE);
    }
    private void resetBg() {
        ll1.setBackgroundResource(R.color.bg_list);
        ll2.setBackgroundResource(R.color.bg_list);
        ll3.setBackgroundResource(R.color.bg_list);
        ll4.setBackgroundResource(R.color.bg_list);
        ll5.setBackgroundResource(R.color.bg_list);
        ll6.setBackgroundResource(R.color.bg_list);
        ll7.setBackgroundResource(R.color.bg_list);
        ll8.setBackgroundResource(R.drawable.border_top_down);
        tv1.setTextColor(getResources().getColor(R.color.tv_color));
        tv2.setTextColor(getResources().getColor(R.color.tv_color));
        tv3.setTextColor(getResources().getColor(R.color.tv_color));
        tv4.setTextColor(getResources().getColor(R.color.tv_color));
        tv5.setTextColor(getResources().getColor(R.color.tv_color));
        tv6.setTextColor(getResources().getColor(R.color.tv_color));
        tv7.setTextColor(getResources().getColor(R.color.tv_color));
        tv8.setTextColor(getResources().getColor(R.color.tv_color));
    }
}
