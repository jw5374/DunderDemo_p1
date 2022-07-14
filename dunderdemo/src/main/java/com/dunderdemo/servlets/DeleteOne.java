package com.dunderdemo.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dunderdb.DunderSession;
import com.dunderdemo.democlasses.Demo;
import com.dunderdemo.util.DunderUtil;

@WebServlet(
    name = "DeleteOne",
    urlPatterns = "/deleteone"
)
public class DeleteOne extends HttpServlet {
    protected void doDelete(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setStatus(200);
        String id = req.getParameter("id");
        try (DunderSession ses = DunderUtil.getSession()) {
            ses.remove(Demo.class, Integer.parseInt(id));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
