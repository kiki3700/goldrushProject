import ClearView from './clear.view.js'
import ClearModel from './clear.model.js'

export default class ManagerController{
  constructor() {
    this.model = new ClearModel();
    this.view = new ClearView();
  }

  getlist = async(callback) => {
    // console.log(await callback());
    console.log('list 생성');
    this.list = await callback();
    this.view.makeClearList(this.list);
  }

  getItem = async(callback) => {
    console.log('item 생성');
    this.hash = window.location.hash.match(/[0-9]*$/)[0];
    if ( !this.hash ){
      return '시작페이지'  
    } else {
      this.item = await callback(window.location.hash.match(/[0-9]*$/)[0]);
      console.log(this.item);
      this.view.updateItemDetail(this.item);
    }
  }
  
  total = async() => {
    await this.getlist(this.model.GetItemList);
    await this.getItem(this.model.GetItem);

    this.view.BindLogoutButton(this.clickLogout);
    this.view.BindClearBtn(this.clear);
  }

  clear = () => {
    console.log(this.view.nowPrice.value);
    const itemid = Number(location.hash.match(/[0-9]*$/)[0]);
    const nowPrice = Number(this.view.nowPrice.value);
    console.log(itemid, nowPrice);
    console.log(event.target);
  }

  clickLogout = () => {
    window.localStorage.removeItem('userInfo');
  }
}