package com.zcy.message.servlet;

import com.zcy.message.bean.Message;
import com.zcy.message.service.Impl.ListServiceImpl;
import com.zcy.message.service.ListService;
import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.log4j.Logger;



import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


public class ListServlet extends HttpServlet {
    ListService service;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Log logger= LogFactory.getLog(ListServlet.class);
        //接收消息
        req.setCharacterEncoding("UTF-8");
        String command=req.getParameter("command");
        String description=req.getParameter("description");
        service=new ListServiceImpl();
        List<Message> list=service.queryMessage(command,description);

        for (Message message:list){
            System.out.println(message);
        }
        //将取到的值存储到request中
        req.setAttribute("list",list);
        req.getRequestDispatcher("/WEB-INF/jsp/list.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
