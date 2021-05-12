import manager from './manager.js'

export default class ManagerView{
  constructor() {
    this.view = manager;
    this.body = document.querySelector('body');
    this.css = document.querySelector('.css_part');
  }

  render = () => {
    const root = document.querySelector('#root');
    root.remove();
    const newRoot = document.createElement('div');
    newRoot.setAttribute('id', 'root');
    this.body.appendChild(newRoot);
    this.css.setAttribute('href', 'Pages/ManagerPage/manager.css');
    newRoot.insertAdjacentHTML('afterbegin', this.view);

    
  }
 
  makeList = (list) => {
    let itemUl = document.querySelector('.item_ul');
    
    for (var item of list) {
      console.log(item);
      item.imgAddress = item.imgAddress.slice(0,9) + '/thumbnail' + item.imgAddress.slice(9);
      if ( item.stage === 'open' || item.stage === 'unopen' ) {
        let li = document.createElement('li');
        li.className = 'item_li';
        let textNode = `
        <a href = '#manager/${item.itemsId}'>
            <div class="row item_small">
            <div class="image_box col-lg-4 col-xs-4">
            <img src="${item.imgAddress}" alt="item_image_small">
              </div>
              <p class="col-lg-4 col-xs-5 text-center">${item.name} <br> ${item.stage}</p>
              <p class="col-lg-4 col-xs-5 text-center">현재가 ${item.price}</p>
            </div>
          </a>
        `
        li.insertAdjacentHTML('afterbegin',textNode);
        itemUl.appendChild(li);
      } else if ( item.stage !== "close" ){
        let li = document.createElement('li');
        li.className = 'item_li';
        let textNode = `
        <a href = '#manager/${item.itemsId}'>
            <div class="row item_small">
            <div class="image_box col-lg-4 col-xs-4">
            <img src="${item.imgAddress}" alt="item_image_small">
              </div>
              <p class="col-lg-4 col-xs-5 text-center">${item.name} <br> ${item.stage}</p>
              <p class="col-lg-4 col-xs-5 text-center">수익률  ${Math.round((item.price - (item.cost/item.quantity))/(item.cost/item.quantity))}% <br> 현재가 ${item.price}</p>
            </div>
          </a>
        `
        li.insertAdjacentHTML('afterbegin',textNode);
        itemUl.appendChild(li);
      }
    }
  }

  updateItemDetail = (item) => {
    let itemContent = document.querySelector('.item_detail');
    itemContent.remove();

    //유닉스 시간변환
    const UnixTimestamp = (t) => {
      const date = new Date(t);
      const year = date.getFullYear();
      const month = "0" + (date.getMonth() + 1);
      const day = "0" + date.getDate()
      return year + "-" + month.substr(-2) + "-" + day.substr(-2); 
    }

    const row = document.querySelector('.item_box > .row');
    const div = document.createElement('div');
    
    div.className = 'item_detail col-lg-7 col-xs-7';
    //if로 스테이지 쪼갤거임.
    let textNode = `
    <form class='enroll_form' enctype="multipart/form-data">
      <div class="item_image">
        <div class='image_form'>
          <div>
            <label for="image_uploads">첨부할 사진을 올려주세요 (click!)</label>
            <input type="file" id="image_uploads" name="img" accept=".jpg, .jpeg, .png" multiple>
          </div>
          <div class="preview">
            <img src="${item.imgAddress}" alt="detail_image">
          </div>
        </div>
      </div>
      <div class="item_container">
        <div class="row item_info">
          <p class="name">상품명</p>
          <input type="text" name="name" value="${item.name}">
        </div>
        <div class="row item_info">
          <p class="cost">가격 $</p>
          <input type="text" name="cost" value="${item.cost}">
        </div>
        <div class="row item_info">
          <p class="piece">조각</p>
          <input type="text" name="quantity" value="${item.quantity}">
        </div>
        <div class="row item_info">
          <p class="stage">stage</p>
          <select name="stage">
            <option value="${item.stage}">${item.stage}</option>
            <option value="unopen">UNOPEN</option>
            <option value="open">OPEN</option>
            <option value="trade">TRADE</option>
            <option value="clear">CLEAR</option>
          </select>
        </div>
        <div class="row item_info">
          <p class="code">code</p>
          <input type="text" name="code" value="${item.code}">
        </div>
        <div class="row item_info">
          <p class="category">종류</p>
          <input type="text" name="category" value="${item.category}">
        </div>
        <div class="row item_info">
          <p class="clearing">Open</p>
          <input type="date" name="openingDate" value="${UnixTimestamp(item.openingDate)}">
        </div>
        <div class="row item_info">
          <p class="ipo">IPO</p>
          <input type="date" name="ipoDate" value="${UnixTimestamp(item.ipoDate)}">
        </div>
        <div class="row item_info">
        <p class="clearing">Clearing</p>
          <input type="date" name="clearingDate" value="${UnixTimestamp(item.clearingDate)}">
        </div>
        <div class="row item_info">
          <textarea class="item_Description" name="description" placeholder='${item.description}'></textarea>
        </div>
        <div class="row item_info">
          <input type="submit" class="btn btn-outline-info update_item" value="수정"></input>
          <input type="submit" class="btn btn-outline-info delete_item" value="삭제"></input>
        </div>
      </form>
    </div>
    `
    div.insertAdjacentHTML('afterbegin', textNode);
    row.appendChild(div);
  }

  BindUpdateItem = (callback) => {
    this.updateItem = document.querySelector('.update_item');
    if ( !this.updateItem ) {
      
    } else {
      this.formData = document.querySelector('.enroll_form')
      this.updateItem.addEventListener('click', callback);
    }
    
  } 
  BindDeleteItem = (callback) => {
    this.deleteItem = document.querySelector('.delete_item');
    if ( !this.deleteItem ) {
      
    } else {
      this.deleteItem.addEventListener('click', callback);
    }
    
  }

  BindInputButton = (callback) => {
    this.inputBtn = document.querySelector('#image_uploads');
    if( !this.inputBtn ) {
      
    } else {
      this.previewImage = document.querySelector('.preview');
      this.inputBtn.addEventListener('change', callback);
    }
    
  }
  
  BindLogoutButton = (callback) => {
    this.logout = document.querySelector('.logout');
    this.logout.addEventListener('click', callback);
  }
}