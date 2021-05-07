const manager = `
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
          <li><a href="#manager" class="welcome">환영합니다! 관리자님!</a></li>
          <li><a href="#main" class="logout">로그아웃</a></li>
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
                  <a href="#manager" class="selected"><p>상품 관리</p></a>
                  <a href="#enroll"><p>상품 등록</p></a>
                  <a href="#clear"><p>상품 청산</p></a>
                  <a href="#userManage"><p>회원 관리</p></a>
                </div>
              </div>
            </div>
            <div class="item_list col-lg-3 col-xs-3">
              <div style="overflow:auto; width:100%; height:79vh;">
                <ul class="item_ul text-center">
                  
                </ul>
              </div>
            </div>
            <div class="item_detail col-lg-7 col-xs-7">
            
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
export default manager;