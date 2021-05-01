import ContactView from './contact.view.js';
import ContactModel from './contact.model.js';

export default class QnaController {
  constructor() {
    this.view = new ContactView();
    this.model = new ContactModel();
  }
  total = () => {
    this.view.BindSubmitButton(this.submitButton);
  } 
  submitButton = (e) => {
    e.preventDefault();
    console.log('제출버튼이 눌렸다.');
    alert("제출되었습니다.");
  }
}