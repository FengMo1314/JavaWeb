package cheng.isTrue;

import cheng.bean.TableBeanCheng;
import cheng.bean.UpdataBeanCheng;
import cheng.db.UserDao;

import java.util.ArrayList;
import java.util.List;

public class CIsTrue {
    UserDao ud = new UserDao();

    public static void main(String[] args) {
        CIsTrue cit = new CIsTrue();
        List<String> list = cit.isLogin("lh", "111");
        for (String s : list) {
            System.out.println(s);
        }
    }

    public List<String> isLogin(String username, String pass) {
        TableBeanCheng tbc = ud.selectByUserName(username);
        List<String> list = new ArrayList<>();
        if (tbc.getUsername().equals("-1")) {//不存在
            list.add("-1");
            list.add("用户名不存在——建议注册");
        } else if (tbc.getUsername().equals(username)) {//用户名匹配
            if (tbc.getPassword().equals(pass)) {//密码对
                list.add("0");
                list.add("登录成功");
                list.add(String.valueOf(tbc.getId()));
            } else {
                list.add("1");
                list.add("密码错误");
            }
        }
        return list;
    }

    public List<String> isRegist(String username, String pass) {
        TableBeanCheng tbc = ud.selectByUserName(username);
        List<String> list = new ArrayList<>();
        if (tbc.getUsername().equals("-1")) {
            String sql = "INSERT INTO userinfo02(username,password)  VALUES('" + username + "','" + pass + "');";
            if (ud.insterBySQL(sql)) {
                list.add("-1");
                list.add("注册成功");
            }
        } else if (tbc.getUsername().equals(username)) {
            if (tbc.getPassword().equals(pass)) {
                list.add("0");
                list.add("账户已注册,密码正确");
            } else {
                list.add("1");
                list.add("账户已存在，但是密码错误");
            }
        }
        return list;
    }

    public List<String> isRegistAndAll(TableBeanCheng registtableBeanCheng) {
        TableBeanCheng tbc = ud.selectByUserName(registtableBeanCheng.getUsername());
        List<String> list = new ArrayList<>();
        if (tbc.getUsername().equals("-1")) {//用户不存在
            boolean isRegistover = ud.insterByBean(registtableBeanCheng);
            if (isRegistover) {
                list.add("-1");
                list.add("注册成功");
            }
        } else if (tbc.getUsername().equals(registtableBeanCheng.getUsername())) {//用户已注册
            if (tbc.getPassword().equals(registtableBeanCheng.getPassword())) {//验证密码
                list.add("0");
                list.add("账户已注册——建议去登录");
            } else {//密码错误
                list.add("1");
                list.add("账户已注册——建议去登陆或者找回密码");
            }
        }
        return list;
    }

    public List<String> isUpdata(int id, UpdataBeanCheng ubc) {
        List<String> list = new ArrayList<>();
        boolean isUsername = ud.isByUserName(ubc.getUsername());
        if (isUsername) {//名字查不到
            ud.updataById(id, ubc);
            list.add("1");
            list.add("修改成功" + ubc);
        } else {
            list.add("0");
            list.add("用户名已被占用！请换个名字" + ubc);
        }
        return list;
    }

    /*
      通过id数组查询所有信息并保存为修改列表的集合
     */
    public List<TableBeanCheng> isUpdataByList(String[] usermesgs) {
        List<TableBeanCheng> ubcList = new ArrayList<>();
        for (int i = 0; i < usermesgs.length; i++) {
            int id = Integer.parseInt(usermesgs[i].replace(" ", "").trim());
            TableBeanCheng tbc = ud.selectByUserId(id);

            ubcList.add(tbc);
        }
        return ubcList;
    }

    public List<String> isDellArrays(String[] usermesgs) {
        List<String> list = new ArrayList<>();
        String isok = "成功删除的用户id:";
        String noOk = "删除失败的用户id:";
        for (int i = 0; i < usermesgs.length; i++) {
            int id = Integer.parseInt(usermesgs[i].replace(" ", "").trim());
            boolean is = ud.dellById(id);
            System.out.println(id + "ids");
            if (is) {
                isok += usermesgs[i] + ",";
            } else {
                noOk += usermesgs[i] + ",";
            }
        }
        list.add(isok);
        list.add(noOk);
        return list;
    }

}
