package com.jiudianlianxian.entity.result;

import com.jiudianlianxian.entity.BaseResult;
import com.jiudianlianxian.entity.data.VerificationCodeData;


/**
 * 
 * Title: VerificationCodeResult
 * Description: ��ȡ��֤�뷵��ʵ����
 * Company: �����ŵ�������Ϣ�������޹�˾
 * ProjectName: Taoke
 * @author fupengpeng
 * @date 2017��8��8�� ����5:12:41
 *
 */
public class VerificationCodeResult extends BaseResult {
	
	private VerificationCodeData verificationCodeData;

	public VerificationCodeData getVerificationCodeData() {
		return verificationCodeData;
	}

	public void setVerificationCodeData(VerificationCodeData verificationCodeData) {
		this.verificationCodeData = verificationCodeData;
	}
	

}
