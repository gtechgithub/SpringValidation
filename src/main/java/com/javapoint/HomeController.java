package com.javapoint;

import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@Autowired
	private EmployeeValidator validator;
	
	@RequestMapping(value="submit", method=RequestMethod.GET)
	public ModelAndView submitSetupForm() {
		
		System.out.println("inside submit setup form");
		Employee emp = new Employee();
		ModelAndView model = new ModelAndView();
		model.setViewName("submit");
		model.addObject("employee", emp);
		return model;
	}

	
	@RequestMapping(value="/submitForm", method=RequestMethod.POST)
	public String submitEmployee(@ModelAttribute("employee") Employee employee, BindingResult result) {
		
		validator.validate(employee, result);
		
		if (result.hasErrors()) {
			return "submit"; 
		}
		return "success";
	}
}
