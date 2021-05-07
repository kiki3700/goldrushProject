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

    const user = JSON.parse(window.localStorage.getItem('userInfo'));
    this.welcome = document.querySelector('.welcome');
    this.welcome.innerHTML = `환영합니다! ${user.name}님!`;

    this.chargeButton = document.querySelector('.charge_money');
    this.dischargeButton = document.querySelector('.discharge_money');
    this.mailForm = document.querySelector('#emailcheck');
    this.firstPwdForm = document.querySelector('#pwdcheck');
    this.secondPwdForm = document.querySelector('#pwd_double_check');
    this.checkEmail = document.querySelector('.check_email')
    this.checkPwd = document.querySelector('.check_pwd');
    this.updateUser = document.querySelector('.update_user');
  }

  BindPortfolio = (portfolio) => {
    
    this.portfolioBody = document.querySelector('.portfolio_table tbody');
    this.portfolioFoot = document.querySelector('.portfolio_table tfoot');
    //total에 들어갈 요소는 추후 계산 예정.
    let tableNode = '';
    let totalAverage = 0;
    let totalPrice = 0;
    let totalAmount = 0;
    let totalRateOfReturn = 0;
    let count = 0;
    for(const item of portfolio) {
      tableNode += `
      <tr>
        <th scope="row">${item.name}</th>
        <td>$${item.averagePrice}</td>
        <td>$${item.price}</td>
        <td>${item.quantity}조각</td>
        <td>${item.rateOfReturn.toFixed(2)}%</td>
      </tr>
      `
      totalAverage += item.averagePrice;
      totalPrice += item.price;
      totalAmount += item.quantity;
      totalRateOfReturn += item.rateOfReturn;
      count++;
    }

    const tableFootNode = `
    <tr>
      <th scope="row">total</th>
      <td>$${totalAverage}</td>
      <td>$${totalPrice}</td>
      <td>${totalAmount}조각</td>
      <td>${(totalRateOfReturn / count).toFixed(2)}%</td>
    </tr>
    `
    
    this.portfolioBody.insertAdjacentHTML('afterbegin', tableNode);  
    this.portfolioFoot.insertAdjacentHTML('afterbegin', tableFootNode);


  }

  BindOfferList = (offer) => {
    this.offerBody = document.querySelector('.offer_log tbody');
    
    //시간등록
    const UnixTimestamp = (t) => {
      const date = new Date(t);
      const year = date.getFullYear();
      const month = "0" + (date.getMonth() + 1);
      const day = "0" + date.getDate();
      const hour = "0" + date.getHours();
      const minute = "0" + date.getMinutes();
      return year + "-" + month.substr(-2) + "-" + day.substr(-2) + " " + hour.substr(-2) + ":" + minute.substr(-2); 
    }
    let tableNode = ``;
    for(const item of offer) {
      tableNode += `
      <tr>
        <th scope="row">${item.name}</th>
        <td>${item.offerPrice}</td>
        <td>${item.quantity}</td>
        <td>${UnixTimestamp(item.timeStamp)}</td>
      </tr>
      `
    }
    this.offerBody.insertAdjacentHTML('afterbegin', tableNode);
  }

  BindAccountList = (account) => {
    //시간등록
    const UnixTimestamp = (t) => {
      const date = new Date(t);
      const year = date.getFullYear();
      const month = "0" + (date.getMonth() + 1);
      const day = "0" + date.getDate();
      return year + "-" + month.substr(-2) + "-" + day.substr(-2);
    }
    this.accountLog = document.querySelector('.check_log_table tbody');
    
    let tableNode = ``;
    for (let item of account) {
      if (item.action === 'deposit') {
        item.action = '충전';
      } else if (item.action === 'sell') {
        item.action = '판매';
      } else if (item.action === 'buy'){
        item.action = '구매';
      } else {
        item.action = '환전';
      }
    }
    
    for(const item of account) {
      if (account.length -1 !== account.indexOf(item)) {
        tableNode += `
          <tr>  
            <th scope="row">${UnixTimestamp(Number(item.timestamp))}</th>
            <td>${item.action}</td>
            <td>${item.amount}</td>
          </tr>
        `
      } else {
        tableNode += `
          <tr>  
            <th scope="row">${UnixTimestamp(Number(item.timestamp))}</th>
            <td>${item.action}</td>
            <td>${item.amount}</td>
          </tr>
        `
        
        this.account = document.querySelector('.account');
        this.account.innerHTML = `잔액 : ${item.balance}원`
      }
      
    }

    this.accountLog.insertAdjacentHTML('afterbegin', tableNode);

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
  BindLogoutButton = (callback) => {
    this.logout = document.querySelector('.logout');
    this.logout.addEventListener('click', callback);
  }
}