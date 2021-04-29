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
                <a class="selected" href="#userInfo"><p>My Info</p></a>
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
                <a href="#qna"><p>QNA</p></a>
                <a href="#contact"><p>Contact</p></a>
              </div>
            </div>
          </div>
          <div class="follow_menu col-lg-10 col-xs-10">
            <div style="overflow:auto; width:100%; height:79vh;">
              <div class="account_info">
                <h1>계좌 정보</h1>
                <div class="account_transfer">
                  잔액 : <b>300000</b>
                  <button class="btn btn-sm charge_money">입금</button>
                  <button class="btn btn-sm discharge_money">출금</button>
                </div> 
              </div>
              <div class="portfolio">
                <h1>Portfolio</h1>
                <table class="table portfolio_table">
                  <thead>
                    <tr>
                      <th scope="col">아이템 ID</th>
                      <th scope="col">구매 가격</th>
                      <th scope="col">현재 가격</th>
                      <th scope="col">수량</th>
                      <th scope="col">수익률</th>
                    </tr>
                  </thead>
                  <tbody>
                    <tr>
                      <th scope="row">스폰지밥</th>
                      <td>10000원</td>
                      <td>20000원</td>
                      <td>1</td>
                      <td>100%</td>
                    </tr>
                    <tr>
                      <th scope="row">Total</th>
                      <td>10000원</td>
                      <td>20000원</td>
                      <td>1</td>
                      <td>100%</td>
                    </tr>
                  </tbody>
                </table>
              </div>
              <div class="check_log">
                <h1>account_log</h1>
                <table id="collapseTableOne" class="table check_log_table">
                  <thead>
                    <tr>
                      <th scope="col">날짜</th>
                      <th scope="col">입 / 출</th>
                      <th scope="col">금액</th>
                    </tr>
                  </thead>
                  <tbody>
                    <tr>
                      <th scope="row">2021.03.12</th>
                      <td>입금</td>
                      <td>10000원</td>
                    </tr>
                  </tbody>
                </table>
                <p class="pull-right account">잔액 : 0원</p> 
              </div>
              <div class="trade_log">
                <h1>거래내역</h1>
                <table class="table trade_log_table">
                  <thead>
                    <tr>
                      <th>item</th>
                      <th>가격</th>
                      <th>양</th>
                      <th>매수 / 매도</th>
                    </tr>
                  </thead>  
                  <tbody>
                    <tr>
                      <th scope="row">스폰지밥</th>
                      <td>10000원</td>
                      <td>1</td>
                      <td>매수</td>
                    </tr>
                  </tbody>
                </table>
              </div>
              <div class="change_id_pwd">
                <h1>회원정보수정</h1>
                <div class="form-group">
                  <label for="emailcheck">회원님의 이메일</label>
                  <input type="email" class="form-control" id="emailcheck" placeholder="변경하실 이메일을 적어주세요.">
                  <small>
                    <div class="check_email">
                      이미 있는 이메일입니다.
                    </div>
                  </small>
                  <br>
                  <br>
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
  </footer>`

  export default userInfo;