import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { BrowserAnimationsModule } from "@angular/platform-browser/animations";
import { AppComponent } from './app.component';
import { SharedModule } from './shared/shared.module';
import { HttpClientModule } from '@angular/common/http';

/* import { AngularFireModule } from '@angular/fire'; */
import { initializeApp, provideFirebaseApp } from '@angular/fire/app';
import { getDatabase, provideDatabase } from '@angular/fire/database';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    SharedModule,
    HttpClientModule,
   /*  AngularFireModule.initializeApp(firebaseConfig), */
    provideFirebaseApp(() => initializeApp({"projectId":"chat-learnconnect","appId":"1:514219251457:web:463675d99119dcb99c6d00","databaseURL":"https://chat-learnconnect-default-rtdb.firebaseio.com","storageBucket":"chat-learnconnect.appspot.com","apiKey":"AIzaSyB1K-dXb5yf2efWeWi0NjwEic2nWLYBb-I","authDomain":"chat-learnconnect.firebaseapp.com","messagingSenderId":"514219251457"})),
    provideDatabase(() => getDatabase())

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
