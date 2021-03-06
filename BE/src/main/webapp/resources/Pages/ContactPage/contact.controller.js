import ContactView from './contact.view.js';
import ContactModel from './contact.model.js';

export default class QnaController {
  constructor() {
    this.view = new ContactView();
    this.model = new ContactModel();

    
  }
  total = () => {
    this.view.BindSubmitButton(this.submitButton);
    this.view.BindLogoutButton(this.clickLogout);

  } 
  submitButton = (e) => {
    e.preventDefault();
    
    alert("제출되었습니다.");
  }
  clickLogout = () => {
    window.localStorage.removeItem('userInfo');
  }
}