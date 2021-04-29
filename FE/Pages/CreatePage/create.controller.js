import CreateView from './create.view.js'
import CreateModel from './create.model.js'

export default class CreateController{
  constructor() {
    this.model = new CreateModel();
    this.view = new CreateView();
  }
  total = () => {
    this.view.BindCreateButton(this.clickCreate);
  }
  clickCreate = () => {
    console.log('clickCreate');
  }
}