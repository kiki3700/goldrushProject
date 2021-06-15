import {domainUrl} from "../env.js";
export default class CatalogueModel {
  constructor() {
  }
  GetItemList() {
    var itemList = fetch(domainUrl+'item/', {
      method: 'GET',
    })
    .then(
      response => response.json(),
      error => error)
    .then((itemList) => {
      return itemList;
    })
    .catch((error) => {
      console.log(error);
    })
    
    return itemList;
  }
  GetItem(itemsId) {
    var item = fetch(domainUrl+`/item/detail/?itemsId=${itemsId}`, {
      method: 'GET',
    })
    .then(
      response => response.json(),
      error => error)
    .then((item) => {
      return item;
    })
    .catch((error) => {
      console.log(error);
    })
    return item
  }
  PostMakeSubscription(membersId, itemsId, quantity) {
    const contract = fetch(domainUrl+`/trade/subscription`, {
      method: 'POST',
      body: JSON.stringify({
        'membersId': membersId,
        'itemsId' : itemsId,
        'quantity' : quantity,
      }),
      headers: {
        'Content-Type': 'application/json;charset=UTF-8',
        'Access-Control-Allow-Origin': '*',
        'Accept': 'application/json'
      },
    })
      .then(
        res => res.json(),
        err => err,
      )
      .then(
        response => {
          if (response.result === 1) {
            alert('청약에 성공하셨습니다.');
            return location.reload();
          } else {
            return alert('청약에 실패하셨습니다.');
          }
        },
      )
      .catch((err) => {
        console.log(err);
      })
      return contract;
  }
  
}