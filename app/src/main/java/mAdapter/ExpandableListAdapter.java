package mAdapter;

//import android.content.Context;
//import android.graphics.Bitmap;
//import android.graphics.BitmapShader;
//import android.graphics.Canvas;
//import android.graphics.Paint;
//import android.graphics.drawable.Drawable;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.BaseExpandableListAdapter;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import com.squareup.picasso.Picasso;
//import com.squareup.picasso.Transformation;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//
//import kxkr.mimilottery.com.R;
//import kxkr.mimilottery.com.RaceColorFootball.bean.MainBean;
//import kxkr.mimilottery.com.RaceColorFootball.bean.OneGameBean;

/**
 * Created by wangqi on 2017/6/6.
 */

//public class ExpandableListAdapter extends BaseExpandableListAdapter {
//    private Context context;
//    private Map<MainBean, List<OneGameBean>> data;
//    private ArrayList<MainBean> mainlist;
//
//    public ExpandableListAdapter(Context context, Map<MainBean, List<OneGameBean>> data, ArrayList<MainBean> mainlist) {
//        this.context = context;
//        this.data = data;
//        this.mainlist = mainlist;
//    }
//
//    //  获得某个父项的某个子项
//    @Override
//    public Object getChild(int parentPos, int childPos) {
//        return data.get(mainlist.get(parentPos)).get(childPos);
//    }
//
//    //  获得父项的数量
//    @Override
//    public int getGroupCount() {
//        return data.size();
//    }
//
//    //  获得某个父项的子项数目
//    @Override
//    public int getChildrenCount(int parentPos) {
//        return data.get(mainlist.get(parentPos)).size();
//    }
//
//    //  获得某个父项
//    @Override
//    public Object getGroup(int parentPos) {
//        return data.get(mainlist.get(parentPos));
//    }
//
//    //  获得某个父项的id
//    @Override
//    public long getGroupId(int parentPos) {
//        return parentPos;
//    }
//
//    //  获得某个父项的某个子项的id
//    @Override
//    public long getChildId(int parentPos, int childPos) {
//        return childPos;
//    }
//
//    //  按函数的名字来理解应该是是否具有稳定的id，这个方法目前一直都是返回false，没有去改动过
//    @Override
//    public boolean hasStableIds() {
//        return false;
//    }
//
//    //  获得父项显示的view
//    @Override
//    public View getGroupView(int parentPos, boolean b, View view, ViewGroup viewGroup) {
//        if (view == null) {
//            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//            view = inflater.inflate(R.layout.football_time_item, null);
//        }
//        view.setTag(R.layout.football_time_item, parentPos);
//        view.setTag(R.layout.football_item_spf, -1);
//
//        TextView time = (TextView) view.findViewById(R.id.football_time_item_tv1);
//        TextView week = (TextView) view.findViewById(R.id.football_time_item_tv2);
//        TextView session = (TextView) view.findViewById(R.id.football_time_item_tv3);
//
//        //父布局time相关
//        time.setText(mainlist.get(parentPos).getDay());
//        week.setText(mainlist.get(parentPos).getWeek());
//        session.setText(mainlist.get(parentPos).getSsesion());
//
//
//        //判断isExpanded就可以控制是按下还是关闭，同时更换图片
//        ImageView parentImageViw = (ImageView) view.findViewById(R.id.football_time_item_img4);
//        if (b) {
//            parentImageViw.setBackgroundResource(R.drawable.smg_down);
//        } else {
//            parentImageViw.setBackgroundResource(R.drawable.smg_up);
//        }
//
//        return view;
//    }
//
//    //  获得子项显示的view
//
//    View winlayout;
//    View drawlayout;
//    View loselayout;
//
//    TextView win;
//    TextView draw;
//    TextView lose;
//
//    TextView winNum;
//    TextView drawNum;
//    TextView loseNum;
//    @Override
//    public View getChildView(final int parentPos, final int childPos, boolean b, View view, ViewGroup viewGroup) {
//        if (view == null) {
//            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//            view = inflater.inflate(R.layout.football_item_spf, null);
//        }
//        view.setTag(R.layout.football_time_item, parentPos);
//        view.setTag(R.layout.football_item_spf, childPos);
//        //胜平负相关
//        TextView week = (TextView) view.findViewById(R.id.spf_week);
//        TextView rank = (TextView) view.findViewById(R.id.spf_paiming);
//        TextView league = (TextView) view.findViewById(R.id.spf_liansai);
//        TextView time = (TextView) view.findViewById(R.id.spf_time);
//        TextView zhuname = (TextView) view.findViewById(R.id.spf_zhuname);
//        TextView kename = (TextView) view.findViewById(R.id.spf_kename);
//        ImageView zhuicon = (ImageView) view.findViewById(R.id.spf_zhuicon);
//        ImageView keicon = (ImageView) view.findViewById(R.id.spf_keicon);
//
//        week.setText(data.get(mainlist.get(parentPos)).get(childPos).getWeek());
//        rank.setText(data.get(mainlist.get(parentPos)).get(childPos).getSession());
//        league.setText(data.get(mainlist.get(parentPos)).get(childPos).getLEAGUE());
//        time.setText(data.get(mainlist.get(parentPos)).get(childPos).getTime());
//
//        zhuname.setText(data.get(mainlist.get(parentPos)).get(childPos).getZhuName());
//        kename.setText(data.get(mainlist.get(parentPos)).get(childPos).getKeName());
//
//        Picasso.with(context)
//                    .load(data.get(mainlist.get(parentPos)).get(childPos).getZhuIcon())
//                    .transform(new CircleTransform())
//                    .into(zhuicon);
//
//        Picasso.with(context)
//                .load(data.get(mainlist.get(parentPos)).get(childPos).getKeIcon())
//                .transform(new CircleTransform())
//                .into(keicon);
//
//        //下截
//
//        View hideview=view.findViewById(R.id.spf_view);
//        if(childPos==data.get(mainlist.get(parentPos)).size()-1){
//            hideview.setVisibility(View.GONE);
//        }else {
//            hideview.setVisibility(View.VISIBLE);
//        }
//        winlayout = view.findViewById(R.id.spf_layout_win);
//        drawlayout = view.findViewById(R.id.spf_layout_draw);
//        loselayout = view.findViewById(R.id.spf_layout_lose);
//        win = (TextView) view.findViewById(R.id.spf_win);
//        draw = (TextView) view.findViewById(R.id.spf_draw);
//        lose = (TextView) view.findViewById(R.id.spf_lose);
//        winNum = (TextView) view.findViewById(R.id.spf_winNum);
//        drawNum = (TextView) view.findViewById(R.id.spf_drawNum);
//        loseNum = (TextView) view.findViewById(R.id.spf_loseNum);
//
//        winNum.setText(data.get(mainlist.get(parentPos)).get(childPos).getsTv1());
//        drawNum.setText(data.get(mainlist.get(parentPos)).get(childPos).getsTv2());
//        loseNum.setText(data.get(mainlist.get(parentPos)).get(childPos).getsTv3());
//
//
//        winlayout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (data.get(mainlist.get(parentPos)).get(childPos).issFlag1()) {
//                    turnGray(winlayout, win, winNum);
//                    data.get(mainlist.get(parentPos)).get(childPos).setsFlag1(false);
//                    data.get(mainlist.get(parentPos)).get(childPos).setHhgg_sum(data.get(mainlist.get(parentPos)).get(childPos).getHhgg_sum() - 1);
//                } else {
//                    turnRed(winlayout, win, winNum);
//                    data.get(mainlist.get(parentPos)).get(childPos).setsFlag1(true);
//                    data.get(mainlist.get(parentPos)).get(childPos).setHhgg_sum(data.get(mainlist.get(parentPos)).get(childPos).getHhgg_sum() + 1);
//                }
//                notifyDataSetChanged();
//                if (data.get(mainlist.get(parentPos)).get(childPos).getHhgg_sum() == 0) {
//                    data.get(mainlist.get(parentPos)).get(childPos).setGame_sum(0);
//                } else {
//                    data.get(mainlist.get(parentPos)).get(childPos).setGame_sum(1);
//                }
//                jiekou.change();
//            }
//        });
//
//        drawlayout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (data.get(mainlist.get(parentPos)).get(childPos).issFlag2()) {
//                    turnGray(drawlayout, draw, drawNum);
//                    data.get(mainlist.get(parentPos)).get(childPos).setsFlag2(false);
//                    data.get(mainlist.get(parentPos)).get(childPos).setHhgg_sum(data.get(mainlist.get(parentPos)).get(childPos).getHhgg_sum() - 1);
//                } else {
//                    turnRed(drawlayout, draw, drawNum);
//                    data.get(mainlist.get(parentPos)).get(childPos).setsFlag2(true);
//                    data.get(mainlist.get(parentPos)).get(childPos).setHhgg_sum(data.get(mainlist.get(parentPos)).get(childPos).getHhgg_sum() + 1);
//                }
//                notifyDataSetChanged();
//                if (data.get(mainlist.get(parentPos)).get(childPos).getHhgg_sum() == 0) {
//                    data.get(mainlist.get(parentPos)).get(childPos).setGame_sum(0);
//                } else {
//                    data.get(mainlist.get(parentPos)).get(childPos).setGame_sum(1);
//                }
//                jiekou.change();
//            }
//        });
//        loselayout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (data.get(mainlist.get(parentPos)).get(childPos).issFlag3()) {
//                    turnGray(loselayout, lose, loseNum);
//                    data.get(mainlist.get(parentPos)).get(childPos).setsFlag3(false);
//                    data.get(mainlist.get(parentPos)).get(childPos).setHhgg_sum(data.get(mainlist.get(parentPos)).get(childPos).getHhgg_sum() - 1);
//                } else {
//                    turnRed(loselayout, lose, loseNum);
//                    data.get(mainlist.get(parentPos)).get(childPos).setsFlag3(true);
//                    data.get(mainlist.get(parentPos)).get(childPos).setHhgg_sum(data.get(mainlist.get(parentPos)).get(childPos).getHhgg_sum() + 1);
//                }
//                notifyDataSetChanged();
//                if (data.get(mainlist.get(parentPos)).get(childPos).getHhgg_sum() == 0) {
//                    data.get(mainlist.get(parentPos)).get(childPos).setGame_sum(0);
//                } else {
//                    data.get(mainlist.get(parentPos)).get(childPos).setGame_sum(1);
//                }
//                jiekou.change();
//            }
//        });
//        //控件颜色的变化
//        initColor(parentPos, childPos);
//        return view;
//    }
//
//    //控件颜色改变
//    private void initColor(int parentPos, int childPos) {
//        if (data.get(mainlist.get(parentPos)).get(childPos).issFlag1()) {
//            turnRed(winlayout, win, winNum);
//        } else {
//            turnGray(winlayout, win, winNum);
//        }
//        if (data.get(mainlist.get(parentPos)).get(childPos).issFlag2()) {
//            turnRed(drawlayout, draw, drawNum);
//        } else {
//            turnGray(drawlayout, draw, drawNum);
//        }
//        if (data.get(mainlist.get(parentPos)).get(childPos).issFlag3()) {
//            turnRed(loselayout, lose, loseNum);
//        } else {
//            turnGray(loselayout, lose, loseNum);
//        }
//    }
//
//    //  子项是否可选中，如果需要设置子项的点击事件，需要返回true
//    @Override
//    public boolean isChildSelectable(int i, int i1) {
//        return true;
//    }
//
//    //变色
//    Drawable drawable;
//    Drawable drawable1;
//
//    public boolean turnRed(View v, TextView tv1, TextView tv2) {
//        drawable = context.getResources().getDrawable(R.drawable.football_trunred);
//        drawable1 = context.getResources().getDrawable(R.drawable.football_bj2);
//        v.setBackground(drawable);
//        tv1.setTextColor(0xffffffff);
//        tv2.setTextColor(0xffffffff);
//        return true;
//    }
//
//    public boolean turnGray(View v, TextView tv1, TextView tv2) {
//        drawable = context.getResources().getDrawable(R.drawable.football_trunred);
//        drawable1 = context.getResources().getDrawable(R.drawable.football_bj2);
//        v.setBackground(drawable1);
//        tv1.setTextColor(0xff333333);
//        tv2.setTextColor(0xff888888);
//        return true;
//    }
//
//
//    public class CircleTransform implements Transformation {
//
//        @Override
//        public Bitmap transform(Bitmap source) {
//            int size = Math.min(source.getWidth(), source.getHeight());
//
//            int x = (source.getWidth() - size) / 2;
//            int y = (source.getHeight() - size) / 2;
//
//            Bitmap squaredBitmap = Bitmap.createBitmap(source, x, y, size, size);
//            if (squaredBitmap != source) {
//                source.recycle();
//            }
//
//            Bitmap bitmap = Bitmap.createBitmap(size, size, source.getConfig() != null
//                    ? source.getConfig() : Bitmap.Config.ARGB_8888);
//
//            Canvas canvas = new Canvas(bitmap);
//            Paint paint = new Paint();
//            BitmapShader shader = new BitmapShader(squaredBitmap,
//                    BitmapShader.TileMode.CLAMP, BitmapShader.TileMode.CLAMP);
//            paint.setShader(shader);
//            paint.setAntiAlias(true);
//
//            float r = size / 2f;
//            canvas.drawCircle(r, r, r, paint);
//
//            squaredBitmap.recycle();
//            return bitmap;
//        }
//
//        @Override
//        public String key() {
//            return "circle";
//        }
//    }
//    //回调
//    SpfJiekou jiekou;
//
//    public interface SpfJiekou {
//        void change();
//    }
//
//    public void GetSpfJiekou(SpfJiekou jiekou) {
//        this.jiekou = jiekou;
//    }
//}
