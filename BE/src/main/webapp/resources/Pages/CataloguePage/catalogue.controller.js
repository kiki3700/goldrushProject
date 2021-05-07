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
    this.hash = window.location.hash.match(/[0-9]*$/)[0];
    if ( !this.hash ){
      return '시작페이지'  
    } else {
      this.item = await callback(window.location.hash.match(/[0-9]*$/)[0]);
      console.log(this.item);
      this.view.makeMainContent(this.item);
    }
    
  }
  //total은 ㄹㅇ 짬통인가영... 렌더후에 돌아가니, 참 뭐든 넣기 좋아용.
  total = async() => {

    if (window.location.hash.match('open')) {
      this.view.totalButton.classList.remove('selected');
      this.view.ipoButton.classList.add('selected');
      
    } else if (window.location.hash.match('trade')) {
      this.view.totalButton.classList.remove('selected');
      this.view.tradingButton.classList.add('selected');
      
    } else if (window.location.hash.match('clear')) {
      this.view.totalButton.classList.remove('selected');
      this.view.clearingButton.classList.add('selected');
      
    } else {
      this.view.totalButton.classList.add('selected');
      
    }
    
    await this.getlist(this.model.GetItemList);
    await this.getItem(this.model.GetItem);

    this.view.BindLogoutButton(this.clickLogout);
  }

  clickLogout = () => {
    console.log('작동이 왜 앙대?')
    window.localStorage.removeItem('userInfo');
  }

}