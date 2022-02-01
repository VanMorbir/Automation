package config.uiconfig;

public class ParaBankUIConfig {
    public static String baseURL = "https://parabank.parasoft.com/parabank/index.htm";
    public static String appiumServer = "http://127.0.0.1:4723/wd/hub";
    public static String deviceName = "device";

    public static class Credentials {
        public static class ValidLogin {
            public static String userName = "john";
            public static String password = "demo";
        }
        public static class InvalidLogin {
            public static String wrongPassword = "123";
        }
        public static class ContactInfo {
            public static String Name = "Test McTestface";
            public static String Email = "test@test.com";
            public static String PhoneNumber = "+123 456789";
            public static String Message = "I am a message, hear me roar";
        }
    }
    public static class Alerts{
        public static class Contact{
            public static String MissingPhoneNumber = "Phone is required.";
        }
    }
}
