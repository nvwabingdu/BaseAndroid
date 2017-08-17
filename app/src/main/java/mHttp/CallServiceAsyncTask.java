package mHttp;

import android.content.Context;
import android.os.AsyncTask;

/**
 * Created by abc on 2015/10/30.
 */
public class CallServiceAsyncTask<P, S, T> extends AsyncTask<Void, Void, T> {
    private Context context;
    private String funcName;
    private byte[] dataArr;
    private CallBacks callBacks;

    public CallServiceAsyncTask(Context context, byte[] dataArr, String functioName, CallBacks callBacks) {
        this.context = context;
        this.dataArr = dataArr;
        this.funcName = functioName;
        this.callBacks = callBacks;
    }

    public void doAsyncTask(){
        this.execute();
    }

    @Override
    protected T doInBackground(Void... voids) {
        CallService callService = new CallService();
        T result = (T) callService.run(funcName, dataArr);
        return result;
    }

    @Override
    protected void onPostExecute(T t) {
        callBacks.OnResult(t);
        super.onPostExecute(t);
    }
}
