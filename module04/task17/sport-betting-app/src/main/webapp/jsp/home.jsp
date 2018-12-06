<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
  <title>Sports bet</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
      <link rel="stylesheet" href="../css/bootstrap.min.css">
      <script src="../js/bootstrap.min.js"></script>
  <script>
  function validate()
  {
   var username = document.accountInfo.username.value;
   var birthday = document.accountInfo.birthday.value;
   var account = document.accountInfo.account.value;
   var currency = document.accountInfo.currencySelect.value;
   var balance = document.accountInfo.balance.value;

   if (username==null || username=="")
   {
   alert("User Name can't be blank");
   return false;
   }
   else if (birthday==null || birthday=="")
   {
   alert("Date of birth can't be blank");
   return false;
   }
   else if (account==null || account=="")
   {
   alert("Account number can't be blank");
   return false;
   }
   else if (balance==null || balance=="")
   {
   alert("Balance can't be blank");
   return false;
   }
  </script>
  <style>
  .fakeimg {
      height: 200px;
      background: #aaa;
  }
  </style>
</head>
<body>
<div class="container">
<div class="card border-primary">
  <div class="card-header text-white bg-primary">Account details</div>
  <div class="card-body">
    <form action="RegisterServlet" method="post" onsubmit="return validate()">
      <div id="accountInfo" class="input-group form-group" >
        <div class="input-group-prepend">
          <span class="input-group-text">Name</span>
        </div>
        <input class="form-control" id="username" required="" type="text" placeholder="Arnold Schwarzenegger">
        <div class="invalid-feedback" style="width: 100%;">
          Your username is required.
        </div>
      </div>

      <div class="input-group form-group">
        <div class="input-group-prepend">
          <span class="input-group-text">Date of Birth:</span>
        </div>
        <input class="form-control" id="birthday" required="" type="text" placeholder="1947-07-30">
        <div class="invalid-feedback" style="width: 100%;">
          Your date of Birth is required.
        </div>
      </div>

      <div class="input-group form-group">
        <div class="input-group-prepend">
          <span class="input-group-text">Account number:</span>
        </div>
        <input class="form-control" id="account" required="" type="text" placeholder="12345678-12345678">
        <div class="invalid-feedback" style="width: 100%;">
          Your account number is required.
        </div>
      </div>
      <div class="input-group form-group">
        <div class="input-group-prepend">
          <span class="input-group-text">Currency:</span>
        </div>
        <select class="custom-select" id="currencySelect" required="">
          <option value="USD">USD</option>
          <option value="EUR">EUR</option>
        </select>
        <div class="invalid-feedback" style="width: 100%;">
          Your currency is required.
        </div>
      </div>

      <div class="input-group form-group">
        <div class="input-group-prepend">
          <span class="input-group-text">Balance:</span>
        </div>
        <input class="form-control" id="balance" required="" type="text" placeholder="99999999">
        <div class="invalid-feedback" style="width: 100%;">
          Your balance is required.
        </div>
      </div>

      <button type="submit" class="btn btn-primary">Save</button>
    </form>
  </div>
</div>
</div>
<br>
<div class="container">
<div class="card border-primary">
  <div class="card-header text-white bg-primary">Wagers</div>
  <div class="card-body">
    <div class="table-responsive">
    <table class="table table-sm text-nowrap row-eq-height">
    <thead>
    <tr>
      <th></th>
      <th>#</th>
      <th>Event title</th>
      <th>Event type</th>
      <th>Bet type</th>
      <th>Outcome value</th>
      <th>Outcome odd</th>
      <th>Wager amount</th>
      <th>Winner</th>
      <th>Processed</th>
    </tr>
    </thead>
    <tbody>
    <tr>
      <td>
        <button type="submit" class="btn btn-primary">Remove</button>
      </td>
      <th scope="row"> 1 </th>
      <td>MTK-FTC - 2018.01.12</td>
      <td>Football match</td>
      <td>Winner</td>
      <td>MTK</td>
      <td>1:2</td>
      <td>10 000 USD</td>
      <td>-</td>
      <td>-</td>
    </tr>
    <tr>
      <td></td>
      <th scope="row"> 2 </th>
      <td>MTK-FTC - 2018.01.12</td>
      <td>Football match</td>
      <td>Goals</td>
      <td>5</td>
      <td>1:3</td>
      <td>10 000 USD</td>
      <td>Yes</td>
      <td>Yes</td>
    </tr>
    <tr>
      <td></td>
      <th scope="row"> 3 </th>
      <td>MTK-FTC - 2018.01.12</td>
      <td>Football match</td>
      <td>Winner</td>
      <td>FTC</td>
      <td>1:5</td>
      <td>10 000 USD</td>
      <td>No</td>
      <td>Yes</td>
    </tr>
    </tbody>
  </table>
</div>
</div>
</div>
</div>
</body>
</html>

