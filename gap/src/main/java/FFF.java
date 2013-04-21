import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;


public class FFF {
	public static void main(String[] args) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		
		
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setUrl("jdbc:mysql://localhost:3306/gap?useOldAliasMetadataBehavior=true&useUnicode=true&characterEncoding=utf-8");
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		
		jdbcTemplate.setDataSource(dataSource);
		
		System.out.println(jdbcTemplate.queryForList("select * from t_production_cell"));
		
	}
}
