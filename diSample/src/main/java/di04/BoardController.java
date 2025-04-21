package di04;

public class BoardController {
    private Board dao;
    public BoardController(){}
    public BoardController(Board dao){
        this.dao = dao;
    }

    public void service() {
        dao.insert("글 등록");
        dao.delete("글 등록");
        dao.update("글 등록");
        dao.select("글 등록");
    }
}
