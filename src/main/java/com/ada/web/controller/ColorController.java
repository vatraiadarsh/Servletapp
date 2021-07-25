/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ada.web.controller;


import com.ada.web.dao.ColorDAO;
import com.ada.web.dao.Impl.ColorDAOImpl;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author vatra 
 */
@WebServlet(name = "color", urlPatterns = {"/admin/colors"})
public class ColorController extends Controller{
    private ColorDAO colorDAO = new ColorDAOImpl();
     @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         try {
            req.setAttribute("colors", colorDAO.getAll());
         } catch (ClassNotFoundException | SQLException ce) {
             ce.getMessage();
         }
         view("admin/color/index", req, resp);
    }
}
