package com.dkillburn.springweb.api.example;

public interface ExampleService {
    public String answerGet();
	public String answerPost(ExampleVO obj);
	public String answerPut(long id, ExampleVO obj);
	public String answerDelete(long id);
}
