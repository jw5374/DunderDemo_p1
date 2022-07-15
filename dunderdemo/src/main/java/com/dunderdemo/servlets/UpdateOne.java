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
import com.google.gson.Gson;

@WebServlet(
    name = "UpdateOne",
    urlPatterns = "/updateone"
)
public class UpdateOne extends HttpServlet {
    protected void doPut(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setStatus(200);
        res.setContentType("application/json");
        Gson gson = new Gson();
        Demo reqObj = gson.fromJson(req.getReader(), Demo.class);
        try (DunderSession ses = DunderUtil.getSession()) {
            ses.update(reqObj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
