package com.saeyan.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/upload.do")
public class uploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); //받을 때
		
		response.setContentType("text/html; charset=utf-8"); //보낼때
		
		PrintWriter out = response.getWriter();
		
		String savePath = "upload"; //업로드 경로
		
		int uploadFileSizeLimit = 5*1025*1024; //파일 최대 업로드 크기 5mb로 제한
		String encType = "UTF-8";
		
		ServletContext context = getServletContext();
		String uploadFilePath = context.getRealPath(savePath);
		
		System.out.println("서버상 실제 폴더 : " + uploadFilePath );
		
		try {
			MultipartRequest multi = new MultipartRequest(request, uploadFilePath, uploadFileSizeLimit, encType, new DefaultFileRenamePolicy());
			String fileName = multi.getFilesystemName("uploadFile");
			
			if(fileName == null) {
				System.out.println("파일 업로드 되지 않았음");
			}else {
				out.println("<br> 글쓴이 : " + multi.getParameter("name"));
				out.println("<br> 제 &nbsp 목 : " + multi.getParameter("title"));
				out.println("<br> 파일명 : " + fileName);
			}
		}catch(Exception e) {
			System.out.println("예외 발생 : " + e);
		}
	
	}

}
