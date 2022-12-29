package cheng.db;

import cheng.bean.Goods_info_Bean;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Goods_info_Dao {
    private static final DruidConnect dc = new DruidConnect(3);
    private static final DataSource ds = DruidConnect.getDataSource();//得到一个连接池
    static Connection con;
    static PreparedStatement pstmt;
    static ResultSet rs;
    static Goods_info_Bean goodsInfoBean;
    static List<Goods_info_Bean> list;

    public static List<Goods_info_Bean> selectAllByGoods_Name(String goods_name) {
        list = new ArrayList<>();
        String sql = "SELECT * FROM tb_pioneer_mall_goods_info WHERE goods_name=?;";
        try {
            con = ds.getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, goods_name);
            rs = pstmt.executeQuery();
            //获取结果并对结果进行遍历封装
            while (rs.next()) {
                int goods_id = rs.getInt("goods_id");
//                 String goods_name=rs.getString("goods_name");
                String goods_intro = rs.getString("goods_intro");
                int goods_category_id = rs.getInt("goods_category_id");
                String goods_cover_img = rs.getString("goods_cover_img");
                String goods_carousel = rs.getString("goods_carousel");
                String goods_detail_content = rs.getString("goods_detail_content");
                int original_price = rs.getInt("original_price");
                int selling_price = rs.getInt("selling_price");
                int stock_num = rs.getInt("stock_num");
                String tag = rs.getString("tag");
                int goods_sell_status = rs.getInt("goods_sell_status");
                int create_user = rs.getInt("create_user");
                Date create_time = rs.getTime("create_time");
                int update_user = rs.getInt("update_user");
                Date update_time = rs.getTime("update_time");
                goodsInfoBean = new Goods_info_Bean(goods_id, goods_name, goods_intro, goods_category_id, goods_cover_img, goods_carousel, goods_detail_content, original_price, selling_price, stock_num, tag, goods_sell_status, create_user, create_time, update_user, update_time);
                list.add(goodsInfoBean);
            }
            con.close();
            pstmt.close();
            rs.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println("通过SQL语句" + sql + "传入参数" + goods_name + "返回了结果集合\n" + list.toString());
        }
        return list;
    }

    /*
    通过Goods_Name模糊查询
     */
    public static List<Goods_info_Bean> selectSomeByGoods_Name(String somegoods_name) {
        list = new ArrayList<>();
        String sql = "SELECT * FROM tb_pioneer_mall_goods_info WHERE goods_name LIKE ?;";
        try {
            con = ds.getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, "%" + somegoods_name + "%");
            rs = pstmt.executeQuery();
            //获取结果并对结果进行遍历封装
            while (rs.next()) {
                int goods_id = rs.getInt("goods_id");
                String goods_name = rs.getString("goods_name");
                String goods_intro = rs.getString("goods_intro");
                int goods_category_id = rs.getInt("goods_category_id");
                String goods_cover_img = rs.getString("goods_cover_img");
                String goods_carousel = rs.getString("goods_carousel");
                String goods_detail_content = rs.getString("goods_detail_content");
                int original_price = rs.getInt("original_price");
                int selling_price = rs.getInt("selling_price");
                int stock_num = rs.getInt("stock_num");
                String tag = rs.getString("tag");
                int goods_sell_status = rs.getInt("goods_sell_status");
                int create_user = rs.getInt("create_user");
                Date create_time = rs.getTime("create_time");
                int update_user = rs.getInt("update_user");
                Date update_time = rs.getTime("update_time");
                goodsInfoBean = new Goods_info_Bean(goods_id, goods_name, goods_intro, goods_category_id, goods_cover_img, goods_carousel, goods_detail_content, original_price, selling_price, stock_num, tag, goods_sell_status, create_user, create_time, update_user, update_time);
                list.add(goodsInfoBean);
            }
            con.close();
            pstmt.close();
            rs.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println("通过SQL语句" + sql + "传入参数" + somegoods_name + "返回了结果集合\n" + list.toString());
        }
        return list;
    }

    public static List<Goods_info_Bean> selectAll() {
        list = new ArrayList<>();
        String sql = "SELECT * FROM  tb_pioneer_mall_goods_info;";
        try {
            con = ds.getConnection();
            pstmt = con.prepareStatement(sql);
//            pstmt.setString(1, goods_name);
            rs = pstmt.executeQuery();
            //获取结果并对结果进行遍历封装
            while (rs.next()) {
                int goods_id = rs.getInt("goods_id");
                String goods_name = rs.getString("goods_name");
                String goods_intro = rs.getString("goods_intro");
                int goods_category_id = rs.getInt("goods_category_id");
                String goods_cover_img = rs.getString("goods_cover_img");
                String goods_carousel = rs.getString("goods_carousel");
                String goods_detail_content = rs.getString("goods_detail_content");
                int original_price = rs.getInt("original_price");
                int selling_price = rs.getInt("selling_price");
                int stock_num = rs.getInt("stock_num");
                String tag = rs.getString("tag");
                int goods_sell_status = rs.getInt("goods_sell_status");
                int create_user = rs.getInt("create_user");
                Date create_time = rs.getTime("create_time");
                int update_user = rs.getInt("update_user");
                Date update_time = rs.getTime("update_time");
                goodsInfoBean = new Goods_info_Bean(goods_id, goods_name, goods_intro, goods_category_id, goods_cover_img, goods_carousel, goods_detail_content, original_price, selling_price, stock_num, tag, goods_sell_status, create_user, create_time, update_user, update_time);
                list.add(goodsInfoBean);
            }
            con.close();
            pstmt.close();
            rs.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println("通过SQL语句" + sql + "传入参数" + "" + "返回了结果集合\n" + list.toString());
        }
        return list;
    }

    public static void main(String[] args) {
        List<Goods_info_Bean> res = selectSomeByGoods_Name("华为");
        for (Goods_info_Bean go : res
        ) {
            System.out.println(go.toString());
        }
    }
}
