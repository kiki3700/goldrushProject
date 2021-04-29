import UserInfoView from './userInfo.view.js';
import UserInfoModel from './userInfo.model.js'

export default class UserInfoController {
  constructor() {
    this.view = new UserInfoView();
    this.model = new UserInfoModel();
  }
  total = () => {

  } 
}