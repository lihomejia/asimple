package com.company.gap.base;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.company.gap.base.util.FileHelper;


/**
 * 初始化动态数据源.
 * @author lh.jia
 *
 */
public class InitDynamicDataSource extends JdbcDaoSupport implements BeanFactoryPostProcessor {
	
	private ConfigurableListableBeanFactory beanFactory;
	
	@Override
	public void postProcessBeanFactory(
			ConfigurableListableBeanFactory beanFactory) throws BeansException {
		this.beanFactory = beanFactory;
		
		String comSql = new StringBuffer()
			.append("select innercode from t_company where status=2")
		.toString();
		List<Map<String, Object>> comList = getJdbcTemplate().queryForList(comSql);
		
		if (comList == null || comList.size() == 0) return;
		
		
		this.loadCompanyDataSource(comList);
	}
	
	
	public void loadCompanyDataSource(List<Map<String, Object>> comList) {
		/** 得到配置文件的路径. */
		Resource dsResource = new ClassPathResource("dynamic-dataSource.xml");
		
		File dsFile = this.getFileByResource(dsResource);
		
		String ds = FileHelper.readFile(dsFile);
		
		/** DataSource Bean模板 */
		String dsTpl = "";
		
		BasicDataSource dataSource = (BasicDataSource) getJdbcTemplate().getDataSource();
		final String url = dataSource.getUrl().replace("&", "&amp;");
		final String user = dataSource.getUsername();
		final String pass = dataSource.getPassword();
		
		StringBuffer dsList = new StringBuffer();
		for (Map<String, Object> mCom : comList) {
			String companyId = ObjectUtils.toString(mCom.get("innercode"));
			
			if (StringUtils.isEmpty(dsTpl)) {
				String tplName = "dynamic-dataSource-tpl.xml";
				Resource tplResource = new ClassPathResource(tplName);
				
				dsTpl = FileHelper.readFile(this.getFileByResource(tplResource));
			}
			
			
			/** 将数据源的模板替换为真实的DataSource配置 */
			dsList.append("\n").append(
				dsTpl.replace("$dataSourceID$", 	companyId)
					.replace("$url$", 				url.replaceFirst("/[^\\/]*\\?", "/" + GapConstants.SCHEMA_PREFIX + companyId  +  "?"))
					.replace("$username$", 			user)
					.replace("$password$", 			pass)
			);
		}
		
		String ds_run = ds.replace("<bean/>", dsList);
		
		/** 此文件为动态数据源的Bean定义 */
		String configLocationString = "dynamic-dataSource-run.xml";
		
		File target = new File(dsFile.getParentFile(), configLocationString);
		
		
		/** 生成或覆盖 一个动态数据源的Spring配置文件 */
		FileHelper.writeFile(target, ds_run, false);
		
		/** 将动态的数据源加载到当前环境 */
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader((BeanDefinitionRegistry) beanFactory);
		reader.loadBeanDefinitions(configLocationString);
	}
	
	private File getFileByResource(Resource resource) {
		try {
			return resource.getFile();
		} catch (IOException e) {
			return null;
		}
	}

}
