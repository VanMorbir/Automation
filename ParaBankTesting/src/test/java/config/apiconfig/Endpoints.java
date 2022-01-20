package config.apiconfig;

public class Endpoints {
    public static String CUSTOMER(String id){
        return "customers/" + id;
    }
    public static String ACCOUNT(String id){
        return "accounts/" + id;
    }
}
