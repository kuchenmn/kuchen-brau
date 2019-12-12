import { Component, OnInit } from '@angular/core';
import { Task } from '../model/task';
import { ActivatedRoute, Router } from '@angular/router';
import { TaskService } from '../task.service';
import {UserId} from '../model/user-id';
import {Recipe} from '../model/recipe';
import {RecipeName} from '../model/recipeName';
import {Lager} from '../model/lager';
import {AllGrain} from '../model/allGrain';
import {Variables} from '../model/variables';

@Component({
  selector: 'app-update-task',
  templateUrl: './update-task.component.html',
  styleUrls: ['./update-task.component.css']
})
export class UpdateTaskComponent implements OnInit {
  id: string;
  task: Task;
  recipe: Recipe;
  messageBody: Variables;
  recipeName: RecipeName;
  lager: Lager;
  allGrain: AllGrain;

  constructor(private route: ActivatedRoute, private router: Router, private taskService: TaskService) { }

  ngOnInit() {
    this.task = new Task();
    this.recipe = new Recipe();
    this.messageBody = new Variables();
    this.recipeName = new RecipeName();
    this.lager = new Lager();
    this.allGrain = new AllGrain();

    this.id = this.route.snapshot.params.id;
    this.taskService.claimTask(this.id, new UserId())
      .subscribe(data => {
        console.log(data);
        // tslint:disable-next-line:no-shadowed-variable
      }, error => console.log(error));
  }

  updateTask() {
    this.taskService.updateTask(this.id, this.messageBody)
    // tslint:disable-next-line:no-shadowed-variable
      .subscribe(data => console.log(data), error => console.log(error));
    this.task = new Task();
    this.goToList();
  }

  onSubmit() {
    this.recipe.allGrain = this.allGrain;
    this.recipe.lager = this.lager;
    this.recipe.recipeName = this.recipeName;
    this.messageBody.variables = this.recipe;
    this.updateTask();
  }

  goToList() {
    this.router.navigate(['/tasks']);
  }
}
