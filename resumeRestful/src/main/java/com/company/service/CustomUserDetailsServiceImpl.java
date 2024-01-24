package com.company.service;

import com.company.dao.impl.UserRepositoryCustom;
import com.company.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("userDetailsService")
public class CustomUserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    @Qualifier("userDao1")
    private UserRepositoryCustom userRepo;

    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException{
//        System.out.println("email"+email);
        User user=userRepo.findByEmail(email);
//        System.out.println(user.getPassword());
       UserBuilder builder=null;
       if(user!=null){
           builder=org.springframework.security.core.userdetails.User.withUsername(email);
           builder.disabled(!true);
           builder.password(user.getPassword());
           String[] authoritiesArr=new String[]{"USER","ADMIN"};
           builder.authorities(authoritiesArr);

           return builder.build();
       }else {

           throw  new UsernameNotFoundException("User not found");
       }
    }
}
