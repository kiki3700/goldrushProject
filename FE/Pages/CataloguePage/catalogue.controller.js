import CatalogueView from './catalogue.view.js'
import CatalogueModel from './catalogue.model.js'

export default class CatalogueController{
  constructor() {
    this.model = new CatalogueModel();
    this.view = new CatalogueView();
  }
  total = () => {
    this.view.BindBuyButton(this.clickBuy);
    this.view.BindSellButton(this.clickSell);
    this.view.BindItemButton(this.clickItem);
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