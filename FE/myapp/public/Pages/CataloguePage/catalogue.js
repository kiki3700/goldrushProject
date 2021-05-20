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
                <ul class="list flex-column">
                  <li>
                    <a href="#catalogue" class="selected total_list"><span class="glyphicon glyphicon-list" aria-hidden="true"> TotalStage</span></a>
                  </li>
                  <li>
                    <a href="#catalogue/open" class="IPO_list"><span class="glyphicon glyphicon-star" aria-hidden="true"> OpenStage</span></a>
                  </li>
                  <li>
                    <a href="#catalogue/trade" class="Trading_list"><span class="glyphicon glyphicon-usd" aria-hidden="true"> TradeStage</span></a>
                  </li>
                  <li>
                    <a href="#catalogue/clear" class="Clearing_list"><span class="glyphicon glyphicon-saved" aria-hidden="true"> ClearStage</span></a>
                  </li>
                </ul>
                <p><a href="#userInfo"><span class="glyphicon glyphicon-cog" aria-hidden="true"> MyInfo</span></a></p>
                <p><a href="#qna"><span class="glyphicon glyphicon-question-sign" aria-hidden="true"> QNA</span></a></p>
                <p><a href="#contact"><span class="glyphicon glyphicon-envelope" aria-hidden="true"> Contact</span></a></p>
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
            <div class="basic">
              <!--<p><span class="glyphicon glyphicon-search" aria-hidden="true"> Find Your Piece</span></p> -->
              <img src="/css/img/KakaoTalk_Image_2021-05-11-11-13-49.gif">
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