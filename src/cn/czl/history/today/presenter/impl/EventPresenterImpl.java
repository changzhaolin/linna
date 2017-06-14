package cn.czl.history.today.presenter.impl;

import java.util.List;

import android.util.Log;

import cn.czl.history.today.entity.Events;
import cn.czl.history.today.entity.IdEvents;
import cn.czl.history.today.model.IEventModel;
import cn.czl.history.today.model.IModel.AsyncCallback;
import cn.czl.history.today.model.impl.EventModelImpl;
import cn.czl.history.today.presenter.IEventPresenter;
import cn.czl.history.today.view.IEventView;

public class EventPresenterImpl implements IEventPresenter{
	private IEventView view;
	private IEventModel model;
	

	public EventPresenterImpl(IEventView view) {
		super();
		this.view = view;
		this.model=new EventModelImpl();
	}


	@Override
	public void loadEnvents(int mouth,int day) {
		// TODO Auto-generated method stub
		model.LoadInfo(new AsyncCallback() {
			
			@Override
			public void Success(Object success) {
				// TODO Auto-generated method stub
				view.showEvent((List<Events>) success);
			}
			
			@Override
			public void Fail(Object fail) {
				// TODO Auto-generated method stub
				
			}
		},mouth,day);
	}


	@Override
	public void SearchEnvents(int id) {
		// TODO Auto-generated method stub
		model.SearchInfo(new AsyncCallback() {
			
			@Override
			public void Success(Object success) {
				// TODO Auto-generated method stub
				Log.e("info","³É¹¦"+success);
				view.showIdEvent((List<IdEvents>)success);
			}
			
			@Override
			public void Fail(Object fail) {
				// TODO Auto-generated method stub
				
			}
		}, id);
	}
	

}
