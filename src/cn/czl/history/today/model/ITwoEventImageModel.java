package cn.czl.history.today.model;

public interface ITwoEventImageModel extends IModel{
	/**
	 * 请求数据然后回调的方法
	 * @param callback
	 * @param id
	 */
	
	public void loadTwoEventDetail(AsyncCallback callback,int id);

}
