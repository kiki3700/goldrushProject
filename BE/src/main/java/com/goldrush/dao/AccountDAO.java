package com.goldrush.dao;

import java.util.List;

import com.goldrush.dto.AccountDTO;

public interface AccountDAO {

	int selectBalacne(int members_id);
	List<AccountDTO> selectAccountLog(int membersId);
	int insertSellResult(int membersId, int amount, int balance);
	int insertBuyResult(int membersId, int amount, int balance);
	int insertIpoResult(int membersId, int amount, int balance);
	int insertClearingResult(int membersId, int amount, int balance);
	int insertFeeResult(int membersId, int amount, int balance);
	int insertDepositResult(int membersId, int amount, int balance);
	int insertWithdrawResult(int membersId, int amount, int balance);

}
