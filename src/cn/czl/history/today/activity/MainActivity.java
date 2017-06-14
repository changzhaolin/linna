package cn.czl.history.today.activity;

import java.util.ArrayList;
import java.util.List;

import org.xutils.x;
import org.xutils.view.annotation.ViewInject;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;
import cn.czl.history.today.R;
import cn.czl.history.today.fragment.EventListFragment;
import cn.czl.history.today.fragment.SearchFragment;
import cn.czl.history.today.mylog.MyLog;

public class MainActivity extends FragmentActivity implements OnClickListener {
	@ViewInject(R.id.vp_news)
	private ViewPager vp_news;
	@ViewInject(R.id.rg_button)
	private RadioGroup radioGroup;
	@ViewInject(R.id.radioButton1)
	private RadioButton rb_event;
	@ViewInject(R.id.radioButton2)
	private RadioButton rb_shousuo;
	@ViewInject(R.id.text1)
	private Button textView;
	private List<Fragment> fragments;
	private MyViewPageAdapter adapter;
	//连续点击时间空间的次数
		private int timeViewClickCount = 0;
		//点击时间控件的时间
		private long timeViewClickTime =0;
		//连续点击bd控件的次数
		private int bdViewClickCount = 0;
 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		 
		x.view().inject(this);
		MyLog.delFile();
		setAdapter();
		setLisenters();
		textView.setOnClickListener(this);
		MyLog.delFile();
	}
	  
	 
	private void setLisenters() {
		
		 
		 vp_news.setOnPageChangeListener(new OnPageChangeListener() {
			
			@Override
			public void onPageSelected(int i) {
				// TODO Auto-generated method stub
				switch (i) {
				case 0:
					rb_event.setChecked(true);
					break;
				case 1:
					rb_shousuo.setChecked(true);
					break;

				 
				}
			}
			
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		 radioGroup.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				// TODO Auto-generated method stub
				switch (checkedId) {
				case R.id.radioButton1:
					vp_news.setCurrentItem(0);
					break;
				case R.id.radioButton2:
					vp_news.setCurrentItem(1);
					break;

				 
				}
			}
		});
	}

	private void setAdapter() {
		// TODO Auto-generated method stub
		fragments = new ArrayList<Fragment>();
		fragments.add(new EventListFragment());
		fragments.add(new SearchFragment());
		adapter = new MyViewPageAdapter(getSupportFragmentManager());
		vp_news.setAdapter(adapter);
	}

	class MyViewPageAdapter extends FragmentPagerAdapter {

		public MyViewPageAdapter(FragmentManager fm) {
			super(fm);
			// TODO Auto-generated constructor stub
		}

		@Override
		public Fragment getItem(int position) {
			// TODO Auto-generated method stub
			return fragments.get(position);
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return fragments.size();
		}

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.text1:
			 try{
					if ((System.currentTimeMillis()-timeViewClickTime)>3000){
						timeViewClickCount=1;
						timeViewClickTime=System.currentTimeMillis();
					}else{
						timeViewClickCount+=1;
						if (timeViewClickCount>=3){
							timeViewClickCount=1;
							//显示系统设置界面
						 
							 
							Intent intent =  new Intent(MainActivity.this,AdminActivity.class);
		       	         	startActivity(intent);
						}
					}
				}
				catch(Exception ex){
				 
			 
				
			}
			break;

		 
		}
	}
	@Override  
    public void onBackPressed() {  
        new AlertDialog.Builder(this).setTitle("你真的要离开我吗？")   
        .setIcon(R.drawable.meng)   
        .setPositiveButton("狠心离开", new DialogInterface.OnClickListener() {   
       
            @Override   
            public void onClick(DialogInterface dialog, int which) {   
            // 点击“确认”后的操作   
            MainActivity.this.finish();   
                System.exit(0);  
       
            }   
        })   
        .setNegativeButton("再等一下", new DialogInterface.OnClickListener() {   
       
            @Override   
            public void onClick(DialogInterface dialog, int which) {   
            // 点击“返回”后的操作,这里不设置没有任何操作   
            }   
        }).show();   
        //super.onBackPressed();  
    }  
}
