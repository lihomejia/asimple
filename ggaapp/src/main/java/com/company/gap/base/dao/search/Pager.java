package com.company.gap.base.dao.search;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


public class Pager implements Cloneable, Serializable {

	private static final long serialVersionUID = 1L;

	// 起始纪录位置 当前记录的位置,从1开始.
	private int start = 0;
	// 查询纪录数量 每页的记录数,小于1则为无效值,使用默认值.
	private int count = 0;
	// 当前查询命中数量 
	private int hits;
	// 全部命中纪录 
	private int allhits;
	// 全部页 
	private int pages;
	// page,当前页 
	private int page;

	public static final int DEFAULT_START = 1;
	public static final int DEFAULT_COUNT = 20;
	public static final int DEFAULT_PAGE = 1;

	/**
	 * 计算页面
	 */
	public final void calculate() {
		ensurePager(this);
		page = (start - 1) / count + 1;
		pages = (allhits - 1) / count + 1;
		hits = page < pages ? count : allhits - (pages - 1) * count;
	}

	/**
	 * @return the start
	 */
	public int getStart() {
		return start;
	}

	/**
	 * @param start the start to set
	 */
	public void setStart(int start) {
		this.start = start;
	}

	/**
	 * @return the count
	 */
	public int getCount() {
		return count;
	}

	/**
	 * @param count the count to set
	 */
	public void setCount(int count) {
		this.count = count;
	}

	/**
	 * @return the hits
	 */
	public int getHits() {
		return hits;
	}

	/**
	 * @param hits the hits to set
	 */
	public void setHits(int hits) {
		this.hits = hits;
	}

	/**
	 * @return the allhits
	 */
	public int getAllhits() {
		return allhits;
	}

	/**
	 * @param allhits the allhits to set
	 */
	public void setAllhits(int allhits) {
		this.allhits = allhits;
	}

	/**
	 * @return the pages
	 */
	public int getPages() {
		return pages;
	}

	/**
	 * @param pages the pages to set
	 */
	public void setPages(int pages) {
		this.pages = pages;
	}

	/**
	 * @return the page
	 */
	public int getPage() {
		return page;
	}

	/**
	 * @param page the page to set
	 */
	public void setPage(int page) {
		this.page = page;
	}

	/**
	 * 获取一个默认的分页器,从1开始,每页显示数量为当前用户设置值,或系统默认值.
	 * 
	 * @return
	 */
	public static Pager getDefault() {
		Pager ins = new Pager();
		ins.setCount(Pager.DEFAULT_COUNT);
		ins.setStart(Pager.DEFAULT_START);
		ins.setPage(Pager.DEFAULT_PAGE);

		return ins;
	}

	/**
	 * 保证一个"起码"可以使用的pager
	 * 
	 * @param pager
	 * @return
	 */
	public static Pager ensurePager(Pager pager) {
		if (pager.start < 1) {
			pager.start = Pager.DEFAULT_START;
		}
		if (pager.count < 1) {
			pager.count = Pager.DEFAULT_COUNT;
		}

		return pager;
	}

	public Pager clone() {
		Pager pager = new Pager();
		pager.allhits = this.allhits;
		pager.count = this.count;
		pager.hits = this.hits;
		pager.page = this.page;
		pager.pages = this.pages;
		pager.start = this.start;

		return pager;
	}

	public String toString() {
		return new StringBuilder()
			.append("Pager:")
			.append(" start(").append(start).append(")")
			.append(" count(").append(count).append(")")
			.append(" page(").append(page).append(")")
			.append(" pages(").append(pages).append(")")
			.append(" hits(").append(hits).append(")")
			.append(" allhits(").append(allhits).append(")")
		.toString();
	}

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Pager p = Pager.getDefault();
		p.setAllhits(1098);
		p.setStart(1081);
		p.calculate();
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(baos);
		oos.writeObject(p);

		ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(baos.toByteArray()));
		Pager p2 = (Pager) ois.readObject();

		System.out.println(p.toString().equals(p2.toString()));
	}
}