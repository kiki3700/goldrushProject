import buy from './buy.js'

export default class BuyView {
  constructor() {
    this.view = buy;
    this.body = document.querySelector('body');
    this.css = document.querySelector('.css_part');
  }

  render = () => {
    const root = document.querySelector('#root');
    root.remove();
    const newRoot = document.createElement('div');
    newRoot.setAttribute('id', 'root');
    this.body.appendChild(newRoot);
    this.css.setAttribute('href', 'Pages/BuyPage/buy.css');
    newRoot.insertAdjacentHTML('afterbegin', this.view);

    const user = JSON.parse(window.localStorage.getItem('userInfo'));
    this.welcome = document.querySelector('.welcome');
    this.welcome.innerHTML = `환영합니다! ${user.name}님!`;
  }

  BindItemName = (item) => {
    this.itemName = document.querySelector('.service h1');
    this.itemName.innerHTML = `${item.name} : 매수 장터`;
  }

  BindReserveItem = (count) => {
    this.reserveCount = document.querySelector('.reserve_item');
    this.reserveCount.value = `보유량 : ${count}`;
  }

  BindLogoutButton = (callback) => {
    this.logout = document.querySelector('.logout');
    this.logout.addEventListener('click', callback);
  }

  BindList = (offer) => {
    this.table = document.querySelector('.table tbody');
    
    let textNode = '';
    
    for (const item of offer) {
      textNode += `
        <tr>
          <td>${item.price}</td>
          <td>${item.quantity}</td>
        </tr>
      `  
    }

    this.table.insertAdjacentHTML('afterbegin', textNode);
  }
  
  CheckAmount = (callback) => {
    this.count = document.querySelector('.sell_item input');
    this.limit = document.querySelector('tbody tr:first-child td:nth-child(2)');
    this.count.addEventListener('keyup', callback);
  }
  
  BindTradeButton = (callback) => {
    this.count = document.querySelector('.sell_item input');
    this.buyButton = document.querySelector('.sell_item button');
    this.sellPrice = document.querySelector('tbody tr:first-child td:nth-child(1)');
    if ( !this.sellPrice ) {
    
    } else {
    
      this.buyButton.addEventListener('click', callback);
    }
  }

  BindOfferButton = (callback) => {
    this.offerPrice = document.querySelector('.buy_offer input:first-child');
    this.quantity = document.querySelector('.buy_offer input:nth-child(2)');
    this.offerButton = document.querySelector('.buy_offer button');
    this.offerButton.addEventListener('click', callback);
  
  }
}

