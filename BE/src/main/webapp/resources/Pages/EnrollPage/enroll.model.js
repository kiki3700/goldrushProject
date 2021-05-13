export default class EnrollModel {
  constructor() {
    
  }
  postEnrollItem(formData) {
    const enrollItem = fetch('http://192.168.1.70:8080/item/list', {
      method: 'POST',
      body : formData,
      headers: {},
    })
    .then(
      response => response.json(),
      error => error
    )
    .then(
      res => {
        if (res.result === 1) {
          alert('상품등록에 성공하셨습니다.');
          location.href = '#enroll'
        } else {
          alert('상품등록에 실패하셨습니다.');
        }
      } 
    )
    .catch((error) => {
      console.log(error);
    }) 
    return enrollItem;
  }
}