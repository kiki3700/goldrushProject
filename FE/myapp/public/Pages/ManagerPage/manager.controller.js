import ManagerView from './manager.view.js'
import ManagerModel from './manager.model.js'

export default class ManagerController{
  constructor() {
    this.model = new ManagerModel();
    this.view = new ManagerView();
  }
  total = () => {
    this.view.Binditem(this.item);
    this.view.BindUpdateItem(this.update);
    this.view.BindDeleteItem(this.delete);
  }

  item = () => {
    console.log(event.target);
  }
  update = () => {
    console.log('update 버튼이 눌렸다.');
  }
  delete = () => {
    console.log('delete 버튼이 눌렸다.');
  }
}