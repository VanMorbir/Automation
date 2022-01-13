namespace AutoTestFramework
{
    public static class Config
    {
        public static string baseURL = "http://testing.todorvachev.com/";

        public static class Credentials
        {
            public static class Valid
            {
                public static string Username = "ValidUser";
                public static string Password = "abcd1234!";
                public static string RepeatPassword = "abcd1234!";
                public static string Email = "example@example.com";
            }

            public static class Invalid
            {
                public static class UserName
                {
                    public static string FourCharacters = "abcd";
                    public static string ThirteenCharacters = "asdfghjklzxcv";
                }
            }
        }

        public static class AlertMessages
        {
            public static string SuccessfulLogin = "Succesful login!";
            public static string UserNameLengthOutOfRange = "User Id should not be empty / length be between 5 to 12";
        }
    }
}
