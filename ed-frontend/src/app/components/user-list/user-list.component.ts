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
    console.log(this.getUsers());
    this.users = [
      { id: 1, firstname: 'Airi', lastname: 'Satou', gender: 'F', birthdate: '2008/11/28', workAddress: 'Tokyo', homeAddress: 'Tokyo' },
      { id: 2, firstname: 'Tiger', lastname: 'Nixon', gender: 'M', birthdate: '2011/04/25', workAddress: 'Edinburgh', homeAddress: 'Edinburgh' }
    ];
  }
}
