package com.bangmaple.lms.authentication.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.Getter;
import org.springframework.validation.ObjectError;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class ExceptionResponseWithValidation {
  @JsonSerialize(using = LocalDateTimeSerializer.class)
  @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
  private LocalDateTime timestamp;
  private Integer status;
  private String error;
  private String message;
  private List<ObjectError> validatingErrors;

  public ExceptionResponseWithValidation(Integer status, String error, String message) {
    this.timestamp = LocalDateTime.now();
    this.status = status;
    this.error = error;
    this.message = message;
  }

  public ExceptionResponseWithValidation(Integer status, String error, List<ObjectError> validatingErrors) {
    this.timestamp = LocalDateTime.now();
    this.status = status;
    this.error = error;
    this.validatingErrors = validatingErrors;
  }
}
