package r_spring文件.springfile;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class Springfile {
	@RequestMapping(value="/byspringupload")
	public ModelAndView toSpringfile(@RequestParam(value = "myfile") MultipartFile file,
			HttpServletRequest request,HttpServletResponse response){
		//获得文件的位置
		
		String path = request.getSession().getServletContext().getRealPath("upload");  
		String filename = file.getOriginalFilename();getClass();
		System.out.println(path);
		File myFile = new File("D:/byspring.txt");
		try {
			System.out.println(path);
			file.transferTo(myFile);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ModelAndView("wenjianshangchuan.jsp");
	}

}
