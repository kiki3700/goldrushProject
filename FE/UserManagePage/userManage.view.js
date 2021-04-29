import userManage from './userManage.js'


class UserManageView{
  constructor() {
    this.view = userManage;
    this.body = document.querySelector('body');
    this.css = document.querySelector('.css_part');
  }

  render = () => {
    const root = document.querySelector('#root');
    root.remove();
    const newRoot = document.createElement('div');
    newRoot.setAttribute('id', 'root');
    this.body.appendChild(newRoot);
    this.css.setAttribute('href', 'UserManagePage/userManage.css');
    newRoot.insertAdjacentHTML('afterbegin', this.view);
  }
}

export default UserManageView;