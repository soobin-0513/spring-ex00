package org.zerock.controller.upload;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/upload")
@Log4j
public class Ex01UploadController {
	
	/*
	 * https://docs.aws.amazon.com/sdk-for-java/latest/developer-guide/home.html
	 */
	
	
	@RequestMapping("/sub01")
	public void method1(String fname, @RequestParam("upfile") MultipartFile ufile) {
		log.info(fname);
		log.info(ufile.getOriginalFilename());
		
		String name = "/Users/imsoobin/Documents/myworkspace/tempFile/" + ufile.getOriginalFilename();
		
		try (
			InputStream is = ufile.getInputStream();
			BufferedInputStream bis = new BufferedInputStream(is);
			
			FileOutputStream fos = new FileOutputStream(name);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
		) {
			int len = 1024;
			byte[] b = new byte[len];
			
			int cnt = 0;
			while ((cnt = bis.read(b, 0, len)) != -1) {
				bos.write(b, 0, cnt);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@PostMapping("/sub02")
	public void method02(MultipartFile file) {
		log.info(file.getOriginalFilename());
		String localFilePath = "/Users/imsoobin/Documents/myworkspace/tempFile/" + file.getOriginalFilename();
		
				//파일경로를 파일객체로  만들어줌 !
		File localFile = new File(localFilePath);
		
		try {
			   // 그 경로에 파일을 씀 
			file.transferTo(localFile);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
}