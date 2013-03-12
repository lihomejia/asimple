package com.company.gap.manure.dao;


import java.util.List;

import com.company.gap.manure.entity.ManureStock;

public interface IManureStockDao {
	List<ManureStock> queryList();
}
