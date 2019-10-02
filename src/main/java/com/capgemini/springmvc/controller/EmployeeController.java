package com.capgemini.springmvc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.capgemini.springmvc.beans.EmployeeBean;
import com.capgemini.springmvc.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService service;

	@GetMapping("/loginForm")
	public ModelAndView getLoginForm(ModelAndView modelAndView) {
		modelAndView.setViewName("loginForm");
		return modelAndView;
	}// end of getLoginForm() getMapping
	
	@PostMapping("/login")
	public String login(@RequestParam(name = "empId") int id, @RequestParam(name="password") String pwd, HttpServletRequest req) {
		EmployeeBean employeeBean = service.login(id, pwd);
		if(employeeBean != null) {
			HttpSession session = req.getSession(true);
			session.setAttribute("employeeBean", employeeBean);
			return "employeeHome";
		} else {
			req.setAttribute("msg", "Invalid Credentials");
			return "loginForm";
		}
	}// end of login() postMapping

//	@PostMapping("/login2")
//	public String login2(int empId, String password, HttpServletRequest req) {
//		EmployeeBean employeeBean= service.login(empId, password);
//		if(employeeBean != null) {
//			HttpSession session = req.getSession(true);
//			session.setAttribute("employeeBean", employeeBean);
//			return "employeeHome";
//		} else {
//			req.setAttribute("msg", "Invalid Credentials");
//			return "loginForm";
//		}
	//}// end of login2() postMapping


	@GetMapping("/addEmployee")
	public String getAddEmployee(HttpSession session, ModelMap modelMap) {
		if (session.isNew()) {
			session.invalidate();
			modelMap.addAttribute("msg", "Please Login First!");
			return "loginForm";
		} else {
			return "addEmployeeForm";
		}
	}//end of getAddEmployee() getMapping

	@PostMapping("/addEmployee")
	public String addEmployee(EmployeeBean employeeBean, ModelMap modelMap) {
		if(service.addEmployee(employeeBean)) {
			modelMap.addAttribute("msg", "Employee Added Successfully");
		}else {
			modelMap.addAttribute("msg", "Employee Alreadt Exist ");
		}
		return "addEmployeeForm";
	}// end of addEmployee() postMapping

	/*
	 * @GetMapping("/searchEmployee") public String
	 * searchEmployee(@RequestParam(name = "emp_Id") int empId,ModelMap modelMap) {
	 * EmployeeBean employeeBean = dao.searchEmployee(empId); if(employeeBean!=null)
	 * { modelMap.addAttribute("employeeBean", employeeBean); return
	 * "searchEmployee"; }else { modelMap.addAttribute("msg", "Employee not found");
	 * return "searchEmployee"; } }
	 */

	@GetMapping("/searchEmployee") 
	public String searchEmployee(HttpSession session, ModelMap modelMap) {
		if (session.isNew()) {
			session.invalidate();
			modelMap.addAttribute("msg", "Please Login First!");
			return "loginForm";
		} else {
			return"searchEmployee";
		}
	}// end of searchEmployee() getMapping

	@PostMapping("/searchEmployee") 
	public String getEmployee(int empId, ModelMap modelMap) { 
		EmployeeBean employeeBean = service.searchEmployee(empId) ;
		if(employeeBean!= null) { 
			modelMap.addAttribute("employeeBean", employeeBean); 
		}else {
			modelMap.addAttribute("msg", "Employee Not Found"); 
		}
		return "searchEmployee";
	}// end of getEmployee() postMapping


	@GetMapping("/deleteEmployee")
	public String deleteEmployee(HttpSession session, ModelMap modelMap) {
		if (session.isNew()) {
			session.invalidate();
			modelMap.addAttribute("msg", "Please Login First!");
			return "loginForm";
		} else {
			return "deleteEmployee";
		}
	}// end of deleteEmployee() getMapping

	@PostMapping("/deleteEmployee")
	public String deleteEmploy(int empId, ModelMap modelMap) {
		if(service.deleteEmployee(empId)) {
			modelMap.addAttribute("msg", "Employee Deleted Successfully");
		}else {
			modelMap.addAttribute("msg", "Employee data not found");
		}
		return "deleteEmployee";
	}// end of deleteEmploy() postMapping

	@GetMapping("/updateEmployee")
	public String updateEmployee(HttpSession session, ModelMap modelMap) {
		if (session.isNew()) {
			session.invalidate();
			modelMap.addAttribute("msg", "Please Login First!");
			return "loginForm";
		} else {
			return "updateEmployeeForm";
		}
	}// end of updateEmployee() get Mapping

	@PostMapping("/updateEmployee")
	public String update(EmployeeBean employeeBean, ModelMap modelMap) {
		if(service.updateEmployee(employeeBean)) {
			modelMap.addAttribute("msg", "Employee Updated Successfully");
		}else {
			modelMap.addAttribute("msg", "Failed to Update");
		}
		return "updateEmployeeForm";
	}// end of update() postMapping
	
	@GetMapping("/getAllEmployees")
	public String getAllEmployee(HttpSession session, ModelMap modelMap) {
		if (session.isNew()) {
			modelMap.addAttribute("msg", "Please Login First!");
			return "loginForm";
		} else {
			List<EmployeeBean> employeeList = service.getEmployee();
			modelMap.addAttribute("employeeList", employeeList);
			
			return "allEmployeeDetails";
		}

	}// End of getAllEmployee()
	
	@GetMapping("/logout")
	public String logout(HttpSession session, ModelMap modelMap) {
		session.invalidate();
		modelMap.addAttribute("msg", "You Are Successfully Logged Out!");
		return "forward:/loginForm";
	}// End of logout()
}

