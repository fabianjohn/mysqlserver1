package com.example.demo.controller;


import java.util.List;

import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.domain.Student;
import com.example.demo.service.StudentService;



@Controller
public class StudentController {
	@Autowired
	private StudentService service;

	@GetMapping("/")
	public String viewHomePage(Model model)
	{
		List<Student>liststudent = service.listAll();
		model.addAttribute("liststudent", liststudent);
		System.out.print("Get / ");
		return "index";
	}
	@GetMapping("/new")
	public String add(Model model)
	{
		model.addAttribute("student",new Student());
		return "new";
	}
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveStudent(@ModelAttribute("student") Student std)
	{
		service.save(std);
		return"redirect:/";
	}
	/*@RequestMapping("/edit/{id}")
	public ModelAndView showEdithStudentPage(@PathVariable(name="id") int id)
	{
		ModelAndView mav = new ModelAndView("editing");
		Student std = service.get(id);
		mav.addObject("student", std);
		return mav;		
	}
	*/
	
	@RequestMapping(value = "/saved", method = RequestMethod.POST)
	public String show(@ModelAttribute("student") Student std) 
	{	
		service.save(std);	
		return "getdetai";
	}
	
	@RequestMapping("/editing")
	public String show(Model model) 
	{
		model.addAttribute("student",new Student());
		
		return "editing";
	}
	
	@RequestMapping("/edit/{id}")
	public ModelAndView showEdithStudentPage(@PathVariable(name="id") int id)
	{
		ModelAndView mav = new ModelAndView("editing");
		Student std = service.get(id);
		mav.addObject("student", std);
		
		return mav;	}
	
	@RequestMapping("/delete/{id}")
	public String deletestudent(@PathVariable(name="id") int id) {
		
		service.delete(id);
		return"redirect:/";
	}
	
	@PostMapping("/get")
	public String get(@RequestParam("studentname") String studentname,
							@RequestParam("course") String course,
							@RequestParam("fee") int fee, ModelMap modelMap)
	{
		modelMap.put("studentname", studentname);
		modelMap.put("course", course);
		modelMap.put("fee",fee);
		return"new";
	}
	/*
	 @PostMapping("/#")
	    public ModelAndView getDetails(@PathVariable(name="id") int id)
	    { 
	    ModelAndView mv = new ModelAndView("#");
	    String student = service.findById(id).toString();
	    mv.addObject(student);
	    return mv;
	    }
	    */
	 @RequestMapping("/details")
	 public String home()
	 {
		 return"details";
	 }
	 @RequestMapping("/home")
	 public String homepage()
	 {
		 return"home";
	 }
}

/*
@GetMapping("/")
public String viewHomePage(Model model)
{
	List<Student1>liststudent = service.listAll();
	model.addAttribute("liststudent", liststudent);
	System.out.println("Get / ");
	return "index";
}
@GetMapping("/new")
public String add(Model model)
{
	model.addAttribute("student1",new Student1());
	return "new";
}
@RequestMapping(value = "/save", method = RequestMethod.POST)
public String saveStudent1(@ModelAttribute("student1") Student1 stud)
{
	service.save(stud);
	return"redirect:/";
}
@RequestMapping("/edit/{id}")
public ModelAndView showEdithStuden1tPage(@PathVariable(name="id") int id)
{
	ModelAndView mav = new ModelAndView("new");
	Student1 stud = service.get(id);
	mav.addObject("student1", stud);
	return mav;
		
}
@RequestMapping("/delete/{id}")
public String deletestudent(@PathVariable(name="id") int id) {
	
	service.delete(id);
	return"redirect:/";
}

@PostMapping("/get")
public String ViewRecord(@RequestParam("studentname") String studentname,
						@RequestParam("course") String course,
						@RequestParam("fee") int fee, ModelMap modelMap)
{
	modelMap.put("studentname", studentname);
	modelMap.put("course", course);
	modelMap.put("fee",fee);
	return"getdetai";
}

 @PostMapping("/details")
    public ModelAndView getDetails(@PathVariable(name="id") int id)
    { 
    ModelAndView mv = new ModelAndView("getdetai");
    String student = service.findById(id).toString();
    mv.addObject(student);
    return mv;
    }
 @RequestMapping("/viewpage")
 public String home()
 {
	 return"viewpage";
 }
 @RequestMapping("/home")
 public String homepage()
 {
	 return"home";
 }
 @RequestMapping("/gg")
 public String datailspage()
 {
	 return"deta";
 }
 
}
*/