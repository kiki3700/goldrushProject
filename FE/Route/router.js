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
    console.log(route);
    route[0].ctrl.view.render();
    route[0].ctrl.total();
  }
}