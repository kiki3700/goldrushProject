import QnaView from './qna.view.js';
import QnaModel from './qna.model.js';

export default class QnaController {
  constructor() {
    this.view = new QnaView();
    this.model = new QnaModel();
  }
  total = () => {
    this.view.BindLogoutButton(this.clickLogout);

    
  }
  clickLogout = () => {
    window.localStorage.removeItem('userInfo');
  }
}