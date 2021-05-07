import MainView from './main.view.js'
import MainModel from './main.model.js'

export default class MainController {
  constructor() {
    this.model = new MainModel();
    this.view = new MainView();
  }
  click() {
    console.log('a');
  }
  total = () => {
    this.view.BindEvent(this.click)
    
    const isLoginUser = JSON.parse(window.localStorage.getItem('userInfo'));
    console.log(isLoginUser);
    if ( !isLoginUser ) {
      console.log('null이 나와 줬으면', isLoginUser);
      return location.href = "#main";
    } else if ( isLoginUser.membersId === 1) {
      console.log('manager가 나와줬으면', isLoginUser);
      return location.href = '#manager';
    } else {
      console.log('다른 유저가 나와줬으면', isLoginUser);
      return location.href = '#catalogue';
    }
  }
}

