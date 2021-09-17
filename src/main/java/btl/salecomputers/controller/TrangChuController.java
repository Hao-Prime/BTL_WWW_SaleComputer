package btl.salecomputers.controller;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import btl.salecomputers.entity.MayTinh;
import btl.salecomputers.entity.ThuongHieu;
import btl.salecomputers.entity.DTO.MayTinhDTO;
import btl.salecomputers.service.MayTinhService;
import btl.salecomputers.service.ThuongHieuService;

@Controller
public class TrangChuController {

	@Autowired
	private MayTinhService mayTinhService;
	@Autowired
	private ThuongHieuService thuongHieuService;
	

	@GetMapping("/")
	public String trangChu(Model theModel, @RequestParam(required = false) String sort,Authentication authentication) {

		
		List<ThuongHieu> listTH=new ArrayList<ThuongHieu>();
		List<MayTinhDTO> theMayTinhs = new ArrayList<MayTinhDTO>();
		
		listTH=thuongHieuService.getThuongHieus();
		

		for (MayTinh mt : mayTinhService.getMayTinhs(sort)) {
			
			//xuly giá
			String x = String.valueOf(mt.getGia());
			if(x.length()>4) {
				x = x.substring(0, x.length() - 5) + "." + x.substring(x.length() - 5, x.length());
			}
			String base64Image = null;
			base64Image = Base64.getEncoder().encodeToString(mt.getHinhAnh());
			//xuly TH
			String strTH="";
			for (ThuongHieu th : listTH) {
				if(mt.getThuonghieu().getMaTH()==th.getMaTH()) {
					strTH=th.getTenTH();
				}
			}
			
			
			//add
			theMayTinhs.add(new MayTinhDTO(mt.getMaMT(), mt.getTenMT(), mt.getRamMT(), mt.getManHinhMT(),
					mt.getSoLuong(), x + "00đ", base64Image, mt.getMoTa(),strTH));
			
			//email
			String name;
			if (authentication != null)
				name =authentication.getName();
			else
				name = "";
			theModel.addAttribute("email", name);
		}
		
		

		theModel.addAttribute("maytinhs", theMayTinhs);
		theModel.addAttribute("thuonghieus", listTH);

		return "TrangChu";
	}
	
	
	@GetMapping("/search")
	public String searchMT(@RequestParam("theSearchName") String theSearchName, Model theModel,Authentication authentication) {
		
		
		
		
		List<ThuongHieu> listTH=new ArrayList<ThuongHieu>();
		List<MayTinhDTO> theMayTinhs = new ArrayList<MayTinhDTO>();
		
		listTH=thuongHieuService.getThuongHieus();
		

		for (MayTinh mt : mayTinhService.searchMayTinhByName(theSearchName)) {
			
			//xuly giá
			String x = String.valueOf(mt.getGia());
			if(x.length()>4) {
				x = x.substring(0, x.length() - 5) + "." + x.substring(x.length() - 5, x.length());
			}
			String base64Image = null;
			base64Image = Base64.getEncoder().encodeToString(mt.getHinhAnh());
			//xuly TH
			String strTH="";
			for (ThuongHieu th : listTH) {
				if(mt.getThuonghieu().getMaTH()==th.getMaTH()) {
					strTH=th.getTenTH();
				}
			}
			
			
			//add
			theMayTinhs.add(new MayTinhDTO(mt.getMaMT(), mt.getTenMT(), mt.getRamMT(), mt.getManHinhMT(),
					mt.getSoLuong(), x + "00đ", base64Image, mt.getMoTa(),strTH));
			
			//email
			String name;
			if (authentication != null)
				name =authentication.getName();
			else
				name = "";
			theModel.addAttribute("email", name);
		}
		
		

		theModel.addAttribute("maytinhs", theMayTinhs);
		theModel.addAttribute("thuonghieus", listTH);
		return "TrangChu";
	}
}
