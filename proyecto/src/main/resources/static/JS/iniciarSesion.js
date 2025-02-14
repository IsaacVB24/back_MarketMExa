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
    loginForm.addEventListener("submit", (e) => {
        e.preventDefault();
        const email = emailField.value.trim();
        const password = passwordField.value.trim();
      
        // Limpiar alertas previas
        alertContainer.innerHTML = "";
      
        // Validar campos
        if (!email || !password) {
          showAlert("Por favor, completa todos los campos antes de iniciar sesión.", "danger");
          return;
        }
      
        if (esCorreoInvalido(email)) {
          showAlert("Por favor, ingresa un correo electrónico válido.", "danger");
          return;
        }
      
        // Enviar solicitud de login
        const usuarios = JSON.parse(sessionStorage.getItem("archivoCuenta")) || [];
        const usuarioEncontrado = usuarios.find(usuario => usuario.email === email && usuario.password === password);
      
        if (usuarioEncontrado) {
          usuarioEncontrado.isLoggedIn = true;
          sessionStorage.setItem("archivoCuenta", JSON.stringify(usuarios));
          sessionStorage.setItem("logueado", "true");
          window.location.href = "/HTML/listaProductos.html";
        } else {
          showAlert("Correo electrónico o contraseña incorrectos.", "danger");
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