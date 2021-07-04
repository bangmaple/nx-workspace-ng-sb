package com.bangmaple.lms.authentication.handlers;

import com.bangmaple.lms.authentication.exception.EntityValidatingException;
import com.bangmaple.lms.authentication.exception.ExceptionResponse;
import com.bangmaple.lms.authentication.exception.ExceptionResponseWithValidation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.codec.DecodingException;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.support.WebExchangeBindException;
import org.springframework.web.server.ServerWebInputException;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

@RestControllerAdvice
@Slf4j
@PropertySource(value = "classpath:messages/global-exception-vi.properties", encoding = "UTF-8")
public class GlobalExceptionHandler {


  @Value("${entity-not-existed-with-id}")
  private String ENTITY_NOT_EXISTED_WITH_ID;

  @Value("${invalid-requested-data}")
  private String INVALID_REQUESTED_DATA;

  @Value("${account-is-locked}")
  private String ACCOUNT_IS_LOCKED;

  @Value("${invalid-username-password}")
  private String INVALID_USERNAME_PASSWORD;

  @Value("${invalid-data}")
  private String INVALID_DATA;

  @Value("${service-unavailable}")
  private String SERVICE_UNAVAILABLE;

  @Value("${service-unavailable-title}")
  private String SERVICE_UNAVAILABLE_TITLE;

  @Value("${username-existed}")
  private String USERNAME_EXISTED;

  @Value("${data-modify-not-allowed}")
  private String DATA_MODIFY_NOT_ALLOWED;

  @ExceptionHandler(DataAccessResourceFailureException.class)
  public Mono<ResponseEntity<ExceptionResponse>> handleDatabaseConnectionFailure(DataAccessResourceFailureException e) {
    return Mono.just(ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(new ExceptionResponse(HttpStatus
      .SERVICE_UNAVAILABLE.value(), SERVICE_UNAVAILABLE, SERVICE_UNAVAILABLE_TITLE)));

  }

 /* @ExceptionHandler(LockedException.class)
  public Mono<ResponseEntity<ExceptionResponse>> handleUserAccountLockedException(LockedException ex) {
    return Mono.just(ResponseEntity
      .badRequest().body(new ExceptionResponse(LocalDateTime.now(), HttpStatus.BAD_REQUEST.value(),
        ACCOUNT_IS_LOCKED, "")));
  }

  @ExceptionHandler(BadCredentialsException.class)
  public Mono<ResponseEntity<ExceptionResponse>> handleInvalidUsernamePasswordException(BadCredentialsException ex) {
    return Mono.just(ResponseEntity
      .badRequest().body(new ExceptionResponse(LocalDateTime.now(), HttpStatus.BAD_REQUEST.value(),
        INVALID_USERNAME_PASSWORD, ex.getMessage())));
  }
*/
  @ResponseStatus(HttpStatus.BAD_REQUEST)
 @ExceptionHandler({WebExchangeBindException.class})
  public Mono<Map<String, String>> handleValidationExceptions(WebExchangeBindException ex) {
    return Mono.create((sink) -> {
      Map<String, String> errorsMap = new HashMap<>();
      ex.getBindingResult().getAllErrors().forEach((error) -> {
        String fieldName = "";
        if (error instanceof FieldError) {
          fieldName = ((FieldError) error).getField();
        } else {
          if (error.getDefaultMessage().contains("Mật khẩu")) {
            fieldName = "rePassword";
          } else {
            fieldName = error.getObjectName();
          }
        }
        String errorMessage = error.getDefaultMessage();
        errorsMap.put(fieldName, errorMessage);
      });
      sink.success(errorsMap);
    });
  }

  @ExceptionHandler(DataIntegrityViolationException.class)
  public Mono<ResponseEntity<ExceptionResponse>> handleDBException(DataIntegrityViolationException ex) {
    return Mono.create((sink) -> {
      String message = DATA_MODIFY_NOT_ALLOWED;
      if (ex.getMessage().contains("duplicate key value violates unique constraint")) {
        message = USERNAME_EXISTED;
      }
      sink.success(ResponseEntity.badRequest()
        .body(new ExceptionResponse(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), message)));
    });
    //  log.error(ex.getMessage(), ex);

  }

  @ExceptionHandler(EntityValidatingException.class)
  public Mono<ResponseEntity<ExceptionResponseWithValidation>> handleEntityValidationException(EntityValidatingException ex) {
    //  log.error(ex.getMessage(), ex);
    return Mono.just(ResponseEntity.badRequest()
      .body(new ExceptionResponseWithValidation(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(),
        ex.getErrors())));
  }

  @ExceptionHandler(NoSuchElementException.class)
  public Mono<ResponseEntity<ExceptionResponse>> handleInputMismatchException(NoSuchElementException ex) {
    //  log.error(ex.getMessage(), ex);
    return Mono.just(ResponseEntity.badRequest()
      .body(new ExceptionResponse(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(),
        ENTITY_NOT_EXISTED_WITH_ID)));
  }

 // @ExceptionHandler({ DecodingException.class, ServerWebInputException.class })
  public Mono<ResponseEntity<ExceptionResponse>> handleInvalidIncomingRequestData(Exception ex) {
    return Mono.just(ResponseEntity
      .badRequest().body((new ExceptionResponse(HttpStatus.BAD_REQUEST.value(),
        INVALID_REQUESTED_DATA, INVALID_DATA))));
  }

}
