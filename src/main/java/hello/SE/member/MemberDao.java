package hello.SE.member;

import hello.SE.DatabaseUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MemberDao {

    private PreparedStatement pstmt;
    Connection con = DatabaseUtil.getConnection();

    public int join (String name,int birth_of_Date,String phone_Num){
        String SQL = "INSERT INTO MEMBERSHIP (name,birth,phone) VALUES (?,?,?)";

        try {
            pstmt = con.prepareStatement(SQL);

            pstmt.setString(1, name);
            pstmt.setString(2, String.valueOf(birth_of_Date));
            pstmt.setString(3, phone_Num);

            return pstmt.executeUpdate();

        }catch (Exception e){
            e.printStackTrace();
        }
        return -1;
    }

    public List<Member> MemberList(Member member1){
        List<Member> members = new ArrayList<Member>();
        String username = member1.getUsername();

        try{

            Connection con = DatabaseUtil.getConnection();
            String query = "select * from membership ";

            if((username != null && username.length() != 0)) {
                query += "where name like ?";
                pstmt = con.prepareStatement(query);
                pstmt.setString(1, "%"+username+"%");
            }else {
                pstmt = con.prepareStatement(query);
            }

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()){
                Member member = new Member();

                member.setUsername(rs.getString(1));
                member.setDate_of_Birth(Integer.parseInt(rs.getString(2)));
                member.setPhone_Num(rs.getString(3));

                members.add(member);
            }
            rs.close();
            pstmt.close();
            con.close();
        } catch (Exception e){
            System.out.println(e+"=>MemberList fail");
        }
        return members;
    }
}
