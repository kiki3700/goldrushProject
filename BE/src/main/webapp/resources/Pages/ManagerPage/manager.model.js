import {domainUrl} from "../env.js"
export default class ManagerModel {
  constructor() {
    
  }
  GetItemList() {
    const itemList = fetch(domainUrl+'item/', {
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
  GetItem(itemId) {
    const item = fetch(domainUrl+`item/detail/?itemsId=${itemId}`, {
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
  PostUpdateItem(formData, itemId) {
    const update = fetch(domainUrl+`item/listEdit/?itemsId=${itemId}`, {
      method: 'POST',
      body: formData,
      headers: {},
    })
    .then(
      response => response.json(),
      error => error)
    .then(
      res => {
        if (res.result === 1) {
          alert('상품을 수정하였습니다.', res);
          location.reload()
        } else {
          alert('상품 수정에 실패하였습니다.')
        }
      }
    )
    .catch((error) => {
      alert('수정하는 데 실패!' ,error);
    })
    return this.PutUpdateItem;
  }
  DeleteItem(itemId) {
    const item = fetch(domainUrl+`item/list?itemsId=${itemId}`, {
      method: 'DELETE',
    })
    .then(
      response => response.json(),
      error => error
    )
    .then(
      json => {
        if (json.result === 1) {
          alert('상품삭제 성공!');
          location.href='#manager';
        } else {
          alert('상품삭제 실패!');    
        }
    } 
    )
    .catch((error) => {
      alert('삭제하는 데 실패!', error)
    })
  }
}