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
  }
}

export default QnaView;