package btl.salecomputers.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import btl.salecomputers.entity.Authenticate;
import btl.salecomputers.entity.HoaDon;
import btl.salecomputers.entity.KhachHang;
import btl.salecomputers.entity.User;
import btl.salecomputers.service.KhachHangService;
import btl.salecomputers.service.UserService;

@Controller
@RequestMapping("/khachhang")
public class KhachHangController {

	@Autowired
	private KhachHangService khachHangService;
	@Autowired
	private UserService userService;

	@GetMapping("/list")
	public String getKhachHang(Model theModel, @RequestParam(required = false) String sort) {
		List<KhachHang> listKhachHangs = null;
		if (sort != null) {
			int theSortField = Integer.parseInt(sort);
			listKhachHangs = khachHangService.getKhachHangs();
		} else {
			listKhachHangs = khachHangService.getKhachHangs();
		}
		theModel.addAttribute("khachhangs", listKhachHangs);
		return "list-khachhang";
	}

	@PostMapping("/saveKhachHang")
	public String saveKhachHang(@ModelAttribute("khachhang") KhachHang khachHang) {
		List<HoaDon> hoaDons = null;
		if (khachHang.getMaKH() != 0) {
			hoaDons = khachHangService.getHoaDons(khachHang.getMaKH());
		}
		khachHang.setHoaDons(hoaDons);
		khachHangService.saveKhachHang(khachHang);

//		User user = new User();
//		user.setUsername(khachHang.getEmail());
//		user.setPassword("{noop}" + 123);
//		user.setEnabled(1);
//		
//		List<Authenticate> listAu = new ArrayList<>();
//		Authenticate au = new Authenticate();
//		au.setUsername(khachHang.getEmail());
//		au.setAuthority("ROLE_CUSTOMER");
//		listAu.add(au);
//		user.setAuthenticates(listAu);
//		
//		
//		userService.saveUser(user);

//		return "redirect:/showMyLoginPage";
		return "redirect:/khachhang/list";
//		return "redirect:/register/showRegistrationForm";
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(@ModelAttribute("email")String email, Model model) {
		KhachHang kh = new KhachHang();
		kh.setEmail(email);
		model.addAttribute("khachhang", kh);
		
		return "form-khachhang";
	}

	@GetMapping("/delete")
	public String deleteKhachHang(@RequestParam("maKH") int maKH) {
		khachHangService.deleteKhachHang(maKH);
		return "redirect:/khachhang/list";
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("maKH") int maKH, Model theModel) {
		KhachHang kh = khachHangService.getKhachHangById(maKH);

		theModel.addAttribute("khachhang", kh);
		return "form-khachhang";
	}

	@GetMapping("/search")
	public String searchKhachHang(@RequestParam("strFind") String strFind, Model theModel) {
		List<KhachHang> khachHangs = khachHangService.searchKhachHang(strFind);

		theModel.addAttribute("khachhangs", khachHangs);
		return "list-khachhang";
	}
}
