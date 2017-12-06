public abstract class Users {

    //Datafields
    private String userName, userPswd, fName, lName;
    private Roles role;

    //Constructors
    public Users() { //No-arg-constructor
    }

    public Users(String userName, String userPswd, String fName, String lName){
        this.userName = userName;
        this.userPswd = userPswd;
        this.fName = fName;
        this.lName = lName;
    }
}
