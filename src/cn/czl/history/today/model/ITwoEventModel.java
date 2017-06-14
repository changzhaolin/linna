package cn.czl.history.today.model;

public interface ITwoEventModel extends IModel{
	
	/**
	 * 回调网络获取的数据
	 * @param callback
	 * @param date
	 */
	
	public void loadTwoInfo(AsyncCallback callback ,String date);

}
