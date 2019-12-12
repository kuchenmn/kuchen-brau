import { TaskDetailsComponent } from './task-details/task-details.component';
import { StartBeerComponent } from './start-beer/start-beer.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { TaskListComponent } from './task-list/task-list.component';
import { UpdateTaskComponent } from './update-task/update-task.component';

const routes: Routes = [
  { path: '', redirectTo: 'tasks', pathMatch: 'full' },
  { path: 'tasks', component: TaskListComponent },
  { path: 'start', component: StartBeerComponent },
  { path: 'update/:id', component: UpdateTaskComponent },
  { path: 'details/:id', component: TaskDetailsComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
