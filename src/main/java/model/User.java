package model;

public enum User
{
    STUARD("standard_user", "secret_sauce");

    private String username;
    private String password;

    User(String username, String password)
    {
        this.username = username;
        this.password = password;
    }

    public String getUserName()
    {
        return username;
    }

    public String getUserPassword()
    {
        return password;
    }
}
