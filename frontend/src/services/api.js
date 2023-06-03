import axios from "axios";

const apiClient = axios.create({
  baseURL: "http://localhost:8006", // URL base del servidor
});

apiClient.defaults.headers.common["Access-Control-Allow-Origin"] =
  "http://localhost:5173"; // Origen de la aplicación Vue
apiClient.defaults.headers.common["Access-Control-Allow-Credentials"] = "true";

export default {
  // Método para realizar una solicitud POST al endpoint /register
  register(data) {
    return apiClient.post("/register", data);
  },

  // Método para realizar otras solicitudes a tu API
  // Puedes agregar más métodos según tus necesidades
};
