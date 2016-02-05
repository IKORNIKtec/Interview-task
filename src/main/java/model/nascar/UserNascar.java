package model.nascar;

public class UserNascar {
    private String email;
    private String password;
    private String zip;

    public UserNascar(String email, String password, String zip) {
        this.email = email;
        this.password = password;
        this.zip = zip;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getZip() {
        return zip;
    }

    @Override
    public String toString(){
        return String.format("(email : %s ; password : %s ; zip : %s)", email, password, zip);
    }

}
