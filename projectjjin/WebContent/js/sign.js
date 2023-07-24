$(function() {
  // 로그인/회원가입 탭 클릭 시 해당 폼 보이기/가리기
  $('.tabs .tab').click(function() {
    $('.tabs .tab').removeClass('active');
    $(this).addClass('active');
    $('.cont').hide();
    
    if ($(this).hasClass('signin')) {
      $('.signin-cont').show();
    } else if ($(this).hasClass('signup')) {
      $('.signup-cont').show();
    }
  });

  // 회원가입 폼 유효성 검사
  $('#signup form').validate({
    rules: {
      name: {
        required: true
      },
      email: {
        required: true,
        email: true
      },
      password: {
        minlength: 6,
        required: true
      },
    },
    success: function(label) {
      label.addClass('valid');
    },
    errorPlacement: function(error, element) {
      error.insertAfter(element);
      error.addClass('valid');
    }
  });

  $('#login').click(function(event) {
    event.preventDefault(); // 기본 동작인 페이지 이동을 막음
    
    var emailValue = $('#email').val();
    var passwordValue = $('#password').val();
    
    if (emailValue !== '' && passwordValue !== '') {
      // 입력값이 비어있지 않을 때에만 페이지 이동
      window.location.href = 'http://localhost:8888/projectjjin/index.html';
    } else {
      // 입력값이 비어있을 때 추가적인 처리나 메시지 표시 등을 할 수 있습니다.
    }
  });
  
    $('#sign up').click(function(event) {
    event.preventDefault(); // 기본 동작인 페이지 이동을 막음
    
    var nameValue = $('#name').val();
    var emailValue = $('#email').val();
    var passwordValue = $('#password').val();
    
    if (nameValue !== '' && emailValue !== '' && passwordValue !=='') {
      // 입력값이 비어있지 않을 때에만 페이지 이동
      window.location.href = 'http://localhost:8888/projectjjin/html/sign.html#signin';
    } else {
      // 입력값이 비어있을 때 추가적인 처리나 메시지 표시 등을 할 수 있습니다.
    }
  });
  

  $('.container .bg').mousemove(function(e) {
    var amountMovedX = (e.pageX * -1 / 30);
    var amountMovedY = (e.pageY * -1 / 9);
    $(this).css('background-position', amountMovedX + 'px ' + amountMovedY + 'px');
  });
});


function switchTab(tabName) {
  // Remove the "active" class from the current active tab
  var activeTab = document.querySelector('.tab.active');
  activeTab.classList.remove('active');

  // Hide the current active content
  var activeContent = document.querySelector('.cont.active');
  activeContent.classList.remove('active');

  if (tabName === 'signup') {
    // Add the "active" class to the signup tab
    var signupTab = document.querySelector('.tab.signup');
    signupTab.classList.add('active');

    // Show the signup content
    var signupContent = document.getElementById('signup');
    signupContent.classList.add('active');
  } else {
    // Add the "active" class to the signin tab
    var signinTab = document.querySelector('.tab.signin');
    signinTab.classList.add('active');

    // Show the signin content
    var signinContent = document.querySelector('.signin-cont');
    signinContent.classList.add('active');
  }
}