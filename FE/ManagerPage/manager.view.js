import manager from './manager.js'


export default class ManagerView{
  constructor() {
    this.view = manager;
    this.body = document.querySelector('body');
    this.css = document.querySelector('.css_part');
  }

  render = () => {
    const root = document.querySelector('#root');
    root.remove();
    const newRoot = document.createElement('div');
    newRoot.setAttribute('id', 'root');
    this.body.appendChild(newRoot);
    this.css.setAttribute('href', 'ManagerPage/manager.css');
    newRoot.insertAdjacentHTML('afterbegin', this.view);
  }
}

