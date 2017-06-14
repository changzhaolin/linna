
package cn.czl.history.today.view;

import java.util.List;

import cn.czl.history.today.entity.Events;
import cn.czl.history.today.entity.IdEvents;

public interface IEventView { 
	/**
	 * ��ʾ��ʷ�¼�
	 * @param events
	 */
	
	void showEvent(List<Events>events);
	/**
	 * ͨ����ʷ�¼�Id����
	 * @param events
	 */
	void showIdEvent(List<IdEvents> events);

}
