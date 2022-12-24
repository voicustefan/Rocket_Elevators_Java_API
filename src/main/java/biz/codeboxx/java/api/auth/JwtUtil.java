//package biz.codeboxx.java.api.auth;
//
//import com.rocket.elevators.User;
//import io.jsonwebtoken.*;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Component;
//
//import java.util.logging.Logger;
//
//@Component
//
//public class JwtUtil {
//    @Value("${app.jwt.secret}")
//    private String secret;
//
//    public String generateAccessToken(User user) {
//        return Jwts.builder()
//                .setSubject(String.format("%s,%s", user.getId(), user.getEmail()))
//                .signWith(SignatureAlgorithm.HS512, secret)
//                .compact();
//    }
//
//    private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(JwtUtil.class);
//
//    public boolean validateAccessToken(String token) {
//        try {
//            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
//            return true;
//        } catch (ExpiredJwtException ex) {
//            LOGGER.error("JWT expired", ex.getMessage());
//        } catch (IllegalArgumentException ex) {
//            LOGGER.error("Token is null, empty or only whitespace", ex.getMessage());
//        } catch (MalformedJwtException ex) {
//            LOGGER.error("JWT is invalid", ex);
//        } catch (UnsupportedJwtException ex) {
//            LOGGER.error("JWT is not supported", ex);
//        } catch (SignatureException ex) {
//            LOGGER.error("Signature validation failed");
//        }
//        return false;
//    }
//
//    public String getSubject(String token) {
//        return parseClaims(token).getSubject();
//    }
//
//    private Claims parseClaims(String token) {
//        return Jwts.parser()
//                .setSigningKey(secret)
//                .parseClaimsJws(token)
//                .getBody();
//    }
//
//}
