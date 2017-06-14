package cn.czl.history.today.entity;

import java.util.List;

public class IdRoot {
	 
	private int error_code;// 0,
	private String  reason;//: "«Î«Û≥…π¶£°",
	private List<IdEvents> result;
	
	public IdRoot() {
		super();
	}

	public IdRoot(int error_code, String reason, List<IdEvents> result) {
		super();
		this.error_code = error_code;
		this.reason = reason;
		this.result = result;
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

	public List<IdEvents> getResult() {
		return result;
	}

	public void setResult(List<IdEvents> result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "IdRoot [error_code=" + error_code + ", reason=" + reason
				+ ", result=" + result + "]";
	}
	 
	 
	
}
