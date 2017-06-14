package cn.czl.history.today.presenter.impl;

import java.util.List;

import cn.czl.history.today.entity.TwoEvent;
import cn.czl.history.today.model.IModel.AsyncCallback;
import cn.czl.history.today.model.ITwoEventModel;
import cn.czl.history.today.model.impl.TwoEventModelImpl;
import cn.czl.history.today.presenter.ITwoEventPresenter;
import cn.czl.history.today.view.ITwoEventView;

public class TwoEventPresenterImpl implements ITwoEventPresenter{
	private ITwoEventView view;
	private ITwoEventModel model;
	

	public TwoEventPresenterImpl(ITwoEventView view) {
		super();
		this.view = view;
		this.model=new TwoEventModelImpl();
	}


	@Override
	public void loadTwoEvent(String date) {
		// TODO Auto-generated method stub
		model.loadTwoInfo(new AsyncCallback() {
			
			@Override
			public void Success(Object success) {
				// TODO Auto-generated method stub
				view.showTwoEvent((List<TwoEvent>)success);
			}
			
			@Override
			public void Fail(Object fail) {
				// TODO Auto-generated method stub
				
			}
		}, date);
	}

}
