import UserInfoView from './userInfo.view.js';
import UserInfoModel from './userInfo.model.js'

export default class UserInfoController {
  constructor() {
    this.view = new UserInfoView();
    this.model = new UserInfoModel();
  }

  total = async() => {
    const user = JSON.parse(localStorage.getItem('userInfo'));
    console.log(user.membersId);
    console.log(typeof(user.membersId));
    const portfolio = await this.model.GetPortfolio(user.membersId);
    // const tradeLog = await this.model.GetTradeLog(user.membersId);
    const offerLog = await this.model.GetOfferLog(user.membersId);
    const accountLog = await this.model.GetAccountLog(user.membersId);
    
    //console.log(tradeLog);
    

    this.view.BindPortfolio(portfolio);
    this.view.BindOfferList(offerLog);
    this.view.BindAccountList(accountLog);
    this.view.BindChargeButton(this.clickChargeBtn);
    this.view.BindDischargeButton(this.clickDisChargeBtn);
    this.view.BindMailForm(this.keyupMail);
    this.view.BindfirstPwdForm(this.keyupPwd);
    this.view.BindSecondPwdForm(this.keyupPwd);
    this.view.BindUpdateUser(this.update);
    this.view.BindLogoutButton(this.clickLogout);
  } 
  clickChargeBtn = () => {
    console.log('입금버튼이 눌렸다.');
  }
  clickDisChargeBtn = () => {
    console.log('출금버튼이 눌렸다.');
  }
  keyupMail = () => {
    console.log(event.target.value);
    //데이터 받아와서 
    if (1) {
      this.view.checkEmail.innerHTML = '수정가능한 이메일입니다.';
    } else {
      this.view.checkEmail.innerHTML = '이미 있는 이메일입니다.';
    }
    
  }
  keyupPwd = () => {
    if (this.view.firstPwdForm.value === this.view.secondPwdForm.value) {
      this.view.checkPwd.innerHTML = '비밀번호가 일치합니다.';
      this.view.updateUser.removeAttribute('disabled');
    } else {
      this.view.checkPwd.innerHTML = '비밀번호가 불일치합니다.';
      this.view.updateUser.setAttribute('disabled', true);
    }
  }
  update = () => {
    console.log('수정버튼이 눌렸다.');
  }
  clickLogout = () => {
    window.localStorage.removeItem('userInfo');
  }
}