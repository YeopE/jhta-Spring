package day03_quiz;

import dto.BuyDto;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import service.BuyService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(JavaConfig.class);
        BuyService service = (BuyService) ac.getBean("buyService");

        System.out.println("원하는 메뉴를 입력하세요.");
        System.out.println("1.제품구매 2.구매정보수정 3.구매정보조회 4.구매취소");
        Scanner scan = new Scanner(System.in);
        int selectNum = scan.nextInt();
        if(selectNum == 1) {
            System.out.println("id를 입력해주세요.");
            String id = scan.next();
            System.out.println("상품명을 입력해주세요.");
            String pname = scan.next();
            System.out.println("가격을 입력해주세요.");
            int price = scan.nextInt();
            System.out.println("수량을 입력해주세요.");
            int amount = scan.nextInt();
            System.out.println("결제 수단을 입력해주세요. (현금or카드)");
            String paymethod = scan.next();

            service.insert(new BuyDto(0, id, pname, price, amount, null), paymethod);
        }else if(selectNum == 2) {
            System.out.println("수정할 구매번호를 입력하세요.");
            int buynum = scan.nextInt();
            System.out.println("수정할 상품명을 입력하세요.");
            String pname = scan.next();
            System.out.println("수정할 가격을 입력하세요.");
            int price = scan.nextInt();
            System.out.println("수정할 수량을 입력하세요.");
            int amount = scan.nextInt();
            System.out.println("수정할 결제 수단을 입력하세요. (현금or카드)");
            String paymethod = scan.next();

            service.update(new BuyDto(buynum, null, pname, price, amount, null),paymethod);
        }else if(selectNum == 3) {
            System.out.println("전체 구매 정보");
            service.buySelectAll();
            System.out.println("전체 결제 정보");
            service.paySelectAll();
        } else if(selectNum == 4) {
            System.out.println("취소할 구매 번호를 입력하세요.");
            int buynum = scan.nextInt();

            service.delete(buynum);
        }else {
            System.out.println("올바른 메뉴를 선택하세요.");
        }
    }
}
