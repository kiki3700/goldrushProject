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
    this.css.setAttribute('href', 'Pages/UserManagePage/userManage.css');
    newRoot.insertAdjacentHTML('afterbegin', this.view);

    this.searchForm = document.querySelector('#search');
    this.kickButton = document.querySelectorAll('.table tr th');
  }

  BindSearchForm = (callback) => {
    this.searchForm.addEventListener('keyup', callback);
  }

  BindKickButton = (callback) => {
    this.kickButton.forEach(item => item.addEventListener('click', callback));
  }
  BindLogoutButton = (callback) => {
    this.logout = document.querySelector('.logout');
    this.logout.addEventListener('click', callback);
  }
}

export default UserManageView;