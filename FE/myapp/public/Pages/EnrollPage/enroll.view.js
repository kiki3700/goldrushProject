import enroll from './enroll.js'


class EnrollView{
  constructor() {
    this.view = enroll;
    this.body = document.querySelector('body');
    this.css = document.querySelector('.css_part');
  }

  render = () => {
    const root = document.querySelector('#root');
    root.remove();
    const newRoot = document.createElement('div');
    newRoot.setAttribute('id', 'root');
    this.body.appendChild(newRoot);
    this.css.setAttribute('href', 'Pages/EnrollPage/enroll.css');
    newRoot.insertAdjacentHTML('afterbegin', this.view);

    this.enrollButton = document.querySelector('.enroll_button');
  }

  BindEnrollButton = (callback) => {
    this.enrollButton.addEventListener('click', callback);
  }
}

export default EnrollView;