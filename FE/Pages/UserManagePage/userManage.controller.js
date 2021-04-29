import UserManageView from './userManage.view.js';
import UserManageModel from './userManage.model.js';

export default class QnaController {
  constructor() {
    this.view = new UserManageView();
    this.model = new UserManageModel();
  }
  total = () => {
    this.view.BindSearchForm(this.search)
    this.view.BindKickButton(this.kick)
  } 
  search = () => {
    console.log('keyup event발생!');
  }
  kick = () => {
    if (confirm("정말 탈퇴시키시겠습니까?")) {
      alert('탈퇴시켰습니다.');
    } else {
      alert('탈퇴를 취소하셨습니다.');
    }
    console.log('탈퇴시킨다.', event.target.innerHTML);
  }
}