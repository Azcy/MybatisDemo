package com.zcy.message.service.Impl;

import com.zcy.message.bean.Message;
import com.zcy.message.dao.ListDao;
import com.zcy.message.dao.impl.ListDaoImpl;
import com.zcy.message.service.ListService;

import java.io.IOException;
import java.util.List;

public class ListServiceImpl implements ListService {
    public List<Message> queryMessage(String COMMAND, String DESCRIPTION) throws IOException {
        ListDao dao=new ListDaoImpl();
        List<Message>list=dao.queryAll(COMMAND,DESCRIPTION);
        return list;
    }
}
