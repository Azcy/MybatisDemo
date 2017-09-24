package com.zcy.message.service.Impl;

import com.zcy.message.bean.Message;
import com.zcy.message.dao.ListDao;
import com.zcy.message.dao.impl.ListDaoImpl;
import com.zcy.message.entity.Page;
import com.zcy.message.service.ListService;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListServiceImpl implements ListService {
    ListDao dao=new ListDaoImpl();


    public void delete(String id) {
        if (id!=null&&!"".equals(id)){
            dao.delectById(Integer.parseInt(id));

        }
    }

    /**
     * 查询相关的业务功能
     * @param command  消息的指令
     * @param description 消息的描述信息
     * @param page  分页类
     * @return 返回消息集合
     */
    public List<Message> queryMessageList(String command,String description,Page page) {
        // 组织消息对象
        Message message = new Message();
        message.setCommand(command);
        message.setDescription(description);
        ListDao messageDao = new ListDaoImpl();
        // 根据条件查询条数
        int totalNumber = messageDao.count(message);
        // 组织分页查询参数
        page.setTotalNumber(totalNumber);
        Map<String,Object> parameter = new HashMap<String, Object>();
        parameter.put("message", message);
        parameter.put("page", page);
        // 分页查询并返回结果
        return messageDao.queryMessageList(parameter);
    }

    /**
     * 根据查询条件分页查询消息列表
     */
    public List<Message> queryMessageListByPage(String command,String description,Page page) {
        Map<String,Object> parameter = new HashMap<String, Object>();
        // 组织消息对象
        Message message = new Message();
        message.setCommand(command);
        message.setDescription(description);
        parameter.put("message", message);
        parameter.put("page", page);
        ListDao messageDao = new ListDaoImpl();
        // 分页查询并返回结果
        return messageDao.queryMessageListByPage(parameter);
    }

}
