package com.cxb.controller.email;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cxb.service.EmailService;

@Controller
public class EmailController {
	@Autowired  
    private EmailService mailService; 
    
    private String to = "1275736266@qq.com";  

	@RequestMapping("/mail")
	public String file() {
		return "/mail";
	}

	/**
	 * 发送邮件
	 * 
	 * @param 邮件标题
	 * @return
	 */
	@RequestMapping("/send")
	@ResponseBody
	public String handleFileUpload(HttpServletRequest request, HttpServletResponse response) {
		String title = request.getParameter("title");
		System.out.println(title);  
		mailService.sendSimpleMail(to, "主题：" + title, "测试邮件内容");  
		return "发送成功";
	}
	
	/**
	 * 带附件的邮件
	 */
	@RequestMapping("/sendAttachmentsMail")
	@ResponseBody
    public void sendAttachmentsMail() {  
        mailService.sendAttachmentsMail(to, "主题：带附件的邮件", "亲，生日快乐，有附件，请查收！", "D:\\1.jpg");  
    }  
      
	/**
	 * 嵌入静态资源的邮件
	 */
	@RequestMapping("/sendInlineResourceMail")
	@ResponseBody
    public void sendInlineResourceMail() {  
		//? 这个id怎么来的
        String rscId = "rscId001";  
        mailService.sendInlineResourceMail(to,  
                "主题：嵌入静态资源的邮件",  
                "<html><body>这是有嵌入静态资源：<img src=\'cid:" + rscId + "\' ></body></html>",  
                "D:\\\\1.jpg",  
                rscId);  
    }  
}
