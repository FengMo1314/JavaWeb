package cheng.bean;

public class TableBeanCheng {
    private int id;
    private String username;
    private String password;
    private String imgs;

    public TableBeanCheng() {
        this.id = -1;
        this.username = "-1";
        this.password = "-1";
        this.imgs = "-1";
    }

    public TableBeanCheng(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public TableBeanCheng(String username, String password, String imgs) {
        this.username = username;
        this.password = password;
        this.imgs = imgs;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImgs() {
        return imgs;
    }

    public void setImgs(String imgs) {
        this.imgs = imgs;
    }

    @Override
    public String toString() {
        return "TableBeanCheng{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", imgs='" + imgs + '\'' +
                '}';
    }
}
