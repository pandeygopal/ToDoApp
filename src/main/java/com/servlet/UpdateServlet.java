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

@WebServlet("/update")
public class UpdateServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		String username = req.getParameter("username");
		String todo = req.getParameter("todo");
		String status = req.getParameter("status");
		TodoDAO dao = new TodoDAO(DBConnect.getConn());
		TodoDtls t = new TodoDtls();
		t.setId(id);
		t.setName(username);
		t.setTodo(todo);
		t.setStatus(status);
		boolean f = dao.updateTodo(t);
		HttpSession session = req.getSession();
		if (f) {
			session.setAttribute("sucMSG", "TODO Updated successfully");
			resp.sendRedirect("index.jsp");
		} else {
			session.setAttribute("failedMSG", "Something wrong in server");
			resp.sendRedirect("index.jsp");
		}

	}

}
