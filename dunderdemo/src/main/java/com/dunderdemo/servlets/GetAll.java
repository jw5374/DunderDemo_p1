package com.dunderdemo.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

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
    name = "GetAll",
    urlPatterns = "/getall"
)
public class GetAll extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setStatus(200);
        res.setContentType("application/json");
        try (DunderSession ses = DunderUtil.getSession()) {
            List<Demo> dList = ses.getAll(Demo.class);
            Gson gson = new Gson();
            String jsonData = gson.toJson(dList);
            PrintWriter out = res.getWriter();
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
