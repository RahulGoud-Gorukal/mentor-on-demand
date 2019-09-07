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

import com.example.MentorOnDemand.Dao.ProposalRequestDao;
import com.example.MentorOnDemand.Dao.UserDao;
import com.example.MentorOnDemand.Exception.ApplicationException;
import com.example.MentorOnDemand.Model.Admin;
import com.example.MentorOnDemand.Model.Mentor;
import com.example.MentorOnDemand.Model.ProposalRequest;
import com.example.MentorOnDemand.Model.User;
import com.example.MentorOnDemand.Service.MentorService;
import com.example.MentorOnDemand.Service.UserService;

@Controller
public class UserControllerImpl implements UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private UserDao userDao;
	@Autowired
	private MentorService mentorService;

	ProposalRequest proposalRequest = new ProposalRequest();
	@Autowired
	private ProposalRequestDao proposalRequestDao;

	public static final Logger LOGGER = Logger.getLogger("MentorOnDemand");

	@Override
	public boolean insertUser(User user) {
		// TODO Auto-generated method stub
		boolean flag = false;
		try {
			flag = userService.insertUser(user);
		} catch (ApplicationException e) {
			LOGGER.error(e.getMessage());
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public User loginUser(String username, String password) {
		// TODO Auto-generated method stub
		User userObject = null;
		try {
			userObject = userService.loginUser(username, password);
		} catch (ApplicationException e) {
			LOGGER.error(e.getMessage());
			e.printStackTrace();
		}
		return userObject;
	}

	// Path to the user registration page
	@RequestMapping(path = "/createUserPage", method = RequestMethod.GET)
	public ModelAndView createUserPage(Model model) {
		ModelAndView mv = new ModelAndView();
		try {
			mv.setViewName("userRegister");
			model.addAttribute("registerUser", new User());
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			e.printStackTrace();
		}
		return mv;
	}

	@RequestMapping(value = "/registerUser", method = RequestMethod.GET)
	public ModelAndView registerUser(@Valid @ModelAttribute("registerUser") User user, BindingResult result,
			HttpServletRequest request, HttpSession session, ModelMap map) throws SQLException {

		ModelAndView mav = null;
		try {
			if (result.hasErrors()) {
				System.out.println("errors");
				System.out.println(result.getAllErrors());
				map.addAttribute("registerUser", user);
				mav = new ModelAndView("userRegister");
				return mav;
			}
			map.addAttribute("registerUser", user);
			userService.insertUser(user);
			// mav = new ModelAndView("Home");
			mav = new ModelAndView("userLogin");
			mav.addObject("loginUser", new User());
			mav.addObject("registerUser", new User());

		} catch (ApplicationException e) {
			LOGGER.error(e.getMessage());
			e.printStackTrace();
		}
		return mav;

	}

	// Path to the user login page
	@RequestMapping(path = "/loginUserPage", method = RequestMethod.GET)
	public ModelAndView loginUser(Model model) {
		ModelAndView mv = new ModelAndView();
		try {
			mv.setViewName("userLogin");
			model.addAttribute("loginUser", new User());
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			e.printStackTrace();
		}
		return mv;
	}

	@RequestMapping(value = "/loginUser", method = RequestMethod.POST)
	public ModelAndView userLogin(@ModelAttribute("loginUser") User user, BindingResult result,
			HttpServletRequest request, HttpSession session, ModelMap map) throws Exception {

		ModelAndView mav = null;
		String username = user.getEmail();
		String password = user.getPassword();
		String name = userDao.findByUsername(username);
		session = request.getSession();
		session.setAttribute("userName", name);
		User userReturn = userService.loginUser(username, password);
		if (userReturn != null) {
			mav = new ModelAndView("userLandingPage");
			mav.addObject("loginUser", new User());
		} else {
			mav = new ModelAndView("userLogin");
			mav.addObject("loginAdmin", new Admin());
		}
		return mav;

	}

	@RequestMapping(path = "/mentorList")
	public ModelAndView getCompanyList(HttpSession session) throws SQLException {
		ModelAndView mv = new ModelAndView();
		try {
			mv.setViewName("matchingMentors");
			// mv.setViewName("displayMentors");
			List<ProposalRequest> statusList=proposalRequestDao.status((String)session.getAttribute("userName"));
			//System.out.println(statusList);
			mv.addObject("mentorList", mentorService.getMentorList());
			mv.addObject("statusList",statusList);
			mv.addObject("searchMentor", new Mentor());
		} catch (Exception e) {

			LOGGER.error(e.getMessage());
			e.printStackTrace();
		}
		return mv;
	}

	@RequestMapping(value = "/requestMentor", method = RequestMethod.GET)
	public ModelAndView getMentor(@RequestParam("username") String username,
			@RequestParam("technology") String technology, @RequestParam("mentorId") int mentorId,
			@RequestParam("mentorName") String mentorName,HttpServletRequest request, HttpSession session) throws SQLException {
		ModelAndView mv = new ModelAndView();
		try {
			int id = userDao.findByUserId(username);
			session = request.getSession();
			session.setAttribute("userId",id);
			proposalRequest.setMentorId(mentorId);
			proposalRequest.setTraineeId(id);
			proposalRequest.setMentorName(mentorName);
			proposalRequest.setTechnology(technology);
			proposalRequest.setTraineeName(username);
			proposalRequest.setProposalStatus("Pending");
			proposalRequestDao.save(proposalRequest);
			mv.setViewName("check");
		} catch (Exception e) {

			LOGGER.error(e.getMessage());
			e.printStackTrace();
		}
		return mv;
	}

	@RequestMapping(value = "/accept", method = RequestMethod.GET)
	public ModelAndView accept(@RequestParam("proposalId") int proposalId) throws SQLException {
		ModelAndView mv = new ModelAndView();
		try {
			ProposalRequest pr = proposalRequestDao.acceptanceStatus(proposalId);
			pr.setProposalStatus("Accepted");
			proposalRequestDao.save(pr);
			mv.setViewName("check");
		} catch (Exception e) {

			LOGGER.error(e.getMessage());
			e.printStackTrace();
		}
		return mv;
	}

	@RequestMapping(value = "/reject", method = RequestMethod.GET)
	public ModelAndView reject(@RequestParam("proposalId") int proposalId) throws SQLException {
		ModelAndView mv = new ModelAndView();
		try {
			ProposalRequest pr = proposalRequestDao.acceptanceStatus(proposalId);
			pr.setProposalStatus("Rejected");
			proposalRequestDao.save(pr);
			mv.setViewName("check");
		} catch (Exception e) {

			LOGGER.error(e.getMessage());
			e.printStackTrace();
		}
		return mv;
	}
	
	@RequestMapping(path = "/userNotify", method = RequestMethod.GET)
	public ModelAndView mentorNotify(Model model, HttpSession session) {
		ModelAndView mv = new ModelAndView();
		String status="Accepted";
		try {
			if (session.getAttribute("userName") != null) {
				mv.setViewName("acceptedProposals");
				mv.addObject("acceptanceList", proposalRequestDao.userNotify( (String)session.getAttribute("userName"),status));
			}
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			e.printStackTrace();
		}
		return mv;
	}

}
