package di04;

public class BoardImplDao implements Board {
    @Override
    public void insert(String data){
        System.out.println(data + " 추가");
    }
    @Override
    public void delete(String data){
        System.out.println(data + " 삭제");
    }
    @Override
    public void update(String data){
        System.out.println(data + " 삭제");
    }
    @Override
    public void select(String data){
        System.out.println(data + " 조회");
    }
}
