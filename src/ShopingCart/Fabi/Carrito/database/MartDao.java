package ShopingCart.Fabi.Carrito.database;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class MartDao {
	private NamedParameterJdbcTemplate access;
	@Autowired
	public void setDtaSource(DataSource dataSource){
		this.access = new NamedParameterJdbcTemplate(dataSource);
	}
	public List executeQuery(String sql,SqlParameterSource sqlParameterSource,RowMapper mapper){
		return this.access.query(sql, sqlParameterSource,mapper);
	}
	public int insertData(String sql, SqlParameterSource sqlParameterSource){
		return this.access.update(sql, sqlParameterSource);
	}
	
	public int updateQuery(String sql, SqlParameterSource paramSource){
		return this.access.update(sql, paramSource);
	}
 
}