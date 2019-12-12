import { TaskDetailsComponent } from '../task-details/task-details.component';
import { Observable } from 'rxjs';
import { TaskService } from '../task.service';
import { Task } from '../model/task';
import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {ChooseRecipeTask} from '../model/choose-recipe-task';

@Component({
  selector: 'app-task-list',
  templateUrl: './task-list.component.html',
  styleUrls: ['./task-list.component.css']
})
export class TaskListComponent implements OnInit {
  tasks: Observable<Task[]>;

  constructor(private taskService: TaskService, private router: Router) { }

  ngOnInit() {
    this.reloadData();
  }

  reloadData() {
    this.tasks = this.taskService.getTasksList(new ChooseRecipeTask());
  }

  taksDetails(id: string) {
    this.router.navigate(['update', id]);
  }

}
