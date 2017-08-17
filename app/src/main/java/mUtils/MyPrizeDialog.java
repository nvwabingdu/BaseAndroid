package mUtils;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import kxkr.mimilottery.com.R;


public class MyPrizeDialog extends Dialog {
	private Context context;
	private String title;
	private String type;
	private String body;
	private Button sure;
	private ImageView close;
	private TextView mTypeTv,mAmountTv;
	private clickInferface clickListenerInterface;
	private ImageView mImageView;

	public MyPrizeDialog(Context context, String type, String body) {
		super(context,R.style.MyDialog);
		this.context = context;
		this.type = type;
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
		setContentView(R.layout.prize_dialog_style);
		this.mAmountTv = (TextView) findViewById(R.id.prize_amount);
		this.mTypeTv = (TextView) findViewById(R.id.prize_type_tv);
		this.sure = (Button) findViewById(R.id.prize_btn);
		this.close = (ImageView) findViewById(R.id.prize_close);
		this.mImageView = (ImageView) findViewById(R.id.light_iv);
		this.mAmountTv.setText(body);
		this.mTypeTv.setText(type);
		Animation operatingAnim = AnimationUtils.loadAnimation(context, R.anim.light_rotation_anim);
		LinearInterpolator lin = new LinearInterpolator();
		operatingAnim.setInterpolator(lin);
		if(operatingAnim!=null){
			mImageView.startAnimation(operatingAnim);
		}

		sure.setOnClickListener(new cliclListener());
		close.setOnClickListener(new cliclListener());
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
				case R.id.prize_btn:
					clickListenerInterface.commit();
					break;
				case R.id.prize_close:
					clickListenerInterface.close();
					break;
			}
		}
	}
}
