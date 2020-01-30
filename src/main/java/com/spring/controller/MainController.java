package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.dao.EmpDao;
import com.spring.model.Employee;

@Controller
public class MainController {

	@Autowired
	EmpDao dao;

	@RequestMapping(value = "/display")
	public String display(Model m) {
		Employee emp = new Employee();
		m.addAttribute("emp", emp);
		return "Addform";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@ModelAttribute("emp") Employee emp) {
		dao.save(emp);
		return "redirect:/viewemp";
	}

	@RequestMapping("/viewemp")
	public String viewemp(Model m) {
		List<Employee> list = dao.getEmployees();
		m.addAttribute("list", list);
		return "viewemp";
	}

	@RequestMapping(value = "/editemp")
	public String editemp(Model m) {
		Employee emp = new Employee();
		m.addAttribute("edit", emp);
		return "editform";

	}
	@RequestMapping(value="/editsave",method=RequestMethod.POST)
	public String editsave(@ModelAttribute Employee emp) {
		dao.update(emp);
		 return "redirect:/viewemp";
		
	}
	@RequestMapping(value = "/deleteemp")
	public String deleteemp(Model m)
	{
		Employee emp=new Employee();
		m.addAttribute("del", emp);
		return "delform";
	}
	@RequestMapping(value="/delemp",method=RequestMethod.POST)
	public String delemp(@ModelAttribute Employee emp) {
	dao.delete(emp);
	return "redirect:/viewemp";
}
}
