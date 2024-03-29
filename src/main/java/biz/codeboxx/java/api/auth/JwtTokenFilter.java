//package biz.codeboxx.java.api.auth;
//
//import com.rocket.elevators.User;
//import com.rocket.elevators.UserDetails;
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.util.ObjectUtils;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import java.io.IOException;
//
//@Component
//public class JwtTokenFilter extends OncePerRequestFilter {
//    @Autowired
//    private JwtUtil jwtUtil;
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request,
//                                    HttpServletResponse response, FilterChain filterChain)
//            throws ServletException, IOException {
//
//        if (!hasAuthorizationBearer(request)) {
//            filterChain.doFilter(request, response);
//            return;
//        }
//
//        String token = getAccessToken(request);
//
//        if (!jwtUtil.validateAccessToken(token)) {
//            filterChain.doFilter(request, response);
//            return;
//        }
//
//        setAuthenticationContext(token, request);
//        filterChain.doFilter(request, response);
//    }
//
//    private boolean hasAuthorizationBearer(HttpServletRequest request) {
//        String header = request.getHeader("Authorization");
//        if (ObjectUtils.isEmpty(header) || !header.startsWith("Bearer")) {
//            return false;
//        }
//
//        return true;
//    }
//
//    private String getAccessToken(HttpServletRequest request) {
//        String header = request.getHeader("Authorization");
//        String token = header.split(" ")[1].trim();
//        return token;
//    }
//
//    private void setAuthenticationContext(String token, HttpServletRequest request) {
//        UserDetails userDetails = getUserDetails(token);
//
//        UsernamePasswordAuthenticationToken
//                authentication = new UsernamePasswordAuthenticationToken(userDetails, null, null);
//
//        authentication.setDetails(
//                new WebAuthenticationDetailsSource().buildDetails(request));
//
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//    }
//
//    private UserDetails getUserDetails(String token) {
//        User userDetails = new User();
//        String[] jwtSubject = jwtUtil.getSubject(token).split(",");
//
//        userDetails.setId(Integer.parseInt(jwtSubject[0]));
//        userDetails.setEmail(jwtSubject[1]);
//
//        return userDetails;
//    }
//
//}
