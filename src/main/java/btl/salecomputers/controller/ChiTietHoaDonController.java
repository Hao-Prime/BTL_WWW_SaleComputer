package btl.salecomputers.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import btl.salecomputers.entity.ChiTietHoaDon;
import btl.salecomputers.entity.HoaDon;
import btl.salecomputers.service.HoaDonService;

@Controller
@RequestMapping("/chitiethoadon")
public class ChiTietHoaDonController {
	@Autowired
	private HoaDonService hoaDonService;
	
	@GetMapping("/list")
	public String listChiTietHoaDon(@RequestParam("maHD") int maHD, Model theModel) {
		HoaDon hd = hoaDonService.getHoaDonById(maHD);
		
//		List<ChiTietHoaDon> chiTietHoaDons = hd.getChiTietHoaDons();
//		theModel.addAttribute("listCTHD",chiTietHoaDons);
		theModel.addAttribute("hoadon",hd);
		return "list-chitiethoadon";
		
	}
}
