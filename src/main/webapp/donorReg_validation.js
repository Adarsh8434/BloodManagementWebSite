function validateForm() {
    var fullName = document.getElementById("fullName").value;
    var bloodGroup = document.getElementById("bloodGroup").value;
    var mobileNumber = document.getElementById("mobileNumber").value;
    var state = document.getElementById("state").value;
    var district = document.getElementById("district").value;
    var email = document.getElementById("email").value;
    var username = document.getElementById("username").value;
    var password = document.getElementById("password").value;
    var retypePassword = document.getElementById("retypePassword").value;

    if (fullName === "" || bloodGroup === "" || mobileNumber.length < 10 ||
        state === "" || district === "" || email === "" || email.indexOf("@") === -1 ||
        username === "" || password.length < 8 || password !== retypePassword) {
        alert("Please fill in all the required fields correctly.");
        return false;
    }

    return true;
}
