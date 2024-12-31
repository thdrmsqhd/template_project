document.addEventListener("DOMContentLoaded", function () {
  const form = document.getElementById("signin-form");
  const emailEl = document.getElementById("email");
  const passwordEl = document.getElementById("password");
  const passwordCheckEl = document.getElementById("confirm-password");

  const emailErrorEl = document.getElementById("email-error");
  const passwordErrorEl = document.getElementById("password-error");
  const passwordCheckErrorEl = document.getElementById("confirm-password-error");

  const resultModal = new bootstrap.Modal(document.getElementById("resultModal"));
  const resultModalBody = document.getElementById("resultModalBody");

  function showError(element, message) {
    element.innerText = "";
    element.style.display = "block";
    element.innerText = message;
  }

  form.addEventListener("submit", async function (event) {
    event.preventDefault();
    const email = document.getElementById("email").value;
    const password = document.getElementById("password").value;
    const passwordCheck = document.getElementById("confirm-password").value;

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
    if (!passwordCheck) {
      showError(passwordCheckErrorEl, "입력한 비밀번호와 일치하지 않습니다.");
      passwordCheckEl.focus();
      return;
    }

    const response = await fetch("/user/api/sign-in", {
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
        resultModalBody.textContent = "회원가입이 성공적으로 완료되었습니다.";
        setTimeout(() => (window.location.href = "/user/log-in"), 1000);
      } else {
        resultModalBody.textContent = "회원가입에 실패했습니다. 다시 시도해주세요.";
      }
      resultModal.show();
    } else {
      resultModalBody.textContent = "오류가 발생했습니다. 다시 시도해주세요.";
      resultModal.show();
    }
  });
});
