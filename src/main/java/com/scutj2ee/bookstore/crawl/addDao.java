package com.scutj2ee.bookstore.crawl;

import com.scutj2ee.bookstore.entity.BookInfo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @Author kobe
 * @Date 2019/6/8 20:56
 * @Description: 手动插入
 * @Modified By:
 */
public class addDao {
    protected static String dbClassName = "com.mysql.cj.jdbc.Driver";
    protected static String dbUrl = "jdbc:mysql://localhost:3306/book?characterEncoding=UTF-8&useSSL=false&serverTimezone=GMT";
    protected static String dbUser = "root";
    protected static String dbPwd = "1234";
    protected static Connection conn = null;

    static
    {
        try
        {
            if (conn == null)
            {
                Class.forName(dbClassName).newInstance();
                conn = DriverManager.getConnection(dbUrl, dbUser, dbPwd);
            }
        }
        catch (Exception e)
        {
                e.printStackTrace();
        }
    }

    public addDao(){}

    public static ResultSet findForResultSet(String sql)
    {
        if (conn == null) {
            return null;
        }
        ResultSet rs = null;
        try
        {
            Statement statement = null;
            statement = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = statement.executeQuery(sql);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return rs;
    }

    public static int addBookInfo(BookInfo bookInfo)throws SQLException{
        String sql = "insert into book_info(book_category_id, `name`,outline, detail," +
                " press,publish_date, `size`, version,author, translator, isbn,price, `catalog`,market_price, deal_mount," +
                " look_mount, discount, image_url," +
                " store_mount, store_time, pack_style) values('" +
                bookInfo.getBookCategoryId()+"','"+bookInfo.getName()+"','"+bookInfo.getOutline()+"','"+
                bookInfo.getDetail()+"','"+bookInfo.getPress() + "','" + bookInfo.getPublishDate() + "','" + bookInfo.getSize() +"','" +
                bookInfo.getVersion()+"','"+bookInfo.getAuthor()+"','"+bookInfo.getTranslator()+"','"+bookInfo.getIsbn()+"','"+
                bookInfo.getPrice()+"','"+bookInfo.getCatalog()+"','"+bookInfo.getMarketPrice()
                +"','"+bookInfo.getDealMount()+"','"+bookInfo.getLookMount()+"','"+bookInfo.getDiscount()+
                "','"+bookInfo.getImageUrl()+"','"+bookInfo.getStoreMount()+"','"+bookInfo.getStoreTime()+"','"+bookInfo.getPackStyle()+"')";

        return conn.createStatement().executeUpdate(sql);
    }

}
