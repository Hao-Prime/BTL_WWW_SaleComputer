package btl.salecomputers.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import btl.salecomputers.entity.HoaDon;
import btl.salecomputers.entity.KhachHang;
import btl.salecomputers.service.KhachHangService;
import btl.salecomputers.service.HoaDonService;

@Controller
@RequestMapping("/hoadon")
public class HoaDonController {

	@Autowired
	private KhachHangService khachHangService;
	@Autowired
	private HoaDonService HoaDonService;

	@GetMapping("/list")
	public String listHoaDon(@RequestParam("maKH") int maKH, Model theModel) {
		KhachHang kh = khachHangService.getKhachHangById(maKH);

		theModel.addAttribute("khachhang", kh);

		return "list-hoadon";
	}

	@GetMapping("/showFormThanhToan")
	public String lapHoaDon(@RequestParam("maHD") int maHD, Model theModel) {
		HoaDon hd = HoaDonService.getHoaDonById(maHD);

		theModel.addAttribute("hoadon", hd);

		return "form-ThanhToan";
	}
}
