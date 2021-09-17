package btl.salecomputers.controller;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import btl.salecomputers.entity.ChiTietHoaDon;
import btl.salecomputers.entity.HoaDon;
import btl.salecomputers.entity.KhachHang;
import btl.salecomputers.entity.MayTinh;
import btl.salecomputers.entity.ThuongHieu;
import btl.salecomputers.entity.DTO.MayTinhDTO;
import btl.salecomputers.service.ChiTietHoaDonService;
import btl.salecomputers.service.HoaDonService;
import btl.salecomputers.service.KhachHangService;
import btl.salecomputers.service.MayTinhService;

@Controller
@RequestMapping("/giohang")
public class GioHangController {
	@Autowired
	private MayTinhService mayTinhService;
	@Autowired
	private KhachHangService khachHangService;
	@Autowired
	private HoaDonService hoaDonService;
	@Autowired
	private ChiTietHoaDonService chiTietHoaDonService;

	@GetMapping("/showGioHang")
	public String showGioHang(@RequestParam("maMT") int maMT, Model theModel, Authentication authentication) {
		MayTinhDTO mtDTO = new MayTinhDTO();
		MayTinh mt = mayTinhService.getMayTinh(maMT);
		String x = String.valueOf(mt.getGia());
		String base64Image = null;
		base64Image = Base64.getEncoder().encodeToString(mt.getHinhAnh());
		
		String th = mt.getThuonghieu().getTenTH();

		mtDTO = new MayTinhDTO(mt.getMaMT(), mt.getTenMT(), mt.getRamMT(), mt.getManHinhMT(), mt.getSoLuong(), x,
				base64Image, mt.getMoTa(),th);
		
		
		// ten usser
		String name;
		if (authentication != null)
			name = authentication.getName();
		else
			name = "";

		int maKH = khachHangService.getKhachHangByEmail(name).getMaKH();
		System.out.println(maKH + "");

		List<HoaDon> hoaDons = new ArrayList<HoaDon>();
		hoaDons = hoaDonService.getHoaDonByMaKH(maKH);

		HoaDon hd = null;
		for (HoaDon hoaDon : hoaDons) {
			if (hoaDon.getNgayDat() == null)
				hd = hoaDon;
		}

		if (hd == null) {
			hd = new HoaDon();
			hd.setKhachHang(khachHangService.getKhachHangById(maKH));
			hoaDonService.saveHoaDon(hd);
			ChiTietHoaDon chiTietHoaDon1 = null;
			chiTietHoaDon1 = new ChiTietHoaDon();
			chiTietHoaDon1.setHoaDon(hd);
			chiTietHoaDon1.setMayTinh(mt);

			long millis = System.currentTimeMillis();
			java.sql.Date date = new java.sql.Date(millis);
			chiTietHoaDon1.setNgayThem(date);

			chiTietHoaDon1.setSoLuong(1);

			chiTietHoaDonService.saveChiTietHoaDon(chiTietHoaDon1);

		} else {
			ChiTietHoaDon chiTietHoaDon = null;
			int sol = 0;
			List<ChiTietHoaDon> chiTietHoaDons = hd.getChiTietHoaDons();
			for (ChiTietHoaDon chiTietHoaDon2 : chiTietHoaDons) {
				if (chiTietHoaDon2.getMayTinh().getMaMT() == maMT) {
					chiTietHoaDon = chiTietHoaDon2;
					sol = chiTietHoaDon2.getSoLuong();
				}
			}
			if (chiTietHoaDon != null) {
				chiTietHoaDon.setSoLuong(sol + 1);
			} else {
				chiTietHoaDon = new ChiTietHoaDon();
				chiTietHoaDon.setHoaDon(hd);
				chiTietHoaDon.setMayTinh(mt);

				long millis = System.currentTimeMillis();
				java.sql.Date date = new java.sql.Date(millis);
				chiTietHoaDon.setNgayThem(date);

				chiTietHoaDon.setSoLuong(1);
			}

			chiTietHoaDonService.saveChiTietHoaDon(chiTietHoaDon);
		}

		theModel.addAttribute("hoaDon", hd);


		return "redirect:/giohang/xemGioHang";
	}

	@GetMapping("/delete")
	public String deleteChiTietHoaDon(@RequestParam("maCTHD") int maCTHD) {
		chiTietHoaDonService.deleteChiTietHoaDon(maCTHD);
		return "redirect:/giohang/xemGioHang";
	}

	@GetMapping("/cong")
	public String congSLChiTietHoaDon(@RequestParam("maCTHD") int maCTHD) {
		ChiTietHoaDon chiTietHoaDon = chiTietHoaDonService.getCTHDById(maCTHD);
		int sl = chiTietHoaDon.getSoLuong() + 1;
		chiTietHoaDon.setSoLuong(sl);
		chiTietHoaDonService.saveChiTietHoaDon(chiTietHoaDon);
		return "redirect:/giohang/xemGioHang";
	}

	@GetMapping("/tru")
	public String truSLChiTietHoaDon(@RequestParam("maCTHD") int maCTHD) {
		ChiTietHoaDon chiTietHoaDon = chiTietHoaDonService.getCTHDById(maCTHD);
		int sl = chiTietHoaDon.getSoLuong();
		if (sl == 1) {
			chiTietHoaDonService.deleteChiTietHoaDon(maCTHD);
		} else {
			sl--;
			chiTietHoaDon.setSoLuong(sl);
			chiTietHoaDonService.saveChiTietHoaDon(chiTietHoaDon);
		}

		return "redirect:/giohang/xemGioHang";
	}

	@GetMapping("/xemGioHang")
	public String showGioHang1(Model theModel, Authentication authentication) {
//		ten usser
		String name;
		if (authentication != null)
			name = authentication.getName();
		else
			name = "";

		int maKH = khachHangService.getKhachHangByEmail(name).getMaKH();

		List<HoaDon> hoaDons = new ArrayList<HoaDon>();
		hoaDons = hoaDonService.getHoaDonByMaKH(maKH);
		HoaDon hd = null;
		for (HoaDon hoaDon : hoaDons) {
			if (hoaDon.getNgayDat() == null)
				hd = hoaDon;
		}
		if (hd == null) {
			return "/";

		} else {
			theModel.addAttribute("hoaDon", hd);
			return "form-GioHang";
		}


	}

	@PostMapping("/saveDiaChi")
	public String saveDiaChi(@ModelAttribute("hoaDon") HoaDon hoaDon, Authentication authentication) {
//		ten usser
		String name;
		if (authentication != null)
			name = authentication.getName();
		else
			name = "";

		int maKH = khachHangService.getKhachHangByEmail(name).getMaKH();

		List<ChiTietHoaDon> listChiTietHoaDons = null;
		if (hoaDon.getMaHD() != 0) {
			listChiTietHoaDons = hoaDonService.getChiTietHoaDon(hoaDon.getMaHD());
		}
		hoaDon.setChiTietHoaDons(listChiTietHoaDons);
		hoaDon.setKhachHang(khachHangService.getKhachHangByEmail(name));
		hoaDonService.saveHoaDon(hoaDon);
//		theModel.addAttribute("hoaDon", hoaDon);
		System.out.println("Cap nhap xong");
		return "redirect:/giohang/xemGioHang";
	}

	@GetMapping("/saveHoaDon")
	public String saveHoaDon(@RequestParam("maHD") int maHD, Authentication authentication) {
//		ten usser
		String name;
		if (authentication != null)
			name = authentication.getName();
		else
			name = "";

		int maKH = khachHangService.getKhachHangByEmail(name).getMaKH();

		HoaDon hoaDon = hoaDonService.getHoaDonById(maHD);
		List<ChiTietHoaDon> listChiTietHoaDons = null;
		if (hoaDon.getMaHD() != 0) {
			listChiTietHoaDons = hoaDonService.getChiTietHoaDon(hoaDon.getMaHD());
		}
		LocalDate ngayD, ngayG;
		ngayD = LocalDate.now();
		ngayG = ngayD.plusDays(7);
		hoaDon.setChiTietHoaDons(listChiTietHoaDons);
		hoaDon.setKhachHang(khachHangService.getKhachHangByEmail(name));
		hoaDon.setNgayDat(Date.valueOf(ngayD));
		hoaDon.setNgayGiao(Date.valueOf(ngayG));
		hoaDon.setNgayNhan(Date.valueOf(ngayG));
		hoaDonService.saveHoaDon(hoaDon);
//		theModel.addAttribute("hoaDon", hoaDon);
		return "dathangthanhcong";
	}
}
