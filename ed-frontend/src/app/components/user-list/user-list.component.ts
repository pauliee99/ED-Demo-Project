import { Component, OnInit } from '@angular/core';
import { RouterLink, RouterLinkActive, RouterOutlet } from '@angular/router';
import { NgForOf } from '@angular/common'; 
import { User } from '@entities/User';
import { UserServiceService } from '@services/user-service.service';

@Component({
  selector: 'app-user-list',
  standalone: true,
  imports: [RouterLink, RouterLinkActive, RouterOutlet, NgForOf],
  templateUrl: './user-list.component.html',
  styleUrl: './user-list.component.css'
})
export class UserListComponent implements OnInit  {
  users: User[] = [];

  constructor(private userService: UserServiceService) { }

  getUsers(): void {
    this.userService.getUsers()
    .subscribe(users => this.users = users);
  }

  ngOnInit() {
    this.getUsers()
  }
}
