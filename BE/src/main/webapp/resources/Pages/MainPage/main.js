const pMain = `
  <nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
      <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">toggle navgation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
        <a class="navbar-brand" href="#/main"><p class="logo">Gold Rush</p></a>
      </div>
      <div id="navbar" class="navbar-collapse collapse">
        <ul class="nav navbar-nav navbar-right">
          <li><a href="#/login">로그인</a></li>
          <li><a href="#/create">회원가입</a></li>
        </ul>
      </div> 
    </div>
  </nav>
  <div class="content_body">
    <section class="content1">
      <div class="row">
        <div class="con tainer-fluid text-center">
          <div class="section-left col-lg-6 col-sm-12">
            <h1>쉽고 즐거운 투자의 시작.</h1>
            <br><br>
            <p>그동안 비싸고 어려웠던 리셀 투자</p>
            <p>골드러쉬와 함께 하세요</p>
            <p>투자 풀을 형성해 쉽고 빠르게 투자할 수 있습니다.</p>
          </div>
          <div class="section-right col-lg-6 col-sm-12">
            <img src="/css/img/시계 첨부용.png" alt="main Asset">
          </div>
        </div>
      </div>
    </section>
    <hr class="style-five">
    <section class="content2 text-center">
      <div class="row">
        <div class="explain col-lg-4 col-xs-4 col-lg-offset-2 col-xs-offset-2 text-center">
          <h1>OpenStage</h1>
          <p>상품에 대한 청약을 진행합니다.</p>
        </div>
        <div class="explain col-lg-4 col-xs-4 text-center">
          <p>외부 전문가에게 검증 받은 상품이 사이트에 등록됩니다. 청약기간동안 선착순으로 상품을 구매합니다.</p>
        </div>
      </div>

      <span class="glyphicon glyphicon-chevron-down" aria-hidden="true"></span>

      <div class="row">
        <div class="explain col-lg-4 col-xs-4 col-lg-offset-2 col-xs-offset-2 text-center">
          <p>청약기간동안 보유한 상품을 다른 투자자분들과 거래합니다. 가격이 오를 거 같다면 확보하고, 내려갈 것 같다면 처분하십시오!</p>
        </div>
        <div class="explain col-lg-4 col-xs-4 text-center">
          <h1>TradeStage</h1>
          <p>상품에 대한 거래를 진행합니다.</p>
        </div>
      </div>

      <span class="glyphicon glyphicon-chevron-down" aria-hidden="true"></span>

      <div class="row">
        <div class="explain col-lg-4 col-xs-4 col-lg-offset-2 col-xs-offset-2 text-center">
          <h1>ClearStage</h1>
          <p>상품 교환이 제한됩니다.</p>
        </div>
        <div class="explain col-lg-4 col-xs-4 text-center">
          <p>6개월의 교환 과정이 종료됩니다. 이후 실제로 상품을 팔기까지의 기간을 ClearStage라 칭합니다.</p>
        </div>
      </div>

      <span class="glyphicon glyphicon-chevron-down" aria-hidden="true"></span>

      <div class="row">
        <div class="explain col-lg-4 col-xs-4 col-lg-offset-2 col-xs-offset-2 text-center">
          <p>상품을 시장에 판매한 후, 그 차익만큼 투자자분들의 상품 보유량에 따라 손익이 분배됩니다!</p>
        </div>
        <div class="explain col-lg-4 col-xs-4 text-center">
          <h1>CloseStage</h1>
          <p>상품을 시장에 판매합니다.</p>
        </div>
      </div>
    </section>
    <hr class="style-five">
    <section class="content3">
      <div class="container-fluid">
        <div class="row">
          <div class="col-lg-6 col-xs-12 text-center row-left">
            <h1>지금 바로 시작하세요!</h1>
            <p>지금이 바로 기회!</p>
          </div>
          <div class="col-lg-6 col-xs-12 text-center">
            <img src="/css/img/서명.png" alt="서명">
          </div>
        </div>
      </div>
    </section>
  </div>
  <footer>
    <div class="col-lg-12 text-center footer_content">
      4주 프로젝트
    </div>
    
  </footer>`

export default pMain;