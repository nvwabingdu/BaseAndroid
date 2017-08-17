package mUtils;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.drawable.ColorDrawable;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import com.google.protobuf.InvalidProtocolBufferException;
import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.tencent.tauth.Tencent;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import Bean.BackCard;
import CoreService.CallBacks;
import CoreService.CallServiceAsyncTask;
import Model.GlobalModel;
import MyView.PayPwdEditText;
import Proto.AppDevice;
import Proto.Base;
import Proto.Buycai;
import Proto.Gift;
import kxkr.mimilottery.com.AppReLogin;
import kxkr.mimilottery.com.HomeMenu.MainActivity;
import kxkr.mimilottery.com.R;
import kxkr.mimilottery.com.RegistAndRetrive.RegistCompleteActivity;
import kxkr.mimilottery.com.codeInvite.DialogBag;
import kxkr.mimilottery.com.codeInvite.DialogFen;
import kxkr.mimilottery.com.codeInvite.DialogPiao;
import kxkr.mimilottery.com.codeInvite.DialogPutPocket;
import kxkr.mimilottery.com.codeInvite.DialogTwo;


/**
 * Created by Administrator on 2016/11/24.
 */
public abstract class BaseActivity extends AppCompatActivity {

    public static String ApkUrl = "http://p.gdown.baidu.com/ca2346187701ffd47b013068b7258b19aacf6cc32bce2d8e56937067a661c973c3ee6ffa1896cac6a48aaf1363927feb84b5c1bcfe2078a5044e99a0580c5bc01b4d3dc8d00b58476a4f67f172bf164431b534dde22b4a6641f25616d5a4593a90c1613aa6442bdc926ccb113ad9445b1adc7817f75717766f8214bc6f60e115fa1989258f0f8acc2093102d7e6c0d3ea2f00196648f747e8d72b408a75a5482e4245c650917752a600132e8c7db5eebaf63dad4263118fa2dc4c423eca4f64ba1ec67691273b438dff2540b485d97c9ae4f1ad7760c8d6cdb6bfe9d9edca2b9";
    public Tencent mTencent;
    public IWXAPI WXapi;
    public SharedPreferences mPreferences;
    public Activity mContext;
    public Handler mPopHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
//            showPrizeCenterPopupWindow();
        }
    };

    private long fenNumber, piaoNumber;

    private DialogBag dialogBag;
    private DialogPutPocket dialogPutPocket;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        PushAgent.getInstance(this).onAppStart();
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
//                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(getLayoutResId());
        AppManger.getAppManager().addActivity(this);
        this.mContext = this;
        ViewGroup contentFrameLayout = (ViewGroup) findViewById(Window.ID_ANDROID_CONTENT);
        View parentView = contentFrameLayout.getChildAt(0);
        if (parentView != null && Build.VERSION.SDK_INT >= 14) {
            parentView.setFitsSystemWindows(true);
        }
        StatusBarCompat.compat(this,0xff000000);
        this.mTencent = Tencent.createInstance(Constants.QQApp_ID, getApplicationContext());
        WXapi = WXAPIFactory.createWXAPI(this, Constants.APP_ID, true);
        WXapi.registerApp(Constants.APP_ID);
        mPreferences = getSharedPreferences("Logininfo",MODE_PRIVATE);
        if(savedInstanceState != null) {
            GlobalModel.getInstance().X_Access_Token = savedInstanceState.getString("X_Access_Token");
            GlobalModel.getInstance().phoneNO = savedInstanceState.getString("phoneNO");
            GlobalModel.getInstance().nikeName = savedInstanceState.getString("nikeName");
            GlobalModel.getInstance().realName = savedInstanceState.getString("realName");
            GlobalModel.getInstance().cai = savedInstanceState.getString("cai");
            GlobalModel.getInstance().kxd = savedInstanceState.getString("kxd");
            GlobalModel.getInstance().image_icon = savedInstanceState.getString("image_icon");
            GlobalModel.getInstance().balance = savedInstanceState.getString("balance");
            GlobalModel.getInstance().idno = savedInstanceState.getString("idno");
            GlobalModel.getInstance().freeze = savedInstanceState.getString("freeze");
            GlobalModel.getInstance().credits = savedInstanceState.getString("credits");
            GlobalModel.getInstance().freeze_cai = savedInstanceState.getString("freeze_cai");
            GlobalModel.getInstance().totle = savedInstanceState.getString("totle");
            GlobalModel.getInstance().bindqq = savedInstanceState.getString("bindqq");
            GlobalModel.getInstance().bindwx = savedInstanceState.getString("bindwx");
            GlobalModel.getInstance().sex = savedInstanceState.getInt("sex");
            GlobalModel.getInstance().level = savedInstanceState.getInt("level");
            GlobalModel.getInstance().exp = savedInstanceState.getInt("exp");
            GlobalModel.getInstance().setPaypwd = savedInstanceState.getBoolean("setPaypwd");
            GlobalModel.getInstance().setLoginPwd = savedInstanceState.getBoolean("setLoginPwd");
            GlobalModel.getInstance().pay_open_password = savedInstanceState.getBoolean("pay_open_password");
            GlobalModel.getInstance().mBackCards = savedInstanceState.getParcelableArrayList("backinfo");
            GlobalModel.getInstance().YQM = savedInstanceState.getString("yqm");
            GlobalModel.getInstance().YqmStatus=savedInstanceState.getBoolean("YqmStatus");
            GlobalModel.getInstance().isDailyCheck=savedInstanceState.getBoolean("isDailyCheck");
            GlobalModel.getInstance().select=savedInstanceState.getInt("select");
            GlobalModel.getInstance().isMustUpdate = savedInstanceState.getBoolean("isMustUpdate");
            GlobalModel.getInstance().DeleteTime = savedInstanceState.getInt("deletetime");
            GlobalModel.getInstance().mEndTime = savedInstanceState.getLong("endtime");
            GlobalModel.getInstance().mIntentPage = savedInstanceState.getString("intentpage");
//            GlobalModel.getInstance().tempList= (ArrayList<OneGameBean>) savedInstanceState.getSerializable("tempList");
        }




//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            //5.0 透明状态栏
//            Window window = getWindow();
//            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
//            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
////            window.setStatusBarColor(Color.parseColor("#333333"));
//            window.setStatusBarColor(Color.TRANSPARENT);
//        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//            //4.4 透明状态栏
//            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//        }

after();

    }

    @Override
    protected void onResume() {
        super.onResume();


//        mPopHandler.sendEmptyMessageDelayed(1,2000);
        String asstoken = mPreferences.getString("asstoken",null);
        if(asstoken != null && GlobalModel.getInstance().X_Access_Token.equals("")) {
            GlobalModel.getInstance().X_Access_Token = asstoken;
        }
        if(GlobalModel.getInstance().diviceId.equals("")) {
            setUUID();
        }



    }

    public void showPrizeDialog(String name, String monry) {
        final MyPrizeDialog dialog = new MyPrizeDialog(this,name,monry);
        dialog.show();
        dialog.setClicklistener(new MyPrizeDialog.clickInferface() {
            @Override
            public void commit() {
                dialog.dismiss();
            }

            @Override
            public void close() {
                dialog.dismiss();
            }
        });
    }

    public void showNewUserDialog() {
        final NovicepacksDialog dialog = new NovicepacksDialog(this);
        dialog.show();
        dialog.setCanceledOnTouchOutside(false);
        dialog.setClicklistener(new NovicepacksDialog.clickInferface() {
            @Override
            public void commit() {
                dialog.dismiss();
                if (GlobalModel.getInstance().phoneNO.equals("")) {
                    Intent intent = new Intent(mContext, RegistCompleteActivity.class);
                    SharedPreferences preferences = getSharedPreferences("loginfrtgift",MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putBoolean("issect",true);
                    editor.commit();
                    startActivity(intent);
                }else {
                    getLift();
                }
            }

            @Override
            public void close() {
                dialog.dismiss();
            }
        });
    }

    public void getLift() {
        byte[] bytes = {0x12};
        CallServiceAsyncTask task = new CallServiceAsyncTask(this, bytes, "/user/phoneregistgift_draw", new CallBacks() {
            @Override
            public void OnResult(Object o) {
                if(o != null) {
                    Map<String,byte[]> result = (Map<String, byte[]>) o;
                    if(result.get("respondCode") == null) {

                        return;
                    }
                    if(Tool.byteToInt2(result.get("respondCode")) != 200) {

                        return;
                    }
                    ByteArrayInputStream input = new ByteArrayInputStream(result.get("result"));
                    try {
                        Base.Response zx = Base.Response.parseFrom(input);
                        if(zx.getCodeValue() == Error.RespCode.Success_VALUE) {
                            Gift.ActivityGiftPackage giftPackage = Gift.ActivityGiftPackage.parseFrom(zx.getResult());
                            List<Gift.GiftItem> itemlist = giftPackage.getListList();
                            giftPackage.getTitle();

                            for (int i =0;i<itemlist.size();i++) {
                                Log.e("TGA",itemlist.get(i).getValue()+itemlist.get(i).getType()+"===");
                                if (itemlist.get(i).getType() == 0) {
                                    piaoNumber += itemlist.get(i).getValue();
                                    Log.e("TGA","piao"+itemlist.get(i).getValue());
                                }else if (itemlist.get(i).getType() == 1) {
                                    fenNumber += itemlist.get(i).getValue();
                                    Log.e("TGA","fen"+itemlist.get(i).getValue());
                                }

                            }
                            dialogBag.show();
                            Log.e("TGA",itemlist.get(0).getValue()+"=="+itemlist.get(0).getType());
                            Log.e("TG",giftPackage.getListList().size()+"=="+fenNumber+"=="+giftPackage.getTitle());
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void OnFault(Object o) {

            }
        });

        task.doAsyncTask();
    }



    /**
     * 判断是否有权限
     *
     * @param permissions
     * @return
     */
    public boolean hasPermission(String... permissions) {
        for (String permission : permissions) {
            if (ContextCompat.checkSelfPermission(this, permission) != PackageManager.PERMISSION_GRANTED) {
                return false;
            }
        }
        return true;
    }

    /**
     * 申请权限方法
     *
     * @param code        返回码
     * @param permissions 具体权限
     */
    public void requestPermission(int code, String... permissions) {
        ActivityCompat.requestPermissions(this, permissions, code);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case Constants.WRITE_READ_EXTERNAL_CODE:
                doSDcardPermission();
                break;
            case Constants.CAMERA_CODE:
                takePhoto();
                break;
            case Constants.CALL_PHONE_CODE:
                callPhone();
                break;
            case Constants.SEM_MESSAGE_CODE:
                sendSEM();
                break;
            default:
                break;
        }
    }

    /**
     * 发送短信
     */
    public void sendSEM() {

    }

    /**
     * 打电话
     */
    public void callPhone() {


    }

    /**
     * 照相机，相册操作
     */
    public void takePhoto() {
    }

    /**
     * 读写操作
     */
    public void doSDcardPermission() {

    }

    /**
     * 返回当前Activity布局文件的id
     *
     * @return
     */
    abstract protected int getLayoutResId();

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("X_Access_Token", GlobalModel.getInstance().X_Access_Token);
        outState.putString("phoneNO", GlobalModel.getInstance().phoneNO);
        outState.putString("nikeName", GlobalModel.getInstance().nikeName);
        outState.putString("realName", GlobalModel.getInstance().realName);
        outState.putString("cai", GlobalModel.getInstance().cai);
        outState.putString("kxd", GlobalModel.getInstance().kxd);
        outState.putString("image_icon", GlobalModel.getInstance().image_icon);
        outState.putString("balance", GlobalModel.getInstance().balance);
        outState.putString("idno", GlobalModel.getInstance().idno);
        outState.putString("freeze", GlobalModel.getInstance().freeze);
        outState.putString("credits", GlobalModel.getInstance().credits);
        outState.putString("freeze_cai", GlobalModel.getInstance().freeze_cai);
        outState.putString("totle", GlobalModel.getInstance().totle);
        outState.putString("bindqq", GlobalModel.getInstance().bindqq);
        outState.putString("bindwx", GlobalModel.getInstance().bindwx);
        outState.putInt("sex", GlobalModel.getInstance().sex);
        outState.putInt("level", GlobalModel.getInstance().level);
        outState.putInt("exp", GlobalModel.getInstance().exp);
        outState.putBoolean("setPaypwd", GlobalModel.getInstance().setPaypwd);
        outState.putBoolean("setLoginPwd", GlobalModel.getInstance().setLoginPwd);
        outState.putBoolean("pay_open_password", GlobalModel.getInstance().pay_open_password);
        outState.putParcelableArrayList("backinfo", (ArrayList<BackCard>) GlobalModel.getInstance().mBackCards);
        outState.putString("yqm",GlobalModel.getInstance().YQM);
        outState.putBoolean("YqmStatus",GlobalModel.getInstance().YqmStatus);
        outState.putBoolean("isDailyCheck",GlobalModel.getInstance().isDailyCheck);
        outState.putInt("select",GlobalModel.getInstance().select);
        outState.putBoolean("isMustUpdate",GlobalModel.getInstance().isMustUpdate);
        outState.putInt("deletetime",GlobalModel.getInstance().DeleteTime);
        outState.putLong("endtime",GlobalModel.getInstance().mEndTime);
        outState.putString("intentpage",GlobalModel.getInstance().mIntentPage);
//        outState.putSerializable("tempList", GlobalModel.getInstance().tempList);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

    }
    public void loginforWX() {

        SendAuth.Req req = new SendAuth.Req();
        req.scope = "snsapi_userinfo";
        req.state = "MIMILottory";
        WXapi.sendReq(req);
        Log.d("WX","onClick");
    }

    /**
     * 中间弹出PopupWindow
     *
     *  设置PopupWindow以外部分有一中变暗的效果
     *
     */
    public void showPrizeCenterPopupWindow() {
//        if(hasWindowFocus()){
            View parent = ((ViewGroup) mContext.findViewById(android.R.id.content)).getChildAt(0);
            View contentView = LayoutInflater.from(mContext).inflate(R.layout.prize_dialog_style, null);
        
            final PopupWindow popupWindow = new PopupWindow(contentView, LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            popupWindow.setFocusable(true);
            popupWindow.setBackgroundDrawable(new ColorDrawable(0xff000000));
            // 设置PopupWindow以外部分的背景颜色  有一种变暗的效果
            final WindowManager.LayoutParams wlBackground = getWindow().getAttributes();
            wlBackground.alpha = 0.5f;      // 0.0 完全不透明,1.0完全透明
            getWindow().setAttributes(wlBackground);
            // 当PopupWindow消失时,恢复其为原来的颜色
            popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
                @Override
                public void onDismiss() {
                    wlBackground.alpha = 1.0f;
                    getWindow().setAttributes(wlBackground);
                }
            });
            //设置PopupWindow进入和退出动画
            popupWindow.setAnimationStyle(R.style.anim_popup_centerbar);
            // 设置PopupWindow显示在中间
//        popupWindow.showAsDropDown(view);
            popupWindow.showAtLocation(parent, Gravity.CENTER,0,0);

        }
//    }

    /**
     * 中间弹出PopupWindow
     *
     *  设置PopupWindow以外部分有一中变暗的效果
     * @param view  parent view
     */
    public void showCenterPopupWindow(View view) {
        View contentView = LayoutInflater.from(this).inflate(R.layout.dialog_pay_style, null);
        final PopupWindow popupWindow = new PopupWindow(contentView, LinearLayout.LayoutParams.WRAP_CONTENT, 440);

        ImageView iv = (ImageView) contentView.findViewById(R.id.pay_close);
        PayPwdEditText mEditText = (PayPwdEditText) contentView.findViewById(R.id.pay_pass);
        mEditText.initStyle(R.drawable.edit_back1, 6, 0.33f, R.color.pay_divier_view, R.color.pay_password, 30);
        mEditText.setOnTextFinishListener(new PayPwdEditText.OnTextFinishListener() {
            @Override
            public void onFinish(String str) {

            }
        });
        popupWindow.setFocusable(true);
        popupWindow.setBackgroundDrawable(new ColorDrawable(0x00000000));
        // 设置PopupWindow以外部分的背景颜色  有一种变暗的效果
        final WindowManager.LayoutParams wlBackground = getWindow().getAttributes();
        wlBackground.alpha = 0.5f;      // 0.0 完全不透明,1.0完全透明
        getWindow().setAttributes(wlBackground);
        // 当PopupWindow消失时,恢复其为原来的颜色
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                wlBackground.alpha = 1.0f;
                getWindow().setAttributes(wlBackground);
            }
        });
        //设置PopupWindow进入和退出动画
        popupWindow.setAnimationStyle(R.style.anim_popup_centerbar);
        // 设置PopupWindow显示在中间
        popupWindow.setSoftInputMode(PopupWindow.INPUT_METHOD_NEEDED);
        popupWindow.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        popupWindow.showAtLocation(view, Gravity.CENTER,0,0);
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        };

        iv.setOnClickListener(listener);
    }

    /**
     * 登录设置唯一ID
     */
    public String setUUID() {
        Log.e("TGA",android.os.Build.VERSION.SDK_INT+"===banbenhao=="+android.os.Build.MODEL+"=="+android.os.Build.VERSION.RELEASE);
        if (hasPermission(Manifest.permission.READ_PHONE_STATE)) {
            TelephonyManager manager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
            GlobalModel.getInstance().diviceId = manager.getDeviceId();
        }else {
            requestPermission(Constants.PHONE_STATE_CODE, Manifest.permission.READ_PHONE_STATE);
        }
        Log.e("TGA",GlobalModel.getInstance().diviceId);
        if(GlobalModel.getInstance().diviceId == null) {
            @SuppressLint("WifiManagerLeak") WifiManager wifiManager = (WifiManager) getSystemService(Context.WIFI_SERVICE);
            WifiInfo info = wifiManager.getConnectionInfo();
            GlobalModel.getInstance().diviceId =  info.getMacAddress();

        }
        Log.e("TGA",GlobalModel.getInstance().diviceId);
        if(GlobalModel.getInstance().diviceId == null) {
            GlobalModel.getInstance().diviceId = UUID.randomUUID().toString();
        }

        Log.e("TGA",GlobalModel.getInstance().diviceId);
        setIP();
        return GlobalModel.getInstance().diviceId;
    }

    /**
     * 登录设置唯一ID
     */
    public String setIP() {
            @SuppressLint("WifiManagerLeak") WifiManager wifiManager = (WifiManager) getSystemService(Context.WIFI_SERVICE);
            WifiInfo info = wifiManager.getConnectionInfo();
            GlobalModel.getInstance().diviceId =  info.getMacAddress();
        int ipAddress = info.getIpAddress();
        return intToIp(ipAddress);
    }

    /**
     * 转换ip
     * @param i
     * @return
     */
    private String intToIp(int i) {

        return (i & 0xFF ) + "." +
                ((i >> 8 ) & 0xFF) + "." +
                ((i >> 16 ) & 0xFF) + "." +
                ( i >> 24 & 0xFF) ;
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        AppManger.getAppManager().finishActivity(this);
    }

    public void startToLogin(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        startActivity(intent);
    }

    public String getWeek(long datetime) {
        String Week = "周";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");//也可将此值当参数传进来
        Date curDate = new Date(datetime);
        String pTime = format.format(curDate);
        Calendar c = Calendar.getInstance();
        try {
            c.setTime(format.parse(pTime));
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        switch(c.get(Calendar.DAY_OF_WEEK)){
            case 1:
                Week += "天";
                break;
            case 2:
                Week += "一";
                break;
            case 3:
                Week += "二";
                break;
            case 4:
                Week += "三";
                break;
            case 5:
                Week += "四";
                break;
            case 6:
                Week += "五";
                break;
            case 7:
                Week += "六";
                break;
            default:
                break;
        }
        return pTime+"  ("+Week+")";
    }
    public String getWeekByDateStr(String strDate)
    {
        int year = Integer.parseInt(strDate.substring(0, 4));
        int month = Integer.parseInt(strDate.substring(5, 7));
        int day = Integer.parseInt(strDate.substring(8, 10));
        String week = "周";
        Calendar c = Calendar.getInstance();

        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month - 1);
        c.set(Calendar.DAY_OF_MONTH, day);

        int weekIndex = c.get(Calendar.DAY_OF_WEEK);

        switch (weekIndex)
        {
            case 1:
                week += "天";
                break;
            case 2:
                week += "一";
                break;
            case 3:
                week += "二";
                break;
            case 4:
                week += "三";
                break;
            case 5:
                week += "四";
                break;
            case 6:
                week += "五";
                break;
            case 7:
                week += "六";
                break;
        }
        return strDate+"  ("+week+")";
    }

    public void getIssueList(String lottoryId) {
        Base.IntValue.Builder request = Base.IntValue.newBuilder();
        request.setValue(Integer.valueOf(lottoryId));
        Base.IntValue zx = request.build();
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        try {
            zx.writeTo(output);
        } catch (IOException e) {
            e.printStackTrace();
        }
        final byte[] bytes = output.toByteArray();
        CallServiceAsyncTask task = new CallServiceAsyncTask(this, bytes, "/buycai/info", new CallBacks() {
            @Override
            public void OnResult(Object o) {
                Map<String, byte[]> result = (Map<String, byte[]>) o;
                if (result.get("respondCode") == null || Tool.byteToInt2(result.get("respondCode")) != 200) {
                    Tool.showShortMessage(getApplicationContext(), "获取当前期号失败");
                    return;
                }
                try {
                    Base.Response response = Base.Response.parseFrom(result.get("result"));
                    if (response.getCodeValue() == Error.RespCode.Success_VALUE) {
                        Log.e("TGA", "success");
                        Buycai.BuycaiInfo info = Buycai.BuycaiInfo.parseFrom(response.getResult());
                       GlobalModel.getInstance().lottoryIssue = info.getCurrent().getIssue();
                        GlobalModel.getInstance().mEndTime = info.getCurrent().getEndTime();
                        LoginDataInit init = new LoginDataInit();
                        init.setIssueInfo(info);
                    } else {
                        Tool.showShortMessage(getApplicationContext(), response.getDesc());
                    }
                } catch (InvalidProtocolBufferException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void OnFault(Object o) {

            }
        });
        task.doAsyncTask();
    }



    private void after() {
        //包
        dialogBag = new DialogBag(this);
        dialogBag.setMyinterface(new DialogBag.Myinterface() {
            @Override
            public void gettag() {
                dialogBag.cancel();
                if (fenNumber != 0 && piaoNumber == 0) {
                    show("+" + fenNumber);
                } else if (piaoNumber != 0 && fenNumber == 0) {
                    show1("" + piaoNumber);
                } else {
                    show2("" + piaoNumber, "+" + fenNumber);
                }
            }
        });
        //收入囊中
        dialogPutPocket = new DialogPutPocket(this, "大礼包的积分或者购彩券，已装入您的账户。在个人中心可以查看！");
        dialogPutPocket.sethelpInterface(new DialogPutPocket.MyInterface() {
            @Override
            public void gettag() {
                dialogPutPocket.cancel();
                setInfo();
            }
        });
    }


    private void show(String xx) {
        final DialogFen dialogFen = new DialogFen(this, xx);
        dialogFen.show();
        dialogFen.setMyinterface(new DialogFen.Myinterface() {
            @Override
            public void gettag() {
                dialogFen.cancel();
                dialogPutPocket.show();
            }
        });
    }

    private void show1(String xx) {
        final DialogPiao pd = new DialogPiao(this, xx);
        pd.show();
        pd.setMyinterface(new DialogPiao.Myinterface() {
            @Override
            public void gettag() {
                pd.cancel();
                dialogPutPocket.show();
            }
        });
    }



    private void show2(String xx, String yy) {
        final DialogTwo two = new DialogTwo(this, xx, yy);
        two.show();
        two.setMyinterface(new DialogTwo.Myinterface() {
            @Override
            public void gettag() {
                two.cancel();
                dialogPutPocket.show();
            }
        });
    }
    public void setInfo() {
        SharedPreferences preferences = getSharedPreferences("loginfrtgift",MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean("issect",false);
        editor.commit();
    }

    public void setReloginDialog() {
        AppReLogin reLogin = new AppReLogin(this);
        reLogin.ShowUpdateDialog();
    }

    public void setDivice(String url) {
        AppDevice.Device.Builder divice = AppDevice.Device.newBuilder();
        divice.setAppId(GlobalModel.getInstance().AppId);
        divice.setAppVersion(GlobalModel.getInstance().AppVersion);
        divice.setOs("Android");
        divice.setModel(android.os.Build.MODEL);
        divice.setId(setUUID());
        divice.setOsVersion(android.os.Build.VERSION.RELEASE);
//        divice.setIp(setIP());
        AppDevice.Device devices = divice.build();
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        try {
            devices.writeTo(output);
        } catch (IOException e) {
            e.printStackTrace();
        }
        final byte[] bytes = output.toByteArray();
        CallServiceAsyncTask task = new CallServiceAsyncTask(this, bytes, url, new CallBacks() {
            @Override
            public void OnResult(Object o) {

            }

            @Override
            public void OnFault(Object o) {

            }
        });

        task.doAsyncTask();
    }

    /**
     * 程序是否在前台运行
     * @return
     */
    public boolean isAppOnForeground() {
        // Returns a list of application processes that are running on the device
        ActivityManager activityManager;
        String packageName;
        activityManager = (ActivityManager) this.getSystemService(Context.ACTIVITY_SERVICE);
        packageName = this.getPackageName();
        List<ActivityManager.RunningAppProcessInfo> appProcesses = activityManager.getRunningAppProcesses();
        if (appProcesses == null) return false;

        for (ActivityManager.RunningAppProcessInfo appProcess : appProcesses) {
            // The name of the process that this object is associated with.
            if (appProcess.processName.equals(packageName)
                    && appProcess.importance == ActivityManager.RunningAppProcessInfo.IMPORTANCE_FOREGROUND) {
                return true;
            }
        }

        return false;
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (!isAppOnForeground()) {
            setDivice("/stats/stop");
        }
    }
}
