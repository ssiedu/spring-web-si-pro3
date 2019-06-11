package com.ssi;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class MyController {

	//it should display details.jsp
	//this method should be called when url ends with /inputs
	@RequestMapping("inputs")
	public String showForm(){
		return "details.jsp";
	}
	
	//it should read the request,process it, provides the response
	//this method shouldbe called when url ends with /process
	@RequestMapping("process")
	public void showResult(@RequestParam("t1") int amount, @RequestParam("t2") int time, HttpServletResponse response){
		
		int interest=(amount*time*10)/100;
		try {
			PrintWriter out=response.getWriter();
			out.println("Your Interest Amount : "+interest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	
	@RequestMapping("test")
	public void testing(){
		System.out.println("Testing Success----------------->!!!!!!!!");
	}
	
}
