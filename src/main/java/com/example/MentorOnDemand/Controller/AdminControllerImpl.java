package com.example.MentorOnDemand.Controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.MentorOnDemand.Dao.MentorDao;
import com.example.MentorOnDemand.Exception.ApplicationException;
import com.example.MentorOnDemand.Model.Admin;
import com.example.MentorOnDemand.Model.Mentor;
import com.example.MentorOnDemand.Model.User;
import com.example.MentorOnDemand.Service.AdminService;
import com.example.MentorOnDemand.Service.SkillService;

@Controller
public class AdminControllerImpl implements AdminController {

	@Autowired
	private AdminService adminService;
	@Autowired
	private SkillService skillService;
	@Autowired
	private MentorDao mentorDao;
	Mentor mentor=new Mentor();
	
	
	public static final Logger LOGGER = Logger.getLogger("MentorOnDemand");
	

	@Override
	public boolean insertAdmin(Admin admin) {
		boolean flag = false;
		try {
			flag = adminService.insertAdmin(admin);
		} catch (ApplicationException e) {
			LOGGER.error(e.getMessage());
			e.printStackTrace();
		}
		return flag;
	}
	//Path to the admin register page
	@RequestMapping(path = "/createAdminPage", method = RequestMethod.GET)
	public ModelAndView createAdminPage(Model model) {
		ModelAndView mv = new ModelAndView();
		try {
			mv.setViewName("adminRegister");
			model.addAttribute("registerAdmin", new Admin());
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			e.printStackTrace();
		}
		return mv;
	}
	//Path to the home page
	@RequestMapping(path = "/homePage", method = RequestMethod.GET)
	public ModelAndView home(Model model) {
		ModelAndView mv = new ModelAndView();
		try {
			mv.setViewName("Home");
			model.addAttribute("registerAdmin", new Admin());
			model.addAttribute("registerMentor", new Mentor());
			model.addAttribute("registerUser", new User());
			model.addAttribute("searchMentor", new Mentor());
			mv.addObject("skillList", skillService.getSkillList());
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			e.printStackTrace();
		}
		return mv;
	}

	@RequestMapping(value = "/registerAdmin", method = RequestMethod.GET)
	public ModelAndView registerAdmin(@Valid @ModelAttribute("registerAdmin") Admin admin, BindingResult result,
			HttpServletRequest request, HttpSession session, ModelMap map) throws SQLException {

		ModelAndView mav = null;
		try {
			if (result.hasErrors()) {
				System.out.println("errors");
				System.out.println(result.getAllErrors());
				map.addAttribute("registerAdmin", admin);
				mav = new ModelAndView("adminRegister");
				return mav;
			}
			map.addAttribute("registerAdmin", admin);
			adminService.insertAdmin(admin);
			mav = new ModelAndView("adminLogin");
			mav.addObject("loginAdmin", new Admin());
			mav.addObject("registerAdmin",  new Admin());

		} catch (ApplicationException e) {
			LOGGER.error(e.getMessage());
			e.printStackTrace();
		}
		return mav;

	}
	//Path to the admin login page
	@RequestMapping(path = "/loginAdminPage", method = RequestMethod.GET)
	public ModelAndView loginMentor(Model model) {
		ModelAndView mv = new ModelAndView();
		try {
			mv.setViewName("adminLogin");
			model.addAttribute("loginAdmin", new Admin());
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			e.printStackTrace();
		}
		return mv;
	}

	@RequestMapping(value = "/loginAdmin", method = RequestMethod.POST)
	public ModelAndView adminLogin(@ModelAttribute("loginAdmin") Admin admin, BindingResult result,
			HttpServletRequest request, HttpSession session, ModelMap map) throws Exception {

		ModelAndView mav = null;
		String username=admin.getEmail();
		String password=admin.getPassword();
		Admin adminReturn =adminService.loginAdmin(username, password);
		if (adminReturn!=null) {
			mav = new ModelAndView("adminLandingPage");
			mav.addObject("loginAdmin", new Admin());
		} else
		{
			mav = new ModelAndView("adminLogin");
			mav.addObject("loginAdmin", new Admin());
		}
		return mav;

	}

	@Override
	public Admin loginAdmin(String username, String password) {
		// TODO Auto-generated method stub
		Admin adminObject=null;
		try {
	     adminObject=adminService.loginAdmin(username, password);
		} catch (ApplicationException e) {
			LOGGER.error(e.getMessage());
			e.printStackTrace();
		}
		return adminObject;
	}
	
	@RequestMapping(path = "/viewMentors", method = RequestMethod.GET)
	public ModelAndView viewMentors(Model model) {
		ModelAndView mv = new ModelAndView();
		try {
			mv.setViewName("mentorDisplayByAdmin");
			mv.addObject("allMentorList", mentorDao.findAll());
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			e.printStackTrace();
		}
		return mv;
	}
	
	@RequestMapping(value = "/block", method = RequestMethod.GET)
	public ModelAndView block( @RequestParam("mentorId") int mentorId,HttpServletRequest request, HttpSession session) throws SQLException {
		ModelAndView mv = new ModelAndView();
		try {
		Mentor status = mentorDao.findByMentorId(mentorId);
			int c=0;
			c=status.getAccess();
			if(c==0)
				status.setAccess(1);
			if(c==1)
				status.setAccess(0);
			mentorDao.save(status);
			mv.setViewName("mentorDisplayByAdmin");
			mv.addObject("allMentorList", mentorDao.findAll());
		} catch (Exception e) {

			LOGGER.error(e.getMessage());
			e.printStackTrace();
		}
		return mv;
	}
}
