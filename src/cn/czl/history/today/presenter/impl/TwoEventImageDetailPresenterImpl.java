package cn.czl.history.today.presenter.impl;

import java.util.List;

import cn.czl.history.today.entity.ImageRoot;
import cn.czl.history.today.model.IModel.AsyncCallback;
import cn.czl.history.today.model.ITwoEventImageModel;
import cn.czl.history.today.model.impl.TwoEventImageDetailModelImpl;
import cn.czl.history.today.presenter.ITwoImageDetailPresenter;
import cn.czl.history.today.view.ITwoImage;

public class TwoEventImageDetailPresenterImpl implements ITwoImageDetailPresenter{
private ITwoImage view;
private ITwoEventImageModel model;

	public TwoEventImageDetailPresenterImpl(ITwoImage view
		 ) {
	super();
	this.view = view;
	this.model = new TwoEventImageDetailModelImpl();
}

	@Override
	public void loadTwoEventDetail(int id) {
		// TODO Auto-generated method stub
		model.loadTwoEventDetail(new AsyncCallback() {
			
			@Override
			public void Success(Object success) {
				// TODO Auto-generated method stub
				view.showTwoImage((List<ImageRoot>)success);
			}
			
			@Override
			public void Fail(Object fail) {
				// TODO Auto-generated method stub
				
			}
		}, id);
	}

	 

}
