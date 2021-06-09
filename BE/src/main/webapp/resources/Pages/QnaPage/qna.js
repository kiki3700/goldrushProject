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
                    <a href="#catalogue" class="total_list"><span class="glyphicon glyphicon-list" aria-hidden="true"> TotalStage</span></a>
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
                <p><a href="#qna" class="selected"><span class="glyphicon glyphicon-question-sign" aria-hidden="true"> QNA</span></a></p>
                <p><a href="#contact"><span class="glyphicon glyphicon-envelope" aria-hidden="true"> Contact</span></a></p>
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
                      <strong>리셀투자란?</strong>
                    </a>
                  </h4>
                </div>
                <div id="collapseQ1" class="panel-collapse collapse in">
                  <div class="panel-body">
                    투자의 시대입니다. 리셀 투자는 희소성이 있는 현물을 매입하고 프리미엄을 붙여 매도하는 행위를 말합니다. 골드 러시에서는 기성 투자 상품을 너머 새로운 투자 대안을 제시합니다. 미술품, 골동품 명품 등 고가여서 투자하기 어려웠던 상품들을 'gold rush'와 함께 합리적인 가격으로 투자를 시작하세요. 
                   </div>
                </div>
              </div>
              <div class="panel">
                <div class="panel-heading">
                  <h4 class="panel-title">
                    <a data-toggle="collapse" data-parent="#accordion" href="#collapseQ2">
                      <strong>어떤 상품을 취급하나요?</strong>
                    </a>
                  </h4>
                </div>
                <div id="collapseQ2" class="panel-collapse collapse">
                  <div class="panel-body">
                   리셀 테크기업 'gold rush'의 투자 상품에는 한계란 없습니다. 고가의 미술품, 골동품, 스니커즈 까지 다양한 전문가와 협업하여 다양한 상품군을 발굴하여 최상의 투자 기회를 제공하겠습니다. 
                  </div>
                </div>
              </div>
              <div class="panel">
                <div class="panel-heading">
                  <h4 class="panel-title">
                    <a data-toggle="collapse" data-parent="#accordion" href="#collapseQ3">
                     <strong> trade 단계는 무엇이가요?</strong>
                    </a>
                  </h4>
                </div>
                <div id="collapseQ3" class="panel-collapse collapse">
                  <div class="panel-body">
                    IPO 이후 goldrush 마켓에서 지분을 거래하실 수 있습니다. trade stage의 상품들을 매도, 매수하여 다양한 상품들에 투자하세요!
                  </div>
                </div>
              </div>
              <div class="panel">
                <div class="panel-heading">
                  <h4 class="panel-title">
                    <a data-toggle="collapse" data-parent="#accordion" href="#collapseQ4">
                     <strong> clear 단계는 어떻게 이뤄지나요?</strong>
                    </a>
                  </h4>
                </div>
                <div id="collapseQ4" class="panel-collapse collapse">
                  <div class="panel-body">
                    clear 단계에 돌입하면, 상품에 대한 지분은 다른 투자자와의 거래가 불가해집니다. 상품을 최상의 조건에 판매합니다. 판매 수익은 투자자분들의 보유율지분 만큼 수익을 분배합니다! 수익금 분배는 clear 이후 최소 일주일 부터 최장 한달 까지 걸릴 수 있습니다.
                  </div>
                </div>
              </div>
              <div class="panel">
                <div class="panel-heading">
                  <h4 class="panel-title">
                    <a data-toggle="collapse" data-parent="#accordion" href="#collapseQ5">
                      <strong>비전이 있나요?</strong>
                    </a>
                  </h4>
                </div>
                <div id="collapseQ5" class="panel-collapse collapse">
                  <div class="panel-body">
                    이미 해외에서 활발하게 진행되고 있는 리셀거래입니다. 국내에서도 현물의 가치는 나날이 우상향 곡선을 그리고 있습니다. 우상향 곡선을 타고 날아올라보세요! 
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