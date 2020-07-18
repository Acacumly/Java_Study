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
        
        //������������
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        
        //��ȡ�������
        String name=req.getParameter("uname");
        String pwd=req.getParameter("pwd");
        String check=req.getParameter("che");
        
        //����ҵ��
        //1:�ж��Ƿ�ѡ���������¼
        if(check!=null&&"yes".equals(check)){
            //�ж��û����������Ƿ�Ϊ��
            if((name!=null&&!"".equals(name))&&(pwd!=null&&!"".equals(pwd))){
            //����cookie�������ڿͻ��˵�Ӳ����
                
            Cookie cookiename=new Cookie("cookiename",URLEncoder.encode(name,"utf-8"));
            Cookie cookiepwd=new Cookie("cookiename",URLEncoder.encode(pwd,"utf-8"));
            System.out.println("LoginCookie.service(�洢cookie)��Ч����2��");
            //����cookie����Ч��14��
            cookiename.setMaxAge(14*24*3600);
            cookiepwd.setMaxAge(14*24*3600);
            
            //���÷���·��
            cookiename.setPath(req.getContextPath()+"/LoginCookie");
            cookiepwd.setPath(req.getContextPath()+"/LoginCookie");
            
            //���͸�������ͻ���
            resp.addCookie(cookiename);
            resp.addCookie(cookiepwd);
        }
        
        //����û���������Ϊ�գ��ӿͻ���Ӳ���ж�ȡcookie
        if((name==null||"".equals(name))||(pwd==null||"".equals(pwd))){
            //��ȡcookie
        Cookie[] cookies=req.getCookies();
        //���˳��û���������
        if(cookies!=null&&cookies.length>0){
            for(int i=0;i<cookies.length;i++){
                //ȡ���û���
                if("cookiename".equals(cookies[i].getName())){
                    //pwd=cookies[i].getValue();
                    name=URLDecoder.decode(cookies[i].getValue(),"utf-8");
                }
                //ȡ������
                if("cookiepwd".equals(cookies[i].getName())){
                    pwd=URLDecoder.decode(cookies[i].getValue(),"utf-8");
                }
            }
        }
        //��ӡӢ����������
        System.out.println("LoginCookie.service()name:"+name);
        System.out.println("pwd:"+pwd);
        }
        //4У���û���������
        if("123".equals(name)&&"123".equals(pwd)){
            resp.getWriter().print(name+"��ͨ��ʽ��½�ɹ���");
        }else{
            resp.getWriter().print("cookie��ʽ��¼�ɹ����˺� "+name);
        }
    }
    }
}
