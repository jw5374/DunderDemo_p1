package com.dunderdemo.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dunderdb.DunderSession;
import com.dunderdemo.democlasses.Demo;
import com.dunderdemo.util.DunderUtil;
import com.google.gson.Gson;

@WebServlet(
    name = "GetOne",
    urlPatterns = "/getone"
)
public class GetOne extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setStatus(200);
        res.setContentType("application/json");
        String id = req.getParameter("id");
        try (DunderSession ses = DunderUtil.getSession()) {
            PrintWriter out = res.getWriter();
            if(id.isEmpty()) {
                out.println("{ \"error\": \"Input is empty\" }");
                return;
            }
            Demo resObj = ses.get(Demo.class, Integer.parseInt(id));
            Gson gson = new Gson();
            String jsonData = gson.toJson(resObj);
            try {
                out.println(jsonData);
            } finally {
                out.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
