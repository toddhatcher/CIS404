/*
File Name: TextServlet.java
      Author: Todd Hatcher
  Assignment: 3.1
        Date: 08/31/2021
       Class: CIS 404-A349

 Description: This servlet file is part of an ASCII Text Reader project on 
              Netbeans. The following Servlet code creates a path to a file 
              located in C:\temp\  which is then made into an input stream that 
              then opens a buffered reader. A print writer object is also used 
              so that each row of buffered reader is output to the browser that 
              accesses this servlet. 
*/

package hatcher;

import java.nio.file.*;
import java.nio.file.Paths;
import java.io.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TextServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html");   
        
        // Set Path to file location using the absolute path
        Path file = Paths.get("c:\\temp\\servlet1.dat");
        InputStream input = null;
        
        try{
            input = Files.newInputStream(file);
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            String s = null;
            
            // Now get printWriter
            PrintWriter out = response.getWriter();
            out.println("<h1>ASCII Reader by Todd:</h1>");
            out.println("</br>");
            
            // Step through each line of the input
            while ((s = reader.readLine()) != null){
                out.println(s + "</br>");
            }
                     
            // Close input
            input.close();
        }
        catch (IOException e)
        {
            // Output or print e
            PrintWriter debug = response.getWriter();
            debug.println("debug: " + e);
        }
    }
}