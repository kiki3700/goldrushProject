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
    this.inputBtn = document.querySelector('#image_uploads');
  }

  BindEnrollButton = (callback) => {
    this.formData = document.querySelector('.enroll_form');
    
    this.enrollButton.addEventListener('click', callback);
  }
  
  BindInputButton = (callback) => {
    this.previewImage = document.querySelector('.preview');
    this.inputBtn.addEventListener('change', callback);
  }

  BindLogoutButton = (callback) => {
    this.logout = document.querySelector('.logout');
    this.logout.addEventListener('click', callback);
  }
}

export default EnrollView;