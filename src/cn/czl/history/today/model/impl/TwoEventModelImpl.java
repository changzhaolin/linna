package cn.czl.history.today.model.impl;

import java.util.List;

import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.android.volley.Request.Method;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.JsonArray;

import cn.czl.history.today.app.EnentApplication;
import cn.czl.history.today.entity.TwoEvent;
import cn.czl.history.today.entity.TwoImagesRoot;
import cn.czl.history.today.entity.TwoRoot;
import cn.czl.history.today.model.ITwoEventModel;

public class TwoEventModelImpl implements ITwoEventModel{
	
	private RequestQueue queue;
	public TwoEventModelImpl() {
		super();
		this.queue = Volley.newRequestQueue(EnentApplication.getContext());
	}
	/**
	 * 网络获取数据的方法
	 */

	@Override
	public void loadTwoInfo(final AsyncCallback callback, String date) {
		// TODO Auto-generated method stub
		String url="http://v.juhe.cn/todayOnhistory/queryEvent.php?key=78c224b340950943432c8d5a7e8888c2&date="+date+"";
		StringRequest sRequest=new StringRequest(Method.POST, url, new Listener<String>() {

			@Override
			public void onResponse(String response) {
				// TODO Auto-generated method stub
				//Log.e("2.0数据", "2.0数据"+response);
				//Gson gson=new Gson();
				TwoRoot twoRoot= JSON.parseObject(response,TwoRoot.class);
				List<TwoEvent>twoEvents=twoRoot.getResult();
			//	Log.e("2.0数据", "2.0详细数据"+twoEvents);
				if (twoEvents!=null) {
					callback.Success(twoEvents);
				}
				
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
