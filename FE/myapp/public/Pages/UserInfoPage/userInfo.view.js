import userInfo from './userInfo.js'


export default class UserInfoView{
  constructor() {
    this.view = userInfo;
    this.body = document.querySelector('body');
    this.css = document.querySelector('.css_part');
  }

  render = () => {
    const root = document.querySelector('#root');
    root.remove();
    const newRoot = document.createElement('div');
    newRoot.setAttribute('id', 'root');
    this.body.appendChild(newRoot);
    this.css.setAttribute('href', 'Pages/UserInfoPage/userInfo.css');
    newRoot.insertAdjacentHTML('afterbegin', this.view);

    this.chargeButton = document.querySelector('.charge_money');
    this.dischargeButton = document.querySelector('.discharge_money');
    this.mailForm = document.querySelector('#emailcheck');
    this.firstPwdForm = document.querySelector('#pwdcheck');
    this.secondPwdForm = document.querySelector('#pwd_double_check');
    this.checkEmail = document.querySelector('.check_email')
    this.checkPwd = document.querySelector('.check_pwd');
    this.updateUser = document.querySelector('.update_user');
  }
  BindChargeButton = (callback) => {
    this.chargeButton.addEventListener('click', callback);
  }
  BindDischargeButton = (callback) => {
    this.dischargeButton.addEventListener('click', callback);
  }
  BindMailForm = (callback) => {
    this.mailForm.addEventListener('keyup', callback);
  }
  BindfirstPwdForm = (callback) => {
    this.firstPwdForm.addEventListener('keyup', callback);
  }
  BindSecondPwdForm = (callback) => {
    this.secondPwdForm.addEventListener('keyup', callback);
  }
  BindUpdateUser = (callback) => {
    this.updateUser.addEventListener('click', callback);
  }
}