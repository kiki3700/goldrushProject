import {domainUrl} from "../env.js"
export default class UserInfoModel {
  constructor() {
    
  }

  GetPortfolio(membersId) {
    const portfolios = fetch(domainUrl+`member/portfolio/?membersId=${membersId}`, {
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
    const offerLog = fetch(domainUrl+`member/offer/?membersId=${membersId}`, {
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
    const accountLog = fetch(domainUrl+`member/account/?membersId=${membersId}`, {
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
    const cancelOffer = fetch(domainUrl+`trade/offer/?offersId=${offersId}`,{
      method : 'DELETE',
    })
    .then(
      response => response.json(),
      error => error
    )
    .then(
      json => alert('오퍼를 취소하셨습니다.', json)
    )
    .catch((error) => {
      alert('삭제하는 데 실패!', error)
    })
    return cancelOffer;
  }
}
