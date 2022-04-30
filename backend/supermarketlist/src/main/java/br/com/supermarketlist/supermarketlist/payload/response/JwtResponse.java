package br.com.supermarketlist.supermarketlist.payload.response;

public class JwtResponse {
    
    private String token;
    private long id;
    private String email;
    private String password;
    private int statusCode;
    
    public JwtResponse(String token, long id, String email, String password, int statusCode) {
        this.token = token;
        this.id = id;
        this.email = email;
        this.password = password;
        this.statusCode = statusCode;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
