package r_spring文件.chuantongfangfa;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.fileUpload;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class Mycontroller_for_chuantong {
	@RequestMapping(value="/chuantongfangfa")
	public ModelAndView chuangtong(HttpServletRequest request,HttpServletResponse response){
		try {
			InputStream inputStream = request.getInputStream();
			File file = new File("d:/chuantongfangfa.txt");
			FileOutputStream fileOutputStream = new FileOutputStream(file);
			byte[] b= new byte[1024];  
			int n=0;
			while ((n=inputStream.read(b))!=-1){
				String string= new String(b);
				System.out.println(string);
				fileOutputStream.write(b, 0, n);
			}
			inputStream.close();
			fileOutputStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ModelAndView("wenjianshangchuan.jsp");
	}

}
