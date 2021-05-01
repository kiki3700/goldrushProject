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
  clickLogin = async() => {
    const mail = this.view.loginMail.value;
    const pwd = this.view.loginPwd.value;
    if ( !mail ) {
      return alert('메일을 작성해주십시오.');
    } else if ( !pwd ) {
      return alert('비밀번호를 작성해주십시오.');
    } else {
      const result = await this.model.PostLogin(mail, pwd);
      
    }
  }
  clickFind = () => {
    console.log('id_pwd_find');
  }
  clickSocial = () => {
    console.log('social_login');
  }
}
