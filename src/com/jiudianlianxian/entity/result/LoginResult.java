package com.jiudianlianxian.entity.result;

import com.jiudianlianxian.entity.BaseResult;
import com.jiudianlianxian.entity.data.LoginData;



/**
 * 
 * Title: LoginResult
 * Description: ��¼������Ϣ
 * Company: �����ŵ�������Ϣ�������޹�˾
 * ProjectName: Taoke
 * @author fupengpeng
 * @date 2017��8��11�� ����4:44:18
 *
 */
public class LoginResult extends BaseResult {
	
	private LoginData loginData;

	public LoginData getLoginData() {
		return loginData;
	}

	public void setLoginData(LoginData loginData) {
		this.loginData = loginData;
	}
	
	
	

}
