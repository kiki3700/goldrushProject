import CatalogueView from './catalogue.view.js'
import CatalogueModel from './catalogue.model.js'

export default class CatalogueController{
  constructor() {
    this.model = new CatalogueModel();
    this.view = new CatalogueView();
    
  }
  //total은 ㄹㅇ 짬통인가영... 렌더후에 돌아가니, 참 뭐든 넣기 좋아용.
  total = () => {
    this.view.BindBuyButton(this.clickBuy);
    this.view.BindSellButton(this.clickSell);
    this.view.BindItemButton(this.clickItem);

    if (window.location.hash.match('IPO')) {
      this.view.totalButton.classList.remove('selected');
      this.view.ipoButton.classList.add('selected');
    } else if (window.location.hash.match('Trading')) {
      this.view.totalButton.classList.remove('selected');
      this.view.tradingButton.classList.add('selected');
    } else if (window.location.hash.match('Clearing')) {
      this.view.totalButton.classList.remove('selected');
      this.view.clearingButton.classList.add('selected');
    } else {
      this.view.totalButton.classList.add('selected');
    }
    

  }

  clickBuy = () => {
    console.log('매수버튼을 누름.')
  }
  clickSell = () => {
    console.log('매도버튼을 누름');
  }
  clickItem = () => {
    console.log(event.target);
  }

}