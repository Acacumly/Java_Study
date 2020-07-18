package MyPackage;




import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginCookie
 */
@WebServlet("/LoginCookie")
public class LoginCookie extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        System.out.println("LoginCookie.service()");
        
        //处理中文乱码
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        
        //获取请求参数
        String name=req.getParameter("uname");
        String pwd=req.getParameter("pwd");
        String check=req.getParameter("che");
        
        //处理业务
        //1:判断是否选择三天免登录
        if(check!=null&&"yes".equals(check)){
            //判断用户名和密码是否为空
            if((name!=null&&!"".equals(name))&&(pwd!=null&&!"".equals(pwd))){
            //设置cookie，保存在客户端的硬盘中
                
            Cookie cookiename=new Cookie("cookiename",URLEncoder.encode(name,"utf-8"));
            Cookie cookiepwd=new Cookie("cookiename",URLEncoder.encode(pwd,"utf-8"));
            System.out.println("LoginCookie.service(存储cookie)有效期是2周");
            //设置cookie的有效期14天
            cookiename.setMaxAge(14*24*3600);
            cookiepwd.setMaxAge(14*24*3600);
            
            //设置访问路径
            cookiename.setPath(req.getContextPath()+"/LoginCookie");
            cookiepwd.setPath(req.getContextPath()+"/LoginCookie");
            
            //发送给浏览器客户端
            resp.addCookie(cookiename);
            resp.addCookie(cookiepwd);
        }
        
        //如果用户名和密码为空，从客户端硬盘中读取cookie
        if((name==null||"".equals(name))||(pwd==null||"".equals(pwd))){
            //读取cookie
        Cookie[] cookies=req.getCookies();
        //过滤出用户名和密码
        if(cookies!=null&&cookies.length>0){
            for(int i=0;i<cookies.length;i++){
                //取出用户名
                if("cookiename".equals(cookies[i].getName())){
                    //pwd=cookies[i].getValue();
                    name=URLDecoder.decode(cookies[i].getValue(),"utf-8");
                }
                //取出密码
                if("cookiepwd".equals(cookies[i].getName())){
                    pwd=URLDecoder.decode(cookies[i].getValue(),"utf-8");
                }
            }
        }
        //打印英户名和密码
        System.out.println("LoginCookie.service()name:"+name);
        System.out.println("pwd:"+pwd);
        }
        //4校验用户名和密码
        if("123".equals(name)&&"123".equals(pwd)){
            resp.getWriter().print(name+"普通方式登陆成功！");
        }else{
            resp.getWriter().print("cookie方式登录成功！账号 "+name);
        }
    }
    }
}
