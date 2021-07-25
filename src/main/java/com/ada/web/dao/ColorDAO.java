/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ada.web.dao;

import com.ada.web.entity.Color;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author vatra
 */
public interface ColorDAO {
    List<Color> getAll() throws ClassNotFoundException, SQLException;
    int delete(int id) throws ClassNotFoundException, SQLException;
    
}
