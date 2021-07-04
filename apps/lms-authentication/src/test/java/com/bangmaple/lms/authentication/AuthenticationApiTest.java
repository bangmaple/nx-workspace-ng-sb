package com.bangmaple.lms.authentication;

import com.bangmaple.lms.authentication.controllers.AuthenticationController;
import com.bangmaple.lms.authentication.models.RegistrationRequestModel;
import com.bangmaple.lms.authentication.repositories.UsersRepository;
import com.bangmaple.lms.authentication.services.AuthenticationService;
import com.bangmaple.lms.authentication.utils.JsonUtil;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)

class AuthenticationApiTest {

  @Autowired
  private WebTestClient webTestClient;

  private MockMvc mockMvc;

  @InjectMocks
  private AuthenticationController authenticationController;

  @Mock
  private AuthenticationService authenticationService;

  @Mock
  private UsersRepository usersRepository;

  @Before
  public void setUp() {
    mockMvc = MockMvcBuilders.standaloneSetup(authenticationController)
      .build();
  }

	@Test
	void testSignUpUser() throws Exception {
    String username = "admin";
    String password = "admin";
    String rePassword = "admin";
    String fullname = "Administrator";
    String email = "admin@gmail.com";
    RegistrationRequestModel registration = new RegistrationRequestModel(username, password,rePassword, fullname, email);
    String body = JsonUtil.toJsonString(registration);
    webTestClient.post()
      .uri("/signup")
      .accept(MediaType.APPLICATION_JSON)
      .bodyValue(body)
      .exchange()
      .expectStatus().isOk();
	}
}
