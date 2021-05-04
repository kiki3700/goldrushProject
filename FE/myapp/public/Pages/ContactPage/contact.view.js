import contact from './contact.js'


class ContactView{
  constructor() {
    this.view = contact;
    this.body = document.querySelector('body');
    this.css = document.querySelector('.css_part');
  }

  render = () => {
    const root = document.querySelector('#root');
    root.remove();
    const newRoot = document.createElement('div');
    newRoot.setAttribute('id', 'root');
    this.body.appendChild(newRoot);
    this.css.setAttribute('href', 'Pages/ContactPage/contact.css');
    newRoot.insertAdjacentHTML('afterbegin', this.view);
    
    const user = JSON.parse(window.localStorage.getItem('userInfo'));
    this.welcome = document.querySelector('.welcome');
    this.welcome.innerHTML = `환영합니다! ${user.name}님!`;
    
    this.submitButton = document.querySelector('.send_btn');
  }

  BindSubmitButton = (callback) => {
    this.submitButton.addEventListener('click', callback);
  }

  BindLogoutButton = (callback) => {
    this.logout = document.querySelector('.logout');
    this.logout.addEventListener('click', callback);
  }
}

export default ContactView;