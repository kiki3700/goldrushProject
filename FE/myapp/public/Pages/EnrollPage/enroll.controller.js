import EnrollView from './enroll.view.js';
import EnrollModel from './enroll.model.js';

export default class QnaController {
  constructor() {
    this.view = new EnrollView();
    this.model = new EnrollModel();
  }
  total = () => {
    this.view.BindEnrollButton(this.enrollButton);
  } 
  enrollButton = () => {
    console.log('등록버튼이 눌렸다.');
  }
}