package p_spring事务;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.TransactionStatus;


/**
 * Servlet implementation class Myservlet16
 */
@WebServlet("/Myservlet16")
public class Myservlet16 extends HttpServlet {
	/*
	 * spring 事务使用模型 -见图片
	 * ----这里的事务实现全部使用面向接口编程使用jdk代理模式
	 * */
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//startTrasfor("useProxy");
		startTrasfor("hasconfig");
		//startTrasfor("noconfig");
	}
	public void startTrasfor(String string){
		ApplicationContext applicationContext =
				new ClassPathXmlApplicationContext("p_spring事务/"+string+"/bean.xml");
		if (string.equals("useProxy")==true){
			Operating_interface operating_interface=applicationContext.getBean("TransferProxy", Operating_interface.class);
			operating_interface.transfer("Tom", "Marry", 100);
		}else {
			Operating_interface operating_interface=applicationContext.getBean("mycustomerTransfer", Operating_interface.class);
			operating_interface.transfer("Tom", "Marry", 100);
		}
	}
	/*
	 * Spring并不直接管理事务，而是提供了多种事务管理器，
	 * 他们将事务管理的职责委托给Hibernate或者JTA等持久化机制所提供的相关平台框架的事务来实现。 
	 * Spring事务管理器的接口是org.springframework.transaction.PlatformTransactionManager，
	 * 通过这个接口，Spring为各个平台如JDBC、Hibernate等都提供了对应的事务管理器，但是具体的实现就是各个平台自己的事情了
	 */
	//定义一个事务属性的详情
	interface TransactionDefinition {
		int getPropagationBehavior(); 	// 返回事务的传播行为
		 									//事务的传播行为--spring中有七种
//PROPAGATION_REQUIRED		表示当前方法必须运行在事务中。如果当前事务存在，方法将会在该事务中运行。否则，会启动一个新的事务
//PROPAGATION_SUPPORTS		表示当前方法不需要事务上下文，但是如果存在当前事务的话，那么该方法会在这个事务中运行
//PROPAGATION_MANDATORY		表示调用该方法的线程必须在事务中运行，如果当前事务不存在，则会抛出一个异常
//PROPAGATION_REQUIRED_NEW	表示当前方法必须运行在它自己的事务中。一个新的事务将被启动。如果存在当前事务，在该方法执行期间，当前事务会被挂起。如果使用JTATransactionManager的话，则需要访问TransactionManager
//PROPAGATION_NOT_SUPPORTED	表示该方法不应该运行在事务中。如果存在当前事务，在该方法运行期间，当前事务将被挂起。如果使用JTATransactionManager的话，则需要访问TransactionManager
//PROPAGATION_NEVER			表示当前方法不应该运行在事务上下文中。如果当前正有一个事务在运行，则会抛出异常
//PROPAGATION_NESTED		表示如果当前已经存在一个事务，那么该方法将会在嵌套事务中运行。嵌套的事务可以独立于当前事务进行单独地提交或回滚。如果当前事务不存在，那么其行为与PROPAGATION_REQUIRED一样。注意各厂商对这种传播行为的支持是有所差异的。可以参考资源管理器的文档来确认它们是否支持嵌套事务
		int getIsolationLevel(); 		// 返回事务的隔离级别，事务管理器根据它来控制另外一个事务可以看到本事务内的哪些数据
		 				//隔离级别属性分类
//ISOLATION_DEFAULT				使用后端数据库默认的隔离级别
//ISOLATION_READ_UNCOMMITTED	最低的隔离级别，允许读取尚未提交的数据变更，可能会导致脏读、幻读或不可重复读
//ISOLATION_READ_COMMITTED		允许读取并发事务已经提交的数据，可以阻止脏读，但是幻读或不可重复读仍有可能发生
//ISOLATION_REPEATABLE_READ		对同一字段的多次读取结果都是一致的，除非数据是被本身事务自己所修改，可以阻止脏读和不可重复读，但幻读仍有可能发生
//ISOLATION_SERIALIZABLE		最高的隔离级别，完全服从ACID的隔离级别，确保阻止脏读、不可重复读以及幻读，也是最慢的事务隔离级别，因为它通常是通过完全锁定事务相关的数据库表来实现的
		int getTimeout();  			// 返回事务必须在多少秒内完成
		boolean isReadOnly(); 			// 事务是否只读，事务管理器能够根据这个返回值进行优化，确保事务是只读的
	} 
	//事务管理器的接口
	interface PlatformTransactionManager{  
	   // 由TransactionDefinition(事务属性配置器)得到TransactionStatus对象
	   TransactionStatus getTransaction(TransactionDefinition definition) throws TransactionException; 
	   // 提交
	   Void commit(TransactionStatus status) throws TransactionException;  
	   // 回滚
	   Void rollback(TransactionStatus status) throws TransactionException;  
	} 
	 //事务状态接口
	public interface TransactionStatus{
		boolean isNewTransaction(); 	// 是否是新的事物
		boolean hasSavepoint(); 		// 是否有恢复点
		void setRollbackOnly();  		// 设置为只回滚
		boolean isRollbackOnly(); 		// 是否为只回滚
		boolean isCompleted(); 			// 是否已完成
	} 
}
