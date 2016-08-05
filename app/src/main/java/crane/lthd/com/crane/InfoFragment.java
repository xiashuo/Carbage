package crane.lthd.com.crane;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.MultiAutoCompleteTextView;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import crane.lthd.com.crane.adapter.MySimpleAdapter;

import static android.widget.Toast.makeText;

public class InfoFragment extends Fragment {
    private setHead sethead;
    private View view;
    private View view_flag;
    private int flag=1;
    private TextView tv1;
    private TextView tv2;
    private TextView tv3;
    private TextView tv4;
    private TextView tv5;
    private TextView tv6;
    private TextView tv7;
    private TextView tv8;
    private TextView tv9;
    private TextView tv10;
    private TextView tv11;
    private TextView tv12;
    private TextView tv13;
    private TextView tv14;
    private TextView tv15;
    private TextView tv16;
    private TextView tv17;
    private TextView tv18;
    private ImageButton ib_all;
    private ImageButton ib_null;
    private AutoCompleteTextView act_search;
    private Button bt_onbus;
    private Button bt_downbus;
    private ListView lv_info1;
    private ListView lv_info2;
    private MySimpleAdapter adapter_lv_info1;
    private MySimpleAdapter adapter_lv_info2;
    private LinearLayout ll_onbus;
    private LinearLayout ll_downbus;
    private LinearLayout ll1;
    private LinearLayout ll2;
    private LinearLayout ll3;
    private LinearLayout ll4;
    private LinearLayout ll5;
    private LinearLayout ll6;
    private LinearLayout ll7;
    private LinearLayout ll8;
    private LinearLayout ll9;
    private LinearLayout ll10;
    private LinearLayout ll11;
    private LinearLayout ll12;
    private LinearLayout ll13;
    private LinearLayout ll14;
    private LinearLayout ll15;
    private LinearLayout ll16;
    private LinearLayout ll17;
    private LinearLayout ll18;
    private LinearLayout ll_left;
    private RelativeLayout rl_save;
    private RelativeLayout rl_listview;
    private RelativeLayout rl_zl;
    private RelativeLayout rl_sjmb;
    private RelativeLayout rl_hf;
    private LinearLayout ll_back;
    private Button bt_hf;//回放
    private ImageButton ib_save;
    String text1[]={"启动","取力","发动机转速","发动机机油压力","发动机冷却液温度","电源电压",
            "电比例安全开关","左手柄先导","右手柄先导","右手柄X","右手柄Y","左手柄X","左手柄Y",
            "泵1电流", "泵2电流", "泵1压力","泵2压力","先导阀","合流阀1","合流阀2"};
    String text2[]={"力矩百分比","额定吊重量","实际吊重量","工况代码","倍率","幅度",
            "主臂角度","主臂长度","臂头高度","风速仪"};
    String text3[]={"伸缩模式","目标伸臂组合","当前伸臂组合","T2伸缩百分比","T3伸缩百分比",
            "T4伸缩百分比", "T5伸缩百分比","T6伸缩百分比","缸销锁死状态","缸销解锁状态",
            "臂销锁死状态","臂销解锁状态","T2臂位","T3臂位","T4臂位","T5臂位","T6臂位",
            "伸缩油缸长度","伸缩油缸压力","吊臂伸","吊臂缩"
    };
    String text4[]={"伸缩副卷切换","副卷工作选择","主卷起","主卷落","副卷起", "副卷落"};
    String text5[]={"变幅起","变幅落"};
    String text6[]={"自由滑转","回转制动解除","回转锁止销解锁","回转制动解除阀","左回转",
            "右回转", "转台锁止","转台解锁","自由滑转阀"};
    String text7[]={"拆装工况","高度限位强制","过放强制","变幅起强制","力限器强制",
            "配重工作选择", "配重升","配重降","操纵室翻转升","操纵室翻转降",
            "液压油散热器"};
    String text8[]={"发动机总线正常","发动机工作时间","发动机转速","发动机水温","机油压力",
            "油门踏板位置", "发动机扭矩","发动机燃油油位","尿素液位","发动机润滑油液位",
            "巡航使能","巡航设定车速","发动机严重故障指示灯","发动机一般故障指示灯"};
    String text9[]={"变速箱总线正常","当前档位","变速箱油温","变速箱故障指示灯","变速箱油温高指示灯",
            "车辆累计里程", "车速"};
    String text10[]={"分动箱低档检测","轴间差速检测","轮间差速检测","公路行驶","防甩尾",
            "蟹行", "后桥转向锁止","小转弯","后桥独立转向","转向故障",
            "当前转向模式","一轴转向角度","二轴转向角度","三轴转向角度"};
    String text11[]={"发动机制动","ABS总线正常","ABS故障指示灯","行车制动","驻车制动","低气压报警",
    "气压1","气压2","制动气压"};
    String text12[]={"液压取力","支腿操作有效","左前支腿压力","右前支腿压力","左后支腿压力","右后支腿压力",
            "车身水平仪X方向", "车身水平仪Y方向","左前支腿跨距","右前支腿跨距","左后支腿跨距",
            "右后支腿跨距"};
    String text13[]={"液压取力","刚性悬架","悬架调平","悬架左前压力","悬架右前压力",
            "悬架左后压力","悬架右后压力","悬架左前上检测开关", "悬架左前下检测开关",
            "悬架右前上检测开关","悬架右前下检测开关","悬架左后上检测开关",
            "悬架左后下检测开关", "悬架右后上检测开关","悬架右后下检测开关"};
    String text14[]={"日间行车灯","行车灯","近光灯","远光灯", "左转向指示灯",
            "右转向指示灯","前雾灯", "后雾灯", "支腿照明灯"};
    String text15[]={"一轴轴荷","二轴轴荷","三轴轴荷","总轴荷","重心坐标","X","Y","Z"};
    String text16[]={"P1控制器版本","P2控制器版本","P4控制器版本","P8控制器版本"};
    String data1[]={"","","1rpm","1bar","4℃","220V","","","","500","500",
            "500","500","500","500","100","150","200","500","500"};
    String data2[]={"50%","20t","15t","001001","10","3m","3m%","3m","3m","3m/m",};
    String data3[]={"手动","112222","112222","50%","50%","50%","50%","50%","",""
            ,"","","","","","","","50mm","2bar","",""};
    String data4[]={"","","","","",""};
    String data5[]={"",""};
    String data6[]={"","","","","","","","","",""};
    String data7[]={"","","","","","","","","","",""};
    String data8[]={"","5000h","2500r/min","100℃","500Kpa","50%","50%","50%",
            "50%","50%","","80km/h","",""};
    String data9[]={"","N","100℃","","","5000km","80km/h"};
    String data10[]={"","","","","","","","","","","4","0°","0°","0°"};
    String data11[]={"","","","","","","5bar","5bar","5bar"};
    String data12[]={"","","500bar","500bar","500bar","500bar","0°","0°","500mm","500mm"
            ,"500mm","500mm"};
    String data13[]={"","","","300bar","300bar","300bar","300bar","","",""
            ,"","","","",""};

    String data14[]={"","","","","","","","","",""
            ,""};
    String data15[]={"0.5t","0.5t","0.5t","1.5t","","0.50","0.50","0.50"};
    String data16[]={"1.00.00","1.00.00","1.00.00","1.00.00"};
    int image1[]={R.drawable.deng, R.drawable.deng2,R.mipmap.ig,R.mipmap.ig,
            R.mipmap.ig,R.mipmap.ig,R.drawable.deng,R.drawable.deng, R.drawable.deng2
            ,R.mipmap.ig,R.mipmap.ig,R.mipmap.ig,R.mipmap.ig,R.mipmap.ig,R.mipmap.ig,
            R.mipmap.ig,R.mipmap.ig,R.mipmap.ig,R.mipmap.ig,R.mipmap.ig};
    int image2[]={R.mipmap.ig,R.mipmap.ig, R.mipmap.ig,R.mipmap.ig,
            R.mipmap.ig,R.mipmap.ig,R.mipmap.ig,R.mipmap.ig,R.mipmap.ig, R.mipmap.ig};
    int image3[]={R.mipmap.ig,R.mipmap.ig,R.mipmap.ig,R.mipmap.ig
            ,R.mipmap.ig,R.mipmap.ig,R.mipmap.ig,R.mipmap.ig, R.drawable.deng2,
            R.drawable.deng,R.drawable.deng, R.drawable.deng2,R.drawable.deng2
            ,R.drawable.deng, R.drawable.deng,R.drawable.deng2,R.drawable.deng,
            R.mipmap.ig,R.mipmap.ig,R.drawable.deng,R.drawable.deng2};
    int image4[]={R.drawable.deng, R.drawable.deng2,R.drawable.deng,R.drawable.deng2,
            R.drawable.deng,R.drawable.deng,R.drawable.deng2,R.drawable.deng,R.drawable.deng,
            R.drawable.deng2,R.drawable.deng,R.drawable.deng2,R.drawable.deng};
    int image5[]={R.drawable.deng,R.drawable.deng2};
    int image6[]={R.drawable.deng, R.drawable.deng2, R.drawable.deng,R.drawable.deng2
            ,R.drawable.deng2,R.drawable.deng,R.drawable.deng2,R.drawable.deng,
            R.drawable.deng,R.drawable.deng2};
    int image7[]={R.drawable.deng, R.drawable.deng2,R.drawable.deng,R.drawable.deng2,
            R.drawable.deng,R.drawable.deng2,R.drawable.deng,R.drawable.deng2,R.drawable.deng
            ,R.drawable.deng, R.drawable.deng2};
    int image8[]={R.drawable.deng2,R.mipmap.ig,R.mipmap.ig,R.mipmap.ig,R.mipmap.ig
            ,R.mipmap.ig,R.mipmap.ig,R.mipmap.ig,R.mipmap.ig, R.mipmap.ig, R.drawable.deng,
            R.mipmap.ig,R.drawable.deng, R.drawable.deng2};
    int image9[]={R.drawable.deng2,R.mipmap.ig,R.mipmap.ig, R.drawable.deng, R.drawable.deng2
            ,R.mipmap.ig,R.mipmap.ig};
    int image10[]={R.drawable.deng, R.drawable.deng2,R.drawable.deng2, R.drawable.deng,
            R.drawable.deng2,R.drawable.deng,R.drawable.deng2,R.drawable.deng2,
            R.drawable.deng,R.drawable.deng,R.mipmap.ig,R.mipmap.ig,R.mipmap.ig,R.mipmap.ig,};
    int image11[]={R.drawable.deng2, R.drawable.deng,R.drawable.deng2,R.drawable.deng2,
            R.drawable.deng,R.drawable.deng2,R.mipmap.ig,R.mipmap.ig,R.mipmap.ig};
    int image12[]={R.drawable.deng2, R.drawable.deng,R.mipmap.ig,R.mipmap.ig,R.mipmap.ig
    ,R.mipmap.ig,R.mipmap.ig,R.mipmap.ig,R.mipmap.ig,R.mipmap.ig,R.mipmap.ig,R.mipmap.ig};
    int image13[]={R.drawable.deng2, R.drawable.deng,R.drawable.deng2,R.mipmap.ig,
            R.mipmap.ig,R.mipmap.ig,R.mipmap.ig,R.drawable.deng2, R.drawable.deng,
            R.drawable.deng2,R.drawable.deng2, R.drawable.deng,R.drawable.deng2,
            R.drawable.deng2, R.drawable.deng};
    int image14[]={R.drawable.deng2,R.drawable.deng2,
            R.drawable.deng, R.drawable.deng2,R.drawable.deng2, R.drawable.deng,
            R.drawable.deng2, R.drawable.deng2, R.drawable.deng};
    int image15[]={R.mipmap.ig,R.mipmap.ig,R.mipmap.ig,R.mipmap.ig,R.mipmap.ig,
            R.mipmap.ig,R.mipmap.ig,R.mipmap.ig};
    int image16[]={R.mipmap.ig,R.mipmap.ig,R.mipmap.ig,R.mipmap.ig};
    int image_left1[]={R.drawable.qd, R.drawable.ql, R.mipmap.fdjzs, R.drawable.fdjjyyl
    , R.drawable.fdjlqywd,R.drawable.dydy, R.drawable.dblaqkg, R.drawable.zsbxd, R.drawable.ysbxd
    , R.drawable.ysbx, R.drawable.ysby, R.drawable.zsbx, R.drawable.zsby,
            R.drawable.b1dl, R.drawable.b2dl, R.drawable.b1yl, R.drawable.b2yl,
            R.drawable.xdf, R.drawable.hlf1, R.drawable.hlf2};
    int image_left2[]={R.drawable.ljbfb,R.drawable.eddzl,R.drawable.sjdzl,
            R.drawable.gkdm,R.drawable.beilv,R.drawable.fudu,R.drawable.zbjd,R.drawable.zbcd
            ,R.drawable.btgd,R.drawable.fsy};
    int image_left3[]={R.drawable.ssms,R.drawable.mbsbzh,R.drawable.dqsbzh,
            R.drawable.t2ssbfb,R.drawable.t3ssbfb,R.drawable.t4ssbfb,R.drawable.t5ssbfb,
            R.drawable.t6ssbfb,R.drawable.gxss,R.drawable.gxjs, R.drawable.bxss, R.drawable.bxjs,
            R.drawable.t2bw, R.drawable.t3bw, R.drawable.t4bw, R.drawable.t5bw,
            R.drawable.t6bw, R.drawable.ssygcd, R.drawable.ssygyl, R.drawable.dbs, R.drawable.dbs};
    int image_left4[]={R.drawable.ssfjqh,R.drawable.fjgzxz,R.drawable.zjq,
            R.drawable.zjl,R.drawable.fjq,R.drawable.fjl};
    int image_left5[]={R.drawable.bfq,R.drawable.bfl};
    int image_left6[]={R.drawable.zyhz,R.drawable.hzzdjc,R.drawable.hzszxjs,
            R.drawable.hzzdjcf,R.drawable.zhz,R.drawable.yhz,R.drawable.ztsz,
            R.drawable.ztjs,R.drawable.zyhzf};
    int image_left7[]={R.drawable.czgk,R.drawable.gdxwqz,R.drawable.gfqz,
            R.drawable.bfqqz,R.drawable.lxqqz,R.drawable.pzgzxz,R.drawable.pzs,
            R.drawable.pzj,R.drawable.czsfzs,R.drawable.czsfzj, R.drawable.yyysrq};
    int image_left9[]={R.drawable.fdjzxzc,R.drawable.fdjgzsj,R.mipmap.fdjzs,
            R.drawable.fdjlqywd,R.mipmap.jyyl,R.drawable.ymtbwz,R.drawable.fdjnj,
            R.drawable.fdjryyw,R.drawable.nsyw,R.drawable.fdjrhyyw, R.drawable.xhsn
    ,R.drawable.xhsdcs,R.drawable.fdjyzgz,R.drawable.fdjybgz};
    int image_left10[]={R.drawable.bsxzxzc,R.drawable.dqdw,R.drawable.bsxyw,
            R.drawable.bsxgzzsd,R.drawable.bsxywgzsd,R.drawable.clljlc,
            R.drawable.cs};
    int image_left11[]={R.drawable.fdxddjc,R.drawable.zjcsjc,R.drawable.ljcsjc,
            R.drawable.glxs,R.drawable.fsw,R.drawable.xx,R.drawable.hqzxsz,
            R.drawable.xzw,R.drawable.hqdlzx,R.drawable.zxgz, R.drawable.dqzxms
            ,R.drawable.yzzxjd,R.drawable.ezzxjd,R.drawable.szzxjd};
    int image_left12[]={R.drawable.fdjzd,R.drawable.abszxzc,R.drawable.absgzzsd,
            R.drawable.xczdzsd,R.drawable.zczdzsd,R.drawable.dqybj,R.drawable.qy1,
            R.drawable.qy2,R.drawable.zdqy};
    int image_left13[]={R.drawable.yyql,R.drawable.ztczyx,R.drawable.zqztyl,
            R.drawable.yqztyl,R.drawable.zhztyl,R.drawable.yhztyl,R.drawable.csspxfx,
            R.drawable.csspyfx,R.drawable.zqztkj,R.drawable.yqztkj, R.drawable.zhztkj
            ,R.drawable.yhztkj};
    int image_left14[]={R.drawable.yyql,R.drawable.gxxj,R.drawable.xjtp, R.drawable.xjzqyl,
            R.drawable.xgyqyl,R.drawable.xgzhyl,R.drawable.xgyhyl, R.drawable.xgzqsjc,
            R.drawable.xgzqxjc,R.drawable.xgyqs, R.drawable.xgyqx,R.drawable.xgzhs,
    R.drawable.xgzhx,R.drawable.xgyhs,R.drawable.xgyhx};
    int image_left15[]={R.drawable.rjxcd,R.drawable.xcd,R.drawable.jgd, R.drawable.ygd
            ,R.drawable.zzxzsd, R.drawable.yzxzsd,
            R.drawable.qwd,R.drawable.hwd, R.drawable.ztzmd2};
    int image_left16[]={R.drawable.yjzh,R.drawable.ezzh,R.drawable.szzh,R.drawable.zzh,
            R.drawable.zxzb,R.drawable.xzzb,R.drawable.yzzb,R.drawable.zzzb};
    int image_left17[]={R.drawable.p1,R.drawable.p2,R.drawable.p4, R.drawable.p8};

    String[] data={"作业监控","载荷监控","伸缩系统","卷扬系统","变幅系统","回转系统",
            "辅助信息","虚拟仪表（上车）","发动机","变速箱","行驶监控","综合制动","支腿监控",
            "悬架监控","灯光监控","轴荷监控","软件版本","虚拟仪表（下车）"};
    List<Map<String,Object>> list1;
    List<Map<String,Object>> list2;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_info, container, false);
        initView(view);
        TextView tv= (TextView) view.findViewById(R.id.config_hidden);
        tv.requestFocus();
        view_flag=ll1;
        initEvent();
        initListView1(text1, data1, image1,image_left1);
        initListView2(text8, data8, image8,image_left9);
        return view;
    }
    private void initListView1(String[] text,String[] data,int[] image,int[] image_left) {
        list1=new ArrayList<>();
        for (int i=0;i<text.length;i++){
            Map<String,Object> map=new HashMap<>();
            map.put("text",text[i]);
            map.put("data",data[i]);
            map.put("image",image[i]);
            map.put("image_left",image_left[i]);
            list1.add(map);
        }
        adapter_lv_info1=new MySimpleAdapter(getContext(),list1,R.layout.layout_info,
                new String[]{"text","data","image","image_left"},new int[]{
                R.id.text,R.id.text2, R.id.image2, R.id.image1});
        lv_info1.setAdapter(adapter_lv_info1);
        setListViewHeightBasedOnChildren(lv_info1);
    }
    private void initListView2(String[] text,String[] data,int[] image,int[] image_left) {
        list2=new ArrayList<>();
        for (int i=0;i<text.length;i++){
            Map<String,Object> map=new HashMap<>();
            map.put("text",text[i]);
            map.put("data",data[i]);
            map.put("image",image[i]);
            map.put("image_left",image_left[i]);
            list2.add(map);
        }
        adapter_lv_info2=new MySimpleAdapter(getContext(),list2,R.layout.layout_info,
                new String[]{"text","image","data","image_left"},new int[]{R.id.text,R.id.image2,
                R.id.text2,R.id.image1});
        lv_info2.setAdapter(adapter_lv_info2);
        setListViewHeightBasedOnChildren(lv_info2);
    }
    private View.OnClickListener listener3=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            rl_listview.setVisibility(View.VISIBLE);
            rl_zl.setVisibility(View.GONE);
            rl_sjmb.setVisibility(View.VISIBLE);
            rl_hf.setVisibility(View.GONE);
            switch (v.getId()){
                case R.id.bt_onbus:
                    bt_onbus.setBackgroundResource(R.drawable.shangche_checked);
                    bt_downbus.setBackgroundResource(R.drawable.xiache);
                    sethead.setTitle("上车信息");
                    ll_downbus.setVisibility(View.GONE);
                    ll_onbus.setVisibility(View.VISIBLE);
                    lv_info1.setVisibility(View.VISIBLE);
                    lv_info2.setVisibility(View.GONE);
                    flag=1;
                    view_flag=ll1;
                    break;
                case R.id.bt_downbus:
                    bt_onbus.setBackgroundResource(R.drawable.shangche);
                    bt_downbus.setBackgroundResource(R.drawable.xiache_checked);
                    ll_onbus.setVisibility(View.GONE);
                    ll_downbus.setVisibility(View.VISIBLE);
                    sethead.setTitle("下车信息");
                    lv_info2.setVisibility(View.VISIBLE);
                    lv_info1.setVisibility(View.GONE);
                    flag=2;
                    view_flag=ll9;
                    break;
            }
        }
    };
    private void initEvent() {
        bt_downbus.setOnClickListener(listener3);
        bt_onbus.setOnClickListener(listener3);
        ll1.setOnClickListener(listener1);
        ll2.setOnClickListener(listener1);
        ll3.setOnClickListener(listener1);
        ll4.setOnClickListener(listener1);
        ll5.setOnClickListener(listener1);
        ll6.setOnClickListener(listener1);
        ll7.setOnClickListener(listener1);
        ll17.setOnClickListener(listener1);
        ll8.setOnClickListener(listener2);
        ll9.setOnClickListener(listener2);
        ll10.setOnClickListener(listener2);
        ll11.setOnClickListener(listener2);
        ll12.setOnClickListener(listener2);
        ll13.setOnClickListener(listener2);
        ll14.setOnClickListener(listener2);
        ll15.setOnClickListener(listener2);
        ll16.setOnClickListener(listener2);
        ll18.setOnClickListener(listener2);
        ib_save.setOnClickListener(listener4);
        bt_hf.setOnClickListener(listener4);
        ll_back.setOnClickListener(listener4);
        ib_all.setOnClickListener(listener5);
        ib_null.setOnClickListener(listener5);
        ll_left.setOnClickListener(listener6);
        lv_info1.setOnItemLongClickListener(longClickListener1);
        lv_info2.setOnItemLongClickListener(longClickListener1);
    }

    private void initView(View view) {
        tv1=(TextView)view.findViewById(R.id.tv1);
        tv2=(TextView)view.findViewById(R.id.tv2);
        tv3=(TextView)view.findViewById(R.id.tv3);
        tv4=(TextView)view.findViewById(R.id.tv4);
        tv5=(TextView)view.findViewById(R.id.textView5);
        tv6=(TextView)view.findViewById(R.id.textView6);
        tv7=(TextView)view.findViewById(R.id.textView7);
        tv8=(TextView)view.findViewById(R.id.textView8);
        tv9=(TextView)view.findViewById(R.id.tv5);
        tv10=(TextView)view.findViewById(R.id.tv6);
        tv11=(TextView)view.findViewById(R.id.tv7);
        tv12=(TextView)view.findViewById(R.id.tv8);
        tv13=(TextView)view.findViewById(R.id.tv9);
        tv14=(TextView)view.findViewById(R.id.tv10);
        tv15=(TextView)view.findViewById(R.id.tv11);
        tv16=(TextView)view.findViewById(R.id.tv12);
        tv17=(TextView)view.findViewById(R.id.tv17);
        tv18=(TextView)view.findViewById(R.id.tv18);
        act_search= (AutoCompleteTextView) view.findViewById(R.id.act_search);
        Drawable drawable=getResources().getDrawable(R.drawable.search);
        drawable.setBounds(0, 0, 30, 30);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(getContext(),
                android.R.layout.simple_dropdown_item_1line,data);
        adapter.setDropDownViewResource(R.layout.item_spinner);
        act_search.setAdapter(adapter);
        act_search.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                act_search.setText("");
                String str=(String) parent.getItemAtPosition(position);
                if (str.equals(data[0]))
                    moveToResult(ll1,1);
                else if (str.equals(data[1]))
                    moveToResult(ll2,1);
                else if (str.equals(data[2]))
                    moveToResult(ll3,1);
                else if (str.equals(data[3]))
                    moveToResult(ll4,1);
                else if (str.equals(data[4]))
                    moveToResult(ll5,1);
                else if (str.equals(data[5]))
                    moveToResult(ll6,1);
                else if (str.equals(data[6]))
                    moveToResult(ll7,1);
                else if (str.equals(data[7]))
                    moveToResult(ll17,1);
                else if (str.equals(data[8]))
                    moveToResult(ll8,2);
                else if (str.equals(data[9]))
                    moveToResult(ll9,2);
                else if (str.equals(data[10]))
                    moveToResult(ll10,2);
                else if (str.equals(data[11]))
                    moveToResult(ll11,2);
                else if (str.equals(data[12]))
                    setLayout2(ll12);
                else if (str.equals(data[13]))
                    moveToResult(ll13,2);
                else if (str.equals(data[14]))
                    moveToResult(ll14,2);
                else if (str.equals(data[15]))
                    moveToResult(ll15,2);
                else if (str.equals(data[16]))
                    moveToResult(ll16,2);
                else if (str.equals(data[17]))
                    moveToResult(ll18,2);
            }
        });
        act_search.setCompoundDrawables(drawable, null, null, null);
        bt_downbus= (Button) view.findViewById(R.id.bt_downbus);
        bt_onbus= (Button) view.findViewById(R.id.bt_onbus);
        lv_info1= (ListView) view.findViewById(R.id.lv_info1);
        lv_info2= (ListView) view.findViewById(R.id.lv_info2);
        ll_downbus= (LinearLayout) view.findViewById(R.id.ll_downbus);
        ll_onbus= (LinearLayout) view.findViewById(R.id.ll_onbus);
        ll1= (LinearLayout) view.findViewById(R.id.button1);
        ll2= (LinearLayout) view.findViewById(R.id.button2);
        ll3= (LinearLayout) view.findViewById(R.id.button3);
        ll4= (LinearLayout) view.findViewById(R.id.button4);
        ll5= (LinearLayout) view.findViewById(R.id.bt5);
        ll6= (LinearLayout) view.findViewById(R.id.bt6);
        ll7= (LinearLayout) view.findViewById(R.id.bt7);
        ll8= (LinearLayout) view.findViewById(R.id.bt8);
        ll9= (LinearLayout) view.findViewById(R.id.button5);
        ll10= (LinearLayout) view.findViewById(R.id.button6);
        ll11= (LinearLayout) view.findViewById(R.id.button7);
        ll12= (LinearLayout) view.findViewById(R.id.button8);
        ll13= (LinearLayout) view.findViewById(R.id.button9);
        ll14= (LinearLayout) view.findViewById(R.id.button10);
        ll15= (LinearLayout) view.findViewById(R.id.button11);
        ll16= (LinearLayout) view.findViewById(R.id.button12);
        ll17= (LinearLayout) view.findViewById(R.id.bt17);
        ll18= (LinearLayout) view.findViewById(R.id.button18);
        ll_back= (LinearLayout) view.findViewById(R.id.ll_back);
        rl_save= (RelativeLayout) view.findViewById(R.id.rl_save);
        rl_listview= (RelativeLayout) view.findViewById(R.id.rl_listview);
        rl_sjmb= (RelativeLayout) view.findViewById(R.id.rl_sjmb);
        rl_hf= (RelativeLayout) view.findViewById(R.id.rl_hf);
        rl_zl= (RelativeLayout) view.findViewById(R.id.rl_zl);
        bt_hf= (Button) view.findViewById(R.id.bt3);
        ib_save=(ImageButton)view.findViewById(R.id.bt_save);
        ib_all= (ImageButton) view.findViewById(R.id.ib_all);
        ib_null= (ImageButton) view.findViewById(R.id.ib_null);
        ll_left= (LinearLayout) view.findViewById(R.id.ll_left);
    }
    public void moveToResult(View v,int i){
        switch (i){
            case 1:
                bt_onbus.setBackgroundResource(R.drawable.shangche_checked);
                bt_downbus.setBackgroundResource(R.drawable.xiache);
                sethead.setTitle("上车信息");
                ll_downbus.setVisibility(View.GONE);
                ll_onbus.setVisibility(View.VISIBLE);
                lv_info1.setVisibility(View.VISIBLE);
                lv_info2.setVisibility(View.GONE);
                flag=1;
                view_flag=v;
                setLayout(v);
                break;
            case 2:
                bt_onbus.setBackgroundResource(R.drawable.shangche);
                bt_downbus.setBackgroundResource(R.drawable.xiache_checked);
                ll_onbus.setVisibility(View.GONE);
                ll_downbus.setVisibility(View.VISIBLE);
                sethead.setTitle("下车信息");
                lv_info2.setVisibility(View.VISIBLE);
                lv_info1.setVisibility(View.GONE);
                flag=2;
                view_flag=v;
                setLayout2(v);
                break;
        }
    }
    private void resetBg1() {
        ll1.setBackgroundResource(R.color.bg_list);
        ll2.setBackgroundResource(R.color.bg_list);
        ll3.setBackgroundResource(R.color.bg_list);
        ll4.setBackgroundResource(R.drawable.border_bottom);
        ll5.setBackgroundResource(R.drawable.border_bottom);
        ll6.setBackgroundResource(R.drawable.border_bottom);
        ll7.setBackgroundResource(R.drawable.border_bottom);
        ll17.setBackgroundResource(R.drawable.border_bottom);
        tv1.setTextColor(getResources().getColor(R.color.tv_color));
        tv2.setTextColor(getResources().getColor(R.color.tv_color));
        tv3.setTextColor(getResources().getColor(R.color.tv_color));
        tv4.setTextColor(getResources().getColor(R.color.tv_color));
        tv5.setTextColor(getResources().getColor(R.color.tv_color));
        tv6.setTextColor(getResources().getColor(R.color.tv_color));
        tv7.setTextColor(getResources().getColor(R.color.tv_color));
        tv17.setTextColor(getResources().getColor(R.color.tv_color));
    }
    private void resetBg2() {
        ll8.setBackgroundResource(R.color.bg_list);
        ll9.setBackgroundResource(R.color.bg_list);
        ll10.setBackgroundResource(R.color.bg_list);
        ll11.setBackgroundResource(R.color.bg_list);
        ll12.setBackgroundResource(R.color.bg_list);
        ll13.setBackgroundResource(R.color.bg_list);
        ll14.setBackgroundResource(R.color.bg_list);
        ll15.setBackgroundResource(R.color.bg_list);
        ll16.setBackgroundResource(R.drawable.border_bottom);
        ll18.setBackgroundResource(R.drawable.border_bottom);
        tv8.setTextColor(getResources().getColor(R.color.tv_color));
        tv9.setTextColor(getResources().getColor(R.color.tv_color));
        tv10.setTextColor(getResources().getColor(R.color.tv_color));
        tv11.setTextColor(getResources().getColor(R.color.tv_color));
        tv12.setTextColor(getResources().getColor(R.color.tv_color));
        tv13.setTextColor(getResources().getColor(R.color.tv_color));
        tv14.setTextColor(getResources().getColor(R.color.tv_color));
        tv15.setTextColor(getResources().getColor(R.color.tv_color));
        tv16.setTextColor(getResources().getColor(R.color.tv_color));
        tv18.setTextColor(getResources().getColor(R.color.tv_color));
    }
    private View.OnClickListener listener1=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (adapter_lv_info1.flag&&v!=view_flag){
                showDiadog(v,1);
                adapter_lv_info1.flag=false;
            }
            else {setLayout(v);}
            view_flag=v;
        }
    };
    private View.OnClickListener listener2=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (adapter_lv_info2.flag&&v!=view_flag){
                showDiadog(v,2);
                adapter_lv_info2.flag=false;
            }
            else
                setLayout2(v);
            view_flag=v;
        }
    };
    public View.OnClickListener listener4=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.bt_save:
                    rl_listview.setVisibility(View.GONE);
                    rl_save.setVisibility(View.GONE);
                    rl_zl.setVisibility(View.VISIBLE);
                    break;
                case R.id.bt3:
                    rl_sjmb.setVisibility(View.GONE);
                    rl_hf.setVisibility(View.VISIBLE);
                    break;
                case R.id.ll_back:
                   showDiadog(view_flag,1);
            }
        }
    };
    private View.OnClickListener listener5=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            ib_all.setBackgroundResource(R.drawable.all);
            ib_null.setBackgroundResource(R.drawable.none);
            switch (v.getId()){
                case R.id.ib_all:
                    ib_all.setBackgroundResource(R.drawable.all_selected);
                    if (flag==1){
                        int count=lv_info1.getChildCount();
                        for (int i=0;i<count;i++){
                            View view=lv_info1.getChildAt(i);
                            CheckBox cb=(CheckBox)view.findViewById(R.id.checkbox1);
                            cb.setChecked(true);
                        }
                    }
                    else {
                        int count=lv_info2.getChildCount();
                        for (int i=0;i<count;i++){
                            View view=lv_info2.getChildAt(i);
                            CheckBox cb=(CheckBox)view.findViewById(R.id.checkbox1);
                            cb.setChecked(true);
                        }
                    }
                    break;
                case R.id.ib_null:
                    ib_null.setBackgroundResource(R.drawable.null_selected);
                    if (flag==1){
                        int count=lv_info1.getChildCount();
                        for (int i=0;i<count;i++){
                            View view=lv_info1.getChildAt(i);
                            CheckBox cb=(CheckBox)view.findViewById(R.id.checkbox1);
                            cb.setChecked(false);
                        }
                    }
                    else {
                        int count=lv_info2.getChildCount();
                        for (int i=0;i<count;i++){
                            View view=lv_info2.getChildAt(i);
                            CheckBox cb=(CheckBox)view.findViewById(R.id.checkbox1);
                            cb.setChecked(false);
                        }
                    }
                    break;
            }
        }
    };
    private View.OnClickListener listener6=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            InputMethodManager imm = (InputMethodManager)
                    getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
        }
    };
    private AdapterView.OnItemLongClickListener longClickListener1=new AdapterView.OnItemLongClickListener() {
        @Override
        public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
            switch (flag){
                case 1:
                    int count1=lv_info1.getChildCount();
                    for (int i=0;i<count1;i++){
                        View v=lv_info1.getChildAt(i);
                        v.findViewById(R.id.checkbox1).setVisibility(View.VISIBLE);
                    }
                    break;
                case 2:
                    int count2=lv_info2.getChildCount();
                    for (int i=0;i<count2;i++){
                        View v=lv_info2.getChildAt(i);
                        v.findViewById(R.id.checkbox1).setVisibility(View.VISIBLE);
                    }
                    break;
            }
            view.findViewById(R.id.checkbox1).setVisibility(View.VISIBLE);
            rl_save.setVisibility(View.VISIBLE);
            return false;
        }
    };
    public void showDiadog(final View view1, final int flag) {
        final AlertDialog.Builder builder= new AlertDialog.Builder(getContext());
        View view=getLayoutInflater(null).inflate(R.layout.layout_diadog,null);
        final Button bt1= (Button) view.findViewById(R.id.bt1);
        Button bt2= (Button) view.findViewById(R.id.bt2);
        Button bt3= (Button) view.findViewById(R.id.bt3);
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
                if (flag==1)
                    setLayout(view1);
                else if (flag==2)
                    setLayout2(view1);
            }
        };
        bt1.setOnClickListener(listener);
        bt2.setOnClickListener(listener);
        bt3.setOnClickListener(listener);
    }
    public void setLayout(View v){
        resetBg1();
        rl_save.setVisibility(View.GONE);
        rl_listview.setVisibility(View.VISIBLE);
        rl_zl.setVisibility(View.GONE);
        rl_sjmb.setVisibility(View.VISIBLE);
        rl_hf.setVisibility(View.GONE);
        ib_all.setBackgroundResource(R.drawable.all);
        ib_null.setBackgroundResource(R.drawable.none);
        switch (v.getId()) {
            case R.id.button1:
                lv_info1.setVisibility(View.VISIBLE);
                ll1.setBackgroundColor(getResources().getColor(R.color.bg_selected));
                tv1.setTextColor(Color.WHITE);
                initListView1(text1, data1, image1,image_left1);
                break;
            case R.id.button2:
                lv_info1.setVisibility(View.VISIBLE);
                ll2.setBackgroundColor(getResources().getColor(R.color.bg_selected));
                tv2.setTextColor(Color.WHITE);
                initListView1(text2, data2, image2,image_left2);
                break;
            case R.id.button3:
                lv_info1.setVisibility(View.VISIBLE);
                ll3.setBackgroundColor(getResources().getColor(R.color.bg_selected));
                tv3.setTextColor(Color.WHITE);
                initListView1(text3, data3, image3,image_left3);
                break;
            case R.id.button4:
                lv_info1.setVisibility(View.VISIBLE);
                ll4.setBackgroundColor(getResources().getColor(R.color.bg_selected));
                tv4.setTextColor(Color.WHITE);
                initListView1(text4, data4, image4,image_left4);
                break;
            case R.id.bt5:
                lv_info1.setVisibility(View.VISIBLE);
                ll5.setBackgroundColor(getResources().getColor(R.color.bg_selected));
                tv5.setTextColor(Color.WHITE);
                initListView1(text5, data5, image5,image_left5);
                break;
            case R.id.bt6:
                lv_info1.setVisibility(View.VISIBLE);
                ll6.setBackgroundColor(getResources().getColor(R.color.bg_selected));
                tv6.setTextColor(Color.WHITE);
                initListView1(text6, data6, image6,image_left6);
                break;
            case R.id.bt7:
                lv_info1.setVisibility(View.VISIBLE);
                ll7.setBackgroundColor(getResources().getColor(R.color.bg_selected));
                tv7.setTextColor(Color.WHITE);
                initListView1(text7, data7, image7,image_left7);
                break;
            case R.id.bt17:
                lv_info1.setVisibility(View.VISIBLE);
                ll17.setBackgroundColor(getResources().getColor(R.color.bg_selected));
                tv17.setTextColor(Color.WHITE);
                lv_info1.setVisibility(View.GONE);
                rl_save.setVisibility(View.GONE);
                break;
        }
    }
    public void setLayout2(View v){
        resetBg2();
        rl_save.setVisibility(View.GONE);
        rl_listview.setVisibility(View.VISIBLE);
        rl_zl.setVisibility(View.GONE);
        rl_sjmb.setVisibility(View.VISIBLE);
        rl_hf.setVisibility(View.GONE);
        ib_all.setBackgroundResource(R.drawable.all);
        ib_null.setBackgroundResource(R.drawable.none);
        switch (v.getId()){
            case R.id.bt8:
                lv_info2.setVisibility(View.VISIBLE);
                ll8.setBackgroundColor(getResources().getColor(R.color.bg_selected));
                tv8.setTextColor(Color.WHITE);
                initListView2(text8,data8,image8,image_left9);
                break;
            case R.id.button5:
                lv_info2.setVisibility(View.VISIBLE);
                ll9.setBackgroundColor(getResources().getColor(R.color.bg_selected));
                tv9.setTextColor(Color.WHITE);
                initListView2(text9,data9,image9,image_left10);
                break;
            case R.id.button6:
                lv_info2.setVisibility(View.VISIBLE);
                ll10.setBackgroundColor(getResources().getColor(R.color.bg_selected));
                tv10.setTextColor(Color.WHITE);
                initListView2(text10, data10, image10,image_left11);
                break;
            case R.id.button7:
                lv_info2.setVisibility(View.VISIBLE);
                ll11.setBackgroundColor(getResources().getColor(R.color.bg_selected));
                tv11.setTextColor(Color.WHITE);
                initListView2(text11, data11, image11,image_left12);
                break;
            case R.id.button8:
                lv_info2.setVisibility(View.VISIBLE);
                ll12.setBackgroundColor(getResources().getColor(R.color.bg_selected));
                tv12.setTextColor(Color.WHITE);
                initListView2(text12, data12, image12,image_left13);
                break;
            case R.id.button9:
                lv_info2.setVisibility(View.VISIBLE);
                ll13.setBackgroundColor(getResources().getColor(R.color.bg_selected));
                tv13.setTextColor(Color.WHITE);
                initListView2(text13, data13, image13,image_left14);
                break;
            case R.id.button10:
                lv_info2.setVisibility(View.VISIBLE);
                ll14.setBackgroundColor(getResources().getColor(R.color.bg_selected));
                tv14.setTextColor(Color.WHITE);
                initListView2(text14, data14, image14,image_left15);
                break;
            case R.id.button11:
                lv_info2.setVisibility(View.VISIBLE);
                ll15.setBackgroundColor(getResources().getColor(R.color.bg_selected));
                tv15.setTextColor(Color.WHITE);
                initListView2(text15, data15, image15,image_left16);
                break;
            case R.id.button12:
                lv_info2.setVisibility(View.VISIBLE);
                ll16.setBackgroundColor(getResources().getColor(R.color.bg_selected));
                tv16.setTextColor(Color.WHITE);
                initListView2(text16, data16, image16,image_left17);
                break;
            case R.id.button18:
                lv_info2.setVisibility(View.VISIBLE);
                ll18.setBackgroundColor(getResources().getColor(R.color.bg_selected));
                tv18.setTextColor(Color.WHITE);
                lv_info2.setVisibility(View.GONE);
                rl_save.setVisibility(View.GONE);
                break;
        }
    }
    public void setListViewHeightBasedOnChildren(ListView listView) {
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null) {
            return;
        }
        int totalHeight = 0;
        for (int i = 0, len = listAdapter.getCount(); i < len; i++) {
            View listItem = listAdapter.getView(i, null, listView);
            listItem.measure(0, 0);
            totalHeight += listItem.getMeasuredHeight();
        }
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight+ (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
    }
    public interface setHead {
        public void setTitle(String str);
    }
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        sethead=(setHead)activity;
    }
}