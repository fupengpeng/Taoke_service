package com.jiudianlianxian.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.jiudianlianxian.domain.User;
import com.jiudianlianxian.entity.data.RegisterData;
import com.jiudianlianxian.entity.data.VerificationCodeData;
import com.jiudianlianxian.entity.result.RegisterResult;
import com.jiudianlianxian.entity.result.VerificationCodeResult;
import com.jiudianlianxian.service.UsersService;


/**
 * 
 * Title: RegisterServlet
 * Description: ע��
 * Company: �����ŵ�������Ϣ�������޹�˾
 * ProjectName: Taoke
 * @author fupengpeng
 * @date 2017��8��8�� ����5:52:50
 *
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {

	private static final int SUCCESS = 0;
	private static final int ERROR = 1;
	/**
	 * Constructor of the object.
	 */
	public RegisterServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		// �����û��ύ���û���������
		String phonenumber = request.getParameter("phonenumber");
		String password = request.getParameter("password");
		
		User user = new User();
		user.setPhonenumber(phonenumber);
		user.setPassword(password);
		UsersService usersService = new UsersService();
		
		RegisterResult registerResult = new RegisterResult();
		String jsonObject;
		
		try {
			if (usersService.register(user)) {
				
				registerResult.setCode(SUCCESS);
				registerResult.setInfo("ע��ɹ�");
				registerResult.setRegisterData(new RegisterData());
				jsonObject = JSONObject.toJSONString(registerResult);
				
			} else {
				
				registerResult.setCode(ERROR);
				registerResult.setInfo("ע��ʧ��");
				registerResult.setRegisterData(new RegisterData());
				jsonObject = JSONObject.toJSONString(registerResult);

			}
			PrintWriter printWriter = response.getWriter();
			printWriter.write(jsonObject);
			printWriter.close();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
