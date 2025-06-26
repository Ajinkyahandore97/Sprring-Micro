package com.zoo.payload;

import lombok.*;
import org.springframework.http.HttpStatus;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse {

   private String message;
   private  boolean success;
   private HttpStatus httpStatus;
}
