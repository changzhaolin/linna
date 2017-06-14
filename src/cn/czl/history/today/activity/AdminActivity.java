package cn.czl.history.today.activity;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import cn.czl.history.today.R;
import cn.czl.history.today.app.EnentApplication;
import cn.czl.history.today.util.Upload;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

public class AdminActivity extends Activity
{
	private TextView uploadInfo;
	private Button btn;
	private Button btnAll;
	private Button btnAllError;
	private Button btnreturn;
	private SimpleDateFormat dateFormat;
	 
	public Upload upload=new Upload();
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_admin);
		btn=(Button) findViewById(R.id.buttons1);
		btnAll=(Button) findViewById(R.id.buttons2);
		btnAllError=(Button) findViewById(R.id.buttons3);
		btnreturn=(Button) findViewById(R.id.buttons4);
		uploadInfo = (TextView) findViewById(R.id.upload_info);
		dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		 
			btnreturn.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					finish();
				}
			});
		 
		btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				uploadFile();
			}
		});

		btnAll.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				 
					uploadAllFile();
			 
			}

			
		});
		btnAllError.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				uploadAllErrorFile();
				
			}

			
			
		});
	}
	
	private void uploadAllErrorFile() {
		// TODO Auto-generated method stub
		 upload.uploadAllErrorFile(AdminActivity.this,  uploadInfo);
	}
	
	/**
	 * 上传所有日志
	 */
	public void uploadAllFile() {
		 
		 upload.uploadAllFile(AdminActivity.this,  uploadInfo);
		
	}
	/**
	 * 上传当天日志
	 */
	public void uploadFile()
	{
		 
		Date now = new Date(); 
		String nTime = dateFormat.format(now)+EnentApplication.getContext().getTerminaID();
		String filePath = Environment.getExternalStorageDirectory()+"/History/log/"+nTime+"Log.txt";
		 
		
		upload.uploadFile(AdminActivity.this, filePath, uploadInfo);

	}
}
