export interface ChatMessage {
  id: number; // ID único del mensaje
  sender: string; // Nombre del remitente
  content: string; // Contenido del mensaje
  timestamp: Date; // Fecha y hora del mensaje
}
