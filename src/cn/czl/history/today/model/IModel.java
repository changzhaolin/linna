package cn.czl.history.today.model;

 

public interface IModel {
	
	 public interface AsyncCallback{
		 void Success(Object success);
		 void Fail(Object fail);
	 }

}
