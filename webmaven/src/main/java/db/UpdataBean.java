package db;

import java.util.Date;

public class UpdataBean {
    private String uid;
    private String username;
    private String password;
    private String email;
    private Date birthday;

    public UpdataBean(String uid, String username, String password, String email, Date birthday) {
        this.uid = uid;
        this.username = username;
        this.password = password;
        this.email = email;
        this.birthday = birthday;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
