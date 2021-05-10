export default class ClearModel {
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

  
}