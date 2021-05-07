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
          res.text().then(text => console.log('뭐가 나오는 거야?', text.message));
          location.href = '#login';
          alert('회원가입이 완료되었습니다.');
        } else {
          res.text().then(text => alert(text.message));
        }
      })
      .catch((error) => {
        alert('회원가입에 실패하였습니다.', error);
      }
    )
  
    return PostCreate;
  }
}