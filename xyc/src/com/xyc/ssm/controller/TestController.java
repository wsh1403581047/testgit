package com.xyc.ssm.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;



@Controller
@RequestMapping(value="hello")
public class TestController {
	@RequestMapping(value = "word")
	@ResponseBody
	public Boolean word(MultipartFile file,HttpServletRequest request){
		String path = request.getSession().getServletContext().getRealPath("pic");
		UUID id = UUID.randomUUID();
		String name = file.getOriginalFilename();
		String type = name.substring(name.lastIndexOf("."));
		String finalName = id+type;
		String finalPath = path+"/"+finalName;
		try {
			file.transferTo(new File(finalPath));
			return true;
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	@RequestMapping(value="toPage")
	public String toPage() {
		return "1";
	}
	
	@RequestMapping(value = "toPagec")
	public String toPage2() {
		return "2";
	}
	
	@RequestMapping(value = "json")
	@ResponseBody
	public String json() {
		String js = "[\r\n" + 
				"\r\n" + 
				"{ \"firstName\": \"Brett\", \"lastName\":\"McLaughlin\", \"email\": \"aaaa\" },\r\n" + 
				"\r\n" + 
				"{ \"firstName\": \"Jason\", \"lastName\":\"Hunter\", \"email\": \"bbbb\"},\r\n" + 
				"\r\n" + 
				"{ \"firstName\": \"Elliotte\", \"lastName\":\"Harold\", \"email\": \"cccc\" }\r\n" + 
				"\r\n" + 
				"]";
		return js;
	}
	
	
}
