package com.norming.ess.common.init;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

import com.norming.ess.common.dao.impl.CommonDaoImpl;
import com.norming.ess.common.dao.utils.DynamicLoadBean;
import com.norming.ess.common.utils.FileHelper;

/**
 * 初始化动态数据源.
 * @author lh.jia
 *
 */
public class InitDynamicDataSource extends CommonDaoImpl implements BeanFactoryPostProcessor {
	
	/** Spring动态加载对象 */
	private DynamicLoadBean dynamicLoadBean;
	
	@Override
	public void postProcessBeanFactory(
			ConfigurableListableBeanFactory beanFactory) throws BeansException {
		List<?> entityList = new ArrayList<>(); //TODO
		
		if (entityList == null || entityList.size() == 0) return;
		
		
		/** 得到配置文件的路径. */
		String path = AppContext.getAppPath() + "\\WEB-INF\\classes\\";
		
		String ds = FileHelper.readFile(new File(path + "dynamic-dataSource.xml"));
		/** DataSource Bean模板 */
		String ds_tpl = "";
		
		StringBuffer dsList = new StringBuffer();
		for (Object oEntity : entityList) {
			Map<?, ?> mEntity = (Map<?, ?>) oEntity;
			
			String ENTID 	= ObjectUtils.toString(mEntity.get("ENTID"));
			String DBTYPE 	= ObjectUtils.toString(mEntity.get("DBTYPE"));
			String DBSERVER = ObjectUtils.toString(mEntity.get("DBSERVER"));
			String DBNAME 	= ObjectUtils.toString(mEntity.get("DBNAME"));
			String DBPORT 	= ObjectUtils.toString(mEntity.get("DBPORT"));
			String DBUSER 	= ObjectUtils.toString(mEntity.get("DBUSER"));
			String DBPWD 	= ObjectUtils.toString(mEntity.get("DBPWD"));
			
			if (StringUtils.isEmpty(ds_tpl)) {
				String tplPath = path;
				if ("1".equals(DBTYPE)) {
					tplPath += "dynamic-dataSource-tpl(mssql).xml";
				}
				else {
					tplPath += "dynamic-dataSource-tpl(oracle).xml";
				}
				ds_tpl = FileHelper.readFile(new File(tplPath));
			}
			
			ds_tpl.replace("$$", ENTID).replace("$$", DBSERVER);
			
			/** 将数据源的模板替换为真实的DataSource配置 */
			dsList.append("\n").append(
				ds_tpl.replace("$dataSourceID$", 	ENTID)
					.replace("$server$", 			DBSERVER)
					.replace("$dbname$", 			DBNAME)
					.replace("$port$", 				DBPORT)
					.replace("$username$", 			DBUSER)
					.replace("$password$", 			DBPWD)
			);
		}
		
		String ds_run = ds.replace("<bean/>", dsList);
		
		/** 此文件为动态数据源的Bean定义 */
		String configLocationString = "dynamic-dataSource-run.xml";
		
		File target = new File(path + configLocationString);
		
		/** 生成或覆盖 一个动态数据源的Spring配置文件 */
		FileHelper.writeFile(target, ds_run, false);
		
		/** 将动态的数据源加载到当前环境 */
		this.dynamicLoadBean.loadBean(configLocationString);
	}
	
	
	public void setDynamicLoadBean(DynamicLoadBean dynamicLoadBean) {
		this.dynamicLoadBean = dynamicLoadBean;
	}
}