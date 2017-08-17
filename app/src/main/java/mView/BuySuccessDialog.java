package mView;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import kxkr.mimilottery.com.R;


public class BuySuccessDialog extends Dialog {
	private Context context;
	private Button sure;
	private String money;
	private String orderInfo;
	private TextView tv;
	private Button see;
	private clickInferface clickListenerInterface;
	private TextView orderNo;

	public BuySuccessDialog(Context context, String money, String no) {
		super(context,R.style.MyDialog);
		this.context = context;
		this.money = money;
		this.orderInfo = no;
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
		setContentView(R.layout.buy_success_dialog);
		this.sure = (Button) findViewById(R.id.buy_success_btn);
		this.tv = (TextView) findViewById(R.id.buy_money_tv);
		this.see = (Button) findViewById(R.id.to_see_order);
		this.orderNo = (TextView) findViewById(R.id.buy_order_info_tv);
		this.tv.setText(money);
		this.orderNo.setText(orderInfo);
		sure.setOnClickListener(new cliclListener());
		see.setOnClickListener(new cliclListener());

		Window dialogWindow = getWindow();
		WindowManager.LayoutParams lp = dialogWindow.getAttributes();
		dialogWindow.setGravity(Gravity.CENTER);
		DisplayMetrics d = context.getResources().getDisplayMetrics();
		dialogWindow.setAttributes(lp);
	}

	public interface clickInferface {
		public void commit();
		public void toOrderInfo();
	}

	private class cliclListener implements View.OnClickListener{

		@Override
		public void onClick(View v) {
			switch (v.getId()) {
				case R.id.buy_success_btn:
					clickListenerInterface.commit();
					break;
				case R.id.to_see_order:
					clickListenerInterface.toOrderInfo();
					break;
			}
		}
	}
}
