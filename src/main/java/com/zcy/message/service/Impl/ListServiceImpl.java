package com.zcy.message.service.Impl;

import com.zcy.message.bean.Message;
import com.zcy.message.dao.ListDao;
import com.zcy.message.dao.impl.ListDaoImpl;
import com.zcy.message.service.ListService;

import java.io.IOException;
import java.util.List;

public class ListServiceImpl implements ListService {
    ListDao dao=new ListDaoImpl();
    public List<Message> queryMessage(String COMMAND, String DESCRIPTION) throws IOException {

        List<Message>list=dao.queryAll(COMMAND,DESCRIPTION);
        return list;
    }

    public void delete(String id) {
        if (id!=null&&!"".equals(id)){
            dao.delectById(Integer.parseInt(id));

        }
    }

}
