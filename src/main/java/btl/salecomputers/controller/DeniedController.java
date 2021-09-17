package btl.salecomputers.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DeniedController {

	@GetMapping("/access-denied")
	public String showMyLoginPage() {

		return "access-denied";
	}
}