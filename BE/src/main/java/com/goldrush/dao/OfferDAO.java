package com.goldrush.dao;

import java.util.List;

import com.goldrush.dto.OfferDTO;
import com.goldrush.dto.OfferLogDTO;
import com.goldrush.dto.OffersListDTO;
import com.goldrush.dto.ResponseDTO;
import com.goldrush.dto.TraderDTO;

public interface OfferDAO {
	public List<OfferDTO> selectOffers();
	public List<OfferDTO> selectOffersByPrice(int price);
	public List<OfferDTO> selectOffersByItemsId(int itemsId);
	public ResponseDTO insertNewOffer(OfferDTO dto);
	public ResponseDTO deleteOffer(OfferDTO dto);
	public List<OffersListDTO> selectBuyOfferList(OfferDTO dto);
	public List<OffersListDTO> selectSellOfferList(OfferDTO dto);
	ResponseDTO updateCompeleteOffer(OfferDTO dto);
	List<OfferLogDTO> selectOffersByMembersId(int membersId);
	OfferDTO selectOffer(OfferDTO offerDTO);
	OfferDTO selectOfferBytrade(TraderDTO dto);
	ResponseDTO insertOffer(OfferDTO dto);
	ResponseDTO updateOfferByTrade(OfferDTO dto);
	int checkEnoughBalance(int membersId);
	int checkOfferedQuantity(int membersId, int itemsId);
	int checkQuantityBalance(int itemsId);
	List<OfferDTO> selectOffersForIpo(int itemsId);
	ResponseDTO deleteOffersForClearing(int itemsId);
	ResponseDTO insertOfferForClear(OfferDTO dto);
	OfferDTO selectOfferForClearing(OfferDTO offerDTO);
}
