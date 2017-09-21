package com.zcy.message.service;

import com.zcy.message.bean.Message;

import java.io.IOException;
import java.util.List;

public interface ListService {
    public List<Message>queryMessage(String COMMAND,String DESCRIPTION) throws IOException;
    public void delete(String id);
}
