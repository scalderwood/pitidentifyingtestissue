package com.scalderwood.pitest.testidentifying;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

  @PostMapping("/add")
  public Object add() {
    return "add";
  }
}