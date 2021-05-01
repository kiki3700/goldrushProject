import pBuy from '/templates/p-Buy.js'


class BuyView{
  constructor() {
    this.view = pBuy;
    this.root = document.querySelector('#root');
    this.css = document.querySelector('.css_part');
  }

  render() {
    this.css.setAttribute('href', '/templates/p-main.css');
    this.root.insertAdjacentHTML('afterbegin', this.view);
  }
}

export default BuyView;