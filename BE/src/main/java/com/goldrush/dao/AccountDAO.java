package com.goldrush.dao;

import java.util.HashMap;
import java.util.List;

import com.goldrush.dto.AccountDTO;

public interface AccountDAO<Hashmap> {

	int selectBalacne(int members_id);
	List<AccountDTO> selectAccountLog(int membersId);
	int insertResult(HashMap<String, Object> params);
//	int insertBuyResult(HashMap<String, Object> params);
//	int insertIpoResult(HashMap<String, Object> params);
//	int insertClearingResult(HashMap<String, Object> params);
//	int insertWithdrawResult(HashMap<String, Object> params);
//	int insertDepositResult(HashMap<String, Object> params);
	int selectCount();
	int selectTranId();
	void insertTranIds();
	int insertFeeResult(int membersId, int amount);
}
