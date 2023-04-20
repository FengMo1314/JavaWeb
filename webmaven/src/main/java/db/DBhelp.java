/**
 *
 */
package db;


import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author LiuHe
 */
public class DBhelp {
    static SQLBean sqb;
    Statement stmt;
    ResultSet rs;
    Connection conn;
    TableBean tb;

    public DBhelp(String Myproperties) {
        this.openSQL(Myproperties);
    }

    public DBhelp(String driver, String url, String name, String pass) {
        this.openSQL(driver, url, name, pass);
    }

    public static void main(String[] args) {
        DBhelp dbh = new DBhelp("D:\\MyProgrammingLanguagesWorkspace\\JavaWeb\\webmaven\\src\\main\\resources\\MySql.properties");
        List<String> strings = dbh.selectAllByTable("mes");
        for (String s : strings) {
            System.out.println(s);
        }
        sqb = new SQLBean("../MySql.properties");
        System.out.println(sqb);
    }

    private void openSQL(String Myproperties) {
        sqb = new SQLBean(Myproperties);
        try {
            // 注册 JDBC 驱动
            Class.forName(sqb.getDriver());
            conn = DriverManager.getConnection(sqb.getUrl(), sqb.getName(), sqb.getPass());
        } catch (SQLException | ClassNotFoundException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }
    }

    private void openSQL(String driver, String url, String name, String pass) {
        sqb = new SQLBean(driver, url, name, pass);
        try {
            // 注册 JDBC 驱动
            Class.forName(sqb.getDriver());
            conn = DriverManager.getConnection(sqb.getUrl(), sqb.getName(), sqb.getPass());
        } catch (SQLException | ClassNotFoundException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }
    }

    public boolean selectBySQL(String sql) {
        try {
            System.out.println(" 实例化Statement对象...");
            stmt = conn.createStatement();
            int num = stmt.executeUpdate(sql);
            return num > 0;
//            // 展开结果集数据库
//            while (rs.next()) {
//                // 通过字段检索
//                int id = rs.getInt("id");
//                String username = rs.getString("username");
//                String pass = rs.getString("password");
//                // 输出数据
//                String lis = "ID\tname\tpass\n" + id + "\t" + username + "\t" + pass;
//                System.out.println(lis);
//            }
        } catch (SQLException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }
        return false;
    }

    public void insertBySQL(String sql) {
        try {
            stmt = conn.createStatement();
            int num = stmt.executeUpdate(sql);
            if (num > 0) {
                System.out.println("OK");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);

        }

    }

    public List<TableBean> selectAllBymyuser() {

        // Statement statement = null; 直接使用Statement执行查询语句可能遭到SQL注入攻击,推荐使用PreparedStatement
        PreparedStatement preparedstatement = null;
        List<TableBean> tableBeans;
        String[] sqls = new String[2];
        sqls[0] = "alter table myuser drop id;";
        sqls[1] = "alter TABLE myuser add id int primary key auto_increment FIRST;";
        String sql = "SELECT * FROM myuser";
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
            tableBeans = new ArrayList<TableBean>();
            while (rs.next()) {
                int uid = rs.getInt("id");
                String username = rs.getString("username");
                String upassword = rs.getString("password");
                String uemail = rs.getString("email");
                Date ubirthday = rs.getDate("birthday");
                tableBeans.add(new TableBean(uid, username, upassword, uemail, ubirthday));
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
        return tableBeans;
    }

    /*
    此bug
     */
    public List<String> selectAllByTable(String tablename) {
        // Statement statement = null; 直接使用Statement执行查询语句可能遭到SQL注入攻击,推荐使用PreparedStatement
        List<String> strings = new ArrayList<String>();
        String sql = "SELECT * FROM " + tablename;

        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            ResultSetMetaData data = rs.getMetaData();
            for (int i = 1; i <= data.getColumnCount(); i++) {
// 获得所有列的数目及实际列数
                int columnCount = data.getColumnCount();
// 获得指定列的列名
                String columnName = data.getColumnName(i);
// 获得指定列的列值
                int columnType = data.getColumnType(i);
// 获得指定列的数据类型名(字段类型)
                String columnTypeName = data.getColumnTypeName(i);
// 所在的Catalog(数据库)名字
                String catalogName = data.getCatalogName(i);
// 对应java数据类型的类
                String columnClassName = data.getColumnClassName(i);
// 在数据库中类型的最大字符个数
                int columnDisplaySize = data.getColumnDisplaySize(i);
// 默认的列的标题——默认字段的标题
                String columnLabel = data.getColumnLabel(i);
// 获得列的模式
                String schemaName = data.getSchemaName(i);
// 某列类型的精确度(类型的长度)
                int precision = data.getPrecision(i);
// 小数点后的位数
                int scale = data.getScale(i);
// 获取某列对应的表名
                String tableName = data.getTableName(i);
// 是否自动递增
                boolean isAutoInctement = data.isAutoIncrement(i);
// 在数据库中是否为货币型
                boolean isCurrency = data.isCurrency(i);
// 是否为空
                int isNullable = data.isNullable(i);
// 是否为只读
                boolean isReadOnly = data.isReadOnly(i);
// 能否出现在where中
                boolean isSearchable = data.isSearchable(i);
//                System.out.println(columnName);
//                System.out.println(tableName);
//                strings.add(columnName);
                strings.add(columnCount + columnName + columnType + columnTypeName + catalogName + columnClassName + columnDisplaySize + columnLabel + schemaName + precision + scale + tableName + isAutoInctement + isCurrency + isNullable + isReadOnly + isSearchable);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return strings;
    }

    public TableBean selectByUserName(String username) {
        String[] sqls = new String[2];

        sqls[0] = "alter table myuser drop id;";
        sqls[1] = "alter TABLE myuser add id int primary key auto_increment FIRST;";
        String sql = "SELECT * FROM myuser WHERE username='" + username + "';";
        try {
            stmt = conn.createStatement();
            for (String s : sqls) {
                stmt.addBatch(s);// 将所有的SQL语句添加到Statement中
            }
            stmt.executeBatch();
            rs = stmt.executeQuery(sql);
            if (!rs.next()) {
                tb = new TableBean();
            } else {
                do {
                    // 通过字段检索
                    int id = rs.getInt("id");
                    String uid = rs.getString("uid");
                    String name = rs.getString("username");
                    String pass = rs.getString("password");
                    String email = rs.getString("email");
                    Date birthday = rs.getDate("birthday");
                    tb = new TableBean(id, uid, name, pass, email, birthday);
                }
                while (rs.next());
            }
            stmt.close();
            rs.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return tb;
    }

    public boolean dellAllByUsername(String name) {
        String[] sqls = new String[2];
        sqls[0] = "alter table myuser drop id;";
        sqls[1] = "alter TABLE myuser add id int primary key auto_increment FIRST;";
        String sql = "DELETE FROM myuser WHERE username='" + name + "'; ";

        int num;
        try {
            stmt = conn.createStatement();
            for (String s : sqls) {
                stmt.addBatch(s);// 将所有的SQL语句添加到Statement中
            }
            stmt.executeBatch();
            num = stmt.executeUpdate(sql);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println(name + "注销");

        }
        return num > 0;
    }

    public boolean dellMoreById(String id) {
//        String[] sqls = new String[2];
//        sqls[0] = "alter table myuser drop id;";
//        sqls[1] = "alter TABLE myuser add id int primary key auto_increment FIRST;";
        String mesgs = "";

        System.out.println(mesgs);
        String sql = "DELETE FROM myuser WHERE id=" + id + ";";
        int num;
        try {
            stmt = conn.createStatement();
//            for (String s : sqls) {
//                stmt.addBatch(s);// 将所有的SQL语句添加到Statement中
//            }
//            stmt.executeBatch();
            num = stmt.executeUpdate(sql);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println("DELLBYID");

        }
        return num > 0;
    }

    public boolean updataById(int id, UpdataBean ub) {
        String sql = "UPDATE myuser SET uid='" + ub.getUid() + "',username='" + ub.getUsername() + "',password='" + ub.getPassword() + "',email='" + ub.getEmail() + "',birthday='" + ub.getBirthday() + "' WHERE id=" + id + ";";
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