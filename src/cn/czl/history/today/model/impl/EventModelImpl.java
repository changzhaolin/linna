package cn.czl.history.today.model.impl;

import java.util.List;



import android.R.string;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Request.Method;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import cn.czl.history.today.app.EnentApplication;
import cn.czl.history.today.entity.Events;
import cn.czl.history.today.entity.IdEvents;
import cn.czl.history.today.entity.IdRoot;
import cn.czl.history.today.entity.Root;
import cn.czl.history.today.model.IEventModel;
import cn.czl.history.today.mylog.MyLog;
 
 

public class EventModelImpl implements IEventModel{
	 
	private RequestQueue queue;
	

	public EventModelImpl() {
		 this.queue=Volley.newRequestQueue(EnentApplication.getContext());
	}
 
	@Override
	public void LoadInfo(final AsyncCallback callback,int mouth,int day) {
		// TODO Auto-generated method stub
		String url="http://api.juheapi.com/japi/toh?key=78c224b340950943432c8d5a7e8888c2&v=1.0&month="+mouth+"&day="+day+"";
		
		StringRequest sRequest=new StringRequest(Request.Method.POST, url, new Listener<String>() {

			@Override
			public void onResponse(String response) {
				// TODO Auto-generated method stub
			 
				Gson gson=new Gson();
				Root root = gson.fromJson(response, Root.class);
				List<Events>events=root.getResult();
				MyLog.d("History", "历史事件"+events);
				if (events!=null) {
				 
						
					 
					callback.Success(events);	
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





	@Override
	public void SearchInfo(final AsyncCallback callback, int id) {
		// TODO Auto-generated method stub
		String url="http://api.juheapi.com/japi/tohdet?key=78c224b340950943432c8d5a7e8888c2&v=1.0&id="+id+"";
		StringRequest sRequest=new StringRequest(Method.POST, url, new Listener<String>() {

			@SuppressWarnings("unused")
			@Override
			public void onResponse(String response) {
				// TODO Auto-generated method stub
				 
				Gson gson=new Gson();
				 
				  IdRoot idroot = gson.fromJson(response, IdRoot.class);
				 
			
				 List<IdEvents>events = idroot.getResult();
				
				
			  
			    if (events!=null) {
			    	callback.Success(events);
				}else {
					Toast.makeText(EnentApplication.getContext(), "该历史事件没有详情", Toast.LENGTH_LONG).show();
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
