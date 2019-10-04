package jdbcdemo5.dao;

import jdbcdemo5.entity.Account;

public interface AccountDao {
	/**
	 * @param account
	 * @return
	 */
	int save(Account account);
}
