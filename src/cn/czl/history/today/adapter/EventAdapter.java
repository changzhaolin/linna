package cn.czl.history.today.adapter;

import java.util.List;

import org.xutils.x;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import cn.czl.history.today.R;
import cn.czl.history.today.entity.Events;
import cn.czl.history.today.util.GlideRoundTransform;
 

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;

public class EventAdapter extends BaseAdapter {
	private Context context;
	private List<Events> events;
	private LayoutInflater inflater;
	private RequestQueue mQueue;

	 

	public EventAdapter(Context context, List<Events> events, ListView listView) {
		super();
		this.context = context;

		this.events = events;

		this.inflater = LayoutInflater.from(context);
		mQueue = Volley.newRequestQueue(context);
	 
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub

		return events.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return events.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ViewHolder holder = null;
		if (convertView == null) {
			convertView = inflater.inflate(R.layout.item_events, null);
			holder = new ViewHolder();
			holder.tv_title = (TextView) convertView
					.findViewById(R.id.tv_title);
			holder.tv_content = (TextView) convertView
					.findViewById(R.id.tv_content);
			holder.tv_year = (TextView) convertView
					.findViewById(R.id.tv_nianfen);
			// holder.tv_lunar = (TextView) convertView
			// .findViewById(R.id.tv_lunar);
			holder.iv_eventphoto = (ImageView) convertView
					.findViewById(R.id.iv_eventphoto);
			convertView.setTag(holder);
		}

		holder = (ViewHolder) convertView.getTag();
		Events event = events.get(position);
		holder.tv_title.setText(event.getTitle());
		holder.tv_content.setText(event.getDes());
		holder.tv_year.setText(event.getYear());
		// holder.tv_lunar.setText(event.getLunar());
		 
			//x.image().bind(holder.iv_eventphoto, event.getPic());
	 

		// ImageRequest imageRequest=new ImageRequest(event.getPic(), new
		// Listener<Bitmap>() {
		//
		// @Override
		// public void onResponse(Bitmap response) {
		// // TODO Auto-generated method stub
		// holder.iv_eventphoto.setImageBitmap(response);
		// }
		// }, 0, 0, Config.RGB_565, new ErrorListener() {
		//
		// @Override
		// public void onErrorResponse(VolleyError error) {
		// // TODO Auto-generated method stub
		//
		// }
		//
		// });
		//
		// mQueue.add(imageRequest);
		//
		// œ‘ æÕº∆¨
		 if (!event.getPic().equals("")) {
		
		Glide.with(context).load(event.getPic()).transform(new GlideRoundTransform(context)).into(holder.iv_eventphoto);
		 }
		
		return convertView;
	}

	class ViewHolder {
		TextView tv_title;
		TextView tv_content;
		TextView tv_year;
		// TextView tv_lunar;
		ImageView iv_eventphoto;
	}

}
