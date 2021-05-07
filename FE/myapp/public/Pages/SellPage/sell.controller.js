import SellView from './sell.view.js'
import SellModel from './sell.model.js'

export default class CatalogueController{
  constructor() {
    console.log('컨트롤러 생성자');
    this.model = new SellModel();
    this.view = new SellView();
  }

  total = async() => {
    const itemsId = Number(location.hash.match(/[0-9]*$/)[0]);
    
    const offer = await this.model.GetOfferList(itemsId);
    const item = await this.model.GetItem(itemsId);
    this.view.BindItemName(item);
    this.view.BindList(offer);
    
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
    console.log('유저 고유번호', user.membersId);
    console.log('사는 양', amount);
    console.log('구입가격', price);
    console.log('아이템 고유번호', itemsId);
    await this.model.PostTradeItem(user.membersId, price, amount, itemsId);
    location.reload()
  }

  offerButton = async() => {
    const price = Number(this.view.offerPrice.value);
    const quantity = Number(this.view.quantity.value);
    const itemsId = Number(location.hash.match(/[0-9]*$/)[0]);
    const user = JSON.parse(localStorage.getItem('userInfo'));

    console.log(price, quantity, itemsId, user.membersId);
    await this.model.PostMakeOffer(user.membersId, itemsId, price, quantity);
    location.reload();
  }

  clickLogout = () => {
    console.log('작동이 왜 앙대?')
    window.localStorage.removeItem('userInfo');
  }
}