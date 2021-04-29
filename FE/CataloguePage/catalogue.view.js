import catalogue from './catalogue.js'


export default class CatalogueView{
  constructor() {
    this.view = catalogue;
    this.body = document.querySelector('body');
    this.css = document.querySelector('.css_part');
  }

  render = () => {
    const root = document.querySelector('#root');
    root.remove();
    const newRoot = document.createElement('div');
    newRoot.setAttribute('id', 'root');
    this.body.appendChild(newRoot);
    this.css.setAttribute('href', 'CataloguePage/catalogue.css');
    newRoot.insertAdjacentHTML('afterbegin', this.view);
  }
}