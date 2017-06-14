package org.yanzi.ui;

import com.bumptech.glide.BitmapTypeRequest;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.media.ThumbnailUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import cn.czl.history.today.R;
import cn.czl.history.today.app.EnentApplication;
import cn.czl.history.today.util.GlideCircleTransform;
 

public class HorizontalListViewAdapter extends BaseAdapter{
	private int[] mIconIDs;
	private String[] mTitles;
	private Context mContext;
	private LayoutInflater mInflater;
	Bitmap iconBitmap;
	private int selectIndex = -1;

	public HorizontalListViewAdapter(Context context, String[] titles, int[] ids){
		this.mContext = context;
		this.mIconIDs = ids;
		this.mTitles = titles;
		mInflater=(LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);//LayoutInflater.from(mContext);
	}
	@Override
	public int getCount() {
		return mIconIDs.length;
	}
	@Override
	public Object getItem(int position) {
		return position;
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		ViewHolder holder;
		if(convertView==null){
			holder = new ViewHolder();
			convertView = mInflater.inflate(R.layout.horizontal_list_item, null);
			holder.mImage=(ImageView)convertView.findViewById(R.id.img_list_item);
			holder.mTitle=(TextView)convertView.findViewById(R.id.text_list_item);
			convertView.setTag(holder);
		}else{
			holder=(ViewHolder)convertView.getTag();
		}
		if(position == selectIndex){
			convertView.setSelected(true);
		}else{
			convertView.setSelected(false);
		}
		
		holder.mTitle.setText(mTitles[position]);
		iconBitmap = getPropThumnail(mIconIDs[position]);
		holder.mImage.setImageBitmap(iconBitmap);

		return convertView;
	}

	private static class ViewHolder {
		private TextView mTitle ;
		private ImageView mImage;
	}
	private Bitmap getPropThumnail(int id){
		Drawable d = mContext.getResources().getDrawable(id);
		 
		Glide.with(mContext).load(d).asBitmap().into(new SimpleTarget<Bitmap>() {  
            @Override  
            public void onResourceReady(Bitmap b, GlideAnimation<? super Bitmap> glideAnimation) {  
            	int w = mContext.getResources().getDimensionPixelOffset(R.dimen.thumnail_default_width);
        		int h = mContext.getResources().getDimensionPixelSize(R.dimen.thumnail_default_height);
        		
        		Bitmap thumBitmap = ThumbnailUtils.extractThumbnail(b, w, h);
            }  
        });
		return iconBitmap; 
	   
	    
//		Bitmap bb = BitmapUtil.getRoundedCornerBitmap(b, 100);
	
		
		 
	}
	public void setSelectIndex(int i){
		selectIndex = i;
	}
}