package com.jemhik.userservice.controller;

import com.jemhik.userservice.model.UserDto;
import com.jemhik.userservice.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller("/user")
@RequiredArgsConstructor
@Slf4j
public class UserController {
  private final UserService userService;

  @GetMapping("/")
  public String showHomePage() {
    return "home";
  }

  @GetMapping("/login")
  public String showLoginPage() {
    return "login";
  }

  @GetMapping("/register")
  public String showRegisterPage() {
    return "register";
  }

  @PostMapping("/createUser")
  public String createUser(@ModelAttribute UserDto userDto) {
    log.info("Creating user with email {}", userDto.getEmail());
    userService.createUser(userDto);
    return "redirect:/login";
  }

  @PostMapping("/authenticate")
  public String authenticate(@ModelAttribute UserDto userDto, HttpServletRequest request) {
    log.info("Authentication user with email {}", userDto.getEmail());
    HttpSession session = request.getSession();
    session.setAttribute("email", userDto.getEmail());
    return userService.authenticateUser(userDto) ? "redirect:/index" : "redirect:/profile";
  }

  @GetMapping("/profile")
  public String showUserProfile(HttpServletRequest request, Model model) {
    HttpSession session = request.getSession();
    String email = (String) session.getAttribute("email");
    UserDto userDto = userService.getUser(email);

    model.addAttribute("user", userDto);
    return "profile";
  }

  @PostMapping("/updateProfile")
  public String updateUserInformation(@ModelAttribute("user") UserDto updatedUser) {
    userService.updateUser(updatedUser);
    return "redirect:/profile";
  }

  @GetMapping("/logout")
  public String logout(HttpServletRequest request) {
    HttpSession session = request.getSession();
    session.invalidate();
    return "redirect:/login";
  }
}
