import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    @Qualifier("userDetailsServce")
    private UserDetailsService userDetailsService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Bean
    public  PasswordEncoder passwordEncoder(){
        return  new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth)throws  Exception{
        auth
                .userDetailsService(userDetailsService)//
                .passwordEncoder(passwordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http)throws Exception{
       http
               .authorizeRequests().antMatchers("/login**").permitAll()
               .and()
//               .authorizeRequests().antMatchers("/sign**").permitAll()
//               .and()
               .authorizeRequests().antMatchers("/users").hasAnyAuthority("USER","ADMIN")
               .and()
               .formLogin().permitAll()
               .and()
               .logout().logoutSuccessUrl("/login").permitAll();
       //.and.csrf().disabled();

    }
}