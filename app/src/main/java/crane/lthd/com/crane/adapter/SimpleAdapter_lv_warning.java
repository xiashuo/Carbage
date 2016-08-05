package crane.lthd.com.crane.adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.SimpleAdapter;

import java.util.List;
import java.util.Map;

import crane.lthd.com.crane.R;
/**
 * Created by xs on 2016/7/13.
 */
public class SimpleAdapter_lv_warning extends SimpleAdapter {
    public int flag=0;
    private List<? extends Map<String, ?>> list;
    private Context mcontext;
    public SimpleAdapter_lv_warning(Context context, List<? extends Map<String, ?>> data, int resource, String[] from, int[] to) {
        super(context, data, resource, from, to);
        list=data;
        mcontext=context;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        convertView=null;
        convertView=super.getView(position, convertView, parent);
        if (position==0&&flag==0)
            convertView.setBackgroundResource(R.color.selected);
        return convertView;
    }
}
