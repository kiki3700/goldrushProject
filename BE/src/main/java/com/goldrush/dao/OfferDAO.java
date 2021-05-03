package com.goldrush.dao;

import java.util.List;

import com.goldrush.dto.OfferDTO;
import com.goldrush.dto.OfferLogDTO;
import com.goldrush.dto.OffersListDTO;
import com.goldrush.dto.ResponseDTO;

public interface OfferDAO {
	public List<OfferDTO> selectOffers();
	public List<OfferDTO> selectOffersByPrice(int price);
	public List<OfferDTO> selectOffersByItemsId(int itemsId);
	public ResponseDTO insertNewOffer(OfferDTO dto);
	public ResponseDTO deleteOffer(OfferDTO dto);
	public ResponseDTO updateOfferByQuantity(OfferDTO dto);
	public List<OffersListDTO> selectBuyOfferList(OfferDTO dto);
	public List<OffersListDTO> selectSellOfferList(OfferDTO dto);
	ResponseDTO updateCompeleteOffer(OfferDTO dto);
	List<OfferLogDTO> selectOffersByMembersId(int membersId);
}
