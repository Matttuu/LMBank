public enum Roles { ADMIN("Administrator"), EMPLOYEE("Bankrådgiver"), CUSTOMER("Kunde");
    private String role;

    Roles(String role){
        this.role = role;
    }
    public String getRole(){
        return this.role;
    }

}
