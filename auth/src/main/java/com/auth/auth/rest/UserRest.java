/**
 * 
 */
package com.auth.auth.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.auth.auth.model.Usuario;
import com.auth.auth.services.UserService;

/**
 * @author mabi
 *
 */
@RestController
@RequestMapping("/user")
public class UserRest {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Usuario> find(@PathVariable Long id) {
		Usuario user = userService.findUser(id);
		return ResponseEntity.ok().body(user);
	}

}
