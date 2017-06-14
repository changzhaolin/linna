package cn.czl.history.today.app;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.lang.Thread.UncaughtExceptionHandler;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import com.tencent.bugly.crashreport.CrashReport;

import android.app.Application;
import android.os.Environment;
import android.telephony.TelephonyManager;
import cn.czl.history.today.activity.WelcomeActivity;
import cn.czl.history.today.util.Upload;

public class EnentApplication extends Application{
	 private static EnentApplication context;
	 public String terminaID;			//TERMINALID÷’∂À ∂±¬Î
	 String url = "http://192.168.168.189:8080/UploadFileServer/upload";
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		CrashReport.initCrashReport(getApplicationContext(), "27c07a109b", true); 
		context=this;
		 TelephonyManager TelephonyMgr = (TelephonyManager)getSystemService(TELEPHONY_SERVICE); 
	          terminaID = android.os.Build.MODEL+TelephonyMgr.getDeviceId();
	         
		Thread.setDefaultUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
 
	}
	
	
	class MyUncaughtExceptionHandler implements UncaughtExceptionHandler{

		@Override
		public void uncaughtException(Thread thread, Throwable ex) {

			try {
				
				Date currdate = new Date(System.currentTimeMillis());

				SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd-HH-mm",Locale.getDefault());

				 String strDate = sdf.format(currdate);
				
				File folder = new File(Environment.getExternalStorageDirectory()+"/History/HistoryErrorLog/");
				if (!folder.exists()) {
					folder.mkdirs();
				}
				File file = new File(Environment.getExternalStorageDirectory()+"/History/HistoryErrorLog/", terminaID+"-"+strDate+".log");
				PrintWriter err;
				err = new PrintWriter(file);
				ex.printStackTrace(err);
				err.flush();
				err.close(); 
				
						Upload upload=new Upload();
						//String path=Environment.getExternalStorageDirectory()+"/History/HistoryErrorLog/"+terminaID+"-"+strDate+".log";
						upload.uploadErrorFile(getApplicationContext(), file);
				
			
				//android.os.Process.killProcess(android.os.Process.myPid());
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
	}
	public static EnentApplication getContext() {
		return context;
	}
	public String getTerminaID() {
		return terminaID;
	}
	public void setTerminaID(String terminaID) {
		this.terminaID = terminaID;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	 
   
	
}
