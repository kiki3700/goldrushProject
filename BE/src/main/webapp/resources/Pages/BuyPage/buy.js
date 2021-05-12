const buy = `
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

<section>
  <div class="container service">
    <h1 class="text-center"></h1>
    <hr class="style-five">
    <div class="scroll" style="overflow:auto; width:100%; height:32vh;">
      <table class="table text-center">
        <thead>
          <tr>
            <th scope="col" class="text-center">가격</th>
            <th scope="col" class="text-center">수량</th>
          </tr>
        </thead>  
        <tbody>
          
        </tbody>
      </table>
    </div>
    <hr class="style-five">
    <div class="buy">
      <div class="sell_item">  
        <input type="number" class="form-control" placeholder="수량을 입력하세요.">
        <input type="text" class="form-control reserve_item" disabled>
        <button type="submit" class="btn-lg">처분</button>
      </div>
      <div class="buy_offer">
        <input type="number" class="form-control" placeholder="가격을 입력하세요.">
        <input type="number" class="form-control" placeholder="수량을 입력하세요.">
        <button type="submit" class="btn-lg">매수 오퍼</button>
      </div>  
    </div>
  </div>
</section>

<footer>
  <div class="col-lg-12 col-xs-12 text-center footer_content">
    4주 프로젝트
  </div>
</footer>`

export default buy;