const pBuy = `
<nav class="navbar navbar-inverse navbar-fixed-top">
  <div class="container">
    <div class="navbar-header">
        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
          <span class="sr-only">toggle navgation</span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
        </button>
      <a class="navbar-brand" href="#"><p class="logo">Gold Rush</p></a>
    </div>
    <div id="navbar" class="navbar-collapse collapse">
      <ul class="nav navbar-nav navbar-right">
        <li><a href="#">환영합니다! 이름님!</a></li>
        <li><a href="#">로그아웃</a></li>
      </ul>
    </div> 
  </div>
</nav>

<section>
  <div class="container service">
    <h1 class="text-center">스폰지밥 : 매수 & 오퍼</h1>
    <hr class="style-five">
    <table class="table text-center">
      <thead>
        <tr>
          <th scope="col" class="text-center">가격</th>
          <th scope="col" class="text-center">수량</th>
        </tr>
      </thead>  
      <tbody>
        <tr>
          <td>10000원</td>
          <td>100</td>
        </tr>
        <tr>
          <td>12000원</td>
          <td>100</td>
        </tr>
        <tr>
          <td>13000원</td>
          <td>100</td>
        </tr>
        <tr>
          <td>15000원</td>
          <td>100</td>
        </tr>
        <tr>
          <td>17000원</td>
          <td>100</td>
        </tr>
      </tbody>
    </table>
    <hr class="style-five">
    <div class="buy">
      <div class="buy_item">  
        <input type="number" class="form-control" placeholder="수량을 입력하세요.">
        
        <button type="submit" class="btn-lg">매수</button>
      </div>
      <div class="buy_offer">
        <input type="number" class="form-control" placeholder="가격을 입력하세요.">
        <input type="number" class="form-control" placeholder="수량을 입력하세요.">
        <button type="submit" class="btn-lg">오퍼</button>
      </div>  
    </div>
  </div>
</section>

<footer>
  <div class="col-lg-12 text-center footer_content">
    4주 프로젝트
  </div>
</footer>`

export default pBuy;