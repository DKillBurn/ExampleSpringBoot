package com.dkillburn.springweb.api.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/example")
public class ExampleRestController {

	@Autowired
	ExampleService exampleService;

	@GetMapping
	public ResponseEntity<Object> exampleGetEndpoint(){
		return new ResponseEntity<Object>(exampleService.answerGet(), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Object> examplePostEndpoint(@RequestBody ExampleVO obj){
		return new ResponseEntity<Object>(exampleService.answerPost(obj), HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<Object> examplePutEndpoint(@RequestParam("id") Long id, @RequestBody ExampleVO obj){
		return new ResponseEntity<Object>(exampleService.answerPut(id, obj), HttpStatus.ACCEPTED);
	}

	@DeleteMapping
	public ResponseEntity<Object> exampleDeleteEndpoint(@RequestParam("id") Long id){
		return new ResponseEntity<Object>(exampleService.answerDelete(id), HttpStatus.ACCEPTED);
	}
}
