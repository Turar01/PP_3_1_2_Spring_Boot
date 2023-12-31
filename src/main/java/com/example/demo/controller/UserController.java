package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/")
public class UserController {

	private final UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/")
	public String getAllUsers(Model model) {
		model.addAttribute("users", userService.getAllUsers());
		return "/users/index";
	}

	@GetMapping("/new")
	public String newPerson(Model model) {
		model.addAttribute("user", new User());
		return "users/new";
	}

	@PostMapping()
	public String create(@ModelAttribute("user") User user) {
		userService.save(user);
		return "redirect:/";
	}

	@GetMapping("/{id}/edit")
	public String edit(Model model, @PathVariable("id") long id) {
		model.addAttribute("user", userService.getUser(id));
		return "users/edit";
	}

	@PatchMapping("/{id}")
	public String update(@ModelAttribute("user") User user, @PathVariable("id") long id) {

		userService.update(id, user);
		return "redirect:/";
	}

	@DeleteMapping("/{id}")
	public String delete(@PathVariable("id") long id) {
		userService.delete(id);
		return "redirect:/";

	}
}