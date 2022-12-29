package db;

import java.io.Serializable;
import java.util.Date;

public class TableBean implements Serializable {
    private int id;
    private String uid;
    private String username;
    private String password;
    private String email;
    private Date birthday;

    public TableBean() {
        this.id = -1;
        this.username = "-1";
        this.password = "-1";
        this.email = "-1";
    }

    public TableBean(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public TableBean(int id, String username, String password, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public TableBean(int id, String username, String password, String email, Date birthday) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.birthday = birthday;
    }

    public TableBean(int id, String uid, String username, String password, String email, Date birthday) {
        this.id = id;
        this.uid = uid;
        this.username = username;
        this.password = password;
        this.email = email;
        this.birthday = birthday;
    }

    public Date getBirthday() {
        return birthday;
    }


    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "TableBean{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
