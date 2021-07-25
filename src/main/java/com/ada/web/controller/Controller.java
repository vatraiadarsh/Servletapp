/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ada.web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author vatra
 */
//making abstract(virtual object) -> don't want to make any new Controller
public abstract class Controller extends HttpServlet {
    protected String prefix = "/WEB-INF/views/";
    protected String suffix = ".jsp";

    protected void view(String page, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(prefix+page+suffix).forward(req, resp);
    }
}
