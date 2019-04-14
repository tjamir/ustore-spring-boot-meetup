package com.auth.auth.rest;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.auth.auth.model.Usuario;
import com.auth.auth.services.SessaoService;

@RestController
@RequestMapping("/sessao")
public class SessaoRest {

	@Autowired
	private SessaoService sessaoService;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<String> login(@RequestBody Usuario user) throws Exception {
		String token = sessaoService.login(user);

		return ResponseEntity.ok().body(token);
	}

	@RequestMapping(value = "/logout/{token}", method = RequestMethod.POST)
	public ResponseEntity<Void> logout(@PathVariable String token) throws Exception {
		sessaoService.logout(token);
		return ResponseEntity.ok().build();
	}

	@RequestMapping(value = "/check/{token}", method = RequestMethod.GET)
	public ResponseEntity<Boolean> check(@PathVariable String token) throws Exception {
		boolean check = sessaoService.check(token);
		
		return ResponseEntity.ok().body(check);
	}

}
