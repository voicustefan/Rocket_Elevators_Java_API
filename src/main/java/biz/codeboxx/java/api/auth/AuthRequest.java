package biz.codeboxx.java.api.auth;

import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

@Getter
@Setter
public class AuthRequest {
    @NotNull
    @Email
    private String email;

    @NotNull
    private String password;
}
