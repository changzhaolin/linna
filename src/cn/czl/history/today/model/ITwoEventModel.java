package cn.czl.history.today.model;

public interface ITwoEventModel extends IModel{
	
	/**
	 * �ص������ȡ������
	 * @param callback
	 * @param date
	 */
	
	public void loadTwoInfo(AsyncCallback callback ,String date);

}
