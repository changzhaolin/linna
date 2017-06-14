package cn.czl.history.today.fragment;

import java.util.Calendar;
import java.util.List;
import java.util.Random;

import org.xutils.x;
import org.xutils.view.annotation.ViewInject;

import com.bumptech.glide.Glide;
import com.tencent.bugly.Bugly;
import com.tencent.bugly.crashreport.CrashReport;

import android.app.AlertDialog;
import android.app.ApplicationErrorReport.CrashInfo;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import cn.czl.history.today.R;
import cn.czl.history.today.adapter.EventAdapter;
import cn.czl.history.today.app.EnentApplication;
import cn.czl.history.today.entity.Events;
import cn.czl.history.today.entity.IdEvents;
import cn.czl.history.today.mylog.MyLog;
import cn.czl.history.today.presenter.IEventPresenter;
import cn.czl.history.today.presenter.impl.EventPresenterImpl;
import cn.czl.history.today.ui.WaveSwipeRefreshLayout;
import cn.czl.history.today.ui.WaveSwipeRefreshLayout.OnRefreshListener;
import cn.czl.history.today.util.GlideCircleTransform;
import cn.czl.history.today.view.IEventView;

public class EventListFragment extends Fragment implements IEventView ,OnRefreshListener{
	private static final int MENU_ACTION_EDIT = 0;
	private static final int MENU_ACTION_SHARE = 1;
	private IEventPresenter presenter;
	private ListView lv_events;
	private List<Events> events;
	private List<IdEvents> idEvents;
	private EventAdapter adapter;
	private int contextItemPosition;
	@ViewInject(R.id.button1)
	private Button btn_search;
	
	private EditText et_mouth;
	private EditText et_day;
	 private final int QR_WIDTH=300;  
	    private final int QR_HEIGHT=300;
	private Button button;

	 
	@ViewInject(R.id.tv_title1)
	private TextView tv_title;
	@ViewInject(R.id.tv_content1)
	private TextView tv_content;
	@ViewInject(R.id.tv_des1)
	private TextView tv_des;

	@ViewInject(R.id.tv_lunar1)
	private TextView tv_lunar;
	@ViewInject(R.id.iv_eventphoto1)
	private ImageView iv_eventphoto;

 

	private ListView listview;

	private ScrollView scrollView;
	private WaveSwipeRefreshLayout layout;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = View.inflate(getActivity(), R.layout.fragment_eventlist, null);
		initView(view);
		   CrashReport.getUserData(getActivity(), "nihao");
		   Bugly.init(getActivity(), "你好吗", true);
		 
		lv_events = (ListView) view.findViewById(R.id.lv_events);
		btn_search=(Button) view.findViewById(R.id.button1);
		button = (Button) view.findViewById(R.id.button2);
		et_mouth = (EditText) view.findViewById(R.id.editText1);
		 final Calendar c = Calendar.getInstance();
 
		et_day = (EditText) view.findViewById(R.id.editText2);
		et_day.setOnClickListener(new View.OnClickListener() {
	          @Override
	          public void onClick(View v) {
	              DatePickerDialog dialog = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
	                  @Override
	                  public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
	                      c.set(year, monthOfYear, dayOfMonth);
	                      et_day.setText(DateFormat.format("yyy-MM-dd", c));
	                  }
	              }, c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH));
	              dialog.show();
	          }
	      });

		x.view().inject(getActivity());
		presenter = new EventPresenterImpl(this);
		presenter.loadEnvents(1, 1);
		registerForContextMenu(lv_events);
		 
		setListeners(view);

		return view;
	}

	private void initView(View view) {
		// TODO Auto-generated method stub
		layout=(WaveSwipeRefreshLayout) view.findViewById(R.id.wsrl);
		layout.setWaveColor(0xFF00A8FF);
		layout.setColorSchemeColors(0xFF000000);
	}
	 

	private void setListeners(final View view) {
		// TODO Auto-generated method stub
		layout.setOnRefreshListener(this);
		btn_search.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String mouth1 = et_mouth.getText().toString().trim();

				String day1 = et_day.getText().toString().trim();

				if (!mouth1.equals("") && !day1.equals("")) {
					int mouth = Integer.parseInt(mouth1);

					int day = Integer.parseInt(day1);
					if (mouth<=12&&day<=31) {
						presenter.loadEnvents(mouth, day);
					}

				} else {
					Toast.makeText(getActivity(), "请输入要搜的日期", Toast.LENGTH_LONG)
							.show();

				}

			}
		});

		button.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String eidString = et_day.getText().toString().trim();
		
			
	
				int id;
				if (!eidString.equals("")) {
					if (eidString.contains("-")) {
						String ed=eidString.substring(0, 4)+eidString.substring(5, 7)+eidString.substring(8, eidString.length());
						id = Integer.parseInt(ed);
						presenter.SearchEnvents(id);
					  
					}else {
						if (eidString.length()!=8) {
							Toast.makeText(getActivity(), "id无效！请检查重新输入",
									Toast.LENGTH_LONG).show();
						}else {
							id = Integer.parseInt(eidString);
							presenter.SearchEnvents(id);
						}
					}
				} else {
					Toast.makeText(getActivity(), "请输入要搜的事件id",
							Toast.LENGTH_LONG).show();
				}

			}
		});
		lv_events.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1,
					int position, long id) {
				// TODO Auto-generated method stub

				try {
					Events event = events.get(position);
					String idd = event.get_id();
					//String title = event.getTitle();
					boolean isNum = idd.matches("[0-9]+");
					if (isNum == true) {
						presenter.SearchEnvents(Integer.parseInt(idd));
					} else {
						String ids = idd.substring(0, 8);
						presenter.SearchEnvents(Integer.parseInt(ids));
						//Toast.makeText(getActivity(), "此id不合法！"+ids, Toast.LENGTH_LONG).show();
					} 
				} catch (Exception e) {
					e.printStackTrace();
					MyLog.e("error", "ErrorException"+e);
				}
				

			}
		});

		lv_events.setOnScrollListener(new OnScrollListener() {
			private boolean isBottom;
			private boolean isTop;
			private int lastItem;
			
			/**
			 * 当滚动状态改变时执行
			 */
			public void onScrollStateChanged(AbsListView view, int scrollState) {

				switch (scrollState) {

				case SCROLL_STATE_FLING:
					// Log.i("info", "SCROLL_STATE_FLING");
					break;
				case SCROLL_STATE_IDLE:
					// Log.i("info", "SCROLL_STATE_IDLE");
					// 如果已经到底了 加载下一页
					int  mouth = new Random().nextInt(12);
				int   day = new Random().nextInt(31);
					if (mouth == 2) {
						day = new Random().nextInt(28);
					} else if (mouth == 2 || mouth == 4 || mouth == 6
							|| mouth == 8 || mouth == 10) {
						day = new Random().nextInt(30);
					}
					if (isBottom) { // 到底了
						Log.i("info", "加载下一页...");
						//

						presenter.loadEnvents(mouth, day);
						Toast.makeText(getActivity(), "正在刷新", Toast.LENGTH_SHORT).show();


//					} else if (isTop) {
//
//						presenter.loadEnvents(mouth, day);
//                       
//					}
					}
					break;
				case SCROLL_STATE_TOUCH_SCROLL:
					// Log.i("info", "SCROLL_STATE_TOUCH_SCROLL");
					break;
				}
			}

			// 当滚动时执行该方法
			public void onScroll(AbsListView view, int firstVisibleItem,
					int visibleItemCount, int totalItemCount) {
				if (firstVisibleItem + visibleItemCount == totalItemCount) {
					// Log.i("info", "到底了....");
					isBottom = true;
				} else {
					isBottom = false;
				}
				lastItem = lv_events.getLastVisiblePosition();

				if (lastItem - visibleItemCount == -1) {
					// Log.i("info", "到底了....");
					isTop = true;
				} else {
					isTop = false;
				}
			}
		});

	}

	@Override
	public void showEvent(List<Events> events) {
		// TODO Auto-generated method stub
		this.events = events;
		adapter = new EventAdapter(getActivity(), events, lv_events);
		lv_events.setAdapter(adapter);
		layout.setRefreshing(false);
	}

	

	private long editId;
	private int editPosition;

	private AlertDialog.Builder builder;

	private AlertDialog dialog;
	private Bitmap bitmap;
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		AdapterContextMenuInfo info = (AdapterContextMenuInfo) menuInfo;
		contextItemPosition = info.position;

		menu.add(Menu.NONE, MENU_ACTION_EDIT, Menu.NONE, "分享");
//		menu.add(Menu.NONE, MENU_ACTION_SHARE, Menu.FIRST, "生成二维码分享");

	}
	@Override
	public boolean onContextItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case MENU_ACTION_EDIT:
			// 将现有表单设置为编辑状态
			Intent intent = new Intent(Intent.ACTION_SEND);
			intent.setType("text/plain");
			intent.putExtra(Intent.EXTRA_TEXT, "这是一个可以用日期或者事件id搜索历史的app,欢迎体验");
			startActivity(Intent
					.createChooser(intent, getActivity().getTitle()));
			break;
		case MENU_ACTION_SHARE:
			 
		break;
		}
		return super.onContextItemSelected(item);
	}
	 
  
	@Override
	public void showIdEvent(List<IdEvents> events) {
		// TODO Auto-generated method stub
		this.idEvents = events;

		builder = new AlertDialog.Builder(getActivity());
		View view = View.inflate(getActivity(), R.layout.item_idevents, null);
		tv_title = (TextView) view.findViewById(R.id.tv_title1);
		tv_des = (TextView) view.findViewById(R.id.tv_des1);
		tv_content = (TextView) view.findViewById(R.id.tv_content1);
		tv_lunar = (TextView) view.findViewById(R.id.tv_lunar1);
		iv_eventphoto = (ImageView) view.findViewById(R.id.iv_eventphoto1);
		tv_title.setText(events.get(0).getTitle());
		tv_des.setText(Html.fromHtml("<font color='red'>" + "事件简介:")
				+ events.get(0).getDes());
		tv_content.setText(Html.fromHtml("<font color='red'>" + "事件内容:")
				+ events.get(0).getContent());
		tv_lunar.setText(Html.fromHtml(events.get(0).getYear()
				+ "年:<font color='red'>" + events.get(0).getMonth()
				+ "月:<font color='red'>" + events.get(0).getDay()
				+ "日:<font color='red'>"));
		 
		 
		if (events.get(0).getPic().equals("")) {
			Toast.makeText(EnentApplication.getContext(), "该事件没有图片", Toast.LENGTH_LONG).show();
		}else {
		 
			Glide
		    .with(EnentApplication.getContext())
		    .load(events.get(0).getPic())
		    .transform(new GlideCircleTransform(getActivity()))
	        
		    .into(iv_eventphoto);
		}
		builder.setView(view);

		builder.create();
		builder.show();

	}

	@Override
	public void onRefresh() {
		int  mouth = new Random().nextInt(12);
		int   day = new Random().nextInt(31);
			if (mouth == 2) {
				day = new Random().nextInt(28);
			} else if (mouth == 2 || mouth == 4 || mouth == 6
					|| mouth == 8 || mouth == 10) {
				day = new Random().nextInt(30);
			}
			Log.e("月份", "月份"+mouth+"号"+day);
		 presenter.loadEnvents(mouth, day);
		 
		Toast.makeText(getActivity(), "正在刷新", Toast.LENGTH_SHORT).show();
		
	}

	 

}
