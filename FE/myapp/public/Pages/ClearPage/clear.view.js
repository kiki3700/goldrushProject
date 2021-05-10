import clear from './clear.js'

export default class ClearView{
  constructor() {
    this.view = clear;
    this.body = document.querySelector('body');
    this.css = document.querySelector('.css_part');
  }

  render = () => {
    const root = document.querySelector('#root');
    root.remove();
    const newRoot = document.createElement('div');
    newRoot.setAttribute('id', 'root');
    this.body.appendChild(newRoot);
    this.css.setAttribute('href', 'Pages/ClearPage/clear.css');
    newRoot.insertAdjacentHTML('afterbegin', this.view);

    
  }

  makeClearList = (list) => {
    let itemUl = document.querySelector('.item_ul');
    
    for (var item of list) {
      //리스트 중에서 stage가 clear인 것만 고릅시다.
      if (item.stage === 'clear') {
        let li = document.createElement('li');
        li.className = 'item_li';
        let textNode = `
          <a href = '#clear/${item.itemsId}'>
            <div class="row item_small">
            <div class="image_box col-lg-4 col-xs-4">
            <img src="/css/img/item_small_noback.png" alt="item_image_small">
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
    // 적절히 수정필요 => 청산시 청산 금액만 추가하도록
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
      <div class="item_image">
        <div class="preview">
          <p>상품이미지</p>
        </div>
      </div>
      <div class="item_container">
        <div class="row item_info">
          <p class="name">상품명</p>
          <input type="text" name="name" value="${item.name}" disabled>
        </div>
        <div class="row item_info">
          <p class="cost">가격 $</p>
          <input type="text" name="cost" value="${item.cost}" disabled>
        </div>
        <div class="row item_info">
          <p class="piece">유통 중 조각</p>
          <input type="text" name="quantity" value="${item.quantity - item.remainingAmount}" disabled>
        </div>
        <div class="row item_info">
          <p class="code">code</p>
          <input type="text" name="code" value="${item.code}" disabled>
        </div>
        <div class="row item_info">
          <p class="clearing">Clearing</p>
          <input type="date" name="clearingDate" value="${UnixTimestamp(item.clearingDate)}" disabled>
        </div>
        <div class="row item_info">
        <p class="clearing">청산가격</p>
          <input type="number" class="clear_price" value="여기에 가격 널거임"></input>
        </div>
        <div class="row item_info">
          <input type="submit" class="btn btn-outline-info delete_item" value="청산"></input>
        </div>
    </div>
    `
    div.insertAdjacentHTML('afterbegin', textNode);
    row.appendChild(div);
  }

  BindClearBtn = (callback) => {
    this.clearBtn = document.querySelector('.btn');
    this.nowPrice = document.querySelector('.clear_price');
    if ( !this.clearBtn ) {
      console.log('클리어버튼없어오!');
    } else {
      this.clearBtn.addEventListener('click', callback);
    }
    
  }

  BindLogoutButton = (callback) => {
    this.logout = document.querySelector('.logout');
    
    this.logout.addEventListener('click', callback);
  }
}