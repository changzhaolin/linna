package cn.czl.history.today.adapter;

import java.util.List;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import cn.czl.history.today.R;
import cn.czl.history.today.app.EnentApplication;
import cn.czl.history.today.entity.ImageRoot;
import cn.czl.history.today.entity.Pic_Url;
import cn.czl.history.today.util.GlideCircleTransform;

public class ImagesAdapter extends BaseAdapter {
	private Context context;
	private List<ImageRoot> imageRoot;
	private List<Pic_Url>pic_Urls;
	private LayoutInflater inflater;
	 
	 
	public ImagesAdapter(Context context, List<ImageRoot> imageRoot,List<Pic_Url>pic_Urls) {
		super();
		this.context = context;
		this.imageRoot = imageRoot;
		this.inflater=LayoutInflater.from(context);
		this.pic_Urls=imageRoot.get(0).getPicUrl();
	  
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return pic_Urls.size();
	}
	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return pic_Urls.get(position);
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
			convertView=inflater.inflate(R.layout.horizontal_list_item, null);
			holder=new ViewHolder();
			holder.iv_photo=(ImageView) convertView.findViewById(R.id.img_list_item);
			holder.tv_Detailtile=(TextView) convertView.findViewById(R.id.text_list_item);
			convertView.setTag(holder);
			
		}
		holder=(ViewHolder) convertView.getTag();
		Pic_Url pic_Url=pic_Urls.get(position);
		if (pic_Url.getPic_title()!=null) {
			holder.tv_Detailtile.setText(pic_Url.getPic_title());
		}else {
			holder.tv_Detailtile.setText("历史再现");
		}
		if (pic_Url.getUrl()!=null) {
			Glide
		    .with(EnentApplication.getContext())
		    .load(pic_Url.getUrl())
		    .transform(new GlideCircleTransform(context))
	        
		    .into(holder.iv_photo);
		}
	   
		  
		return convertView;
	}
	
class ViewHolder{
	 ImageView iv_photo;
	 TextView tv_Detailtile;
}
	 

}
