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
    this.item = document.querySelectorAll('.item_li');

    this.totalButton = document.querySelector('.total_list');
    this.ipoButton = document.querySelector('.IPO_list');
    this.tradingButton = document.querySelector('.Trading_list');
    this.clearingButton = document.querySelector('.Clearing_list');
  }

  BindBuyButton = (callback) => {
      this.buyButton.addEventListener('click', callback);
  }
  BindSellButton = (callback) => {
    this.sellButton.addEventListener('click', callback);
  }
  BindItemButton = (callback) => {
    this.item.forEach(e => e.addEventListener('click', callback));
  }
  BindTotalButton = (callback) => {
    this.totalButton.addEventListener('click', callback);
  }
  BindIpoButton = (callback) => {
    this.ipoButton.addEventListener('click', callback);
  }
  BindTradingButton = (callback) => {
    this.tradingButton.addEventListener('click', callback);
  }
  BindClearingButton = (callback) => {
    this.clearingButton.addEventListener('click', callback);
  }
}
