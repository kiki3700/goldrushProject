const userManage = `
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
                <a href="#manager"><p>상품 관리</p></a>
                <a href="#enroll"><p>상품 등록</p></a>
                <a href="#userManage" class="selected"><p>회원 관리</p></a>
              </div>
            </div>
          </div>
          <div class="follow_menu col-lg-10 col-xs-10">
            <div style="overflow:auto; width:100%; height:79vh;">
              <div class="userSearch">
                <h1>회원정보</h1>
                <input type="text" id="search">
              </div>
              <table class="table">
                <thead>
                  <th scope="col">회원ID</th>
                  <th scope="col">회원이름</th>
                  <th scope="col">입금내역</th>
                  <th scope="col">출금내역</th>
                  <th scope="col">구매내역</th>
                  <th scope="col">판매내역</th>
                </thead>
                <tbody>
                  <tr>
                    <th scope="row">cjftn@naver.com</th>
                    <td>김철수</td>
                    <td>30000</td>
                    <td>10000</td>
                    <td>스폰지밥 : 1000</td>
                    <td>스폰지밥 : 3000</td>
                  </tr>
                  <tr>
                    <th scope="row">yongFE@google.com</th>
                    <td>곽철용</td>
                    <td>20000</td>
                    <td>20000</td>
                    <td>스폰지밥 : 2000</td>
                    <td>스폰지밥 : 2500</td>
                  </tr>
                </tbody>
              </table>
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
export default userManage;