package com.servlet;

import java.io.IOException;
import com.DAO.TodoDAO;
import com.db.DBConnect;
import com.entity.TodoDtls;
import jakarta.security.auth.message.callback.PrivateKeyCallback.Request;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/delete")
public class deleteServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		TodoDAO dao = new TodoDAO(DBConnect.getConn());
		boolean f = dao.deleteTodo(id);
		HttpSession session = req.getSession();
		if (f) {
			session.setAttribute("sucMSG", "TODO Deleted successfully");
			resp.sendRedirect("index.jsp");
		} else {
			session.setAttribute("failedMSG", "Something wrong in server");
			resp.sendRedirect("index.jsp");
		}
	}

}
