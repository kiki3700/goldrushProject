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
    
    if ( !isLoginUser ) {
    
      return location.href = "#main";
    } else if ( isLoginUser.membersId === 1) {
    
      return location.href = '#manager';
    } else {
    
      return location.href = '#catalogue';
    }
  }
}

