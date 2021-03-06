import {domainUrl} from "../env.js"
export default class ClearModel {
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
      alert(error);
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
      alert(error);
    })
    return item
  }

  GetClear(itemid, sellPrice) {
    const clear = fetch(domainUrl+`/trade/clear/?itemsId=${itemid}&price=${sellPrice}`, {
      method: 'GET',
    })
    .then(
      res => res.json(),
      err => err,
    )
    .then(
      response => {
        if (response.result === 1) {
          location.href = '#clear';
        } else {
          alert('클리어실패!', response);
        }
      }
    )
    .catch((err) => {
      console.log('클리어 에러!', err);
    })
    return clear;
  }

  
}