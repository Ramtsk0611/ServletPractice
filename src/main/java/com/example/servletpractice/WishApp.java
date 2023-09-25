package com.example.servletpractice;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class WishApp extends HttpServlet
{
    public void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
    {
        //set response content type
        res.setContentType("text/html");
        //get printWrite obj
        PrintWriter pw = res.getWriter();
        //write request processing logic to generate wish message
        Calendar cal = Calendar.getInstance();
        //get current hours of the day
        int hour = cal.get(Calendar.HOUR_OF_DAY);//24 hrs format
        //generate wish message
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