package dao;

public class userlogin {
   public boolean isLogined(String uname,String upass) throws Exception {
       System.out.println("get uname:"+uname);
       System.out.println("get upass:"+upass);
//       return uname.equals("Admin") && upass.equals("123456");
       return new DruidDemo().UserLogin(uname,upass);


   }
}
