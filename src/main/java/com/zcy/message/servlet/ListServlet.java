package com.zcy.message.servlet;

import com.zcy.message.bean.Message;
import com.zcy.message.entity.Page;
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
import java.util.regex.Pattern;


public class ListServlet extends HttpServlet {
    ListService service;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Log logger= LogFactory.getLog(ListServlet.class);
        // 设置编码
        req.setCharacterEncoding("UTF-8");
        // 接受页面的值
        String command = req.getParameter("command");
        String description = req.getParameter("description");
        String currentPage = req.getParameter("currentPage");
        // 创建分页对象
        Page page = new Page();
        Pattern pattern = Pattern.compile("[0-9]{1,9}");
        if(currentPage == null ||  !pattern.matcher(currentPage).matches()) {
            page.setCurrentPage(1);
        } else {
            page.setCurrentPage(Integer.valueOf(currentPage));
        }
        ListService listService = new ListServiceImpl();
        // 查询消息列表并传给页面
        req.setAttribute("messageList", listService.queryMessageList(command, description,page));
        // 向页面传值
        req.setAttribute("command", command);
        req.setAttribute("description", description);
        req.setAttribute("page", page);
        System.out.println(page);
        // 向页面跳转

        req.getRequestDispatcher("/WEB-INF/jsp/list.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
