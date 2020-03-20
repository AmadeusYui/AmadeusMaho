package domain;

/**
 * 用户基本信息
 * @author Yui
 */
public class User {
    private String username;
    private String password;
    private String basketball;
    private String football;
    private String tabletennis;
    private String selfstudy;
    private String coach;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBasketball() {
        return basketball;
    }

    public void setBasketball(String basketball) {
        this.basketball = basketball;
    }

    public String getFootball() {
        return football;
    }

    public void setFootball(String football) {
        this.football = football;
    }

    public String getTabletennis() {
        return tabletennis;
    }

    public void setTabletennis(String tabletennis) {
        this.tabletennis = tabletennis;
    }

    public String getSelfstudy() {
        return selfstudy;
    }

    public void setSelfstudy(String selfstudy) {
        this.selfstudy = selfstudy;
    }

    public String getCoach() {
        return coach;
    }

    public void setCoach(String coach) {
        this.coach = coach;
    }
}
