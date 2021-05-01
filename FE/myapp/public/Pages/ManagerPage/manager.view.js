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
    this.css.setAttribute('href', 'Pages/ManagerPage/manager.css');
    newRoot.insertAdjacentHTML('afterbegin', this.view);

    this.item = document.querySelectorAll('.item_li');
    this.updateItem = document.querySelector('.update_item');
    this.deleteItem = document.querySelector('.delete_item');
  }

  Binditem = (callback) => {
    this.item.forEach(e => e.addEventListener('click', callback));
  }
  BindUpdateItem = (callback) => {
    this.updateItem.addEventListener('click', callback);
  } 
  BindDeleteItem = (callback) => {
    this.deleteItem.addEventListener('click', callback);
  }
}