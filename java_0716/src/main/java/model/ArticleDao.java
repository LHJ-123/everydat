package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ArticleDao {
    //新增文章（发布文章）

    public void add(Article article) {
        Connection connection = DBUtil.getConnection();
        String sql = "insert into article values (null,?,?,?)";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1,article.getTitle());
            statement.setString(2,article.getContent());
            statement.setInt(3,article.getUserId());
           int ret = statement.executeUpdate();
            if (ret != 1) {
                System.out.println("插入文章失败");
                return;
            }
            System.out.println("插入文章成功");
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(connection,statement,null);
        }
    }
    //查看文章列表
    public List<Article> selectAll() {
        List<Article> articles = new ArrayList<>();
        Connection connection = DBUtil.getConnection();
        String sql = "select articleId,title,userId from article";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Article article = new Article();
                article.setArticleId(resultSet.getInt("articleId"));
                article.setTitle(resultSet.getString("title"));
                article.setUserId(resultSet.getInt("userId"));
                articles.add(article);
            }
            return articles;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(connection,statement,resultSet);
        }
        return null;
    }
    //查看指定文章详情
    public Article selectById(int articleId) {
        Connection connection = DBUtil.getConnection();
        String sql = "select * from article where articleId = ?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1,articleId);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Article article = new Article();
                article.setArticleId(resultSet.getInt("articleId"));
                article.setTitle(resultSet.getString("title"));
                article.setContent(resultSet.getString("content"));
                article.setUserId(resultSet.getInt("userId"));
                return article;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(connection,statement,resultSet);
        }
        return null;
    }
    //删除文章(给定ID来删除）
 public void delete(int articleId) {
     Connection connection = DBUtil.getConnection();
     String sql = "delete from article where articleId = ?";
     PreparedStatement statement = null;
     try {
         statement = connection.prepareStatement(sql);

         statement.setInt(1,articleId);
         int ret = statement.executeUpdate();
         if (ret != 1) {
             System.out.println("删除文章失败");
             return;
         }
         System.out.println("删除文章成功");
     } catch (SQLException e) {
         e.printStackTrace();
     }finally {
         DBUtil.close(connection,statement,null);
     }
 }

    public static void main(String[] args) {

     ArticleDao articleDao = new ArticleDao();
        /*Article article = new Article();
        article.setTitle("我是标题2");
        article.setContent("我是正文2我是正文我是正文我是正文我是正文我是正文");
        article.setUserId(1);
        articleDao.add(article);
       List<Article> articles = articleDao.selectAll();
        System.out.println(articles);*/
       /*Article article = articleDao.selectById(1);
        System.out.println(article);*/
       articleDao.delete(2);
    }
}
