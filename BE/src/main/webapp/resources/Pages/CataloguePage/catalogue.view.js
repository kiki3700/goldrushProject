import catalogue from './catalogue.js'


export default class CatalogueView{
  constructor() {
    this.view = catalogue;
    this.body = document.querySelector('body');
    this.css = document.querySelector('.css_part');
  }

  render = () => {
    const root = document.querySelector('#root');
    root.remove();
    const newRoot = document.createElement('div');
    newRoot.setAttribute('id', 'root');
    this.body.appendChild(newRoot);
    this.css.setAttribute('href', 'Pages/CataloguePage/catalogue.css');
    newRoot.insertAdjacentHTML('afterbegin', this.view);
    
    this.buyButton = document.querySelector('.buy_btn');
    this.sellButton = document.querySelector('.sell_btn');
    
    const user = JSON.parse(window.localStorage.getItem('userInfo'));
    this.welcome = document.querySelector('.welcome');
    this.welcome.innerHTML = `환영합니다! ${user.name}님!`;
    
    this.totalButton = document.querySelector('.total_list');
    this.ipoButton = document.querySelector('.IPO_list');
    this.tradingButton = document.querySelector('.Trading_list');
    this.clearingButton = document.querySelector('.Clearing_list');
  }
  
  makeList = (list) => {
    let itemUl = document.querySelector('.item_ul');
    
    if ( !window.location.hash.match(/\/[a-zA-z]+/) ) {
      for (var item of list) {
        console.log('item : ', item);
        if (item.stage !== 'unopen') {
          let li = document.createElement('li');
          li.className = 'item_li';
          let textNode = `
            <a href = '#catalogue/${item.itemsId}'>
              <div class="row item_small">
              <div class="image_box col-lg-4 col-xs-4">
              <img src="/css/img/item_small_noback.png" alt="item_image_small">
                </div>
                <p class="col-lg-4 col-xs-5 text-center">${item.name} <br> ${item.stage}</p>
                <p class="col-lg-4 col-xs-5 text-center">수익률  ${Math.round((item.price - (item.cost/item.quantity))/(item.cost/item.quantity))}% <br> 현재가 ${item.price}</p>
              </div>
            </a>
          `
          li.insertAdjacentHTML('afterbegin', textNode);
          itemUl.appendChild(li);
        }
      }
    } else {
      let condition = window.location.hash.match(/\/\w+/)[0].substr(1);
      for (const item of list) {
        if (item.stage === condition) {
          console.log('조건을 봐요!', condition);
          let li = document.createElement('li');
          li.className = 'item_li';
          let textNode = `
            <a href = '#catalogue/${condition}/${item.itemsId}'>
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
    
  }
  
  makeMainContent = (item) => {
    let itemContent = document.querySelector('.item_detail');
    itemContent.remove();
    const row = document.querySelector('.item_box > .row');
    const div = document.createElement('div');
    let textNode = ``;
    div.className = 'item_detail col-lg-7 col-xs-7';
    //if로 스테이지 쪼갤거임.
    console.log(item);
    if (item.stage === "open") {
      textNode = `
    <div style="overflow:auto; width:100%; height: 100%;">
      <div class="row contract">
        <button class="btn btn-lg col-lg-8 col-xs-8 pull-left contract_btn"> 청약 </button>
      </div>  
      <div style="overflow:auto; width:100%; height: 69vh;">
        <div class="item_image">
          <img src="/css/img/item.jpg" alt="detail_image">
        </div>
        <div class="item_container">
          <div class="row item_info item_name text-center">
            <p class="col-lg-6 col-xs-6">상품 이름</p>
            <p class="col-lg-6 col-xs-6">${item.name} </p>
          </div>
          <div class="row item_info item_price text-center">
            <p class="col-lg-6 col-xs-6">상품 가격</p>
            <p class="col-lg-6 col-xs-6">$${item.cost}</p>
          </div>
          <div class="row item_info item_piece text-center">
            <p class="col-lg-6 col-xs-6">상품 조각</p>
            <p class="col-lg-6 col-xs-6">${item.quantity}</p>
          </div>
          <div class="row item_info item_piece_price text-center" >
            <p class="col-lg-6 col-xs-6">공모가</p>
            <p class="col-lg-6 col-xs-6">$${item.cost / item.quantity}</p>
          </div>
          <div class="row item_info item_explain text-center">
            <p class="col-lg-12">
              ${item.description}
          </div>
          <div class="chart">
            <h1>차트가 들어갈 공간입니다.</h1>
          </div>
        </div>
      </div>
    </div>
    `
    } else if (item.stage === "trade") {
      textNode = `
    <div style="overflow:auto; width:100%; height: 100%;">
      <div class="row contract">
        <button class="btn btn-lg col-lg-4 col-xs-4 pull-left buy_btn" onclick="location.href='#buy/${item.itemsId}'"> 매도 </button> 사는 가격 : $${item.buyOffer}
        <button class="btn btn-lg col-lg-4 col-xs-4 pull-right sell_btn" onclick="location.href='#sell/${item.itemsId}'"> 매수 </button> 파는 가격 : $${item.sellOffer}
      </div>  
      <div style="overflow:auto; width:100%; height: 69vh;">
        <div class="item_image">
          <img src="/css/img/item.jpg" alt="detail_image">
        </div>
        <div class="item_container">
          <div class="row item_info item_name text-center">
            <p class="col-lg-6 col-xs-6">상품 이름</p>
            <p class="col-lg-6 col-xs-6">${item.name} </p>
          </div>
          <div class="row item_info item_price text-center">
            <p class="col-lg-6 col-xs-6">상품 가격</p>
            <p class="col-lg-6 col-xs-6">$${item.cost}</p>
          </div>
          <div class="row item_info item_piece text-center">
            <p class="col-lg-6 col-xs-6">상품 조각</p>
            <p class="col-lg-6 col-xs-6">${item.quantity}</p>
          </div>
          <div class="row item_info item_piece_price text-center" >
            <p class="col-lg-6 col-xs-6">현재가</p>
            <p class="col-lg-6 col-xs-6">$${item.price}</p>
          </div>
          <div class="row item_info item_explain text-center">
            <p class="col-lg-12">
              ${item.description}
          </div>
          <div class="chart">
            <h1>차트가 들어갈 공간입니다.</h1>
          </div>
        </div>
      </div>
    </div>
    `
    } else {
      textNode = `
    <div style="overflow:auto; width:100%; height: 100%;">
      <div class="row contract">
        <button class="btn btn-lg col-lg-4 col-xs-4 pull-left buy_btn" onclick="location.href='#buy/${item.itemsId}'" disabled> 매도 </button>
        <button class="btn btn-lg col-lg-4 col-xs-4 pull-right sell_btn" onclick="location.href='#sell/${item.itemsId}'" disabled> 매수 </button>
      </div>  
      <div style="overflow:auto; width:100%; height: 69vh;">
        <div class="item_image">
          <img src="/css/img/item.jpg" alt="detail_image">
        </div>
        <div class="item_container">
          <div class="row item_info item_name text-center">
            <p class="col-lg-6 col-xs-6">상품 이름</p>
            <p class="col-lg-6 col-xs-6">${item.name} </p>
          </div>
          <div class="row item_info item_price text-center">
            <p class="col-lg-6 col-xs-6">상품 가격</p>
            <p class="col-lg-6 col-xs-6">$${item.cost}</p>
          </div>
          <div class="row item_info item_piece text-center">
            <p class="col-lg-6 col-xs-6">상품 조각 지울거임</p>
            <p class="col-lg-6 col-xs-6">${item.quantity}</p>
          </div>
          <div class="row item_info item_piece_price text-center" >
            <p class="col-lg-6 col-xs-6">조각 당 가격 => 팔린가격</p>
            <p class="col-lg-6 col-xs-6">$${item.cost / item.quantity}</p>
          </div>
          <div class="row item_info item_explain text-center">
            <p class="col-lg-12">
              ${item.description}
          </div>
          <div class="chart">
            <h1>차트가 들어갈 공간입니다.</h1>
          </div>
        </div>
      </div>
    </div>
    `
    }
    
    div.insertAdjacentHTML('afterbegin', textNode);
    row.appendChild(div);
  }

  BindLogoutButton = (callback) => {
    this.logout = document.querySelector('.logout');
    this.logout.addEventListener('click', callback);
  }
}
