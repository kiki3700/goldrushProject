import {domainUrl} from "../env.js";
export default class BuyModel {
  constructor() {
  }
 
  GetOfferList = (itemsId) => {
    const offerList = fetch(domainUrl+`trade/offer?itemsId=${itemsId}&buy=${true}`, {
      method: 'GET',
    })
    .then(
      response => response.json(),
      error => error)
    .then((offerList) => {
      return offerList;
    })
    .catch((error) => {
      alert('오퍼리스트 읽는 것에 실패', error);
    })
    return offerList;
  }

  GetItem(itemsId) {
    var item = fetch(domainUrl+`item/detail/?itemsId=${itemsId}`, {
      method: 'GET',
    })
    .then(
      response => response.json(),
      error => error)
    .then((item) => {
      return item;
    })
    .catch((error) => {
      alert('읽어오는 데 실패!', error);
    })
    return item;
  }

  PostTradeItem(membersId, price, quantity, itemsId) {
    var buy =  fetch(domainUrl+`trade/trade`, {
      method: 'POST',
      body: JSON.stringify({
        'membersId' : membersId,
        'price' : price,
        'quantity' : quantity,
        'itemsId' : itemsId,
        'buy' : false,
      }),
      headers: {
        'Content-Type': 'application/json;charset=UTF-8',
        'Access-Control-Allow-Origin': '*',
        'Accept': 'application/json'
      }}
      )
      .then(
        res => res.json(),
        err => err
      )
      .then(
        res => {
          if (res.result === 1){
            alert('성공적으로 판매하셨습니다.'),
            location.reload()
          } else {
            alert('보유량이 부족합니다.');
          }
        }
      )
      .catch((err) => {
        alert('트레이드 실패!',err);
      })
      return buy;
  }


  PostMakeOffer(membersId, itemsId, offerPrice, quantity) {
    var offer = fetch(`http://3.36.216.37/trade/offer/`, {
      method: 'POST',
      body: JSON.stringify({
        'membersId' : membersId,
        'itemsId' : itemsId,
        'buy' : true,
        'offerPrice' : offerPrice,
        'quantity' : quantity,
      }),
      headers: {
        'Content-Type': 'application/json;charset=UTF-8',
        'Access-Control-Allow-Origin': '*',
        'Accept': 'application/json'
      }}
      )
      .then(
        res => res.json(),
        err => err
      )
      .then(
        res => {
          if ( res.result === 1) {
            alert('매수 오퍼 등록에 성공하셨습니다.');
            location.reload();
          } else {
            alert('매수 오퍼 등록에 실패하였습니다.');
          }
        }
      )
      .catch((err) => {
        alert('매수 오퍼 실패!', err);
      })

      return offer;
  }

  GetPortfolio(membersId) {
    const portfolios = fetch(`http://3.36.216.37/member/portfolio/?membersId=${membersId}`, {
      method: 'GET',
    })
    .then(
      response => response.json(),
      error => error)
    .then((portfolios) => {
      
      return portfolios;
    })
    .catch((error) => {
      alert('읽어오는 데 실패하였습니다.', error);
    })
    
    return portfolios;
  }
}