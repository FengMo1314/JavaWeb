package db;

import junit.framework.TestCase;

public class DBhelpTest extends TestCase {

    public void testSelectByUserName() {
        TableBean tb = new TableBean();
        DBhelp dbh = new DBhelp("../MySql.properties");
        tb = dbh.selectByUserName("root");
        System.out.println(tb.getId());
    }
}