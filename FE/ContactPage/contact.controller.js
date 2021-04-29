import ContactView from './contact.view.js';
import ContactModel from './contact.model.js';

export default class QnaController {
  constructor() {
    this.view = new ContactView();
    this.model = new ContactModel();
  }
  total = () => {

  } 
}