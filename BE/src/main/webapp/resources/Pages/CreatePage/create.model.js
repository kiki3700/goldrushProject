export default class CreateModel {
  constructor() {
    
  }

  PostCreate = (id, pwd, name) => {
    var PostCreate = fetch('http://192.168.1.70:8080/member/signup', {
      method: 'POST',
      body: JSON.stringify({
        "userId": id,
        "password": pwd,
        "name": name,
      }),
      headers: {
        'Content-Type': 'application/json;charset=UTF-8',
        'Access-Control-Allow-Origin': '*',
        'Accept': 'application/json'

      }}
      )
      .then((res) => {
        console.log(res.status);
        if (res.status === 202) {
          location.href = '#login';
          alert('회원가입이 완료되었습니다.');
        } else {
          res.text().then(text => alert('이미 있는 메일주소입니다. status', text));
        }
      })
      .catch((error) => {
        alert('이미 있는 메일주소입니다. 캐치로옴', error);
      }
    )
  
    return PostCreate;
  }
}