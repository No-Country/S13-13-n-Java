export interface ChatMessage {
  id?: number; // ID único del mensaje
  url_img: string; // Foto del remitente
  sender: string; // Nombre del remitente
  content: string; // Contenido del mensaje
  timestamp: Date; // Fecha y hora del mensaje
}
