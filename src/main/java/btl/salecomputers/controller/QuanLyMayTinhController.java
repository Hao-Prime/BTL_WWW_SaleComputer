package btl.salecomputers.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.servlet.annotation.MultipartConfig;
import javax.sql.rowset.serial.SerialException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import btl.salecomputers.entity.MayTinh;
import btl.salecomputers.entity.ThuongHieu;
import btl.salecomputers.entity.DTO.MayTinhDTO;
import btl.salecomputers.service.MayTinhService;
import btl.salecomputers.service.ThuongHieuService;

@Controller
@RequestMapping("/maytinh")
@MultipartConfig(maxFileSize = 16177215)
public class QuanLyMayTinhController {

	@Autowired
	private MayTinhService mayTinhService;
	@Autowired
	private ThuongHieuService thuongHieuService;




	@PostMapping("/saveMayTinh")
	public String savePerson(@ModelAttribute("maytinh") MayTinh theMayTinh,
			@RequestParam("photo") MultipartFile file) throws IOException, SerialException, SQLException {

		byte[] ha = file.getBytes();
		theMayTinh.setHinhAnh(ha);
		theMayTinh.setChiTietHoaDons(null);
		mayTinhService.saveMayTinh(theMayTinh);
		return "redirect:/";	
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
	
		List<ThuongHieu> listTH=new ArrayList<ThuongHieu>();
		listTH=thuongHieuService.getThuongHieus();
		MayTinh theMayTinh = new MayTinh();
		
		theModel.addAttribute("maytinh", theMayTinh);
		theModel.addAttribute("thuonghieus", listTH);
		return "maytinh-form";
	}


	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("maMT") int maMT, Model theModel) {
		
		List<ThuongHieu> listTH=new ArrayList<ThuongHieu>();
		listTH=thuongHieuService.getThuongHieus();
		theModel.addAttribute("thuonghieus", listTH);
		

		
		MayTinh theMayTinh = mayTinhService.getMayTinh(maMT);
		theModel.addAttribute("maytinh", theMayTinh);
		return "maytinh-form";
		
	}
	@GetMapping("/delete")
	public String deletePerson(@RequestParam("maMT") int maMT) {

		// delete the customer
		mayTinhService.deleteMayTinh(maMT);
		return "redirect:/";
	}
	
	@GetMapping("/showChiTietMayTinh")
	public String showChiTietMayTinh(@RequestParam("maMT") int maMT, Model theModel) {
		MayTinhDTO mtDTO = new MayTinhDTO();
		MayTinh mt = mayTinhService.getMayTinh(maMT);
		String x = String.valueOf(mt.getGia());
		String base64Image = null;
		base64Image = Base64.getEncoder().encodeToString(mt.getHinhAnh());
		
		String th = mt.getThuonghieu().getTenTH();
		
		mtDTO = new MayTinhDTO(mt.getMaMT(), mt.getTenMT(), mt.getRamMT(), mt.getManHinhMT(),
				mt.getSoLuong(), x, base64Image, mt.getMoTa(),th);
		
		
		theModel.addAttribute("maytinh", mtDTO);
		return "form-ChiTietMayTinh";
	}
	
	@GetMapping("/showGioHang")
	public String showGioHang(@RequestParam("maMT") int maMT, Model theModel) {
		MayTinhDTO mtDTO = new MayTinhDTO();
		MayTinh mt = mayTinhService.getMayTinh(maMT);
		String x = String.valueOf(mt.getGia());
		String base64Image = null;
		base64Image = Base64.getEncoder().encodeToString(mt.getHinhAnh());
		
		String th = mt.getThuonghieu().getTenTH();
		
		
		mtDTO = new MayTinhDTO(mt.getMaMT(), mt.getTenMT(), mt.getRamMT(), mt.getManHinhMT(),
				mt.getSoLuong(), x, base64Image, mt.getMoTa(),th);
		
		
		theModel.addAttribute("maytinh", mtDTO);
		return "form-GioHang";
	}

}
