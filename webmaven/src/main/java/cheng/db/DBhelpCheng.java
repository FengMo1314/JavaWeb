package cheng.db;

import cheng.bean.SQLBeanCheng;
import cheng.bean.TableBeanCheng;
import cheng.bean.UpdataBeanCheng;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBhelpCheng {
    static SQLBeanCheng sqlBeanCheng;
    Statement stmt;
    ResultSet rs;
    Connection conn;
    TableBeanCheng tbc;

    public DBhelpCheng(String Myproperties) {
        this.openSQL(Myproperties);
    }

    private void openSQL(String Myproperties) {
        sqlBeanCheng = new SQLBeanCheng(Myproperties);
        try {
//            注册JDBC驱动
            Class.forName(sqlBeanCheng.getDriver());
            conn = DriverManager.getConnection(sqlBeanCheng.getUrl(), sqlBeanCheng.getName(), sqlBeanCheng.getPass());

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        DBhelpCheng dbc = new DBhelpCheng("../../ChenSql.properties");
        System.out.println(dbc.selectByUserName("xx").toString());
    }

    /**
     * public static void main(String[] args) {
     * DBhelpCheng dbhc=new DBhelpCheng("../ChenSql.properties");
     * String[] sqls = new String[2];
     * sqls[0] = "alter table userinfo02 drop id;";
     * sqls[1] = "alter TABLE userinfo02 add id int primary key auto_increment FIRST;";
     * String sql = "SELECT * FROM userinfo02";
     * try {
     * dbhc.stmt = dbhc.conn.createStatement();
     * for (String s : sqls) {
     * dbhc.stmt.addBatch(s);// 将所有的SQL语句添加到Statement中
     * }
     * dbhc.stmt.executeBatch();
     * dbhc.rs = dbhc.stmt.executeQuery(sql);
     * TableBeanCheng tbc = null;
     * while (dbhc.rs.next()) {
     * int uid = dbhc.rs.getInt("id");
     * String username = dbhc.rs.getString("username");
     * String upassword = dbhc.rs.getString("password");
     * tbc=new TableBeanCheng(uid,username,upassword);
     * }
     * String s = tbc.toString();
     * System.out.println(s);
     * } catch (SQLException e) {
     * throw new RuntimeException(e);
     * }
     * }
     */
    public boolean insterBySQL(String sql) {
        PreparedStatement preparedstatement = null;
        int num = 0;
        try {
            stmt = conn.createStatement();
            preparedstatement = conn.prepareStatement(sql);
            num = preparedstatement.executeUpdate();// 这里不需要再传入SQL语句

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return num > 0;
    }

    public List<TableBeanCheng> selectAllTableMesgs() {
        PreparedStatement preparedstatement = null;
        List<TableBeanCheng> tableBeanChengList;
        String[] sqls = new String[2];
        sqls[0] = "alter table userinfo02 drop id;";
        sqls[1] = "alter TABLE userinfo02 add id int primary key auto_increment FIRST;";
        String sql = "SELECT * FROM userinfo02";
        try {
            stmt = conn.createStatement();
            for (String s : sqls) {
                stmt.addBatch(s);// 将所有的SQL语句添加到Statement中
            }
            stmt.executeBatch();
            preparedstatement = conn.prepareStatement(sql);
            rs = preparedstatement.executeQuery();// 这里不需要再传入SQL语句

            // 如果不怕SQL注入的话也可以直接使用statement.executeQuery(sql)查询语句,代码如下
            /*
            // 3.获取语句对象
            statement = connection.createStatement();
            // 4.执行语句

            String sql = "select * from emp";
            resultSet = statement.executeQuery(sql);
             */

            // 4.获取结果并对结果进行遍历封装
            tableBeanChengList = new ArrayList<>();
            while (rs.next()) {
                int id = rs.getInt("id");
                String username = rs.getString("username");
                String pass = rs.getString("password");
                tableBeanChengList.add(new TableBeanCheng(id, username, pass));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            // 5.关闭资源
            if (null != rs) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (null != preparedstatement) {
                try {
                    preparedstatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (null != conn) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return tableBeanChengList;
    }

    public TableBeanCheng selectByUserName(String username) {
        String[] sqls = new String[2];

        sqls[0] = "alter table userinfo02 drop id;";
        sqls[1] = "alter TABLE userinfo02 add id int primary key auto_increment FIRST;";
        String sql = "SELECT * FROM userinfo02 WHERE username='" + username + "';";
        try {
            stmt = conn.createStatement();
            for (String s : sqls) {
                stmt.addBatch(s);// 将所有的SQL语句添加到Statement中
            }
            stmt.executeBatch();
            rs = stmt.executeQuery(sql);
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
            stmt.close();
            rs.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println("通过username查询了所有");
        }
        return tbc;
    }

    public boolean updataById(int id, UpdataBeanCheng ubc) {
        String sql = "UPDATE userinfo02 SET username='" + ubc.getUsername() + "',password='" + ubc.getPassword() + "' WHERE id=" + id + ";";
        int num;
        try {
            stmt = conn.createStatement();
            num = stmt.executeUpdate(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return num > 0;
    }
}
