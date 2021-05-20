import sell from './sell.js'

export default class sellView {
  constructor() {
    this.view = sell;
    this.body = document.querySelector('body');
    this.css = document.querySelector('.css_part');
  }

  render = () => {
    const root = document.querySelector('#root');
    root.remove();
    const newRoot = document.createElement('div');
    newRoot.setAttribute('id', 'root');
    this.body.appendChild(newRoot);
    this.css.setAttribute('href', 'Pages/SellPage/sell.css');
    newRoot.insertAdjacentHTML('afterbegin', this.view);
    
    const user = JSON.parse(window.localStorage.getItem('userInfo'));
    this.welcome = document.querySelector('.welcome');
    this.welcome.innerHTML = `환영합니다! ${user.name}님!`;
  }

  BindItemName = (item) => {
    this.itemName = document.querySelector('.service h1');
    this.itemName.innerHTML = `${item.name} : 매도 장터`;
  }

  BindReserveItem = (count) => {
    this.reserveCount = document.querySelector('.reserve_item');
    
    this.reserveCount.value = `보유량 : ${count}`;
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
    this.count = document.querySelector('.buy_item input');
    this.limit = document.querySelector('tbody tr:first-child td:nth-child(2)');
    this.count.addEventListener('keyup', callback);
  }
  
  BindTradeButton = (callback) => {
    this.count = document.querySelector('.buy_item input');
    this.buyButton = document.querySelector('.buy_item button');
    this.buyPrice = document.querySelector('tbody tr:first-child td:nth-child(1)');
    this.buyButton.addEventListener('click', callback);
  }

  BindOfferButton = (callback) => {
    this.offerPrice = document.querySelector('.sell_offer input:first-child');
    this.quantity = document.querySelector('.sell_offer input:nth-child(2)');
    this.offerButton = document.querySelector('.sell_offer button');
    this.offerButton.addEventListener('click', callback);
    
  }

  BindLogoutButton = (callback) => {
    this.logout = document.querySelector('.logout');
    this.logout.addEventListener('click', callback);
  }
}

