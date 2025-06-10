//Ta sem as imports pq o maven não baixou até agr

@EnableWebSecurity
@Configuration
public class Security{

@Bean
public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) Throws Exception{
     return httpSecurity.csrf(csrf -> csrf.disable())
          .sessionManagement(session -> session.sessionCreationPolicy(sessionCreationPolicy.STATELESS)
          .build();

