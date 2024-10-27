import { Component, OnInit } from '@angular/core';
import { User } from '@entities/User';
import { UserServiceService } from '@services/user-service.service';

@Component({
  selector: 'app-user-list',
  standalone: true,
  imports: [],
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
