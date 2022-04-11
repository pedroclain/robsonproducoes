/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.robsonproducoes.robsonproducoesspringapi.endpoints;

import com.robsonproducoes.robsonproducoesspringapi.model.EmailBody;
import com.robsonproducoes.robsonproducoesspringapi.service.EmailService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author pedro
 */
@Controller
@RequestMapping("/")
@AllArgsConstructor
public class UserController {
  
  private final EmailService emailService;
  
  @RequestMapping
  public String index() {
    return "index";
  }
  
  @RequestMapping(method = RequestMethod.POST, value = "/send-email")
  public String sendEmail(@ModelAttribute EmailBody emailBody) {

    emailService.sendEmail(emailBody);
    return "redirect:/";
  }
}
