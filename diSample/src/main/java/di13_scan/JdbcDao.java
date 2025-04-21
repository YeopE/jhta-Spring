package di13_scan;

import members.dto.MembersDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
@Repository
public class JdbcDao {
    @Autowired
    private JdbcTemplate jdbcTemplate; //JDBC를 연결할때 JdbcTemplate을 사용한다.

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public int insert(MembersDto dto){
        String sql = "insert into members values(?,?,?,?,sysdate)";
        //jdbcTemplate.update("실행할sql구문",?에 대응되는 파라미터값들); //Object... args 로 나와있다.
        //int n = jdbcTemplate.update(sql,dto.getNum(),dto.getName(),dto.getPhone(),dto.getAddr());

        //Object 배열 형태로 작성
        Object[] args=new Object[]{dto.getNum(),dto.getName(),dto.getPhone(),dto.getAddr()}; //Object배열 생성 및 초기화

        //배열 초기화 및 생성 별도
//        Object[] a = new Object[4];
//        a[0] = dto.getNum();
//        a[1] = dto.getName();
//        a[2] = dto.getPhone();
//        a[3] = dto.getAddr();

        int n = jdbcTemplate.update(sql,args);
        return n;
    }

    public int delete(int num){
        int n = jdbcTemplate.update("delete from members where num = ?", num);
        return n;
    }

    public int update (MembersDto dto) {
        int n = jdbcTemplate.update("update members set name=?,phone=?,addr=? where num = ?", dto.getName(),dto.getPhone(),dto.getAddr(),dto.getNum());
        return n;
    }

    public MembersDto select(int num) {
        String sql = "select * from members where num = ?";
        try {
            //select로 조회된 결과를 어떤DTO에 어떻게 담을지를 구현하는 클래스
            RowMapper<MembersDto> rowMapper = new RowMapper<MembersDto>() {
                @Override
                public MembersDto mapRow(ResultSet rs, int rowNum) throws SQLException { //int rowNum = 행번호
                    MembersDto dto = new MembersDto();
                    dto.setNum(rs.getInt("num"));
                    dto.setName(rs.getString("name"));
                    dto.setPhone(rs.getString("phone"));
                    dto.setAddr(rs.getString("addr"));
                    dto.setRegdate(rs.getDate("regdate"));
                    return dto;
                }
            };
            MembersDto dto = jdbcTemplate.queryForObject(sql, rowMapper, num);
            return dto;
        }catch (EmptyResultDataAccessException e){ //없는 번호를 조회하면 나타나는 EmptyResultDataAccessException 예외처리 진행 null 값을 리턴 시킴
            System.out.println(e.getMessage());
            return null;
        }
    }

    //데이터 여러 개 받기
    public List<MembersDto> selectAll(){
        RowMapper<MembersDto> rowMapper=(ResultSet rs, int rowNum)->{ //람다식
            MembersDto dto = new MembersDto();
            dto.setNum(rs.getInt("num"));
            dto.setName(rs.getString("name"));
            dto.setPhone(rs.getString("phone"));
            dto.setAddr(rs.getString("addr"));
            dto.setRegdate(rs.getDate("regdate"));
            return dto;
        };
        List<MembersDto> list = jdbcTemplate.query("select * from members",rowMapper);
        return list;
    }
}
