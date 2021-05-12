import CreateView from './create.view.js'
import CreateModel from './create.model.js'

export default class CreateController{
  constructor() {
    this.model = new CreateModel();
    this.view = new CreateView();
  }
  total = () => {
    this.view.BindCreateButton(this.clickCreate);
  }
  clickCreate = async() => {
    console.log('작동했다.');
    var regExp = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
    const name = this.view.userName.value;
    const mail = this.view.userMail.value;
    const pwd = this.view.userPwd.value;
    
    if ( !name ) {
      return alert('이름을 작성해주십시오.');
    } else if ( !mail ) {
      return alert('메일을 작성해주십시오.');
    } else if ( !pwd ) {
      return alert('비밀번호를 작성해주십시오.')
    } else if (mail.match(regExp) === null) {
      return alert('이메일 형식을 맞춰주십시오.');
    } else {
      const result = await this.model.PostCreate(mail, pwd, name);
      console.log(result);
    }

    
    
    
  }
}