package cn.czl.history.today.entity;

import java.util.List;

public class TwoImagesRoot {

	private String reason;
	private List<ImageRoot> result;
	private int  error_code;
	public TwoImagesRoot(String reason, List<ImageRoot> result, int error_code) {
		super();
		this.reason = reason;
		this.result = result;
		this.error_code = error_code;
	}
	public TwoImagesRoot() {
		super();
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public List<ImageRoot> getResult() {
		return result;
	}
	public void setResult(List<ImageRoot> result) {
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
		return "TwoImagesRoot [reason=" + reason + ", result=" + result
				+ ", error_code=" + error_code + "]";
	}
	 
	

}
