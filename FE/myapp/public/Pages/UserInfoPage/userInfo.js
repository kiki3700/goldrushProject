const userInfo = `
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
                <p><a href="#userInfo" class="selected"><span class="glyphicon glyphicon-cog" aria-hidden="true"> MyInfo</span></a></p>
                <p><a href="#qna"><span class="glyphicon glyphicon-question-sign" aria-hidden="true"> QNA</span></a></p>
                <p><a href="#contact"><span class="glyphicon glyphicon-envelope" aria-hidden="true"> Contact</span></a></p>
              </div>
            </div>
          </div>
          <div class="follow_menu col-lg-10 col-xs-10">
            <div style="overflow:auto; width:100%; height:79vh;">
              <div class="account_info">
                <h1>충전 • 환전</h1>
                <div class="account_transfer">
                  <input type="number" class="form-control amount" placeholder="충전, 환전하실 금액을 입력해주세요."/>
                  <br>
                  <button class="btn btn-sm charge_money">충전</button>
                  <button class="btn btn-sm discharge_money">환전</button>
                </div> 
              </div>
              <div class="portfolio">
                <h1>포트폴리오</h1>
                <table class="table portfolio_table">
                  <thead>
                    <tr>
                      <th scope="col">상품 이름</th>
                      <th scope="col">평균 단가</th>
                      <th scope="col">현재 가격</th>
                      <th scope="col">수량</th>
                      <th scope="col">수익률</th>
                    </tr>
                  </thead>
                  <tbody>
                    
                  </tbody>
                  <tfoot>  
                    
                  <tfoot>
                </table>
              </div>
              <div class="check_log">
                <h1>계좌 내역</h1>
                <table id="collapseTableOne" class="table check_log_table">
                  <thead>
                    <tr>
                      <th scope="col">날짜</th>
                      <th scope="col">구매/판매 | 충전/환전 </th>
                      <th scope="col">금액</th>
                    </tr>
                  </thead>
                  <tbody>
                    
                  </tbody>
                </table>
                <p class="pull-right account"></p> 
              </div>
              
              <div class="offer_log">
                <h1>호가 내역</h1>
                <table class="table offer_log_table">
                  <thead>
                    <tr>
                      <th scope="col">호가 번호</th>
                      <th scope="col">상품 이름</th>
                      <th scope="col">호가 가격</th>
                      <th scope="col">수량</th>
                      <th scope="col">등록시간</th>
                      <th scope="col">호가 취소</th>
                    </tr>
                  </thead>
                  <tbody>
                    <tr>
                      
                    </tr>
                  </tbody>
                </table>
              </div>
              <div class="change_id_pwd">
                <h1>회원정보수정</h1>
                <div class="form-group">
                  <label for="pwdcheck">회원님의 비밀번호</label>
                  <input type="password" class="form-control" id="pwdcheck" placeholder="변경하실 비밀번호를 적어주세요.">
                  <input type="password" class="form-control" id="pwd_double_check" placeholder="다시 한번 적어주세요">
                  <small>
                    <div class="check_pwd">
                      비밀번호가 일치합니다
                    </div>
                  </small>
                  <br>
                  <button class="btn update_user" disabled>
                    내 정보 수정
                  </button>
                  <button class="btn delete_user">
                    회원 탈퇴
                  </button>
                
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
  </footer>`

  export default userInfo;