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

import com.example.MentorOnDemand.Exception.ApplicationException;
import com.example.MentorOnDemand.Model.Skill;
import com.example.MentorOnDemand.Service.SkillService;

@Controller
public class SkillControllerImpl implements SkillController {

	@Autowired
	private SkillService skillService;
	public static final Logger LOGGER = Logger.getLogger("MentorOnDemand");

	@Override
	public boolean insertSkill(Skill skill) {
		boolean flag = false;
		try {
			flag = skillService.insertSkill(skill);
		} catch (ApplicationException e) {
			LOGGER.error(e.getMessage());
			e.printStackTrace();
		}
		return flag;
	}

	@RequestMapping(path = "/createSkillPage", method = RequestMethod.GET)
	public ModelAndView createAdminPage(Model model) {
		ModelAndView mv = new ModelAndView();
		try {
			mv.setViewName("skillRegister");
			model.addAttribute("registerSkill", new Skill());
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			e.printStackTrace();
		}
		return mv;
	}

	@RequestMapping(value = "/registerSkill", method = RequestMethod.GET)
	public ModelAndView registerSkill(@Valid @ModelAttribute("registerSkill") Skill skill, BindingResult result,
			HttpServletRequest request, HttpSession session, ModelMap map) throws SQLException {

		ModelAndView mav = null;
		try {
			if (result.hasErrors()) {
				System.out.println("errors");
				System.out.println(result.getAllErrors());
				map.addAttribute("registerSkill", skill);
				mav = new ModelAndView("skillRegister");
				return mav;
			}
			map.addAttribute("registerSkill", skill);
			skillService.insertSkill(skill);
			mav = new ModelAndView("skillList");
			mav.addObject("skillList", skillService.getSkillList());
			
		} catch (ApplicationException e) {
			LOGGER.error(e.getMessage());
			e.printStackTrace();
		}
		return mav;

	}
	
	@RequestMapping(path = "/skillList")
	public ModelAndView getSkill() throws SQLException  {
		ModelAndView mv = new ModelAndView();
		try {
			mv.setViewName("skillList");
			mv.addObject("skillList", skillService.getSkillList());
		} catch (Exception e) {

			LOGGER.error(e.getMessage());
			e.printStackTrace();
		}
		return mv;
	}

	@Override
	public List<Skill> getSkillList() throws SQLException, ApplicationException {
		// TODO Auto-generated method stub
		return skillService.getSkillList();
	}

	

}
