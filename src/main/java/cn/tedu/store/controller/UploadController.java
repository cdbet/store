package cn.tedu.store.controller;

import java.io.File;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/upload")
public class UploadController {
	//显示上传的页面
	@RequestMapping("/showUpload.do")
	public String showUpload() {
		return "upload";
	}
	
	//实现上传功能
	@RequestMapping("/doUpload")
	public String doUpload(MultipartFile file) throws Exception{
		//1.实现上传功能
		//teansferTo实现上传功能
		//getOriginalFilename()获取上传文件
		file.transferTo(new File("d:/",file.getOriginalFilename()));
		//2.重定向到index.jsp
		return "redirect:../main/showIndex.do";
		
	}
}
