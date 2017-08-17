package mUtils;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import kxkr.mimilottery.com.R;


public class NovicepacksDialog extends Dialog {
	private Context context;
	private Button mOpen;
	private clickInferface clickListenerInterface;
	private ImageView mClose;

	public NovicepacksDialog(Context context) {
		super(context,R.style.MyDialog);
		this.context = context;
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
		setContentView(R.layout.novice_packs_style);
		this.mOpen = (Button) findViewById(R.id.newb_open);
		this.mClose = (ImageView) findViewById(R.id.newb_close_iv);

		mOpen.setOnClickListener(new cliclListener());
		mClose.setOnClickListener(new cliclListener());
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
				case R.id.newb_open:
					clickListenerInterface.commit();
					break;
				case R.id.newb_close_iv:
					clickListenerInterface.close();
					break;
			}
		}
	}
}
