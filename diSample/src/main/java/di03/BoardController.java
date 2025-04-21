package di03;

public class BoardController {
    private CommonDao dao;
    public BoardController(){}
//    public BoardController(CommonDao dao){ //생성자로 받아도 되고 아래와 같이 setter로 받아도 된다.
//        this.dao = dao;
//    }
    public void setDao(CommonDao dao){
        this.dao = dao;
    }
    public void service() {
        dao.insert("스프링di이해1");
        dao.update("스프링di이해1");
        dao.delete("스프링di이해1");
        dao.select("스프링di이해1");
    }
}
