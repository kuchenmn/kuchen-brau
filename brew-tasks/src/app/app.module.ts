import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {HttpClient, HttpClientModule} from '@angular/common/http';
import { AppComponent } from './app.component';
import { StartBeerComponent } from './start-beer/start-beer.component';
import { TaskListComponent } from './task-list/task-list.component';
import { TaskDetailsComponent } from './task-details/task-details.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { UpdateTaskComponent } from './update-task/update-task.component';
import {FormsModule} from '@angular/forms';
// import {RouterModule} from '@angular/router';
import {AppRoutingModule} from './app.routing.module';

@NgModule({
  declarations: [
    AppComponent,
    StartBeerComponent,
    TaskListComponent,
    TaskDetailsComponent,
    UpdateTaskComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
