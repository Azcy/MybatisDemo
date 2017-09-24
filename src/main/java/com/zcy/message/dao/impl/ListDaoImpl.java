package com.zcy.message.dao.impl;

import com.zcy.message.bean.Message;
import com.zcy.message.dao.ListDao;
import com.zcy.message.mapper.IMessage;
import com.zcy.message.util.DBUtil;
import com.zcy.message.util.MyDBUtil;
import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ListDaoImpl implements ListDao{


    public void delectById(int id) {
        try {
            SqlSession session=MyDBUtil.getSqlSession();
            session.delete("com.zcy.message.mapper.IMessage.deleteById",id);

            session.commit();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    /**
     * 根据查询条件查询消息列表
     */
    public List<Message> queryMessageList(Map<String,Object> parameter) {

        List<Message> messageList = new ArrayList<Message>();
        SqlSession sqlSession = null;
        try {
            sqlSession = MyDBUtil.getSqlSession();
            // 通过sqlSession执行SQL语句
            IMessage imessage = sqlSession.getMapper(IMessage.class);
            messageList = imessage.queryMessageList(parameter);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            if(sqlSession != null) {
                sqlSession.close();
            }
        }
        return messageList;
    }

    /**
     * 根据查询条件查询消息列表
     */
    public int count(Message message) {

        SqlSession sqlSession = null;
        int result = 0;
        try {
            sqlSession = MyDBUtil.getSqlSession();
            // 通过sqlSession执行SQL语句
            IMessage imessage = sqlSession.getMapper(IMessage.class);
            result = imessage.count(message);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            if(sqlSession != null) {
                sqlSession.close();
            }
        }
        return result;
    }

    /**
     * 根据查询条件分页查询消息列表
     */
    public List<Message> queryMessageListByPage(Map<String,Object> parameter) {

        List<Message> messageList = new ArrayList<Message>();
        SqlSession sqlSession = null;
        try {
            sqlSession = MyDBUtil.getSqlSession();
            // 通过sqlSession执行SQL语句
            IMessage imessage = sqlSession.getMapper(IMessage.class);
            messageList = imessage.queryMessageListByPage(parameter);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            if(sqlSession != null) {
                sqlSession.close();
            }
        }
        return messageList;
    }
}
