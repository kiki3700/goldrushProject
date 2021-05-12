import qna from './qna.js'


class QnaView{
  constructor() {
    this.view = qna;
    this.body = document.querySelector('body');
    this.css = document.querySelector('.css_part');
  }

  render = () => {
    const root = document.querySelector('#root');
    root.remove();
    const newRoot = document.createElement('div');
    newRoot.setAttribute('id', 'root');
    this.body.appendChild(newRoot);
    this.css.setAttribute('href', 'Pages/QnaPage/qna.css');
    newRoot.insertAdjacentHTML('afterbegin', this.view);

    const user = JSON.parse(window.localStorage.getItem('userInfo'));
    this.welcome = document.querySelector('.welcome');
    this.welcome.innerHTML = `환영합니다! ${user.name}님!`;
  }

  BindLogoutButton = (callback) => {
    this.logout = document.querySelector('.logout');
    this.logout.addEventListener('click', callback);
  }
}

export default QnaView;