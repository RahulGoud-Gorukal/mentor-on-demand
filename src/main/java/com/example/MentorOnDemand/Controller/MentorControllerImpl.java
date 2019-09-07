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
import org.springframework.web.servlet.ModelAndView;

import com.example.MentorOnDemand.Dao.MentorDao;
import com.example.MentorOnDemand.Dao.ProposalRequestDao;
import com.example.MentorOnDemand.Exception.ApplicationException;
import com.example.MentorOnDemand.Model.Mentor;
import com.example.MentorOnDemand.Model.ProposalRequest;
import com.example.MentorOnDemand.Service.MentorService;
import com.example.MentorOnDemand.Service.SkillService;

@Controller
public class MentorControllerImpl implements MentorController {
	@Autowired
	private MentorService mentorService;
	@Autowired
	private SkillService skillService;

	@Autowired
	private MentorDao mentorDao;

	@Autowired
	private ProposalRequestDao proposalRequestDao;
	public static final Logger LOGGER = Logger.getLogger("MentorOnDemand");

	@Override
	public boolean insertMentor(Mentor mentor) {
		boolean flag = false;
		try {
			flag = mentorService.insertMentor(mentor);
		} catch (ApplicationException e) {
			LOGGER.error(e.getMessage());
			e.printStackTrace();
		}
		return flag;
	}

	@RequestMapping(path = "/createMentorPage", method = RequestMethod.GET)
	public ModelAndView createMentorPage(Model model) {
		ModelAndView mv = new ModelAndView();
		try {
			mv.setViewName("mentorRegister");
			model.addAttribute("registerMentor", new Mentor());
			mv.addObject("skillList", skillService.getSkillList());
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			e.printStackTrace();
		}
		return mv;
	}

	@RequestMapping(value = "/registerMentor", method = RequestMethod.GET)
	public ModelAndView registerMentor(@Valid @ModelAttribute("registerMentor") Mentor mentor, BindingResult result,
			HttpServletRequest request, HttpSession session, ModelMap map) throws SQLException {

		ModelAndView mav = null;
		mentor.setAccess(0);
		try {
			if (result.hasErrors()) {
				System.out.println("errors");
				System.out.println(result.getAllErrors());
				map.addAttribute("registerMentor", mentor);
				mav = new ModelAndView("mentorRegister");
				mav.addObject("skillList", skillService.getSkillList());
				return mav;
			}
			map.addAttribute("registerMentor", mentor);
			mentorService.insertMentor(mentor);
			mav = new ModelAndView("mentorLogin");
			mav.addObject("loginMentor", new Mentor());
			mav.addObject("registerMentor", new Mentor());
			mav.addObject("skillList", skillService.getSkillList());

		} catch (ApplicationException e) {
			LOGGER.error(e.getMessage());
			e.printStackTrace();
		}
		return mav;

	}

	@RequestMapping(path = "/loginMentorPage", method = RequestMethod.GET)
	public ModelAndView loginMentorPage(Model model) {
		ModelAndView mv = new ModelAndView();
		try {
			mv.setViewName("mentorLogin");
			model.addAttribute("loginMentor", new Mentor());
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			e.printStackTrace();
		}
		return mv;
	}

	@RequestMapping(value = "/loginMentor", method = RequestMethod.POST)
	public ModelAndView loginMentor(@ModelAttribute("loginMentor") Mentor mentor, BindingResult result,
			HttpServletRequest request, HttpSession session, ModelMap map) throws Exception {

		ModelAndView mav = null;
		String username = mentor.getEmail();
		String password = mentor.getPassword();
		int id = mentorDao.findByEmail(username);
		int access=mentor.getAccess();
		session = request.getSession();
		session.setAttribute("mentorId", id);
		System.out.println(session.getAttribute("mentorId"));
		Mentor mentorReturn = mentorService.loginMentor(username, password);
		if (mentorReturn != null && access==1) {
			mav = new ModelAndView("mentorLandingPage");
			mav.addObject("loginMentor", new Mentor());
		} else if(mentorReturn != null && access==0) {
			mav = new ModelAndView("mentorLogin");
			mav.addObject("loginMentor", new Mentor());
		}
		else
		{
			mav = new ModelAndView("check");
		}
		return mav;

	}

	@Override
	public Mentor loginMentor(String username, String password) {
		// TODO Auto-generated method stub
		Mentor mentorObject = null;
		try {
			mentorObject = mentorService.loginMentor(username, password);
		} catch (ApplicationException e) {
			LOGGER.error(e.getMessage());
			e.printStackTrace();
		}
		return mentorObject;
	}

	@RequestMapping(path = "/searchMentorPage", method = RequestMethod.GET)
	public ModelAndView searchMentorPage(Model model) {
		ModelAndView mv = new ModelAndView();
		try {
			mv.setViewName("Home");
			model.addAttribute("searchMentor", new Mentor());
			// mv.addObject("searchMentor", new Mentor());
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			e.printStackTrace();
		}
		return mv;
	}

	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public ModelAndView search(@ModelAttribute("searchMentor") Mentor mentor, BindingResult result,
			HttpServletRequest request, HttpSession session, ModelMap map) throws Exception {

		ModelAndView mav = null;
		String skill = mentor.getTechnology();
		mav = new ModelAndView("matchingMentors");
		mav.addObject("mentorList", mentorService.searchMentor(skill));
		return mav;

	}

	@RequestMapping(path = "/mentorNotify", method = RequestMethod.GET)
	public ModelAndView mentorNotify(Model model, HttpSession session) {
		ModelAndView mv = new ModelAndView();
		try {
			if (session.getAttribute("mentorId") != null) {
				mv.setViewName("displayProposals");
				mv.addObject("proposalList", proposalRequestDao.mentorNotify((int) session.getAttribute("mentorId")));
			}
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			e.printStackTrace();
		}
		return mv;
	}

}
