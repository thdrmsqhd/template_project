document.addEventListener("DOMContentLoaded", function () {
  const form = document.getElementById("signin-form");
  const emailEl = document.getElementById("email");
  const passwordEl = document.getElementById("password");
  const passwordCheckEl = document.getElementById("passwordCheck");

  function showError(element, message) {
    const errorEl = document.createElement("p");
    errorEl.id = "error";
    errorEl.textContent = message;
    element.appendChild(errorEl);
    element.focus();
  }

  form.addEventListener("submit", async function (event) {
    event.preventDefault();
    const email = document.getElementById("email").value;
    const password = document.getElementById("password").value;
    const passwordCheck = document.getElementById("passwordCheck").value;

    if (!email) {
      showError(emailEl, "Email and password are required");
      return;
    }
    if (!password) {
      showError(passwordEl, "Email and password are required");
      return;
    }
    if (!passwordCheck) {
      showError(passwordCheckEl, "Email and password are required");
      return;
    }

    const data = {
      email: email,
      password: password,
    };
    const response = await fetch("/api/signin", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(data),
    });

    if (response.status === 200) {
      // TODO: 로그인 성공시 전환 화면 추가
      window.location.href = "/home";
    } else {
      const responseData = response.data;
      // TODO: 로그인 실패시 처리
      console.log(responseData.message);
    }
  });
});
