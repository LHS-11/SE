package hello.SE.servlet;

import hello.SE.member.Member;
import hello.SE.member.MemberDao;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name="memberFindServlet",urlPatterns = "/servlet/members/find")
public class MemberFindServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getParameter("UTF-8");
        String name = request.getParameter("keyword");
        Member member = new Member();
        member.setUsername(name);
        MemberDao memberDao = new MemberDao();
        List<Member> members = memberDao.MemberList(member);

        request.setAttribute("members",members);


        String viewPath = "/WEB-INF/views/findmembers.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
        dispatcher.forward(request,response);

    }
}
