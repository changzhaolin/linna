package cn.czl.history.today.model;

public interface ITwoEventImageModel extends IModel{
	/**
	 * ��������Ȼ��ص��ķ���
	 * @param callback
	 * @param id
	 */
	
	public void loadTwoEventDetail(AsyncCallback callback,int id);

}
