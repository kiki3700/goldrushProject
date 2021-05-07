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
    this.view.makeList(this.list);
  }

  getItem = async(callback) => {
    console.log('item 생성');
    this.item = await callback(window.location.hash.match(/[0-9]*$/)[0] || 1);
    this.view.updateItemDetail(this.item);
  }
  
  total = async() => {
    //await this.getlist(this.model.GetItemList);
    //await this.getItem(this.model.GetItem);

    this.view.BindLogoutButton(this.clickLogout);
  }

  clickLogout = () => {
    window.localStorage.removeItem('userInfo');
  }
}