package com.dkillburn.springweb.api.example;

import org.springframework.stereotype.Service;

@Service
public class ExampleServiceImpl implements ExampleService{

	//Any Repository/Entity Based DBA, redis, etc...

	@Override
	public String answerGet(){
		return "Get answer from example";
	}

	@Override
	public String answerPost(ExampleVO obj){
		return "Post answer from example";
	}

	@Override
	public String answerPut(long id, ExampleVO obj){
		return "Put answer from example";
	}

	@Override
	public String answerDelete(long id){
		return "Delete answer from example";
	}
}
