package com.zcy.message.service;

import com.zcy.message.bean.Message;
import com.zcy.message.entity.Page;

import java.io.IOException;
import java.util.List;

public interface ListService {
    public void delete(String id);
    public List<Message> queryMessageList(String command,String description,Page page);
    public List<Message> queryMessageListByPage(String command,String description,Page page);

}
