export default class CatalogueModel {
  constructor() {
  }
  GetItemList() {
    var itemList = fetch('http://192.168.1.70:8080/item/', {
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
      console.log(error);
    })
    return item
  }
  PostMakeSubscription(membersId, itemsId, quantity) {
    const contract = fetch(`http://192.168.1.70:8080/trade/subscription`, {
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
        response => console.log(response),
      )
      .catch((err) => {
        console.log(err);
      })
      return contract;
  }
  
}