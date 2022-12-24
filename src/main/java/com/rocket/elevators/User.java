package com.rocket.elevators;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

//@Entity
//@Table(name = "users")
//@NoArgsConstructor
//@Getter
//@Setter

public class User implements UserDetails {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id;
    @JsonIgnore
    private String email;
    @JsonIgnore
    private String encryptedPassword;

    @JsonIgnore
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @JsonIgnore
    @Override
    public String getPassword() {
        return encryptedPassword;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isEnabled() {
        return true;
    }


    //HTTP GET request
//    public static void request() throws URISyntaxException, IOException, InterruptedException {
//        HttpClient client = HttpClient.newHttpClient();
//        HttpRequest getRequest = HttpRequest.newBuilder()
//                .GET()
//                .uri(new URI("https://java-api.codeboxxtest.xyz/users"))
//                .header("Authorization", "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJjdXN0b21lcjFAYnVzaW5lc3MuY29tIiwiaXNzIjoiaHR0cHM6Ly9qYXZhLWFwaS5jb2RlYm94eHRlc3QueHl6L2F1dGhlbnRpY2F0ZSJ9.QbJsJ-MZXWieFf_fcAkNWI3S9Skqd-yFVF3S2h-uhfo")
//                .build();
//        HttpResponse<String> response = client.send(getRequest, HttpResponse.BodyHandlers.ofString());
//        System.out.println(response.body());
//    }
//    HttpClient httpClient = HttpClient.newHttpClient();
//    HttpResponse<String> getResponse = httpClient.send( , BodyHandlers.ofString());
//    System.out.println(postResponse.body());
}
