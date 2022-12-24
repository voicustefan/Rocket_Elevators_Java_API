//import biz.codeboxx.java.api.auth.JwtTokenFilter;
//import com.rocket.elevators.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//@Configuration
//public class ApplicationSecurity {
//    @Autowired
//    private UserRepository userRepository;
//
//    @Bean
//    public UserDetailsService userDetailsService() {
//        return new UserDetailsService() {
//            @Override
//            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//                return (UserDetails) userRepository.findByEmail(username)
//                        .orElseThrow(
//                                () -> new UsernameNotFoundException("User " + username + " not   found."));
//            }
//        };
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    public AuthenticationManager authenticationManager(
//            AuthenticationConfiguration authConfig) throws Exception {
//        return authConfig.getAuthenticationManager();
//    }
//
//    @Bean
//    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
//        http.csrf().disable();
//        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//        // This will be changed later to restrict access.
//        http.authorizeRequests()
//                .antMatchers("/api/auth").permitAll()
//                .anyRequest().authenticated();
//        http.exceptionHandling()
//                .authenticationEntryPoint(
//                        (request, response, ex) -> {
//                            response.sendError(
//                                    HttpServletResponse.SC_UNAUTHORIZED,
//                                    ex.getMessage()
//                            );
//                        }
//                );
//
//        http.addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class);
//        return http.build();
//    }
//
//    @Autowired
//    private JwtTokenFilter jwtTokenFilter;
//}
