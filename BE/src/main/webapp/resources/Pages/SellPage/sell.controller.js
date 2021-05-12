import SellView from './sell.view.js'
import SellModel from './sell.model.js'

export default class CatalogueController{
  constructor() {
    
    this.model = new SellModel();
    this.view = new SellView();
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
    this.view.BindItemName(item);
    this.view.BindList(offer);
    await this.view.BindReserveItem(reserveCount);
    this.view.CheckAmount(this.check);
    this.view.BindTradeButton(this.buyButton);
    this.view.BindOfferButton(this.offerButton);

    this.view.BindLogoutButton(this.clickLogout);
  }

  check = () => {
    const limit = Number(this.view.limit.innerHTML);
    let amount = Number(this.view.count.value);
    if (limit < amount) {
      this.view.count.value = '';
      return alert(`${limit}조각 이상은 확보할 수 없습니다!`);
    }
  }

  buyButton = async() => {
    const amount = Number(this.view.count.value);
    const user = JSON.parse(localStorage.getItem('userInfo'));
    const price = Number(this.view.buyPrice.innerHTML);
    const itemsId = Number(location.hash.match(/[0-9]*$/)[0])
    
    if ( amount < 1 ) {
      return alert("최소 구입단위는 1입니다.")
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