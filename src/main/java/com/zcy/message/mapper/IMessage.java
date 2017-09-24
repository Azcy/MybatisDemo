package com.zcy.message.mapper;

import com.zcy.message.bean.Message;
import com.zcy.message.dao.ListDao;

import java.nio.MappedByteBuffer;
import java.util.List;
import java.util.Map;

/**
 * 与Message配置文件相对应的接口
 */
public interface IMessage {

    /**
     * 根据查询条件查询消息列表
     */
    public List<Message> queryMessageList(Map<String,Object> parameter);

    /**
     * 根据查询条件查询消息列表
     */
    public List<Message> queryMessageListByPage(Map<String,Object> parameter);

    /**
     * 根据查询条件查询消息列表的条数
     */
    public int count(Message message);

    public void deleteBatch(List<Message> list);



}
