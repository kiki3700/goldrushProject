export default class LoginModel {
  constructor() {
    
  }
  
  PostLogin = (id, pwd) =>  {
  var PostLogin = fetch('http://192.168.1.70:8080/member/login', {
    method: 'POST',
    body: JSON.stringify({
      "userId": id,
      "password": pwd
    }),
    headers: {
      'Content-Type': 'application/json;charset=UTF-8',
      'Access-Control-Allow-Origin': '*',
      'Accept': 'application/json'
    },
  })
    .then(
      ( response ) => {
        if (response.status === 202) {
          response.json().then(json => {
            console.log(json.result, json.message, json.obj);
            window.localStorage.setItem('userInfo', JSON.stringify(json.obj));
            let getUser = window.localStorage.getItem('userInfo');
            const usingUser = JSON.parse(getUser);
            
            if ( usingUser.membersId === 1) {
              location.href = '#manager';
            } else {
              location.href = '#catalogue'
            }
            
          });
        } else {
          response.json().then(json => alert('실패', json.message));
        }
      }
    )
    .catch((error) => {
      alert('catch로 왔어오!', error);
    })

    return PostLogin;
  }
}