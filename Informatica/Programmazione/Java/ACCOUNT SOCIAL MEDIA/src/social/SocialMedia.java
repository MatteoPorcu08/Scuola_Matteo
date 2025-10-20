package social;

public class SocialMedia {
    String username;
    String name;
    int follower;
    int post;

    // Costruttore
    public SocialMedia(String username, String name, int follower, int post) {
        this.username = username;
        this.name = name;
        this.follower = follower;
        this.post = post;
    }

    //Setter base
    private void setusername(String username) {
        this.username = username;
    }
    private void setname(String name) {
        this.name = name;
    }
    private void setfollower(int follower) {
        this.follower = follower;
    }
    private void setpost(int post) {
        this.post = post;
    }

    //Getter base
    public String getusername() {
        return username;
    }
    public String getname() {
        return name;
    }
    public int getfollower () {
        return follower;
    }
    public int getpost() {
        return post;
    }

    //Metodi ulteriori
    String pubblica () {
        post = post + 1;
        return "Nuovo post pubblicato!: " + post;
    }
    void aggiungiFollower (){
        follower = follower + 1;
    }
    void rimuoviFollower(){
        if (follower > 0){
            follower = follower - 1;
        }
    }
    boolean isInfluencer(){
        if(follower < 10000){
            return false;
        } else {
            return true;
        }
    }

    //Metodo toString
    public String toString() {
        return " Username: " + username + "\nName: " + name + "\nFollower: " + follower + "\nPost: " + post;
    }
}