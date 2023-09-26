package com.example.servletpractice;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class WishApp extends HttpServlet
{
    public void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
    {
        res.setContentType("text/html");
        PrintWriter pw = res.getWriter();
        Calendar cal = Calendar.getInstance();
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        if(hour<12)
            pw.println("Good Morning!!");
        else if (hour < 16)
            pw.println("Good afternoon");
        else if(hour<20)
            pw.println("Good evening");
        else
            pw.println("Good night");

        pw.println("<br><br><a href= '../ServletPractice/'>Home</a>");
        //close stream object
        pw.close();
    }
}