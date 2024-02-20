import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { ChatMessage } from 'src/app/interfaces/chat-message';
import { FormBuilder, FormGroup } from '@angular/forms';
//import { ChatService } from '../../services/chat.service';

@Component({
  selector: 'app-chat-room',
  templateUrl: './chat-room.component.html',
  styleUrls: ['./chat-room.component.css']
})

export class ChatRoomComponent implements OnInit{
  isLoading: boolean = true;
  chatList: any;

  searchForm: any = FormGroup;
searchCriteria: any = '';



  constructor(/* private chatService: ChatService */ private fb: FormBuilder) {
      this.searchForm = this.fb.group({
        searchCriteria: [''], // Inicializa el campo de búsqueda
      });
    }


  // Simula una operación asíncrona, como cargar datos de un servidor
  ngOnInit() {
    setTimeout(() => {
      this.isLoading = false;
    }, 2000);

    this.searchForm.get('searchCriteria').valueChanges.subscribe(() => {
      this.updateSearch();
    });
  }

  updateSearch() {
    const criteria = this.searchForm.get('searchCriteria').value;
  
  }
  }


