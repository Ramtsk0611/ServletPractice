package com.example.servletpractice;

import java.io.*;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class RegisterTeacher extends HttpServlet
{
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        int id = Integer.parseInt(request.getParameter("TId"));
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        try
        {
            //load the driver
            Class.forName("oracle.jdbc.driver.OracleDriver");
            //create connection object
            Connection con=DriverManager.getConnection( "jdbc:oracle:thin:@localhost:1521:xe","local","test");
            // create the prepared statement object
            PreparedStatement ps=con.prepareStatement("insert into TeacherDetails values(?,?,?)");

            ps.setInt(1, id);
            ps.setString(2,name);
            ps.setString(3,address);

            int i = ps.executeUpdate();
            if(i>0)
                out.print("You are successfully registered...");
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        out.close();
    }
}