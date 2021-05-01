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
                  <a href="#manager" class="selected"><p>상품 관리</p></a>
                  <a href="#enroll"><p>상품 등록</p></a>
                  <a href="#userManage"><p>회원 관리</p></a>
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
            <div class="item_image">
              <img src="/css/img/item.jpg" alt="detail_image">
              <input type="file" name="" id="">
            </div>
            <div class="item_container">
              <div class="row item_info">
                <p class="col-lg-6 col-xs-6 name">스폰지밥</p>
                <input type="text">
              </div>
              <div class="row item_info">
                <p class="col-lg-6 col-xs-6 cost">10000000원</p>
                <input type="text">
              </div>
              <div class="row item_info">
                <p class="col-lg-6 col-xs-6 piece">300조각</p>
                <input type="text">
              </div>
              <div class="row item_info">
                <p class="col-lg-6 col-xs-6 ipo">IPO Stage - 2021.04.23</p>
                <input type="text">
              </div>
              <div class="row item_info">
                <p class="col-lg-6 col-xs-6 trading">Trading Stage - 2021.05.12</p>
                <input type="text">
              </div>
              <div class="row item_info">
                <p class="col-lg-6 col-xs-6 clearing">Clearing Stage - 2021.05.13</p>
                <input type="text">
              </div>
              <div class="row item_info">
                <textarea class="col-lg-12 item_Description"></textarea>
              </div>
              <div class="button-group">
                <button type="button" class="btn btn-outline-info update_item">수정</button>
                <button type="button" class="btn btn-outline-info delete_item">삭제</button>
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
export default manager;