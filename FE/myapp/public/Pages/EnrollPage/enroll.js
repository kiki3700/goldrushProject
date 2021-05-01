const enroll = `
  <nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
      <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">toggle navgation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
        <a class="navbar-brand" href="#manager"><p class="logo">Gold Rush</p></a>
      </div>
      <div id="navbar" class="navbar-collapse collapse">
        <ul class="nav navbar-nav navbar-right">
          <li><a href="#manager">환영합니다! 관리자님!</a></li>
          <li><a href="#main">로그아웃</a></li>
        </ul>
      </div> 
    </div>
  </nav>
  
  <section class="merchandise_list">
    <div class="container-fluid">
      <div class="item_box">
        <div class="row">
          <div class="menu col-lg-2 col-xs-2">
            <div class="row">
              <div class="col">
                <a href="#manager"><p>상품 관리</p></a>
                <a href="#enroll" class="selected"><p>상품 등록</p></a>
                <a href="#userManage"><p>회원 관리</p></a>
              </div>
            </div>
          </div>
          <div class="follow_menu col-lg-10 col-xs-10">
            <div class="item_image">
              <img src="/css/img/item.jpg" alt="detail_image">
              <input type="file" id="img_input" accept="img/*">
            </div>
            <div class="item_container">
              <div class="row item_info">
                <p class="col-lg-6 col-xs-6 name">상품이름</p>
                <input type="text">
              </div>
              <div class="row item_info">
                <p class="col-lg-6 col-xs-6 cost">원가</p>
                <input type="text">
              </div>
              <div class="row item_info">
                <p class="col-lg-6 col-xs-6 piece">조각</p>
                <input type="text">
              </div>
              <div class="row item_info">
                <p class="col-lg-6 col-xs-6 ipo">IPO Stage</p>
                <input type="text">
              </div>
              <div class="row item_info">
                <p class="col-lg-6 col-xs-6 trading">Trading Stage</p>
                <input type="text">
              </div>
              <div class="row item_info">
                <p class="col-lg-6 col-xs-6 clearing">Clearing Stage</p>
                <input type="text">
              </div>
              <div class="row item_info">
                <textarea class="col-lg-12 item_Description"></textarea>
              </div>
              <div class="button-group">
                <button type="button" class="btn enroll_button">등록</button>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </section>
  

  <footer>
    <div class="col-lg-12 col-xs-12 text-center footer_content">
      4주 프로젝트
    </div>
  </footer>
  `
  export default enroll;