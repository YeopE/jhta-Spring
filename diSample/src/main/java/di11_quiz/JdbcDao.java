package di11_quiz;

import members.dto.MyUsersDto;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class JdbcDao {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    //등록
    public int insert(MyUsersDto dto){
        String sql = "insert into myusers values(?,?,?,sysdate)";
        int n = jdbcTemplate.update(sql,dto.getId(),dto.getPwd(),dto.getEmail());
        return n;
    }

    //삭제
    public int delete(String id) {
        String sql = "delete from myusers where id = ?";
        int n = jdbcTemplate.update(sql,id);
        return n;
    }

    //수정
    public int update(MyUsersDto dto){
        String sql = "update myusers set pwd=?, email=? where id = ?";
        int n = jdbcTemplate.update(sql,dto.getPwd(), dto.getEmail(), dto.getId());
        return n;
    }

    //조회
    public MyUsersDto select(String id){
        String sql= "select * from myusers where id = ?";
        try {
            RowMapper<MyUsersDto> rowMapper = new RowMapper<MyUsersDto>() {
                @Override
                public MyUsersDto mapRow(ResultSet rs, int rowNum) throws SQLException {
                    MyUsersDto dto = new MyUsersDto();
                    dto.setId(rs.getString("id"));
                    dto.setPwd(rs.getString("pwd"));
                    dto.setEmail(rs.getString("email"));
                    dto.setRegdate(rs.getDate("regdate"));
                    return dto;
                }
            };
            MyUsersDto dto = jdbcTemplate.queryForObject(sql, rowMapper, id);
            return dto;
        } catch (EmptyResultDataAccessException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    //전체조회
    public List<MyUsersDto> selectAll() {
        String sql = "select * from myusers";
        RowMapper<MyUsersDto> rowMapper = (ResultSet rs, int rowNum)->{
            MyUsersDto dto = new MyUsersDto();
            dto.setId(rs.getString("id"));
            dto.setPwd(rs.getString("pwd"));
            dto.setEmail(rs.getString("email"));
            dto.setRegdate(rs.getDate("regdate"));
            return dto;
        };
        List<MyUsersDto> list = jdbcTemplate.query(sql,rowMapper);
        return list;
    }
}
