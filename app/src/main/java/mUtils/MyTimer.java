package mUtils;

import android.app.Activity;
import android.os.CountDownTimer;
import android.text.Spannable;
import android.text.SpannableString;
import android.widget.Button;

public class MyTimer extends CountDownTimer {

	private Button btn;
	private Activity mActivity;
	public MyTimer(Activity mActivity, long millisInFuture, long countDownInterval, Button btn) {
		super(millisInFuture, countDownInterval);
		// TODO Auto-generated constructor stub
		this.btn = btn;
		this.mActivity = mActivity;

	}

	@Override
	public void onTick(long millisUntilFinished) {
		// TODO Auto-generated method stub
		//设置按钮为不可点击
		btn.setClickable(false);

		btn.setText(""+millisUntilFinished / 1000+" S");//倒计时

		Spannable span = new SpannableString(btn.getText().toString());
		btn.setText(span);

	}

	@Override
	public void onFinish() {
//		btn.setVisibility(View.VISIBLE);
		// TODO Auto-generated method stub
		btn.setText("验证码");
		btn.setClickable(true);//设置按钮为可点击
	}

	
}
