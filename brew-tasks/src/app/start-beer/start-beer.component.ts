import { Component, OnInit } from '@angular/core';
import { TaskService } from '../task.service';
import { Task } from '../model/task';
import { Router } from '@angular/router';

@Component({
  selector: 'app-start-beer',
  templateUrl: './start-beer.component.html',
  styleUrls: ['./start-beer.component.css']
})
export class StartBeerComponent implements OnInit {
  task: Task = new Task();
  submitted = false;

  constructor(private taskService: TaskService, private router: Router) {
  }

  ngOnInit() {
  }

}
