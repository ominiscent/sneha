package com.cdac.singer.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cdac.singer.dao.SingerDao;
import com.cdac.singer.dao.SingerDaoImpl;
import com.cdac.singer.model.Singer;


@WebServlet("/SingerRegistrationServlet")
public class SingerRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


    public SingerRegistrationServlet() {
        
    }
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		int id=Integer.parseInt(request.getParameter("id"));
		String name=request.getParameter("name");
		String type=request.getParameter("type");
		
		Singer s=new Singer(id,name,type);
		SingerDao sd=new SingerDaoImpl();
//		if(sd.insert(s))
//		out.println("record inserted");
//		else
//			System.out.println("not inserted");
		
		boolean f=sd.validate(s);
		
		if(!f)
		{
			sd.insert(s);
			out.println("<html><body><h1>Record Inserted</h1></body></html>");
			
		}
		else
		{
			out.println("<html><body><h1>Record Already Exists</h1></body></html>");
		}
		
	}

}
