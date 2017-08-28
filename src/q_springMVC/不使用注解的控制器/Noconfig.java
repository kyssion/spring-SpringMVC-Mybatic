package q_springMVC.不使用注解的控制器;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


//当不是用配置文件的时候我们将不需要使用接口直接使用一个注释
@Controller//这个注释讲这个bean配制成一个控制器-注解没有标记只是起到了一个标记的作用
//注意要让这个注解起到作用需要早xml文件中进行配置
@RequestMapping(value="/sdf")//这样下面的所有方法的起始地址就是/sdf
public class Noconfig {
	@RequestMapping(value="/mappingOne",method={RequestMethod.GET,RequestMethod.PUT})
	//注解中属性- 	 value：表示需要匹配的url的格式。
	 				//method：表示所需处理请求的http 协议(如get,post,put,delete等)，可选值为RequestMethod这个enum的值。
	 				//params:格式为”paramname=paramvalue” 或 “paramname!=paramvalue”。不带参数则表示paramvalue可以为任意值。
					//如params =  {"param1=1","param2!=2","param3"},表示对应的url必须包括param1,param2,param3三个参数，其中param1的值必须为1，param2的值不能为2，param3的值可以为任意值。
	 				//headers:用来限定对应的reqeust请求的headers中必须包括的内容，例如
					//headers={"Connection=keep-alive"}, 表示请求头中的connection的值必须为keep-alive。
	//		
	//定义的方法中可以讲需要的属性直接写进去,从而直接能得到,spring底层使用反射技术能动态的知道你需要什么属性
	//spring支持的属性java- HttpServletRequest HttpServletServletResponse HttpSession Locale inputstream reader outputStream writer Map 
 	//spring的属性WebRequest NativeWebRequest ModeMap model- 表单对象(气势model 或者 map 或者 ModeMap就是封装了request.setAttrbute方法)
	//注意这些参数都是在一个请求中有效也就是说只要获取了对台进行操作在一次请求转发过程中都能获得和进行操作
	public ModelAndView mappingOne(HttpServletRequest request,HttpServletResponse response ,ModelMap modelMap){
		System.out.println(request.getParameter("one"));
		modelMap.addAttribute("xixi", "123145");
		return new ModelAndView("myModeAndView");
		//处理方法可以返回的类型
		//Modelandview Medel map View 代表逻辑属兔名称的String void 
	}
	@RequestMapping(value="mappingTwo/{id}/{xixi}",method={RequestMethod.GET,RequestMethod.POST})
	public void mappingTwo(@PathVariable() int id,@PathVariable String xixi){
		//一种解析url的方法 -讲url地址地址中的方法进行解析处理  名称要相互匹配要相同
		//name(value) - 指定绑定的参数
		System.out.println(id+"  "+xixi);
	}
	@RequestMapping(value="mappingThree",method={RequestMethod.GET,RequestMethod.POST})
	public void mappingThree(@RequestParam(value="sadf") int id,@RequestParam String hehe){
		//讲url 地址中的响应字子自动和函数中的参数相匹配 注意名称要相互匹配要相同
		//name-指定参数中那个元素和者个进行绑定 value 是他的别名
		//defaulfvalue -  指定默认的参数
		System.out.println(id+"  "+hehe);
	}
	//spring 重定向
	public String mappingFour(RedirectAttributes redirectAttributes){
		redirectAttributes.addFlashAttribute("xx", "asdfasdf");//使用这个方法可以实现内部的重定向属性传递方法
		//在spring中返回字符串使用rediret开头的时候表使用了重定向技术
		return "redirect:/xxxx/";
	}
	
	//model and view 
	public void springModelandView(){
		//modelandview 其实是将model和view 封装在一个如果想使用需要使用get方法生成
		ModelAndView modelAndView = new ModelAndView();
		//modelAndView= new ModelAndView(viewName, model)
		modelAndView.addAllObjects(new HashMap<String,String>());
		modelAndView.addObject("xxx", "xxx");
		View view=modelAndView.getView();
		ModelMap map =modelAndView.getModelMap();
		modelAndView.setView(view);
		modelAndView.setViewName("xxx");
		//modelMap--其实是map的实现类而已
		ModelMap map2= new ModelMap();
		map.addAllAttributes(new HashMap<String,String>());
		map.addAttribute("xx", "heh");
		//view---没什么用就当是字符串就好了
		View view2 = new View() {
			public void render(Map<String, ?> arg0, HttpServletRequest arg1, HttpServletResponse arg2) throws Exception {}
			public String getContentType() {return null;}
		};
	}
}
