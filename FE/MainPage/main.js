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
        <div class="container-fluid text-center">
          <div class="section-left col-lg-6 col-sm-12">
            <h1>쉽고 즐거운 투자의 시작.</h1>
            <br><br>
            <p>나날히 상승하는 김일성시계의 가치에 투자하세요!</p>
            <p>시계의 가격이 너무 비싸다고요? 그런 당신을 위해 준비했습니다!</p>
            <p>하나의 시계에 대해서 10명, 100명이 투자합니다.</p>
            <p>6개월 후의 상승한 현물의 가치를 느껴보세요!</p>
          </div>
          <div class="section-right col-lg-6 col-sm-12">
            <img src="/css/img/시계 첨부용.png" alt="일성이시계">
          </div>
        </div>
      </div>
    </section>
    <hr class="style-five">
    <section class="content2">
      <div class="row">
        <div class="explain col-lg-4 col-xs-5 col-lg-offset-2 text-center">
            <h1>1단계</h1>
            <p>가치가 오를 상품을 매입합니다.</p>
        </div>
        <div class="explain col-lg-4 col-xs-5 text-center">
          <h1>사진자리</h1>
        </div>
      </div>
      <div class="row">
        <div class="explain col-lg-4 col-xs-5 col-lg-offset-2 text-center">
            <h1>사진자리</h1>
        </div>
        <div class="explain col-lg-4 col-xs-5 text-center">
          <h1>2단계</h1>
          <p>매입한 상품의 청약을 진행합니다.</p>
        </div>
      </div>
      <div class="row">
        <div class="explain col-lg-4 col-xs-5 col-lg-offset-2 text-center">
          <h1>3단계</h1>
          <p>일정기간 이후 상품을 판매합니다.</p>
        </div>
        <div class="explain col-lg-4 col-xs-5 text-center">
          <h1>사진자리</h1>
        </div>
      </div>
      <div class="row">
        <div class="explain col-lg-4 col-xs-5 col-lg-offset-2 text-center">
          <h1>사진자리</h1>
        </div>
        <div class="explain col-lg-4 col-xs-5 text-center">
          <h1>4단계</h1>
          <p>일어난 수익에 대하여 청산을 진행합니다.</p>
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