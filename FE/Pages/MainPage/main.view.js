import pMain from './main.js'


export default class MainView{
  constructor() {
    this.view = pMain;
    this.body = document.querySelector('body');
    this.css = document.querySelector('.css_part');
  }  
  render = () => {
    const root = document.querySelector('#root');
    root.remove();
    const newRoot = document.createElement('div');
    newRoot.setAttribute('id', 'root');
    this.body.appendChild(newRoot);
    this.css.setAttribute('href', 'Pages/MainPage/main.css');
    newRoot.insertAdjacentHTML('afterbegin', this.view);
    //이벤트 요소 잡아주기
    this.button = document.querySelector('.logo'); 
  }

  //각각 이벤트 달아주기
  BindEvent = (callback) => {
    this.button.addEventListener('click', callback);
  }
  

}

 