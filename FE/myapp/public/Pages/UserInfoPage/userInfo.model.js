export default class UserInfoModel {
  constructor() {
    
  }

  GetCharge = () => {
    const charge = fetch(`http://192.168.1.70:8080/bank/oauth`, {
      method: "GET",
      headers: {
        'Content-Type': 'application/json;charset=UTF-8',
        'Access-Control-Allow-Origin': '*',
        'Accept': 'application/json'
      },
    })
    .then(
      response => response.json(),
      err => err
    )
    .then(
      res => console.log(res),
    )
    .catch((error) => {
      console.log('충전상황에 문제가 있어요', error);
    })
    return charge;
  }

  GetPortfolio(membersId) {
    const portfolios = fetch(`http://192.168.1.70:8080/member/portfolio/?membersId=${membersId}`, {
      method: 'GET',
    })
    .then(
      response => response.json(),
      error => error)
    .then((portfolios) => {
      console.log(portfolios);
      return portfolios;
    })
    .catch((error) => {
      alert('읽어오는 데 실패하였습니다.', error);
    })
    
    return portfolios;
  }

  GetOfferLog(membersId) {
    const offerLog = fetch(`http://192.168.1.70:8080/member/offer/?membersId=${membersId}`, {
      method: 'GET',
    })
    .then(
      response => response.json(),
      error => error)
    .then((offerLog) => {
      return offerLog;
    })
    .catch((error) => {
      alert('오퍼로그 : 실패.', error);
    })
    
    return offerLog;
  }

  GetAccountLog(membersId) {
    const accountLog = fetch(`http://192.168.1.70:8080/member/account/?membersId=${membersId}`, {
      method: 'GET',
    })
    .then(
      response => response.json(),
      error => error)
    .then((accountLog) => {
      return accountLog;
    })
    .catch((error) => {
      alert('계좌로그 : 실패.', error);
    })
    
    return accountLog;
  }

  DeleteCancelOffer(offersId) {
    const cancelOffer = fetch(`http://192.168.1.70:8080/trade/offer/?offersId=${offersId}`,{
      method : 'DELETE',
    })
    .then(
      response => response.json(),
      error => error
    )
    .then(
      json => console.log(json)
    )
    .catch((error) => {
      alert('삭제하는 데 실패!', error)
    })
    return cancelOffer;
  }
}
