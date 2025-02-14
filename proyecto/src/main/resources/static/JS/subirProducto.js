document.getElementById("btnEnviar").addEventListener("click", function (e) {
  e.preventDefault();

  // Verificar si hay un token en el sessionStorage
  const token = sessionStorage.getItem("token");
  if (!token) {
    alerta.classList.remove("d-none");
    alerta.innerHTML = "No tienes autorización para crear productos. Inicia sesión primero.";
    return;
  }

  const nombre = document.getElementById("productName").value.trim();
  const descripcion = document.getElementById("productDescription").value.trim();
  const categoriaElement = document.getElementById('productCategory').options[document.getElementById('productCategory').selectedIndex];
  const precio = document.getElementById("productPrice").value.trim();
  const stock = document.getElementById("productStock").value.trim();
  const alerta = document.getElementById("alerta");
  const imagen = document.querySelector('#imagenProducto');

  function normalizarTexto(texto) {
    return texto
      .toLowerCase()
      .normalize("NFD")
      .replace(/[\u0300-\u036f]/g, ""); // Elimina acentos
  }

  let errores = [];
  if (nombre === "") errores.push("El nombre del producto es obligatorio.");
  if (descripcion === "") errores.push("La descripción no puede estar vacía.");
  if (categoriaElement.value == 0) errores.push("Debes seleccionar una categoría.");
  if (!precio || isNaN(precio) || parseFloat(precio) <= 0) errores.push("El precio debe ser un número mayor a 0.");
  if (!stock || isNaN(stock) || parseInt(stock, 10) < 0) errores.push("El stock debe ser un número mayor o igual a 0.");
  if (!imagen.src || imagen.src === "") errores.push("Debe seleccionarse una imagen para el producto.");

  if (errores.length > 0) {
    alerta.classList.remove("d-none");
    alerta.innerHTML = errores.join("<br>");
    return;
  } else {
    alerta.classList.remove("d-none");
    alerta.innerHTML = "¡Producto creado exitosamente!";
  }

  // **Objeto producto con categoría normalizada**
  const producto = {
    "name": nombre,
    "description": descripcion,
    "image": imagen.src,
    "price": parseFloat(precio),
    "category": normalizarTexto(categoriaElement.value),
    "stock": parseInt(stock, 10)
  };

<<<<<<< HEAD
  // **Enviar al backend con fetch**
  fetch("http://18.191.30.217/api/productos/", {
    method: "POST",
    headers: { 
      "Content-Type": "application/json",
      "Authorization": `Bearer ${token}`  // Enviar el token en el encabezado de la solicitud
    },
    body: JSON.stringify(producto)
  })
  .then(response => {
    if (!response.ok) throw new Error("Error en la respuesta del servidor");
    return response.json();
  })
  .then(data => {
    console.log("Producto creado:", data);
    alerta.innerHTML += "<br>Producto guardado en la base de datos.";
    limpiarFormulario();
  })
  .catch(error => {
    console.error("Error:", error);
    alerta.innerHTML += "<br>Error al guardar el producto en el servidor.";
  });
=======
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
>>>>>>> 63175d4457a63c490a8b52abd6dd619d272439bb
});

// **Función para limpiar el formulario**
function limpiarFormulario() {
  document.getElementById("productName").value = "";
  document.getElementById("productDescription").value = "";
  document.getElementById("productCategory").value = "";
  document.getElementById("productPrice").value = "";
  document.getElementById("productStock").value = "";
  document.getElementById("imagenProducto").src = ""; 
}
