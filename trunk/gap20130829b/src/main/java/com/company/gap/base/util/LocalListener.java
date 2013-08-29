package com.company.gap.base.util;

import java.util.LinkedHashSet;
import java.util.concurrent.ConcurrentHashMap;

/**
 * ThreadLocal监听器.
 * <p>
 * ThreadLocal虽然是个好东西,但是在遇到Thread线程池以后,clear就成了大问题.
 * ThreadLocal中的真正起作用的东西是绑定在Thread对象下的(ThreadLocal.ThreadLocalMap threadLocals),释放该对象.
 * 一般情况下我们会用这样的办法来解决,在底层控制器里面:
 * </p>
 * <pre>
 * try {
 * } finally {
 * 	threadLocalIns.clear();
 * }
 * </pre>
 * 但是后面的工作就很麻烦了,以后增加一个threadLocal就要去底层的控制器里面增加处理.
 * 这样的处理,可以做成一个"注册监听"的方式,由某个辅助对象来统一处理,而每个threadLocal自己的调用代码里只需要向监听器注册自己即可.
 * <pre>
 * try{
 * localListener.regist(threadLocal)
 * } finally {
 * 	localListener.clearContexts();
 * }
 * </pre>
 * <p>
 * 静态和非静态的区别是:静态的threadLocal,应该是绑定在class下的,这样的情况下,绑定一次以后,每次clearContexts,都需要处理它,
 * 而非静态threadLocal,绑定在对象下,在每次clearContexts后,同时也会取消监听(因为一般情况下,绑定的对象出了这个线程就没了).
 * 或者换个scope说法,静态的是application级别的,而非静态的是request级别的.
 * </p>
 * 
 */
public class LocalListener {

	private final Object obj = new Object();
	private ConcurrentHashMap<ThreadLocal<?>, Object> statics = new ConcurrentHashMap<ThreadLocal<?>, Object>();
	private ThreadLocal<LinkedHashSet<ThreadLocal<?>>> tmps = new ThreadLocal<LinkedHashSet<ThreadLocal<?>>>();

	private LinkedHashSet<ThreadLocal<?>> forTmps(boolean autoCreate) {
		LinkedHashSet<ThreadLocal<?>> ts = tmps.get();
		if (ts == null && autoCreate) {
			ts = new LinkedHashSet<ThreadLocal<?>>();
			ts.add(tmps);
			tmps.set(ts);
		}
		return ts;
	}

	/**
	 * 清除全部的ThreadLocal信息.
	 * 必须在dispatcher控制器的finaly中调用该函数,以清除.
	 */
	public void clearContexts() {
		for (ThreadLocal<?> tl : statics.keySet().toArray(new ThreadLocal[0])) {
			tl.remove();
		}
		LinkedHashSet<ThreadLocal<?>> tmps = forTmps(false);
		if (tmps != null) {
			for (ThreadLocal<?> tl : tmps.toArray(new ThreadLocal[0])) {
				tl.remove();
			}
		}
	}

	/**
	 * 注册一个全局的ThreadLocal(绑定在一个类的static属性下).
	 * 
	 * @param <E>
	 * @param tl
	 * @return 返回刚才注册登记的ThreadLocal对象.
	 */
	public <E> ThreadLocal<E> registStatic(ThreadLocal<E> tl) {
		statics.putIfAbsent(tl, obj);
		return tl;
	}

	/**
	 * 注销一个全局的ThreadLocal.
	 * 
	 * @param <E>
	 * @param tl
	 * @return
	 */
	public <E> ThreadLocal<E> unregistStatic(ThreadLocal<E> tl) {
		statics.remove(tl);
		return tl;
	}

	/**
	 * 注册一个请求级别的的threadLocal.
	 * 
	 * @param <E>
	 * @param tl
	 * @return 返回要注册的ThreadLocal对象.
	 */
	public <E> ThreadLocal<E> regist(ThreadLocal<E> tl) {
		forTmps(true).add(tl);
		return tl;
	}

	/**
	 * 注销一个请求级别的threadLocal,如果未曾注册,则什么都不做.
	 * 
	 * @param <E>
	 * @param tl
	 * @return 返回要注销的ThreadLocal对象(无论操作是否真实起效了).
	 */
	public <E> ThreadLocal<E> unregist(ThreadLocal<E> tl) {
		LinkedHashSet<ThreadLocal<?>> tmps = forTmps(false);
		if (tmps != null) {
			tmps.remove(tl);
		}
		return tl;
	}
}
