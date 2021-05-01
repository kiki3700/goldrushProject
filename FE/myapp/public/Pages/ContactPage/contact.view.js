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
    
    this.submitButton = document.querySelector('.send_btn');
  }

  BindSubmitButton = (callback) => {
    this.submitButton.addEventListener('click', callback);
  }
}

export default ContactView;