package cn.czl.history.today.entity;

import java.util.List;

public class Root {
	   private int error_code;
	   private String reason;
	   private List<Events>result;
	public Root(int error_code, String reason, List<Events> result) {
		super();
		this.error_code = error_code;
		this.reason = reason;
		this.result = result;
	}
	public Root() {
		super();
	}
	public int getError_code() {
		return error_code;
	}
	public void setError_code(int error_code) {
		this.error_code = error_code;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public List<Events> getResult() {
		return result;
	}
	public void setResult(List<Events> result) {
		this.result = result;
	}
	@Override
	public String toString() {
		return "Root [error_code=" + error_code + ", reason=" + reason
				+ ", result=" + result + "]";
	}
	   

}
