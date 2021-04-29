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
                  <a class="selected"><p>item</p></a>
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
                <li class="item_li">
                  <div class="row item_small">
                    <div class="image_box col-lg-4 col-xs-4">
                      <img src="/css/img/item_small_noback.png" alt="item_image_small">
                    </div>
                    <p class="col-lg-4 col-xs-5 text-center">스폰지밥  IPO</p>
                    <p class="col-lg-4 col-xs-5 text-center">수익률  30%</p>
                  </div>
                </li>
                <li class="item_li">
                  <div class="row item_small">
                    <div class="image_box col-lg-4 col-xs-4">
                      <img src="/css/img/item_small_noback.png" alt="item_image_small">
                    </div>
                    <p class="col-lg-4 col-xs-5 text-center">스폰지밥  Trading</p>
                    <p class="col-lg-4 col-xs-5 text-center">수익률  30%</p>
                  </div>
                </li>
                <li class="item_li">
                  <div class="row item_small">
                    <div class="image_box col-lg-4 col-xs-4">
                      <img src="/css/img/item_small_noback.png" alt="item_image_small">
                    </div>
                    <p class="col-lg-4 col-xs-5 text-center">스폰지밥  Clearing</p>
                    <p class="col-lg-4 col-xs-5 text-center">수익률  30%</p>
                  </div>
                </li>
                <li class="item_li">
                  <div class="row item_small">
                    <div class="image_box col-lg-4 col-xs-4">
                      <img src="/css/img/item_small_noback.png" alt="item_image_small">
                    </div>
                    <p class="col-lg-4 col-xs-5 text-center">스폰지밥  IPO</p>
                    <p class="col-lg-4 col-xs-5 text-center">수익률  30%</p>
                  </div>
                </li>
                <li class="item_li">
                  <div class="row item_small">
                    <div class="image_box col-lg-4 col-xs-4">
                      <img src="/css/img/item_small_noback.png" alt="item_image_small">
                    </div>
                    <p class="col-lg-4 col-xs-5 text-center">스폰지밥  IPO</p>
                    <p class="col-lg-4 col-xs-5 text-center">수익률  30%</p>
                  </div>
                </li>
                <li class="item_li">
                  <div class="row item_small">
                    <div class="image_box col-lg-4 col-xs-4">
                      <img src="/css/img/item_small_noback.png" alt="item_image_small">
                    </div>
                    <p class="col-lg-4 col-xs-5 text-center">스폰지밥  IPO</p>
                    <p class="col-lg-4 col-xs-5 text-center">수익률  30%</p>
                  </div>
                </li>
                <li class="item_li">
                  <div class="row item_small">
                    <div class="image_box col-lg-4 col-xs-4">
                      <img src="/css/img/item_small_noback.png" alt="item_image_small">
                    </div>
                    <p class="col-lg-4 col-xs-5 text-center">스폰지밥  IPO</p>
                    <p class="col-lg-4 col-xs-5 text-center">수익률  30%</p>
                  </div>
                </li>
                <li class="item_li">
                  <div class="row item_small">
                    <div class="image_box col-lg-4 col-xs-4">
                      <img src="/css/img/item_small_noback.png" alt="item_image_small">
                    </div>
                    <p class="col-lg-4 col-xs-5 text-center">스폰지밥  IPO</p>
                    <p class="col-lg-4 col-xs-5 text-center">수익률  30%</p>
                  </div>
                </li>
                <li class="item_li">
                  <div class="row item_small">
                    <div class="image_box col-lg-4 col-xs-4">
                      <img src="/css/img/item_small_noback.png" alt="item_image_small">
                    </div>
                    <p class="col-lg-4 col-xs-5 text-center">스폰지밥  IPO</p>
                    <p class="col-lg-4 col-xs-5 text-center">수익률  30%</p>
                  </div>
                </li>
                <li class="item_li">
                  <div class="row item_small">
                    <div class="image_box col-lg-4 col-xs-4">
                      <img src="/css/img/item_small_noback.png" alt="item_image_small">
                    </div>
                    <p class="col-lg-4 col-xs-5 text-center">스폰지밥  IPO</p>
                    <p class="col-lg-4 col-xs-5 text-center">수익률  30%</p>
                  </div>
                </li>
                <li class="item_li">
                  <div class="row item_small">
                    <div class="image_box col-lg-4 col-xs-4">
                      <img src="/css/img/item_small_noback.png" alt="item_image_small">
                    </div>
                    <p class="col-lg-4 col-xs-5 text-center">스폰지밥  IPO</p>
                    <p class="col-lg-4 col-xs-5 text-center">수익률  30%</p>
                  </div>
                </li>
                
              </ul>
            </div>
          </div>
          <div class="item_detail col-lg-7 col-xs-7">
            <div class="row contract">
              <button class="btn btn-lg col-lg-4 col-xs-4 pull-left buy_btn"> 청약 / 매수 </button>
              <button class="btn btn-lg col-lg-4 col-xs-4 pull-right sell_btn"> 청약취소 / 매도 </button>
            </div>
            <div style="overflow:auto; width:100%; height: 69vh;">
              <div class="item_image">
                <img src="/css/img/item.jpg" alt="detail_image">
              </div>
              <div class="item_container">
                <div class="row item_info item_name text-center">
                  <p class="col-lg-6 col-xs-6">상품 이름</p>
                  <p class="col-lg-6 col-xs-6">스폰지밥 얼굴 </p>
                </div>
                <div class="row item_info item_price text-center">
                  <p class="col-lg-6 col-xs-6">상품 가격</p>
                  <p class="col-lg-6 col-xs-6">1,000,000원</p>
                </div>
                <div class="row item_info item_piece text-center">
                  <p class="col-lg-6 col-xs-6">상품 조각</p>
                  <p class="col-lg-6 col-xs-6">100</p>
                </div>
                <div class="row item_info item_piece_price text-center" >
                  <p class="col-lg-6 col-xs-6">조각 당 가격</p>
                  <p class="col-lg-6 col-xs-6">10,000원</p>
                </div>
                <div class="row item_info item_explain text-center">
                  <p class="col-lg-12">
                    1999년 5월 1일 키즈 초이스 어워드에서 처음으로 방영한 바닷속의 도시인 비키니 시티(Bikini Bottom)에서 벌어지는 이야기를 다룬 시트콤 형식의 코미디 애니메이션. 타임지 선정 '최고의 애니메이션'이며, 니켈로디언 키즈 초이스 어워드 최우수 애니메이션 부분 15회 최다 수상작이자 자타공인 니켈로디언의 최고 전성기를 이끈 애니메이션이다. 매일 전 세계 2천7백만 명이 시청했다고 하며, 초창기 포켓몬스터의 광풍을 시청률에서 잡아버린 작품도 이것이다. 지금도 헌신적인 니켈로디언의 대표 인기 애니메이션이지만, 같이 니켈로디언을 대표했던 티미의 못 말리는 수호천사가 종영되면서 니켈로디언의 최후의 보루작으로 남게 되었다.</p>
                </div>
                <div class="chart">
                  <h1>차트가 들어갈 공간입니다.</h1>
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
export default catalogue;