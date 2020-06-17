package com.akcreations.springwebservice.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	//get simple string
	@GetMapping(path="/hello-world")
	public String helloworld()
	{
		return "hello-world";
	}
	
	// get a JSON OBJECT
	@GetMapping(path="/hello-bean")
	public HelloWorldBean getHelloWorldBean()
	{
		return new HelloWorldBean("hello-world");
	}
	
	// get the response based on path variable or params
	@GetMapping( path="/hello/{name}")
	public HelloWorldBean getHelloUser(@PathVariable String name)
	{
		return new HelloWorldBean(String.format("Hello, %s", name));
	}
	

}
