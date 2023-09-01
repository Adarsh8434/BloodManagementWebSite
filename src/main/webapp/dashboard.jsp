<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Blood Bank Dashboard</title>
    <link rel="stylesheet" href="style.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
</head>
<body>
    <header>
            <div style="background-color: rgb(236, 28, 20);">
                <header class="d-flex justify-content-center py-3">
                  <ul class="nav nav-pills">
                    <li class="nav-item"><a href="#" class="nav-link active" aria-current="page" style="color: white; background: red; margin-left: 20px; font-size: larger;">Dashboard</a></li>
                    <li class="nav-item"><a href="#" class="nav-link" style="color: white; background: red; margin-left: 20px; font-size: larger;">Manage Blood</a></li>
                    <li class="nav-item"><a href="#" class="nav-link" style="color: white; background: red; margin-left: 20px; font-size: larger;">Manage Request</a></li>
                    <li class="nav-item"><a href="#" class="nav-link" style="color: white; background: red; margin-left: 20px; font-size: larger;">Blood Issued</a></li>
                    <li class="nav-item"><a href="#" class="nav-link" style="color: white; background: red; margin-left: 20px; font-size: larger;">Log Out</a></li>
                  </ul>
                </header>
              </div>
            
        </header>
    <main>
        <h1><b>Dashboard</b></h1>
        <h2 class="bloodcount"><b>Welcome <%= session.getAttribute("bloodBankUsername") %> Blood Bank</b></h2>
        <h2 class="heading">Blood Availability Status</h2>
        <br/><br/><br/>

        <div class="boxcontainer">
            <div class="box1">
                <p><br/><b>A+ (Positive)</b><br/><br/></p>
                <p class="bloodcount"><%= bloodStock.getA_positive() %></p>
            </div>
            <div class="box2">
                <p><br/><b>B+ (Positive)</b><br/><br/></p>
                <p class="bloodcount"><%= bloodStock.getB_positive() %></p>
            </div>
            <div class="box3">
                <p><br/><b>AB+ (Positive)</b><br/><br/></p>
                <p class="bloodcount"><%= bloodStock.getAB_positive() %></p>
            </div>
            <div class="box4">
                <p><br/><b>O+ (Positive)</b><br/><br/></p>
                <p class="bloodcount"><%= bloodStock.getO_positive() %></p>
            </div>

        <br/><br/><br/>
        <div class="boxcontainer">
            <div class="box1">
                <p><br/><b>A+ (Negative)</b><br/><br/></p>
                <p class="bloodcount"><%= bloodStock.getA_negative() %></p>
            </div>
            <div class="box2">
                <p><br/><b>B+ (Negative)</b><br/><br/></p>
                <p class="bloodcount"><%= bloodStock.getB_negative() %></p>
            </div>
            <div class="box3">
                <p><br/><b>AB+ (Negative)</b><br/><br/></p>
                <p class="bloodcount"><%= bloodStock.getAB_negative() %></p>
            </div>
            <div class="box4">
                <p><br/><b>O+ (Negative)</b><br/><br/></p>
                <p class="bloodcount"><%= bloodStock.getO_negative() %></p>
            </div>
        </div>
            <br><br>

    </main>
    <footer class="py-5">
            <div class="row">
              <div class="col-6 col-md-2 mb-3">
                <h5 class="sli">Links</h5>
                <ul class="nav flex-column ">
                  <li class="nav-item mb-2"><a href="index.html" class="nav-link p-0 text-body-secondary">Home</a></li>
                  <li class="nav-item mb-2"><a href="aboutus.html" class="nav-link p-0 text-body-secondary">About Us</a></li>
                  <li class="nav-item mb-2"><a href="#" class="nav-link p-0 text-body-secondary">Notification</a></li>
                  <li class="nav-item mb-2"><a href="contactus.html" class="nav-link p-0 text-body-secondary">Contact Us</a></li>
                </ul>
              </div>
        
              <div class="col-6 col-md-2 mb-3">
                <h5 class="sli">Contact </h5>
                <ul class="nav flex-column">
                  <li class="nav-item mb-2"><a href="mailto:adarshkumar@gmail.com" class="nav-link p-0 text-body-secondary">adarshkumar@gmail.com</a></li>
                  <li class="nav-item mb-2"><a href="mailto:diksharawal786@gmail.com" class="nav-link p-0 text-body-secondary">diksharawal786@gmail.com</a></li>
                </ul>
                <h5 class="sli">Phone</h5>
                <ul class="nav flex-column">
                  <li class="nav-item mb-2"><a href="tel:8987864264" class="nav-link p-0 text-body-secondary">+91-8987864264</a></li>
                  <li class="nav-item mb-2"><a href="tel:8800173012" class="nav-link p-0 text-body-secondary">+91-8800173012</a></li>
              </div>
        
              <div class="col-md-5 offset-md-1 mb-3">
                <form>
                  <h5 class="sli">Subscribe now</h5>
                  <p>For latest updates of blood:</p>
                  <div class="d-flex flex-column flex-sm-row w-100 gap-2">
                    <label for="newsletter1" class="visually-hidden">Email address</label>
                    <input id="newsletter1" type="text" class="form-control" placeholder="Email address">
                    <button class="btn btn-primary" type="button">Subscribe</button>
                  </div>
                </form>
              </div>
            </div>
        
            <div class="d-flex flex-column flex-sm-row justify-content-between py-4 my-4 border-top">
              <p>©Authorized blood management website 2023.</p>
            </div>
          </footer>
          <script>
            // Retrieve blood bank name from session storage
            var bloodBankName = sessionStorage.getItem('BloodBankName');
            if (bloodBankName) {
                // Update the welcome message with the blood bank name
                document.getElementById('BloodBankName').textContent = bloodBankName;
            }
        </script>  
</body>
</html>
