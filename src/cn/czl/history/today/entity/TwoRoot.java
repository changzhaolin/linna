package cn.czl.history.today.entity;

import java.util.List;

public class TwoRoot {
	
	private String reason;

	private List<TwoEvent> result ;

	private int error_code;

	public TwoRoot(String reason, List<TwoEvent> result, int error_code) {
		super();
		this.reason = reason;
		this.result = result;
		this.error_code = error_code;
	}

	public TwoRoot() {
		super();
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public List<TwoEvent> getResult() {
		return result;
	}

	public void setResult(List<TwoEvent> result) {
		this.result = result;
	}

	public int getError_code() {
		return error_code;
	}

	public void setError_code(int error_code) {
		this.error_code = error_code;
	}

	@Override
	public String toString() {
		return "TwoRoot [reason=" + reason + ", result=" + result
				+ ", error_code=" + error_code + "]";
	}
	

}
