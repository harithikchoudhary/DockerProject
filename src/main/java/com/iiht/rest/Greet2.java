package com.iiht.rest;

import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//api
//endpoint - means service rest or soap or where service is listening
//handler
@RestController
@RequestMapping("/rest/api.2.0")
public class Greet2 {

	@GetMapping
	@RequestMapping("/welcome")
	public ResponseEntity<String> msg() {
		ResponseEntity<String> response = new ResponseEntity<>("OLA! Commo Sava", HttpStatus.OK);
		return response;
	}

	@GetMapping
	@RequestMapping("/time")
	public ResponseEntity<String> getTime() {
		return ResponseEntity.status(HttpStatus.OK).body(Calendar.getInstance().getTime() + "");
	}

	@GetMapping
	@RequestMapping("gender/{gender}")
	public String genderMessage(@PathVariable String gender) {

		if (gender.equals("Female"))
			return "Welcome Miss";
		if (gender.equals("Male"))
			return "Welcome Mr";
		else
			return "Welcome";

	}

	@GetMapping
	@RequestMapping("namegender/{name}/{gender}")
	public ResponseEntity<String> genderMessage2(@RequestHeader HttpHeaders headers, @PathVariable String name,
			@PathVariable String gender) {

		Set set = headers.keySet();

		Iterator<String> keys = set.iterator();

		String keyStr = null;

		while (keys.hasNext()) {

			keyStr += keys.next() + "\n";
		}

		Set<Entry<String, List<String>>> entries = headers.entrySet();
		Iterator itr2 = entries.iterator();

		String keyValueStr = null;
		while (itr2.hasNext()) {

			keyValueStr += itr2.next() + "\n";
		}

		// keyStr
		// return keyValueStr;

		HttpHeaders headers2 = new HttpHeaders();

		headers2.setAcceptCharset(null);
		headers2.setContentType(MediaType.TEXT_HTML);
		headers.setContentLength(keyValueStr.length());
		headers2.set("ust", "GammaTraining#6");

		return ResponseEntity.status(HttpStatus.OK).headers(headers2).body(keyValueStr);

	}

	
	/*
	 * @PostMapping
	 * 
	 * @RequestMapping(value = "/namegender", consumes
	 * =" MediaType.APPLICATION_JSON_VALUE", produces =
	 * "MediaType.APPLICATION_JSON_VALUE") public ResponseEntity<Member>
	 * genderMessage3(@RequestBody Member member) {
	 * 
	 * member.setName(member.getName()+"Hello"); return ResponseEntity.ok(member); }
	 * 
	 * 
	 * if (member.getGender().equals("Female")) { return
	 * ResponseEntity.ok("welcome Miss" + member.getName()); }
	 * 
	 * else if (member.getGender().equals("Male")) { return
	 * ResponseEntity.ok("Welcome Mr " + member.getName()); }
	 * 
	 * else return ResponseEntity.ok("welcome" + member.getName()); }
	 */
	 
}
