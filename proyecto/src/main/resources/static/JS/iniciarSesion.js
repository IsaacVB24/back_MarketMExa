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
        const myHeaders = new Headers();
        myHeaders.append("Content-Type", "application/json");
        const raw = JSON.stringify({ "email": email, "pass": password });
        const requestOptions = {
            method: "POST",
            headers: myHeaders,
            body: raw,
            redirect: "follow"
        };

        fetch("http://18.191.30.217/api/login/", requestOptions)
            .then((response) => {
                if (!response.ok) {
                    // Manejar errores de autenticación
                    throw new Error('Correo o contraseña incorrectos');
                }
                return response.json();
            })
            .then((result) => {
                // Mostrar bienvenida y redirigir
                showAlert("¡Bienvenido/a!", "success");
                localStorage.setItem('logueado', 'true');
                localStorage.setItem('usuarioLogueado', JSON.stringify({ username: email })); // AÑADIDO: GUARDAR USUARIO LOGUEADO EN LOCALSTORAGE
                sessionStorage.setItem('token', JSON.stringify(result.access)); // AÑADIDO: ALMACENAR TOKEN COMO JSON EN SESSIONSTORAGE
                setTimeout(() => {
                    window.location.href = "/HTML/listaProductos.html";
                }, 2000);
            })
            .catch((error) => {
                // Mostrar alerta de error
                showAlert(error.message, "danger");
            });
    });

    // Mostrar alertas
    function showAlert(message, type) {
        const alertHTML = `
            <div class="alert alert-${type} alert-dismissible fade show" role="alert">
                ${message}
                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
            </div>
        `;
        alertContainer.innerHTML = alertHTML;
        // Limpiar alerta después de 3 segundos
        setTimeout(() => {
            alertContainer.innerHTML = "";
        }, 3000);
    }

    // Función para validar el correo electrónico
    function esCorreoInvalido(email) {
        const re = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
        return !re.test(email);
    }
});