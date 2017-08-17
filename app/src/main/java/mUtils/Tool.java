package mUtils;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.media.ExifInterface;
import android.os.Handler;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import kxkr.mimilottery.com.ArrangeThreeAndFive.FiveSureActivity;
import kxkr.mimilottery.com.ArrangeThreeAndFive.ThreeSureActivity;
import kxkr.mimilottery.com.BuyLottory.BjSureActivity;
import kxkr.mimilottery.com.BuyLottory.CqSscSureActivity;
import kxkr.mimilottery.com.BuyLottory.DltBileSureActivity;
import kxkr.mimilottery.com.BuyLottory.DltSingleSureActivity;
import kxkr.mimilottery.com.BuyLottory.FcGroupSureActivity;
import kxkr.mimilottery.com.BuyLottory.FcZXSureActivity;
import kxkr.mimilottery.com.BuyLottory.GdSureActivity;
import kxkr.mimilottery.com.BuyLottory.SsqBileSureActivity;
import kxkr.mimilottery.com.BuyLottory.SsqSingleSureActivity;


public class Tool {
    public static void showMessage(Context context, String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }

    public static void showShortMessage(Context context, String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }

    public static String getString(TextView view) {
        return view.getText().toString().trim();
    }

    public static String getString(EditText view) {
        return view.getText().toString().trim();
    }

    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
     */
    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    /**
     * 获取屏幕宽度
     */
    public static int getWinWidth(Context context) {
        WindowManager manager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dm = new DisplayMetrics();
        manager.getDefaultDisplay().getMetrics(dm);
        int winwidth = dm.widthPixels;
        return winwidth;
    }

    /**
     * 获取屏幕高度
     */
    public static int getWinHeight(Context context) {
        WindowManager manager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dm = new DisplayMetrics();
        manager.getDefaultDisplay().getMetrics(dm);
        int winheight = dm.heightPixels;
        return winheight;
    }

    public static int byteToInt2(byte[] b) {

        int mask=0xff;
        int temp=0;
        int n=0;
        for(int i=0;i<b.length;i++){
            n<<=8;
            temp=b[i]&mask;
            n|=temp;
        }
        return n;
    }

    /**
     * 验证手机格式（正则表达式）
     */
    public static boolean isMobileNO(String mobiles) {
        /*
		移动号段：
              134 135 136 137 138 139 147 150 151 152 157 158 159 178 182 183 184 187 188
        联通号段：
            130 131 132 145 155 156 175 176 185 186
        电信号段：
            133 153 177 180 181 189
        虚拟运营商:
             170
        总结起来就是第一位必定为1，第二位必定为3或4或5或7或8，其他位置的可以为0-9
		*/
        String telRegex = "[1][34578]\\d{9}";//"[1]"代表第1位为数字1，"[358]"代表第二位可以为3、4、5、7、8中的一个，"\\d{9}"代表后面是可以是0～9的数字，有9位。
        if (TextUtils.isEmpty(mobiles)) return false;
        else return mobiles.matches(telRegex);
    }

    /**
     * 调用此方法输入所要转换的时间戳输入例如（1402733340）输出（"2014-06-14 16:09"）
     */
    public static String timestampTotime(String time) {
        SimpleDateFormat sdr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        @SuppressWarnings("unused")
        long lcc = Long.valueOf(time);
        int i = Integer.parseInt(time);
        String times = sdr.format(new Date(i * 1000L));
        return times;
    }

    /**
     * 调用此方法输入所要转换的时间戳输入例如（1402733340）输出（"2014-06-14 16:09"）
     */
    public static String timestampTotimeone(String time) {
        SimpleDateFormat sdr = new SimpleDateFormat("yyyy-MM-dd");
        @SuppressWarnings("unused")
        long lcc = Long.valueOf(time);
        int i = Integer.parseInt(time);
        String times = sdr.format(new Date(i * 1000L));
        return times;
    }

    /**
     * 调用此方法输入所要转换的时间戳输入例如（1402733340）输出（"2014-06-14 16:09"）
     */
    public static String timestampMin(String time) {
        SimpleDateFormat sdr = new SimpleDateFormat("yyyy MM dd-HH:mm");
        @SuppressWarnings("unused")
        long lcc = Long.valueOf(time);
        int i = Integer.parseInt(time);
        String times = sdr.format(new Date(i * 1000L));
        return times;
    }


    /**
     * 调用此方法输入所要转换的时间戳输入例如（1402733340）输出（"2014-06-14 16:09"）
     */
    public static String timestampMin2(String time) {
        SimpleDateFormat sdr = new SimpleDateFormat("yyyy.MM.dd");
        @SuppressWarnings("unused")
        long lcc = Long.valueOf(time);
        int i = Integer.parseInt(time);
        String times = sdr.format(new Date(i * 1000L));
        return times;
    }

    /**
     * 调用此方法输入所要转换的时间戳输入例如（1402733340）输出（"2014-06-14"）
     */
    public static String timestampMin3(String time) {
        SimpleDateFormat sdr = new SimpleDateFormat("yyyy-MM-dd");
        @SuppressWarnings("unused")
        long lcc = Long.valueOf(time);
        int i = Integer.parseInt(time);
        String times = sdr.format(new Date(i * 1000L));
        return times;
    }

    /**
     * 掉此方法输入所要转换的时间输入例如（"2014-06-14-16-09-00"）返回时间戳
     *
     * @param time
     * @return
     */
    public static String dataOne(String time) {
        SimpleDateFormat sdr = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.CHINA);
        Date date;
        String times = null;
        try {
            date = sdr.parse(time);
            long l = date.getTime();
            String stf = String.valueOf(l);
            times = stf.substring(0, 10);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return times;
    }

    /**
     * 输入时间戳  返回周几
     *
     *
     *
     */
    public static String getWeek(long timeStamp) {
        int mydate = 0;
        String week = null;
        Calendar cd = Calendar.getInstance();
        cd.setTime(new Date(timeStamp));
        mydate = cd.get(Calendar.DAY_OF_WEEK);
        // 获取指定日期转换成星期几
        if (mydate == 1) {
            week = "周日";
        } else if (mydate == 2) {
            week = "周一";
        } else if (mydate == 3) {
            week = "周二";
        } else if (mydate == 4) {
            week = "周三";
        } else if (mydate == 5) {
            week = "周四";
        } else if (mydate == 6) {
            week = "周五";
        } else if (mydate == 7) {
            week = "周六";
        }
        return week;
    }

    /**
     * 掉此方法输入所要转换的时间输入例如（"2014-06-14-16-09-00"）返回时间戳
     *
     * @param time
     * @return
     */
    public static String deadTime(String time) {
        SimpleDateFormat sdr = new SimpleDateFormat("yyyy|MM-dd HH:mm", Locale.CHINA);
        Date date;
        String times = null;
        try {
            date = sdr.parse(time);
            long l = date.getTime();
            String stf = String.valueOf(l);
            times = stf.substring(0, 10);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return times;
    }


    /**
     * 提示对话框（只有一个确定按钮）
     */
    public static void showSimPromptdia(Context context, String msg) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("提示").setMessage(msg).setNegativeButton("确定", null).create().show();
        //builder.setTitle(Html.fromHtml("<font color = '#009a9a'>" + "提示" + "</font>")) 有颜色的标题
    }

    //计算图片的缩放值
    public static int calculateInSampleSize(BitmapFactory.Options options, int reqWidth, int reqHeight) {
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth) {
            final int heightRatio = Math.round((float) height / (float) reqHeight);
            final int widthRatio = Math.round((float) width / (float) reqWidth);
            inSampleSize = heightRatio < widthRatio ? heightRatio : widthRatio;
        }
        return inSampleSize;
    }

    // 根据路径获得图片并压缩，返回bitmap用于显示
    public static Bitmap getSmallBitmap(String filePath) {
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(filePath, options);

        // Calculate inSampleSize
        options.inSampleSize = calculateInSampleSize(options, 480, 800);

        // Decode bitmap with inSampleSize set
        options.inJustDecodeBounds = false;

        return BitmapFactory.decodeFile(filePath, options);
    }

    /**
     * 压缩图片，处理某些手机拍照角度旋转的问题
     */
    public static String compressImage(String filePath, String fileName, int q, File fileParent) throws FileNotFoundException {

        Bitmap bm = getSmallBitmap(filePath);

        int degree = readPictureDegree(filePath);

        if (degree != 0) {//旋转照片角度
            bm = rotateBitmap(bm, degree);
        }

        File imageDir = fileParent;

        File outputFile = new File(imageDir, fileName);

        FileOutputStream out = new FileOutputStream(outputFile);

        bm.compress(Bitmap.CompressFormat.PNG, q, out);


        bm.recycle();

        System.gc();

        return outputFile.getPath();
    }

    public static int readPictureDegree(String path) {
        int degree = 0;
        try {
            ExifInterface exifInterface = new ExifInterface(path);
            int orientation = exifInterface.getAttributeInt(
                    ExifInterface.TAG_ORIENTATION,
                    ExifInterface.ORIENTATION_NORMAL);
            switch (orientation) {
                case ExifInterface.ORIENTATION_ROTATE_90:
                    degree = 90;
                    break;
                case ExifInterface.ORIENTATION_ROTATE_180:
                    degree = 180;
                    break;
                case ExifInterface.ORIENTATION_ROTATE_270:
                    degree = 270;
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return degree;
    }

    public static Bitmap rotateBitmap(Bitmap bitmap, int degress) {
        if (bitmap != null) {
            Matrix m = new Matrix();
            m.postRotate(degress);
            bitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(),
                    bitmap.getHeight(), m, true);
            return bitmap;
        }
        return bitmap;
    }

    /**
     * 验证邮箱格式是否正确
     */
    public static boolean emailValidation(String email) {
        String regex = "\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*";
        return email.matches(regex);
    }


    /*
* 验证号码 手机号 固话均可
*
*/
    public static boolean isPhoneNumberValid(String phoneNumber) {
        boolean isValid = false;

        String expression = "((^(13|15|18|17)[0-9]{9}$)|(^0[1,2]{1}\\d{1}-?\\d{8}$)|(^0[3-9] {1}\\d{2}-?\\d{7,8}$)|(^0[1,2]{1}\\d{1}-?\\d{8}-(\\d{1,4})$)|(^0[3-9]{1}\\d{2}-? \\d{7,8}-(\\d{1,4})$))";
        CharSequence inputStr = phoneNumber;

        Pattern pattern = Pattern.compile(expression);

        Matcher matcher = pattern.matcher(inputStr);

        if (matcher.matches() ) {
            isValid = true;
        }

        return isValid;

    }

    /**
     * 身份证号码校验
     * @param id 身份证号码
     * @returnl
     */
    public static boolean isLegalId(String id){
        if (id.toUpperCase().matches("(^\\d{15}$)|(^\\d{17}([0-9]|X)$)")){
            return true;
        }else {
            return false;
        }
    }

    /**
     * 验证是否全是数字
     * @param str
     * @return
     */
    public static boolean isNumeric(String str){

        Pattern pattern = Pattern.compile("[0-9]*");

        return pattern.matcher(str).matches();

    }

    /**
     * 验证是否仅包含数字、字母、汉子
     * @param str
     * @return
     */
    public static boolean isLetterDigitOrChinese(String str) {
        String regex = "^[a-z0-9A-Z\u4e00-\u9fa5]+$";
        return str.matches(regex);
    }

    public static void setbackInfo() {
        AppManger.getAppManager().finishActivity(SsqBileSureActivity.class);
        AppManger.getAppManager().finishActivity(SsqSingleSureActivity.class);
        AppManger.getAppManager().finishActivity(DltSingleSureActivity.class);
        AppManger.getAppManager().finishActivity(DltBileSureActivity.class);
        AppManger.getAppManager().finishActivity(FcZXSureActivity.class);
        AppManger.getAppManager().finishActivity(FcGroupSureActivity.class);
        AppManger.getAppManager().finishActivity(CqSscSureActivity.class);
        AppManger.getAppManager().finishActivity(BjSureActivity.class);
        AppManger.getAppManager().finishActivity(GdSureActivity.class);
        AppManger.getAppManager().finishActivity(FiveSureActivity.class);
        AppManger.getAppManager().finishActivity(ThreeSureActivity.class);
    }


    /**
     *
     * 显示toast，自己定义显示长短。
     * param1:activity  传入context
     * param2:word   我们需要显示的toast的内容
     * param3:time length  long类型，我们传入的时间长度（如500）
     */
    public static void showToast(final Activity activity, final String word, final long time){
        activity.runOnUiThread(new Runnable() {
            public void run() {
                final Toast toast = Toast.makeText(activity, word, Toast.LENGTH_LONG);
                toast.show();
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    public void run() {
                        toast.cancel();
                    }
                }, time);
            }
        });
    }

    public static Bitmap getGreyBitmap(Context mContext, int drawalbeInt) {
        Drawable drawable = mContext.getResources().getDrawable(drawalbeInt);
        Bitmap bitmap = GetDrable.drawableToBitmap(drawable);
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Bitmap faceIconGreyBitmap = Bitmap
                .createBitmap(width, height, Bitmap.Config.ARGB_8888);

        Canvas canvas = new Canvas(faceIconGreyBitmap);
        Paint paint = new Paint();
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setSaturation(0);
        ColorMatrixColorFilter colorMatrixFilter = new ColorMatrixColorFilter(
                colorMatrix);
        paint.setColorFilter(colorMatrixFilter);
        canvas.drawBitmap(bitmap, 0, 0, paint);
        return faceIconGreyBitmap;
    }
}  
