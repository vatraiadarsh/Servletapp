/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ada.web.controller;

import com.ada.web.entity.Color;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
     @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         try {
             Class.forName("com.mysql.cj.jdbc.Driver");
             Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/inventoryapp","root","");
             String sql = "select * from colors";
             PreparedStatement stmt = conn.prepareStatement(sql);
             List<Color> colors = new ArrayList<>();
             ResultSet rs = stmt.executeQuery();
             while (rs.next()) {
                 Color color = new Color();
                 color.setId(rs.getInt("id"));
                 color.setName(rs.getString("name"));
                 color.setCode(rs.getString("code"));
                 color.setStatus(rs.getBoolean("status"));
                 colors.add(color);
             }
             conn.close();
             req.setAttribute("colors", colors);
         } catch (ClassNotFoundException | SQLException ce) {
             ce.getMessage();
         }
         view("admin/color/index", req, resp);
    }
}
