import UserInfoView from './userInfo.view.js';
import UserInfoModel from './userInfo.model.js'

export default class UserInfoController {
  constructor() {
    this.view = new UserInfoView();
    this.model = new UserInfoModel();
  }

  total = async() => {
    const user = JSON.parse(localStorage.getItem('userInfo'));
    
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
    this.view.BindCancelOffer(this.cancel)
    
    this.view.BindfirstPwdForm(this.keyupPwd);
    this.view.BindSecondPwdForm(this.keyupPwd);
    this.view.BindUpdateUser(this.update);
    this.view.BindLogoutButton(this.clickLogout);
  } 
  clickChargeBtn = () => {
    var setCookie = function(name, value, day) {
      var date = new Date();
      date.setTime(date.getTime() + day * 60 * 60 * 24 * 1000);
      document.cookie = name + '=' + value + ';expires=' + date.toUTCString() + ';path=/';
    };
    var deleteCookie = function(name) {
      var date = new Date();
      document.cookie = name + "= " + "; expires=" + date.toUTCString() + "; path=/";
    }
    var getCookie = function(name) {
      var value = document.cookie.match('(^|;) ?' + name + '=([^;]*)(;|$)');
      return value? value[2] : null;
    };
    
    if ( getCookie('membersId') ) {
      deleteCookie('membersId');
    } else {
      
    }

    if ( getCookie('amount') ) {
      deleteCookie('amount');
    } else {
      
    }

    if ( getCookie('withdraw') ) {
      deleteCookie('withdraw');
    } else {
      
    }
    
    const amount = Number(this.view.chargeAmount.value);
    if ( amount < 1000) {
      return alert("최소 충전 단위는 1000원입니다.");
    } else {
      const user = JSON.parse(localStorage.getItem('userInfo'));
    
      setCookie('membersId', user.membersId);
      setCookie('amount', Number(this.view.chargeAmount.value));
      setCookie('withdraw', false);
      
      location.href = 'http://192.168.1.70:8080/bank/oauth';
    }
  
    
  }
  clickDisChargeBtn = () => {
    var setCookie = function(name, value, day) {
      var date = new Date();
      date.setTime(date.getTime() + day * 60 * 60 * 24 * 1000);
      document.cookie = name + '=' + value + ';expires=' + date.toUTCString() + ';path=/';
    };
    var deleteCookie = function(name) {
      var date = new Date();
      document.cookie = name + "= " + "; expires=" + date.toUTCString() + "; path=/";
    }
    var getCookie = function(name) {
      var value = document.cookie.match('(^|;) ?' + name + '=([^;]*)(;|$)');
      return value? value[2] : null;
    };
    
    if ( getCookie('membersId') ) {
      deleteCookie('membersId');
    } else {
      
    }

    if ( getCookie('amount') ) {
      deleteCookie('amount');
    } else {
      
    }
    
    if ( getCookie('withdraw') ) {
      deleteCookie('withdraw');
    } else {
      
    }

    
    const limit = Number(this.view.limitAmount.innerHTML);
    const amount = Number(this.view.chargeAmount.value);
    
    if ( amount > limit ) {
      return alert('잔고보다 많은 돈을 출금할 수는 없습니다.');
    } else if (amount < 1000) {
      return alert('최소 환전 단위는 1000원입니다.');
    } else {
        const user = JSON.parse(localStorage.getItem('userInfo'));
        setCookie('membersId', user.membersId);
        setCookie('amount', Number(this.view.chargeAmount.value));
        setCookie('withdraw', true);
        location.href = 'http://192.168.1.70:8080/bank/oauth';
    }
  }

  cancel = async() => {
    let target;

    this.view.cancelOffer.forEach((item, index) => {
      if (item === event.target) {
        target = this.view.offersId[index]
      }
    })
    const offerId = Number(target.innerHTML);
    
    await this.model.DeleteCancelOffer(offerId);
    location.reload();
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
  
  clickLogout = () => {
    window.localStorage.removeItem('userInfo');
  }
}