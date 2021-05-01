import pLogin from './login.js'

class LoginView{
  constructor() {
    this.view = pLogin;
    this.body = document.querySelector('body');
    this.css = document.querySelector('.css_part');
  }
  render = () => {
    const root = document.querySelector('#root');
    root.remove();
    const newRoot = document.createElement('div');
    newRoot.setAttribute('id', 'root');
    this.body.appendChild(newRoot);
    this.css.setAttribute('href', 'Pages/LoginPage/login.css');
    newRoot.insertAdjacentHTML('afterbegin', this.view);
    //이벤트 달아줄 요소 선택하기
    this.loginButton = document.querySelector('.form_login');
    this.findButton = document.querySelector('.find_id_pwd');
    this.socialLoginButton = document.querySelector('.social_login'); 
  }
  
  BindLoginButton = (callback) => {
    this.loginMail = document.querySelector('.input_id');
    this.loginPwd = document.querySelector('.input_password');
    this.loginButton.addEventListener('click', callback);
  }
  BindFindButton = (callback) => {
    this.findButton.addEventListener('click', callback);
  }
  BindSocialLoginButton = (callback) => {
    this.socialLoginButton.addEventListener('click', callback);
  }

}

export default LoginView;