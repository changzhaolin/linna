package cn.czl.history.today.util;

import android.content.Context;
import android.widget.Toast;
/**
 * ����ʾ�����ݲ�һ��ʱ�����϶�Ϊ����ͬһ��Toast,
 * ��ʾ����һ��ʱ��ֻ�м��ʱ�����2��ʱ����ʾ
 * @author Administrator
 * 2017-4-20
 */
public class ToastUtil {  
    private static String oldMsg;  
    private static long time;  
  
    public static void showToast(Context context, String msg, int duration) {  
        if (!msg.equals(oldMsg)) { // ����ʾ�����ݲ�һ��ʱ�����϶�Ϊ����ͬһ��Toast  
            Toast.makeText(context, msg, duration).show();  
            time = System.currentTimeMillis();  
        } else {  
            // ��ʾ����һ��ʱ��ֻ�м��ʱ�����2��ʱ����ʾ  
            if (System.currentTimeMillis() - time > 2000) {  
                Toast.makeText(context, msg, duration).show();  
                time = System.currentTimeMillis();  
            }  
        }  
        oldMsg = msg;  
    }  
  
}  
