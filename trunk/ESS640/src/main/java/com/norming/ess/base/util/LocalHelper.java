package com.norming.ess.base.util;

import java.lang.reflect.Field;

/**
 * ThreadLocal对象,"注册"到本助手类下,在任务结束时候"统一"释放,避免因为线程池原因而产生的对象无法释放问题.
 * 如果是类下面的static的变量,请调用registStatic,否则请调用regist
 * 
 */
public class LocalHelper {

	private static LocalListener listener = new LocalListener();

	/**
	 * 清除全部的LocalContext信息.这个函数只能由Dispatcher控制器来使用.
	 *
	 */
	public static void clearContexts() {
		listener.clearContexts();

	}

	/**
	 * 绑定一个request级别的ThreadLocal对象.
	 * 
	 * @param <E>
	 * @param tl
	 * @return
	 */
	public static <E> ThreadLocal<E> regist(ThreadLocal<E> tl) {
		return listener.regist(tl);
	}

	/**
	 * 绑定一个global级别的ThreadLocal对象.
	 * 
	 * @param <E>
	 * @param tl
	 * @return
	 */
	public static <E> ThreadLocal<E> registStatic(ThreadLocal<E> tl) {
		return listener.registStatic(tl);
	}

	/**
	 * 注销一个request级别的ThreadLocal对象.
	 * 
	 * @param <E>
	 * @param tl
	 * @return
	 */
	public static <E> ThreadLocal<E> unregist(ThreadLocal<E> tl) {
		return listener.unregist(tl);
	}

	/**
	 * 注销一个global级别的ThreadLocal对象.
	 * 
	 * @param <E>
	 * @param tl
	 * @return
	 */
	public static <E> ThreadLocal<E> unregistStatic(ThreadLocal<E> tl) {
		return listener.unregistStatic(tl);
	}
	
}

class LocalTest {

	public static void main(String[] args) {
		test1();
	}

	private static void test1() {
		C1 c1 = new C1();
		try {
			c1.tl.set("tl value");
			C1.stl.set("stl value");
			showLocals(Thread.currentThread());
			showC1(c1);
		} catch (Throwable tr) {

		} finally {
			LocalHelper.clearContexts();
			showLocals(Thread.currentThread());
			showC1(c1);
		}
	}
	
	private static void showLocals(Thread t){
		System.out.println("Show Thread:" + t);
		Object m = getValue(t, "threadLocals");
		Object[] es = (Object[]) getValue(m, "table");
		for (Object e : es){
			if (e != null){
				System.out.println(getValue(e, "value"));
			}
		}
	}
	
	private static void showC1(C1 c1){
		System.out.println("Show c1, stl(" + C1.stl.get() + "), tl(" + c1.tl.get() + ")");
	}
	
	private static Object getValue(Object o, String f){
		Class<?> c = (Class<?>) (o instanceof Class ? o : o.getClass());
		try {
			Field field = c.getDeclaredField(f);
			if (!field.isAccessible()){
				field.setAccessible(true);
			}
			return field.get(o);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	static class C1 {
		static ThreadLocal<Object> stl = LocalHelper.registStatic(new ThreadLocal<Object>() {
			public String toString() {
				return "stl:" + this.get();
			}
		});
		ThreadLocal<Object> tl = LocalHelper.regist(new ThreadLocal<Object>() {
			public String toString() {
				return "tl:" + this.get();
			}
		});
	}
}