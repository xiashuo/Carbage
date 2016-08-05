package crane.lthd.com.crane;

import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.List;
import java.util.Map;

/**
 * Created by xs on 2016/7/26.
 */
public class Data_Warning {
    public int[] image={R.drawable.fdj,R.drawable.fdj,R.drawable.fdj,R.drawable.bsx,R.drawable.abs,
            R.drawable.lxqxt,R.drawable.lxqxt,R.drawable.zjxt};
    public String[] name_gz={"发动机","发动机","发动机","变速箱","ABS","力限器系统","力限器系统","主卷系统"};
    public String[] code_gz={"8000460002","800046000D","8000540000","812P2185","83000005","01010031"
            ,"01010061","06100102"};
    public String[] info_error={"驻车制动状态不合理","来自CCVS1，CCVS2，或CCVS3的J1939驻车制动开关信号丢失或无效"
            ,"车速高于可编程阈值#1，这不是个系统错误。","发动机冷却液温度传感器2电路电压高","左前轮传感器断路",
            "系统程序错误","所有的CAN模块CANBUS数据传输错误","主卷泵压力端口故障下限溢出"};
}
