package crane.lthd.com.crane;

import android.app.Activity;
import android.graphics.drawable.BitmapDrawable;
import android.inputmethodservice.KeyboardView;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
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
import android.widget.Button;
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

import crane.lthd.com.crane.adapter.MyPagerAdapter;
import crane.lthd.com.crane.adapter.SimpleAdapter_lv_warning;

import static java.lang.Math.abs;
import static java.lang.Math.log;
    public class TakeupActivity extends Activity {
        private ImageView iv1;
        private ImageView iv2;
        private ImageView iv3;
        private ImageView iv4;
        private ImageView iv5;
        private RelativeLayout rl_left;
        private RelativeLayout rl_right;
        private LinearLayout layout_takeup;
        private float X;
        private float Y;
        private YaoGanView yaogan1;
        private YaoGanView yaogan2;
        private ImageButton ib_quli;
        private ImageView iv_checking;
        private int flag2 = 0;
        private ImageView iv_left1;
        private ImageView iv_right1;
        private ImageView iv_up1;
        private ImageView iv_down1;
        private ImageView iv_left2;
        private ImageView iv_right2;
        private ImageView iv_up2;
        private ImageView iv_down2;
        private ImageView iv_fjj;
        private ImageView iv_fjs;
        private ViewPager vpager;
        private ArrayList<View> listViews;
        private TextView tv_left1;
        private TextView tv_right1;
        private TextView tv_top1;
        private TextView tv_bottom1;
        private TextView tv_left2;
        private TextView tv_right2;
        private TextView tv_top2;
        private TextView tv_bottom2;
        private TextView tv_error;
        private Button bt_one;
        private Button bt_two;
        private Button bt_three;
        private ImageButton ib_guzhang;
        private Window window;
        private WindowManager.LayoutParams params;
        private PopupWindow pw;
        private PopupWindow pw2;
        private RelativeLayout rl1;
        private ListView lv_warning;
        private List<Map<String,Object>> list;
        private Map<String,Object> map;
        private SimpleAdapter_lv_warning adapter_lv;
        private Data_Warning data;
        Handler mhandler=new Handler(){
            @Override
            public void handleMessage(Message msg) {
                switch (msg.what){
                    case 135:
                        iv_checking.setVisibility(View.GONE);
                        ib_quli.setBackgroundResource(R.drawable.quli_pressed);
                        break;
                    case 11:
                        iv1.setVisibility(View.GONE);
                        break;
                    case 12:
                        iv2.setVisibility(View.GONE);
                        break;
                    case 13:
                        iv3.setVisibility(View.GONE);
                        break;
                    case 14:
                        iv4.setVisibility(View.GONE);
                        break;
                    case 15:
                        iv5.setVisibility(View.GONE);
                        break;
                }
            }
        };
    private ViewPager.OnPageChangeListener pageChangeListener=new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            bt_one.setBackgroundResource(R.drawable.viewid);
            bt_two.setBackgroundResource(R.drawable.viewid);
            bt_three.setBackgroundResource(R.drawable.viewid);
            switch (position){
                case 0:
                    bt_one.setBackgroundResource(R.drawable.viewid2);
                    break;
                case 1:
                    bt_two.setBackgroundResource(R.drawable.viewid2);
                    break;
                case 2:
                    bt_three.setBackgroundResource(R.drawable.viewid2);
                    break;
            }
        }
        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_takeup);
        initView();
        initEvent();
    }
    private View.OnTouchListener onTouchListener=new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            if (pw!=null&&pw.isShowing()){
                pw.dismiss();
            }
            if (pw2!=null&&pw2.isShowing()){
                pw2.dismiss();
            }
            return false;
        }
    };
    private void initView() {
        data=new Data_Warning();
        ib_guzhang= (ImageButton) findViewById(R.id.ib_warning);
        window=getWindow();
        params=window.getAttributes();
        rl1=(RelativeLayout)findViewById(R.id.layout_pager);
        ib_quli = (ImageButton) findViewById(R.id.ib_quli);
        iv_checking= (ImageView) findViewById(R.id.iv_quli);
        rl_left = (RelativeLayout) findViewById(R.id.rl_hand_l);
        rl_right = (RelativeLayout) findViewById(R.id.rl_hand_r);
        yaogan1 = new YaoGanView(this, 270, 335);
        yaogan2 = new YaoGanView(this, 265, 335);
        X = yaogan1.SmallRockerCircleX;
        Y = yaogan1.SmallRockerCircleY;
        rl_left.addView(yaogan1);
        rl_right.addView(yaogan2);
        iv_left1 = (ImageView) findViewById(R.id.ig_left);
        iv_up1 = (ImageView) findViewById(R.id.ig_up);
        iv_right1 = (ImageView) findViewById(R.id.ig_right);
        iv_down1 = (ImageView) findViewById(R.id.ig_down);
        iv_left2 = (ImageView) findViewById(R.id.ig_left2);
        iv_up2 = (ImageView) findViewById(R.id.ig_up2);
        iv_right2 = (ImageView) findViewById(R.id.ig_right2);
        iv_down2 = (ImageView) findViewById(R.id.ig_down2);
        iv_fjj = (ImageView) findViewById(R.id.ig_fjj);
        iv_fjs = (ImageView) findViewById(R.id.ig_fjs);
        vpager = (ViewPager) findViewById(R.id.viewpager);
        listViews = new ArrayList<View>();
        LayoutInflater mInflater =this.getLayoutInflater();
        View view1=mInflater.inflate(R.layout.view1, null, false);
        listViews.add(view1);
        View view2=mInflater.inflate(R.layout.view2, null, false);
        listViews.add(view2);
        View view3=mInflater.inflate(R.layout.view3, null, false);
        listViews.add(view3);
        vpager.setAdapter(new MyPagerAdapter(listViews));
        vpager.setCurrentItem(1);
        tv_left1=(TextView)findViewById(R.id.tv_left1);
        tv_right1=(TextView)findViewById(R.id.tv_right1);
        tv_top1=(TextView)findViewById(R.id.tv_top1);
        tv_bottom1=(TextView)findViewById(R.id.tv_bottom1);
        tv_left2= (TextView) findViewById(R.id.tv_left2);
        tv_right2=(TextView)findViewById(R.id.tv_right2);
        tv_top2=(TextView)findViewById(R.id.tv_top2);
        tv_bottom2=(TextView)findViewById(R.id.tv_bottom2);
        bt_one=(Button)findViewById(R.id.bt_view1);
        bt_two=(Button)findViewById(R.id.bt_view2);
        bt_three=(Button)findViewById(R.id.bt_view3);
    }
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
    private void initEvent() {
        yaogan1.setOnTouchListener(touchlistener1);
        yaogan2.setOnTouchListener(touchlistener2);
        vpager.addOnPageChangeListener(pageChangeListener);
        vpager.setOnTouchListener(onTouchListener);
    }
    private View.OnTouchListener touchlistener1 = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            float x, y;
            x = event.getX() - 45;
            y = event.getY() - 45;
            if (event.getAction() == MotionEvent.ACTION_DOWN || event.getAction() == MotionEvent.ACTION_MOVE) {
                iv_left1.setBackgroundResource(R.drawable.sbjt);
                iv_up1.setBackgroundResource(R.drawable.sbjt2);
                iv_right1.setBackgroundResource(R.drawable.sbjt3);
                iv_down1.setBackgroundResource(R.drawable.sbjt4);
                int ratio=0;
                tv_left1.setVisibility(View.GONE);
                tv_right1.setVisibility(View.GONE);
                tv_top1.setVisibility(View.GONE);
                tv_bottom1.setVisibility(View.GONE);
                int flag=sureDirection(270, 335, x, y);
                switch (flag) {
                    case 1:
                        iv_left1.setBackgroundResource(R.drawable.sbjt_jihuo);
                        ratio=(int)((270-x)/1.8);
                        tv_left1.setVisibility(View.VISIBLE);
                        tv_left1.setText("" + ratio + "%");
                        break;
                    case 2:
                        iv_up1.setBackgroundResource(R.drawable.sbjt_jihuo2);
                        ratio=(int)((335-y)/1.8);
                        tv_top1.setVisibility(View.VISIBLE);
                        tv_top1.setText("" + ratio + "%");
                        break;
                    case 3:
                        iv_right1.setBackgroundResource(R.drawable.sbjt_jihuo3);
                        ratio=(int)((x-270)/1.8);
                        tv_right1.setVisibility(View.VISIBLE);
                        tv_right1.setText("" + ratio + "%");
                        break;
                    case 4:
                        iv_down1.setBackgroundResource(R.drawable.sbjt_jihuo4);
                        ratio=(int)((y-335)/1.8);
                        tv_bottom1.setVisibility(View.VISIBLE);
                        tv_bottom1.setText("" + ratio + "%");
                        break;
                }
                // 当触屏区域不在活动范围内
                if (Math.sqrt(Math.pow((270 - x), 2) + Math.pow((335 - y), 2)) >= 180) {
                    double rad=getRad(270,335,x,y);
                    x=getX(270,335,180,rad);
                    y=getY(270, 335, 180, rad);
                    tv_left1.setText("100%");
                    tv_top1.setText("100%");
                    tv_bottom1.setText("100%");
                    tv_right1.setText("100%");

                }
            }
            else if (event.getAction() == MotionEvent.ACTION_UP) {
                //当释放按键时摇杆要恢复摇杆的位置为初始位置
                x = 270;
                y = 335;
                iv_left1.setBackgroundResource(R.drawable.sbjt);
                iv_up1.setBackgroundResource(R.drawable.sbjt2);
                iv_right1.setBackgroundResource(R.drawable.sbjt3);
                iv_down1.setBackgroundResource(R.drawable.sbjt4);
                tv_left1.setVisibility(View.GONE);
                tv_right1.setVisibility(View.GONE);
                tv_top1.setVisibility(View.GONE);
                tv_bottom1.setVisibility(View.GONE);
                tv_left1.setText("0%");
                tv_top1.setText("0%");
                tv_bottom1.setText("0%");
                tv_right1.setText("0%");
            }
            yaogan1.SmallRockerCircleX = x;
            yaogan1.SmallRockerCircleY = y;
            yaogan1.invalidate();
            return true;
        }
    };
    private CompoundButton.OnCheckedChangeListener listener_cb=new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                switch (buttonView.getId()){
                    case R.id.button11:
                        if (isChecked){
                            iv1.setVisibility(View.VISIBLE);
                            mhandler.sendEmptyMessageDelayed(11,2000);
                        }
                        break;
                    case R.id.button12:
                        if (isChecked){
                            iv2.setVisibility(View.VISIBLE);
                            mhandler.sendEmptyMessageDelayed(12,2000);
                        }
                        break;
                    case R.id.button13:
                        if (isChecked){
                            iv3.setVisibility(View.VISIBLE);
                            mhandler.sendEmptyMessageDelayed(13,2000);
                        }
                        break;
                    case R.id.button14:
                        if (isChecked){
                            iv4.setVisibility(View.VISIBLE);
                            mhandler.sendEmptyMessageDelayed(14,2000);
                        }
                        break;
                    case R.id.button15:
                        if (isChecked){
                            iv5.setVisibility(View.VISIBLE);
                            mhandler.sendEmptyMessageDelayed(15,2000);
                        }
                        break;
                    case R.id.button10:
                        if (isChecked){
                            iv_fjj.setVisibility(View.VISIBLE);
                            iv_fjs.setVisibility(View.VISIBLE);
                        }
                        else {
                            iv_fjj.setVisibility(View.GONE);
                            iv_fjs.setVisibility(View.GONE);
                        }
                        break;
                }
            }
        };
    private View.OnTouchListener touchlistener2 = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            float x, y;
            x = event.getX() - 45;
            y = event.getY() - 45;
            if (event.getAction() == MotionEvent.ACTION_DOWN || event.getAction() == MotionEvent.ACTION_MOVE) {
                iv_left2.setBackgroundResource(R.drawable.sbjt);
                iv_up2.setBackgroundResource(R.drawable.sbjt2);
                iv_right2.setBackgroundResource(R.drawable.sbjt3);
                iv_down2.setBackgroundResource(R.drawable.sbjt4);
                tv_left2.setVisibility(View.GONE);
                tv_right2.setVisibility(View.GONE);
                tv_top2.setVisibility(View.GONE);
                tv_bottom2.setVisibility(View.GONE);
                int ratio=0;
                int flag=sureDirection(265, 335, x, y);
                switch (flag) {
                    case 1:
                        iv_left2.setBackgroundResource(R.drawable.sbjt_jihuo);
                        ratio=(int)((265-x)/1.8);
                        tv_left2.setVisibility(View.VISIBLE);
                        tv_left2.setText("" + ratio + "%");
                        y=335;
                        break;
                    case 2:
                        iv_up2.setBackgroundResource(R.drawable.sbjt_jihuo2);
                        ratio=(int)((335-y)/1.8);
                        tv_top2.setVisibility(View.VISIBLE);
                        tv_top2.setText("" + ratio + "%");
                        x=265;
                        break;
                    case 3:
                        iv_right2.setBackgroundResource(R.drawable.sbjt_jihuo3);
                        ratio=(int)((x-265)/1.8);
                        tv_right2.setVisibility(View.VISIBLE);
                        tv_right2.setText("" + ratio + "%");
                        y=335;
                        break;
                    case 4:
                        iv_down2.setBackgroundResource(R.drawable.sbjt_jihuo4);
                        ratio=(int)((y-335)/1.8);
                        tv_bottom2.setVisibility(View.VISIBLE);
                        tv_bottom2.setText("" + ratio + "%");
                        x=265;
                        break;
                }
                // 当触屏区域不在活动范围内
                if (Math.sqrt(Math.pow((265 - x), 2) + Math.pow((335 - y), 2)) >= 180) {
                    switch (flag){
                        case 1:
                            x=85;
                            y=335;
                            break;
                        case 2:
                            x=265;
                            y=155;
                            break;
                        case 3:
                            x=445;
                            y=335;
                            break;
                        case 4:
                            x=265;
                            y=515;
                            break;
                    }
                    tv_left2.setText("100%");
                    tv_top2.setText("100%");
                    tv_bottom2.setText("100%");
                    tv_right2.setText("100%");
                }
            }
            else if (event.getAction() == MotionEvent.ACTION_UP) {
                //当释放按键时摇杆要恢复摇杆的位置为初始位置
                x= 265;
                y= 335;
                iv_left2.setBackgroundResource(R.drawable.sbjt);
                iv_up2.setBackgroundResource(R.drawable.sbjt2);
                iv_right2.setBackgroundResource(R.drawable.sbjt3);
                iv_down2.setBackgroundResource(R.drawable.sbjt4);
                tv_left2.setVisibility(View.GONE);
                tv_right2.setVisibility(View.GONE);
                tv_top2.setVisibility(View.GONE);
                tv_bottom2.setVisibility(View.GONE);
                tv_left2.setText("0%");
                tv_top2.setText("0%");
                tv_bottom2.setText("0%");
                tv_right2.setText("0%");
            }
            yaogan2.SmallRockerCircleX = x;
            yaogan2.SmallRockerCircleY = y;
            yaogan2.invalidate();
            return true;
        }
    };
    public int sureDirection(float x1, float y1, float x2, float y2) {
        if (abs(x1 - x2) > abs(y1 - y2)) {
            if (x2 > x1)
                return 3;
            else
                return 1;
        } else {
            if (y2 > y1)
                return 4;
            else
                return 2;
        }
    }
    public void setCurrentView(View view){
        switch (view.getId()){
            case R.id.bt_view1:
                vpager.setCurrentItem(0);
                break;
            case R.id.bt_view2:
                vpager.setCurrentItem(1);
                break;
            case R.id.bt_view3:
                vpager.setCurrentItem(2);
                break;
        }
    }
    public void getOtherFunction(View v) {
        initPopWindow();
    }
    public void setQuli(View view) {
        switch (flag2){
            case 0:
                iv_checking.setVisibility(View.VISIBLE);
                mhandler.sendEmptyMessageDelayed(135, 1000);
                flag2=1;
                break;
            case 1:
                view.setBackgroundResource(R.drawable.quli);
                flag2=0;
                break;
        }

    }
    public void onBack(View v) {
        finish();
    }
    public void initPopWindow() {
        if (pw2!=null){
            pw2.setAnimationStyle(R.anim.anim_pop);
            pw2.setBackgroundDrawable(new BitmapDrawable());
            pw2.showAtLocation(findViewById(R.id.bt_other), Gravity.CENTER, 0, 0);
        }
        else {
            View view = getLayoutInflater().inflate(R.layout.layout_popwindow, null);
            Button bt= (Button) view.findViewById(R.id.button);
            RelativeLayout rl_blank1= (RelativeLayout) view.findViewById(R.id.rl_blank1);
            RelativeLayout rl_blank2= (RelativeLayout) view.findViewById(R.id.rl_blank2);
            CheckBox cb1= (CheckBox)view.findViewById(R.id.button11);
            CheckBox cb2= (CheckBox)view.findViewById(R.id.button12);
            CheckBox cb3= (CheckBox)view.findViewById(R.id.button13);
            CheckBox cb4= (CheckBox)view.findViewById(R.id.button14);
            CheckBox cb5= (CheckBox)view.findViewById(R.id.button15);
            CheckBox cb6= (CheckBox)view.findViewById(R.id.button10);
            iv1= (ImageView) view.findViewById(R.id.iv11);
            iv2= (ImageView) view.findViewById(R.id.iv12);
            iv3= (ImageView) view.findViewById(R.id.iv13);
            iv4= (ImageView) view.findViewById(R.id.iv14);
            iv5= (ImageView) view.findViewById(R.id.iv15);
            rl_blank1.setOnTouchListener(onTouchListener);
            rl_blank2.setOnTouchListener(onTouchListener);
            bt.setOnTouchListener(onTouchListener);
            cb1.setOnCheckedChangeListener(listener_cb);
            cb2.setOnCheckedChangeListener(listener_cb);
            cb3.setOnCheckedChangeListener(listener_cb);
            cb4.setOnCheckedChangeListener(listener_cb);
            cb5.setOnCheckedChangeListener(listener_cb);
            cb6.setOnCheckedChangeListener(listener_cb);
            pw2 = new PopupWindow(view, ViewGroup.LayoutParams.FILL_PARENT,
                    ViewGroup.LayoutParams.FILL_PARENT, true);
            pw2.setAnimationStyle(R.anim.anim_pop);
            pw2.setBackgroundDrawable(new BitmapDrawable());
            pw2.showAtLocation(findViewById(R.id.bt_other), Gravity.CENTER, 0, 0);
        }
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
    }
    /***
     * 得到两点之间的弧度
     */
    public double getRad(float px1, float py1, float px2, float py2) {
        //得到两点X的距离
        float x = px2 - px1;
        //得到两点Y的距离
        float y = py1 - py2;
        //算出斜边长
        float xie = (float) Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
        //得到这个角度的余弦值（通过三角函数中的定理 ：邻边/斜边=角度余弦值）
        float cosAngle = x / xie;
        //通过反余弦定理获取到其角度的弧度
        float rad = (float) Math.acos(cosAngle);
        //注意：当触屏的位置Y坐标<摇杆的Y坐标我们要取反值-0~-180
        if (py2 < py1) {
            rad = -rad;
        }
        return rad;
    }
    public float getX(float centerX, float centerY, float R, double rad) {
        //获取圆周运动的X坐标
        float x = (float) (R * Math.cos(rad)) + centerX;
        return x;
    }
    public float getY(float centerX, float centerY, float R, double rad) {
        //获取圆周运动的Y坐标
        float Y = (float) (R * Math.sin(rad)) + centerY;
        return Y;
    }
}

