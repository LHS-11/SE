package hello.SE.member;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Member {

    private String username;
    private int date_of_Birth;
    private String phone_Num;

    public Member(String username, int date_of_Birth, String phone_Num) {
        this.username = username;
        this.date_of_Birth = date_of_Birth;
        this.phone_Num = phone_Num;
    }

    public Member() {
    }
}
