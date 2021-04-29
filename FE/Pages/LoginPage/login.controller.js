import LoginModel from './login.model.js'
import LoginView from './login.view.js'

export default class LoginController {
  constructor() {
    this.model = new LoginModel();
    this.view = new LoginView();
    
  }
  total = () => {
    this.view.BindLoginButton(this.clickLogin);
    this.view.BindFindButton(this.clickFind);
    this.view.BindSocialLoginButton(this.clickSocial);
  }
  clickLogin = () => {
    console.log('login');
  }
  clickFind = () => {
    console.log('id_pwd_find');
  }
  clickSocial = () => {
    console.log('social_login');
  }
}
