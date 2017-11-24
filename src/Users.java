public abstract class Users {

    //Datafield
    private String userName, userPswd, fName, lName;
    private Roles role;

    public Users(String userName, String userPswd, String fName, String lName){
        this.userName = userName;
        this.userPswd = userPswd;
        this.fName = fName;
        this.lName = lName;
    }
}
