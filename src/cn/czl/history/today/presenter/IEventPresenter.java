package cn.czl.history.today.presenter;

public interface IEventPresenter {
	
	
	/**
	 * ����Ҫ��ʾ���¼�
	 * @param info
	 */
	public void loadEnvents(int mouth,int day);
	/**
	 * ͨ���¼�id��ѯ��ʷ�¼�
	 * @param id
	 */
	public void SearchEnvents(int id);
	

}
