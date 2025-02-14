document.addEventListener("DOMContentLoaded", function () {
    const btnSubirImagen = document.getElementById("btnSubirImagen");
    const inputImagen = document.getElementById("imageUpload");
    const imagenProducto = document.getElementById("imagenProducto");
    const btnEnviar = document.getElementById("btnEnviar");
    const alerta = document.getElementById("alerta");

    // Cuando se hace clic en el botón, se activa el input file
    btnSubirImagen.addEventListener("click", function () {
        inputImagen.click();
    });

    // Vista previa de la imagen seleccionada
    inputImagen.addEventListener("change", function () {
        const file = inputImagen.files[0];
        if (file) {
            const reader = new FileReader();
            reader.onload = function (e) {
                imagenProducto.src = e.target.result;
                imagenProducto.style.display = "block";
            };
            reader.readAsDataURL(file);
        }
    });

    // Evento al hacer clic en el botón de registrar producto
    btnEnviar.addEventListener("click", function (e) {
        e.preventDefault();
        alerta.classList.add("d-none");
        alerta.innerHTML = "";

        const token = sessionStorage.getItem("token");
        if (!token) {
            alerta.classList.remove("d-none");
            alerta.innerHTML = "No tienes autorización para crear productos. Inicia sesión primero.";
            return;
        }

        const nombre = document.getElementById("productName").value.trim();
        const descripcion = document.getElementById("productDescription").value.trim();
        const categoriaElement = document.getElementById("productCategory");
        const precio = document.getElementById("productPrice").value.trim();
        const stock = document.getElementById("productStock").value.trim();

        let errores = [];
        if (!nombre) errores.push("El nombre del producto es obligatorio.");
        if (!descripcion) errores.push("La descripción no puede estar vacía.");
        if (categoriaElement.value === "0") errores.push("Debes seleccionar una categoría.");
        if (!precio || isNaN(precio) || parseFloat(precio) <= 0) errores.push("El precio debe ser un número mayor a 0.");
        if (!stock || isNaN(stock) || parseInt(stock, 10) < 0) errores.push("El stock debe ser un número mayor o igual a 0.");
        if (!inputImagen.files || inputImagen.files.length === 0) {
            errores.push("Debe seleccionarse una imagen para el producto.");
        }

        if (errores.length > 0) {
            alerta.classList.remove("d-none");
            alerta.innerHTML = errores.join("<br>");
            return;
        }

        // Subir imagen a Cloudinary antes de enviar el producto al backend
        const file = inputImagen.files[0];
        const formData = new FormData();
        formData.append("file", file);
        formData.append("upload_preset", "tu_upload_preset"); // Reemplaza con tu configuración de Cloudinary

        fetch("https://api.cloudinary.com/v1_1/tu_cuenta/image/upload", {
            method: "POST",
            body: formData
        })
        .then(response => response.json())
        .then(data => {
            const producto = {
                "name": nombre,
                "description": descripcion,
                "image": data.secure_url, // URL de la imagen subida a Cloudinary
                "price": parseFloat(precio),
                "category": categoriaElement.value.toLowerCase(),
                "stock": parseInt(stock, 10)
            };

            return fetch("http://18.191.30.217/api/productos/", {
                method: "POST",
                headers: { 
                    "Content-Type": "application/json",
                    "Authorization": `Bearer: ${token}`
                },
                body: JSON.stringify(producto)
            });
        })
        .then(response => {
            if (!response.ok) throw new Error("Error en la respuesta del servidor");
            return response.json();
        })
        .then(data => {
            console.log("Producto creado:", data);
            alerta.classList.remove("d-none");
            alerta.innerHTML = "¡Producto creado exitosamente!<br>Producto guardado en la base de datos.";
            limpiarFormulario();
        })
        .catch(error => {
            console.error("Error:", error);
            alerta.classList.remove("d-none");
            alerta.innerHTML = "Error al guardar el producto en el servidor.";
        });
    });

    // **Función para limpiar el formulario**
    function limpiarFormulario() {
        document.getElementById("productName").value = "";
        document.getElementById("productDescription").value = "";
        document.getElementById("productCategory").value = "0";
        document.getElementById("productPrice").value = "";
        document.getElementById("productStock").value = "";
        document.getElementById("imageUpload").value = ""; // Limpiar input de imagen
        imagenProducto.style.display = "none"; // Ocultar vista previa
    }
});
