const qna = `
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
          <li><a href="#userInfo">환영합니다! 이름님!</a></li>
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
                <a href="#userInfo"><p>My Info</p></a>
                <a><p>item</p></a>
                <ul class="nav flex-column collapse in">
                  <li>
                    <a href="#catalogue" class="total_list">Total</a>
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
                <a class="selected" href="#qna"><p>QNA</p></a>
                <a href="#contact"><p>Contact</p></a>
              </div>
            </div>
          </div>
          <div class="follow_menu col-lg-10  col-xs-10">
            <h1>자주 하시는 질문을 모아봤습니다!</h1>
            <div class="panel-group" id="accordion">
              <div class="panel">
                <div class="panel-heading">
                  <h4 class="panel-title">
                    <a data-toggle="collapse" data-parent="#accordion" href="#collapseQ1">
                      <span class="glyphicon glypicon-star"></span>
                      조각투자란?
                    </a>
                  </h4>
                </div>
                <div id="collapseQ1" class="panel-collapse collapse in">
                  <div class="panel-body">
                    투자의 시대다. 적금으로 월급을 착실히 모아 내집 마련의 꿈을 이룰 수 있는 시기는 지났다. ‘성실’보다 ‘투자’가 계층사다리를 올라가는 방법이라고 판단하는 사람들이 늘었다. 청년층도 비록 소액일지라도 투자에 관심을 갖기 시작했다. 이러한 흐름을 타고 2030세대를 겨냥한 새로운 투자 형태가 생겼다. 바로 ‘조각투자’다. 수천만원을 웃도는 목돈을 준비할 필요가 없다. 투자 시작점은 ‘10만원’이다. 회수 기간은 평균 6개월로 짧다. 투자 대상은 ‘명품’이다. 익숙하고, 투자기간이 짧고, 소액이라는 점에서 젊은 층의 투자 문턱을 낮췄다.
                  </div>
                </div>
              </div>
              <div class="panel">
                <div class="panel-heading">
                  <h4 class="panel-title">
                    <a data-toggle="collapse" data-parent="#accordion" href="#collapseQ2">
                      <span class="glyphicon glypicon-star"></span>
                      이만큼 잘나갑니다!
                    </a>
                  </h4>
                </div>
                <div id="collapseQ2" class="panel-collapse collapse">
                  <div class="panel-body">
                    고가 명품이나 한정판을 구매하고 다시 팔아 수익을 거두는 리셀테크(리셀+재테크)가 MZ세대의 재테크 수단으로 떠오르고 있다. 리셀테크 인기에 발맞춰 소액으로 리셀테크 시장에 참여할 수 있는 펀드가 출시돼 큰 관심을 받고 있다.
                  </div>
                </div>
              </div>
              <div class="panel">
                <div class="panel-heading">
                  <h4 class="panel-title">
                    <a data-toggle="collapse" data-parent="#accordion" href="#collapseQ3">
                      <span class="glyphicon glypicon-star"></span>
                      등록은 언제 이뤄지나요?
                    </a>
                  </h4>
                </div>
                <div id="collapseQ3" class="panel-collapse collapse">
                  <div class="panel-body">
                    최근 소액 투자로 소유권을 공동 구매하거나 공동 소유하는 플랫폼이 인기를 끌고 있다. 고액 자산가가 아니라면 소유하기 힘든 명품, 미술품, 저작권 등을 공동으로 소유하고 발생하는 수익금을 나누는 구조다. 온라인 미술품 경매사 서울옥션블루는 미술품, 스니커즈 등을 공동 구매할 수 있는 플랫폼 소투(SOTWO)를 운영하고 있다. 최근 걸그룹 브레이브걸스 노래 롤린 역주행과 함께 저작권 투자자들이 1000% 가까운 수익률을 거두며 음악 저작권 공유 플랫폼 뮤직카우가 큰 관심을 받기도 했다. 신범준 대표는 "명품은 눈에 보이는 현물이고 누구나 가치 변화를 알 수 있어 주식보다 쉽게 투자할 수 있는 대상"이라며 "최근 급성장하고 있는 리셀에 대한 수요가 피스로 자연스레 이동할 것으로 기대한다"고 말했다. 이어 "앞으로도 소액 투자자들도 의미 있는 수익을 누릴 수 있도록 가치 있고 우량한 현물 포트폴리오를 지속적으로 제안하겠다"고 밝혔다. 한편 집합 1호에 이은 피스의 후속 포트폴리오는 오는 6월 공개된다.
                  </div>
                </div>
              </div>
              <div class="panel">
                <div class="panel-heading">
                  <h4 class="panel-title">
                    <a data-toggle="collapse" data-parent="#accordion" href="#collapseQ4">
                      <span class="glyphicon glypicon-star"></span>
                      비전이 있는 투자인가요?
                    </a>
                  </h4>
                </div>
                <div id="collapseQ4" class="panel-collapse collapse">
                  <div class="panel-body">
                    온라인 미술품 경매사 서울옥션블루는 미술품과 아트 토이, 스니커즈 등을 공동구매할 수 있는 플랫폼 ‘소투(SOTWO)’를 운영 중이다. 테사(TESSA)에서도 뱅크시, 야요이 쿠사마 등의 작품을 소액으로 투자할 수 있다. 또, 잘만 투자하면 직접 곡을 쓰지 않더라도 ‘벚꽃연금’과 같은 저작권 수익을 올릴 수 있다. (버스커버스커의 ‘벚꽃 엔딩’은 매년 봄 많이 재생돼 벚꽃연금으로 불린다) 뮤직카우에선 옥션 또는 마켓 거래로 저작권 일부를 소유할 수 있다. 뮤직카우에 따르면 ‘차트 역주행’으로 재조명 받은 브레이브 걸스의 ‘롤린’은 최근 들어 1주일 사이 저작권 수익률 1000%에 이르기도 했다.                  </div>
                </div>
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
  export default qna;