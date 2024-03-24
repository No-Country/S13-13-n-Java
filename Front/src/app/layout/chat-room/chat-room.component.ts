import {
  Component,
  EventEmitter,
  OnInit,
  Output,
  ElementRef,
  ViewChild,
} from '@angular/core';
import { Observable } from 'rxjs';
import { Database, set, ref, update } from '@angular/fire/database';
import { FormBuilder, FormGroup } from '@angular/forms';
import { SidebarService } from 'src/app/services/sidebar.service';
//import { ChatService } from '../../services/chat.service';

@Component({
  selector: 'app-chat-room',
  templateUrl: './chat-room.component.html',
  styleUrls: ['./chat-room.component.css'],
})
export class ChatRoomComponent implements OnInit {
  isLoading: boolean = true;
  chatList: any;

  searchForm: any = FormGroup;
  searchCriteria: any = '';

  currentComponent: any;
  //////
  /* chatSeleccionado: string | null = null; */
  //////

  formulario!: FormGroup;
  mensajes: string[] = [];
  textoMostrado: string = '';
  mensajeVisible: boolean = false;

  ///////
  CleanMessages: boolean = true;

  visible: boolean = false;
  //////

  constructor(
    /* private chatService: ChatService,  */ private fb: FormBuilder,
    private sidebarService: SidebarService,
    public database:Database
  ) {
    this.searchForm = this.fb.group({
      searchCriteria: [''], // Inicializa el campo de búsqueda
    });
    /////////////////
    this.sidebarService.currentComponent$.subscribe((component) => {
      this.currentComponent = component;
    });
  }

  // Simula una operación asíncrona, como cargar datos de un servidor
  ngOnInit() {
    setTimeout(() => {
      this.isLoading = false;
    }, 2000);

    /* this.searchForm.get('searchCriteria').valueChanges.subscribe(() => {
      this.updateSearch();
    }); */
    this.cargarMensajesDesdeLocalStorage();

    this.formulario = this.fb.group({
      textoInput: [''],
    });

    /*    this.chatService.chatSeleccionado$.subscribe(chatId => {
      this.chatSeleccionado = chatId;
    });*/ //////////
  }

  updateSearch() {
    const criteria = this.searchForm.get('searchCriteria').value;
  }

  enviarTexto() {
    const nuevoMensaje = this.formulario.value.textoInput;
    this.mensajes.push(nuevoMensaje);
    this.guardarMensajesEnLocalStorage();

    this.mensajeVisible = true;

    this.formulario.reset(); // Limpiar el input después de enviar
  }

  guardarMensajesEnLocalStorage() {
    localStorage.setItem('mensajes', JSON.stringify(this.mensajes));
  }

  cargarMensajesDesdeLocalStorage() {
    const mensajesGuardados = localStorage.getItem('mensajes');
    if (mensajesGuardados) {
      this.mensajes = JSON.parse(mensajesGuardados);
      this.mensajeVisible = true; // Mostrar los mensajes al cargar la página
    }
  }

  onclick() {
    this.CleanMessages = !this.CleanMessages;
    this.visible = !this.visible;
  }

  deleteAllMessages() {
    this.mensajes = [];
    localStorage.clear();
  }
}
