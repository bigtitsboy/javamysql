package com;

import com.etc.dao.impdetaildao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "LikeServlet", value = "/LikeServlet")
public class LikeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String val = request.getParameter("val");
        impdetaildao impdetaildao = new impdetaildao();
        ArrayList likearrayList = impdetaildao.likeselect(val);
        HttpSession session=request.getSession();
        session.setAttribute("likearry",likearrayList);
        PrintWriter out = response.getWriter();
        out.print("<script> window.location.href ='http://localhost:8080/jsp/likesearch.jsp' </script>");
//        System.out.println(session.getAttribute("likearry"));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
