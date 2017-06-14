package cn.czl.history.today.model.impl;

import java.util.List;
import java.util.ListIterator;

import android.util.Log;
import cn.czl.history.today.app.EnentApplication;
import cn.czl.history.today.entity.ImageRoot;
import cn.czl.history.today.entity.Pic_Url;
import cn.czl.history.today.entity.TwoImagesRoot;
import cn.czl.history.today.model.ITwoEventImageModel;

import com.android.volley.Request.Method;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

public class TwoEventImageDetailModelImpl implements ITwoEventImageModel {
 private RequestQueue queue;
 
	public TwoEventImageDetailModelImpl() {
	super();
	this.queue = Volley.newRequestQueue(EnentApplication.getContext());
}

	@Override
	public void loadTwoEventDetail(final AsyncCallback callback, int id) {
		// TODO Auto-generated method stub
		String url="http://v.juhe.cn/todayOnhistory/queryDetail.php?key=78c224b340950943432c8d5a7e8888c2&e_id="+id+"";
		StringRequest sRequest=new StringRequest(Method.POST, url, new Listener<String>() {

			@Override
			public void onResponse(String response) {
				// TODO Auto-generated method stub
				
				Gson gson=new Gson();
				TwoImagesRoot twoImagesRoot=gson.fromJson(response, TwoImagesRoot.class);
	 
				 List<ImageRoot> imageRoot = twoImagesRoot.getResult();
			 
//					Log.d("info", "详细数据3"+imageRoot);
//				 
//		             List<Pic_Url> pic_Url=imageRoot.get(0).getPicUrl();
//		             Log.d("info", "详细数据3"+pic_Url);
		             callback.Success(imageRoot);
		              
			}
		}, new Response.ErrorListener() {

			@Override
			public void onErrorResponse(VolleyError error) {
				// TODO Auto-generated method stub
				
			}
		});
		queue.add(sRequest);
	}
       

}
