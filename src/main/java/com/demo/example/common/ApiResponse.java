package com.demo.example.common;

import java.util.List;

import com.demo.example.person.entities.PersonResponseDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse {

      String responseStatus;
      String description;
      Object data;
     
}
