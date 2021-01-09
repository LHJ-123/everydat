package Dao;

import DBUtil.DBUtil;
import Model.Header;
import Model.KinderGarten;
import exception.KinderGartenException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class KinderGartenDao {

    //新增孩子信息
    public void addChild(KinderGarten kinderGarten) throws KinderGartenException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql ="insert into kindergarten values (null,?,?,?,?,?,?)";
        connection= DBUtil.getConnect();
        try{
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,kinderGarten.getChildName());
            preparedStatement.setInt(2,kinderGarten.getChildAge());
            preparedStatement.setString(3,kinderGarten.getChildSex());
            preparedStatement.setString(4,kinderGarten.getChildClass());
            preparedStatement.setInt(5,kinderGarten.getChildHeader());
            preparedStatement.setString(6,kinderGarten.getChildStatus());

            int ret = preparedStatement.executeUpdate();

            if(ret!= 1){
                throw new KinderGartenException("插入数据失败！");
            }
        } catch ( SQLException e) {
            throw new KinderGartenException("插入数据失败！");
        }finally {
            DBUtil.getClose(connection,preparedStatement,null);
        }
    }

    //由姓名删除孩子
    public void deleteChildByName(String name) throws KinderGartenException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        String sql= "delete from kindergarten where ChildName = ?";
        connection = DBUtil.getConnect();
        try{
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,name);

            int ret = preparedStatement.executeUpdate();
            if(ret!= 1){
                throw new KinderGartenException("删除数据失败！");
            }
        } catch (SQLException | KinderGartenException e) {
            e.printStackTrace();
            throw new KinderGartenException("删除数据失败！");
        }finally {
            DBUtil.getClose(connection,preparedStatement,null);
        }
    }


    //查找所有孩子
    public List<KinderGarten> SelectAll() throws KinderGartenException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        String sql ="select * from kindergarten ";
        connection = DBUtil.getConnect();

        List<KinderGarten> childList = new ArrayList();
        try {
            preparedStatement = connection.prepareStatement(sql);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                KinderGarten kinderGarten = new KinderGarten();
                kinderGarten.setChildNum(resultSet.getInt("ChildNum"));
                kinderGarten.setChildName(resultSet.getString("ChildName"));
                kinderGarten.setChildAge(resultSet.getInt("ChildAge"));
                kinderGarten.setChildSex(resultSet.getString("ChildSex"));
                kinderGarten.setChildClass(resultSet.getString("ChildClass"));
                kinderGarten.setChildHeader(resultSet.getInt("ChildHeader"));
                kinderGarten.setChildStatus(resultSet.getString("ChildStatus"));
                childList.add(kinderGarten);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new KinderGartenException("查询所有孩子信息失败！");

        }finally {
            DBUtil.getClose(connection,preparedStatement,resultSet);
        }
        return childList;

    }

    //由编号查找孩子
    public KinderGarten selectByNum(int num) throws KinderGartenException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        String sql ="select * from kindergarten where  ChildNum= ?";
        connection = DBUtil.getConnect();

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,num);

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){
                KinderGarten kinderGarten = new KinderGarten();
                kinderGarten.setChildNum(resultSet.getInt("ChildNum"));
                kinderGarten.setChildName(resultSet.getString("ChildName"));
                kinderGarten.setChildAge(resultSet.getInt("ChildAge"));
                kinderGarten.setChildSex(resultSet.getString("ChildSex"));
                kinderGarten.setChildClass(resultSet.getString("ChildClass"));
                kinderGarten.setChildHeader(resultSet.getInt("ChildHeader"));
                kinderGarten.setChildStatus(resultSet.getString("ChildStatus"));
                return kinderGarten;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new KinderGartenException("按照编号查找孩子失败！");

        }finally {
            DBUtil.getClose(connection,preparedStatement,resultSet);
        }
        return null;
    }
    //由姓名查找孩子
    public KinderGarten selectByName(String name) throws KinderGartenException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        String sql ="select * from kindergarten where  ChildName = ?";
        connection = DBUtil.getConnect();

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,name);

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){
                KinderGarten kinderGarten = new KinderGarten();
                kinderGarten.setChildNum(resultSet.getInt("ChildNum"));
                kinderGarten.setChildName(resultSet.getString("ChildName"));
                kinderGarten.setChildAge(resultSet.getInt("ChildAge"));
                kinderGarten.setChildSex(resultSet.getString("ChildSex"));
                kinderGarten.setChildClass(resultSet.getString("ChildClass"));
                kinderGarten.setChildHeader(resultSet.getInt("ChildHeader"));
                kinderGarten.setChildStatus(resultSet.getString("ChildStatus"));
                return kinderGarten;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new KinderGartenException("按照姓名查找孩子失败！");

        }finally {
            DBUtil.getClose(connection,preparedStatement,resultSet);
        }
        return null;
    }





    //由姓名更改年龄
    public void updateChildAgeByName(String name, int age) throws KinderGartenException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        String sql= "update  kindergarten set  ChildAge = ? where  ChildName= ?";
        connection = DBUtil.getConnect();
        try{
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,age);
            preparedStatement.setString(2,name);

            int ret = preparedStatement.executeUpdate();
            if(ret!= 1){
                throw new KinderGartenException("修改数据失败！");
            }
        } catch (SQLException | KinderGartenException e) {
            e.printStackTrace();
            throw new KinderGartenException("修改数据失败！");
        }finally {
            DBUtil.getClose(connection,preparedStatement,null);
        }
    }

    //由姓名更改孩子的班主任
    public void updateChildHeaderByName(String name, int header) throws KinderGartenException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        String sql= "update  kindergarten set  ChildHeader = ? where ChildName = ?";
        connection = DBUtil.getConnect();
        try{
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,header);
            preparedStatement.setString(2,name);

            int ret = preparedStatement.executeUpdate();
            if(ret!= 1){
                throw new KinderGartenException("修改数据失败！");
            }
        } catch (SQLException | KinderGartenException e) {
            e.printStackTrace();
            throw new KinderGartenException("修改数据失败！");
        }finally {
            DBUtil.getClose(connection,preparedStatement,null);
        }
    }

    //由姓名更改孩子在校状态
    public void updateChildStatusByName(String name, String status) throws KinderGartenException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        String sql= "update  kindergarten set  ChildStatus = ? where ChildName = ?";
        connection = DBUtil.getConnect();
        try{
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,status);
            preparedStatement.setString(2,name);

            int ret = preparedStatement.executeUpdate();
            if(ret!= 1){
                throw new KinderGartenException("修改数据失败！");
            }
        } catch (SQLException | KinderGartenException e) {
            e.printStackTrace();
            throw new KinderGartenException("修改数据失败！");
        }finally {
            DBUtil.getClose(connection,preparedStatement,null);
        }
    }
    //由姓名更改孩子性别
    public void updateChildSexByName(String name, String sex) throws KinderGartenException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        String sql= "update  kindergarten set  ChildSex = ? where ChildName = ?";
        connection = DBUtil.getConnect();
        try{
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,sex);
            preparedStatement.setString(2,name);

            int ret = preparedStatement.executeUpdate();
            if(ret!= 1){
                throw new KinderGartenException("修改数据失败！");
            }
        } catch (SQLException | KinderGartenException e) {
            e.printStackTrace();
            throw new KinderGartenException("修改数据失败！");
        }finally {
            DBUtil.getClose(connection,preparedStatement,null);
        }
    }

    //由姓名更改孩子班级
    public void updateChildClassByName(String name, String Class) throws KinderGartenException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        String sql= "update  kindergarten set  ChildClass = ? where ChildName = ?";
        connection = DBUtil.getConnect();
        try{
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,Class);
            preparedStatement.setString(2,name);

            int ret = preparedStatement.executeUpdate();
            if(ret!= 1){
                throw new KinderGartenException("修改数据失败！");
            }
        } catch (SQLException | KinderGartenException e) {
            e.printStackTrace();
            throw new KinderGartenException("修改数据失败！");
        }finally {
            DBUtil.getClose(connection,preparedStatement,null);
        }
    }

    //由姓名更改孩子姓名
    public void updateChildNameByName(String name1, String name2) throws KinderGartenException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        String sql= "update  kindergarten set  ChildName = ? where ChildName = ?";
        connection = DBUtil.getConnect();
        try{
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,name2);
            preparedStatement.setString(2,name1);

            int ret = preparedStatement.executeUpdate();
            if(ret!= 1){
                throw new KinderGartenException("修改数据失败！");
            }
        } catch (SQLException | KinderGartenException e) {
            e.printStackTrace();
            throw new KinderGartenException("修改数据失败！");
        }finally {
            DBUtil.getClose(connection,preparedStatement,null);
        }
    }

    //查询每个孩子的班主任信息
    public Header selectHeaderByNum(int num) throws KinderGartenException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        String sql ="select * from header where  num = ?";
        connection = DBUtil.getConnect();

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,num);

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){
                Header header = new Header();
                header.setNum(resultSet.getInt("num"));
                header.setName(resultSet.getString("name"));
                header.setSex(resultSet.getString("sex"));
                header.setAge(resultSet.getInt("age"));
                return header;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new KinderGartenException("查找失败！");

        }finally {
            DBUtil.getClose(connection,preparedStatement,resultSet);
        }
        return null;
    }


}

