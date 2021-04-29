import ManagerView from './manager.view.js'
import ManagerModel from './manager.model.js'

export default class ManagerController{
  constructor() {
    this.model = new ManagerModel();
    this.view = new ManagerView();
  }
  total = () => {
    console.log('매니저');
  }
}