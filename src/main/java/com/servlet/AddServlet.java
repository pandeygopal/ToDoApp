package com.servlet;

import java.io.IOException;

import com.DAO.TodoDAO;
import com.db.DBConnect;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class AddServlet extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String username = req.getParameter("username");
		String todo = req.getParameter("todo");
		String status = req.getParameter("status");
		TodoDAO dao = new TodoDAO(DBConnect.getConn());
		boolean f = dao.addTodo(username, todo, status);
		HttpSession session = req.getSession();
		if (f) {
			session.setAttribute("sucMSG", "TODO added successfully");
			resp.sendRedirect("index.jsp");

		} else {
			session.setAttribute("failedMSG", "TODO failed!!");
			resp.sendRedirect("index.jsp");
		}

	}

}
