/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ada.web.dao.Impl;

import com.ada.web.dao.ColorDAO;
import com.ada.web.entity.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vatra
 */
public class ColorDAOImpl implements ColorDAO{

    @Override
    public List<Color> getAll() throws ClassNotFoundException, SQLException {
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
             return colors;
    }

    @Override
    public int delete(int id) throws ClassNotFoundException, SQLException {
     Class.forName("com.mysql.cj.jdbc.Driver");
             Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/inventoryapp","root","");
             String sql = "delete from colors where id=?";
             PreparedStatement stmt = conn.prepareStatement(sql); 
             stmt.setInt(1, id);
             int result = stmt.executeUpdate();
             conn.close();
             return result;
    }
    
}
