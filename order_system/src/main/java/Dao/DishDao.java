package Dao;


import model.DBUtil;
import model.Dish;
import util.OrderSystemException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//新增菜品
//删除菜品
//查询所有菜品
//查询指定菜品
public class DishDao {
    public void add(Dish dish) throws SQLException {
        Connection connection = DBUtil.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            String sql = "insert into dishes values(null,?,?)";
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,dish.getName());
            preparedStatement.setInt(2,dish.getPrice());
            int ret = preparedStatement.executeUpdate();
            if (ret != 1) {
                throw new OrderSystemException("插入菜品失败");
            }
            System.out.println("插入菜品成功");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (OrderSystemException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection,preparedStatement,null);
        }
    }

    public void delete(int dishId) throws SQLException {
        Connection connection = DBUtil.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            String sql = "delete from dishes where dishId = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,dishId);
            int ret = preparedStatement.executeUpdate();
            if (ret != 1) {
                throw new OrderSystemException("删除菜品失败");
            }
            System.out.println("删除菜品成功");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (OrderSystemException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection,preparedStatement,null);
        }
    }

    public List<Dish> selectAll() throws SQLException, OrderSystemException {
        List<Dish> dishes = new ArrayList<>();
        Connection connection = DBUtil.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            String sql = "select * from dishes";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Dish dish = new Dish();
                dish.setDishId(resultSet.getInt("dishId"));
                dish.setName(resultSet.getString("name"));
                dish.setPrice(resultSet.getInt("price"));
                dishes.add(dish);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new OrderSystemException("查找所有菜品失败");
        } finally {
            DBUtil.close(connection,preparedStatement,resultSet);
        }
        return dishes;
    }
    public Dish selectById(int dishId) throws SQLException, OrderSystemException {
        Connection connection = DBUtil.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            String sql = "select * from dishes where dishId = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,dishId);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                Dish dish = new Dish();
                dish.setDishId(resultSet.getInt("dishId"));
                dish.setName(resultSet.getString("name"));
                dish.setPrice(resultSet.getInt("price"));
                return dish;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new OrderSystemException("查询指定菜品失败");
        } finally {
            DBUtil.close(connection,preparedStatement,resultSet);
        }
        return null;
    }

    public static void main(String[] args) throws SQLException, OrderSystemException {
        DishDao dishDao = new DishDao();
        /*Dish dish = new Dish();
        dish.setName("炒肉丝");
        dish.setPrice(3000);
        dishDao.add(dish);*/
       List<Dish> dishes = dishDao.selectAll();
        System.out.println(dishes);
        Dish dish = dishDao.selectById(1);
        System.out.println(dish);
        dishDao.delete(1);
    }
}
