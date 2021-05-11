package com.goldrush.dao;

import java.util.List;

import com.goldrush.dto.AccountDTO;

public interface AccountDAO {

	int selectBalacne(int members_id);
	List<AccountDTO> selectAccountLog(int membersId);
	int insertFeeResult(int membersId, int amount, int balance);
	int insertSellResult(int membersId, int amount);
	int insertBuyResult(int membersId, int amount);
	int insertIpoResult(int membersId, int amount);
	int insertClearingResult(int membersId, int amount);
	int insertWithdrawResult(int membersId, int amount);
	int insertDepositResult(int membersId, int amount);
	int selectCount();
	int selectTranId();
	void insertTranIds();
}
