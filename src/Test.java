import java.io.InputStream;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws ClassNotFoundException{
        boolean bool=true;
        while(bool) {
            System.out.println("请输入用户名：");
            Scanner sc = new Scanner(System.in);
            String username = sc.next();

            System.out.println("请输入密码：");
            String password = sc.next();

            InputStream in = Class.forName("Test").getResourceAsStream("/user.xlsx");
            ReadUserExcel readExcel = new ReadUserExcel();
            User user[] = readExcel.readExcel(in);
            System.out.println("从Excel读取到的密码：" + user[0].getPassword());
            for (int i = 0; i < user.length; i++) {
                if (username.equals(user[i].getUsername()) && password.equals(user[i].getPassword())) {
                    System.out.println("登录成功");
                    bool = false;
                    break;
                } else {
                    System.out.println("登录失败");
                }
            }
        }
    }
}
