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
      alert('읽어오는 데 실패하였습니다.', error);
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
      alert('읽어오는 데 실패!', error);
    })
    return item
  }
}