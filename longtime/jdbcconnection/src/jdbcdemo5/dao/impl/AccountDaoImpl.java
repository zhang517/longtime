package jdbcdemo5.dao.impl;

import java.util.Date;

import jdbcdemo5.dao.AccountDao;
import jdbcdemo5.entity.Account;
import jdbcdemo5.util.BaseDao;

public class AccountDaoImpl  extends BaseDao implements AccountDao {
	@Override
	public int save(Account account) {
		String sql
		   ="INSERT INTO account (deal_type,pet_id,seller_id,buyer_id,price,deal_time)" +
                "VALUES (?,?,?,?,?,?)";  
		
		Object[] param={account.getDealType(),account.getPetId(),
				account.getSellerId(),account.getBuyerId(),
				account.getPrice(),new Date()};
		
		int result=this.exceuteUpdate(sql, param);
		
		return result;
	}
}
