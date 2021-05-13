import BuyView from './buy.view.js'
import BuyModel from './buy.model.js'

export default class CatalogueController{
  constructor() {
    
    this.model = new BuyModel();
    this.view = new BuyView();
  }

  total = async() => {
    const itemsId = Number(location.hash.match(/[0-9]*$/)[0]);
    
    
    const userId = JSON.parse(localStorage.getItem('userInfo'));
    
    let reserveCount = 0;
    
    const portfolio = await this.model.GetPortfolio(userId.membersId);
    const offer = await this.model.GetOfferList(itemsId);
    const item = await this.model.GetItem(itemsId);
    
    portfolio.forEach(reserve => {
      if (reserve.name === item.name){
        reserveCount = reserve.quantity;
      }
    })

    await this.view.BindItemName(item);
    await this.view.BindList(offer);
    await this.view.BindReserveItem(reserveCount);
    this.view.CheckAmount(this.check);
    this.view.BindTradeButton(this.sellButton);
    this.view.BindOfferButton(this.offerButton);
    
    this.view.BindLogoutButton(this.clickLogout);
  }

  check = () => {
    const limit = Number(this.view.limit.innerHTML);
    let amount = Number(this.view.count.value);
    if ( !limit ) {
      return alert('수량이 없습니다!');
    } else if (limit < amount) {
      this.view.count.value = '';
      return alert(`${limit}조각 이상은 처분할 수 없습니다!`);
    }
    
  }
  
  sellButton = async() => {
    const amount = Number(this.view.count.value);
    const user = JSON.parse(localStorage.getItem('userInfo'));
    const price = Number(this.view.sellPrice.innerHTML)
    
    const itemsId = Number(location.hash.match(/[0-9]*$/)[0])
    
    if ( amount < 1) {
      return alert('최소 판매단위는 1입니다.');
    } 
    
    await this.model.PostTradeItem(user.membersId, price, amount, itemsId);
    
    
  }

  offerButton = async() => {
    const price = Number(this.view.offerPrice.value);
    const quantity = Number(this.view.quantity.value);
    const itemsId = Number(location.hash.match(/[0-9]*$/)[0]);
    const user = JSON.parse(localStorage.getItem('userInfo'));

    if ( quantity < 1 || price < 1 ) {
      return alert("가격과 수량의 최소단위는 1입니다.");
    }

    await this.model.PostMakeOffer(user.membersId, itemsId, price, quantity);
    
  }

  clickLogout = () => {
    window.localStorage.removeItem('userInfo');
  }
}