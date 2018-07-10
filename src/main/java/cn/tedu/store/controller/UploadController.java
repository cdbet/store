package cn.tedu.store.controller;

import java.io.File;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/upload")
public class UploadController {
	//��ʾ�ϴ���ҳ��
	@RequestMapping("/showUpload.do")
	public String showUpload() {
		return "upload";
	}
	
	//ʵ���ϴ�����
	@RequestMapping("/doUpload")
	public String doUpload(MultipartFile file) throws Exception{
		//1.ʵ���ϴ�����
		//teansferToʵ���ϴ�����
		//getOriginalFilename()��ȡ�ϴ��ļ�
		file.transferTo(new File("d:/",file.getOriginalFilename()));
		//2.�ض���index.jsp
		return "redirect:../main/showIndex.do";
		
	}
}
