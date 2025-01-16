package com.koreait.app;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestServlet1
 */
//@WebServlet("/Hello")
//현재 서블릿을 상속받아 만든 서블릿 클래스와 URL 경로를 서로 매핑시켜주는 역할을 한다
//즉 사용자가 우리 서버 주소 뒤에 /Hello 작성하면 현재 서블릿이 요청을 받게 되는 것
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TestServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	// doGe().메소드는 get 요청이 들어오면 실행되는 메소드
	// 요청을 담아줄 매개변수와 응답을 담을 매개변수 2개가 필요하다

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// getWriter() 메소드는 화면에 출력을 하기 위해 사용하며 출력 스트림을 반환(출력하는 객체)/ 이 객체를 사용하면 사용자의 화면에
		// 글씨를 뿌려줄 수 있음
		// append()메소드는 문자열을 연결해주는 메소드
		// request.getContextPath() : 리퀘스트 객체로부터 ContextPath 라는 것을 얻어오는데 컨텍스트패스는 현재 우리의
		// 사이트, 우리의 웹 어플리케이션의 루트 경로를 의미
		// 루트 경로 : 최상위 경로를 의미하며 이 서버의 가장 상위 경로를 의미

//		response.getWriter().append("Serverd at : ").append(request.getContextPath());
		
		//응답하는 컨텐츠가 html이고 문자 인코딩은 YTF-8을 사용할거라는 설정
		response.setContentType("text/html;charset=UTF-8");
		//PrinterWrite 객체를 사용하면 응답에 텍스트 데이터를 추가할 수 있음
		//추가된 데이터는 사용자의 웹 브라우저 화면에 출력
		//print() 메소드를 사용하여 출력해줄 수 있음
		
		//서블릿은 자바코드 안에 html코드/ jsp는 반대
//		PrintWriter out = response.getWriter();
//		out.print("<html>"); //out.print() : PrintWriter 객체를 사용하여 HTML코드를 생성하고 브라우저로 전송
//		out.print("<head>");
//		out.print("<title>서블릿</title>");
//		out.print("</head>");
//		out.print("</body>");
//		out.print("<h1>안녕하세요</h1>");
//		out.print("</body>");
//		out.print("</html>");
//		out.close();
		
		//web.xml 작성 후 요청받은 내용 화면에 뿌려주기
//		request가 가지고 있는 객체를 꺼내고 싶다면 getParameter()메소드를 사용
//		get{arameter (String arg) 꺼내고 싶은 데이터의 이름을 넘겨주면 됨
//		데이터의 이름은 html에 작성한 태그의 name태그의 값과 동일
		String result = request.getParameter("userName");
		System.out.println(result);
		
		
//		response 객체는 getWriter()을 가지고 있음
//		getWriter()의 반환타입은 PrintWriter
//		즉 PrintWriter 객체를 반환하며 이 객체는 스트림을 사용하는 출력 객체
//		이 객체에 print()메소드를 사용하면 클라이언트 화면에 보여줄 문자열을 응답객체에 담을 수 있음
//		response.setContentType("text/html; charset=UTF-8");
//		//ContentType은 현재 페이지의 컨텐츠들을 의미, 다른 의미로는 현재 페이지에 뿌려지는 데이터들의 정보를 담고 있음
//		//응답을 할 때도 올바르게 설정되어 있어야 브라우저가 정확하게 해석하고 화면을 보여줄 수 있음
//		PrintWriter out = response.getWriter();
//		out.print("<h1>" + request.getParameter("userName") + "님 환영합니다</h1>");
		//getParameter()메소드는 jsp(화면)에서 사용할 목적으로 만들어지지 않음
		//서블릿에서 사용할 메소드
		
//		out.close();
		//위의 코드도 여전히 서블릿 형식을 사용하고 있으므로 결과 페이지를 만들 result.jsp파일을 만들고 jsp파일로 실행
		
		//forward 방식 사용
		//getRequestDispatcher("경로").forward(request, response)
		//다른 서블릿이나 jsp로 요청을 전달
		//주로 클라이언트의 요청을 받아 다른 페이지로 이동을 시킬때 사용
		//getRequsetDispatcher는 request 객체가 가지고 있으며 request 객체를 전달할 파일 경로를 매개변수로 넘겨줘야 함
		//forward()에 request객체를 넘겨주므로 request가 가지고 있는 데이터를 유지한채로 jsp파일로 이동
		request.setAttribute("userName", request.getParameter("userName"));
		request.getRequestDispatcher("result.jsp").forward(request, response);
		
	}

	// http://localhost:8888/day01/Hello
	// day01 : 컨텍스트패스 경로(루트 경로)
	// /Hello : 우리 서버에 있는 서블릿의 경로

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
