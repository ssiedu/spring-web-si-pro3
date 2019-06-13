package com.ssi;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class MyController {

	@Autowired
	private InterestService interestService;
	
	
	@RequestMapping("inputs")
	public String showForm(){
		return "details.jsp";
	}
	
	@RequestMapping("process")
	public ModelAndView showResult(@ModelAttribute("data") InterestModel model){
		interestService.calculateInterest(model);
		ModelAndView mv=new ModelAndView("result.jsp");
		return mv;
	}
	
	
	@RequestMapping("test")
	public void testing(){
		System.out.println("Testing Success----------------->!!!!!!!!");
	}
	
}
