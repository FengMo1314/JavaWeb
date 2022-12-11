package html;

import db.DBhelp;
import db.TableBean;

public class IsTrue {
    //    DBhelp dbh;
    DBhelp dbh = new DBhelp("../MySql.properties");

    public int isRegist(String name, String pass) {
        if (this.isNull(name, pass)) {//密码||名字为空
            return -1;
        } else {
            TableBean tb = dbh.selectByUserName(name);
            System.out.println("传入用户:" + name + "pass:" + pass + "数据库返回:" + tb.toString());
            if (tb.getId() == -1) {//无此人
                String sql = "INSERT INTO myuser(username,password)  VALUES('" + name + "','" + pass + "');";
                dbh.insertBySQL(sql);//调用插入语句
                return 1;
            } else {//已存在
                return 0;
            }
        }
    }

    public int isLogin(String name, String pass) {
        if (this.isNull(name, pass)) {
            return -2;
        } else {
            TableBean tb = dbh.selectByUserName(name);
            if (tb.getId() == -1) { //无此人
                return -1;
            } else if (tb.getPassword().equals(pass)) {//密码对
                return 0;
            } else { //密码错误
                return 1;
            }
        }
    }

    public boolean isDell(String name) {
        return dbh.dellAllByUsername(name);
    }

    public boolean isNull(String name, String pass) {
        return name.equals("") || pass.equals("");
    }
}
