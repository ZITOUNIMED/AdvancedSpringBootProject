package com.example.tutosSpringBoot.config.initialization;

import com.example.tutosSpringBoot.data.entities.Person;
import com.example.tutosSpringBoot.data.services.impl.PersonService;
import com.example.tutosSpringBoot.utils.UserRolesEnum;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@Order(4)
public class InitPersonsRunner implements CommandLineRunner{
    private static final Logger LOGGER = LoggerFactory.getLogger(InitPersonsRunner.class);

    @Autowired
    private PersonService personService;

    @Autowired
	PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
       LOGGER.info("Initialize Persons ...");

       Person admin = new Person();
       admin.setEmail("admin@gmail.com");
       admin.setPassword(passwordEncoder.encode("admin"));
       admin.setEnable(true);
       admin.setFirstname("Mohamed");
       admin.setLastname("Zitouni");
       admin.setRole(UserRolesEnum.ROLE_ADMIN.name());

       personService.save(admin);

       Person user1= new Person();
       user1.setEmail("user1@gmail.com");
       user1.setPassword(passwordEncoder.encode("user1"));
       user1.setEnable(true);
       user1.setFirstname("Firstname 1");
       user1.setLastname("Lastname 1");
       user1.setRole(UserRolesEnum.ROLE_USER.name());

       personService.save(user1);

       Person user2= new Person();
       user2.setEmail("user2@gmail.com");
       user2.setPassword(passwordEncoder.encode("user2"));
       user2.setEnable(false);
       user2.setFirstname("Firstname 2");
       user2.setLastname("Lastname 2");
       user2.setRole(UserRolesEnum.ROLE_USER.name());

       personService.save(user2);

       Person guest= new Person();
       guest.setEmail("guest@gmail.com");
       guest.setPassword(passwordEncoder.encode("guest"));
       guest.setEnable(true);
       guest.setFirstname("Firstname 2");
       guest.setLastname("Lastname 2");
       guest.setRole(UserRolesEnum.ROLE_GUEST.name());

       personService.save(guest);
    }
    
}
