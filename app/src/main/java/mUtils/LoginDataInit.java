package mUtils;

import android.content.Context;
import android.util.Log;

import com.google.protobuf.ProtocolStringList;

import java.util.ArrayList;

import DataBase.OperateDB;
import Model.GlobalModel;
import Proto.Buycai;
import Proto.User;

/**
 * Created by zl on 2017/4/12.
 */

public class LoginDataInit {
    GlobalModel mGlobalModel = GlobalModel.getInstance();
    private Context context;
    public LoginDataInit() {
    }

    public LoginDataInit(Context context) {
        this.context = context;
    }

    /**
     * 清空登录信息
     */
    public void initData() {
        mGlobalModel.loginType="";
        mGlobalModel.openidWX="";//微信登录获取的access_token
//        mGlobalModel.access_token="";//微信登录获取的openid
//        mGlobalModel.openidQQ="";
        mGlobalModel.X_Access_Token="";//已登录session
        mGlobalModel.loginType = "";//登录方式;2:微信，1:QQ;3:手机号
        mGlobalModel.Count_Id=0;
        mGlobalModel.level=0;
        mGlobalModel.sex=0;
        mGlobalModel.exp=0;
        mGlobalModel.cai="--";
        mGlobalModel.kxd="";
        mGlobalModel.phoneNO="";//手机号
        mGlobalModel.nikeName="";//昵称
        mGlobalModel.realName="";//真实姓名
        mGlobalModel.image_icon="";//头像
        mGlobalModel.balance="--";//余额
        mGlobalModel.idno="";//身份证号码
        mGlobalModel.freeze="--";//冻结金额
        mGlobalModel.credits="";//积分
        mGlobalModel.freeze_cai="--";//彩金
        mGlobalModel.totle="--";
        mGlobalModel.mBackCards =null;
        mGlobalModel.bindqq="";//绑定QQ openid
        mGlobalModel.bindwx="";//绑定微信 openid
        mGlobalModel.flushType ="1";// 1,全部，2低频，3高频，4竞彩
        mGlobalModel.sscType="1";//1今天,2昨天,3前天
        mGlobalModel.gdType="1";//1今天,2昨天,3前天
        mGlobalModel.bjType="1";//1今天,2昨天,3前天
        mGlobalModel.mList = null;
        mGlobalModel.IsTrue = false;
        GlobalModel.getInstance().select = 1;
        OperateDB operateDB = new OperateDB(context);
        operateDB.deleteAll();
    }

    //设置用户信息
    public void setData (User.UserInfo userInfo) {
        mGlobalModel.Count_Id = userInfo.getAccountId();
        if (userInfo.getNickname() == null || userInfo.getNickname().equals("")) {
            mGlobalModel.nikeName = "  ";
        }else {
            mGlobalModel.nikeName = userInfo.getNickname();
        }

        mGlobalModel.image_icon = userInfo.getIcon();
        mGlobalModel.realName = userInfo.getRealname();
        if(userInfo.getBindqq() != null) {
            mGlobalModel.bindqq = userInfo.getBindqq();
        }
        if(userInfo.getBindwx() != null) {
            mGlobalModel.bindwx = userInfo.getBindwx();
        }

        mGlobalModel.phoneNO = userInfo.getBindphone();
        mGlobalModel.idno = userInfo.getIdno();
        mGlobalModel.sex = userInfo.getSex().getNumber();
        mGlobalModel.exp = userInfo.getExp();
        mGlobalModel.level = userInfo.getLevel();
        mGlobalModel.setPaypwd = userInfo.getPayPassword();
        mGlobalModel.setLoginPwd = userInfo.getLoginPassword();
        mGlobalModel.pay_open_password = userInfo.getPayOpenPassword();
        mGlobalModel.isDailyCheck = userInfo.getIsDailyCheck();
        if(userInfo.getInvitationCode() != null){
            mGlobalModel.YQM = userInfo.getInvitationCode();
        }
        mGlobalModel.YqmStatus=userInfo.getUserInviteStatus();

    }

    //设置购彩基本信息
    public void setIssueInfo(Buycai.BuycaiInfo info) {
        mGlobalModel.mIssueLists.clear();
        Buycai.SaleIssue current = info.getCurrent();
//        mGlobalModel.lottoryIssue = current.getIssue();
        Log.e("TGA", "issue:" + current.getIssue());
        mGlobalModel.Multiple = info.getMaxMultiple();
        ProtocolStringList list = info.getSaleListList();
        if (mGlobalModel.mIssueLists == null) {
            mGlobalModel.mIssueLists = new ArrayList<String>();
        }
        for (int i = 0; i < list.size(); i++) {
            mGlobalModel.mIssueLists.add(list.get(i));
        }
    }

    //购彩成功后清空信息
    public void initBuyCaiInfo() {
        mGlobalModel.lottoryIssue = "";
        mGlobalModel.Multiple = 0;
        mGlobalModel.mIssueLists.clear();
        mGlobalModel.isChase = false;
        mGlobalModel.mIntentPage = "";
        mGlobalModel.payToken = "";
//        AppManger.getAppManager().finishActivity(SsqSingleSureActivity.class);
//        AppManger.getAppManager().finishActivity(SsqBileSureActivity.class);
//        AppManger.getAppManager().finishActivity(DltBileSureActivity.class);
//        AppManger.getAppManager().finishActivity(DltSingleSureActivity.class);
//        AppManger.getAppManager().finishActivity(FcGroupSureActivity.class);
//        AppManger.getAppManager().finishActivity(FcZXSureActivity.class);
//        AppManger.getAppManager().finishActivity(CqSscSureActivity.class);
//        AppManger.getAppManager().finishActivity(BjSureActivity.class);
//        AppManger.getAppManager().finishActivity(GdSureActivity.class);
//        AppManger.getAppManager().finishActivity(ThreeSureActivity.class);
//        AppManger.getAppManager().finishActivity(FiveSureActivity.class);
    }
}
