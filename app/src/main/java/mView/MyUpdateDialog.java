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


public class MyUpdateDialog extends Dialog {
	private Context context;
	private String title;
	private clickInferface clickListenerInterface;
	private TextView desc;
	private TextView mSure,mcancle;
	private int colorbg;

	public MyUpdateDialog(Context context, String title, int color) {
		super(context,R.style.MyDialog);
		this.context = context;
		this.title  = title;
		this.colorbg = color;
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
		setContentView(R.layout.apkupdate_dialog);
		this.desc = (TextView) findViewById(R.id.update_des_tv);
		this.mSure = (TextView) findViewById(R.id.update_sure);
		this.mcancle = (TextView) findViewById(R.id.update_cancle);
		this.desc.setText(title);
		this.mcancle.setBackgroundColor(colorbg);

		mSure.setOnClickListener(new cliclListener());
		mcancle.setOnClickListener(new cliclListener());
		Window dialogWindow = getWindow();
		WindowManager.LayoutParams lp = dialogWindow.getAttributes();
		dialogWindow.setGravity(Gravity.CENTER);
		DisplayMetrics d = context.getResources().getDisplayMetrics();
		dialogWindow.setAttributes(lp);
	}

	public interface clickInferface {
		public void commit();
		public void close();
	}

	private class cliclListener implements View.OnClickListener{

		@Override
		public void onClick(View v) {
			switch (v.getId()) {
				case R.id.update_sure:
					clickListenerInterface.commit();
					break;
				case R.id.update_cancle:
					clickListenerInterface.close();
					break;
			}
		}
	}
}
