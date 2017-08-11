package com.jiudianlianxian.entity;

/**
 * 
 * Title: BaseResult
 * Description: ������Ϣbase��
 * Company: �����ŵ�������Ϣ�������޹�˾
 * ProjectName: ShoppingMall
 * @author fupengpeng
 * @date 2017��8��3�� ����4:27:28
 *
 */
public class BaseResult {
	
	private int code;
	private String info;
	
	public BaseResult(){}
	
	public BaseResult(int code, String info) {
		super();
		this.code = code;
		this.info = info;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	
	

}
