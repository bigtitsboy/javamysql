package com;

import com.etc.dao.impdetaildao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "EditServlet", value = "/EditServlet")
public class EditServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        int id = Integer.parseInt(request.getParameter("id"));
        String uname = request.getParameter("uname");
        String userPass = request.getParameter("userPass");
        int idkey = Integer.parseInt(request.getParameter("oldid"));
        impdetaildao impdetaildao = new impdetaildao();
        impdetaildao.update(id, uname, userPass, idkey);
        PrintWriter out = response.getWriter();
        out.print("<script> window.location.href ='http://localhost:8080/jsp/userindex.jsp' </script>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
