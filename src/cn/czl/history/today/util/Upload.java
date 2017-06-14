package cn.czl.history.today.util;

import java.io.File;
import java.io.FileNotFoundException;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import android.content.Context;
import android.os.Environment;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;
import cn.czl.history.today.app.EnentApplication;

public class Upload {
	
	
	/**
	 * 当天日志上传
	 * @param context
	 * @param path
	 * @param textView
	 */
	public void uploadFile(final Context context ,String path,final TextView textView)
	{
		//服务器端地址
		String url = EnentApplication.getContext().getUrl();
		//手机端要上传的文件，首先要保存你手机上存在该文件
	  
		AsyncHttpClient httpClient = new AsyncHttpClient();

		RequestParams param = new RequestParams();
		try
		{
			param.put("file", new File(path));
		//	param.put("file1", new File(filePath1));
			//param.put("content", "liucanwen");
			
			httpClient.post(url, param, new AsyncHttpResponseHandler()
			{
				@Override
				public void onStart()
				{
					super.onStart();
					
					textView.setText("正在上传...");
				}
				
				@Override
				public void onSuccess(String arg0)
				{
					super.onSuccess(arg0);

					Log.i("ck", "success>" + arg0);
					
					if(arg0.equals("success"))
					{
						Toast.makeText(context, "上传成功！", 1000).show();
					}
					
					textView.setText(arg0);
				}
				
				@Override
				public void onFailure(Throwable arg0, String arg1)
				{
					super.onFailure(arg0, arg1);
					
					textView.setText("上传失败！");
				}
			});
			
		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
			Toast.makeText(context, "上传文件不存在！", 1000).show();
		}
	}
	/**
	 * 上传全部日志
	 * @param context
	 * @param textView
	 */
	public void uploadAllFile(final Context context ,final TextView textView)
	{
		//服务器端地址
				//String url = "http://192.168.0.100:8080/UploadFileServer/upload";
		String url = EnentApplication.getContext().getUrl();
				//手机端要上传的文件，首先要保存你手机上存在该文件
			  
				AsyncHttpClient httpClient = new AsyncHttpClient();
				 String[] filepaths;  
			      File f = null;
			      f = new File(Environment.getExternalStorageDirectory()+"/History/log/");
				 filepaths=f.list();
				RequestParams param = new RequestParams();
				try
				{
					 for (int i = 0; i < filepaths.length; i++) {
							param.put("file"+i, new File(Environment.getExternalStorageDirectory()+"/History/log/"+filepaths[i]));
						}
					
				//	param.put("file1", new File(filePath1));
					//param.put("content", "liucanwen");
					
					httpClient.post(url, param, new AsyncHttpResponseHandler()
					{
						@Override
						public void onStart()
						{
							super.onStart();
							
							 
							ToastUtil.showToast(context, "正在上传...", Toast.LENGTH_LONG);
						}
						
						@Override
						public void onSuccess(String arg0)
						{
							super.onSuccess(arg0);

							Log.i("ck", "success>" + arg0);
							
							if(arg0.equals("success"))
							{
							 
								ToastUtil.showToast(context, "上传成功！", Toast.LENGTH_LONG);
							}
							
							 
							ToastUtil.showToast(context, arg0, Toast.LENGTH_LONG);
						}
						
						@Override
						public void onFailure(Throwable arg0, String arg1)
						{
							super.onFailure(arg0, arg1);
							
						 
							ToastUtil.showToast(context, "上传失败！", Toast.LENGTH_LONG);
						}
					});
					
				} catch (FileNotFoundException e)
				{
					e.printStackTrace();
					 
					ToastUtil.showToast(context, "上传文件不存在！", Toast.LENGTH_LONG);
				}
		 
        
    }  
	/**
	 * 上传全部错误日志
	 * @param context
	 * @param textView
	 */
	public void uploadAllErrorFile(final Context context ,final TextView textView)
	{
		//服务器端地址
				//String url = "http://192.168.0.100:8080/UploadFileServer/upload";
		String url = EnentApplication.getContext().getUrl();
				//手机端要上传的文件，首先要保存你手机上存在该文件
			  
				AsyncHttpClient httpClient = new AsyncHttpClient();
				 String[] filepaths;  
			      File f = null;
			      f = new File(Environment.getExternalStorageDirectory()+"/History/HistoryErrorLog/");
				 filepaths=f.list();
				RequestParams param = new RequestParams();
				try
				{
					 for (int i = 0; i < filepaths.length; i++) {
							param.put("file"+i, new File(Environment.getExternalStorageDirectory()+"/History/HistoryErrorLog/"+filepaths[i]));
						}
					
				//	param.put("file1", new File(filePath1));
					//param.put("content", "liucanwen");
					
					httpClient.post(url, param, new AsyncHttpResponseHandler()
					{
						@Override
						public void onStart()
						{
							super.onStart();
							
							 
							ToastUtil.showToast(context, "正在上传...", Toast.LENGTH_LONG);
						}
						
						@Override
						public void onSuccess(String arg0)
						{
							super.onSuccess(arg0);

							Log.i("ck", "success>" + arg0);
							
							if(arg0.equals("success"))
							{
							 
								ToastUtil.showToast(context, "上传成功！", Toast.LENGTH_LONG);
							}
							
							 
							ToastUtil.showToast(context, arg0, Toast.LENGTH_LONG);
						}
						
						@Override
						public void onFailure(Throwable arg0, String arg1)
						{
							super.onFailure(arg0, arg1);
							
						 
							ToastUtil.showToast(context, "上传失败！", Toast.LENGTH_LONG);
						}
					});
					
				} catch (FileNotFoundException e)
				{
					e.printStackTrace();
					 
					ToastUtil.showToast(context, "上传文件不存在！", Toast.LENGTH_LONG);
				}
		 
        
    }  
	
	/**
	 * 上传错误之日志
	 * @param context
	 * @param file
	 */
	public void uploadErrorFile(final Context context ,File file)
	{
		//服务器端地址
		//String url = "http://192.168.0.100:8080/UploadFileServer/upload";
		String url = EnentApplication.getContext().getUrl();
		//手机端要上传的文件，首先要保存你手机上存在该文件
	  
		AsyncHttpClient httpClient = new AsyncHttpClient();

		RequestParams param = new RequestParams();
		try
		{
			param.put("file", file);
		//	param.put("file1", new File(filePath1));
			//param.put("content", "liucanwen");
			
			httpClient.post(url, param, new AsyncHttpResponseHandler()
			{
				@Override
				public void onStart()
				{
					super.onStart();
					
					 
					//ToastUtil.showToast(context, "正在上传...", Toast.LENGTH_LONG);
				}
				
				@Override
				public void onSuccess(String arg0)
				{
					super.onSuccess(arg0);

					Log.i("ck", "success>" + arg0);
					
					if(arg0.equals("success"))
					{
					 
					//	ToastUtil.showToast(context, "上传成功！", Toast.LENGTH_LONG);
					}
					
					 
					//ToastUtil.showToast(context, arg0, Toast.LENGTH_LONG);
				}
				
				@Override
				public void onFailure(Throwable arg0, String arg1)
				{
					super.onFailure(arg0, arg1);
					
				 
				//	ToastUtil.showToast(context, "上传失败！", Toast.LENGTH_LONG);
				}
			});
			
		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
			 
			//ToastUtil.showToast(context, "上传文件不存在！", Toast.LENGTH_LONG);
		}
	}

}
