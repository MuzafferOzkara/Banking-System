import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { FormsModule, ReactiveFormsModule } from '@angular/forms'; 



import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { UserListComponent } from './user-list/user-list.component';
import { HttpClientModule } from '@angular/common/http';
import { LoginComponent } from './login/login.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { MatButtonModule, MatCheckboxModule, MatCardModule, MatProgressSpinnerModule, MatToolbarModule, MatInputModule, MatDialogModule, MatTableModule, MatMenuModule, MatIconModule } from '@angular/material';
import { CustomMaterialModule } from './core/material.module';
import { CommonModule } from '@angular/common';

import { MaterialModule } from './material';
import { RouterModule } from '@angular/router';


@NgModule({
  declarations: [
    AppComponent,
    UserListComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,    
    FormsModule,  
    ReactiveFormsModule,  
    HttpClientModule,  
    ReactiveFormsModule.withConfig({warnOnNgModelWithFormControl: 'always'}), BrowserAnimationsModule,



    
    MaterialModule,
    FormsModule,
    RouterModule,
    ReactiveFormsModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    HttpClientModule,
    
   
    
    BrowserAnimationsModule,
    MatButtonModule, 
    MatCheckboxModule,
    MatCardModule,
    MatProgressSpinnerModule,  
    CustomMaterialModule,
    CommonModule, 
    MatToolbarModule,
    MatButtonModule, 
    MatCardModule,
    MatInputModule,
    MatDialogModule,
    MatTableModule,
    MatMenuModule,
    MatIconModule,
    MatProgressSpinnerModule





  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
