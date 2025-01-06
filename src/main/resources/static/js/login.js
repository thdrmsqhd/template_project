document.addEventListener("DOMContentLoaded", function () {
  const form = document.getElementById("login");
  const emailEl = document.getElementById("email");
  const passwordEl = document.getElementById("password");

  form.addEventListener("submit", async function (event) {
    event.preventDefault();
    const email = emailEl.value;
    const password = passwordEl.value;

    const emailErrorEl = document.getElementById("email-error");
    const passwordErrorEl = document.getElementById("password-error");

    if (!email) {
      showError(emailErrorEl, "이메일은 필수 정보 입니다.");
      emailEl.focus();
      return;
    }
    if (!email.includes("@")) {
      showError(emailErrorEl, "이메일 형식이 올바르지 않습니다.");
      emailEl.focus();
      return;
    }
    if (!password) {
      showError(passwordErrorEl, "비밀번호는 필수 정보 입니다.");
      passwordEl.focus();
      return;
    }

    const response = await fetch("/api/auth/login", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({
        email: email,
        password: password,
      }),
    });

    const data = await response.json();
    if (response.status === 200) {
      if (data) {
        console.log(data);
      } else {
        console.log("로그인 실패");
      }
    } else {
      console.log("로그인 실패");
    }
  });
});

function showError(element, message) {
  element.innerText = "";
  element.style.display = "block";
  element.innerText = message;
}
