package com.zcy.message.dao;

import com.zcy.message.bean.Message;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface ListDao {
    /**



    /**
     * 单条删除
     */
    public void delectById(int id);



    /**
     * 查询消息的总数量
     */
    public int count(Message message);

    public List<Message> queryMessageList(Map<String,Object > objectMap) ;

    public List<Message> queryMessageListByPage(Map<String,Object > objectMap) ;





}
