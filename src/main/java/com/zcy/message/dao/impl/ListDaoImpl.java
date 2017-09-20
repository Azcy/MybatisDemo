package com.zcy.message.dao.impl;

import com.zcy.message.bean.Message;
import com.zcy.message.dao.ListDao;
import com.zcy.message.util.DBUtil;
import com.zcy.message.util.MyDBUtil;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ListDaoImpl implements ListDao{
    public List<Message> queryAll(String command, String content) throws IOException {
        List<Message> list = new ArrayList<Message>();
        List<String> paramList = new ArrayList<String>();

        SqlSession session = MyDBUtil.getSqlSession();
        Message message = new Message();
        list =  session.selectList("com.zcy.message.mapper.selectMessage");
        //list.add(message);

          /* Connection conn= DBUtil.getConnection();
            StringBuilder sql=new StringBuilder("select id,command,description,content FROM message where 1=1");
            if (null!=command&&!command.trim().equals("")){
                sql.append(" and command = ?");
                paramList.add(command);
            }
            if (null!=content&&!content.trim().equals("")){
                sql.append(" and description like '%' ? '%'");
                paramList.add(content);
            }
            PreparedStatement statement=conn.prepareStatement(sql.toString());
            for (int i=0;i<paramList.size();i++){
                statement.setString(i+1,paramList.get(i));
            }
            ResultSet rs=statement.executeQuery();
            while (rs.next()){
                Message message=new Message();
                message.setCommand(rs.getString("COMMAND"));
                message.setContent(rs.getString("CONTENT"));
                message.setDescription(rs.getString("DESCRIPTION"));
                message.setId(Integer.parseInt(rs.getString("ID")));
                list.add(message);
            }


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }*/


        return list;
    }
    }
