import userInfo from './userInfo.js'


export default class UserInfoView{
  constructor() {
    this.view = userInfo;
    this.body = document.querySelector('body');
    this.css = document.querySelector('.css_part');
  }

  render = () => {
    const root = document.querySelector('#root');
    root.remove();
    const newRoot = document.createElement('div');
    newRoot.setAttribute('id', 'root');
    this.body.appendChild(newRoot);
    this.css.setAttribute('href', 'UserInfoPage/userInfo.css');
    newRoot.insertAdjacentHTML('afterbegin', this.view);
  }
}