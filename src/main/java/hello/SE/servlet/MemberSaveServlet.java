package hello.SE.servlet;

import hello.SE.member.MemberDao;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "memberSaveServlet",urlPatterns ="/servlet/members/save")
public class MemberSaveServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");

        String name = request.getParameter("name");
        int date_of_birth = Integer.parseInt(request.getParameter("date_Of_Birth"));
        String phone_number = request.getParameter("phone_Number");

        if(request.getParameter("name")!=null){
            name = request.getParameter("name");
        }
        if(request.getParameter("date_Of_Birth")!=null){
            date_of_birth = Integer.parseInt(request.getParameter("date_Of_Birth"));
        }
        if(request.getParameter("phone_Number")!=null){
            phone_number = request.getParameter("phone_Number");
        }

        MemberDao memberDao = new MemberDao();
        int result = memberDao.join(name, date_of_birth, phone_number);
        if(result==1){
            String viewPath = "/WEB-INF/views/members.jsp";
            RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
            dispatcher.forward(request,response);


        }
    }
}
