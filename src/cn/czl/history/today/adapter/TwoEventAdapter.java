package cn.czl.history.today.adapter;

import java.util.List;

import cn.czl.history.today.R;
import cn.czl.history.today.entity.TwoEvent;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class TwoEventAdapter extends BaseAdapter {
	private Context context;
	private List<TwoEvent>twoEvents;
	private LayoutInflater inflater;

	public TwoEventAdapter(Context context, List<TwoEvent> twoEvents) {
		super();
		this.context = context;
		this.twoEvents = twoEvents;
		this.inflater=LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return twoEvents.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return twoEvents.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ViewHolder holder=null;
		if (convertView==null) {
			convertView=inflater.inflate(R.layout.item_two_event, null);
			holder=new ViewHolder();
			holder.tv_day=(TextView) convertView.findViewById(R.id.tv_day);
			holder.tv_titles=(TextView) convertView.findViewById(R.id.tv_titles);
			holder.tv_nain=(TextView) convertView.findViewById(R.id.tv_years);
			convertView.setTag(holder);
		}
		holder=(ViewHolder) convertView.getTag();
		TwoEvent twoEvent=twoEvents.get(position);
		if (twoEvent!=null) {
			holder.tv_day.setText("今日："+twoEvent.getDay());
			holder.tv_titles.setText(twoEvent.getTitle());
			holder.tv_nain.setText("历史时间："+twoEvent.getDate());
		}
		
		return convertView;
	}
    class ViewHolder{
    	TextView tv_day;
    	TextView tv_titles;
    	TextView tv_nain;
    }
	 

}
