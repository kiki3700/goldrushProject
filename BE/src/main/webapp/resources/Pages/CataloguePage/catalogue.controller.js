import CatalogueView from './catalogue.view.js'
import CatalogueModel from './catalogue.model.js'

export default class CatalogueController{
  constructor() {
    
    this.model = new CatalogueModel();
    this.view = new CatalogueView();

    
  }

  getlist = async(callback) => {
    
    
    this.list = await callback();
    this.view.makeList(this.list);
  }

  getItem = async(callback) => {
    
    this.hash = window.location.hash.match(/[0-9]*$/)[0];
    if ( !this.hash ){
      return '시작페이지'  
    } else {
      this.item = await callback(window.location.hash.match(/[0-9]*$/)[0]);
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
    this.view.BindContractInput(this.inputNumber);
    this.view.BindContractButton(this.clickContract);
    this.view.BindLogoutButton(this.clickLogout);
  }

  clickLogout = () => {
    window.localStorage.removeItem('userInfo');
  }

  inputNumber = () => {
    let amount = Number(this.view.eventContractInput.value);
    const left = this.view.leftAmount
    if (amount > left) {
      this.view.eventContractInput.value = '';
      alert(`${left} 이상은 구입할 수 없습니다.`);
    }
  }

  clickContract = async() => {
    
    const userInfo = JSON.parse(localStorage.getItem('userInfo'));
    const itemid = location.hash.match(/[0-9]*$/)[0];
    const quantity = Number(this.view.contractInput.value);
    
    await this.model.PostMakeSubscription(userInfo.membersId, itemid, quantity);
    
  }


}