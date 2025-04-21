package di05_anno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
/*
    @Controller : 컨트롤러 객체 생성
    @Service : 서비스객체 생성
    @Repository : Dao 생성
    @Component : 위에 기능에 해당하지 않는 클래스
 */
@Controller(value = "controller") //스프링이 자동생성해준다(Controller) //(value="이름") 은 기본 xml에서 줬던 class name값이다. 별도의 이름을 지정하고 싶으면 (value = "원하는이름")으로 지어주면 되고 아니면 TestMain.java 에 BoardController controller = (BoardController)ac.getBean("boardController"); 라고 컨트롤러의 소문자 명으로 자동으로 기입된다.
public class BoardController {
    @Autowired //CommonDao가 있으면 자동으로 주입해라 (CommonDao가 없으면 에러)
    private CommonDao dao;
    public BoardController(){}
    public void service() {
        dao.insert("스프링di이해1");
        dao.update("스프링di이해1");
        dao.delete("스프링di이해1");
        dao.select("스프링di이해1");
    }
}
