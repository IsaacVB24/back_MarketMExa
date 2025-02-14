document.addEventListener("DOMContentLoaded", () => {
    const passwordField = document.getElementById("pass");
    const emailField = document.getElementById("email");
    const alertContainer = document.getElementById("alertContainer");
    const rememberMe = document.getElementById("rememberMe");
    const loginForm = document.getElementById("formulario");
  
    // ícono de "ver contraseña"
    const passwordToggle = document.createElement("i");
    passwordToggle.className = "fa-regular fa-eye icon";
    passwordToggle.style.cursor = "pointer";
    passwordToggle.style.position = "absolute";
    passwordToggle.style.right = "15px";
    passwordToggle.style.top = "50%";
    passwordToggle.style.transform = "translateY(-50%)";
    passwordField.parentElement.style.position = "relative";
    passwordField.parentElement.appendChild(passwordToggle);
  
    // Alternar visibilidad de contraseña
    passwordToggle.addEventListener("click", () => {
      if (passwordField.type === "password") {
        passwordField.type = "text";
        passwordToggle.className = "fa-regular fa-eye-slash icon";
      } else {
        passwordField.type = "password";
        passwordToggle.className = "fa-regular fa-eye icon";
      }
    });
  
    // Validar formulario al enviar
  loginForm.addEventListener("submit", async (e) => {
    e.preventDefault();

    const email = emailField.value.trim();
    const password = passwordField.value.trim();

    // Limpiar alertas previas
    alertContainer.innerHTML = "";

    // Validar campos
    if (!email || !password) {
        showAlert("⚠️ Por favor, completa todos los campos.", "danger");
        return;
    }

    if (esCorreoInvalido(email)) {
        showAlert("⚠️ Ingresa un correo electrónico válido.", "danger");
        return;
    }

    try {
        const response = await fetch("http://18.191.30.217/api/login/", {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify({ email: email, pass: password })
        });

        if (response.status === 401) {
            showAlert("❌ Correo o contraseña incorrectos.", "danger");
            return;
        }

        if (!response.ok) {
            showAlert("❌ Error en el servidor. Inténtalo más tarde.", "danger");
            return;
        }

        const result = await response.json();
        showAlert("✅ ¡Bienvenido/a!", "success");
        localStorage.setItem("logueado", "true");
        sessionStorage.setItem("token", result.access);

        setTimeout(() => {
            window.location.href = "/HTML/listaProductos.html";
        }, 2000);

    } catch (error) {
        showAlert("Correo electrónico invalido", "danger");
    }
});
  
    function showAlert(message, type) {
        const alertDiv = document.createElement("div");
        alertDiv.className = `alert alert-${type}`;
        alertDiv.textContent = message;
        alertContainer.appendChild(alertDiv);
    }

    function esCorreoInvalido(correo) {
        const regexEmail = /[^@ \t\r\n]+@[^@ \t\r\n]+\.[^@ \t\r\n]+/;
        return !regexEmail.test(correo);
    }
});