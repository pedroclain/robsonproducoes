/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.robsonproducoes.robsonproducoesspringapi.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author pedro
 */
@Getter
@Setter
@ToString
public class EmailBody {
  
  private String name;
  private String email;
  private String message;
  private MultipartFile sampleFile;
}
