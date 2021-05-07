export default class BuyModel {
  constructor() {
    
  }
  GetOfferList = (itemsId) => {
    const offerList = fetch(`http://192.168.1.70:8080/trade/offer?itemsId=${itemsId}&buy=${true}`, {
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
    var item = fetch(`http://192.168.1.70:8080/item/detail/?itemsId=${itemsId}`, {
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
     var buy =  fetch(`http://192.168.1.70:8080/trade/trade`, {
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
        res => console.log(res)
      )
      .catch((err) => {
        alert('트레이드 실패!',err);
      })
      return buy;
  }


  PostMakeOffer(membersId, itemsId, offerPrice, quantity) {
    var offer = fetch(`http://192.168.1.70:8080/trade/offer/`, {
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
        res => console.log(res)
      )
      .catch((err) => {
        alert('매수 오퍼 실패!', err);
      })

      return offer;
  }
}