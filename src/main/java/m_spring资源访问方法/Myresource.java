package m_spring资源访问方法;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.UrlResource;


public class Myresource {
	//spring 使用资源的模版方法 Resource接口
		public interface InputStreamSource{
	        //每次调用都将返回一个新的资源对应的java.io.InputStream字节流，调用者在使用完毕后必须关闭该资源
	        InputStream getInputStream() throws IOException;
	    }
	    public interface Resource extends InputStreamSource{
	        //返回当前Resouce代表的底层资源是否存在，true表示存在
	        boolean exists();
	        //返回当前Resouce代表的底层资源是否可读，true表示可读
	        boolean isReadable();
	        //返回当前Resouce代表的底层资源是否已经打开，如果返回true，则只能被读取一次然后关闭以避免内存泄露；常见的Resource实现一般返回false；
	        boolean isOpen();
	        //如果当前Resouce代表的底层资源能由java.util.URL代表，则返回该URL，否则抛出IOException
	        URL getURL() throws IOException;
	        //如果当前Resouce代表的底层资源能由java.util.URI代表，则返回该URI，否则抛出IOException
	        URI getURI() throws IOException;
	        //如果当前Resouce代表的底层资源能由java.io.File代表，则返回该File，否则抛出IOException
	        File getFile() throws IOException;
	        //返回当前Resouce代表的底层文件资源的长度，一般的值代表的文件资源的长度
	        long contentLength() throws IOException;
	        //返回当前Resouce代表的底层文件资源的最后修改时间
	        long lastModified() throws IOException;
	        //用于创建相对于当前Resource代表的底层资源的资源，比如当前Resource代表文件资源“D:/test/”则createRelative("test.txt")将返回代表文件资源“D:/test/test.txt”Resource资源。
	        Resource createRelative(String relativePath) throws IOException;
	        //返回当前Resource代表的底层文件资源的文件路径，比如File资源：file://d:/test.txt 将返回d:/test.txt，而URL资源http://www.javass.cn将返回“”，因为只返回文件路径
	        String getFilename();
	        //返回当前Resource代表的底层资源的描述符，通常就是资源的全路径（实际文件名或实际URL地址）
	        String getDescription();
	    }
	    //定义一个基础的io操作
	    private void dumpStream(org.springframework.core.io.Resource resource){
	        InputStream is = null;
	      try {
	            //1.获取资源文件
	            is = resource.getInputStream();
	            //2.读取资源文件
	            byte[] descBytes = new byte[is.available()];
	            is.read(descBytes);
	            System.out.println(new String(descBytes));
	        } catch (IOException e) {
	            e.printStackTrace();
	        } finally{
	            try {
	                //3.关闭资源
	                is.close();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	    //使用ByteArrayResource代表 btye[]数组资源，对于getInputStream操作将返回一个ByteArrayInputStream 
	    class ResourceTest {
	        public void testByteArrayResource(){
	            //1.定义资源
	        	org.springframework.core.io.Resource resource = new ByteArrayResource("hello".getBytes());
	            //2.验证资源
	            if(resource.exists()){
	                //3.访问资源---引申 内部类能够访问外部类的私有方法
	                dumpStream(resource);
	            }

	        }
	        //InputStreamResource代表Java.io.InputStream字节流，对于个体InputStream操作将直接返回该字节流，因此只能读取一次字节流，即isOpen永远返回true
	        public void testInputStreamResource(){
	            ByteArrayInputStream bis = new ByteArrayInputStream("hello2".getBytes());
	            org.springframework.core.io.Resource resource = new InputStreamResource(bis);
	            if (resource.exists()) {
	                dumpStream(resource);
	            }
	        }
	        //FileSystemResource代表java.io.File资源，对于getInputStream 操作将返回底层文件的字节流，isOpen将永远返回false，从而表示可多次读取底层文件的字节流
	        public void testFileSystemResource(){
	            File file = new File("d:/test.txt");
	            org.springframework.core.io.Resource resource = new FileSystemResource(file);
	            if (resource.exists()) {
	                dumpStream(resource);
	            }
	        }
	        //ClassPathResource代表classpath路径的资源，将使用ClassLoader进行加载资源。classpath资源存在于类路径中的文件系统中或jar包里，且isOpen永远返回false，表示可多次读取资源。 
	        //ClassPathResource加载资源替代了Class类和ClassLoader类的getResource(String name)和getResouceAsStream(String name) 两个加载类路径资源方法，提供一致的访问方式
	        public void testClasspathResourceByDefaultClassLoader() throws IOException{
	        	//构造方法存在三个
	        	//1. 直接使用项目的根目录进行查找
	        	org.springframework.core.io.Resource resource = 
	                new ClassPathResource("com/lizhenhua/test3/db.properties");
	            //2. 只用指定的classload作为加载资源的类型进行加载 根目录进行查找
	        	 ClassLoader classLoader = MyServlet13.class.getClassLoader();
	        	 org.springframework.core.io.Resource resource2 = 
	                 new ClassPathResource("META-INF/INDEX.LIST",classLoader);
	        	 //3. 
	        	 org.springframework.core.io.Resource resource3 = 
	             new ClassPathResource("com/lizhenhua/test3/db.properties",this.getClass());
	        	if (resource.exists()) {
	                dumpStream(resource);
	            }
	            System.out.println("path:" + resource.getFile().getAbsolutePath());
	        }
	        //UrlResource代表URL资源，用于简化URL资源访问。isOpen永远返回false，可以多次读取资源
	        //支持如下资源访问
	        //http:通过标准的http协议访问web资源，如new UrlResource("http://地址");
	        //ftp:通过ftp协议访问资源，如new UrlResource("ftp://地址");
	        //file:通过file协议访问本地文件系统资源 如：new UrlResource(file:d:/test.txt)
	        public void testUrlResource() throws IOException{   
	        	org.springframework.core.io.Resource  resource = 
	                new UrlResource("http://www.hao123.com");
	            if (resource.exists()) {dumpStream(resource);}
	            System.out.println("path:" + resource.getURL().getPath());
	        }
	        	//前面介绍的资源路径都是非常简单的一个路径匹配一个资源，Spring还提供了一种更强大的Ant模式通配符匹配，从一个路径匹配一批资源
	        	//?：匹配一个字符
	        	//*:匹配零个或多个字符串
	        	//**:匹配路径中的零个或多个目录
	        	//Spring在加载类路径资源时除了提供前缀"classpath:" 的来支持加载一个Resource，
	        	//还提供一个前缀"classpath*:"来支持加载所有匹配的类路径Resource。
	        //所有的applicationcontext 都是现实了resourceLoad接口可以使用和urlresource相同的接口的方法进行相关的资源加入
	    }   
}
