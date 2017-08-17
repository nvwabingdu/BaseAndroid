/**
 * 
 */
package mUtils;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.util.Log;
import android.webkit.HttpAuthHandler;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import kxkr.mimilottery.com.R;

/**
 * @author Administrator
 *
 */
public class WebViewClientSSL extends WebViewClient {
    private final String TAG = "WebViewClientSSL";
    private Context mContext;
    private Dialog pd;
    public WebViewClientSSL(Context ctx) {
        this.mContext = ctx;
        pd = new Dialog(ctx, R.style.new_circle_progress_loading);
        pd.setContentView(R.layout.layout_progressbar_loading);
    }

    @Override
    public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
        Log.e(TAG, "onReceivedError ： " + description);
//        super.onReceivedError(view, errorCode, description, failingUrl);
//        view.loadUrl(GlobalModel.getInstance().playUrl);
    }

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        view.loadUrl(url);
        return true;
    }

    @Override
    public void onPageFinished(WebView view, String url) {
        super.onPageFinished(view, url);
        pd.dismiss();
    }

    @Override
    public void onPageStarted(WebView view, String url, Bitmap favicon) {
        super.onPageStarted(view, url, favicon);
        TextView textView = (TextView) pd.findViewById(R.id.emptyView);
        textView.setText("页面加载中......");
        pd.show();
    }

    //    @Override
//    public void onReceivedClientCertRequest(WebView view, ClientCertRequestHandler handler, String host_and_port) {
//        Log.e(TAG, "onReceivedClientCertRequest ： " + host_and_port);
//        if ((null != AppConfig.mPrivateKey)
//                && ((null != AppConfig.mX509Certificates) && (AppConfig.mX509Certificates.length != 0))) {
//            handler.proceed(AppConfig.mPrivateKey, AppConfig.mX509Certificates);
//        } else {
//            handler.cancel();
//        }
//    }

    @Override
    public void onReceivedHttpAuthRequest(WebView view, HttpAuthHandler handler, String host, String realm) {
        if ((null != AppConfig.mPrivateKey)
                && ((null != AppConfig.mX509Certificates) && (AppConfig.mX509Certificates.length != 0))) {

            handler.proceed(String.valueOf(AppConfig.mPrivateKey), String.valueOf(AppConfig.mX509Certificates));
        } else {
            handler.cancel();
        }
    }

    @Override
    public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
        Log.e(TAG, "onReceivedSslError ： ");
        //handler.cancel();
        handler.proceed();
    }
}
