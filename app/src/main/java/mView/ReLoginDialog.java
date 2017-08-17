package mView;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import kxkr.mimilottery.com.R;


public class ReLoginDialog extends Dialog {
	private Context context;
//	private String title;
	private clickInferface clickListenerInterface;
	private TextView desc;
	private TextView mSure,mcancle;
	private int colorbg;
	private String title;
	private String body;
	private TextView mTitleTv,mBodyTv;

	public ReLoginDialog(Context context, String title, String body) {
		super(context,R.style.MyDialog);
		this.context = context;
		this.title = title;
		this.body = body;
	}

	public void setClicklistener(clickInferface clickListenerInterface) {
		       this.clickListenerInterface = clickListenerInterface;
	    }

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		init();
	}

	private void init() {
		setContentView(R.layout.relogin_dialog);
		this.mSure = (TextView) findViewById(R.id.relogin_cancle);
		this.mcancle = (TextView) findViewById(R.id.relogin_sure);
		this.mTitleTv = (TextView) findViewById(R.id.update_title);
		this.mBodyTv = (TextView) findViewById(R.id.update_des_tv);
		mSure.setOnClickListener(new cliclListener());
		mcancle.setOnClickListener(new cliclListener());
		Window dialogWindow = getWindow();
		WindowManager.LayoutParams lp = dialogWindow.getAttributes();
		dialogWindow.setGravity(Gravity.CENTER);
		DisplayMetrics d = context.getResources().getDisplayMetrics();
		dialogWindow.setAttributes(lp);
		this.mTitleTv.setText(title);
		this.mBodyTv.setText(body);
	}

	public interface clickInferface {
		public void commit();
		public void close();
	}

	private class cliclListener implements View.OnClickListener{

		@Override
		public void onClick(View v) {
			switch (v.getId()) {
				case R.id.relogin_sure:
					clickListenerInterface.commit();
					break;
				case R.id.relogin_cancle:
					clickListenerInterface.close();
					break;
			}
		}
	}
}
