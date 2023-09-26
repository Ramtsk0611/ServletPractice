package com.example.servletpractice;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

public class SessionDemo extends HttpServlet
{
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        HttpSession session = request.getSession(true);
        Date createTime = new Date(session.getCreationTime());
        Date lastAccessTime = new Date(session.getLastAccessedTime());
        String title = "Welcome Back to my website";
        Integer visitCount;
        String visitCountKey = new String("visitCount");
        String userIDKey = new String("userID");
        String userID = new String("Surendra");
        visitCount = (Integer)session.getAttribute(visitCountKey);
        if (visitCount == null || userIDKey == null)
        {
            title = "Welcome to my website";
            session.setAttribute(userIDKey, userID);
            visitCount = 0;
        }
        visitCount = visitCount + 1;
        session.setAttribute(visitCountKey,  visitCount);
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String docType =
                "<!doctype html public \"-//w3c//dtd html 4.0 " +
                        "transitional//en\">\n";
        out.println(docType +
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n" +
                "<body bgcolor=\"#e5f7c0\">\n" +
                "<h1 align=\"center\">" + title + "</h1>\n" +
                "<h2 align=\"center\">Session Infomation</h2>\n" +
                "<table border=\"1\" align=\"center\">\n" +
                "<tr bgcolor=\"#eadf8c\">\n" +
                "<th>Session info</th><th>value</th></tr>\n" +
                "<tr>\n" +
                "  <td>id</td>\n" +
                "  <td>" + session.getId() + "</td></tr>\n" +
                "<tr>\n" +
                "  <td>Creation Time</td>\n" +
                "  <td>" + createTime +
                "  </td></tr>\n" +
                "<tr>\n" +
                "  <td>Time of Last Access</td>\n" +
                "  <td>" + lastAccessTime +
                "  </td></tr>\n" +
                "<tr>\n" +
                "  <td>User ID</td>\n" +
                "  <td>" + userID +
                "  </td></tr>\n" +
                "<tr>\n" +
                "  <td>Number of visits</td>\n" +
                "  <td>" + visitCount + "</td></tr>\n" +
                "</table>\n" +
                "</body></html>");
    }
}