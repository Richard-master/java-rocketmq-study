package com.yyh.consumer;

/**
 * @Classname
 * @Description
 */
public class Email {
    private String user;
    private String email;
    private Integer type;

    public Email(String user, String email, Integer type) {
        this.user = user;
        this.email = email;
        this.type = type;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Email{" +
                "user='" + user + '\'' +
                ", email='" + email + '\'' +
                ", type=" + type +
                '}';
    }
}
