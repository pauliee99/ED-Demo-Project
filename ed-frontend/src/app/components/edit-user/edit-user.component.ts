import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { User } from '@entities/User';
import { UserServiceService } from '@services/user-service.service';

@Component({
  selector: 'app-edit-user',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './edit-user.component.html',
  styleUrl: './edit-user.component.css'
})
export class EditUserComponent {
  user: User = {
    firstname: '',
    lastname: '',
    gender: 1,
    birthdate: '',
    workAddress: {
      street_name: '',
      street_num: 0,
      postal_code: 0,
    },
    homeAddress: {
      street_name: '',
      street_num: 0,
      postal_code: 0,
    },
  };

  constructor(private userService: UserServiceService) {}

  ngOnInit() {
    // this.userService.getUserById()
  }
  
  onSubmit() {
    this.userService.addUser(this.user).subscribe(response => {
      console.log("User created successfully!", response);
    });
  }
}
