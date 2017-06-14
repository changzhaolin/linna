package cn.czl.history.today.activity;

import java.io.Serializable;
import java.util.List;

import org.yanzi.ui.HorizontalListView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.ImageLoader.ImageListener;
import com.bumptech.glide.Glide;

import cn.czl.history.today.R;
import cn.czl.history.today.R.layout;
import cn.czl.history.today.R.menu;
import cn.czl.history.today.adapter.ImagesAdapter;
import cn.czl.history.today.app.EnentApplication;
import cn.czl.history.today.entity.ImageRoot;
import cn.czl.history.today.entity.Pic_Url;
import cn.czl.history.today.entity.TwoEvent;
import cn.czl.history.today.presenter.ITwoImageDetailPresenter;
import cn.czl.history.today.presenter.impl.TwoEventImageDetailPresenterImpl;
import cn.czl.history.today.util.GlideCircleTransform;

import cn.czl.history.today.view.ITwoImage;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class TwoDetailActivity extends Activity implements ITwoImage{
	private TwoEvent twoEvent;
	private ITwoImageDetailPresenter presenter;
	private ImagesAdapter adapter;
	private List<ImageRoot> imageRoot;
	private List<Pic_Url>pic_Urls;
	private HorizontalListView listView;
	private TextView tile;
	private TextView tv_content;
	private ImageView iv_pressImage;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_two_detail);
		listView=  (HorizontalListView) findViewById(R.id.horizon_listview);
		tile=(TextView) findViewById(R.id.tv_Detail_Tile);
		tv_content=(TextView) findViewById(R.id.tv_DetailContent);
		iv_pressImage=(ImageView) findViewById(R.id.image_preview);
		presenter=new TwoEventImageDetailPresenterImpl(this);
		
		Intent intent=getIntent();
		  twoEvent = (TwoEvent) intent.getSerializableExtra("twoEvent");
		 presenter.loadTwoEventDetail(Integer.parseInt(twoEvent.getE_id()));
		//  presenter.loadTwoEventDetail(1);
		  setListeners();
	}
 
	private void setListeners() {
		// TODO Auto-generated method stub
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				 Pic_Url pic_Url=pic_Urls.get(position);
				 Glide
				    .with(EnentApplication.getContext())
				    .load(pic_Url.getUrl())
				    .transform(new GlideCircleTransform(getApplicationContext()))
			        
				    .into(iv_pressImage);
				  
			}
		});
	}

	@Override
	public void showTwoImage(List<ImageRoot> imageRoot) {
		 this.imageRoot=imageRoot;
		 this.pic_Urls=imageRoot.get(0).getPicUrl();
		 tile.setText(imageRoot.get(0).getTitle());
		 tv_content.setText(imageRoot.get(0).getContent());
		 if (pic_Urls!=null) {
			 adapter=new ImagesAdapter(TwoDetailActivity.this, imageRoot, pic_Urls);
			 listView.setAdapter(adapter);
		}
		 
		
	}

}
