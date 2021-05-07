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

  // GetTradeLog(membersId) {
  //   const tradeLog = fetch(`http://192.168.1.70:8080/member/trade/?membersId=${membersId}`, {
  //     method: 'GET',
  //   })
  //   .then(
  //     response => response.json(),
  //     error => error)
  //   .then((tradeLog) => {
  //     return tradeLog;
  //   })
  //   .catch((error) => {
  //     alert('트레이더로그 : 실패.', error);
  //   })
    
  //   return tradeLog;
  // }

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
    const accountLog = fetch(`http://192.168.1.70:8080//member/account/?membersId=${membersId}`, {
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
}