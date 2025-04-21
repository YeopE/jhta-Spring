package di02;

public class BoardController {
    private MysqlDao dao;
    public BoardController() {
        dao = new MysqlDao();
    }
    public void service() {
        dao.insert("스프링di이해1");
        dao.update("스프링di이해1");
        dao.delete("스프링di이해1");
        dao.select("스프링di이해1");
    }
}
