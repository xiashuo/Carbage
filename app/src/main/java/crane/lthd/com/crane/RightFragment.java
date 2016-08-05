package crane.lthd.com.crane;
import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class RightFragment extends Fragment implements ControlFootActivity.setDangwei
,XuanjiaActivity.setDangwei{
    private TextView tv_dangwei;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_right, container, false);
        initView(view);
        return view;
    }
    private void initView(View view) {
        tv_dangwei= (TextView) view.findViewById(R.id.tv_dangwei);
    }
    public void setDangwei(int flag){
        switch (flag){
            case 0:
                tv_dangwei.setText("N");
                break;
            case 1:
                tv_dangwei.setText("PN");
                break;
        }
    }

    @Override
    public void setText(int flag) {
        setDangwei(flag);
    }
}
