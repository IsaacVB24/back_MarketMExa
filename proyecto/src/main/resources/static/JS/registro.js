document.addEventListener("DOMContentLoaded", () => {
    const usernameField = document.getElementById("username");
    const emailField = document.getElementById("email");
    const passwordField = document.getElementById("pass");
    const alertContainer = document.getElementById("alertContainer");
    const registroForm = document.getElementById("formularioRegistro");

    // Validar formulario al enviar
    registroForm.addEventListener("submit", (e) => {
        e.preventDefault();
        const username = usernameField.value.trim();
        const email = emailField.value.trim();
        const password = passwordField.value.trim();
      
        // Limpiar alertas previas
        alertContainer.innerHTML = "";
      
        // Validar campos
        if (!username || !email || !password) {
          showAlert("Por favor, completa todos los campos para registrarte.", "danger");
          return;
        }
      
        if (esCorreoInvalido(email)) {
          showAlert("Por favor, ingresa un correo electrónico válido.", "danger");
          return;
        }
      
        if (esPasswordIncorrecto(password)) {
          showAlert("La contraseña debe tener al menos 8 caracteres, incluyendo una mayúscula, una minúscula, un número y un carácter especial.", "danger");
          return;
        }
      
        // Guardar el nuevo usuario en sessionStorage
        const usuarios = JSON.parse(sessionStorage.getItem("archivoCuenta")) || [];
        if (usuarios.some(usuario => usuario.email === email)) {
          showAlert("El correo electrónico ya está registrado.", "danger");
          return;
        }
      
        usuarios.push({ username, email, password, isLoggedIn: false });
        sessionStorage.setItem("archivoCuenta", JSON.stringify(usuarios));
        showAlert("Registro exitoso. Ahora puedes iniciar sesión.", "success");

        // Redirigir a la página de inicio de sesión
        setTimeout(() => {
            window.location.href = "/HTML/iniciarSesion.html";
        }, 2000);
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

    function esPasswordIncorrecto(password) {
        const regexContr = /^(?=.*[A-Z])(?=.*[a-z])(?=.*[\W_]).{8,}$/;
        return !regexContr.test(password);
    }
});