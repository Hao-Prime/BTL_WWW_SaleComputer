package btl.salecomputers.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import btl.salecomputers.entity.Authenticate;
import btl.salecomputers.entity.KhachHang;
import btl.salecomputers.entity.User;
import btl.salecomputers.service.AuthenticateService;
import btl.salecomputers.service.UserService;

@Controller
@RequestMapping("/register")
public class RegisterController {

	@Autowired
	private UserDetailsManager userDetailsManager;

	private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	private Logger logger = Logger.getLogger(getClass().getName());
	
	@Autowired
	private UserService userService;
	@Autowired
	private AuthenticateService authenticateService;

	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {

		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}

	@GetMapping("/showRegistrationForm")
	public String showMyLoginPage(Model theModel) {
		User user = new User();

		theModel.addAttribute("crmUser", user);

		return "registration-form";

	}

	@PostMapping("/processRegistrationForm")
	public String processRegistrationForm(@Valid @ModelAttribute("crmUser") User theCrmUser,
			BindingResult theBindingResult, Model theModel) {

		String userName = theCrmUser.getUsername();
		String password = theCrmUser.getPassword();
		logger.info("Processing registration form for: " + userName);
		if(userName == null || password == null) {
			theModel.addAttribute("crmUser", new User());
			theModel.addAttribute("registrationError", "User name/password can not be empty.");

			logger.warning("User name/password can not be empty.");

			return "registration-form";
		}
		// form validation
//		if (theBindingResult.hasErrors()) {
//
//			theModel.addAttribute("crmUser", new User());
//			theModel.addAttribute("registrationError", "User name/password can not be empty.");
//
//			logger.warning("User name/password can not be empty.");
//
//			return "registration-form";
//		}

		// check the database if user already exists
		boolean userExists = doesUserExist(userName);

		if (userExists) {
			theModel.addAttribute("crmUser", new User());
			theModel.addAttribute("registrationError", "User name already exists.");

			logger.warning("User name already exists.");

			return "registration-form";
		}

		//
		// whew ... we passed all of the validation checks!
		// let's get down to business!!!
		//

		// encrypt the password
//		String encodedPassword = passwordEncoder.encode(theCrmUser.getPassword());

		// prepend the encoding algorithm id
//		encodedPassword = "{noop}" + encodedPassword;

		// give user default role of "employee"
//		List<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList("ROLE_EMPLOYEE");
//
//		// create user object (from Spring Security framework)
//		org.springframework.security.core.userdetails.User tempUser = new org.springframework.security.core.userdetails.User(
//				userName, encodedPassword, authorities);
//
//		// save user in the database
//		userDetailsManager.createUser(tempUser);
		
		
		Authenticate au = new Authenticate();
		au.setUsername(userName);
		au.setAuthority("ROLE_CUSTOMER");
		
		
		User user = new User();
		
		user.setEnabled(1);
		user.setPassword("{noop}" + theCrmUser.getPassword());
		user.setUsername(userName);
		userService.saveUser(user);
		authenticateService.saveAu(au);
		
		logger.info("Successfully created user: " + userName);

		theModel.addAttribute("email", userName);
//		return "registration-confirmation";
		return "redirect:/khachhang/showFormForAdd";
	}

	private boolean doesUserExist(String userName) {

		logger.info("Checking if user exists: " + userName);

		// check the database if the user already exists
		boolean exists = userDetailsManager.userExists(userName);

		logger.info("User: " + userName + ", exists: " + exists);

		return exists;
	}
}
