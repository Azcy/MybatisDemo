package com.zcy.message.servlet;

import com.zcy.message.bean.Message;
import com.zcy.message.service.Impl.ListServiceImpl;
import com.zcy.message.service.ListService;
import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class DeleteByIdServlet extends HttpServlet {
    ListService service;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Log logger= LogFactory.getLog(ListServlet.class);
        //接收消息
        req.setCharacterEncoding("UTF-8");
        String id=req.getParameter("id");
        service=new ListServiceImpl();
        service.delete(id);

        req.getRequestDispatcher("/message").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
