package com.zcy.message.dao;

import com.zcy.message.bean.Message;

import java.io.IOException;
import java.util.List;

public interface ListDao {
    public List<Message> queryAll(String command,String content) throws IOException;



}
