package com.example.tutosSpringBoot.config;

import java.util.Arrays;

import com.example.tutosSpringBoot.data.entities.Person;
import com.example.tutosSpringBoot.data.repositories.PersonRepository;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class CustomUserDetailsService implements UserDetailsService{
    private final PersonRepository personRepository;

    public CustomUserDetailsService(PersonRepository personRepository){
        this.personRepository = personRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Person person = personRepository.findByEmail(email);

        if(person == null) {
        	throw new UsernameNotFoundException("email not found!");
        }
        
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;

        UserDetails userDetails = new User(
                email,
                person.getPassword(),
                person.isEnable(),
                accountNonExpired,
                credentialsNonExpired,
                accountNonLocked,
                Arrays.asList(new SimpleGrantedAuthority(person.getRole())));

        return userDetails;
    }
}
