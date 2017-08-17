package mHttp;

import android.util.Log;

import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import mModel.GlobalModel;


/**
 * Created by abc on 2015/10/29.
 */
public class CallService {
//    private GlobalModel globalModel = GlobalModel.get_Instanst();
//    final String serverPath = globalModel.BaseUri;

    public static byte[] intToBytes2(int n){
        byte[] b = new byte[4];

        for(int i = 0;i < 4;i++)
        {
            b[i]=(byte)(n>>(24-i*8));

        }
        return b;
    }

//    public Map<String, byte[]> run(String functionName, byte[] dataArr){
//        JSONObject result = new JSONObject();
//        Map<String,byte[]> maps = new HashMap<String, byte[]>();
//        ByteArrayOutputStream baos = new ByteArrayOutputStream();
//        try {
//            URL url = new URL(GlobalModel.getInstance().imageUrl+functionName);
////            URL url = new URL(functionName);
//            Log.e("TGA",url+"==>url");
////            Log.e("TOKEN",GlobalModel.getInstance().X_Access_Token);
//            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
//            if(!GlobalModel.getInstance().X_Access_Token.equals("")) {
//                urlConnection.setRequestProperty("Authorization", GlobalModel.getInstance().X_Access_Token);
//            }
////            urlConnection.setRequestProperty("appVersion","1.0.30");
////            urlConnection.setRequestProperty("appId","com.kxkr.caipiao.hengtongcai");
////            urlConnection.setRequestProperty("deviceId",GlobalModel.getInstance().diviceId);
//            urlConnection.setRequestMethod("POST");
//            urlConnection.setReadTimeout(10000);
//            urlConnection.setConnectTimeout(10000);
//
//            urlConnection.setDoOutput(true);
//            urlConnection.setDoInput(true);
//            OutputStream os = urlConnection.getOutputStream();
//            os.write(dataArr);
////            os.write(dataArr.toString().getBytes());
//            os.flush();
//            maps.put("respondCode",intToBytes2(urlConnection.getResponseCode()));
//            Log.e("TGA","respondCode:"+urlConnection.getResponseCode());
//            if (urlConnection.getResponseCode() == 200){
//
////                String Authorization = urlConnection.getHeaderField("Authorization");
//                String applistVersion = urlConnection.getHeaderField("latestVersion");
//                String reviewVersion = urlConnection.getHeaderField("reviewVersion");
//                String appUrl = urlConnection.getHeaderField("appUrl");
//                if (appUrl != null) {
//                    BaseActivity.ApkUrl = appUrl;
//                }
//                Log.e("Authorization","Authorization:"+"applistVersion"+applistVersion+"reviewVersion"+reviewVersion);
////                if(Authorization != null) {
////                    GlobalModel.getInstance().X_Access_Token =  Authorization;
////                }
//
//                InputStream is = urlConnection.getInputStream();
//
//                int len = 0;
//                byte buffer[] = new byte[1024];
//                while ((len = is.read(buffer)) != -1){
//                    baos.write(buffer, 0, len);
//                }
//                is.close();
//                baos.close();
//                String resultStr  = new String(baos.toByteArray());
//                if (!resultStr.equals("")){
//                    result = new JSONObject(resultStr);
//                }
//            }
//            urlConnection.disconnect();
//        }catch (Exception e){
//            if (e != null){
//
//            }
//        }
//        maps.put("result",baos.toByteArray());
//        return maps;
//    }


}
