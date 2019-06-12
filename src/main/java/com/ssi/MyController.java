package com.ssi;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


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
	public ModelAndView showResult(@RequestParam("t1") int amount, @RequestParam("t2") int time){
		
		int interest=(amount*time*10)/100;
		
		InterestModel interestModel=new InterestModel();
		interestModel.setAmount(amount);
		interestModel.setTime(time);
		interestModel.setInterest(interest);
		
		ModelAndView mv=new ModelAndView();
		mv.setViewName("result.jsp");
		mv.addObject("data", interestModel);
		
		
		
		return mv;
	}
	
	
	@RequestMapping("test")
	public void testing(){
		System.out.println("Testing Success----------------->!!!!!!!!");
	}
	
}
