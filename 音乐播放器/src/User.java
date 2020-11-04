import java.util.Date;

public class User {
    private String id;
    private String username;
    private String userpwd;
    private String nickname;
    private Date birth;
    private String signature;

    public User(String id, String username, String userpwd, String nickname, Date birth, String signature) {
        this.id = id;
        this.username = username;
        this.userpwd = userpwd;
        this.nickname = nickname;
        this.birth = birth;
        this.signature = signature;
    }

    public User() {

    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpwd() {
        return userpwd;
    }

    public void setUserpwd(String userpwd) {
        this.userpwd = userpwd;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
