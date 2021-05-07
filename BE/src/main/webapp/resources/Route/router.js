export default class Router {
  constructor() {
    
    this.routes = [];
    //this.hashChange = this.hashChange.bind(this);
    

    window.addEventListener('hashchange', this.hashChange);
    window.addEventListener('DOMContentLoaded', this.hashChange);
    
    
  }
  addRoute(name, ctrl, url) {
    this.routes.push({
      name,
      ctrl,
      url
    });
  }

  hashChange = () => {
    const hash = window.location.hash;
    console.log('hashchane이벤트 발생', hash);
    const route = this.routes.filter(route => hash.match(route.name));
    console.log('아니 이름이 왜 이상하게 잡히냐!', route[0].name);
    console.log(typeof(route[0].name));
    const noAuthority = ['create', 'main', 'login'];
    const userAuthority = ['catalogue', 'userInfo', 'qna', 'contact', 'buy', 'sell'];
    const managerAuthority = ['manager', 'enroll', 'userManage', 'clear'];
    const user = JSON.parse(window.localStorage.getItem('userInfo'));
    
    if (noAuthority.includes(route[0].name)) {
      console.log('a');
      route[0].ctrl.view.render();
      route[0].ctrl.total();
      
    } else if (userAuthority.includes(route[0].name)) {
      console.log('b');
      if ( !user ) {
        alert('권한이 없습니다.')
        window.location.href = '#main';
      } else {
        route[0].ctrl.view.render();
        route[0].ctrl.total();
      }
    } else if (managerAuthority.includes(route[0].name)) {
      if ( !user ) {
        alert('권한이 없습니다.')
        window.location.href = '#main';
      } else if ( user.membersId === 1) {
        route[0].ctrl.view.render();
        route[0].ctrl.total();
      } else {
        alert('관리자만 접근할 수 있습니다.')
        window.location.href = '#main';
      }

    }
    // if (route[0].name === '#userInfo' || '#catalogue' || '#qna' || '#contact') {
    //   const user = JSON.parse(window.localStorage.getItem('userInfo'));
    //   if( !user ){
    //     alert('접근권한이 없습니다.');
    //     window.location.href = '#main'
    //   } else {
    //     route[0].ctrl.view.render();
    //     route[0].ctrl.total();
    //   }
    //} else if (route[0].name = '#main' || '#login' || '#create') {
        
    //}
    
  }

}