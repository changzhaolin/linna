package cn.czl.history.today.fragment;

 
import java.util.List;
import java.util.Random;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;
import cn.czl.history.today.R;
import cn.czl.history.today.activity.TwoDetailActivity;
import cn.czl.history.today.adapter.TwoEventAdapter;
import cn.czl.history.today.entity.TwoEvent;
import cn.czl.history.today.presenter.ITwoEventPresenter;
import cn.czl.history.today.presenter.impl.TwoEventPresenterImpl;
import cn.czl.history.today.ui.WaveSwipeRefreshLayout;
import cn.czl.history.today.ui.WaveSwipeRefreshLayout.OnRefreshListener;
import cn.czl.history.today.view.ITwoEventView;

public class SearchFragment extends Fragment implements ITwoEventView,OnRefreshListener{
	private ITwoEventPresenter presenter;
	private ListView lv_twoevent;
	private List<TwoEvent>twoEvents;
	private TwoEventAdapter adapter;
 
	private WaveSwipeRefreshLayout layout;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view=View.inflate(getActivity(), R.layout.fragment_search, null);
		initView(view);
		lv_twoevent=(ListView) view.findViewById(R.id.lv_twoEvents);
		presenter=new TwoEventPresenterImpl(this);
		int a=new Random().nextInt(12);
		int b=new Random().nextInt(31);
		if (a==2) {
			b=new Random().nextInt(28);
		}else if (a==2||a==4||a==6||a==8||a==10) {
			b=new Random().nextInt(30);
		}
		  String date = String.valueOf(a)+"/"+String.valueOf(b);
		presenter.loadTwoEvent(date);
		setLisenters();
		
		return view;
	}
	private void initView(View view) {
		// TODO Auto-generated method stub
		layout=(WaveSwipeRefreshLayout) view.findViewById(R.id.wsrl2);
		layout.setWaveColor(0xFF00A8FF);
		layout.setColorSchemeColors(0xFF000000);
	}
	 

	private void setLisenters() {
		// TODO Auto-generated method stub
		layout.setOnRefreshListener(this);
		lv_twoevent.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int position,
					long id) {
				// TODO Auto-generated method stub
				 TwoEvent twoEvent=twoEvents.get(position);
				 Intent intent=new Intent(getActivity(), TwoDetailActivity.class);
				 if (twoEvent.getE_id()==null) {
					Toast.makeText(getActivity(), "该id是无效id", Toast.LENGTH_LONG).show();
				}else {
					intent.putExtra("twoEvent",twoEvent);
					 startActivity(intent);
				}
				 
			}
		});
		lv_twoevent.setOnScrollListener(new OnScrollListener() {
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
					int a=new Random().nextInt(12);
					int b=new Random().nextInt(31);
					if (a==2) {
						b=new Random().nextInt(28);
					}else if (a==2||a==4||a==6||a==8||a==10) {
						b=new Random().nextInt(30);
					}
					  String date = String.valueOf(a)+"/"+String.valueOf(b);
					if (isBottom) { // 到底了
						//Log.i("info", "加载下一页...");
						//

						presenter.loadTwoEvent(date);

//					} else if (isTop) {
//
//						presenter.loadTwoEvent(date);
//
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
				lastItem = lv_twoevent.getLastVisiblePosition();

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
	public void showTwoEvent(List<TwoEvent> twoEvents) {
		// TODO Auto-generated method stub
		this.twoEvents=twoEvents;
		adapter=new TwoEventAdapter(getActivity(), twoEvents);
		lv_twoevent.setAdapter(adapter);
		layout.setRefreshing(false);
		
	}
	@Override
	public void onRefresh() {
		// TODO Auto-generated method stub
		int a=new Random().nextInt(12);
		int b=new Random().nextInt(31);
		if (a==2) {
			b=new Random().nextInt(28);
		}else if (a==2||a==4||a==6||a==8||a==10) {
			b=new Random().nextInt(30);
		}
		  String date = String.valueOf(a)+"/"+String.valueOf(b);
		  presenter.loadTwoEvent(date);
	}

}
