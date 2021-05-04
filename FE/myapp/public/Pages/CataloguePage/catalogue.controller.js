import CatalogueView from './catalogue.view.js'
import CatalogueModel from './catalogue.model.js'

export default class CatalogueController{
  constructor() {
    console.log('컨트롤러 생성자');
    this.model = new CatalogueModel();
    this.view = new CatalogueView();

    
  }

  getlist = async(callback) => {
    // console.log(await callback());
    console.log('list 생성');
    this.list = await callback();
    this.view.makeList(this.list);
  }

  getItem = async(callback) => {
    console.log('item 생성');
    this.item = await callback(window.location.hash.match(/[0-9]*$/)[0] || 1);
    this.view.makeMainContent(this.item);
  }
  //total은 ㄹㅇ 짬통인가영... 렌더후에 돌아가니, 참 뭐든 넣기 좋아용.
  total = async() => {
    
    await this.getlist(this.model.GetItemList);
    await this.getItem(this.model.GetItem)

    this.view.BindBuyButton(this.clickBuy);
    this.view.BindSellButton(this.clickSell);
    this.view.BindLogoutButton(this.clickLogout);
    
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
  clickLogout = () => {
    window.localStorage.removeItem('userInfo');
  }

}