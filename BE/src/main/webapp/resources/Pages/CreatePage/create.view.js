import create from './create.js'

export default class CreateView{
  constructor() {
    this.view = create;
    this.body = document.querySelector('body');
    this.css = document.querySelector('.css_part');
  }

  render = () => {
    const root = document.querySelector('#root');
    root.remove();
    const newRoot = document.createElement('div');
    newRoot.setAttribute('id', 'root');
    this.body.appendChild(newRoot);
    this.css.setAttribute('href', 'Pages/CreatePage/create.css');
    newRoot.insertAdjacentHTML('afterbegin', this.view);

    this.createButton = document.querySelector('.form_login');
    
  }

  BindCreateButton = (callback) => {
    this.userName = document.querySelector('.input_name');
    this.userMail = document.querySelector('.input_id');
    this.userPwd = document.querySelector('.input_password');
    this.createButton.addEventListener('click', callback);
  }
}
