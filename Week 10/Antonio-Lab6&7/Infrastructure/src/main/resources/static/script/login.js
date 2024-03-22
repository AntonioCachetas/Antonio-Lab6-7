document.addEventListener('DOMContentLoaded', function() {
    var loginType = document.getElementById('loginType');
    var urlParams = new URLSearchParams(window.location.search);
    var type = urlParams.get('type');


    if (type === 'admin') {
        loginType.textContent = 'Admin Login';
        document.getElementById('student-link').style.display = 'block';
    } else {
        loginType.textContent = 'Customer Login';
        document.getElementById('admin-link').style.display = 'block';
    }
});
