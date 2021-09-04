package com;

import com.etc.dao.impdetaildao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DelServlet", value = "/DelServlet")
public class DelServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        impdetaildao impdetaildao = new impdetaildao();
        impdetaildao.del(id);
        PrintWriter out = response.getWriter();
        out.print("<script> window.location.href ='http://localhost:8080/jsp/userindex.jsp' </script>");
//        System.out.println(id);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
