import { Component, OnInit } from '@angular/core';
import { Task } from '../model/task';
import { Recipe } from '../model/recipe';
import { TaskService } from '../task.service';
import { TaskListComponent } from '../task-list/task-list.component';
import { Router, ActivatedRoute } from '@angular/router';
import {UserId} from '../model/user-id';

@Component({
  selector: 'app-task-details',
  templateUrl: './task-details.component.html',
  styleUrls: ['./task-details.component.css']
})
export class TaskDetailsComponent implements OnInit {
  id: string;
  task: Task;
  recipe: Recipe;

  constructor(private route: ActivatedRoute, private router: Router, private taskService: TaskService) { }

  ngOnInit() {
    this.id = this.route.snapshot.params.id;
    this.taskService.claimTask(this.id, new UserId())
      .subscribe(data => {
        console.log(data);
        this.recipe = data;
        // tslint:disable-next-line:no-shadowed-variable
      }, error => console.log(error));
  }

  list() {
    this.router.navigate(['/tasks']);
  }

}
