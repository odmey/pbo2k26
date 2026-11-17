public class Member {
    private final String name, mbti, role;

    public Member(String name, String mbti, String role){
        this.name = name;
        this.mbti = mbti;
        this.role = role;
    } 

    public String getName(){ 
        return name; 
    }

    public String getMbti(){ 
        return mbti; 
    }

    public String getRole(){ 
        return role; 
    }

}
