import UserManageView from './userManage.view.js';
import UserManageModel from './userManage.model.js';

export default class QnaController {
  constructor() {
    this.view = new UserManageView();
    this.model = new UserManageModel();
  }
  total = () => {

  } 
}