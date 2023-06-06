package ra.dto.respone;

import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class JwtResponse {
    private Long id;
    private String token;
    private String type = "Bearer";
    private String name;
    private String email;

    private Collection<? extends GrantedAuthority> roles;



    public JwtResponse(String jwt,  Long id, String name, String email, Collection<? extends GrantedAuthority> authorities) {
        this.token = jwt;
        this.id = id;
        this.name = name;
        this.email = email;
        this.roles = authorities;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setRoles(Collection<? extends GrantedAuthority> roles) {
        this.roles = roles;
    }



    public Collection<? extends GrantedAuthority> getRoles() {
        return roles;
    }

}
