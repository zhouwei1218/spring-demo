package com.zww.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zww.domain.User;
import com.zww.domain.UserRepository;

@RestController
public class UserController {
	@Autowired
	UserRepository useRepository;
	/**
	 * 查询所有
	 * @return
	 */
	@RequestMapping("/getAll")
	List<User> findAll(){
		return useRepository.findAll();
	}
	/**
	 * 保存一个
	 * @param username 
	 * @param password
	 * @return
	 */
	@PostMapping("/save")
	User createUser(@RequestParam("username")String username, @RequestParam("password")String password) {
		User user = new User();
		user.setPassWord(password);
		user.setUserName(username);
		return useRepository.save(user);
		
	}
	/**
	 * 根据姓名查询
	 */
	@GetMapping(value="/query/name/{name}")
	List<User> queryByName(@PathVariable("name") String name) {
		return useRepository.findByUserName(name);
	}
	/**
	 * 更新
	 * @param id
	 * @param username
	 * @param password
	 * @return
	 */
	@PutMapping(value="/update/{id}")
	User uppdate(@PathVariable("id") long id,
					@RequestParam("username")String username, @RequestParam("password")String password) {
		User user = new User();
		user.setId(id);
		user.setPassWord(password);
		user.setUserName(username);
		return useRepository.save(user);
	}
	/**
	 * 删除
	 * @param id
	 */
	@GetMapping(value="/delete/{id}")
	void deleteById(@PathVariable("id") long id) {
		useRepository.deleteById(id);
	}
	
}
