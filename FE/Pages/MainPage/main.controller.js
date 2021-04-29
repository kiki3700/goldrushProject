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
  }
}

