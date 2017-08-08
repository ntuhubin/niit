package com.niit.org.controller;

import java.util.List;

import org.niit.com.bean.Info;
import org.niit.com.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/Info")
public class InfoController {
	private DbService ds;
	
	@Autowired
	public void setDs(DbService ds) {
		this.ds = ds;
	}

	@RequestMapping()
	public String Login(ModelMap model){
		
		//List<Info> infoList = ds.getInfo(0);
		//model.addAttribute("infoList",infoList);
		return "login";
		/*if(name == "abc")
			return "showInfo";
		else
		{
			model.addAttribute("msg","用户名或者密码错误!");
			return "redirect:/index";
		}*/
		
	}
	
	@RequestMapping("/login")
	public String LOG(@RequestParam("lname") String name, ModelMap model){

		if(name.compareTo("abc") != 0){
			model.addAttribute("msg","用户名或者密码错误！");
			return "redirect:/Info";
		}
		List<Info> infoList = ds.getInfo(0);
		model.addAttribute("infoList",infoList);
			
		return "showInfo";
	
	

	}

	@RequestMapping("/infos")
	public String showInfos(ModelMap model){
		

		List<Info> infoList = ds.getInfo(0);
		model.addAttribute("infoList",infoList);
			
		return "showInfo";
	
	

	}
	

	@RequestMapping("/insert")
	public String insertInfo(){
		return "insertInfo";
	}
	
	@RequestMapping("/insertData")
	public String insertInfo(@RequestParam("name") String name,@RequestParam("intro") String intro,ModelMap model){
		//校验
		if("".equals(name) || null == name){
			model.addAttribute("msg","姓名不能为空!");
			return "insertInfo";
		}
		
		//数据保存
		Info info = new Info();
		info.setName(name);
		info.setIntro(intro);
		int result = ds.insert(info);
		
		return "redirect:/Info/infos";
	}
	
	@RequestMapping("/update")
	public String updateInfo(int id,ModelMap model){
		List<Info>  infoList = ds.getInfo(id);
		if(infoList != null && infoList.size() > 0){
			model.addAttribute("info",infoList.get(0));
		}
		
		return "updateInfo";
	}
	
	@RequestMapping("/updateData")
	public String updateInfo(Info info,ModelMap model){
		//校验
		if("".equals(info.getName()) || null == info.getName()){
			model.addAttribute("msg","姓名不能为空!");
			return "updateInfo";
		}
		
		//数据保存
		int result = ds.update(info);
		
		return "redirect:/Info/infos";
	}
	
	@RequestMapping("/delete")
	public String deleteInfo(int id,ModelMap model){
		int result = ds.delete(id);
		
		return "redirect:/Info/infos";
	}
	
	
}
