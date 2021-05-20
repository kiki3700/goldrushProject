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
                      조각투자란?
                    </a>
                  </h4>
                </div>
                <div id="collapseQ1" class="panel-collapse collapse in">
                  <div class="panel-body">
                    투자의 시대입니다. 은행을 통해, 착실히 돈을 모아 내집 마련의 꿈을 이룰 수 있는 시기는 지났습니다. 이제 계층 사다리를 이동하는방법은 '성실'보다는 '투자'입니다. 다양한 계층에서 투자에 관심을 갖기 시작했더라도, 투자를 할 곳은 마땅치가 않습니다. 그런 분들을 위해 준비한 투자 플랫폼이 바로 이곳 'GoldRush'입니다. 투자의 시작은 1000원이 될 수도 있고, 10000원이 될수도, 심지어 100원이 될 수도 있습니다. 짧은 기간동안 투자를 통해서 가장 큰 이익을 얻어보세요!
                  </div>
                </div>
              </div>
              <div class="panel">
                <div class="panel-heading">
                  <h4 class="panel-title">
                    <a data-toggle="collapse" data-parent="#accordion" href="#collapseQ2">
                      어떤 상품을 취급하나요?
                    </a>
                  </h4>
                </div>
                <div id="collapseQ2" class="panel-collapse collapse">
                  <div class="panel-body">
                    리셀테크에 활용될 수 있는, 시간이 지났을 때 가치가 오를 상품을 취급합니다. 이 상품들은 전문가들의 심사를 통해 판단됩니다. 절대 아무 상품이나 투자의 소재로 사용하지 않습니다!
                  </div>
                </div>
              </div>
              <div class="panel">
                <div class="panel-heading">
                  <h4 class="panel-title">
                    <a data-toggle="collapse" data-parent="#accordion" href="#collapseQ3">
                      trade 단계는 무엇이가요?
                    </a>
                  </h4>
                </div>
                <div id="collapseQ3" class="panel-collapse collapse">
                  <div class="panel-body">
                    청약기간동안 받은 상품들을 다른 투자자분과 거래하실 수 있습니다. 가치가 떨어질 것 같다면 처분하시고, 가치가 오를 것 같으면 확보하십시오! 이를 통해 투자자 스스로 리스크관리와 더불어 최대의 이익을 얻을 수도 있습니다!
                  </div>
                </div>
              </div>
              <div class="panel">
                <div class="panel-heading">
                  <h4 class="panel-title">
                    <a data-toggle="collapse" data-parent="#accordion" href="#collapseQ4">
                      clear 단계는 어떻게 이뤄지나요?
                    </a>
                  </h4>
                </div>
                <div id="collapseQ4" class="panel-collapse collapse">
                  <div class="panel-body">
                    clear 단계에 돌입하면, 다른 투자자와의 거래가 불가해집니다. 이후 최상의 매입자를 모집합니다. 매입자에게 판매한 후 투자자분들의 보유율만큼 차익을 분배합니다!
                  </div>
                </div>
              </div>
              <div class="panel">
                <div class="panel-heading">
                  <h4 class="panel-title">
                    <a data-toggle="collapse" data-parent="#accordion" href="#collapseQ5">
                      비전이 있나요?
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