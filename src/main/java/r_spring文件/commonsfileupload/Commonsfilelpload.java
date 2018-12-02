package r_spring文件.commonsfileupload;

import java.io.File;
import java.util.Iterator;
import java.util.List;


import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class Commonsfilelpload {
	@RequestMapping(value="/commonsfileupload")
	public ModelAndView toCommonsfileupload(HttpServletRequest request){
		//获得文件根目录
		String uploaddir = request.getServletContext().getRealPath("/docs");
		System.out.println(uploaddir);
		//判断是否有Multupart请求
		boolean isMultpart = ServletFileUpload.isMultipartContent(request);
		if (isMultpart){
			System.out.println(isMultpart);
			//获得fileItemfactory工厂方法
			FileItemFactory fileItemFactory= new DiskFileItemFactory();
			//为servletupload文件上传加上fileitem接口
			ServletFileUpload servletFileUpload = new ServletFileUpload(fileItemFactory);
			 try {
				 //获得所有表单元素的集合
				List<FileItem> fileItems = servletFileUpload.parseRequest(request);
				System.out.println(fileItems.size());
				Iterator<FileItem> iterator = fileItems.iterator();
				//便利表单域找到一个文件输入的表单域
				while (iterator.hasNext()) {
                    FileItem item = iterator.next();
                    if (item.isFormField()){
                    	System.out.println("is commons form"+item.getName());
                    }
                    else{
                    	File file = new File("d:/commons.txt");
                    	try {
                    		//写入文件之中就行
							item.write(file);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
                    }
				}
			} catch (FileUploadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else{
			System.out.println(request.getParameter("mytext"));
			System.out.println(isMultpart);
		}
		return new ModelAndView("wenjianshangchuan.jsp");
	}
}
