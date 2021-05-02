package com.goldrush.dao;

import java.util.List;

import com.goldrush.dto.MemberDTO;
import com.goldrush.dto.ResponseDTO;
import com.goldrush.dto.TradeDTO;

public interface TradeDAO {
	public List<TradeDTO> selectTrade(MemberDTO dto);
	public ResponseDTO insertTrade(TradeDTO dto);
}
