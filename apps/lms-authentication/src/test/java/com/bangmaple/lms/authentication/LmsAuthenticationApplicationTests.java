package com.bangmaple.lms.authentication;

import com.bangmaple.lms.authentication.models.RegistrationRequestModel;
import com.bangmaple.lms.authentication.repositories.UsersRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LmsAuthenticationApplicationTests {

  @Autowired
  private UsersRepository usersRepository;

	@Test
	void testSignUpUser() {
    RegistrationRequestModel registrationRequest = new RegistrationRequestModel();
	 // this.usersRepository.register("admindd", "adddd", "a/ddd", "addd");
	  this.usersRepository.findById(1L).subscribe(System.out::println);
	}

}
