import pMain from '/templates/p-main.js'


class MainView{
  constructor() {
    this.view = pMain;
    this.root = document.querySelector('#root');
    this.css = document.querySelector('.css_part');
  }

  render() {
    this.css.setAttribute('href', '/templates/p-main.css');
    this.root.insertAdjacentHTML('afterbegin', this.view);
  }
}

export default MainView;