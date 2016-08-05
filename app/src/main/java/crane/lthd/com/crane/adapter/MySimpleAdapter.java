package crane.lthd.com.crane.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.List;
import java.util.Map;

import crane.lthd.com.crane.R;

/**
 * Created by xs on 2016/7/13.
 */
public class MySimpleAdapter extends SimpleAdapter {
    public boolean flag=false;
    private ImageButton ib_delete;
    private List<? extends Map<String, ?>> list;
    private Context mcontext;
    public MySimpleAdapter(Context context, List<? extends Map<String, ?>> data, int resource, String[] from, int[] to) {
        super(context, data, resource, from, to);
        list=data;
        mcontext=context;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        convertView=super.getView(position, convertView, parent);
        CheckBox cb= (CheckBox) convertView.findViewById(R.id.checkbox1);
        cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                flag=true;
            }
        });
        return convertView;
    }
}
