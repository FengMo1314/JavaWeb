package cheng.db;

import cheng.bean.TableBeanCheng;
import cheng.bean.UpdataBeanCheng;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    private static final DataSource ds = DruidConnect.getDataSource();
    static DruidConnect dc = new DruidConnect(0);
    Connection con;
    PreparedStatement pstmt;
    Statement stmt;
    ResultSet rs;
    TableBeanCheng tbc;
    List<TableBeanCheng> tbclist;

    public boolean insterBySQL(String sql) {
        int num = 0;
        try {
            con = ds.getConnection();
            pstmt = con.prepareStatement(sql);
            num = pstmt.executeUpdate();
            con.close();
            pstmt.close();
            rs.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println("传入参数" + sql + "返回了结果\n" + (num > 0));
        }

        return num > 0;
    }

    public boolean insterByBean(TableBeanCheng tbc) {
        int num = 0;
        String sql = "INSERT INTO userinfo02 VALUES(? ,? ,? , ?)";
        try {
            con = ds.getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, String.valueOf(tbc.getId()));
            pstmt.setString(2, tbc.getUsername());
            pstmt.setString(3, tbc.getPassword());
            pstmt.setString(4, tbc.getImgs());
            num = pstmt.executeUpdate();
            con.close();
            pstmt.close();
            rs.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println("传入参数" + tbc.toString() + "返回了结果\n" + (num > 0));
        }

        return num > 0;
    }

    public List<TableBeanCheng> selectAllTableMesgs() {
        List<TableBeanCheng> tableBeanChengList = null;
        String[] sqls = new String[2];
        sqls[0] = "alter table userinfo02 drop id;";
        sqls[1] = "alter TABLE userinfo02 add id int primary key auto_increment FIRST;";
        String sql = "SELECT * FROM userinfo02";
        try {
            con = ds.getConnection();
            stmt = con.createStatement();
//            con.setAutoCommit(false);
            for (String s : sqls) {
                stmt.addBatch(s);// 将所有的SQL语句添加到Statement中
            }
            stmt.executeBatch();
            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();
            //获取结果并对结果进行遍历封装
            tableBeanChengList = new ArrayList<>();
            while (rs.next()) {
                int id = rs.getInt("id");
                String username = rs.getString("username");
                String pass = rs.getString("password");
                tableBeanChengList.add(new TableBeanCheng(id, username, pass));
            }
            con.close();
            pstmt.close();
            rs.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println("通过SQL语句" + sql + "传入参数" + "" + "返回了结果集合\n" + tableBeanChengList.toString());
        }

        return tableBeanChengList;
    }

    public boolean updataById(int id, UpdataBeanCheng ubc) {
        int num = 0;
        String sql = "UPDATE userinfo02 SET username=? ,password=? WHERE id=?;";
        try {
            con = ds.getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, ubc.getUsername());
            pstmt.setString(2, ubc.getPassword());
            pstmt.setString(3, String.valueOf(id));
            num = pstmt.executeUpdate();
            con.close();
            pstmt.close();
            rs.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println("通过SQL语句" + sql + "传入参数" + id + "&&" + ubc + "返回了结果\n" + (num > 0));
        }
        return num > 0;
    }

    public TableBeanCheng selectByUserName(String username) {
        String[] sqls = new String[2];
        sqls[0] = "alter table userinfo02 drop id;";
        sqls[1] = "alter TABLE userinfo02 add id int primary key auto_increment FIRST;";
        String sql = "SELECT * FROM userinfo02 WHERE username=?;";
        try {
            con = ds.getConnection();
            stmt = con.createStatement();
//            con.setAutoCommit(false);
            for (String s : sqls) {
                stmt.addBatch(s);// 将所有的SQL语句添加到Statement中
            }
            stmt.executeBatch();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, username);
            rs = pstmt.executeQuery();
            if (!rs.next()) {//查询结果首行就为空则调用空构造
                tbc = new TableBeanCheng();
            } else {
                do {
                    // 通过字段检索
                    int id = rs.getInt("id");
                    String name = rs.getString("username");
                    String pass = rs.getString("password");
                    tbc = new TableBeanCheng(id, name, pass);
                }
                while (rs.next());
            }
            con.close();
            pstmt.close();
            rs.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println("通过SQL语句" + sql + "传入参数" + username + "返回了结果\n" + tbc.toString());
        }
        return tbc;
    }

    /**
     * 通过用户名查询用户是否已存在
     *
     * @param username
     * @return
     */
    public boolean isByUserName(String username) {
        String[] sqls = new String[2];
        sqls[0] = "alter table userinfo02 drop id;";
        sqls[1] = "alter TABLE userinfo02 add id int primary key auto_increment FIRST;";
        String sql = "SELECT * FROM userinfo02 WHERE username=?;";
        try {
            con = ds.getConnection();
            stmt = con.createStatement();
//            con.setAutoCommit(false);
            for (String s : sqls) {
                stmt.addBatch(s);// 将所有的SQL语句添加到Statement中
            }
            stmt.executeBatch();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, username);
            rs = pstmt.executeQuery();
            if (!rs.next()) {//查询结果首行就为空则调用空构造
                tbc = new TableBeanCheng();
            } else {
                do {
                    // 通过字段检索
                    int id = rs.getInt("id");
                    String name = rs.getString("username");
                    String pass = rs.getString("password");
                    tbc = new TableBeanCheng(id, name, pass);
                }
                while (rs.next());
                con.close();
                pstmt.close();

            }
            con.close();
            pstmt.close();
            rs.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println("通过SQL语句" + sql + "传入参数" + username + "返回了结果\n" + (tbc.getId() == -1));
        }
        return tbc.getId() == -1;
    }

    public TableBeanCheng selectByUserId(int id) {
        String[] sqls = new String[2];
        sqls[0] = "alter table userinfo02 drop id;";
        sqls[1] = "alter TABLE userinfo02 add id int primary key auto_increment FIRST;";
        String sql = "SELECT * FROM userinfo02 WHERE id=?;";
        try {
            con = ds.getConnection();
            stmt = con.createStatement();
//            con.setAutoCommit(false);
            for (String s : sqls) {
                stmt.addBatch(s);// 将所有的SQL语句添加到Statement中
            }
            stmt.executeBatch();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, String.valueOf(id));
            rs = pstmt.executeQuery();
            if (!rs.next()) {//查询结果首行就为空则调用空构造
                tbc = new TableBeanCheng();
            } else {
                do {
                    // 通过字段检索
                    id = rs.getInt("id");
                    String name = rs.getString("username");
                    String pass = rs.getString("password");
                    tbc = new TableBeanCheng(id, name, pass);
                }
                while (rs.next());
            }
            con.close();
            pstmt.close();
            rs.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println("通过SQL语句" + sql + "传入参数" + id + "返回了结果\n" + tbc.toString());
        }
        return tbc;
    }

    public List<TableBeanCheng> selectSomsByUserName(String username) {
        String[] sqls = new String[2];
        sqls[0] = "alter table userinfo02 drop id;";
        sqls[1] = "alter TABLE userinfo02 add id int primary key auto_increment FIRST;";
        String sql = "SELECT * FROM userinfo02 WHERE username like '%" + username + "%' ;";
        try {
            con = ds.getConnection();
            stmt = con.createStatement();
//            con.setAutoCommit(false);
            for (String s : sqls) {
                stmt.addBatch(s);// 将所有的SQL语句添加到Statement中
            }
            stmt.executeBatch();
            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();
            tbclist = new ArrayList<>();
            if (!rs.next()) {//查询结果首行就为空则调用空构造
                tbc = new TableBeanCheng();
                tbclist.add(tbc);
            } else {
                do {
                    // 通过字段检索
                    int id = rs.getInt("id");
                    String name = rs.getString("username");
                    String pass = rs.getString("password");
                    tbc = new TableBeanCheng(id, name, pass);
                    tbclist.add(tbc);
                }
                while (rs.next());
            }
            con.close();
            pstmt.close();
            rs.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println("通过SQL语句" + sql + "传入参数" + username + "返回了结果集合\n" + tbclist.toString());
        }
        return tbclist;
    }

    public boolean dellById(int id) {
        int num = 0;
        String sql = "DELETE FROM userinfo02  WHERE id=?;";
        try {
            con = ds.getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, String.valueOf(id));
            num = pstmt.executeUpdate();
            con.close();
            pstmt.close();
            rs.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {

            System.out.println("通过SQL语句" + sql + "传入参数" + id + "返回了结果集合\n" + (num > 0));
        }
        return num > 0;
    }
}
