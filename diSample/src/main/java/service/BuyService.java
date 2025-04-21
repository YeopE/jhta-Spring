package service;

import dao.BuyDao;
import dao.BuyDaoImpl;
import dao.PayDao;
import dao.PayDaoImpl;
import dto.BuyDto;
import dto.PayDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class BuyService {
    @Autowired
    private BuyDao buyDao;
    @Autowired
    private PayDao payDao;

    public int insert(BuyDto dto, String paymethod) {
        buyDao.insert(dto);
        int n = payDao.insert(new PayDto(0,dto.getBuynum(), (dto.getPrice() * dto.getAmount()), paymethod));
        return n;
    }

    public int update(BuyDto dto, String paymethod){
        buyDao.update(dto);
        int n = payDao.update(new PayDto(0,dto.getBuynum(),(dto.getPrice() * dto.getAmount()),paymethod));
        return n;
    }

    public int delete(int buynum) {
        payDao.delete(payDao.selectPaynum(buynum));
        int n = buyDao.delete(buynum);
        return n;
    }

    public List<BuyDto> buySelectAll() {
        List<BuyDto> list = buyDao.selectAll();
        for (BuyDto dto : list) {
            System.out.println(dto);
        }
        return list;
    }

    public List<PayDto> paySelectAll() {
        List<PayDto> list = payDao.selectAll();
        for (PayDto dto : list) {
            System.out.println(dto);
        }
        return list;
    }


}
