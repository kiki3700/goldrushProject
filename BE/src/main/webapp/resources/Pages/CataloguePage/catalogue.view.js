import catalogue from './catalogue.js'


export default class CatalogueView{
  constructor() {
    this.view = catalogue;
    this.body = document.querySelector('body');
    this.css = document.querySelector('.css_part');
  }

  // loading = () => {
    
  //   const loadingpage = document.createElement('div');
    
  //   loadingpage.setAttribute('id', 'loading');
  //   const loading = document.createElement('img');
  //   loading.setAttribute('src', '/css/img/KakaoTalk_Image_2021-05-11-11-13-49.gif');
  //   console.log(root);
  //   console.log(loadingpage);
  //   console.log(loading);
  //   loadingpage.appendChild(loading);
    
  //   this.body.appendChild(loadingpage);
  // }

  // loaded = () => {
  //   const root = document.querySelector('#loading');
  //   root.style.display = 'none';
  // }

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
    
    const UnixTimestamp = (t) => {
      const date = new Date(t);
      const year = date.getFullYear();
      const month = "0" + (date.getMonth() + 1);
      const day = "0" + date.getDate();
      return year + "-" + month.substr(-2) + "-" + day.substr(-2); 
    }

    if ( !window.location.hash.match(/\/[a-zA-z]+/) ) {
      for (var item of list) {
        item.imgAddress = item.imgAddress.slice(0,9) + '/thumbnail' + item.imgAddress.slice(9);
        if (item.stage !== 'unopen' && item.stage !== 'close') {
          let li = document.createElement('li');
          li.className = 'item_li';
          let textNode = `
            <a href = '#catalogue/${item.itemsId}'>
              <div class="row item_small">
                <div class="image_box col-lg-4 col-xs-4">
                  <img src= "${item.imgAddress}" alt="item_image_small">
                </div>
                <div class="content_box">
                  <p class="list_item_price">현재가 : ${item.price}원</p>  
                  <p class="list_item_name">${item.name}</p>
                  <small class="list_item_stage">${item.stage}: ${item.stage === 'open' ? UnixTimestamp(item.ipoDate) : item.stage === 'trade' ? UnixTimestamp(item.clearingDate) : '상품 판매중'}</small>
                </div>
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
          item.imgAddress = item.imgAddress.slice(0,9) + '/thumbnail' + item.imgAddress.slice(9);
          let li = document.createElement('li');
          li.className = 'item_li';
          let textNode = `
            <a href = '#catalogue/${condition}/${item.itemsId}'>
              <div class="row item_small">
                <div class="image_box col-lg-4 col-xs-4">
                  <img src="${item.imgAddress}" alt="item_image_small">
                </div>
                <div class="content_box">
                  <p class="list_item_price">현재가 : ${item.price}원</p>  
                  <p class="list_item_name">${item.name}</p>
                  <small class="list_item_stage">${item.stage}: ${item.stage === 'open' ? UnixTimestamp(item.ipoDate) : item.stage === 'trade' ? UnixTimestamp(item.clearingDate) : '상품 판매중'}</small>
                </div>
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
    
    if (item.stage === "open") {
      textNode = `
    <div style="overflow:auto; width:100%; height: 100%;">
      <div class="row contract">
        <input class="contract_count form-control" type="number" placeholder="청약 개수"/>
        <button class="btn btn-lg col-lg-8 col-xs-8 pull-left contract_btn"> 청약 </button>
      </div>  
      <div style="overflow:auto; width:100%; height: 69vh;">
        <div class="item_image">
          <img src="${item.imgAddress}" alt="detail_image">
        </div>
        <div class="item_container">
          <div class="row item_info item_name text-center">
            <p class="col-lg-6 col-xs-6">상품 이름</p>
            <p class="col-lg-6 col-xs-6">${item.name} </p>
          </div>
          <div class="row item_info item_price text-center">
            <p class="col-lg-6 col-xs-6">상품 가격</p>
            <p class="col-lg-6 col-xs-6">${item.cost}원</p>
          </div>
          <div class="row item_info item_piece text-center">
            <p class="col-lg-6 col-xs-6">상품 남은 조각</p>
            <p class="col-lg-6 col-xs-6">${item.remainingAmount}</p>
          </div>
          <div class="row item_info item_piece text-center">
            <p class="col-lg-6 col-xs-6">상품 전체 조각</p>
            <p class="col-lg-6 col-xs-6">${item.quantity}</p>
          </div>
          <div class="row item_info item_piece_price text-center" >
            <p class="col-lg-6 col-xs-6">공모가</p>
            <p class="col-lg-6 col-xs-6">${item.cost / item.quantity}원</p>
          </div>
          <div class="row item_info item_explain text-center">
            <p class="col-lg-12">
              ${item.description}
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
          <img src="${item.imgAddress}" alt="detail_image">
        </div>
        <div class="item_container">
          <div class="row item_info item_name text-center">
            <p class="col-lg-6 col-xs-6">상품 이름</p>
            <p class="col-lg-6 col-xs-6">${item.name} </p>
          </div>
          <div class="row item_info item_price text-center">
            <p class="col-lg-6 col-xs-6">상품 가격</p>
            <p class="col-lg-6 col-xs-6">${item.cost}원</p>
          </div>
          <div class="row item_info item_piece text-center">
            <p class="col-lg-6 col-xs-6">상품 조각</p>
            <p class="col-lg-6 col-xs-6">${item.quantity}</p>
          </div>
          <div class="row item_info item_piece_price text-center" >
            <p class="col-lg-6 col-xs-6">현재가</p>
            <p class="col-lg-6 col-xs-6">${item.price}원</p>
          </div>
          <div class="row item_info item_explain text-center">
            <p class="col-lg-12">
              ${item.description}
          </div>
        </div>
        <div class="chart">
            <canvas id="canvas"></canvas>
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
          <img src="${item.imgAddress}" alt="detail_image">
        </div>
        <div class="item_container">
          <div class="row item_info item_name text-center">
            <p class="col-lg-6 col-xs-6">상품 이름</p>
            <p class="col-lg-6 col-xs-6">${item.name} </p>
          </div>
          <div class="row item_info item_price text-center">
            <p class="col-lg-6 col-xs-6">상품 가격</p>
            <p class="col-lg-6 col-xs-6">${item.cost}원</p>
          </div>
          <div class="row item_info item_piece text-center">
            <p class="col-lg-6 col-xs-6">상품 조각 지울거임</p>
            <p class="col-lg-6 col-xs-6">${item.quantity}</p>
          </div>
          <div class="row item_info item_piece_price text-center" >
            <p class="col-lg-6 col-xs-6">조각 당 가격 => 팔린가격</p>
            <p class="col-lg-6 col-xs-6">${item.cost / item.quantity}원</p>
          </div>
          <div class="row item_info item_explain text-center">
            <p class="col-lg-12">
              ${item.description}
          </div>
        </div>
      </div>
    </div>
    `
    }
    // 여기에 차트 관련 코드 작성 예정
    
    const UnixTimestamp = (t) => {
      const date = new Date(t);
      const month = "0" + (date.getMonth() + 1);
      const day = "0" + date.getDate();
      
      return month.substr(-2) + "-" + day.substr(-2);
    }
    
    const day = [];
    const price = [];
    item.priceGraph.forEach(item => {
      day.push(UnixTimestamp(item.date));
      price.push(item.price);
    })
    
    div.insertAdjacentHTML('afterbegin', textNode);
    row.appendChild(div);
    this.chart = document.querySelector('#canvas');
    if ( !this.chart ) {
      
    } else {
      const ctx = this.chart.getContext('2d');
      const data = {
          // The type of chart we want to create
          type: 'line',
          // The data for our dataset
          data: {
              labels: day,
              datasets: [{
                  label: "일일 가격변동",
                  backgroundColor: 'rgb(255, 99, 132)',
                  fill:false, // line의 아래쪽을 색칠할 것인가? 
                  borderColor: 'rgb(255, 99, 132)',
                  lineTension:0.1, // 값을 높이면, line의 장력이 커짐.
                  data: price,
              }]
          },
          // Configuration options go here
          options: {}
      }
      const chart = new Chart(ctx, data);
    }
    
  }

  

  BindContractButton = (callback) => {
    this.contractButton = document.querySelector('.contract_btn');
    this.contractInput = document.querySelector('.contract_count');
    if ( !this.contractButton ) {
      
    } else {
      this.contractButton.addEventListener('click', callback);
    }
  }

  BindContractInput = (callback)=> {
    this.eventContractInput = document.querySelector('.contract_count');
    this.leftAmount = document.querySelector('.item_container div:nth-child(3) p:nth-child(2)');
    
    if ( !this.leftAmount ){
      
    } else {
      this.leftAmount = Number(this.leftAmount.innerHTML);
    }
    
    
    if ( !this.eventContractInput ) {
      
    } else {
      
      this.eventContractInput.addEventListener('keyup', callback);
    }
    
  }

  BindLogoutButton = (callback) => {
    this.logout = document.querySelector('.logout');
    this.logout.addEventListener('click', callback);
  }
}
