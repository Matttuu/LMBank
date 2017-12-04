//Denne klasse bliver umiddelbart ikke brugt alligevel

public enum AccountType { CACC("Lønkonto"), SACC("Opsparingskonto");
    private String accType;

    AccountType(String accType){
            this.accType = accType;
    }
    public String getAccType(){
        return this.accType;
    }
}
