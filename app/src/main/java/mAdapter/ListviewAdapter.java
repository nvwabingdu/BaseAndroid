package mAdapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by wangqi on 2017/6/29.
 */

public class ListviewAdapter extends BaseAdapter {
//    private ArrayList<Bean> list;
    private Context context;
//    private Activity mActivity;

//    public ListviewAdapter(ArrayList<ChooseBean> list, Context context) {
//        this.list = list;
//        this.context = context;
//        mActivity = context;
//    }

    @Override
    public int getCount() {
//        return list.size();
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    class MyHolder {
        TextView name;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final MyHolder holder;
        if (convertView == null) {
            holder = new MyHolder();
//            convertView = LayoutInflater.from(context).inflate(R.layout.布局, null);
            //找id
            convertView.setTag(holder);
        } else {
            holder = (MyHolder) convertView.getTag();
        }

        return convertView;
    }


    //回调    mInterface.method();
    Interface mInterface;

    interface Interface {
        void method();
    }

    public void GetInterface(Interface mInterface) {
        this.mInterface = mInterface;
    }
}