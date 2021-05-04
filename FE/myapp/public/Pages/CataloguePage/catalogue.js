const catalogue = `
  <nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
      <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">toggle navgation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
        <a class="navbar-brand" href="#catalogue"><p class="logo">Gold Rush</p></a>
      </div>
      <div id="navbar" class="navbar-collapse collapse">
        <ul class="nav navbar-nav navbar-right">
          <li><a href="#userInfo" class="welcome">환영합니다! 이름님!</a></li>
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
                  <a href="#userInfo"><p>My Info</p></a>
                  <p>item</p>
                  <ul class="nav flex-column">
                    <li>
                      <a href="#catalogue" class="selected total_list">Total</a>
                    </li>
                    <li>
                      <a href="#catalogue/IPO" class="IPO_list">IPO Stage</a>
                    </li>
                    <li>
                      <a href="#catalogue/Trading" class="Trading_list">Trading Stage</a>
                    </li>
                    <li>
                      <a href="#catalogue/Clearing" class="Clearing_list">Clearing Stage</a>
                    </li>
                  </ul>
                  <a href="#qna"><p>QNA</p></a>
                  <a href="#contact"><p>Contact</p></a>
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
            <div class="row contract">
              <button class="btn btn-lg col-lg-4 col-xs-4 pull-left buy_btn"> 청약 / 매수 </button> : 사는 가격 : $100
              <button class="btn btn-lg col-lg-4 col-xs-4 pull-right sell_btn"> 청약취소 / 매도 </button> : 파는 가격 : $120
            </div>
            <div style="overflow:auto; width:100%; height: 69vh;">
              
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
export default catalogue;