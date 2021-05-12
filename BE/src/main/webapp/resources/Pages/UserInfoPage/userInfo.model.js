export default class UserInfoModel {
  constructor() {
    
  }

  GetPortfolio(membersId) {
    const portfolios = fetch(`http://192.168.1.70:8080/member/portfolio/?membersId=${membersId}`, {
      method: 'GET',
    })
    .then(
      response => response.json(),
      error => error)
    .then((portfolios) => {
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
